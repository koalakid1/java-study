import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyDialog extends JDialog{
	
	private JTextField id = new JTextField(10);
	private JTextField pw = new JTextField(10);
	private JButton loginButton = new JButton("login");
	
	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		this.setLayout(new FlowLayout());
		this.add(id);
		this.add(pw);
		this.add(loginButton);
		this.setSize(120,130);
		
		loginButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//로그인 처리. db연동. id, pw 일치 여부 확인
				System.out.println("로그인처리...");
			}
		});
	}
	
}

public class DE extends JFrame{
	
	private MyDialog dialog;
	
	public DE() {
		super("학사관리");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btn = new JButton("로그인");
		
		dialog = new MyDialog(this, "로그인");
		
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				
			}
		});
		
		this.getContentPane().add(btn);
		
		this.setSize(250,200);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new DE();
	}
}
