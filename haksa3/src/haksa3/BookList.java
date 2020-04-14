package haksa3;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BookList extends JPanel{
	
	JTextField tfno = null ;
	JTextField tftitle = null ;
	JTextField tfauthor = null;
	
	JTextField tfid = null ;
	JTextField tfrent = null ;
	JButton btnrent = null;
	JButton btnnorent = null;
	
	static ResultSet rs;
	DefaultTableModel model;
	
	JButton btnlist = null;
	JButton btninsert = null;
	JButton btnupdate = null;
	JButton btndelete = null;
	JButton btnsearch = null;
	
	JTable table;
	
	String query;
	
	public BookList() {

		setLayout(new FlowLayout());
		
		add(new JLabel("��ȣ"));
		tfno = new JTextField(14);
		add(tfno);
		btnsearch = new JButton("�˻�");
		add(btnsearch);
		
		add(new JLabel("����"));
		tftitle = new JTextField(20);
		add(tftitle);
		
		add(new JLabel("����"));
		tfauthor = new JTextField(20);
		add(tfauthor);
		
		
		String colName[]={"��ȣ","����","����","�뿩 ��"};
		model=new DefaultTableModel(colName,0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(250,220));
		add(table);
		add(new JScrollPane(table));
		
		btnlist = new JButton("���");
		btninsert = new JButton("�Է�");
		btnupdate = new JButton("����");
		btndelete = new JButton("����");
		
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
				tfno.setText(no);
				String title = (String)model.getValueAt(table.getSelectedRow(), 1);
				tftitle.setText(title);
				String author = (String)model.getValueAt(table.getSelectedRow(), 2);
				tfauthor.setText(author);
				
			}
		});
		
		btninsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					String no = tfno.getText();
					String title = tftitle.getText();
					String author = tfauthor.getText();
					
					haksa.stmt.executeUpdate("insert into books values('"+no+"','"+title+"','"+author+"')");
					
					JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�.");
					
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
					String no = tfno.getText();
					
					rs = haksa.stmt.executeQuery("select * from books where no='"+no+"'");
					
					model.setNumRows(0);
					if(rs.next()) {
						tfno.setText(rs.getString("no"));
						tftitle.setText(rs.getString("title"));
						tfauthor.setText(rs.getString("author"));
						
						String[] row = new String[4];
						row[0] = rs.getString("no");
						row[1] = rs.getString("title");
						row[2] = rs.getString("author");
						ResultSet rs2 = haksa.stmt.executeQuery("select count(*) from bookrent where bookno = '"+row[0]+"'");
						if(rs2.next()) {
				    		row[3]=rs2.getString(1);
				    		rs2.close();	
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
					String no = tfno.getText();
					String title = tftitle.getText();
					String author = tfauthor.getText();
					haksa.stmt.executeUpdate("update books set title='"+title+"', author='"+author+"' where no='"+no+"'");
					
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
					list();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btndelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "�����Ͻðڽ��ϱ�?","����", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					
					//���� ó��. db �����ؼ� ����
					try {
						String no = tfno.getText();
						haksa.stmt.executeUpdate("delete from books where no='"+no+"'");
						tfno.setText("");
						tftitle.setText("");
						tfauthor.setText("");
						list();
					} catch (Exception e) {
						e.printStackTrace();// TODO: handle exception
					}
					//����ó���Ϸ� �޼��� ���
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.","�˸�",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		
		add(btnlist);
		add(btninsert);
		add(btnupdate);
		add(btndelete);
		
		add(new JLabel("�й�    "));
		tfid = new JTextField(19);
		add(tfid);
		
		add(new JLabel("������"));
		tfrent = new JTextField(19);
		add(tfrent);
		
		btnrent = new JButton("�뿩");
		btnrent.setPreferredSize(new Dimension(125,20));
		add(btnrent);
		
		
		btnnorent = new JButton("�ݳ�");
		btnnorent.setPreferredSize(new Dimension(125,20));
		add(btnnorent);
		
		query = "select s.id, s.name, b.title, br.rDate" + 
				" from student s, books b, bookRent br" + 
				" where br.id=s.id" + 
				" and br.bookNo=b.no";
		
		btnrent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "�뿩 ����Ͻðڽ��ϱ�?","�뿩", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					
					//���ó��
					try {
						String id = tfid.getText();
						String rent = tfrent.getText();
						haksa.stmt.executeUpdate("insert into bookrent values(rentseq.nextval,'"+id+"',(select no from books where title = '"+rent+"'),to_char(sysdate,'yyyymmdd'))");
						list();
					} catch (Exception e) {
						e.printStackTrace();// TODO: handle exception
					}
					//����ó���Ϸ� �޼��� ���
					JOptionPane.showMessageDialog(null, "�뿩 ó���Ǿ����ϴ�.","�˸�",JOptionPane.OK_OPTION);
				}
			}
		});
		btnnorent.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "�ݳ� ó���Ͻðڽ��ϱ�?","�ݳ�", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					
					//���� ó��. db �����ؼ� ����
					try {
						String id = tfid.getText();
						String rent = tfrent.getText();
						haksa.stmt.executeUpdate("delete from bookrent where id='"+id+"' and bookno = "
												+ "(select no from books where title = '"+rent+"')");
						list();
					} catch (Exception e) {
						e.printStackTrace();// TODO: handle exception
					}
					//����ó���Ϸ� �޼��� ���
					JOptionPane.showMessageDialog(null, "�ݳ� ó���Ǿ����ϴ�.","�˸�",JOptionPane.OK_OPTION);
					
				}
				
			}
		});
		setSize(280,500);
		setVisible(true);
	}
	public void list(){
		try{ 
		    // Select�� ����
		    ResultSet rs= haksa.stmt.executeQuery("select books.no,books.title,books.author, count(bookrent.bookno)" + 
		    		" from bookrent, books" + 
		    		" where bookrent.bookno = books.no" + 
		    		" group by books.no, books.title, books.author" + 
		    		" union" + 
		    		" select books.no,books.title,books.author, 0" + 
		    		" from books" + 
		    		" where books.no not in (select bookno from bookrent)");
		   
		    //JTable �ʱ�ȭ
		    model.setNumRows(0);
		    while(rs.next()){
		    	String[] row=new String[4];//�÷��� ������ 3
		    	row[0]=rs.getString("no");
		    	row[1]=rs.getString("title");
		    	row[2]=rs.getString("author");
		    	row[3]=rs.getString(4);
		    	
		    	model.addRow(row);
		    }
		    rs.close();
		    
		  	}catch(Exception e1){
		  		//e.getStackTrace();
		  		System.out.println(e1.getMessage());
		  	}
		}
}
