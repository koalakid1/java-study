package haksa3;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RentChart extends JPanel {
	Color[] color = new Color[100];
	String[] itemName = new String[100];
	
	int[] data = new int[100];
	int[] arcangle = new int[100];
	int sum = 0;
	
	
	public RentChart() {
		try {
			ResultSet rs = haksa.stmt.executeQuery("select distinct dept from student");
			int count = 0;
			while(rs.next()) {
				itemName[count] = rs.getString(1);
				int r=(int)(Math.random()*256);
				int g=(int)(Math.random() *256);
				int b =(int)(Math.random()*256);
				Color c= new Color(r,g,b);
				color[count] = c;
				count++;
			System.out.println(itemName.length);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		setSize(570,400);
		setVisible(true);
		list();
	}

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int start = 0;
			
			for(int i=0;i<data.length;i++){
				g.setColor(color[i]);
				g.drawString(itemName[i]+""+Math.round(arcangle[i]*100/360)+"%", 50+i*100,20);
			}
			
			for (int i = 0; i<arcangle.length; i++) {
				g.setColor(color[i]);
				g.fillArc(250,75,300,300,start,arcangle[i]);
				
				start += arcangle[i];
			}
		}

	
	public void list() {
		for (int i = 0; i < data.length; i++) {
			String query = "select count(*)" + 
					" from bookrent join student on student.id = bookrent.id" + 
					" where student.dept = '"+itemName[i]+"'";
			try {
				ResultSet rs = haksa.stmt.executeQuery(query);
				if(rs.next()) {
					data[i] = rs.getInt("count(*)");
					sum += data[i];
				}
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		for (int i = 0; i < arcangle.length; i++) {
			arcangle[i] = (int)Math.round((double)data[i]/(double)sum * 360);
		}
		
	}
	
}
