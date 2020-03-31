package haksa;
import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
		setTitle("학사관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("학번"));
		tfid = new JTextField(20);
		c.add(tfid);
		
		c.add(new JLabel("이름"));
		tfname = new JTextField(20);
		c.add(tfname);
		
		c.add(new JLabel("학과"));
		tfdepartment = new JTextField(20);
		c.add(tfdepartment);
		
		c.add(new JLabel("주소"));
		tfaddress = new JTextField(20);
		c.add(tfaddress);
		
		taList = new JTextArea(10,20);
		c.add(new JScrollPane(taList));
		
		btnlist = new JButton("목록");
		btninsert = new JButton("입력");
		btnupdate = new JButton("수정");
		btndelete = new JButton("삭제");
		
		c.add(btnlist);
		c.add(btninsert);
		c.add(btnupdate);
		c.add(btndelete);
		
		setSize(300,300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new haksa();
	}
}
