package haksa;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class haksa extends JFrame{
	JTextField tfid = null ;
	JTextField tfname = null ;
	JTextField tfdepartment = null;
	JTextField tfaddress = null;
	JTextArea taList = null;
	
	JButton btnlist = null;
	JButton btninsert = null;
	JButton btnupdate = null;
	JButton btndelete = null;
	
	
	
	public haksa() {
		setTitle("�л����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("�й�"));
		tfid = new JTextField(20);
		c.add(tfid);
		
		c.add(new JLabel("�̸�"));
		tfname = new JTextField(20);
		c.add(tfname);
		
		c.add(new JLabel("�а�"));
		tfdepartment = new JTextField(20);
		c.add(tfdepartment);
		
		c.add(new JLabel("�ּ�"));
		tfaddress = new JTextField(20);
		c.add(tfaddress);
		
		taList = new JTextArea(10,23);
		c.add(new JScrollPane(taList));
		
		btnlist = new JButton("���");
		btninsert = new JButton("�Է�");
		btnupdate = new JButton("����");
		btndelete = new JButton("����");
		
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?","����", JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					
					//���� ó��. db �����ؼ� ����
					System.out.println("����ó��....");
					
					//����ó���Ϸ� �޼��� ���
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.","�˸�",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		
		c.add(btnlist);
		c.add(btninsert);
		c.add(btnupdate);
		c.add(btndelete);
		
		setSize(300,400);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new haksa();
	}
}
