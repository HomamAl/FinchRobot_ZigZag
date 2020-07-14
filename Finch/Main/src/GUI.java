import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI {
	private static JFrame frame;
	private static JPanel panel;
	private static JButton button1, button2, button3, button4, button5, button6;
	
	public static void main(String[] args) {
		frame = new JFrame("Finch Robot tasks");
		frame.setVisible(true);
		frame.setSize(300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		panel = new JPanel();
		panel.setBackground(Color.GRAY);
		button1 = new JButton("Task 1 : FollowLight");
		button2 = new JButton("Task 2 : Draw Shape");
		button3 = new JButton("Task 3 : Navigate    ");
		button4 = new JButton("Task 4 : Zigzag     ");
		button5 = new JButton("Task 5 : Follow Object ");
		button6 = new JButton("Task 6 : Dance");
		
		button1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				light.FollowLight.main(args);;
				
			}
		});
		button2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				shape.Draw_Shapes.main(args);
			}
		});
		button3.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				navigate.Navigate.main(args);;
			}
		});
		button4.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				zigzag.Zigzag.main(args);
			}
		});
		button5.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				followObject.FollowObject.main(args);
			}
		});
		button6.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
	        	dance.Dance.main(args);
			}
		});
		
		panel.add(button1);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		panel.add(button5);
		panel.add(button6);
		frame.add(panel);
	}
}