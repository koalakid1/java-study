import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class C_E extends JFrame{
	
	private MyPanel panel = new MyPanel();
	
	class MyPanel extends JPanel{
		
		int vGap = 10, height = 20;
		int startX = 100, startY = 100;
		int Gap = 50;
		ImageIcon icon = new ImageIcon("images/banana.png");
		Image img = icon.getImage();
		@Override
		protected void paintComponent(Graphics g) {			
			super.paintComponent(g);
			g.setColor(Color.cyan);
			g.drawString("1/4분기", startX - 70 , startY + height * 3 / 4);
			g.fillRect(startX, startY, 50, height);
			g.setColor(Color.blue);
			g.drawString("2/4분기", startX - 70 , startY + height * 3 / 4 + (vGap + height) * 1);
			g.fillRect(startX, startY+height+vGap, 70, height);
			g.setColor(Color.green);
			g.drawString("3/4분기", startX - 70 , startY + height * 3 / 4 + (vGap + height) * 2);
			g.fillRect(startX, startY+2*(height + vGap), 100, height);
			g.setColor(Color.gray);
			g.drawString("4/4분기", startX - 70 , startY + height * 3 / 4 + (vGap + height) * 3);
			g.fillRect(startX, startY+3*(height + vGap), 150, height);
			
			g.setColor(Color.black);
			g.drawLine(startX + Gap * 0, startY * 4 , startX +Gap * 1 , startY * 4 - 50 );
			g.drawLine(startX + Gap * 1, startY * 4 - 50, startX + Gap * 2 , startY * 4 - 50 - 20 );
			g.drawLine(startX + Gap * 2, startY * 4 - 50 - 20, startX + Gap * 3 , startY * 4 - 50 - 20 - 30);
			g.drawLine(startX + Gap * 3, startY * 4 - 50 - 20 - 30, startX + Gap * 4 , startY * 4 - 50 - 20 - 30 - 50);
			g.drawLine(startX, startY*4, startX + Gap * 4, startY * 4);
			g.drawLine(startX, startY*4, startX, startY * 4 - 150);
			
			g.setColor(Color.cyan);
			g.fillArc(startX, startY * 9 / 2, 150, 150, 0, 48);
			g.setColor(Color.blue);
			g.fillArc(startX, startY * 9 / 2, 150, 150, 48, 68);
			g.setColor(Color.green);
			g.fillArc(startX, startY * 9 / 2, 150, 150, 116, 97);
			g.setColor(Color.gray);
			g.fillArc(startX, startY * 9 / 2, 150, 150, 213, 147);
			
			
			g.drawImage(img, 450, 30, this);
			g.drawImage(img, 0, 0,this.getWidth(),this.getHeight(), this);
			
			
			
		}
			
	}
	
	public C_E() {
		setTitle("차트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(1000,700);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new C_E();
	}
	
}
