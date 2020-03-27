package E_S;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class L_C extends JFrame {
	
	public L_C() {
		setTitle("레이블 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textlabel = new JLabel("사랑합니다.");
		
		ImageIcon normalicon = new ImageIcon("img/icon.png");
		JLabel label = new JLabel(normalicon);
		
		c.add(textlabel);
		c.add(label);
		setSize(1000,1000);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new L_C();
	}
	
}
