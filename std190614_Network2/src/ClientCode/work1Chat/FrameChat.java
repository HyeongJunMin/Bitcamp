package work1Chat;

import java.awt.Button;
import java.awt.TextArea;
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

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class FrameChat extends JFrame implements WindowListener, ActionListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Socket sck ;
	
	public FrameChat() {
		setBounds(400, 100, 330, 500);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		addMouseMotionListener(this);
		
	}
	
	public FrameChat(Socket sck) {
		super("chat");
		this.sck = sck;
		setBounds(400, 100, 330, 500);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		addMouseMotionListener(this);
		
		this.mkTf();
		this.mkBtn();
	}
	TextField tf;
	TextArea chatBrd;
	JScrollPane jp;
	public void mkTf() {
		chatBrd = new TextArea();
		chatBrd.setBounds(5, 5, 290, 390);
		JPanel p = new JPanel();
		p.add(chatBrd);
		
		tf = new TextField();
		tf.setBounds(5, 395, 230, 30);
		
		add(chatBrd);
		add(p);
		add(tf);
	}
	Button btn1;
	public void mkBtn() {
		btn1 = new Button("send");
		btn1.setBounds(240, 395, 60, 30);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				if( tf.getText().equals("") != false ) {
					String str = tf.getText();
					PrintWriter pw;
					try {
						System.out.println("sck info : " + sck.toString() + "  " + sck.getLocalPort() + "   " + str);
						pw = new PrintWriter(sck.getOutputStream());
						pw.println(str);
						//flush는 중요해요 -> 여기까지 보내겠다! 는 뜻으로 flush를 만나지 못하면 전송이 끝나지 않음
						pw.flush();
						
					} catch (IOException ee) {
						// TODO Auto-generated catch block
						ee.printStackTrace();
					}

				}
			//}
		});
		add(btn1);
	}
	
	public FrameChat(int a) {
		
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
//		if( e.getSource().equals(btn1) ) {
//			//textField가 빈칸이 아니면
//			if( this.tf.getText().equals("") != false ) {
//				String str = this.tf.getText();
//				PrintWriter pw;
//				try {
//					System.out.println("이거됐는데");
//					pw = new PrintWriter(sck.getOutputStream());
//					pw.println(str);
//					//flush는 중요해요 -> 여기까지 보내겠다! 는 뜻으로 flush를 만나지 못하면 전송이 끝나지 않음
//					pw.flush();
//				} catch (IOException ee) {
//					// TODO Auto-generated catch block
//					ee.printStackTrace();
//				}
//
//			}
//		}
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
