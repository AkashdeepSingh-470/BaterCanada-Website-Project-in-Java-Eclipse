/**
 * 
 */
package javaProject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 * @author team
 *
 */
public class User extends functions {
	//MohammedSirajuddin-654
	public void NewUser()
	{   
		String inputDialog3;
		inputDialog3 = JOptionPane.showInputDialog("Enter the number of Accounts you want to Create: ");
		int namenumber=Integer.parseInt(inputDialog3);
		System.out.println(namenumber);
		ArrayList<String> name = new ArrayList<>(namenumber);
		ArrayList<Integer> contact= new ArrayList<>(namenumber);
		ArrayList<Double> amnt= new ArrayList<>(namenumber);
		
		
		
		for(int i=0;i<namenumber;i++) 
		{
		int c=0;
		JOptionPane.showMessageDialog(null, "Enter your details");
		try {
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
        name1= JOptionPane.showInputDialog("Enter your name",JOptionPane.OK_CANCEL_OPTION);
        name.add(i,name1);
        
        
        if (name.get(i).length() < 2) 
        {
        	JOptionPane.showMessageDialog(f,
        		    "Name Should be greater than 2-Characters."
        			+"",
        		    "Enter a Valid Name.",JOptionPane.ERROR_MESSAGE);
            c++;
        } else if (name.get(i).matches(".*?[\\p{Punct}&&[^_]].*") || name.get(i).matches("[a-zA-Z ]*\\d+.*")) 
        {
        	JOptionPane.showMessageDialog(f,
        		    "-Enter a Valid Name."
        			+"",
        		    "Enter a Valid Name.",JOptionPane.ERROR_MESSAGE);
            
            c++;
        }
		}while (c == 1);

        /*************************************************/
        do
        {
        contact1= JOptionPane.showInputDialog("Enter your contact number",JOptionPane.OK_CANCEL_OPTION);	
        double contactnumber=Double.parseDouble(contact1);
        int contactnumber1=(int)contactnumber;
        contact.add(i, contactnumber1);
        
        BufferedReader br = new BufferedReader(new FileReader("userdetails.txt"));
        
        if (contact.get(i).equals("(.*)[a-zA-Z]+(.*)") || contact.get(i).equals(".*?[\\p{Punct}&&[^_]].*"))
        {
            
            JOptionPane.showMessageDialog(f,
        		    "-Enter a Valid Contact Number."
        			+"",
        		    "Enter a Valid Contact Number.",JOptionPane.ERROR_MESSAGE);
            c++;
        } 
        else if (contact.get(i).SIZE < 15) 
        {
            c++;
            JOptionPane.showMessageDialog(f,
        		    "-Contact Number Should be of 10-Digits."
        			+"",
        		    "Contact Number Should be of 10-Digits.",JOptionPane.ERROR_MESSAGE);
            
        } 
        else 
        {
            while ((lread = br.readLine()) != null) 
            {
                c = 0;
                if (lread.contains(contact.get(i) + " "))
                {
                    c++;
                    JOptionPane.showMessageDialog(f,
                		    "Contact Number Already Exists."
                			+"",
                		    "Contact Number Already Exists.",JOptionPane.ERROR_MESSAGE);
                    break;
                }
            }
        }
        
        }while (c == 1);
        
        /*************************************************/
        
        
        do
        {
        	c = 0;
        	amnt1= JOptionPane.showInputDialog("Enter the amount",JOptionPane.OK_CANCEL_OPTION);	
            double amount=Integer.parseInt(amnt1);
            amnt.add(i, amount);
            
            if (amnt.equals("(.*)[a-zA-Z]+(.*)") || amnt.equals(".*?[\\p{Punct}&&[^_]].*")) 
            {

                c++;
                JOptionPane.showMessageDialog(f,
            		    "Enter a Valid Amount."
            			+"",
            		    "Enter a Valid Amount.",JOptionPane.ERROR_MESSAGE);
              
            } 
            else {
               
                if (amnt.get(i)< 1000)
                {
                	JOptionPane.showMessageDialog(f,
                		    "Initial Amount Should be greater than or equals to Rs.1000."
                			+"",
                		    "Enter a Valid Amount.",JOptionPane.ERROR_MESSAGE);
                	
                    
                    c++;
                }
            }
	
        }while (c == 1);
        
        /*************************************************/
        //MohammedSirajuddin-654
       
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
        String username;
        String password;
        username= JOptionPane.showInputDialog("Please enter your new user name:"
    			+ "Account creation",JOptionPane.OK_CANCEL_OPTION);
        password=JOptionPane.showInputDialog("Please enter your new password:"
    			+ "Account creation",JOptionPane.OK_CANCEL_OPTION);
        
        /*************************************************/
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
        } while (c == 1);
        JOptionPane.showMessageDialog(f,
        	    "Account Created Successfully.",
        	    "Account Created Successfully.",
        	    JOptionPane.INFORMATION_MESSAGE);

        JOptionPane.showMessageDialog(f,
        	    "Username :" + username,
        	    "Account details for Account"+acnt,
        	    JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(f,
        	    "Password :" + password,
        	    "Account details for Account "+acnt,
        	    JOptionPane.INFORMATION_MESSAGE);
        JOptionPane.showMessageDialog(f,
        	    "Amount :" + amnt.get(i),
        	    "Account Summary for Account "+acnt,
        	    JOptionPane.INFORMATION_MESSAGE);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");//MohammedSirajuddin-654
        String date = sdf.format(new Date());

        /*************************************************/
        
        bw.write(username + " " + acnt + "   " + amnt.get(i) + "  initial" + "    " + amnt.get(i) + "   " + date); 
      //statement.txt
        bw.newLine();
        
        bw.close();
        
        outs.println(username + " " + password + "  " + acnt + "  " + actype + "  " + contact.get(i) + "  " + amnt.get(i)); //userdetails.txt
      //userdetails.txt
        outs.close();
        
        
        BufferedWriter wr = new BufferedWriter(new FileWriter("name.txt", true));
        wr.write("Username:-  "+ username + " Password:- " + password + " Account Holders name " + name.get(i));
        wr.newLine();
        wr.close();


		}
		//MohammedSirajuddin-654
		catch(Exception e)
		{
			
            System.out.println(e);
		}
		}
		}

