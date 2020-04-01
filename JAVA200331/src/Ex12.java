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
		JMenu fileMenu = new JMenu("����");
		
		// Color �޴������ۿ� Action ������ ���
		colorMenuItem.addActionListener(new MenuActionListener());
		
		fileMenu.add(colorMenuItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	// Color �޴��������� ���õ� �� ����Ǵ� Action ������
	class MenuActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand(); // �޴��������� �̸� ����
			if(cmd.equals("Color")) { // Color �޴��������� ���
				// �÷� ���̾�α׸� ����ϰ� ����ڰ� ������ ���� �˾ƿ´�.
				Color selectedColor = JColorChooser.showDialog(null,"Color",Color.YELLOW);
				
				// ��� ��ư�� �����ų� �׳� ���̾�α׸� �ݴ� ��� selectedColor�� null�̴�.
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
					repaint();//������ �ٷ� �� ��츦 ����
					
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
				//ù��° ���̰ų� ���� ���� ������ ���̸�
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