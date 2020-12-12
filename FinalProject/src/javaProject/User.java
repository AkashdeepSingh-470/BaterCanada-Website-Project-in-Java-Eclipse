/**
 * 
 */
package javaProject;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * @author team
 *
 */
public class User {

	public void NewUser()
	{   
		String inputDialog3,inputDialog4,inputDialog5,amnt;
		inputDialog3 = JOptionPane.showInputDialog("Enter the number of Customers you want to Enter: ");
		int namenumber=Integer.parseInt(inputDialog3);
		System.out.println(namenumber);
		
		JOptionPane.showMessageDialog(null, "Enter your details");
		
		for(int i=0;i<namenumber;i++) {

		
		ArrayList<String> name = new ArrayList<>();
		inputDialog4= JOptionPane.showInputDialog("Enter the name of Customers you want to Enter: ");
		name.add(inputDialog4);
		
       
            
        ArrayList<Integer> contact =new ArrayList<>();
		inputDialog5 = JOptionPane.showInputDialog("Enter the contact numbers of Customers you want to Enter: ");
		int cntct=Integer.parseInt(inputDialog5);
		contact.add(cntct);
		
	
		ArrayList<Integer> Amount =new ArrayList<>();
		amnt=JOptionPane.showInputDialog("Enter the initial amount you want to Enter: ");
		int amount=Integer.parseInt(amnt);
		Amount.add(amount);
		
		JOptionPane.showMessageDialog(null, "Enter next customer details");
	
		
		}
	
	}

}