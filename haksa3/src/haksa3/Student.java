package haksa3;

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

public class Student extends JPanel{
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
	
	public Student() {
		setLayout(new FlowLayout());
		
		JPanel Pid = new JPanel();
		Pid.add(new JLabel("�й�"));
		tfid = new JTextField(14);
		Pid.add(tfid);
		btnsearch = new JButton("�˻�");
		Pid.add(btnsearch);
		add(Pid);
		
		JPanel Pname = new JPanel();
		Pname.add(new JLabel("�̸�"));
		tfname = new JTextField(20);
		Pname.add(tfname);
		add(Pname);
		
		JPanel Pdept = new JPanel();
		Pdept.add(new JLabel("�а�"));
		tfdept = new JTextField(20);
		Pdept.add(tfdept);
		add(Pdept);
		
		JPanel Paddress = new JPanel();
		Paddress.add(new JLabel("�ּ�"));
		tfaddress = new JTextField(20);
		Paddress.add(tfaddress);
		add(Paddress);
		
		String colName[]={"�й�","�̸�","�а�","�ּ�"};
		model=new DefaultTableModel(colName,0);
		table = new JTable(model);
		table.setPreferredScrollableViewportSize(new Dimension(300,200));
		table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
		table.getColumnModel().getColumn(1).setPreferredWidth(50);
		table.getColumnModel().getColumn(2).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setPreferredWidth(120);
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
					
					haksa.stmt.executeUpdate("insert into student values('"+id+"','"+name+"','"+dept+"','"+address+"')");
					
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
					
					rs = haksa.stmt.executeQuery("select * from student where id='"+id+"'");
					
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
					haksa.stmt.executeUpdate("update student set name='"+name+"', dept='"+dept+"', address='"+address+"' where id='"+id+"'");
					
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
						haksa.stmt.executeUpdate("delete from student where id='"+id+"'");
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
		
		add(btnlist);
		add(btninsert);
		add(btnupdate);
		add(btndelete);
		
		setSize(350,450);
		setVisible(true);
	}
	public void list(){
		try{ 
		    // Select�� ����
		    ResultSet rs=haksa.stmt.executeQuery("select * from student");
		   
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
}