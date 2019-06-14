package work1Chat2;

import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class FrameLogin extends JFrame implements ActionListener, WindowListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FrameChat2 fc;
	public FrameLogin(FrameChat2 fc) {
		super("Set ID");
		this.fc = fc;
		
		setBounds(450, 150, 220, 100);
		setVisible(true);
		setLayout(null);

		addWindowListener(this);
		addMouseMotionListener(this);
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//			// TODO Auto-generated method stub
//			System.exit(0);
//			}			
//		});
		setAlwaysOnTop(true);
		mkBtn();
		mkTf();
	}
	Button btn1;
	public void mkBtn() {
		btn1 = new Button("Login");
		btn1.setBounds(140, 20, 60, 30);
		add(btn1);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fc.id = tf1.getText();
				dispose();
			}
		});
	}
	TextField tf1;
	public void mkTf() {
		tf1 = new TextField();
		tf1.setBounds(10, 20, 120, 30);
		add(tf1);
		tf1.requestFocus();
		tf1.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				fc.id = tf1.getText();
				dispose();
			}
		});
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		
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
		
	}

}
