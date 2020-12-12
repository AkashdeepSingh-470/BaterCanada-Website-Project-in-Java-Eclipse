/**
 * 
 */
package javaProject;

import java.io.IOException;
import javax.swing.JOptionPane;


/**
 * @author AkashdeepSingh-470
 *
 */
public class JavaProject {
	  /*
	   * To change this license header, choose License Headers in Project Properties.
	   * To change this template file, choose Tools | Templates
	   * and open the template in the editor.
	   */

	      public static void main(String[] args) throws IOException 
	      {
	    	  	String userName = "sir911";
	  	  		String password = "bob";
	  	  		methodOne(userName,password);
	  	  		
	      }

public static void methodOne(String userName, String password) throws IOException 
{
//Here made two dialog box for taking input from user
String inputDialog;
String inputDialog2;
int attempts = 0; //Initializing this variable

//Here while loop gives only three attempts for user to login
while(attempts < 3)
 {
	 //taking input from user through Dialog box
	 inputDialog = JOptionPane.showInputDialog("Enter your Username");
	 inputDialog2 = JOptionPane.showInputDialog("Enter your Password");
	 
	 //checking if input userName and password is correct or not
	if (inputDialog.equals(userName) && inputDialog2.equals(password))
	{
	//displaying login success message to user
	JOptionPane.showMessageDialog(null, "Login Success");
	methodTwo(null);
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
public static void methodTwo(String[] args) throws IOException 
{
	User U=new User();

	Update Up=new Update();


            
	JOptionPane.showMessageDialog(null,"     Welcome to Simulation of a Banking System 	 ");
{
	
  String s = JOptionPane.showInputDialog(null,"Please Enter your choice"
		  	+"\n1.Create New Account"
			+"\n2.Existing Account"
			+"\n3.Delete Account"
			+"\n4.Exit",JOptionPane.QUESTION_MESSAGE);
  int choice=Integer.parseInt(s);

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
  
  int result = JOptionPane.showConfirmDialog(null,"You Have Entered Wrong Choice"+"\nDo you want to continue?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
  if(result == JOptionPane.YES_OPTION){
  	String userName = "sir911";
  	String password = "bob";
  	methodOne(userName,password);  
   }
  else if (result == JOptionPane.NO_OPTION)
  {
      System.exit(0);
   }
   else 
   {
  	 System.exit(0);
   }
  	String userName = "sir911";
	String password = "bob";
	methodOne(userName,password);
  break;
}
}
}
}