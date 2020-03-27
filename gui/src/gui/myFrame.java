package gui;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class myFrame extends JFrame {
	public myFrame() {
		
		setTitle("FlowLayout Sample");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout(FlowLayout.LEFT,50,10));
		c.setBackground(Color.MAGENTA);
		
		c.add(new JLabel(" �̸�"));
		c.add(new JTextField("",10));
		c.add(new JLabel(" �й�"));
		c.add(new JTextField("",10));
		c.add(new JLabel(" �а�"));
		c.add(new JTextField("",10));
		c.add(new JLabel(" ����"));
		c.add(new JTextField("",10));
		setSize(300, 200);
		setVisible(true);

		
	}
	
	public static void main(String[] args) {
		new myFrame();
	}
}
