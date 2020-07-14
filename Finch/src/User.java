import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class User {


	public static void main(String[] args) {
		
		//if(myFinch.isFinchLevel() == true  )
		while (isFinchLevel() == true)
		{
		//Graphical user interface for the user input 
		//obtain user input from JOption dialog for the length 
		String length = 
				JOptionPane.showInputDialog("Length of the zigzag?(cm) between 20cm and 80cm");
		  
		//convert String inputs to int values for the use of calculation
		int intLen = Integer.parseInt(length);
		//Validation rules for the input 
		while(intLen<20 || intLen>80)
			try {
				intLen = Integer.parseInt(JOptionPane.showInputDialog(null, "Enter the length of line 'must be between(20cm to 80 cm)"));
				}
			catch (NumberFormatException e) 
			{
			System.out.println("The exception is: " + e);
			JOptionPane.showMessageDialog(null, "Only numeric values accepted", null, JOptionPane.ERROR_MESSAGE);
			}
		
		//obtain user input from JOption dialog for the number 
		String number = 
				JOptionPane.showInputDialog("How many zigzags?(even number from 2-10)");
		// convert String inputs to int values for the use of calculation
		int intNum = Integer.parseInt(number);
		//Validation rules for the input
		while((intNum<2 || intNum>10) || (intNum % 2 != 0)) {
			try {
				intNum = Integer.parseInt(JOptionPane.showInputDialog(null, "How many zigzags?(even number from 2-10)"));
				}
			catch (NumberFormatException e)
			{
				System.out.println("The exception is: " + e);
				JOptionPane.showMessageDialog(null, "Only numeric values accepted", null, JOptionPane.ERROR_MESSAGE);
				}
		}
		
		//display results in JOptionPane message dialog
		JOptionPane.showMessageDialog(null, "The finch will move for " + intLen + "cm " + 
		"and for " + intNum + " section", "Movment", JOptionPane.PLAIN_MESSAGE);
		}
		//System.out.print("The length is: " + length + "cm");
			
		//Constructor to pass the arguments to the ZigZag class
			ZigZag movement = new ZigZag(intLen,intNum); 
		
		//This will be the length * by the motor speed 
		//The motor speed times 0.11 velocity against motor speed
			int time = (intLen * 85); 
			
		//Create a random integer between (100-255) for the speed	
			int min = 100;
			int max = 255;
			Random rand = new Random();
			int RandS = rand.nextInt(max) - min;
		    int Linespeed = RandS;
		   
		//for loop for the finch to draw the zigzag line based on the input 
		//when i is less than the user input, increament i
		//if i is an even number call line1 method from the ZigZag class
		//if i is an odd number call line2 method from the ZigZag class
		//when the loop is done rotate the finch
			int i;
			for(i=0; i < intNum; i++) 
			{
				if(i%2 == 0) //if "i" an even number
				{
					movement.line1(time, Linespeed);
				}else{
					movement.line2(time, Linespeed);
    				}
			}
			movement.FullRotation(time);
		//for loop for the finch to retrace its movement
	    // it repeats the same process as the previous loop 
		//Just the methods are swapped 
			for(i=intNum; i > 0; i--)
			{
				if(i%2 == 0) //if "i" an even number
				{
					movement.line2(time, Linespeed);
				}else{
					movement.line1(time, Linespeed);
    				}
			}
			movement.FullRotation(time);
			
			
    //Calculations for the user log
			int LineDistance = intLen * intNum;	//calculate the line distance
			double travDistance = (Math.sqrt(Math.pow(intLen, 2) + Math.pow(intLen, 2))) * intNum/2;	//calculate distance from start to END of the zigzag line
			double Velocity = (Linespeed * 11)/100;
			double Speed = intNum / Velocity; 
			
	//Print the calculations into a text file		
			String filename ="Output.txt"; //Name of the text file 
			try {
				PrintWriter outputStream = new PrintWriter(filename);
				outputStream.println("Straight line distance: " + LineDistance+ "cm"); //Stores in the RAM first //calculate the line distance
				outputStream.println("Length of the traversed path(start to end of the zigzag): " + travDistance +"cm"); //calculate the distance from start to end of zigzag line");
				outputStream.close();//Push the data to the file
				System.out.println("Done");
			}catch(FileNotFoundException e) {
				e.printStackTrace();
				}
			JOptionPane.showMessageDialog(null, "The line distance is: " + LineDistance + "cm\n" + 
				"distance from start to END of the zigzag line: " + travDistance + "\n" + 
				"The speed is: " + Speed + "\n" + "Speed" + Linespeed, "Output", JOptionPane.PLAIN_MESSAGE);
			}  
	
		}