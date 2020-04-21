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
		setTitle("���� ����");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		init();
		
		JPanel PBookNo = new JPanel();
		PBookNo.add(new JLabel("������ȣ"));
		tfBookno = new JTextField(14);
		PBookNo.add(tfBookno);
		btnsearch = new JButton("�˻�");
		PBookNo.add(btnsearch);
		this.add(PBookNo);
		
		JPanel PBookName = new JPanel();
		PBookName.add(new JLabel("  ������  "));
		tfBookName = new JTextField(20);
		PBookName.add(tfBookName);
		this.add(PBookName);
		
		JPanel PAuthor = new JPanel();
		PAuthor.add(new JLabel("    ����     "));
		tfAuthor = new JTextField(20);
		PAuthor.add(tfAuthor);
		this.add(PAuthor);
		
		String colName[]={"������ȣ","������","����","�뿩��"};
		model=new DefaultTableModel(colName,0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(300,200));
		table.getColumnModel().getColumn(0).setPreferredWidth(55);  //JTable �� �÷� ���� ����
		table.getColumnModel().getColumn(1).setPreferredWidth(100);
		table.getColumnModel().getColumn(2).setPreferredWidth(100);
		table.getColumnModel().getColumn(3).setPreferredWidth(45);
		this.add(table);
		this.add(new JScrollPane(table));
		
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
						String no = tfBookno.getText();
						haksa.stmt.executeUpdate("delete from books where no='"+no+"'");
						tfBookno.setText("");
						tfBookName.setText("");
						tfAuthor.setText("");
						list();
						JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.","�˸�",JOptionPane.ERROR_MESSAGE);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "�뿩 ���� å�� ������ �� �����ϴ�.","�˸�",JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();// TODO: handle exception
						
					}
					//����ó���Ϸ� �޼��� ���
					
					
				}
			}
		});
		
		this.add(btnlist);
		this.add(btninsert);
		this.add(btnupdate);
		this.add(btndelete);
		
		JPanel Prental = new JPanel();
		Prental.add(new JLabel("�뿩 / �ݳ� ó�� "),BorderLayout.CENTER);
		Prental.getSize(new Dimension(300,20));
		this.add(Prental);
		
		JPanel Pstudent = new JPanel();
		Pstudent.add(new JLabel("�й�"));
		tfid = new JTextField(8);
		Pstudent.add(tfid);
		Pstudent.add(new JLabel("������ȣ"));
		tfno = new JTextField(10);
		Pstudent.add(tfno);
		this.add(Pstudent);
		
		btnBorrow = new JButton("�뿩");
		btnBorrow.setPreferredSize(new Dimension(100,20));
		this.add(btnBorrow);
		
		btnReturn = new JButton("�ݳ�");
		btnReturn.setPreferredSize(new Dimension(100,20));
		this.add(btnReturn);
		
		btnBorrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "�뿩 ����Ͻðڽ��ϱ�?","�뿩", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					
					//���� ó��. db �����ؼ� ����
					try {
						String id = tfid.getText();
						String no = tfno.getText();
						haksa.stmt.executeUpdate("insert into bookrent values(rentseq.nextval,'"+ id +"','"+no+"',to_char(sysdate,'yyyymmdd'))");
						list();
						JOptionPane.showMessageDialog(null, "�뿩 ó���Ǿ����ϴ�.","�˸�",JOptionPane.OK_OPTION);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "�������� �ʴ� �й� �Ǵ� �����Դϴ�.","�˸�",JOptionPane.ERROR_MESSAGE);
						e.printStackTrace();// TODO: handle exception
						
					}
				}
			}
		});
		
		btnReturn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg) {
				int result = JOptionPane.showConfirmDialog(null, "�ݳ� ó���Ͻðڽ��ϱ�?","�뿩", JOptionPane.YES_NO_OPTION);
				
				if (result == JOptionPane.YES_OPTION) {
					
					//���� ó��. db �����ؼ� ����
					try {
						String id = tfid.getText();
						String no = tfno.getText();
						haksa.stmt.executeUpdate("delete from bookrent where id = '"+id+"'and bookno = '"+no+"'");
						list();
						JOptionPane.showMessageDialog(null, "�ݳ� ó���Ǿ����ϴ�.","�˸�",JOptionPane.OK_OPTION);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(null, "�뿩��Ͽ� �������� �ʽ��ϴ�.","�˸�",JOptionPane.ERROR_MESSAGE);
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
		    // Select�� ����
		    ResultSet rs=haksa.stmt.executeQuery("select b.no,b.title,b.author,count(br.bookno)" + 
		    		" from books b, bookrent br" + 
		    		" where b.no = br.bookno" + 
		    		" group by b.no, b.title, b.author" + 
		    		" union" + 
		    		" select no,title,author,0" + 
		    		" from books" + 
		    		" where no not in (select distinct bookno from bookrent)");
		   
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
		   
		  	}catch(Exception e){
		  		e.printStackTrace();
		  	}
		}
}
