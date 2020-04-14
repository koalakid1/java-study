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
			//DB����
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle", "ora_user", "hong");
			//System.out.println("����Ϸ�");
			stmt=conn.createStatement();	
		}catch(Exception e) {
				e.printStackTrace();	
		}

		setTitle("�л�����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//x��ư ������ ���α׷� ����
			    
		setLayout(null);//���̾ƿ�����. ���̾ƿ� ��� ����.
			    
		JLabel l_dept=new JLabel("�а�");
		l_dept.setBounds(10, 10, 30, 20);
		add(l_dept);
			    
		    
		String[] dept={"��ü","��ǻ�ͽý���","��Ƽ�̵��","��ǻ�Ͱ���"};
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
					query +=" and s.dept='��ǻ�ͽý���'" + 
							" order by s.id";
				}else if(selectedIndex == 2) {
					query +=" and s.dept='��Ƽ�̵��'" + 
							" order by s.id";
				}else if(selectedIndex == 3) {
					query +=" and s.dept='��ǻ�Ͱ���'" + 
							" order by s.id";
				}
				
				list();
			}
		});
		
		String colName[]={"�й�","�̸�","������","������"};
		model=new DefaultTableModel(colName,0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(470,200));
		add(table);
		JScrollPane sp=new JScrollPane(table);
		sp.setBounds(10, 40, 460, 250);
		add(sp);  
			    
		setSize(490, 400);//ȭ��ũ��
		setVisible(true);
			    
		//��ü���
		list();
	}


	public void list(){
		try{
//			System.out.println("����Ǿ����ϴ�.....");			     
//			System.out.println(query);       			     
			// Select�� ����     			    
			ResultSet rs=stmt.executeQuery(query);
			    			     
			//JTable �ʱ�ȭ			     
			model.setNumRows(0);			    			     
			
			while(rs.next()){			      
				String[] row=new String[4];//�÷��� ������ 4			      
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