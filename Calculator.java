package calculator;
import java.util.Scanner;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.BorderFactory;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
	
		JFrame frame;
		JTextField textfield;
		JButton[] numberButtons = new JButton[10];
		JButton[] functionButtons = new JButton[11];
		JButton addButton, subtractButton, multiplyButton, divideButton;
		JButton decButton, equalButton, delButton, clrButton, negButton, percButton, sqrtButton;
		JPanel panel;
		
		Font myFont = new Font("Times New Roman", Font.BOLD, 30);
		Font myFont2 = new Font("Times New Roman", Font.BOLD, 25);
		char operator;
	    double numb1 = 0, numb2 = 0, result = 0;

		Calculator(){
			frame = new JFrame("Calculator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setSize(440, 550);
			frame.setLayout(null);
			frame.getContentPane().setBackground(new Color(255, 204, 51));
			
			
			textfield = new JTextField();
			textfield.setBounds(50, 25, 300, 50);
			textfield.setFont(myFont);
			textfield.setEditable(false);
			textfield.setBackground(Color.GRAY);
			textfield.setHorizontalAlignment(JTextField.RIGHT);
			textfield.getSelectedText();
			//textfield.setText(textfield.getText().concat(String.valueOf(0)));
			
			//Function Buttons and their signs
			addButton = new JButton("+");
			subtractButton = new JButton("-");
			multiplyButton = new JButton("*");
			divideButton = new JButton("/");
			decButton = new JButton(".");
			equalButton = new JButton("=");
			delButton = new JButton("Del");
			clrButton = new JButton("-C-");
			negButton = new JButton("+/-");
			percButton = new JButton("%");
			sqrtButton = new JButton("r");
			//Array of the function buttons
			functionButtons[0] = addButton;
			functionButtons[1] = subtractButton;
			functionButtons[2] = multiplyButton;
			functionButtons[3] = divideButton;
			functionButtons[4] = decButton;
			functionButtons[5] = equalButton;
			functionButtons[6] = delButton;
			functionButtons[7] = clrButton;
			functionButtons[8] = negButton;
			functionButtons[9] = percButton;
			functionButtons[10] = sqrtButton;
			//Function Button Colors
			addButton.setBackground(Color.RED);
			subtractButton.setBackground(Color.MAGENTA);
			multiplyButton.setBackground(Color.GREEN);
			divideButton.setBackground(Color.YELLOW);
			equalButton.setBackground(Color.WHITE);
			negButton.setBackground(Color.PINK);
			decButton.setBackground(new Color(51, 204, 255));
			delButton.setBackground(Color.LIGHT_GRAY );
			clrButton.setBackground(new Color(255, 102, 102));
			percButton.setBackground(new Color(0,153, 0));
			sqrtButton.setBackground(Color.lightGray);
			for(int i = 0; i < 10; i++ ) {
				
				functionButtons[i].addActionListener(this);
				functionButtons[i].setFont(myFont2);
				functionButtons[i].setFocusable(false);
				
			}
			
			for(int i = 0; i < 10; i++ ) {
				
				numberButtons[i] = new JButton(String.valueOf(i)); 
				
				numberButtons[i].addActionListener(this);
				numberButtons[i].setFont(myFont);
				numberButtons[i].setFocusable(false);
				numberButtons[i].setBackground(Color.CYAN);
				
			}
			
			negButton.setBounds(50, 430, 75, 50);
			percButton.setBounds(125, 430, 75, 50);
			delButton.setBounds(200, 430, 75, 50);
			clrButton.setBounds(275, 430, 75, 50);
			//sqrtButton.setBounds(250, 430, 75, 50);
			Border blackline = BorderFactory.createLineBorder(Color.DARK_GRAY, 8);
			
			panel = new JPanel();
			panel.setBounds(50, 100, 300, 300);
			panel.setLayout(new GridLayout(5,4,8,8));
			panel.setBorder(blackline);
			panel.setBackground(Color.DARK_GRAY);
			
			panel.add(numberButtons[1]);
			panel.add(numberButtons[2]);
			panel.add(numberButtons[3]);
			panel.add(addButton);
			panel.add(numberButtons[4]);
			panel.add(numberButtons[5]);
			panel.add(numberButtons[6]);
			panel.add(subtractButton);
			panel.add(numberButtons[7]);
			panel.add(numberButtons[8]);
			panel.add(numberButtons[9]);
			panel.add(multiplyButton);
			panel.add(decButton);
			panel.add(numberButtons[0]);
			panel.add(equalButton);
			panel.add(divideButton);
			panel.add(sqrtButton);
		
			
			frame.add(panel);
			frame.add(negButton);
			frame.add(delButton);
			frame.add(clrButton);
			frame.add(textfield);
			frame.add(percButton);
			
			frame.setVisible(true);
			
		}
	
	  public static void main(String[] args) {

		
		Calculator calc =  new Calculator();
	    char operator;
	    double number1, number2, result;

	    // create an object of Scanner class
	    Scanner input = new Scanner(System.in);

	    // ask users to enter operator
	    System.out.println("User Input: \n");
	    System.out.println(calc);
	    operator = input.next().charAt(0);

	    // ask users to enter numbers
	    System.out.println("Enter first number");
	    number1 = input.nextDouble();

	    System.out.println("Enter second number");
	    number2 = input.nextDouble();

	    switch (operator) {

	      // performs addition between numbers
	      case '+':
	        result = number1 + number2;
	        System.out.println(number1 + " + " + number2 + " = " + result);
	        break;

	      // performs subtraction between numbers
	      case '-':
	        result = number1 - number2;
	        System.out.println(number1 + " - " + number2 + " = " + result);
	        break;

	      // performs multiplication between numbers
	      case '*':
	        result = number1 * number2;
	        System.out.println(number1 + " * " + number2 + " = " + result);
	        break;

	      // performs division between numbers
	      case '/':
	        result = number1 / number2;
	        System.out.println(number1 + " / " + number2 + " = " + result);
	        break;
	      
	     
	    	  
	      default:
	        System.out.println("Invalid operator!");
	        break;
	    }

	    input.close();
	  }
 
	@Override
	public void actionPerformed(ActionEvent e) {
		//Making the calculator buttons functionable
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
			
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			numb1 = Double.parseDouble(textfield.getText());
			operator = '+';
			textfield.setText("");
		}
		if(e.getSource() == subtractButton) {
			numb1 = Double.parseDouble(textfield.getText());
			operator = '-';
			textfield.setText("");
		}
		if(e.getSource() == multiplyButton) {
			numb1 = Double.parseDouble(textfield.getText());
			operator = '*';
			textfield.setText("");
		}
		if(e.getSource() == divideButton) {
			numb1 = Double.parseDouble(textfield.getText());
			operator = '/';
			textfield.setText("");
		}
		
		if(e.getSource() == equalButton) {
			numb2 = Double.parseDouble(textfield.getText());
			
			switch (operator) {

		      // performs addition between numbers
		      case '+':
		        result = numb1 + numb2;
		        System.out.println(numb1 + " + " + numb2 + " = " + result);
		        break;

		      // performs subtraction between numbers
		      case '-':
		        result = numb1 - numb2;
		        System.out.println(numb1 + " - " + numb2 + " = " + result);
		        break;

		      // performs multiplication between numbers
		      case '*':
		        result = numb1 * numb2;
		        System.out.println(numb1 + " * " + numb2 + " = " + result);
		        break;

		      // performs division between numbers
		      case '/':
		        result = numb1 / numb2;
		        System.out.println(numb1 + " / " + numb2 + " = " + result);
		        break;
		    
	    	  
		      default:
		        System.out.println("Invalid operator!");
		        break;
		    }
			textfield.setText(String.valueOf(result));
			numb1 = result;
		}
		// percentage of a number
		if(e.getSource() == percButton ) {
			numb1 = Double.parseDouble(textfield.getText());
			operator = '%'; 
			result = numb1 / 100;
			textfield.setText(String.valueOf(result));  
		      
	    	 
	    	//  System.out.println(numb1 + " modular " + numb2 + " = " + result);
	    	
		}
		if(e.getSource()==clrButton) {
			textfield.setText("");
			numb1 = numb2 = result = 0;
			//operator = "";
		}
		if(e.getSource()==delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		if(e.getSource()==negButton) {
			double temp = Double.parseDouble(textfield.getText());
			
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
		if(e.getSource()==sqrtButton) {
			
			numb1 = Double.parseDouble(textfield.getText());
			result = Math.sqrt(numb1);
			textfield.setText(String.valueOf(result)); 
		}
	}
	}

