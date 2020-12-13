
package javaProject;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class functions {
    /*
     * To change this license header, choose License Headers in Project Properties.
     * To change this template file, choose Tools | Templates
     * and open the template in the editor.
     */
	JFrame f = new JFrame();
        float damt=0.0f,wamt=0.0f,bal=0.0f;
   double RATE = 0.035;
        String data;

        char fbal[]=new char[20];
        char user[]=new char[20];
        char account[]=new char[20];
        int l=0;
        Scanner scan=new Scanner(System.in);

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
                        data.getChars(40,l-1,fbal,0);
                        String b=String.valueOf(fbal).trim();

                        bal=Float.parseFloat(b);

                        data.getChars(0,6,user,0);
                        String u=String.valueOf(user).trim();
                        data.getChars(12,18,account,0);
                        String ac=String.valueOf(account).trim();

                        try
                        {
                        	
                            JOptionPane.showInputDialog(f,"Please Enter Your Amount :");
                            String dm=scan.next();
                            damt=Float.parseFloat(dm);

                            if(damt<100.0f)
                            {
                                //JOptionPane.showMessageDialog(f,"\nAmount Should be greater than or equals to Rs. 100...");
                                JOptionPane.showMessageDialog(f,"\nAmount Should be greater than or equals to Rs. 100...");
                                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
                            }
                            else
                            {
                                bal=bal+damt;
                                JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully...");
                                JOptionPane.showMessageDialog(f,"\nTotal Balance : "+bal);
                                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");

                                String c=String.valueOf(bal);
                                data=data.replace(b,c);

                                SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                                String date = sdf.format(new Date());

                                bw.write(u+" "+ac+"   "+damt+"  deposit"+"    "+bal+"   "+date);
                                bw.newLine();
                                bw.close();
                            }
                        }
                        catch(NumberFormatException ioe)
                        {
                            JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");
                            JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
                        }

                    }

                    outs.write(data);
                    outs.newLine();

                }
            }
            catch(InputMismatchException e)
            {
                JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");
                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
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
                        data.getChars(40,l-1,fbal,0);
                        String b=String.valueOf(fbal).trim();

                        bal=Float.parseFloat(b);

                        data.getChars(0,6,user,0);
                        String u=String.valueOf(user).trim();
                        data.getChars(12,18,account,0);
                        String ac=String.valueOf(account).trim();

                        try
                        {
                            JOptionPane.showInputDialog(f,"Enter your Withdrawal Amount :");
                            String wt=scan.next();
                            wamt=Float.parseFloat(wt);
                            float less=bal-wamt;

                            if(wamt<100.0f)
                            {
                                JOptionPane.showMessageDialog(f,"\nWithrawal Should be greater than or equals to Rs.100...");
                                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
                            }
                            else if(less<1000.0f)
                            {
                                JOptionPane.showMessageDialog(f,"\nInsufficient Balance...");
                                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
                            }
                            else
                            {
                                bal=bal-wamt;
                                JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully...");
                                JOptionPane.showMessageDialog(f,"\nTotal Balance : "+bal);
                                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
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
                            JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");

                        }

                    }

                    outs.write(data);
                    outs.newLine();
                }
            }
            catch(InputMismatchException e)
            {
                JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");
                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
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
                        data.getChars(40,l-1,fbal,0);
                        String b=String.valueOf(fbal).trim();
                        bal=Float.parseFloat(b);
                        JOptionPane.showMessageDialog(f,"\nTotal Balance : "+bal);
                        JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
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

            try
            {
                BufferedReader ins=new BufferedReader(new FileReader("statement.txt"));
                JOptionPane.showMessageDialog(f,"User |"+" A/c No. |"+" Transactions |"+" Total Bal. "+"|  Date & Time ");
                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
                System.out.println();
                while((data=ins.readLine())!=null)
                {

                    if(data.contains(nmacnt))
                    {
                        System.out.println(data);

                    }
                }
                JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
                ins.close();
            }
            catch(Exception e){}
        }

    public void depositto(String nmpass, float damt)
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
                    data.getChars(40,l-1,fbal,0);
                    String b=String.valueOf(fbal).trim();

                    bal=Float.parseFloat(b);

                    data.getChars(0,6,user,0);
                    String u=String.valueOf(user).trim();
                    data.getChars(12,18,account,0);
                    String ac=String.valueOf(account).trim();

                    try
                    {


                            bal=bal+damt;
                            JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully...");

                            JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");

                            String c=String.valueOf(bal);
                            data=data.replace(b,c);

                            SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy hh:mm:ss");
                            String date = sdf.format(new Date());

                            bw.write(u+" "+ac+"   "+damt+"  deposit"+"    "+bal+"   "+date);
                            bw.newLine();
                            bw.close();

                    }
                    catch(NumberFormatException ioe)
                    {
                        JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");
                        JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
                    }

                }

                outs.write(data);
                outs.newLine();

            }
        }
        catch(InputMismatchException e)
        {
            JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");
            JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
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
                    data.getChars(40,l-1,fbal,0);
                    String b=String.valueOf(fbal).trim();

                    bal=Float.parseFloat(b);

                    data.getChars(0,6,user,0);
                    String u=String.valueOf(user).trim();
                    data.getChars(12,18,account,0);
                    String ac=String.valueOf(account).trim();

                    try
                    {

                        float less=bal-wamt;


                      if(less<1000.0f)
                        {
                            JOptionPane.showMessageDialog(f,"\nInsufficient Balance...");
                            JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
                        }
                        else
                        {
                            bal=bal-wamt;
                            JOptionPane.showMessageDialog(f,"\nTransaction Completed Successfully...");
                            JOptionPane.showMessageDialog(f,"\nTotal Balance : "+bal);
                            JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
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
                        JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");

                    }

                }

                outs.write(data);
                outs.newLine();
            }
        }
        catch(InputMismatchException e)
        {
            JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...");
            JOptionPane.showMessageDialog(f,"-------------------------------------------------------------");
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
    
}

//Amanurrahmankhan551


