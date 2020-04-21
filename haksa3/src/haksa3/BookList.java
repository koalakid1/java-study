package haksa3;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BookList extends JFrame{
	static ResultSet rs;
	
	JTextField tfBookno = null ;
	JTextField tfBookName = null ;
	JTextField tfAuthor = null;
	JTextField tfid = null ;
	JTextField tfno = null ;
	
	JButton btnlist = null;
	JButton btninsert = null;
	JButton btnupdate = null;
	JButton btndelete = null;
	JButton btnsearch = null;
	JButton btnBorrow = null;
	JButton btnReturn = null;
	
	DefaultTableModel model;
	JTable table;
	
	public BookList() {
		setTitle("대출 관리");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		init();
		
		JPanel PBookNo = new JPanel();
		PBookNo.add(new JLabel("도서번호"));
		tfBookno = new JTextField(14);
		PBookNo.add(tfBookno);
		btnsearch = new JButton("검색");
		PBookNo.add(btnsearch);
		this.add(PBookNo);
		
		JPanel PBookName = new JPanel();
		PBookName.add(new JLabel("  도서명  "));
		tfBookName = new JTextField(20);
		PBookName.add(tfBookName);
		this.add(PBookName);
		
		JPanel PAuthor = new JPanel();
		PAuthor.add(new JLabel("    저자     "));
		tfAuthor = new JTextField(20);
		PAuthor.add(tfAuthor);
		this.add(PAuthor);
		
		String colName[]={"도서번호","도서명","저자","대여수"};
		model=new DefaultTableModel(colName,0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(300,200));
		table.getColumnModel().getColumn(0).setPreferredWidth(55);  //JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		this.add(table);
		this.add(new JScrollPane(table));
		
		btnlist = new JButton("목록");
		btninsert = new JButton("입력");
		btnupdate = new JButton("수정");
		btndelete = new JButton("삭제");
		
		btnlist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				list();
			}
		});
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				table = (JTable)e.getComponent();
				model = (DefaultTableModel)table.getModel();
				String no = (String)model.getValueAt(table.getSelectedRow(), 0);
				tfBookno.setText(no);
				String title = (String)model.getValueAt(table.getSelectedRow(), 1);
				tfBookName.setText(title);
				String author = (String)model.getValueAt(table.getSelectedRow(), 2);
				tfAuthor.setText(author);
			}
		});
		
		btninsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					String no = tfBookno.getText();
					String title = tfBookName.getText();
					String author = tfAuthor.getText();
					
					haksa.stmt.executeUpdate("insert into books values('"+no+"','"+title+"','"+author+"')");
					
					JOptionPane.showMessageDialog(null, "등록되었습니다.");
					
					list();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		btnsearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					String no = tfBookno.getText();
					
					rs = haksa.stmt.executeQuery("select * from books where no='"+no+"'");
					model.setNumRows(0);
					if(rs.next()) {
						tfBookno.setText(rs.getString("no"));
						tfBookName.setText(rs.getString("title"));
						tfAuthor.setText(rs.getString("author"));
						
						String[] row = new String[4];
						row[0] = rs.getString("no");
						row[1] = rs.getString("title");
						row[2] = rs.getString("author");
						try {
							ResultSet rs2 = haksa.stmt.executeQuery("select count(bookno) from bookrent where bookno = '"+row[0]+"'");
							if(rs2.next()) {
								row[3] = rs2.getString(1);
							}
							rs2.close();
						} catch (Exception e) {
							e.printStackTrace();// TODO: handle exception
						}
						model.addRow(row);
					}
					rs.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					String no = tfBookno.getText();
					String title = tfBookName.getText();
					String author = tfAuthor.getText();
					haksa.stmt.executeUpdate("update books set title='"+title+"', author='"+author+"' where no='"+no+"'");
					
					JOptionPane.showMessageDialog(null, "수정되었습니다.");
					list();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {	
				int result = JOptionPane.showConfirmDialog(null, "삭제하시겠습니까?","삭제", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					
					//삭제 처리. db 연동해서 삭제
					try {
						String no = tfBookno.getText();
						haksa.stmt.executeUpdate("delete from books where no='"+no+"'");
						tfBookno.setText("");
						tfBookName.setText("");
						tfAuthor.setText("");
						list();
						JOptionPane.showMessageDialog(null, "삭제되었습니다.","알림",JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "대여 중인 책은 삭제할 수 없습니다.","알림",JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();// TODO: handle exception
						
					}
					//삭제처리완료 메세지 출력
					
					
				}
			}
		});
		
		this.add(btnlist);
		this.add(btninsert);
		this.add(btnupdate);
		this.add(btndelete);
		
		JPanel Prental = new JPanel();
		Prental.add(new JLabel("대여 / 반납 처리 "),BorderLayout.CENTER);
		Prental.getSize(new Dimension(300,20));
		this.add(Prental);
		
		JPanel Pstudent = new JPanel();
		Pstudent.add(new JLabel("학번"));
		tfid = new JTextField(8);
		Pstudent.add(tfid);
		Pstudent.add(new JLabel("도서번호"));
		tfno = new JTextField(10);
		Pstudent.add(tfno);
		this.add(Pstudent);
		
		btnBorrow = new JButton("대여");
		btnBorrow.setPreferredSize(new Dimension(100,20));
		this.add(btnBorrow);
		
		btnReturn = new JButton("반납");
		btnReturn.setPreferredSize(new Dimension(100,20));
		this.add(btnReturn);
		
		btnBorrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "대여 등록하시겠습니까?","대여", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					
					//삭제 처리. db 연동해서 삭제
					try {
						String id = tfid.getText();
						String no = tfno.getText();
						haksa.stmt.executeUpdate("insert into bookrent values(rentseq.nextval,'"+ id +"','"+no+"',to_char(sysdate,'yyyymmdd'))");
						list();
						JOptionPane.showMessageDialog(null, "대여 처리되었습니다.","알림",JOptionPane.OK_OPTION);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "존재하지 않는 학번 또는 도서입니다.","알림",JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();// TODO: handle exception
						
					}
				}
			}
		});
		
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "반납 처리하시겠습니까?","대여", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					
					//삭제 처리. db 연동해서 삭제
					try {
						String id = tfid.getText();
						String no = tfno.getText();
						haksa.stmt.executeUpdate("delete from bookrent where id = '"+id+"'and bookno = '"+no+"'");
						list();
						JOptionPane.showMessageDialog(null, "반납 처리되었습니다.","알림",JOptionPane.OK_OPTION);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "대여목록에 존재하지 않습니다.","알림",JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();// TODO: handle exception
						
					}
				}
			}
		});
		
		setSize(350,600);
		setVisible(true);
	}
	
	public void init() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
			}
		});
	}
	
	public void list(){
		try{ 
		    // Select문 실행
		    ResultSet rs=haksa.stmt.executeQuery("select b.no,b.title,b.author,count(br.bookno)" + 
		    		" from books b, bookrent br" + 
		    		" where b.no = br.bookno" + 
		    		" group by b.no, b.title, b.author" + 
		    		" union" + 
		    		" select no,title,author,0" + 
		    		" from books" + 
		    		" where no not in (select distinct bookno from bookrent)");
		   
		    //JTable 초기화
		    model.setNumRows(0);
		   
		    while(rs.next()){
		    	String[] row=new String[4];//컬럼의 갯수가 3
		    	row[0]=rs.getString("no");
		    	row[1]=rs.getString("title");
		    	row[2]=rs.getString("author");
		    	row[3]=rs.getString(4);
		    	model.addRow(row);
		    }
		    rs.close();	
		   
		  	}catch(Exception e){
		  		e.printStackTrace();
		  	}
		}
}
