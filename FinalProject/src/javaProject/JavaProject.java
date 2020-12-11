/**
 * 
 */

package javaProject;
import javax.swing.*;
/**
 * @author Team
 *
 */
public class JavaProject {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//AkashdeepSingh-470
		System.out.println("done");
		
		System.out.println("test3"); //AkashdeepSingh-470

		//ganeshganji-996
		System.out.println("ganesh done");
		//MohammedSirajuddin-654
		System.out.println("Siraj done as well");
		//MohammedSirajuddin-654
		JFrame f = new JFrame();
		JOptionPane.showMessageDialog(f,"Hello, Welcome to the Bank."); 
	    f.setVisible(true);  
		String s = JOptionPane.showInputDialog(f,"Please Enter your choice "
				+"\n1.Create New Account"
				+"\n2.Existing Account"
				+"\n3.Delete Account"
				+"\n4.Exit",JOptionPane.QUESTION_MESSAGE);
		int choice=Integer.parseInt(s);  
        if(choice>5 || choice<1)
        {
        	JOptionPane.showMessageDialog(f,
        		    "You Have Entered Wrong Choice"
        			+"",
        		    "Incorrect Choice", JOptionPane.ERROR_MESSAGE);
        	JOptionPane.showConfirmDialog(f,
        		    "Do you want to continue?",
        		    "Confirmation",
        		    JOptionPane.YES_NO_CANCEL_OPTION);
        }
        
        System.out.println("test");
        System.out.println("test2");
        
	}
}