//MohammedSirajuddin-654
	
//ganeshganji-996
char account[]=new char[6];
private Random scan;

public void ExistingUser()
{
	JOptionPane.showMessageDialog(null, "Enter your details");
   
    int count=0;
    String name=null,pass=null,amt=null,cont=null,actyp=null;
  
    
    name= JOptionPane.showInputDialog("Enter your NAME",JOptionPane.OK_CANCEL_OPTION);
  
    pass= JOptionPane.showInputDialog("Enter your PIN",JOptionPane.OK_CANCEL_OPTION);

    String userpass=name+" "+pass+" ";
    char cnt=' ';
    int choice;
    String line,line2,fullname;
    char full[]=new char[100];

    try
    {


        BufferedReader ins=new BufferedReader(new FileReader("userdetails.txt"));


        while((line=ins.readLine())!=null)
        {

            if(line.contains(userpass))
            {

                System.out.println("\nLogged In Successfully !!!");
                System.out.println("-------------------------------------------------------------");
                BufferedReader nmf=new BufferedReader(new FileReader("name.txt"));

                while((line2=nmf.readLine())!=null)
                {

                    if(line2.contains(userpass))
                    {
                        line2.getChars(13,line2.length(),full,0);
                        fullname=String.valueOf(full).trim();
                        System.out.println("\n\tWelcome Dear, "+fullname);
                    }
                }
                nmf.close();



                line.getChars(12,18,account,0);
                String ac=String.valueOf(account).trim();
                String userac=name+" "+ac;

                do
                {


                    System.out.println("-------------------------------------------------------------");
                    System.out.println("\nPlease Enter Your Choice :");
                    System.out.println("1.Deposit");
                    System.out.println("2.Withdraw");
                    System.out.println("3.Transfer Money");
                    System.out.println("4.Pay Utilities");
                    System.out.println("5.Balance Inquiry");
                    System.out.println("6.Loan Details");
                    System.out.println("7.Mini Statement");
                
          
                   
                   
					choice=scan.nextInt();
                    System.out.println("-------------------------------------------------------------");

                    switch(choice) {
                        case 1:
                            ins.close();
                            deposit(userpass);
                            break;
                        case 2:
                            ins.close();
                            withdraw(userpass);
                            break;
                        case 3:
                            ins.close();
                            String acc1,acc2,a;
                           
                            acc1= JOptionPane.showInputDialog("Enter a Account number to transfer from",JOptionPane.OK_CANCEL_OPTION);
                            acc2= JOptionPane.showInputDialog("Enter a Account number to transfer to",JOptionPane.OK_CANCEL_OPTION);
                            
                            //a= JOptionPane.showInputDialog("Enter the amount you want to transfer",JOptionPane.OK_CANCEL_OPTION);
                            a=JOptionPane.showInputDialog(null, Float.toString(12.25f));
                           
                           

                            withdrawfrom(acc1, a);
                            depositto(acc2, a);
                            break;
                        case 4:
                            int options;
                            do {
                                System.out.println();

                                System.out.println("1) Electricity Bill");
                                System.out.println("2)Water Bill ");
                                System.out.println("3) Mobile Bill ");
                                System.out.println("4) Internet Bill");
                                System.out.println("5) Exit");
                              
                                options= Integer.parseInt(JOptionPane.showInputDialog("Enter choice [1-5]: ",JOptionPane.OK_CANCEL_OPTION));
                                switch (options) {
                                    case 1:
                                     
                                        int Units = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the Units that you Consumed  :",JOptionPane.OK_CANCEL_OPTION));
                                        ElectricityBill1(Units, name);
                                        break;

                                    case 2:
                                
                                        int galoonused = Integer.parseInt(JOptionPane.showInputDialog(" Enter the galoon of water used   : ",JOptionPane.OK_CANCEL_OPTION));
                                        waterBill(galoonused, userpass);
                                        break;

                                    case 3:

                                        int textUsed = Integer.parseInt(JOptionPane.showInputDialog(" Please Enter the texts sent   :  :",JOptionPane.OK_CANCEL_OPTION));
                                        System.out.print(" ");
                                        double callUsed = Integer.parseInt(JOptionPane.showInputDialog("Please Enter minutes used  :  Please Enter the texts sent   :  :",JOptionPane.OK_CANCEL_OPTION));
                                        mobileBill(textUsed, callUsed, userpass);

                                        break;

                                    case 4:
                                        System.out.print(" ");
                                        double dataconsumed = Integer.parseInt(JOptionPane.showInputDialog("Please Enter the data consumed   : :",JOptionPane.OK_CANCEL_OPTION));
                                        internetBill(dataconsumed, userpass);
                                        break;

                                    case 5:
                                        ExistingUser();
                                        break;
                                }
                            } while (options != 6);
                                   break;
                        case 5:
                            ins.close();
                            statement(userac);
                            break;
                        case 6:
                        	double principal;
                    		String input;
                    		
                    		input = JOptionPane.showInputDialog("Enter Principal Amount");
                    		principal = Double.parseDouble(input);
                    		
                            
                            int year = Integer.parseInt(JOptionPane.showInputDialog("Enter Time period in years : :",JOptionPane.OK_CANCEL_OPTION));
                            
                          loandetails(principal, year);
                            break;
                        case 7:
                            ins.close();
                            inquery(userpass);
                            break;
                        default :
                            System.out.println("\nOops !!! You Have Entered Wrong Choice...");
                            System.out.println("-------------------------------------------------------------");
                            break;

                    }
                   // System.out.println("Do you want to continue (Y/N) :");
                   // cnt=scan.next().charAt(0);
                     //cnt=JOptionPane.showInputDialog("Do you want to continue (Y/N)");
                    JFrame f = new JFrame();
                    
                    String Userchoice;
                    Userchoice=JOptionPane.showConfirmDialog(f,
                		    "Do you want to continue?",
                		    "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION); 
             String c;
             c=JOptionPane.showInputDialog("Do you want to continue (Y/N)");

                
             
                
                
                
                while(cnt=='Y' || cnt=='y');
                
                if(cnt!='y' ||cnt!='Y')
                {
                    System.out.println("-------------------------------------------------------------");
                    System.out.println("Thank You");
                    System.out.println("          For Banking...");
                    System.out.println("-------------------------------------------------------------");
                }
                count=1;
                break;
                }while (choice!=8);
            }


        }
        if(count==0)
        {
            System.out.println("\nOops !!! You Have Entered Wrong User/Password(Pin)...");
            System.out.println("-------------------------------------------------------------");
        }


        ins.close();


    }
    catch(InputMismatchException e)
    {
        System.out.println("\nOops !!! You Have Entered Wrong Input...");
        System.out.println("-------------------------------------------------------------");
    }
    catch(Exception e)
    {}
  
}

private void inquery(String userpass) {
	// TODO Auto-generated method stub
	
}

private void loandetails(double principal, int year) {
	// TODO Auto-generated method stub
	
}

private void statement(String userac) {
	// TODO Auto-generated method stub
	
}

private void internetBill(double dataconsumed, String userpass) {
	// TODO Auto-generated method stub
	
}

private void mobileBill(int textUsed, double callUsed, String userpass) {
	// TODO Auto-generated method stub
	
}

private void waterBill(int galoonused, String userpass) {
	// TODO Auto-generated method stub
	
}

private void ElectricityBill1(int units, String name) {
	// TODO Auto-generated method stub
	
}

private void depositto(String acc2, String a) {
	// TODO Auto-generated method stub
	
}

private void withdrawfrom(String acc1, String a) {
	// TODO Auto-generated method stub
	
}

public void withdraw(String userpass) {
	// TODO Auto-generated method stub
	
}

public void deposit(String userpass) {
	// TODO Auto-generated method stub
	

}
}

