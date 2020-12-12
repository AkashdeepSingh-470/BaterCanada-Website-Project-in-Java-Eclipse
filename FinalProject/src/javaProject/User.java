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
}
//MohammedSirajuddin-654
	

