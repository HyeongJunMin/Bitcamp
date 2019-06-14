package work4RSP;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import workDTO.RSPDTO;

public class Work4ClientFrame extends JFrame implements ActionListener, WindowListener, MouseMotionListener {
	
	Socket sck;
	JButton btn1, btn2, btn3, btn4;
	public JLabel lbl1, lblId, lbl2, lbl3;
	public String inputDone = "ready";
	public RSPDTO rspDTO;
	
	public Work4ClientFrame() {
		
	}
	
	public Work4ClientFrame(Socket sck) {
		super("Rock, Scissor, Paper!");
		this.sck = sck;
		setBase();
		mkBtn();
		mkLbl();
		new Work4ClientThread(sck, this).start();
	}
	
	public void setBase() {
		setBounds(400, 100, 350, 330);
		setVisible(true);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
	}
	
	public void mkBtn() {
		btn1 = new JButton("Rock");
		btn1.setBounds(20, 90, 100, 50);
		add(btn1);
		btn1.addActionListener(this);
		
		btn2 = new JButton("Scissor");
		btn2.setBounds(120, 90, 100, 50);
		add(btn2);
		btn2.addActionListener(this);
		
		btn3 = new JButton("Paper");
		btn3.setBounds(220, 90, 100, 50);
		add(btn3);
		btn3.addActionListener(this);
	}
	
	public void mkLbl() {
		lbl1 = new JLabel();
		lbl1.setText("가위바위보 게임!");
		lbl1.setBounds(30, 1, 400, 50);
		lbl1.setFont(new Font("돋움", Font.PLAIN, 35));
		add(lbl1);
		
		lblId = new JLabel();
		lblId.setText("플레이어 1");
		lblId.setBounds(120, 40, 400, 50);
		lblId.setFont(new Font("돋움", Font.PLAIN, 20));
		add(lblId);
		
		lbl2 = new JLabel();
		lbl2.setText("상태 : 매칭 대기중 ...");
		lbl2.setBounds(30, 140, 200, 30);
		add(lbl2);
		
		lbl3 = new JLabel();
		lbl3.setText("결과 : ");
		lbl3.setBounds(30, 200, 200, 30);
		add(lbl3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		//inputDone이 ready이면 제출가능
		//클릭이 완료되면 더 이상 클릭 불가(inputDone="done")
		try {
		ObjectOutputStream oos = new ObjectOutputStream(sck.getOutputStream());
		
		if( inputDone.equals("ready")) {
			if( e.getSource().equals(btn1) ) {
				//바위 클릭
				rspDTO = new RSPDTO(0);
				lbl2.setText("상태 : 바위! 제출 완료");
				
				oos.writeObject(rspDTO);
				
				inputDone = "done";
			} else if( e.getSource().equals(btn2) ) {
				//가위 클릭
				rspDTO = new RSPDTO(1);
				lbl2.setText("상태 : 가위! 제출 완료");
				
				oos.writeObject(rspDTO);
				
				inputDone = "done";
			} else if( e.getSource().equals(btn3) ) {
				//보 클릭
				rspDTO = new RSPDTO(2);
				lbl2.setText("상태 : 보! 제출 완료");
				
				oos.writeObject(rspDTO);
				
				inputDone = "done";
			}
			
		}
		
		} catch(Exception ee) {
			System.out.println("데이터 송신 오류");
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
