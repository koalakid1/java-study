package haksa;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyButton extends JButton{
	
	public MyButton(String text) {
		super(text);
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawRect(2, 2, getWidth()-5, getHeight()-5);
	}
	
}

public class myFrame extends JFrame{
	
	public myFrame() {
		setTitle("학사관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setBackground(Color.orange);
		c.setLayout(new FlowLayout(FlowLayout.LEFT, 30, 40));
		c.add(new MyButton("OK"));
		c.add(new MyButton("Cancel"));
		c.add(new MyButton("Ignore"));
		
		c.add(new MyButton("커스텀버튼"));
		
		setSize(300,300);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new myFrame();
	}
	
}
