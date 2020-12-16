
package javaProject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
/**
 * @author AkashdeepSingh-470 JarmanSinghBatth503 ganeshganji-996 Amanurrahmankhan-551
 *
 */

public class functions 
{
		JFrame f = new JFrame();
        float damt=0.0f,wamt=0.0f,bal=0.0f;
        double RATE = 0.035;
        String data;

        char fbal[]=new char[20];
        char user[]=new char[20];
        char account[]=new char[20];
        int l=0;

        public void deposit(String nmpass)
        {
            String oldFileName = "userdetails.txt";
            String tmpFileName = "out.txt";
            BufferedReader ins=null;
            BufferedWriter outs=null;

            try
            {

                ins=new BufferedReader(new FileReader(oldFileName));
                outs=new BufferedWriter(new FileWriter(tmpFileName));
                
                BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
                while((data=ins.readLine())!=null)
                {

                    if(data.contains(nmpass))
                    {
                        l=data.length();
                        System.out.println(l);
                        
                        data.getChars(38,l-2,fbal,0);
                        String b=String.valueOf(fbal).trim();
                        System.out.println(b);
                        System.out.println(data);                      

                        bal=Float.parseFloat(b);
                        
                        System.out.println(bal);

                        data.getChars(0,6,user,0);
                        String u=String.valueOf(user).trim();
                        data.getChars(13,19,account,0);
                        String ac=String.valueOf(account).trim();

                        try
                        {
                        	
                        	String dm= JOptionPane.showInputDialog(f,"Please Enter Your Amount :","Deposit Amount", JOptionPane.ERROR_MESSAGE);
                            //String dm=scan.next();
                            damt=Float.parseFloat(dm);

                            if(damt<100.0f)
                            {
                                
                                JOptionPane.showMessageDialog(f,"\nAmount Should be greater than or equals to Rs. 100...","Deposit Error", JOptionPane.ERROR_MESSAGE);
                                
                            }
                            else
                            {
                                bal=bal+damt;
                                System.out.println(bal+ " " +damt);
                                JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully..."+"\nTotal Balance : "+bal,"Deposit Transaction Completed", JOptionPane.ERROR_MESSAGE);
                                
                                //String bal1 = Float.toString(bal).trim();
                                //System.out.println("only bal1 "+bal1);
                                int a =(int)bal;
                                String c=String.valueOf(a);
                                
                                System.out.println("only c "+c);
                                
                                data=data.replace(b,c);
                                
                                System.out.println("new deposit "+data);
                                
                                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                                String date = sdf.format(new Date());
                                
               /*statement.tx*/ bw.write(u+" "+ac+"   "+damt+"  deposit"+"    "+bal+"   "+date);
                                bw.newLine();
                                bw.close();
                                
                            }
                        }
                        catch(NumberFormatException ioe)
                        {
                            JOptionPane.showMessageDialog(f,"\n You Have Entered Wrong Input.","Deposit Error", JOptionPane.ERROR_MESSAGE);
                            
                        }

                    }

                    outs.write(data);//out.txt tempfile
                    outs.newLine();
                    
                }
            }
            catch(InputMismatchException e)
            {
            	JOptionPane.showMessageDialog(f,"\n You Have Entered Wrong Input.","Deposit Error", JOptionPane.ERROR_MESSAGE);
                
            }
            catch (Exception e)
            {
                return;
            }
            finally
            {
                try
                {
                    if(ins != null)//reading userdetails.txt
                        ins.close();
                }
                catch (IOException e)
                {
                    //
                }
                try
                {
                    if(outs != null)
                        outs.close();
                }
                catch (IOException e)
                {
                	
                }
            }

            File oldFile = new File(oldFileName);
            oldFile.delete();
            System.out.println("printing "+oldFile);
            
            File newFile = new File(tmpFileName);
            newFile.renameTo(oldFile);
            System.out.println("printing2 "+newFile);
        }

