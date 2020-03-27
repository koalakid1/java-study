package E_S;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class M_T_E extends JFrame{
	private final int flying_unit = 10;
	private JLabel la = new JLabel("HELLO");
	public M_T_E() {
		setTitle("상,하,좌,우 키를 이용하여 텍스트 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c =getContentPane();
		c.setLayout(null);
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				int keycode = e.getKeyCode();
				
				switch (keycode) {
				case KeyEvent.VK_UP:
					la.setLocation(la.getX(), la.getY()-flying_unit);
					c.setBackground(Color.YELLOW);
					break;
				case KeyEvent.VK_DOWN:
					la.setLocation(la.getX(), la.getY()+flying_unit); 
					c.setBackground(Color.RED);
					break;
				case KeyEvent.VK_LEFT:
					la.setLocation(la.getX()-flying_unit, la.getY());
					c.setBackground(Color.GREEN);
					break;
				case KeyEvent.VK_RIGHT:
					la.setLocation(la.getX()+flying_unit, la.getY()); 
					c.setBackground(Color.BLUE);
					break;

				}
			}
		});
		la.setLocation(50, 50);
		la.setSize(100, 20);
		c.add(la);
		
		setSize(300,300);
		setVisible(true);
		c.setFocusable(true);
		c.requestFocus();
		
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Component com = (Component) e.getSource();
				com.setFocusable(true);
				com.requestFocus();
			}
		});
	}
	
	public static void main(String[] args) {
		new M_T_E();
	}
}
