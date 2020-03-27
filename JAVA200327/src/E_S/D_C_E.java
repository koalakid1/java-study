package E_S;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;

public class D_C_E extends JFrame {
	public D_C_E() {
		setTitle("Click and Double Click ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2) {
					
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					Component c = (Component) e.getSource();
					c.setBackground(new Color(r,g,b));
					
				}
			}
		});
		setSize(300,200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new D_C_E();
	}
}
