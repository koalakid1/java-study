package haksa3;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class haksa extends JFrame{

	
	JPanel panel;  // �޴��� ȭ���� ��µǴ� �г�
	
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	
	haksa(){ 
		try {			   
			Class.forName("com.mysql.jdbc.Driver");			   
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");			   
			stmt=conn.createStatement();
		} catch (Exception e) {   
			e.printStackTrace(); 
		}
		addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){	
				try {
					if(conn!=null){
						conn.close();
					}
				} catch (SQLException e1) {
			    		e1.printStackTrace();	
				}	
			}	
		});
		setTitle("�л�����ý���"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x��ư ������ ���α׷� ����  
		JMenuBar bar=new JMenuBar();
  
		JMenu m_student=new JMenu("�л�����");//File�޴�
		bar.add(m_student);
 		
		JMenu m_book=new JMenu("��������");//Edit�޴�
 		bar.add(m_book);
  
 		JMenuItem mi_list=new JMenuItem("�л�����");
 		m_student.add(mi_list);
  
 		mi_list.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				panel.removeAll(); //���������Ʈ ����
 				panel.revalidate(); //�ٽ� Ȱ��ȭ
			    panel.repaint();    //�ٽ� �׸���
			    panel.add(new Student()); //ȭ�� ����.
			    panel.setLayout(null);//���̾ƿ��������   
 			}	
 		});
   
 		JMenuItem mi_booklist = new JMenuItem("��������");
 		m_book.add(mi_booklist);
 		
 		JMenuItem mi_bookRent=new JMenuItem("������");
 		m_book.add(mi_bookRent);
 		
 		JMenuItem mi_chart=new JMenuItem("��Ȳ��Ʈ");
 		m_book.add(mi_chart);
 		
 		mi_bookRent.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {	    
 				panel.removeAll(); //���������Ʈ ����
				panel.revalidate(); //�ٽ� Ȱ��ȭ
				panel.repaint();    //�ٽ� �׸���
				panel.add(new BookRent()); //ȭ�� ����.
				panel.setLayout(null);//���̾ƿ��������			    
 			}
 		});

 		
 		mi_chart.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {	    
 				panel.removeAll(); //���������Ʈ ����
				panel.revalidate(); //�ٽ� Ȱ��ȭ
				panel.repaint();    //�ٽ� �׸���
				panel.add(new RentChart()); //ȭ�� ����.
				panel.setLayout(null);//���̾ƿ��������			    
 			}
 		});
 		

 		mi_booklist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.revalidate();
				panel.repaint();
				panel.add(new BookList());
				panel.setLayout(null);	
			}
		});
  
 		panel=new JPanel();//panel����
 		add(panel);//�����ӿ� �г� �߰�
  
 		setJMenuBar(bar);
 		setSize(800,520);
 		setLocationRelativeTo(null);
 		setVisible(true);
	}
	
	public static void main(String[] args) {
		new haksa();
	}
}