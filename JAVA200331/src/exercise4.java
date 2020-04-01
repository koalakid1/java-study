import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class exercise4 extends JFrame{
	
	
	Color[] color = {Color.RED, Color.BLUE, Color.MAGENTA, Color.ORANGE};
	JTextField[] tf  = new JTextField[4];
	String[] itemName = {"apple", "banana", "kiwi", "mango"};
	drawchart drawchart = new drawchart();
	
	int[] data = {0,0,0,0};
	int[] arcangle = {0,0,0,0};
	public exercise4() {
		setTitle("과일 개수 원차트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		Panel panel = new Panel();
		panel.setBackground(Color.gray);
		for (int i = 0; i < 4; i++) {
			
			tf[i] = new JTextField("0",5);
			panel.add(new JLabel(itemName[i]),BorderLayout.NORTH);
			panel.add(tf[i],BorderLayout.NORTH);
		}
		JButton btn = new JButton("그래프 그리기");

		panel.add(btn);

		c.add(panel,BorderLayout.NORTH);
		btn.addActionListener(new drawaction(tf));
		c.add(new JLabel(itemName[0]));
		c.add(drawchart,BorderLayout.CENTER);
		
		setSize(570,400);
		setVisible(true);

	}
	
	class drawaction implements ActionListener{
		JTextField[] tf;
		
		drawaction(JTextField[] tf) {
			this.tf = tf;// TODO Auto-generated constructor stub
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {


			int sum = 0;
			try {
			for (int i = 0; i < 4; i++) {
				data[i] = Integer.parseInt(tf[i].getText());
				sum += data[i];
			}
			for (int i = 0; i < 4; i++) {
				arcangle[i] = (int)Math.round((double)data[i]/(double)sum *360);
			}
			
			drawchart.repaint();
			}
			catch (NumberFormatException n) {
			}
		}
	
		
	}
	
	class drawchart extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int start = 0;
			
			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.drawString(itemName[i]+""+Math.round(arcangle[i]*100/360)+"%", 50+i*100,20);
			}
			
			for (int i = 0; i < 4; i++) {
				g.setColor(color[i]);
				g.fillArc(200,100,200,200,start,arcangle[i]);
				
				start += arcangle[i];
				
			}

		}
		
	}
	
	public static void main(String[] args) {
		new exercise4();
	}
}
