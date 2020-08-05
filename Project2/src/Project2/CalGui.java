package Project2;
import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

import java.awt.*; 
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class CalGui extends JFrame {

		private JLabel lable;
		private JButton buttonNum0; 
		private JButton buttonNum1; 
		private JButton buttonNum2;
		private JButton buttonNum3;
		private JButton buttonNum4;
		private JButton buttonNum5;
		private JButton buttonNum6;
		private JButton buttonNum7;
		private JButton buttonNum8;
		private JButton buttonNum9;
		private JButton buttonMultiply;
		private JButton buttonDivide;
		private JButton buttonEql;
		private JButton buttonSub;
		private JButton buttonAdd;
		private JButton buttonClear;
		private JButton buttonDot;
		private JButton buttonBack; 
		private double TEMP;
		private double SolveTemp;
		private JTextField Result; 
		private JTextField ResultBin; 
		private JTextField ResultHex;
		private JTextField ResultOct; 
		private JButton AND;
		private JButton A;
		private JButton B;
		private JButton C;
		private JButton D;
		private JButton E;
		private JButton F;
		private JButton Xor;
		private JButton Not;
		private JButton Or;
		private JButton Lsh;
		private JButton Rsh;
		private JButton Mod;
		private JButton signSwitch; 
		private JButton Bin; 
		private JButton up;
		private JButton CE;
		private JButton back;
		private JButton brace1;
		private JButton brace2;
		private JButton Dec;
		private JButton Hex;
		private JButton Oct; 
		private  JTextField ResultDec; 

	
	Boolean addBool = false; // Used to determine what operation will be used
	Boolean subBool = false; 
	Boolean divBool = false;
	Boolean mulBool = false;
	Boolean modBool = false; 
	Boolean Eqls    = false; 
	Boolean bin = false;
	Boolean add = false; 
	Boolean dec = true;
	Boolean hex = false;
	Boolean oct = false; 
	
	String display = "";
	String displayBin = ""; 
	String displayHex = ""; 
	String displayOct = ""; 
	String binTemp = ""; 
	String binSolveTemp =""; 
	String tempHex = ""; 
	String SolveTemphex = ""; 
	String octSolveTemp = "";
	String octTemp = ""; 
	
	
	public static String binaryConverter(int dec)
	{
		String str2 = "";
		int finalvalue; 
		if (dec == 0) {
		return "";
		}
		
		else
		{
		  finalvalue = (dec%2); 
			str2 = str2 + finalvalue;
			return binaryConverter(dec/2) + finalvalue; 
	
	    }
	}
	
	public static String dec2Hex(int value)
	{
		String result = "";
		int remain = value %16;
		
		if(value == 0)
		{
			return "0";  
		}
		
		else 
		{
			switch (remain)
			{
			case 10: 
				result = "A";
				break;
			case 11:
				result = "B";
				break; 
			case 12: 
				result = "C";
				break; 
			case 13:
				result = "D";
				break;
			case 14:
				result = "E";
				break;
			case 15:
				result = "F";
				break;
			default:
				result = remain + result; 
			}
			return dec2Hex(value/16)+  result; 
			
		}
		
	}
	 static String findTwoscomplement(StringBuffer str) 
	    { 
	        int n = str.length(); 
	       
	        // Traverse the string to get first '1' from 
	        // the last of string 
	        int i; 
	        for (i = n-1 ; i >= 0 ; i--) 
	            if (str.charAt(i) == '1') 
	                break; 
	       
	        // If there exists no '1' concat 1 at the 
	        // starting of string 
	        if (i == -1) 
	            return "1" + str; 
	       
	        // Continue traversal after the position of 
	        // first '1' 
	        for (int k = i-1 ; k >= 0; k--) 
	        { 
	            //Just flip the values 
	            if (str.charAt(k) == '1') 
	                str.replace(k, k+1, "0"); 
	            else
	                str.replace(k, k+1, "1"); 
	        } 
	       
	        // return the modified string 
	        return str.toString(); 
	    } 

	
		public static String toOctal(int decimal){    
		    int rem; //declaring variable to store remainder  
		    String octal=""; //declareing variable to store octal  
		    //declaring array of octal numbers  
		    char octalchars[]={'0','1','2','3','4','5','6','7'};  
		    //writing logic of decimal to octal conversion   
		    while(decimal>0)  
		    {  
		       rem=decimal%8;   
		       octal=octalchars[rem]+octal;   
		       decimal=decimal/8;  
		    }  
		    return ("0o" + octal);  
		} 
	 
		public static int oct2Dec(String octal)
	    {
			int a = Integer.parseInt(octal);	
	        int decimalNumber = 0, i = 0;

	        while(a != 0)
	        {
	            decimalNumber += (a % 10) * Math.pow(8, i);
	            ++i;
	            a/=10;
	        }

	        return decimalNumber;
	    }
		public static int bin2Dec(String binInput){  
		    int len = binInput.length();
		    if (len == 0) 
		    return 0;
		    else {
		    String now = binInput.substring(0,1);
		    String later = binInput.substring(1);
		    return Integer.parseInt(now) * (int)Math.pow(2, len-1) + bin2Dec(later);   
		    }
		  }
	 
		 public static String addBinary(String a, String b){
			    // Use as radix 2 because it's binary    
			    int number0 = Integer.parseInt(a, 2);
			    int number1 = Integer.parseInt(b, 2);
			    int sum = number0 + number1;
			    return Integer.toBinaryString(sum); //returns the answer as a binary value;
			}
		

		public static String subBinary(String bin1, String bin2)
		{
			
			int a = bin2Dec(bin1);
			int b = bin2Dec(bin2);
			int result = a - b;
			String total = binaryConverter(result);
			
			return total; 
			
		}
		
		
		String binMul(String bin1, String bin2)
		{
			int a = bin2Dec(bin1);
			int b = bin2Dec(bin2);
			int result = a * b; 
			String total = binaryConverter(result);
			return total; 
		}

		
		String binDiv(String bin1, String bin2)
		{
			int a = bin2Dec(bin1);
			int b = bin2Dec(bin2);
			int result = a/b; 
			String total = binaryConverter(result);
			return total; 
			
		}
		
		String binMod(String bin1, String bin2)
		{
			int a = bin2Dec(bin1);
			int b = bin2Dec(bin2);
			int result = a%b; 
			String total = binaryConverter(result);
			return total; 
			
		}
		
		private static int hex2Dec(String hexNum) {
			int decimal = 0;
			String Code = "0123456789ABCDEF"; 
			hexNum = hexNum.toUpperCase(); // Used if the user inputs hex values that have lower case
			int length = hexNum.length();
			if (length > 0) {
				char ch = hexNum.charAt(0); 
				int digit = Code.indexOf(ch);
				String substring = hexNum.substring(1);
				decimal = digit * (int) Math.pow(16, length - 1) + hex2Dec(substring);
			}
			return decimal;
		}
		
		String hexAdd(String hex1, String hex2)
		{
			int a = hex2Dec(hex1);
			int b = hex2Dec(hex2);
			int	result = a + b;
			String total = dec2Hex(result); 
			return total; 
			
		}
		
		String hexMod(String hex1, String hex2)
		{
			int a = hex2Dec(hex1);
			int b = hex2Dec(hex2);
			int	result = a % b;
			String total = dec2Hex(result); 
			return total; 
			
		}
		
		String hexSub(String hex1, String hex2)
		{
			int a = hex2Dec(hex1);
			int b = hex2Dec(hex2);
			int	result = a - b;
			String total = dec2Hex(result); 
			return total; 
			
		}
		
		String hexMul(String hex1, String hex2)
		{
			int a = hex2Dec(hex1);
			int b = hex2Dec(hex2);
			int	result = a * b;
			String total = dec2Hex(result); 
			return total; 
			
		}
		
		
		String hexDiv(String hex1, String hex2)
		{
			int a = hex2Dec(hex1);
			int b = hex2Dec(hex2);
			int	result = a/b;
			String total = dec2Hex(result); 
			return total; 
			
		}
		
		
		String octAdd(String oct1, String oct2)
		{
			int a = oct2Dec(oct1);
			int b = oct2Dec(oct2);
			int result = a + b;
			String total = Integer.toString(result);
			return total; 
		}
		
		String octSub(String oct1, String oct2)
		{
			int a = oct2Dec(oct1);
			int b = oct2Dec(oct2);
			int result = a - b;
			String total = Integer.toString(result);
			return total; 
		}
		
		
		String octMul(String oct1, String oct2)
		{
			int a = oct2Dec(oct1);
			int b = oct2Dec(oct2);
			int result = a * b;
			String total = Integer.toString(result);
			return total; 
		}
		
		String octDiv(String oct1, String oct2)
		{
			int a = oct2Dec(oct1);
			int b = oct2Dec(oct2);
			int result = a / b;
			String total = Integer.toString(result);
			return total; 
		}
		
		String octMod(String oct1, String oct2)
		{
			int a = oct2Dec(oct1);
			int b = oct2Dec(oct2);
			int result = a % b;
			String total = Integer.toString(result);
			return total; 
		}
		
	 public CalGui() // Constructor
	 {
	       
			JPanel p1 = new JPanel();
			p1.setLayout(new GridLayout(7,5));

			p1.add(Lsh =  new JButton("Lsh"));
			p1.add(Rsh =  new JButton("Rsh"));
			p1.add(Or =  new JButton("Or"));
			p1.add(Xor =  new JButton("Xor"));
			p1.add(Not =  new JButton("Not"));
			p1.add(AND = new JButton("AND")); 
			p1.add(up = new JButton("â†‘"));
		
			
			
			JPanel p2 = new JPanel();
			p2.setLayout(new GridLayout(7,5));
			p2.add(lable = new JLabel(" \u2630" + " Programmer ")); 
			p2.add(Result = new JTextField(20)); // Where the result will be outputted.
		//	p2.add(Bin = new JButton("Bin"));

			p2.add(ResultBin = new JTextField(20));
			p2.add(ResultHex = new JTextField(20)); 
			p2.add(ResultOct = new JTextField(20));   
			p2.add(ResultDec = new JTextField(20));   

			Result.setHorizontalAlignment(JTextField.LEFT);
			p2.add(Bin = new JButton("Bin"));
			ResultBin.setHorizontalAlignment(JTextField.LEFT);
			p2.add(Hex = new JButton("Hex"));
			ResultHex.setHorizontalAlignment(JTextField.LEFT);
			p2.add(Oct = new JButton("Oct")); 
			ResultOct.setHorizontalAlignment(JTextField.LEFT);
			p2.add(Dec = new JButton("Dec"));
			Result.setEditable(false);
			ResultBin.setEditable(false);
			ResultHex.setEditable(false);
			ResultOct.setEditable(false);
			
		
			p1.add(Mod = new JButton("Mod")); 
			p1.add(CE = new JButton("CE")); 
			p1.add(buttonClear = new JButton("C"));
			p1.add(back = new JButton("<-"));
			p1.add(buttonDivide = new JButton("Ã·")); 
			p1.add(A = new JButton("A"));
			p1.add(B = new JButton("B"));
			p1.add(buttonNum7 = new JButton("7")); 
			p1.add(buttonNum8 = new JButton("8"));
			p1.add(buttonNum9 = new JButton("9")); 
			p1.add(buttonMultiply = new JButton("X"));
			p1.add(C = new JButton("C"));
			p1.add(D = new JButton("D"));
			p1.add(buttonNum4 = new JButton("4"));
			p1.add(buttonNum5 = new JButton("5"));
			p1.add(buttonNum6 = new JButton("6"));
			p1.add(buttonSub = new JButton("-"));
			p1.add(E = new JButton("E"));
			p1.add(F = new JButton("F"));
			p1.add(buttonNum1 = new JButton("1"));
			p1.add(buttonNum2 = new JButton("2"));
			p1.add(buttonNum3 = new JButton("3")); 
			p1.add(buttonAdd = new JButton("+"));
			p1.add(brace1 = new JButton("("));
			p1.add(brace2 = new JButton(")"));
			p1.add(signSwitch = new JButton("+/-")); 
			p1.add(buttonNum0 = new JButton("0"));
			p1.add(buttonDot =  new JButton("."));
			p1.add(buttonEql = new JButton("=")); 
		 
			
	
			JPanel p = new JPanel();
			p.add(p2);
			p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
			p.add(p1);
			add(p);

		//Used to determine when each button is clicked
		buttonNum1.addActionListener(new ListentoOne());
		buttonNum2.addActionListener(new ListentoTwo());
		buttonNum3.addActionListener(new ListentoThree());
		buttonNum4.addActionListener(new ListentoFour());
		buttonNum5.addActionListener(new ListentoFive());
		buttonNum6.addActionListener(new ListentoSix());
		buttonNum7.addActionListener(new ListentoSeven());
		buttonNum8.addActionListener(new ListentoEight());
		buttonNum9.addActionListener(new ListentoNine());
		buttonNum0.addActionListener(new ListentoZero());
		buttonAdd.addActionListener(new ListentoAdd());
		buttonSub.addActionListener(new ListentoSubtract());
		buttonMultiply.addActionListener(new ListentoMultiply());
		buttonDivide.addActionListener(new ListentoDivide());
		buttonClear.addActionListener(new ListenClear());
		buttonEql.addActionListener(new ListentoSolve());
		buttonDot.addActionListener(new ListentoDot());
		Mod.addActionListener(new ListentoMOD()); 
		signSwitch.addActionListener(new ListentoSignChange()); 
		Bin.addActionListener(new ListentoBin()); 
		Dec.addActionListener(new ListentoDec());
		Hex.addActionListener(new ListentoHex());
		Oct.addActionListener(new ListentoOct());
		A.addActionListener(new ListentoA());
		B.addActionListener(new ListentoB());
		C.addActionListener(new ListentoC());
		D.addActionListener(new ListentoD());
		E.addActionListener(new ListentoE());
		F.addActionListener(new ListentoF());
		back.addActionListener(new ListentoBack());
		
        try
        {
          UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
           
        }

            catch(Exception e)
           {
             
           }
        
        SwingUtilities.updateComponentTreeUI(p);   
        

		
		
	 }
	 

	 class ListentoBack implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (dec == true)
			{
				display = Result.getText(); 
			
			    if (display != null && display.length() > 0) {
			        display = display.substring(0, display.length() - 1); 
			        Result.setText(display);
			        int binDisp = Integer.parseInt(Result.getText()); 
				    String bin = binaryConverter(binDisp); 
				    ResultBin.setText("Bin: " + bin);
				    
				    int hexDisp = Integer.parseInt(Result.getText()); 
				    String hex = dec2Hex(hexDisp); 
				    ResultHex.setText("Hex: 0x" + hex);
				     
				    
				    int octDisp = Integer.parseInt(Result.getText()); 
				    String Oct = toOctal(octDisp); 
				    ResultOct.setText("Oct: " + Oct);
			}
			}
			    
			    else if (bin == true)
			    {
			    	displayBin = ResultBin.getText();
			    if (displayBin != null && displayBin.length() > 0) {
			        displayBin = displayBin.substring(0, displayBin.length() - 1); 
			    
			        ResultBin.setText(displayBin);
			        String decDispl = ResultBin.getText(); 
					String dec = Integer.toString(bin2Dec(decDispl)); 
					Result.setText("Dec: " + dec);
					
				    int hexDisp = Integer.parseInt(dec); 
				    String hex = dec2Hex(hexDisp); 
				    ResultHex.setText("Hex: 0x" + hex);
				     
				    
				    int octDisp = Integer.parseInt(dec); 
				    String Oct = toOctal(octDisp); 
				    ResultOct.setText("Oct: " + Oct);
			    
			    }
			    }
			    
			    else if (hex == true)
			    {
			    	displayHex = ResultHex.getText();
			    	if (displayHex != null && displayHex.length() >= 0) {
				        displayHex = displayHex.substring(0, displayHex.length() - 1); 
			    	
				        ResultHex.setText(displayHex);
				    	String decDispl = ResultHex.getText();
						String dec = Integer.toString(hex2Dec(decDispl)); 
						Result.setText("Dec" + dec);
						
						int bin = Integer.parseInt(dec);
						String binary = binaryConverter(bin); 
						ResultBin.setText("Bin: " + binary);
						
						int octDisp = Integer.parseInt(dec);
						String Oct = toOctal(octDisp);
						ResultOct.setText("Oct: " + Oct); 
				            
			    }
			    }
			    
			    else if (oct == true)
			    {
			    	display = ResultOct.getText();
			    	if (display != null && display.length() >= 0) {
				        display = display.substring(0, display.length() - 1); 
				        ResultOct.setText(display);
						String decDispl = ResultOct.getText();
						int dec = oct2Dec(decDispl);
						String dec2 = (Integer.toString(dec));
						Result.setText("Dec: " + dec2);
						String binary = binaryConverter(dec); 
						ResultBin.setText("Bin: " + binary);
						
						String hex = dec2Hex(dec); 
						 ResultHex.setText("Hex: 0x" + hex);
			    }
			    }
			    
			    
		 
		}
	 }
	 
	 class ListentoA implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "A");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
			}
			
		}
		 
	 }
	 
	 class ListentoB implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "B");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
			}
			
		}
		 
	 }
	  
	 
	 class ListentoC implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "C");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
			}
			
		}
		 
	 }
	 
	 
	 
	 class ListentoD implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "D");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
			}
			
		}
		 
	 }
	 
	 class ListentoE implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "E");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
			}
			
		}
		 
	 }
	 
	 
	 
	 class ListentoF implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "F");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
			}
			
		}
		 
	 }
	 
	 
	 class ListentoOct implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (oct == false)
			{
				bin = false;
				dec = false;
				hex = false;
				oct = true;
				
			}
			else {
				oct = false;
				dec = true;
			}
			
		}
		 
	 }
	 class ListentoDec implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (dec == false)
			{
				bin = false;
				dec = true;
				hex = false;
				oct = false;
				
			}
			else {
				dec = false;
			}
			
		}
		 
	 }
	 
	 class ListentoHex implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (hex == false)
			{
				bin = false;
				dec = false;
				hex = true;
				oct = false;
				
			}
			else {
				hex = false;
				dec = true;
			}
			
		}
		 
	 }
	 
	 
	 class ListentoBin implements ActionListener
	 {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (bin == false)
			{
				bin = true;
				dec = false;
				hex = false;
				oct = false;
				
			}
			else {
				bin = false;
				dec = true;
			}
			
		}
		 
	 }
	 class ListenClear implements ActionListener
	 {

	 	@Override
	 	public void actionPerformed(ActionEvent e) {
	 		display = Result.getText();
	 		Result.setText("");
	 		ResultBin.setText("");
	 		ResultHex.setText("");
	 		ResultOct.setText("");
	 		addBool = false;
	 		subBool = false;
	 		divBool = false;
	 		mulBool = false; 
	 		modBool = false;
	 		TEMP = 0; 
	 		SolveTemp = 0; 
	 	}


	 }
	 
	class ListentoOne  implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true) {
			display = Result.getText();
			Result.setText(display + "1");
		    int binDisp = Integer.parseInt(Result.getText()); 
		    String bin = binaryConverter(binDisp); 
		    ResultBin.setText("Bin: " + bin);
		    
		    int hexDisp = Integer.parseInt(Result.getText()); 
		    String hex = dec2Hex(hexDisp); 
		    ResultHex.setText("Hex: 0x" + hex);
		     
		    
		    int octDisp = Integer.parseInt(Result.getText()); 
		    String Oct = toOctal(octDisp); 
		    ResultOct.setText("Oct: " + Oct);
			}
		
			else if(bin == true)
			{
				displayBin = ResultBin.getText();
				ResultBin.setText(displayBin + "1");
				String decDispl = ResultBin.getText(); 
				String dec = Integer.toString(bin2Dec(decDispl)); 
				Result.setText("Dec: " + dec);
				
			    int hexDisp = Integer.parseInt(dec); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			     
			    
			    int octDisp = Integer.parseInt(dec); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
				
			}
			
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "1");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "1");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
		    
		    Eqls = false;
		
	}
	}
	
	
	class ListentoTwo implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			Result.setText(display + "2");
			
			//Binary Output
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			  //Hex Output  
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "2");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "2");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false; 
			    
			    
		}
	}
	
	class ListentoThree implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			Result.setText(display + "3");
			//Binary output
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			//Hex output
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "3");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "3");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false; 
			    
			    
		}
	}
	class ListentoFour implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			Result.setText(display + "4");
			//Binary output
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			    //Hex output
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "4");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "4");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false; 
			    
		}
	}
	class ListentoFive implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			Result.setText(display + "5");
			//Binary output
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			    
			    //Hex output
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "5");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "5");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false; 
			    
		}
	}
	
	class ListentoSix implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			Result.setText(display + "6");
			
			//Binary output
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			    
			    //Hex output
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "6");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "6");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false; 
			    
		}
	}
	
	class ListentoSeven implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			Result.setText(display + "7");
			//Binary output
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			    //Hex output
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "7");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "7");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false;  
			    
		}
	}
	
	class ListentoEight implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			Result.setText(display + "8");
			//Binary output
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			    
			    //Hex output
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "8");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "8");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false; 
			    
		}
	}
	
	
	class ListentoNine implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			//Binary output
			Result.setText(display + "9");
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			    
			    //Hex output
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "9");
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec" + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "9");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false; 
			    
		}
	}
	
	class ListentoZero implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			if (dec == true)
			{
			display = Result.getText();
			Result.setText(display + "0");
			
			//Binary output
			   int binDisp = Integer.parseInt(Result.getText()); 
			    String bin = binaryConverter(binDisp); 
			    ResultBin.setText("Bin: " + bin);
			    //Hex output
			    int hexDisp = Integer.parseInt(Result.getText()); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			    
			    int octDisp = Integer.parseInt(Result.getText()); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
			}
			
			else if (bin == true)
			{
				displayBin = ResultBin.getText();
				ResultBin.setText(displayBin + "0");
				String decDispl = ResultBin.getText(); 
				String dec = Integer.toString(bin2Dec(decDispl)); 
				Result.setText("Dec: " + dec);
				
			    int hexDisp = Integer.parseInt(dec); 
			    String hex = dec2Hex(hexDisp); 
			    ResultHex.setText("Hex: 0x" + hex);
			     
			    
			    int octDisp = Integer.parseInt(dec); 
			    String Oct = toOctal(octDisp); 
			    ResultOct.setText("Oct: " + Oct);
				
			}
			else if (hex == true)
			{
				displayHex = ResultHex.getText();
				ResultHex.setText(displayHex + "1");
				
				String decDispl = ResultHex.getText();
				String dec = Integer.toString(hex2Dec(decDispl)); 
				Result.setText("Dec: " + dec);
				
				int bin = Integer.parseInt(dec);
				String binary = binaryConverter(bin); 
				ResultBin.setText("Bin: " + binary);
				
				int octDisp = Integer.parseInt(dec);
				String Oct = toOctal(octDisp);
				ResultOct.setText("Oct: " + Oct); 
				
				
			}
			
			else if (oct == true)
			{
				displayOct = ResultOct.getText();
				ResultOct.setText(displayOct + "0");
				
				String decDispl = ResultOct.getText();
				int dec = oct2Dec(decDispl);
				String dec2 = (Integer.toString(dec));
				Result.setText("Dec: " + dec2);
				String binary = binaryConverter(dec); 
				ResultBin.setText("Bin: " + binary);
				
				String hex = dec2Hex(dec); 
				 ResultHex.setText("Hex: 0x" + hex);
				
				
			}
			    Eqls = false; 
			    
		}
	}
	
	class ListentoDot implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (Eqls == true)
			{
				Result.setText("");
		 		ResultBin.setText("");
		 		ResultHex.setText("");
			}
			display=Result.getText();
			Result.setText(display + ".");
			
		    int octDisp = Integer.parseInt(Result.getText()); 
		    String Oct = toOctal(octDisp); 
		    ResultOct.setText("Oct: " + Oct);
			Eqls = false; 
			
			
		}
		
	}
	
	class ListentoAdd implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (dec == true)
			{
			TEMP = Double.parseDouble(Result.getText()); // Used to convert what is in result to a double
			Result.setText("");// Resets the Result display
			}
			else if(bin == true)
			{
				binTemp = ResultBin.getText();
				ResultBin.setText("");
			}
			
			else if (hex == true)
			{
				tempHex = ResultHex.getText();
				ResultHex.setText("");
			}
			else if (oct == true)
			{
				octTemp = ResultOct.getText(); 
				ResultOct.setText("");
			}
			addBool = true;	
		}
		
	}
	
	class ListentoSubtract implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (dec == true)
			{
			TEMP = Double.parseDouble(Result.getText());
			Result.setText("");
			}
			
			else if (bin == true)
			{
				
					binTemp = ResultBin.getText();
					ResultBin.setText("");
			}
			else if (hex == true)
			{
				tempHex = ResultHex.getText();
				ResultHex.setText("");
			}
			else if (oct == true)
			{
				octTemp = ResultOct.getText(); 
				ResultOct.setText("");
			}
			
			subBool = true; 
		}	
	}
	class ListentoMultiply implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
		if (dec == true)
		{
		TEMP = Double.parseDouble(Result.getText());
		Result.setText("");
		}
		else if (bin == true)
		{
			binTemp = ResultBin.getText();
			ResultBin.setText(""); 
		}
		else if (hex == true)
		{
			tempHex = ResultHex.getText();
			ResultHex.setText("");
		}
		else if (oct == true)
		{
			octTemp = ResultOct.getText(); 
			ResultOct.setText("");
		}
		
		mulBool = true;
		}
		}
	
	class ListentoDivide implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e)
		{
			if (dec == true)
			{
			TEMP = Double.parseDouble(Result.getText());
			Result.setText("");
			}
			else if (bin == true)
				{
					binTemp = ResultBin.getText();
					ResultBin.setText(""); 
				}
			else if (hex == true)
			{
				tempHex = ResultHex.getText();
				ResultHex.setText("");
			}
			else if (oct == true)
			{
				octTemp = ResultOct.getText(); 
				ResultOct.setText("");
			}
			
			divBool = true;
		}
	}
	
	class ListentoMOD implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (dec == true)
			{
			TEMP = Double.parseDouble(Result.getText());
			Result.setText("");
			}
			else if (bin == true)
				{
					binTemp = ResultBin.getText();
					ResultBin.setText(""); 
				}
			else if (hex == true)
			{
				tempHex = ResultHex.getText();
				ResultHex.setText("");
			}
			else if (oct == true)
			{
				octTemp = ResultOct.getText(); 
				ResultOct.setText("");
			}
			modBool = true; 
			
		}
		
	}
	
	class ListentoSignChange implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (dec == true)
			{
			Result.setText("-" + display);
			}
			Eqls = false; 
			
		}
		
	}
	
	class ListentoSolve implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			if (dec == true)
			{
			SolveTemp = Double.parseDouble(Result.getText());
			if(addBool == true)
			{
				SolveTemp = SolveTemp + TEMP;
			}
			else if (subBool==true)
			{
				SolveTemp = TEMP - SolveTemp;
			}
			else if (mulBool == true)
			{
				SolveTemp = SolveTemp * TEMP;
			}
			else if (divBool == true)
			{
				try {
				SolveTemp = TEMP / SolveTemp; 
				}
				catch(ArithmeticException SolveTemp)
				{
					System.out.println("Error Cannot divide by zero!");
				}
			}
			else if (modBool == true)
			{
				SolveTemp = TEMP%SolveTemp; 
			}
			int dec = (int) SolveTemp;
			if (dec >=0)
			{
			String bin = binaryConverter(dec); 
			String hex = dec2Hex(dec); 
			String Oct = toOctal(dec); 
			Result.setText(Double.toString(SolveTemp));
			ResultBin.setText(bin);
			ResultHex.setText(hex);
			ResultOct.setText(Oct);
			}
			
			else
			{
				Result.setText(Double.toString(SolveTemp));
				StringBuffer bin = new StringBuffer(binaryConverter(dec)); 
				ResultBin.setText(findTwoscomplement(bin));
				String hex = dec2Hex(dec); 
				ResultHex.setText(hex);
				String Oct = toOctal(dec);
				ResultOct.setText(Oct);
				
			}
			}
			else if(bin == true)
			{
				binSolveTemp = ResultBin.getText();
			 if (addBool == true)
			 {
				 String binAns =addBinary(binSolveTemp, binTemp); 
				 ResultBin.setText(binAns); 
				 int dec = bin2Dec(binAns);
				 String dec2 = (Integer.toString(dec));
				 Result.setText("Dec: " + dec2);
				 String hex = dec2Hex(dec);
				 ResultHex.setText("Hex: 0x" +hex);
				 String Oct = toOctal(dec);
				 ResultOct.setText("Oct: " + Oct); 
				 
			 }
			 else if(subBool == true)
			 {
				 String binAns =subBinary(binTemp, binSolveTemp); 
				 ResultBin.setText(binAns); 
				 int dec = bin2Dec(binAns);
				 String dec2 = (Integer.toString(dec));
				 Result.setText("Dec: " + dec2);
				 String hex = dec2Hex(dec);
				 ResultHex.setText("Hex: 0x" +hex);
				 String Oct = toOctal(dec);
				 ResultOct.setText("Oct: " + Oct); 
			 }
			 else if (mulBool ==  true)
			 {
				 String binAns = binMul(binSolveTemp, binTemp);
				 ResultBin.setText(binAns); 
				 int dec = bin2Dec(binAns);
				 String dec2 = (Integer.toString(dec));
				 Result.setText("Dec: " + dec2);
				 String hex = dec2Hex(dec);
				 ResultHex.setText("Hex: 0x" +hex);
				 String Oct = toOctal(dec);
				 ResultOct.setText("Oct: " + Oct);
				
			 }
			 else if (divBool == true)
			 {
				 String binAns = binDiv(binTemp, binSolveTemp);
				 ResultBin.setText(binAns); 
				 int dec = bin2Dec(binAns);
				 String dec2 = (Integer.toString(dec));
				 Result.setText("Dec: " + dec2);
				 String hex = dec2Hex(dec);
				 ResultHex.setText("Hex: 0x" +hex);
				 String Oct = toOctal(dec);
				 ResultOct.setText("Oct: " + Oct); 
			 }
			 else if (modBool == true)
			 {
				 String binAns = binMod(binTemp, binSolveTemp);
				 ResultBin.setText(binAns); 
				 int dec = bin2Dec(binAns);
				 String dec2 = (Integer.toString(dec));
				 Result.setText("Dec: " + dec2);
				 String hex = dec2Hex(dec);
				 ResultHex.setText("Hex: 0x" +hex);
				 String Oct = toOctal(dec);
				 ResultOct.setText("Oct: " + Oct); 
			 }
			}
			
			else if (hex == true)
			{
				SolveTemphex = ResultHex.getText();
				if(addBool == true)
				{
					String hexAns = hexAdd(tempHex, SolveTemphex); 
					ResultHex.setText(hexAns);
					int dec = hex2Dec(hexAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					String Oct = toOctal(dec);
					 ResultOct.setText("Oct: " + Oct); 
					
				}
				
				
				else if (subBool == true)
				{
					String hexAns = hexSub(tempHex, SolveTemphex); 
					ResultHex.setText(hexAns);
					int dec = hex2Dec(hexAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					String Oct = toOctal(dec);
					 ResultOct.setText("Oct: " + Oct); 
					
				}
				
				else if (mulBool == true)
				{
					String hexAns = hexMul(tempHex, SolveTemphex); 
					ResultHex.setText(hexAns);
					int dec = hex2Dec(hexAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					String Oct = toOctal(dec);
					 ResultOct.setText("Oct: " + Oct);
				}
				
				else if(divBool == true)
				{
					String hexAns = hexDiv(tempHex, SolveTemphex); 
					ResultHex.setText(hexAns);
					int dec = hex2Dec(hexAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					String Oct = toOctal(dec);
					 ResultOct.setText("Oct: " + Oct);
				}
				else if(modBool == true)
				{
					String hexAns = hexMod(tempHex, SolveTemphex); 
					ResultHex.setText(hexAns);
					int dec = hex2Dec(hexAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					String Oct = toOctal(dec);
					 ResultOct.setText("Oct: " + Oct);
				}
			}
			
			else if (oct == true)
			{
				octSolveTemp = ResultOct.getText();
				if(addBool == true)
				{
					String octAns = octAdd(octTemp, octSolveTemp); 
					ResultOct.setText(octAns);
					int dec = oct2Dec(octAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					 String hex = dec2Hex(dec);
					 ResultHex.setText("Hex: 0x" +hex);
					
				}
				
				
				if(subBool == true)
				{
					String octAns = octSub(octTemp, octSolveTemp); 
					ResultOct.setText(octAns);
					int dec = oct2Dec(octAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					 String hex = dec2Hex(dec);
					 ResultHex.setText("Hex: 0x" +hex);
					
				}
				
				
				if(mulBool == true)
				{
					String octAns = octMul(octTemp, octSolveTemp); 
					ResultOct.setText(octAns);
					int dec = oct2Dec(octAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					 String hex = dec2Hex(dec);
					 ResultHex.setText("Hex: 0x" +hex);
					
				}
				
				
				if(divBool == true)
				{
					String octAns = octDiv(octTemp, octSolveTemp); 
					ResultOct.setText(octAns);
					int dec = oct2Dec(octAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					 String hex = dec2Hex(dec);
					 ResultHex.setText("Hex: 0x" +hex);
					
				}
				
				if(modBool == true)
				{
					String octAns = octMod(octTemp, octSolveTemp); 
					ResultOct.setText(octAns);
					int dec = oct2Dec(octAns);
					String dec2 =(Integer.toString(dec)); 
					Result.setText("Dec: " + dec2);
					String bin = binaryConverter(dec);
					ResultBin.setText("Bin: " + bin);
					 String hex = dec2Hex(dec);
					 ResultHex.setText("Hex: 0x" +hex);
					
				}
			}
			addBool = false;
			subBool = false;
			mulBool = false;
			divBool = false;
			modBool = false; 
			Eqls = true; 
		
		}
		
	}
	
	
}







