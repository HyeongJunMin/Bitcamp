package lct2AWTWindow;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class AWTSingletonChange {
	private static AWTSingletonChange single = null;
	public Sub s;
	public Front f;
	private AWTSingletonChange() {
		f = new Front();
		s = new Sub();
		f.setVisible(true);
	}
	
	public void fV() {
		if(f.isVisible()) {
			f.setVisible(false);
		}else {
			f.setVisible(true);
		}
	}
	
	public void SV() {
		if(s.isVisible()) {
			s.setVisible(false);
		}else {
			s.setVisible(true);
		}
	}
	
	
	public static AWTSingletonChange getInstance() {
		if( single == null ) {
			single = new AWTSingletonChange();
		}
		return single;
	}
}
class Sub extends Frame implements WindowListener, ActionListener{
	public Sub() {
		super("BackWindow");
		setLayout(null);
		Button btn = new Button("Back");
		btn.setBounds(100, 100, 100, 50);
		btn.addActionListener(this);
		add(btn);
		
		setSize(640, 480);
		setLocation(100, 100);
		setBackground(new Color(160,240,160));
		setVisible(false);
		
		addWindowListener(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AWTSingletonChange s = AWTSingletonChange.getInstance();
		s.fV();
		s.SV();
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}

class Front extends Frame implements WindowListener, ActionListener{
	public Front() {
		super("FrontWindow");
		setLayout(null);
		Button btn = new Button("Move");
		btn.setBounds(100, 100, 100, 50);
		btn.addActionListener(this);
		add(btn);
		
		setSize(640, 480);
		setLocation(100, 100);
		setBackground(new Color(240,160,160));
		setVisible(false);
		
		addWindowListener(this);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		AWTSingletonChange s = AWTSingletonChange.getInstance();
		s.fV();
		s.SV();
	}	
}
