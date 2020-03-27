package E_S;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class K_C_E extends JFrame {
	private JLabel la = new JLabel();
	
	public K_C_E() {
		setTitle("key code 예제 : f1키 : 초록색, % 키 : 노란색");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		
		c.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				la.setText(e.getKeyText(e.getKeyCode()));
				
				if (e.getKeyChar() == '%') {
					c.setBackground(Color.YELLOW);
				}else if (e.getKeyCode() == KeyEvent.VK_F1) {
					c.setBackground(Color.GREEN);
				}
			}
		});
		c.add(la);
		
		setSize(300,150);
		setVisible(true);
		
		c.setFocusable(true);
		c.requestFocus();
		
	}
	public static void main(String[] args) {
		new K_C_E();
	}
}
