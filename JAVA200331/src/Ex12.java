import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import MenuAndColorChooserEx.MenuActionListener;

public class Ex12 extends JFrame{

	private MyPanel panel=new MyPanel();
	
	public Ex12() {
		this.setTitle("Graphic");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setContentPane(panel);
		
		createMenu();
		
		this.setSize(500, 500);
		this.setVisible(true);
	}
	
	private void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem colorMenuItem = new JMenuItem("Color");
		JMenu fileMenu = new JMenu("설정");
		
		// Color 메뉴아이템에 Action 리스너 등록
		colorMenuItem.addActionListener(new MenuActionListener());
		
		fileMenu.add(colorMenuItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	// Color 메뉴아이템이 선택될 때 실행되는 Action 리스너
	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); // 메뉴아이템의 이름 리턴
			if(cmd.equals("Color")) { // Color 메뉴아이템의 경우
				// 컬러 다이얼로그를 출력하고 사용자가 선택한 색을 알아온다.
				Color selectedColor = JColorChooser.showDialog(null,"Color",Color.YELLOW);
				
				// 취소 버튼을 누르거나 그냥 다이얼로그를 닫는 경우 selectedColor는 null이다.
				if(selectedColor != null) 
					panel.getting(selectedColor);
			}
		}
	}

		
	class MyPanel extends JPanel{

		private ArrayList<Point> aPoint=new ArrayList<Point>();		
		private ArrayList<Boolean> aPointFlag=new ArrayList<Boolean>();
		
		Point startP;
		Point endP;
		
		public MyPanel() {
			addMouseMotionListener(new MouseMotionListener() {

				@Override
				public void mouseDragged(MouseEvent e) {
					
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
					repaint();
				}

				@Override
				public void mouseMoved(MouseEvent e) {}
			});
			
			addMouseListener(new MouseListener() {
				@Override
				public void mousePressed(MouseEvent e) {
					aPoint.add(e.getPoint());
					aPointFlag.add(false);
				}
				@Override
				public void mouseReleased(MouseEvent e) {
					aPointFlag.remove(aPointFlag.size()-1);	
					aPointFlag.add(true);
					repaint();//눌렀다 바로 띈 경우를 위해
					
				}
				@Override
				public void mouseClicked(MouseEvent arg0) {}
				@Override
				public void mouseEntered(MouseEvent e) {}
				@Override
				public void mouseExited(MouseEvent e) {}
				
				
				});
		}
		Color selectedColor = Color.black;
		
		void getting(Color selectedColor) {
			
			this.selectedColor = selectedColor;
			
		}
		@Override
		protected void paintComponent(Graphics g) {			
			super.paintComponent(g);
			g.setColor(selectedColor);
			for(int i=0;i<aPoint.size();i++) {
				//첫번째 점이거나 이전 점이 마지막 점이면
				if(i==0 || aPointFlag.get(i-1)==true) {
					startP=aPoint.get(i);					
				}				
				
				endP=aPoint.get(i);
				g.drawLine((int)startP.getX(), (int)startP.getY(), (int)endP.getX(), (int)endP.getY());
				startP=endP;				
			}			
		}		
	}
	public static void main(String[] args) {
		new Ex12();
	}
}