import java.awt.*;

import javax.swing.*;

public class G_D_S_E extends JFrame{
	
	private MyPanel panel = new MyPanel();
	
	public G_D_S_E() {
		setTitle("drawString 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(panel);
		setSize(250,200);
		setVisible(true);
		
	}
	
	   
	class MyPanel extends JPanel{
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(Color.red);
			g.drawLine(65, 30, 145, 40);
			
			g.setColor(Color.blue);
			g.drawString("자바는 재밌다.", 30, 30);
			
			g.setColor(new Color(255,0,0));
			g.setFont(new Font("Arial",Font.ITALIC,30));
			g.drawString("JAVA is interesting", 60, 60);
			
			g.setColor(new Color(0x00ff00ff));
			for (int i = 0; i < 5; i++) {
				g.setFont(new Font("Jokerman",Font.ITALIC, i*10));
				g.drawString("This much!!", 30, 60+i*60);
			}
		}
	
	}
	
	public static void main(String[] args) {
		new G_D_S_E();
	}
	
}
