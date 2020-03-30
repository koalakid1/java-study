import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class exercise extends JFrame {
	
	private MyPanel panel = new MyPanel();
	
	public exercise() {
		setTitle("차트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		
		setSize(1000,700);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		
		int vGap = 50, weight = 20;
		int startX = 150, startY = 100;
		int Gap = 50;
		ImageIcon icon = new ImageIcon("images/banana.png");
		Image img = icon.getImage();
		@Override
		protected void paintComponent(Graphics g) {			
			super.paintComponent(g);
			g.setColor(Color.cyan);
			g.drawString("1/4분기", startX - 10, startY - 5 );
			g.fillRect(startX, startY, weight, 50);
			g.drawString("50", startX + 5, startY + 60 );
			g.setColor(Color.blue);
			g.drawString("2/4분기", startX + 40 , startY - 5);
			g.fillRect(startX + vGap, startY, weight, 70);
			g.drawString("70", startX + 55 , startY + 80);
			g.setColor(Color.green);
			g.drawString("3/4분기", startX + 90, startY - 5);
			g.fillRect(startX + vGap * 2 , startY,weight, 100);
			g.drawString("100", startX + 100, startY + 110);
			g.setColor(Color.gray);
			g.drawString("4/4분기", startX + 140, startY - 5 );
			g.fillRect(startX + vGap * 3, startY, weight, 140 );
			g.drawString("140", startX + 150, startY + 150 );
			
			g.setColor(Color.black);
			g.drawLine(startX - 50, startY, startX + vGap * 5, startY );
			g.drawLine(startX - 50, startY, startX - 50, startY * 3);
			g.drawString("(단위 : 억)", startX - 120, startY + 20 );
			
			g.drawLine(startX + Gap * 0, startY * 5 , startX +Gap * 1 , startY * 5 - 50 );
			g.drawString("1/4분기", startX + 30 , startY * 5 + 20 );
			g.drawString("50", startX + 45 , startY * 5  - 50 );
			g.drawLine(startX + Gap * 1, startY * 5 - 50, startX + Gap * 2 , startY * 5 - 70 );
			g.drawString("2/4분기", startX + 80 , startY * 5 + 20 );
			g.drawString("70", startX + 95 , startY * 5  - 70 );
			g.drawLine(startX + Gap * 2, startY * 5 - 70, startX + Gap * 3 , startY * 5 - 100);
			g.drawString("3/4분기", startX + 130 , startY * 5 + 20 );
			g.drawString("100", startX + 145 , startY * 5  - 100 );
			g.drawLine(startX + Gap * 3, startY * 5 - 100, startX + Gap * 4 , startY *5 - 140);
			g.drawString("4/4분기", startX + 180 , startY * 5 + 20 );
			g.drawString("140", startX + 195 , startY * 5  - 140 );
			g.drawLine(startX, startY*5, startX + Gap * 5, startY * 5);
			g.drawLine(startX, startY*5, startX, startY * 5 - 200);
			
			g.drawString("(단위 : 억)", startX -60, startY *5 - 180 );
			
			
			
		}
			
	}
	
	public static void main(String[] args) {
		new exercise();
	}
	
}