        public void withdraw(String nmpass)
        {
            String oldFileName = "userdetails.txt";
            String tmpFileName = "out.txt";
            BufferedReader ins=null;
            BufferedWriter outs=null;
            try
            {
                ins=new BufferedReader(new FileReader(oldFileName));
                outs=new BufferedWriter(new FileWriter(tmpFileName));

                BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
                while((data=ins.readLine())!=null)
                {
                    if(data.contains(nmpass))
                    {
                        l=data.length();
                        System.out.println(l);
                        
                        data.getChars(38,l-2,fbal,0);
                        String b=String.valueOf(fbal).trim();
                        bal=Float.parseFloat(b);
                        
                        System.out.println(b);
                        System.out.println(bal);
                        System.out.println(data);

                        data.getChars(0,6,user,0);
                        String u=String.valueOf(user).trim();
                        data.getChars(14,20,account,0);
                        String ac=String.valueOf(account).trim();

                        try
                        {
                        	String wt=JOptionPane.showInputDialog(f,"Enter your Withdrawal Amount :","Withdraw Amount", JOptionPane.INFORMATION_MESSAGE);
                            //String wt=scan.next();
                            wamt=Float.parseFloat(wt);
                            float less=bal-wamt;
                            System.out.println(less);

                            if(wamt<100.0f)
                            {
                                JOptionPane.showMessageDialog(f,"\n Withrawal Should be greater than or equals to Rs.100..."," Withdraw Error", JOptionPane.ERROR_MESSAGE);
                                
                            }
                            else if(less<1000.0f)
                            {
                                JOptionPane.showMessageDialog(f,"\nInsufficient Balance..."," Withdraw Error", JOptionPane.ERROR_MESSAGE);
                                
                            }
                            else
                            {
                                bal=bal-wamt;
                                JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully..."," Withdraw Transaction Completed", JOptionPane.INFORMATION_MESSAGE);
                                int a =(int)bal;
                                String c=String.valueOf(a);
                                //String c=String.valueOf(bal);

                                data=data.replace(b,c);

                                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                                String date = sdf.format(new Date());

                                bw.write(u+" "+ac+"   "+wamt+"  withdraw"+"   "+bal+"   "+date);

                                bw.newLine();
                                bw.close();
                            }

                        }
                        catch(NumberFormatException eoi)
                        {
                            JOptionPane.showMessageDialog(f,"\n You Have Entered Wrong Input.","Withdraw Error", JOptionPane.ERROR_MESSAGE);                           
                        }

                    }

                    outs.write(data);
                    outs.newLine();
                }
            }
            catch(InputMismatchException e)
            {
                JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input..."," Withdraw Error", JOptionPane.ERROR_MESSAGE);
                
            }
            catch(Exception e){}
            finally
            {
                try
                {
                    if(ins != null)
                        ins.close();
                }
                catch (IOException e)
                {
                    //
                }
                try
                {
                    if(outs != null)
                        outs.close();
                }
                catch (IOException e)
                {
                    //
                }
            }

            File oldFile = new File(oldFileName);
            oldFile.delete();

            File newFile = new File(tmpFileName);
            newFile.renameTo(oldFile);
        }

        /**********************************************************************/

        public void inquiry(String nmpass)
        {
            try
            {
                BufferedReader ins=new BufferedReader(new FileReader("userdetails.txt"));
                while((data=ins.readLine())!=null)
                {
                    if(data.contains(nmpass))
                    {
                        l=data.length();
                        data.getChars(38,l-2,fbal,0);
                        String b=String.valueOf(fbal).trim();
                        bal=Float.parseFloat(b);
                        JOptionPane.showMessageDialog(f,"\nTotal Balance : "+bal,"Total Balance", JOptionPane.INFORMATION_MESSAGE);
                       
                        break;
                    }
                }
                ins.close();
            }
            catch(Exception e){}

        }

        /*********************************************************************/

