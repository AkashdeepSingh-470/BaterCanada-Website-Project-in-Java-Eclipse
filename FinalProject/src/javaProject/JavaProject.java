/**
 * 
 */
package javaProject;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


/**
 * @author Team 
 *
 */
public class JavaProject implements ActionListener 
{
	private static JLabel username1;
	private static JTextField userText1;
	private static JLabel password1;
	private static JPasswordField passwordText;
	private static JButton button;
	private static JLabel success;
	
	private static String userName = "sir911";
	private static String userpassword = "bob";
	
	public static int attempts = 0;
	public static JFrame frame1;
	public static JPanel panel1;
	
	public static void main(String[] args) 
	{
		
		panel1 = new JPanel();
		frame1 = new JFrame();
		frame1.setSize(350,200);
		frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame1.add(panel1);
		
		panel1.setLayout(null);
		
		username1 = new JLabel("Username: ");
		username1.setBounds(10,20,80,25);
		panel1.add(username1);
		
		userText1 = new JTextField(20);
		userText1.setBounds(100, 20, 165, 25);
		panel1.add(userText1);
		
		password1 = new JLabel("Password: ");
		password1.setBounds(10,50,80,25);
		panel1.add(password1);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(100,50,165,25);
		panel1.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(10,80,80,25);
		button.addActionListener(new JavaProject());
		panel1.add(button);
		
		success = new JLabel("");
		success.setBounds(10,110,300,25);
		panel1.add(success);
		
		frame1.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String user = userText1.getText();
		System.out.println(user);
		String password = passwordText.getText();
		System.out.println(password);

			if (user.equals(userName) && password.equals(userpassword))
			{
				success.setText("Login Successful!");
				frame1.dispose();
				JOptionPane.showMessageDialog(null, "congrats");
				try {
					methodTwo(null);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		 else
		 { 
			 if(attempts<=2)
			 {
				 success.setText("Login Unsuccessful!");
				 attempts++;
				 System.out.println(attempts);
			 }
			 else 
			 {
				 //System.out.println(attempts);
				frame1.dispose();
				JOptionPane.showMessageDialog(null, "you have exceeded the given attempts");		 
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
	        U.ExistingUser();
	        break;
	    case 2:
	    	U.ExistingUser();
	        break;
	    case 3:
	        //U.DeleteAccount();
	        break;
	    case 4:
	  	  JOptionPane.showMessageDialog(null,"You Have Entered Wrong Choice");
	        break;
	    default:
	    
	    int result = JOptionPane.showConfirmDialog(null,"You Have Entered Wrong Choice"+"\nDo you want to continue?","Confirmation",JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.ERROR_MESSAGE);
	    if(result == JOptionPane.YES_OPTION)
	    {
	    	/*String userName = "sir911";
	    	String password = "bob";
	    	methodOne(userName,password); */ 
	     }
	    else if (result == JOptionPane.NO_OPTION)
	    {
	        System.exit(0);
	     }
	     else 
	     {
	    	 System.exit(0);
	     }
	    break;
	}
	}
	}
}