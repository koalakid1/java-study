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

	
	JPanel panel;  // 메뉴별 화면이 출력되는 패널
	
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
		setTitle("학사관리시스템"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼 누르면 프로그램 종료  
		JMenuBar bar=new JMenuBar();
  
		JMenu m_student=new JMenu("학생관리");//File메뉴
		bar.add(m_student);
 		
		JMenu m_book=new JMenu("도서관리");//Edit메뉴
 		bar.add(m_book);
  
 		JMenuItem mi_list=new JMenuItem("학생정보");
 		m_student.add(mi_list);
  
 		mi_list.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				panel.removeAll(); //모든컴포넌트 삭제
 				panel.revalidate(); //다시 활성화
			    panel.repaint();    //다시 그리기
			    panel.add(new Student()); //화면 생성.
			    panel.setLayout(null);//레이아웃적용안함   
 			}	
 		});
   
 		JMenuItem mi_booklist = new JMenuItem("도서정보");
 		m_book.add(mi_booklist);
 		
 		JMenuItem mi_bookRent=new JMenuItem("대출목록");
 		m_book.add(mi_bookRent);
 		
 		JMenuItem mi_chart=new JMenuItem("현황차트");
 		m_book.add(mi_chart);
 		
 		mi_bookRent.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {	    
 				panel.removeAll(); //모든컴포넌트 삭제
				panel.revalidate(); //다시 활성화
				panel.repaint();    //다시 그리기
				panel.add(new BookRent()); //화면 생성.
				panel.setLayout(null);//레이아웃적용안함			    
 			}
 		});

 		
 		mi_chart.addActionListener(new ActionListener(){
 			@Override
 			public void actionPerformed(ActionEvent e) {	    
 				panel.removeAll(); //모든컴포넌트 삭제
				panel.revalidate(); //다시 활성화
				panel.repaint();    //다시 그리기
				panel.add(new RentChart()); //화면 생성.
				panel.setLayout(null);//레이아웃적용안함			    
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
  
 		panel=new JPanel();//panel생성
 		add(panel);//프레임에 패널 추가
  
 		setJMenuBar(bar);
 		setSize(800,520);
 		setLocationRelativeTo(null);
 		setVisible(true);
	}
	
	public static void main(String[] args) {
		new haksa();
	}
}