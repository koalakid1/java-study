import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class exercise2 extends JFrame {
	
	JTextField[] tf = new JTextField[4];
	
	int[] data = {0,0,0,0}; // 차트의 값 저장배열
	int[] arcAngle = new int[4]; 
 
	Color[] color = {Color.RED, Color.BLUE,Color.MAGENTA, Color.ORANGE};
 
	String[] itemName = {"apple", "banana", "kiwi", "mango"};


	MyPanel panel = new MyPanel();
	InputPanel input = new InputPanel();
	
	class InputPanel extends JPanel{
		public InputPanel() {
			setBackground(Color.gray);
			
			for (int i = 0; i < tf.length; i++) {
				tf[i] = new JTextField(5);
				tf[i].addActionListener(new MyAction());
				add(new JLabel(itemName[i]));
				add(tf[i]);
			}
		}
	}
	
	class MyPanel extends JPanel{
		
		int startX = 200,startY = 200;
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int startangle = 0;
			
			for (int i = 0; i < data.length; i++) {
				
				g.setColor(color[i]);
				g.drawString(itemName[i]+""+Math.round(arcAngle[i]*100/360), 50+i*100, 20);
				
			}
			
			for (int i = 0; i < data.length; i++) {
				g.setColor(color[i]);
				g.fillArc(150, 50, 200, 200, startangle, arcAngle[i]);
				startangle = startangle + arcAngle[i];
			}
		}
		
	}
	
	void drawChart(){ // 차트를 그린다
		int sum=0; // 초기값 0
		for(int i=0;i<data.length;i++){ // 데이터 값만큼 루프
			data[i] = Integer.parseInt(tf[i].getText());
			sum+=data[i];
		}
		if(sum == 0) 
			return;
 
		for(int i=0;i<data.length;i++){ 
			arcAngle[i] = (int)Math.round((double)data[i]/(double)sum*360);
			panel.repaint(); // 차트패널의 PAINT호출
		}
	}
	
	public exercise2() {
		setTitle("예제 3");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container contentPane = getContentPane(); // 컨테이너 갯
		contentPane.add(input, BorderLayout.NORTH);
		contentPane.add(panel, BorderLayout.NORTH);
		setSize(500,350);
		setVisible(true);

		
	}
	
	class MyAction implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			JTextField t = (JTextField) e.getSource();
			int n;
			try {
				n = Integer.parseInt(t.getText());
			} catch (NumberFormatException e2) {
				return;// TODO: handle exception
			}
			drawChart();
			
		}
		
	}
	
	public static void main(String[] args) {
		new exercise2();
	}
}
