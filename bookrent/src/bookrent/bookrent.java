package bookrent;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class bookrent extends JFrame {
	DefaultTableModel model = null;
	JTable table = null;
	Connection conn = null;
	
	Statement stmt;
	String query;
	
	public bookrent() {
		query = "select s.id, s.name, b.title, br.rdate " +
				"from bookrent br,student s,books b " +
				"where br.id = s.id " +
				"and br.bookno = b.no " +
				"order by br.no";
		try {
			//DB연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle", "ora_user", "hong");
			//System.out.println("연결완료");
			stmt=conn.createStatement();	
		}catch(Exception e) {
				e.printStackTrace();	
		}

		setTitle("학생관리");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x버튼 누르면 프로그램 종료
			    
		setLayout(null);//레이아웃설정. 레이아웃 사용 안함.
			    
		JLabel l_dept=new JLabel("학과");
		l_dept.setBounds(10, 10, 30, 20);
		add(l_dept);
			    
		    
		String[] dept={"전체","컴퓨터시스템","멀티미디어","컴퓨터공학"};
		JComboBox cb_dept=new JComboBox(dept);
		cb_dept.setBounds(45, 10, 100, 20);
		add(cb_dept);
		
		cb_dept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				query = "select s.id, s.name, b.title, br.rDate" + 
						" from student s, books b, bookRent br" + 
						" where br.id=s.id" + 
						" and br.bookNo=b.no";
				
				JComboBox cb = (JComboBox)e.getSource();
				int selectedIndex = cb.getSelectedIndex();
				
				if(selectedIndex == 0) {
					query += " order by s.id";
				}else if(selectedIndex == 1) {
					query +=" and s.dept='컴퓨터시스템'" + 
							" order by s.id";
				}else if(selectedIndex == 2) {
					query +=" and s.dept='멀티미디어'" + 
							" order by s.id";
				}else if(selectedIndex == 3) {
					query +=" and s.dept='컴퓨터공학'" + 
							" order by s.id";
				}
				
				list();
			}
		});
		
		String colName[]={"학번","이름","도서명","대출일"};
		model=new DefaultTableModel(colName,0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(470,200));
		add(table);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(10, 40, 460, 250);
		add(sp);  
			    
		setSize(490, 400);//화면크기
		setVisible(true);
			    
		//전체목록
		list();
	}


	public void list(){
		try{
//			System.out.println("연결되었습니다.....");			     
//			System.out.println(query);       			     
			// Select문 실행     			    
			ResultSet rs=stmt.executeQuery(query);
			    			     
			//JTable 초기화			     
			model.setNumRows(0);			    			     
			
			while(rs.next()){			      
				String[] row=new String[4];//컬럼의 갯수가 4			      
				row[0]=rs.getString("id");			    
				row[1]=rs.getString("name");			    
				row[2]=rs.getString("title");			    
				row[3]=rs.getString("rdate");
				model.addRow(row);   
			}
			rs.close();									
		}		
		catch(Exception e1){		
			//e.getStackTrace();
			System.out.println(e1.getMessage());
		}	
	}
		
	public static void main(String[] args) {	
		new bookrent();
		}			
}