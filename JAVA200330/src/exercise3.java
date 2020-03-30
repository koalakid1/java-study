import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class exercise3 extends JFrame{
	
	Container c;
	JTextField[] tf  = new JTextField[4];
	
	int[] data = {0,0,0,0};
	int[] arcAngle = {0,0,0,0};
	
	Color[] color ={Color.RED, Color.BLUE,Color.MAGENTA, Color.ORANGE};
	String[] itemName = {"apple", "banana", "kiwi", "mango"};
	
	drawchart drawchart = new drawchart();
	
	public exercise3() {
		setTitle("¿¹Á¦3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c = getContentPane();
		c.setLayout(new FlowLayout());
		
		for (int i = 0; i < tf.length; i++) {
			tf[i] = new JTextField("0",5);
		

			c.add(new JLabel(itemName[i]),BorderLayout.NORTH);
			c.add(tf[i],BorderLayout.NORTH);
			
			tf[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					JTextField t = (JTextField) e.getSource();
					int n = Integer.parseInt(t.getText());
					drawchart = new drawchart();
				}
			});
		}
		

		
		c.add(drawchart);
		
		
		setSize(550,300);
		setVisible(true);
	}
	
	class drawchart extends JPanel{
		
		@Override
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
			
			int sum = 0;
			for (int i = 0; i < tf.length; i++) {
				data[i] = Integer.parseInt(tf[i].getText());
				sum += data[i];
			}
			for (int i = 0; i < data.length; i++) {
				arcAngle[i] = (int)Math.round((double)data[i]/(double)sum *360);
			}
			
			int startAngle = 0;
			
			for (int i = 0; i < arcAngle.length; i++) {
				g.setColor(color[i]);
				g.drawString(itemName[i]+" "+Math.round(arcAngle[i]*100/360), 50+i*100, 20);
			}
			
			for (int i = 0; i < arcAngle.length; i++) {
				g.setColor(color[i]);
				g.fillArc(150, 50, 200, 200, startAngle, arcAngle[i]);
				startAngle += arcAngle[i];
			}
		}
		
	}
	
	public static void main(String[] args) {
		new exercise3();
	}
}
