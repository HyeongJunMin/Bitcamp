package work2SetTurn;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Work2ClientFrame  extends JFrame implements WindowListener, MouseMotionListener, ActionListener{
	JLabel lbl1;
	TextField tf1;
	Socket sck;
	JButton btn1;
	public boolean btnVisible = true;
	
	public Work2ClientFrame() {
		setBounds(400, 100, 230, 200);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		addMouseMotionListener(this);
		
		this.mkDefaultSet();
	}
	
	public Work2ClientFrame(Socket sck) {
		this.sck = sck;
		setBounds(400, 100, 230, 200);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		addMouseMotionListener(this);
		
		this.mkDefaultSet();
		
		new Work2ClientThread(sck, this).start();
	}
	
	public void mkDefaultSet() {
		lbl1 = new JLabel("Client");
		lbl1.setBounds(90, 30, 200, 30);
		add(lbl1);
		
		tf1 = new TextField();
		tf1.setBounds(5, 60, 200, 30);
		add(tf1);
		tf1.setText("Client Num : 0");
		
		btn1 = new JButton("클릭");
		btn1.setBounds(5, 100, 200, 30);
		btn1.setText("클릭하세요");
		add(btn1);
		tf1.setText("can use");
		btn1.setVisible(btnVisible);
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (btnVisible == true) {
					try {
						PrintWriter pw = new PrintWriter(sck.getOutputStream());
						pw.println(btnVisible);
						pw.flush();
						tf1.setText("can not use");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
	}
	
	public void setTf(String str) {
		tf1.setText(str);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
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
	

}
