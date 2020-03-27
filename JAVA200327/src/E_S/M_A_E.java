package E_S;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class M_A_E extends JFrame{
	
	private JLabel la = new JLabel("No Mouse Event");
	
	public M_A_E() {
		
		setTitle("MouseListener¿Í MouseMotinListener ¿¹Á¦");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				la.setText("mousePressed ("+e.getX()+", "+e.getY()+")");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				la.setText("mouseReleased("+e.getX()+", "+e.getY()+")");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Component c = (Component)e.getSource();
				c.setBackground(Color.cyan);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Component c = (Component)e.getSource();
				c.setBackground(Color.yellow);
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				la.setText("mouseDragged("+e.getX()+", "+e.getY()+")");
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				la.setText("mouseMoved("+e.getX()+", "+e.getY()+")");
			}
		});
		c.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				la.setText("mousePressed ("+e.getX()+", "+e.getY()+")");
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				la.setText("mouseReleased("+e.getX()+", "+e.getY()+")");
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				Component c = (Component)e.getSource();
				c.setBackground(Color.cyan);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				Component c = (Component)e.getSource();
				c.setBackground(Color.yellow);
			}
			@Override
			public void mouseDragged(MouseEvent e) {
				la.setText("mouseDragged("+e.getX()+", "+e.getY()+")");
			}
			@Override
			public void mouseMoved(MouseEvent e) {
				la.setText("mouseMoved("+e.getX()+", "+e.getY()+")");
			}
		});
		
		c.add(la);
		
		setSize(300,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new M_A_E();
	}
}
