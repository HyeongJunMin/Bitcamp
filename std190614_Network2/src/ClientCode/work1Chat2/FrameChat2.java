package work1Chat2;

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

public class FrameChat2 extends JFrame implements ActionListener, WindowListener, MouseMotionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public TextArea chatBrd;	//외부에서 접근할 수 있도록 public 설정
	public String id;
	TextField tf;
	JScrollPane jp;
	Button btn1;
	Socket sck;	
	
	public FrameChat2(Socket sck) {
		this.sck = sck;
		new ReadThread2(sck, this).start();	//스레드에 소켓과 프레임인스턴스 전달
		setBounds(400, 100, 330, 500);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		addMouseMotionListener(this);
		mkTf();
		mkBtn();
	}


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
		tf.addActionListener(this);
	}
	
	public void mkBtn() {
		btn1 = new Button("send");
		btn1.setBounds(240, 395, 60, 30);
		
		btn1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if( tf.getText().equals("") ) {
					System.out.println("텍스트필드 비어있음");
				}else {
					String str = tf.getText();
					try {
						chatBrd.append(id + " : "+str+"\n");
						System.out.println("Run Socket Info : " + sck.toString());
						PrintWriter pw = new PrintWriter(sck.getOutputStream());
						pw.println(id + " : " + str);
						pw.flush();
						tf.setText("");
					} catch (IOException e1) {
						System.out.println("Window Form Write Exception");
					}
				}
			}
		});
		
		add(btn1);
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
		//엔터키 입력시 메시지 전송 및 textField 초기화
		if( tf.getText().equals("") ) {
			System.out.println("텍스트필드 비어있음");
		}else {
			String str = tf.getText();
			try {
				chatBrd.append(id + " : "+str+"\n");
				System.out.println("Run Socket Info : " + sck.toString());
				PrintWriter pw = new PrintWriter(sck.getOutputStream());
				pw.println(id + " : " + str);
				pw.flush();
				tf.setText("");
			} catch (IOException e1) {
				System.out.println("Window Form Write Exception");
			}
		}
		
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
