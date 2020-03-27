import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class L_C_1 extends JFrame{
	
	public L_C_1() {
		setTitle("∑π¿Ã∫Ì");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		ImageIcon a = new ImageIcon("images/icon.png");
		JLabel label = new JLabel(a);
		
		c.add(label);
		
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new L_C_1();
	}
	
}
