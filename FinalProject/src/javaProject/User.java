/**
 * 
 */
package javaProject;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author AkashdeepSingh-470 JarmanSinghBatth503 ganeshganji-996 Amanurrahmankhan-551
 *
 */
public class User extends functions 
{
	public void NewUser()
	{   
		String inputDialog3;
		inputDialog3 = JOptionPane.showInputDialog(f,"Enter the number of Accounts you want to Create: ","Create User",JOptionPane.INFORMATION_MESSAGE);
		
		int namenumber=Integer.parseInt(inputDialog3);
		
		System.out.println(namenumber);
		
		ArrayList<String> name = new ArrayList<>(namenumber);
		ArrayList<Integer> contact = new ArrayList<>(namenumber);
		ArrayList<Double> amnt= new ArrayList<>(namenumber);
		
		for(int i=0;i<namenumber;i++) 
		{
		int c=0;
		JOptionPane.showMessageDialog(f, "Enter your details","Create User",JOptionPane.INFORMATION_MESSAGE);
		try 
		{
		PrintWriter outs = new PrintWriter(new FileWriter("userdetails.txt", true));
        BufferedWriter bw = new BufferedWriter(new FileWriter("statement.txt", true));
        String name1;
        String contact1;
        String line;
        String lread;
        String amnt1;
        String ac;
        String actype;
        JFrame f = new JFrame();
        /*************************************************/
        do
        {	
        c=0;
        name1= JOptionPane.showInputDialog(f,"Enter your name","Create User - Name Details",JOptionPane.OK_OPTION);
        name.add(i,name1);

        if (name.get(i).length() < 2) 
        {
        	JOptionPane.showMessageDialog(f,"Name Should be greater than 2 - Characters",
        	"Create User - Name Details",JOptionPane.ERROR_MESSAGE);
            c++;
        } 
        else if (name.get(i).matches(".*?[\\p{Punct}&&[^_]].*") || name.get(i).matches("[a-zA-Z ]*\\d+.*")) 
        {
        	JOptionPane.showMessageDialog(f,"Enter a Valid Name",
        	"Create User - Name Details",JOptionPane.ERROR_MESSAGE);
            
            c++;
        }
		}
        while (c == 1);

        /*************************************************/
        do
        {
        	c=0;
        	contact1= JOptionPane.showInputDialog(f,"Enter your contact number","Create User - Contact Details",JOptionPane.OK_OPTION);	
        	double contactnumber=Double.parseDouble(contact1);
        	
            int contactnumber1=(int)contactnumber;
            contact.add(i, contactnumber1);
            
            BufferedReader br = new BufferedReader(new FileReader("userdetails.txt"));
            
            if (contact1.equals("(.*)[a-zA-Z]+(.*)") || contact.equals(".*?[\\p{Punct}&&[^_]].*"))
            {
            	c++;
                JOptionPane.showMessageDialog(f,"Enter a Valid Contact Number.",
            	"Create User - Contact Details",JOptionPane.ERROR_MESSAGE);  
            } 
           else if (contact1.length() != 10) 
            {
                c++;
                JOptionPane.showMessageDialog(f,"Contact Number Should be of 10-Digits.",
            	"Create User - Contact Details",JOptionPane.ERROR_MESSAGE);       
            }
        else 
        {
        	
            while ((lread = br.readLine()) != null) 
            {
                c = 0;
                if (lread.contains(contact1 + " "))
                {
                    c++;
                    JOptionPane.showMessageDialog(f,"Contact Number Already Exists.",
                	"Create User",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
        
        }
        while (c == 1);      
        
        do
        {
        	c = 0;
        	amnt1= JOptionPane.showInputDialog("Enter the amount",JOptionPane.OK_CANCEL_OPTION);	
            double amount=Integer.parseInt(amnt1);
            amnt.add(i, amount);
            
            if (amnt.equals("(.*)[a-zA-Z]+(.*)") || amnt.equals(".*?[\\p{Punct}&&[^_]].*")) 
            {
                c++;
                JOptionPane.showMessageDialog(f,"Only Numbers!!",
            	"Enter a Valid Amount.",JOptionPane.ERROR_MESSAGE);
              
            } 
            else 
            {
                if (amnt.get(i)< 100)
                {
                	JOptionPane.showMessageDialog(f,"Initial Amount Should be greater than or equals to Rs.100.",
                	"Enter a Valid Amount.",JOptionPane.ERROR_MESSAGE);                   
                    c++;
                }
            }
	
        }while (c == 1);
      
		do
        {
        	
        	ac= JOptionPane.showInputDialog("Enter Your Account type (Saving or Current) :"
        			+ "",JOptionPane.OK_CANCEL_OPTION);
            actype = ac.toLowerCase();
            if (!(actype.equals("saving") || actype.equals("current")))
            {            	
            	JOptionPane.showMessageDialog(f,
            		    "Account Type Should be saving or current"
            			+"",
            		    "Enter a Valid Account type.",JOptionPane.ERROR_MESSAGE);                
            }

		}while(!(actype.equals("saving") || actype.equals("current")));
		
        if (actype.equals("saving"))
        {
            actype = "saving";
        }
        
        /*************************************************/
        Random rnd = new Random();

        char nm[]=new char[6];       
        String username;    
        name.get(i).getChars(0,3,nm,0);
        username = String.valueOf(nm).trim();
        if (username.length() < 2) 
        {
            username = username + (10000 + rnd.nextInt(90000));
        } 
        else if (username.length() < 3) 
        {
            username = username + (1000 + rnd.nextInt(9000));
        } 
        else 
        {
            username = username + (100 + rnd.nextInt(900));
        }
        if (username.contains(" ")) 
        {
            username = username.replace(" ", "a");
        }
          
        char ps[]=new char[6];
        String password;
        name.get(i).getChars(3,7,ps,0);
        password = String.valueOf(nm).trim();
        if (password.length() < 3) {
            password = password + (10000 + rnd.nextInt(90000));
        } else if (password.length() < 3) {
            password = password + (1000 + rnd.nextInt(9000));
        } else {
            password = password+ (100 + rnd.nextInt(900));
        }
        if (password.contains(" ")) {
            password = password.replace(" ", "a");
        }

        int acnt;
        do {
            acnt = 10000 + rnd.nextInt(90000);
            c = 0;
            BufferedReader br = new BufferedReader(new FileReader("userdetails.txt"));
            while ((lread = br.readLine()) != null)
            {
                if (lread.contains(acnt + " "))
                {
                    c++;
                    break;
                }
            }
            br.close();
        } 
        while (c == 1);
        
        JOptionPane.showMessageDialog(f,"Account Created Successfully." +"\nUsername: " +username
        +"\nPassword: " +password+"\nAccount number: "+acnt +"\nAmount :" + amnt.get(i),
        "Account Number currently Logged In: "+acnt, JOptionPane.INFORMATION_MESSAGE);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        String date = sdf.format(new Date());

        /*************************************************/
        
        bw.write(username + " " + acnt + " " + amnt.get(i) + " initial" + " " + amnt.get(i) + " " + date); 
      //statement.txt
        bw.newLine();
        
        bw.close();
        
        outs.println(username + " " + password + " " + acnt + " " + actype + " " + contact.get(i) + " " + amnt.get(i)); //userdetails.txt
      //userdetails.txt
        outs.close();
        
        
        BufferedWriter wr = new BufferedWriter(new FileWriter("name.txt", true));
        wr.write("Username:-  "+ username + " Password:- " + password + " Account Holders name " + name.get(i));
        wr.newLine();
        wr.close();

        JOptionPane.showMessageDialog(f,"\nThank You For Banking...",
            	"Thank you for Visiting",JOptionPane.INFORMATION_MESSAGE);

    } 
		catch (InputMismatchException e) 
		{
    	JOptionPane.showMessageDialog(f,"\nOops !!! You Have Entered Wrong Input...",
    	"Incorrect User Choice",JOptionPane.INFORMATION_MESSAGE);
    } 
		catch (Exception a) 
		{
    }

}
}

char account[]=new char[6];
public void ExistingUser()
{
	JFrame f = new JFrame();

    int count=0;
    String name=null,pass=null,amt=null,cont=null,actyp=null;
  
    String uname = JOptionPane.showInputDialog(f,"Enter your Username","Enter your details to login",JOptionPane.OK_CANCEL_OPTION);
  
    String upass = JOptionPane.showInputDialog(f,"Enter your Password","Enter your details to login",JOptionPane.OK_CANCEL_OPTION);

    String userpass=uname+" "+upass+" ";
    char cnt=' ';
    int choice;
    String line,line2,fullname;
    char full[]=new char[100];
    //ArrayList<String> full = new ArrayList<String>(100);
    try
    {
        BufferedReader ins=new BufferedReader(new FileReader("userdetails.txt"));

        while((line=ins.readLine())!=null)
        {

            if(line.contains(userpass))
            {
            	JOptionPane.showMessageDialog(f,"Logged In Successfully !.",
            	"User: " +uname,JOptionPane.INFORMATION_MESSAGE);
                
                BufferedReader nmf=new BufferedReader(new FileReader("name.txt"));

                while((line2=nmf.readLine())!=null)
                {

                    if(line2.contains(userpass))
                    {
                        line2.getChars(13,line2.length(),full,0);
                        fullname=String.valueOf(full).trim();
                        
                        JOptionPane.showMessageDialog(f,"Welcome :" + fullname,
                        "Account details ",JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                nmf.close();

                line.getChars(13,19,account,0);
                String ac=String.valueOf(account).trim();
                String userac=uname+" "+ac;
                User u=new User();
                do
                {	                	
                	String s = JOptionPane.showInputDialog(f,"Please Enter your choice "
            				+"\n1.Deposit"
            				+"\n2.Withdraw"
            				+"\n3.Transfer Money"
            				+"\n4.Pay Utilities"
            				+"\n5.Balance Inquiry"
            				+"\n6.Loan Details"
            				+"\n7.Mini Statement",
            				"Utilities",JOptionPane.INFORMATION_MESSAGE);
                	
                    switch(s) 
                    {
                        case "1":
                            ins.close();
                            u.deposit(userpass);
                            break;
                        case "2":
                            ins.close();
                            u.withdraw(userpass);
                            break;
                        case "3":
                            ins.close();
                            String acc1,acc2,a1;
                           
                            //acc1= JOptionPane.showInputDialog(f,"Enter the Account number to transfer from: ","Transfer Money",JOptionPane.OK_CANCEL_OPTION);
                            acc2= JOptionPane.showInputDialog(f,"Enter the Account number to transfer to: ","Transfer Money",JOptionPane.OK_CANCEL_OPTION);
                            
                            a1= JOptionPane.showInputDialog(f,"Enter the amount you want to transfer: ","Transfer Money",JOptionPane.OK_CANCEL_OPTION);
                            Float a=Float.parseFloat(a1);
                            withdrawfrom(userpass, a);
                            depositto(acc2, a);
                            break;
                        case "4":
                            int options;
                            do 
                            {
                            	String s1 = JOptionPane.showInputDialog(f,"Please Enter your choice "
                        				+"\n1.Electricity Bill"
                        				+"\n2.Internet Bill"
                        				+"\n3.Exit"
                        				,"Utility Bill Payment",JOptionPane.QUESTION_MESSAGE); 
                            	
                                options= Integer.parseInt(s1);
                                switch (options) 
                                {
                                    case 1:
                                        int Units = Integer.parseInt(JOptionPane.showInputDialog(f,"Please Enter the Units that you Consumed:  ","Eclectricity Bill Payment",JOptionPane.OK_CANCEL_OPTION));
                                        u.ElectricityBill1(Units, uname);
                                        break;

                                    case 2:
                                        double dataconsumed = Double.parseDouble(JOptionPane.showInputDialog(f,"Please Enter the data consumed:  ","Internet Bill Payment",JOptionPane.OK_CANCEL_OPTION));
                                        u.internetBill(dataconsumed, userpass);
                                        break;

                                    case 3:
                                        u.ExistingUser();
                                        break;
                                }
                            } 
                            while (options != 6);
                            break;
                        case "5":
                            ins.close();
                            u.statement(userac);
                            break;
                        case "6":
                        	double principal;
                    		String input;
                    		
                    		input = JOptionPane.showInputDialog(f,"Enter Principal Amount",JOptionPane.OK_CANCEL_OPTION);
                    		principal = Double.parseDouble(input);                   		
                            
                            int year = Integer.parseInt(JOptionPane.showInputDialog(f,"Enter Time period in years : :",JOptionPane.OK_CANCEL_OPTION));
                            
                          u.loandetails(principal, year);
                            break;
                        case "7":
                            ins.close();
                            u.inquiry(userpass);
                            break;
                        default :
                        	JOptionPane.showMessageDialog(f,"You Have Entered Wrong Choice",
                        	"Incorrect User Choice",JOptionPane.ERROR_MESSAGE);                           
                            break;
                    }                  
                count=1;
                break;
                }while (choice!=8);
            }

        }
        if(count==0)
        {
        	JOptionPane.showMessageDialog(f,"You Have Entered Wrong User/Password",
        	"Incorrect User Choice",JOptionPane.ERROR_MESSAGE);
        
        }


        ins.close();


    }
    catch(InputMismatchException e)
    {
    	JOptionPane.showMessageDialog(f,"You Have Entered Wrong User/Password",
    	"Incorrect User Choice",JOptionPane.ERROR_MESSAGE);
    }
    catch(Exception e)
    {    	
    	System.out.println(e);    	
    } 
}

public void DeleteAccount()
{
    String oldFileName = "userdetails.txt";
    String tmpFileName = "out.txt";


	String uname = JOptionPane.showInputDialog(f,"Enter your Username: ","Delete Account",JOptionPane.OK_OPTION);

	String upin = JOptionPane.showInputDialog(f,"Enter Your Password: ","Delete Account",JOptionPane.OK_OPTION);

    String combo=uname+" "+upin+" ";
    String data;
    int cnt=0;
    String ac=null;
    String userac=null;
    BufferedReader ins=null;
    BufferedWriter outs=null;

    try
    {
        ins=new BufferedReader(new FileReader(oldFileName));
        outs=new BufferedWriter(new FileWriter(tmpFileName));

        while((data=ins.readLine())!=null)
        {

            if(data.contains(combo))
            {
                data.getChars(16,20,account,0);
                ac=String.valueOf(account).trim();

                cnt++;
                continue;
            }

            outs.write(data);
            outs.newLine();
        }
        userac=uname+" "+ac;

        if(cnt==0)
        {
        	JOptionPane.showMessageDialog(null, " You Have Entered Wrong User/Password(Pin)...","Delete Account",JOptionPane.OK_OPTION);
        }
        else
        {   JOptionPane.showMessageDialog(null, "Account Deleted Successfully..."
        		+"\nThank You For Banking","Delete Account",JOptionPane.OK_OPTION);
        		System.exit(0);
        }

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
/////////////////////////////////////////////////////////////////////
    String old="statement.txt";
    String temp="delete.txt";
    try
    {
        ins=new BufferedReader(new FileReader(old));
        outs=new BufferedWriter(new FileWriter(temp));

        while((data=ins.readLine())!=null)
        {
            if(data.contains(userac))
            {
                continue;
            }

            outs.write(data);
            outs.newLine();
        }

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

    File oldF = new File(old);
    oldF.delete();

    File newF = new File(temp);
    newF.renameTo(oldF);
////////////////////////////////////////////////////////////////////////////////////////////////////

    String oldFile2="name.txt";
    String tempFile2="delete.txt";
    try
    {
        ins=new BufferedReader(new FileReader(oldFile2));
        outs=new BufferedWriter(new FileWriter(tempFile2));

        while((data=ins.readLine())!=null)
        {
            if(data.contains(uname))
            {
                continue;
            }

            outs.write(data);
            outs.newLine();
        }

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

    File oldName = new File(oldFile2);
    oldName.delete();

    File newName = new File(tempFile2);
    newName.renameTo(oldName);

}
}

