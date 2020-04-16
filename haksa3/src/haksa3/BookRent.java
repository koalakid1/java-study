package haksa3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class BookRent extends JPanel{
	DefaultTableModel model=null;
	JTable table=null;
	String query;
	 
	public BookRent() {
	
	query="select student.id, student.name, books.title, bookRent.rDate" + 
	" from  bookRent, student,books" + 
	" where bookRent.id=student.id" + 
	" and bookRent.bookNo=books.no" + 
	" order by bookRent.no";
	
	
	
	    
	    setLayout(null);//레이아웃설정. 레이아웃 사용 안함.
	    
	    JLabel l_dept=new JLabel("학과");
	    l_dept.setBounds(10, 10, 30, 20);
	    add(l_dept);
	    
	   
	    
	    
	    String[] dept={"전체","컴퓨터시스템","멀티미디어","컴퓨터공학"};
	    JComboBox cb_dept=new JComboBox(dept);
	    cb_dept.setBounds(45, 10, 100, 20);
	    add(cb_dept);
	    
	    JButton btnBook = new JButton("대출관리");
	    btnBook.setBounds(250, 10, 90, 20);
	    add(btnBook);
	    btnBook.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(new BookList());
			}
		});
	    
	    cb_dept.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//기본 쿼리
				query="select s.id, s.name, b.title, br.rDate" + 
						" from student s, books b, bookRent br" + 
						" where br.id=s.id and br.bookNo=b.no";
				
				JComboBox cb=(JComboBox)e.getSource();
				int selectedIndex=cb.getSelectedIndex();//선택한 아이템의 index
				
				if(selectedIndex==0) {
					query+=" order by s.id";
				}else if(selectedIndex==1) {
					query+=" and s.dept='컴퓨터시스템'" + 
							" order by b.no";
				}else if(selectedIndex==2) {
					query+=" and s.dept='멀티미디어'" + 
							" order by b.no";
				}else if(selectedIndex==2) {
					query+=" and s.dept='컴퓨터공학'" + 
							" order by b.no";
				}
				
				list(); //목록출력
				
			}});
	    
	    
	    
	    String colName[]={"학번","이름","도서명","대출일"};
	    model=new DefaultTableModel(colName,0);
	    table = new JTable(model);
	    table.setPreferredScrollableViewportSize(new Dimension(300,200));
	    table.getColumnModel().getColumn(0).setPreferredWidth(60);
	    table.getColumnModel().getColumn(1).setPreferredWidth(70);
	    table.getColumnModel().getColumn(2).setPreferredWidth(130);
	    table.getColumnModel().getColumn(3).setPreferredWidth(70);
	    add(table);
	    JScrollPane sp=new JScrollPane(table);
	    sp.setBounds(10, 40, 330, 400);
	    add(sp);  
	    
	    
	    setSize(350, 550);//화면크기
	    setVisible(true);
	    
	    //전체목록
	    list();
	}
	
	
	public void list(){
	    try{
		     // Select문 실행     
		     ResultSet rs=haksa.stmt.executeQuery(query);
		    
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
	

}