        public void statement(String nmacnt)
        {
        	System.out.println(nmacnt);
        	//ArrayList<String> Display = new ArrayList<>();
        	String Display = "";

            try
            {
                BufferedReader ins=new BufferedReader(new FileReader("statement.txt"));
                while((data=ins.readLine())!=null)
                {

                    if(data.contains(nmacnt))
                    {
                    	//Display.add(data+"\n");
                    	Display += data+"\n";
                        System.out.println(data);
                    }
                }
                JOptionPane.showMessageDialog(f, Display,"Transaction Details", JOptionPane.INFORMATION_MESSAGE);
                
                ins.close();
            }
            catch(Exception e){}
        }

        
    public void depositto(String nmpass, float damt)
    {
    	char fbal1[]=new char[20];
        String oldFileName = "userdetails.txt";
        String tmpFileName = "out.txt";
        BufferedReader ins=null;
        BufferedWriter outs=null;
        System.out.println("user passed "+nmpass);
        System.out.println("Amount passed "+damt);

        try
        {

            ins=new BufferedReader(new FileReader(oldFileName));
            outs=new BufferedWriter(new FileWriter(tmpFileName));

            BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
            while((data=ins.readLine())!=null)
            {

                if(data.contains(nmpass))
                {
                	l=data.length();
                    System.out.println(l);
                    
                    data.getChars(38,l-2,fbal1,0);
                    String b=String.valueOf(fbal1).trim();
                    bal=Float.parseFloat(b);
                    
                    System.out.println(b);
                    System.out.println(bal);
                    System.out.println(data);

                    data.getChars(0,6,user,0);
                    String u=String.valueOf(user).trim();
                    data.getChars(14,20,account,0);
                    String ac=String.valueOf(account).trim();

                    try
                    {
                            bal=bal+damt;
                            System.out.println("after deposit bal = "+bal);
                            
                            JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully...",
                            "Transfer Money",JOptionPane.INFORMATION_MESSAGE);
                            
                            int a = (int)bal;
                            String c=String.valueOf(a);
                            System.out.println("int c = "+c);
                            data=data.replace(b,c);

                            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                            String date = sdf.format(new Date());

                            bw.write(u+" "+ac+"   "+damt+"  deposit"+"    "+bal+"   "+date);
                            bw.newLine();
                            bw.close();

                    }
                    catch(NumberFormatException ioe)
                    {
                        JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...",
                        "Transfer Money",JOptionPane.INFORMATION_MESSAGE);
                    }

                }

                outs.write(data);
                outs.newLine();

            }
        }
        catch(InputMismatchException e)
        {
            JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...",
            "Transfer Money",JOptionPane.INFORMATION_MESSAGE);
        }
        catch (Exception e)
        {
            return;
        }
        finally
        {
            try
            {
                if(ins != null)
                    ins.close();
            }
            catch (IOException e)
            {
                //
            }
            try
            {
                if(outs != null)
                    outs.close();
            }
            catch (IOException e)
            {
                //
            }
        }

        File oldFile = new File(oldFileName);
        oldFile.delete();

        File newFile = new File(tmpFileName);
        newFile.renameTo(oldFile);
}

    /***************************************************************/

    public void withdrawfrom(String nmpass,float wamt)
    {
        String oldFileName = "userdetails.txt";
        String tmpFileName = "out.txt";
        BufferedReader ins=null;
        BufferedWriter outs=null;
        try
        {
            ins=new BufferedReader(new FileReader(oldFileName));
            outs=new BufferedWriter(new FileWriter(tmpFileName));

            BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
            while((data=ins.readLine())!=null)
            {
                if(data.contains(nmpass))
                {
                    l=data.length();
                    data.getChars(38,l-2,fbal,0);
                    String b=String.valueOf(fbal).trim();

                    bal=Float.parseFloat(b);

                    data.getChars(0,6,user,0);
                    String u=String.valueOf(user).trim();
                    data.getChars(13,19,account,0);
                    String ac=String.valueOf(account).trim();

                    try
                    {
                        float less=bal-wamt;

                      if(less<1000.0f)
                        {
                            JOptionPane.showMessageDialog(f,"\nInsufficient Balance...");
                            }
                        else
                        {
                            bal=bal-wamt;
                            JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully...");
                            JOptionPane.showMessageDialog(f,"\nTotal Balance : "+bal);
                            int a =(int)bal;
                            String c=String.valueOf(a);

                            data=data.replace(b,c);

                            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                            String date = sdf.format(new Date());
                           
                            bw.write(u+" "+ac+"   "+wamt+"  withdraw"+"   "+bal+"   "+date);
                            bw.newLine();
                            bw.close();
                        }

                    }
                    catch(NumberFormatException eoi)
                    {
                        JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");

                    }

                }

                outs.write(data);
                outs.newLine();
            }
        }
        catch(InputMismatchException e)
        {
            JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");
        }
        catch(Exception e){}
        finally
        {
            try
            {
                if(ins != null)
                    ins.close();
            }
            catch (IOException e)
            {
                //
            }
            try
            {
                if(outs != null)
                    outs.close();
            }
            catch (IOException e)
            {
                //
            }
        }

        File oldFile = new File(oldFileName);
        oldFile.delete();

        File newFile = new File(tmpFileName);
        newFile.renameTo(oldFile);
    }

    public void loandetails(double principal, int year) {
        RATE = (RATE / 100) / 12;
        year = year * 12;
        double p = (principal * RATE) / (1 - Math.pow(1 + RATE, -year));
        //
        JOptionPane.showMessageDialog(f,"EMI : " + p);
    } 

