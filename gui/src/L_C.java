

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class L_C extends JFrame {
	
	public L_C() {
		setTitle("���̺� ����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textlabel = new JLabel("����մϴ�.");
		
		ImageIcon normalicon = new ImageIcon("img/ICON2.png");
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
