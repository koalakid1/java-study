import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class exercise6 extends JFrame{
	
	public exercise6() {
		setTitle("과일 차트");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();

		
//		DrawPanel drawpanel = new DrawPanel();
//		
//		c.add(drawpanel,BorderLayout.CENTER);
//		
		JPanel panel = new JPanel();
		
		JTextField txt1 = new JTextField(3);
		JTextField txt2 = new JTextField(3);
		JTextField txt3 = new JTextField(3);
		JTextField txt4 = new JTextField(3);
		
		JButton btn = new JButton("그래프 그리기");
		
		panel.setBackground(Color.GRAY);
		
		panel.add(new JLabel("사과"));
		panel.add(txt1);
		panel.add(new JLabel("바나나"));
		panel.add(txt2);
		panel.add(new JLabel("키위"));
		panel.add(txt3);
		panel.add(new JLabel("망고"));
		panel.add(txt4);
		panel.add(btn);
		
		c.add(panel,BorderLayout.SOUTH);
		
		btn.addActionListener(new DrawAction(txt1,txt2,txt3,txt4,));
		setSize(500,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new exercise6();
	}
	
}