public void ElectricityBill1(int Units,String nmpass) {

    float Amount, Sur_Charge, Total_Amount;

    if (Units < 50) {
        Amount = (float) (Units * 2.60);
        Sur_Charge = 25;
    } else if (Units <= 100) {
        // For the First Fifty Units Charge = 130 (50 * 2.60)
        // Next, we are removing those 50 units from total units
        Amount = (float) (130 + ((Units - 50) * 3.25));
        Sur_Charge = 35;
    } else if (Units <= 200) {
        // First Fifty Units charge = 130, and 50 - 100 is 162.50 (50 * 3.25)
        // Next, we are removing those 100 units from total units
        Amount = (float) (130 + 162.50 + ((Units - 100) * 5.26));
        Sur_Charge = 45;
    } else {
  		/* First Fifty Units = 130, 50 - 100 is 162.50,
  		 and 100 - 200 is 526 (100 * 5.65)
  		Next, we are removing those 200 units from total units */
        Amount = (float) (130 + 162.50 + 526 + ((Units - 200) * 7.75));
        Sur_Charge = 55;
    }

    Total_Amount = Amount + Sur_Charge;
    
    JOptionPane.showMessageDialog(f,"\n Electricity Bill  =  " + Total_Amount,
    "Electricity Bill Payment",JOptionPane.INFORMATION_MESSAGE);
    
    String oldFileName = "userdetails.txt";
    String tmpFileName = "out.txt";
    BufferedReader ins=null;
    BufferedWriter outs=null;
    try
    {
        ins=new BufferedReader(new FileReader(oldFileName));
        outs=new BufferedWriter(new FileWriter(tmpFileName));

        BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
        while((data=ins.readLine())!=null)
        {
            if(data.contains(nmpass))
            {
                l=data.length();
                data.getChars(38,l-2,fbal,0);
                String b=String.valueOf(fbal).trim();

                bal=Float.parseFloat(b);

                data.getChars(0,6,user,0);
                String u=String.valueOf(user).trim();
                data.getChars(13,19,account,0);
                String ac=String.valueOf(account).trim();

                try
                {
                    System.out.println(Total_Amount);

                    float less=bal-Total_Amount;

               if(bal<less)
                    {
                        JOptionPane.showMessageDialog(f,"\nInsufficient Balance...",
                        "Electricity Bill Payment",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        bal=bal-Total_Amount;
                        JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully...",
                        "Electricity Bill Payment",JOptionPane.INFORMATION_MESSAGE);
                        
                        JOptionPane.showMessageDialog(f,"\nTotal Balance : "+bal,
                        "Electricity Bill Payment",JOptionPane.INFORMATION_MESSAGE);
                        
                        String c=String.valueOf(bal);

                        data=data.replace(b,c);

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                        String date = sdf.format(new Date());

                        bw.write(u+" "+ac+"   "+wamt+"  withdraw"+"   "+bal+"   "+date);

                        bw.newLine();
                        bw.close();
                    }

                }
                catch(NumberFormatException eoi)
                {
                    JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");

                }

            }

            outs.write(data);
            outs.newLine();
        }
    }
    catch(InputMismatchException e)
    {
        JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");
    }
    catch(Exception e){}
    finally
    {
        try
        {
            if(ins != null)
                ins.close();
        }
        catch (IOException e)
        {
            //
        }
        try
        {
            if(outs != null)
                outs.close();
        }
        catch (IOException e)
        {
            //
        }
    }

    File oldFile = new File(oldFileName);
    oldFile.delete();


    File newFile = new File(tmpFileName);
    newFile.renameTo(oldFile);

}

