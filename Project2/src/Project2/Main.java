package Project2;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[])
	{
		CalGui calc = new CalGui();
		calc.pack();
		calc.setLocationRelativeTo(null);
		calc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		calc.setVisible(true);
	}

}
