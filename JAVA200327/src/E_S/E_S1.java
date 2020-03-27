package E_S;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

class MyAction implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JButton text = (JButton)e.getSource();
		if(text.getText().equals("버튼1")) {
			text.setText("btn1");
		}
		else
			text.setText("버튼1");
	}
	
}


public class E_S1 extends JFrame{

	public E_S1() {
		
		this.setTitle("Event");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = this.getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn1 = new JButton("버튼1");
		c.add(btn1);
		btn1.addActionListener(new MyAction());
		
		JButton btn2 = new JButton("버튼2");
		c.add(btn2);
		btn2.addActionListener(new MyAction2());
		
		JButton btn3 = new JButton("버튼3");
		c.add(btn3);
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("btn3가 클릭됨.");// TODO Auto-generated method stub
			}
		});

		
		
		this.setSize(500, 500);
		this.setVisible(true);
		
	}
	
	private class MyAction2 implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("btn2가 클릭됨.");// TODO Auto-generated method stub	
		}
	}
	
	public static void main(String[] args) {
		new E_S1();
	}
	
}
