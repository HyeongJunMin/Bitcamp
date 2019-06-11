package lct1Swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class SwingMouseEvent extends JFrame implements MouseListener, MouseMotionListener{
	JLabel l1;
	int posX, posY;
	
	public SwingMouseEvent() {
		super("Mouse Events");
		setLayout(null);
		
		l1 = new JLabel("x = y = ");
		l1.setBounds(50, 100, 200, 50);
		add(l1);
		
		setBounds(0, 0, 640, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addMouseListener(this);	//현재 프레임에 리스너 추가
		addMouseMotionListener(this);
	}
	


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
//		JOptionPane.showMessageDialog(null, "fff");
		posX = e.getX();
		posY = e.getY();
		l1.setText("x = " + posX + " y = " + posY);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		posX = e.getX();
		posY = e.getY();
		l1.setText("x = " + posX + " y = " + posY);
		l1.setBounds(e.getX(), e.getY() - 20, 200, 50);
	}
	
}
