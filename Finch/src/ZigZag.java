import java.awt.Color; //import the colours for the LED
import edu.cmu.ri.createlab.terk.robot.finch.Finch; //The finch functions library

class ZigZag{ //Class to define the finch functions
	
	static int a,b;//a = length ,  b = number, so that the arguments on the movmnt object will be assigned to the integers
	private static Finch myFinch = new Finch(); //finch object
	static Color green = Color.green, red = Color.red, blue = Color.blue, pink = Color.pink ; //LED different colours
	static int buzzer1 = 4000, buzzer2=8000; //buzzer sound
	//int time = (a * 85); //The motor speed times 0.11 velocity against motor speed

	
			
	public ZigZag(int x, int y) //Constructor to receive the arguments from the User class 
	{
		x = a; //Length
		y = b; //Number
	}
	
	//The method arguments are going to be called from the ZigZag constructor in the User class
	public static void line1(int time,  int Linespeed) {
		/*This method will contain:
		*LED colours
		*buzzer sound
		*Wheels velocity for movement
		*wheels velocity for rotation 
		*/
		myFinch.setLED(green); //Set the LED colour
		myFinch.buzz(buzzer1, time); 
		myFinch.setWheelVelocities(Linespeed, Linespeed, time);
		myFinch.setWheelVelocities(-150, 150, 600);
	}
	
	//The method arguments are going to be called from the ZigZag constructor in the User class
	public static void line2(int time, int Linespeed) {	
		/*This method will contain:
		*LED colours
		*buzzer sound
		*Wheels velocity for movement
		*wheels velocity for rotation 
		*/
		myFinch.setLED(red);
		myFinch.buzz(buzzer2, time);
		myFinch.setWheelVelocities(Linespeed, Linespeed, time);
		myFinch.setWheelVelocities(150, -150, 600);
	}
	
	//The finch wheels rotation based on the duration of the finch movement 
	public static void FullRotation(int time)
	{
		myFinch.setWheelVelocities(100, -100, 750);
	}
	
	//Halt the program
	public static void Stop()
    {
		myFinch.setLED(blue);
    	myFinch.quit();
    }
}