public void internetBill(double dataconsumed,String nmpass) {
    final double DATACOST = 10;
    final double DISCOUNT = 0.10;
    double totalcost, totalDiscount, finalTotalForDis;

    totalcost = dataconsumed * DATACOST;

    totalDiscount = totalcost * DISCOUNT;
    finalTotalForDis = totalcost - totalDiscount;

    if (totalcost >= 15) 
    {
        JOptionPane.showMessageDialog(f,"Your discount is " + totalDiscount
        +"\nYou Bill Total is " + finalTotalForDis,
        "Internet Bill Payment",JOptionPane.INFORMATION_MESSAGE);
    }
    else 
    {
        JOptionPane.showMessageDialog(f,"You are not entitled to discount this time."
        +"\nYour Bill Total is " + totalcost,
        "Internet Bill Payment",JOptionPane.INFORMATION_MESSAGE);
    }

    String oldFileName = "userdetails.txt";
    String tmpFileName = "out.txt";
    BufferedReader ins=null;
    BufferedWriter outs=null;
    try
    {
        ins=new BufferedReader(new FileReader(oldFileName));
        outs=new BufferedWriter(new FileWriter(tmpFileName));

        BufferedWriter bw=new BufferedWriter(new FileWriter("statement.txt",true));
        while((data=ins.readLine())!=null)
        {
            if(data.contains(nmpass))
            {
                l=data.length();
                data.getChars(38,l-2,fbal,0);
                String b=String.valueOf(fbal).trim();

                bal=Float.parseFloat(b);

                data.getChars(0,6,user,0);
                String u=String.valueOf(user).trim();
                data.getChars(13,19,account,0);
                String ac=String.valueOf(account).trim();

                try
                {
                    System.out.println(totalcost);

                    float less= (float) (bal-totalcost);

                    if(bal<less)
                    {
                        JOptionPane.showMessageDialog(f,"\nInsufficient Balance...",
                        "Internet Bill Payment",JOptionPane.INFORMATION_MESSAGE);
                    }
                    else
                    {
                        bal= (float) (bal-totalcost);
                        JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully..."+"\nTotal Balance : "+bal,
                        "Internet Bill Payment",JOptionPane.INFORMATION_MESSAGE);
                        String c=String.valueOf(bal);

                        data=data.replace(b,c);

                        SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                        String date = sdf.format(new Date());

                        bw.write(u+" "+ac+"   "+wamt+"  withdraw"+"   "+bal+"   "+date);

                        bw.newLine();
                        bw.close();
                    }

                }
                catch(NumberFormatException eoi)
                {
                    JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...",
                    "Internet Bill Payment",JOptionPane.INFORMATION_MESSAGE);

                }

            }

            outs.write(data);
            outs.newLine();
        }
    }
    catch(InputMismatchException e)
    {
        JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...",
        "Internet Bill Payment",JOptionPane.INFORMATION_MESSAGE);
    }
    catch(Exception e){}
    finally
    {
        try
        {
            if(ins != null)
                ins.close();
        }
        catch (IOException e)
        {
            
        }
        try
        {
            if(outs != null)
                outs.close();
        }
        catch (IOException e)
        {
        	
        }
    }

    File oldFile = new File(oldFileName);
    oldFile.delete();


    File newFile = new File(tmpFileName);
    newFile.renameTo(oldFile);
}
}

