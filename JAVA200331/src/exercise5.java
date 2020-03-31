import java.awt.Container;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class exercise5 extends JFrame{
	int[] arcangle = {30, 40,120,60};
	class drawchart extends JPanel{
	
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int start = 0;

			
			
			for (int i = 0; i < 4; i++) {
				g.fillArc(200,200,200,200,start,arcangle[i]);
				
				start += arcangle[i];
				
			}

		}
		
	}
	public exercise5() {
		setTitle("123");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.add(new drawchart());
		setSize(500,500);
		setVisible(true);// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		new exercise5();
	}
}
