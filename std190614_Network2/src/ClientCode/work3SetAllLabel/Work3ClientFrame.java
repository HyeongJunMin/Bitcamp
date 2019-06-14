package work3SetAllLabel;

import java.awt.Button;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;

public class Work3ClientFrame extends JFrame implements WindowListener, ActionListener{

	Socket sck;
	public Label lbl1, lbl2;
	public String lblStr;
	Button btn1, btn2;
	
	public Work3ClientFrame(Socket sck) {
		super("work3 set all label");
		System.out.println("sck ok");
		this.sck = sck;
		setBase();
		
		mkBtn();
		mkLbl();
		
		new Work3ClientThread(sck, this).start();
	}
	
	public void setBase() {
		setBounds(400, 100, 230, 130);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
	}
	
	public void mkBtn() {
		btn1 = new Button("1");
		btn1.setBounds(6, 1, 100, 30);
		add(btn1);
		btn1.addActionListener(this);
		
		btn2 = new Button("2");
		btn2.setBounds(110, 1, 100, 30);
		add(btn2);
		btn2.addActionListener(this);
	}
	
	public void mkLbl() {
		lbl1 = new Label("1");
		lbl1.setBounds(50, 45, 50, 30);
		add(lbl1);
		
		lbl2 = new Label("2");
		lbl2.setBounds(150, 45, 50, 30);

		add(lbl2);
	}
	
	//버튼 클릭하면 그에 맞는 숫자를 서버로 보내도록 이벤트 설정
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btn1) ) {
			
			PrintWriter pw;
			try {
				pw = new PrintWriter(sck.getOutputStream());
				pw.println("1");
				pw.flush();
				System.out.println("btn output ok : 1");
			} catch (IOException e1) {
				System.out.println("btn output ex");
			}
			
			
		}else if( e.getSource().equals(btn2) ) {
			
			PrintWriter pw;
			try {
				pw = new PrintWriter(sck.getOutputStream());
				pw.println("2");
				pw.flush();
				System.out.println("btn output ok : 2");
			} catch (IOException e1) {
				System.out.println("btn output ex");
			}
		}
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
