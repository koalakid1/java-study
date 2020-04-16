package haksa3;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JPanel;

public class RentChart extends JPanel{
	
	ArrayList<Integer> data = new ArrayList<Integer>();
	ArrayList<Integer> arcangle = new ArrayList<Integer>();
	ArrayList<Color> color = new ArrayList<Color>();
	ArrayList<String> deptName = new ArrayList<String>();
	int sum = 0;
	
	public RentChart() {
		list();
		setSize(350,550);
		setVisible(true);
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black);
		g.setFont(new Font("Serif",Font.BOLD,20));
		g.drawString("도서 대여 현황 집계 차트", 60, 30);
		g.draw3DRect(50, 10, 250, 30, false);
		g.setFont(new Font(null));
		int start = 0, sum = 0, sum2 = 0, start_list = 30;
		for(int i=0;i<data.size();i++){
			Color colors = color.get(i);
			String deptNames = deptName.get(i);
			Integer arcangles = arcangle.get(i);
			
			g.setColor(colors);
			if (start_list + sum + 12*(deptNames+Math.round(arcangles*100/360)+"%").length()> 350) {
				sum = 0;
				sum2 += 20;
			}
			g.drawString(deptNames+""+Math.round(arcangles*100/360)+"%", start_list+sum, 70 + sum2);
			sum += 12*(deptNames+Math.round(arcangles*100/360)+"%").length();
			
			g.fillArc(50,150,250,250,start,arcangles);
			start += arcangles;
		}
	}

	
	public void get_angle(){
		
		String query = "select count(*) from bookrent where id in (select id from student where dept = ";
		for (int i = 0; i < deptName.size(); i++) {
			try {
				ResultSet rs = haksa.stmt.executeQuery(query + "'" + deptName.get(i) + "')");
				if(rs.next()) {
					data.add(rs.getInt(1));
					sum += data.get(i);
				}
				
				rs.close();
			} catch (Exception e) {
				e.getStackTrace();
			}
		}
		for (Integer integer : data) {
			arcangle.add((int)Math.round((double)integer/(double)sum *360));
		}
	}
	
	public void list() {
		
		
		String query = "select distinct dept from student";
		try {
			ResultSet rs = haksa.stmt.executeQuery(query);
			while(rs.next()) {
				int checker = 0;
				while(true) {
					int r = (int)(Math.random()*256);
					int g = (int)(Math.random()*256);
					int b = (int)(Math.random()*256);
					for (Color c : color) {
						if (new Color(r,g,b) == c) {
							checker = 1;
							break;
						}
					}
					if(checker == 1) {
						checker = 0;
						continue;
					}
					color.add(new Color(r,g,b));
					break;
				}
				deptName.add(rs.getString(1));
			}
			rs.close();
		} catch (Exception e) {
			e.getStackTrace();
		}
		get_angle();
	}
}
