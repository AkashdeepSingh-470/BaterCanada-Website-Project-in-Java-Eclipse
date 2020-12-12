/**
 * 
 */
package javaProject;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;


/**
 * @author Team 
 *
 */
public class JavaProject {
	  /*
	   * 
	   */
public static void main(String[] args) throws IOException 
	      {
	
	
	
	
	try 
	{
	    	  	String userName = "sir911";
	  	  		String password = "bob";
	  	  	User U=new User();

		//ganeshganji-996
		System.out.println("ganesh done");
		//MohammedSirajuddin-654
		System.out.println("Siraj done as well");
		//MohammedSirajuddin-654
		JFrame f = new JFrame();
		JOptionPane.showMessageDialog(f,"Hello, Welcome to the Bank."); 
		String s = JOptionPane.showInputDialog(f,"Please Enter your choice "
				+"1.Create New Account"
				+"2.Existing Account"
				+"3.Delete Account"
				+"4.Exit",JOptionPane.QUESTION_MESSAGE);
		int choice=Integer.parseInt(s);
		int Userchoice =0;
        if(choice>5 || choice<1)
        {
        	JOptionPane.showMessageDialog(f,
        		    "You Have Entered Wrong Choice"
        			+"",
        		    "Incorrect Choice",JOptionPane.ERROR_MESSAGE);
        	Userchoice=JOptionPane.showConfirmDialog(f,
        		    "Do you want to continue?",
        		    "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
        }
		
        if(Userchoice == JOptionPane.YES_OPTION)
        {
        	methodTwo();
        }
        else if (Userchoice == JOptionPane.NO_OPTION)
        {
            System.exit(0);
         }
         else 
         {
        	 System.exit(0);
         }
        
        switch(choice)
        {
          case 1:
        	  
              U.NewUser();
              
           /*   U.ExistingUser();
              break;*/
          case 2:
        	  /*
              U.ExistingUser();*/
              break;
          case 3:
           /*
              U.DeleteAccount();*/
              break;
          case 4:
        	  JOptionPane.showMessageDialog(null,"Thank You for visting Simulation of a Banking System");
              break;
          default:
        	  System.exit(0);
        	  break;
        	  
        }
	      }
    catch(Exception e)
{
    	System.out.println(e);
}
        
        
      //MohammedSirajuddin-654
        
        
	  }

public static void methodOne(String UserName, String password) throws IOException 
{
//Here made two dialog box for taking input from user
String inputDialog;
String inputDialog2;
int attempts = 0; //Initializing this variable

//Here while loop gives only three attempts for user to login
while(attempts < 3)
 {
	
	 //taking input from user through Dialog box
	 inputDialog = JOptionPane.showInputDialog("Enter your Username",JOptionPane.OK_CANCEL_OPTION);
	 inputDialog2 = JOptionPane.showInputDialog("Enter your Password",JOptionPane.OK_CANCEL_OPTION);
	  
	 
 
	 //checking if input userName and password is correct or not
	if (inputDialog.equals(UserName) && inputDialog2.equals(password))
	{
	//displaying login success message to user
	JOptionPane.showMessageDialog(null, "Login Success");
	break;

	}
 else
 {
	   //message for user if wrong userName and password is entered
	   JOptionPane.showMessageDialog(null, "Invalid Username or Password Try Again!");
	   attempts++;  
	   
 }
 }


	  }

public static void methodTwo()
{
	JFrame f = new JFrame();
	String s = JOptionPane.showInputDialog(f,"Please Enter your choice "
			+"1.Create New Account"
			+"2.Existing Account"
			+"3.Delete Account"
			+"4.Exit",JOptionPane.QUESTION_MESSAGE);
	int choice=Integer.parseInt(s);
	int Userchoice =0;
    if(choice>5 || choice<1)
    {
    	JOptionPane.showMessageDialog(f,
    		    "You Have Entered Wrong Choice"
    			+"",
    		    "Incorrect Choice",JOptionPane.ERROR_MESSAGE);
    	Userchoice=JOptionPane.showConfirmDialog(f,
    		    "Do you want to continue?",
    		    "Confirmation",JOptionPane.YES_NO_CANCEL_OPTION);
    }
}
}
//MohammedSirajuddin-654
