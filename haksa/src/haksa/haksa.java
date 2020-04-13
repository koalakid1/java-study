package haksa;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class haksa extends JFrame{
	static Connection conn;
	static Statement stmt;
	static ResultSet rs;
	
	JTextField tfid = null ;
	JTextField tfname = null ;
	JTextField tfdept = null;
	JTextField tfaddress = null;
	JTextArea taList = null;
	
	JButton btnlist = null;
	JButton btninsert = null;
	JButton btnupdate = null;
	JButton btndelete = null;
	
	JButton btnsearch = null;
	
	
	public haksa() {
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
		
		taList = new JTextArea(10,23);
		c.add(new JScrollPane(taList));
		
		btnlist = new JButton("���");
		btninsert = new JButton("�Է�");
		btnupdate = new JButton("����");
		btndelete = new JButton("����");
		
		btnlist.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from student order by id");	
					
					taList.setText("");
					
					taList.append("�й�"+"\t"+"�̸�"+"\t"+"�а�"+"\n");
					taList.append("======================================\n");
					while(rs.next()) {
//						System.out.print(rs.getString("id")+"\t");
//						System.out.print(rs.getString("name")+"\t");
//						System.out.println(rs.getString("dept"));
						taList.append(rs.getString("id")+"\t"+rs.getString("name")+"\t"+rs.getString("dept")+"\n");
					}
					rs.close();
					conn.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		btninsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");
					stmt = conn.createStatement();
					stmt.executeUpdate("insert into student values('"+ tfid.getText() +"','"+tfname.getText() +"','"+tfdept.getText() +"')");
					rs = stmt.executeQuery("select * from student order by id");	
					
					taList.setText("");
					
					taList.append("�й�"+"\t"+"�̸�"+"\t"+"�а�"+"\n");
					taList.append("======================================\n");
					while(rs.next()) {
//						System.out.print(rs.getString("id")+"\t");
//						System.out.print(rs.getString("name")+"\t");
//						System.out.println(rs.getString("dept"));
						taList.append(rs.getString("id")+"\t"+rs.getString("name")+"\t"+rs.getString("dept")+"\n");
					}
					rs.close();
					conn.close();
					
					JOptionPane.showMessageDialog(null, "��ϵǾ����ϴ�.");
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
		
		btnsearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");
					stmt = conn.createStatement();
					rs = stmt.executeQuery("select * from student where id = '"+ tfid.getText() +"'");	
					
					taList.setText("");
					
					taList.append("�й�"+"\t"+"�̸�"+"\t"+"�а�"+"\n");
					taList.append("======================================\n");
					if(rs.next()) {
//						System.out.print(rs.getString("id")+"\t");
//						System.out.print(rs.getString("name")+"\t");
//						System.out.println(rs.getString("dept"));
						taList.append(rs.getString("id")+"\t"+rs.getString("name")+"\t"+rs.getString("dept")+"\n");
						tfname.setText(rs.getString("name"));
						tfdept.setText(rs.getString("dept"));
					}
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs!=null) rs.close();
						if(conn!=null) conn.close();
					} catch (Exception e) {
						e.printStackTrace();// TODO: handle exception
					}
				}
			}
		});
		
		btnupdate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					
					conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");
					stmt = conn.createStatement();
					stmt.executeUpdate("update student set name = '"+tfname.getText()+"', dept= '"+tfdept.getText()+"' where id = '"+tfid.getText()+"'");
					
					rs = stmt.executeQuery("select * from student where id = '"+ tfid.getText() +"'");	
					
					taList.setText("");
					
					taList.append("�й�"+"\t"+"�̸�"+"\t"+"�а�"+"\n");
					taList.append("======================================\n");
					if(rs.next()) {
//						System.out.print(rs.getString("id")+"\t");
//						System.out.print(rs.getString("name")+"\t");
//						System.out.println(rs.getString("dept"));
						taList.append(rs.getString("id")+"\t"+rs.getString("name")+"\t"+rs.getString("dept")+"\n");
						tfname.setText(rs.getString("name"));
						tfdept.setText(rs.getString("dept"));
					}
					JOptionPane.showMessageDialog(null, "�����Ǿ����ϴ�.");
				
				} catch (Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(rs!=null) rs.close();
						if(conn!=null) conn.close();
					} catch (Exception e) {
						e.printStackTrace();// TODO: handle exception
					}
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
						Class.forName("com.mysql.jdbc.Driver");
						
						conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:myoracle","ora_user","hong");
						stmt = conn.createStatement();
						stmt.executeUpdate("delete from student where id='"+tfid.getText()+"'");
						
						taList.setText("");
						tfid.setText("");
						tfname.setText("");
						tfdept.setText("");
						
					} catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							if(conn!=null) conn.close();
						} catch (Exception e) {
							e.printStackTrace();// TODO: handle exception
						}
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
		
		setSize(295,400);
		setResizable(false);
		setVisible(true);
	}
	
	public static void main(String[] args) throws ClassNotFoundException {
		new haksa();
	}
}
