package haksa2;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class haksa extends JFrame{
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	
	JTextField tfid = null ;
	JTextField tfname = null ;
	JTextField tfdept = null;
	JTextField tfaddress = null;
	
	
	
	JButton btnlist = null;
	JButton btninsert = null;
	JButton btnupdate = null;
	JButton btndelete = null;
	JButton btnsearch = null;
	
	DefaultTableModel model;
	JTable table;
	
	public haksa() {
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
		setTitle("�л����");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		c.add(new JLabel("�й�"));
		tfid = new JTextField(14);
		c.add(tfid);
		btnsearch = new JButton("�˻�");
		c.add(btnsearch);
		
		c.add(new JLabel("�̸�"));
		tfname = new JTextField(20);
		c.add(tfname);
		
		c.add(new JLabel("�а�"));
		tfdept = new JTextField(20);
		c.add(tfdept);
		
		c.add(new JLabel("�ּ�"));
		tfaddress = new JTextField(20);
		c.add(tfaddress);
		
		String colName[]={"�й�","�̸�","�а�","�ּ�"};
		model=new DefaultTableModel(colName,0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(250,200));
		c.add(table);
		c.add(new JScrollPane(table));
		
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
				String id = (String)model.getValueAt(table.getSelectedRow(), 0);
				tfid.setText(id);
				String name = (String)model.getValueAt(table.getSelectedRow(), 1);
				tfname.setText(name);
				String dept = (String)model.getValueAt(table.getSelectedRow(), 2);
				tfdept.setText(dept);
				String address = (String)model.getValueAt(table.getSelectedRow(), 3);
				tfaddress.setText(address);
				
			}
		});
		
		btninsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					String id = tfid.getText();
					String name = tfname.getText();
					String dept = tfdept.getText();
					String address = tfaddress.getText();
					
					stmt.executeUpdate("insert into student values('"+id+"','"+name+"','"+dept+"','"+address+"')");
					
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
					String id = tfid.getText();
					
					rs = stmt.executeQuery("select * from student where id='"+id+"'");
					
					model.setNumRows(0);
					if(rs.next()) {
						tfid.setText(rs.getString("id"));
						tfname.setText(rs.getString("name"));
						tfdept.setText(rs.getString("dept"));
						tfaddress.setText(rs.getString("address"));
						
						String[] row = new String[4];
						row[0] = rs.getString("id");
						row[1] = rs.getString("name");
						row[2] = rs.getString("dept");
						row[3] = rs.getString("address");
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
					String id = tfid.getText();
					String name = tfname.getText();
					String dept = tfdept.getText();
					String address = tfaddress.getText();
					stmt.executeUpdate("update student set name='"+name+"', dept='"+dept+"', address='"+address+"' where id='"+id+"'");
					
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
						String id = tfid.getText();
						stmt.executeUpdate("delete from student where id='"+id+"'");
						tfid.setText("");
						tfname.setText("");
						tfdept.setText("");
						tfaddress.setText("");
						list();
					} catch (Exception e) {
						e.printStackTrace();// TODO: handle exception
					}
					//����ó���Ϸ� �޼��� ���
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.","�˸�",JOptionPane.ERROR_MESSAGE);
					
				}
			}
		});
		
		c.add(btnlist);
		c.add(btninsert);
		c.add(btnupdate);
		c.add(btndelete);
		
		setSize(295,450);
		setResizable(false);
		setVisible(true);
	}
	public void list(){
		try{ 
		    // Select�� ����
		    ResultSet rs=stmt.executeQuery("select * from student");
		   
		    //JTable �ʱ�ȭ
		    model.setNumRows(0);
		   
		    while(rs.next()){
		    	String[] row=new String[4];//�÷��� ������ 3
		    	row[0]=rs.getString("id");
		    	row[1]=rs.getString("name");
		    	row[2]=rs.getString("dept");
		    	row[3]=rs.getString("address");
		    	model.addRow(row);
		    }
		    rs.close();
		   
		  	}catch(Exception e1){
		  		//e.getStackTrace();
		  		System.out.println(e1.getMessage());
		  	}
		}
	public static void main(String[] args) throws ClassNotFoundException {
		new haksa();
	}
}
