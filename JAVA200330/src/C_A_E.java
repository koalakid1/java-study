import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class C_A_E extends JFrame{
	
	private String[] fruits = {"apple","banana","kiwi","manggo"};
	private ImageIcon[] images = {
			new ImageIcon("images/apple.png"),
			new ImageIcon("images/banana.png"),
			new ImageIcon("images/kiwi.png"),
			new ImageIcon("images/mango.png")
	};
	private JLabel imgLabel = new JLabel(images[0]);
	private JComboBox<String> strCombo = new JComboBox<String>(fruits);
	
	public C_A_E() {
		setTitle("콤보박스 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(strCombo);
		c.add(imgLabel);
		
		strCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> cb = (JComboBox<String>)e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
			}
		});
	
		setSize(300,250);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new C_A_E();
	}
	
}
