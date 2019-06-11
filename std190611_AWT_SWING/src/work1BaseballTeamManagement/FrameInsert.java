package work1BaseballTeamManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FrameInsert extends JFrame implements WindowListener, ActionListener{
	public FrameInsert() {
		super("Insert New Info");
		
		mkBtn();
		
		setLayout(null);
		setBounds(800, 250, 250, 170);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	JButton btn1, btn2, btn3;
	public void mkBtn() {
		btn1 = new JButton("투수 추가");
		btn2 = new JButton("타자 추가");
		btn3 = new JButton("메인메뉴로 돌아가기");
		
		btn1.setBounds(10, 10, 100, 50);
		btn2.setBounds(120, 10, 100, 50);
		btn3.setBounds(10, 65, 210, 50);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		add(btn1);
		add(btn2);
		add(btn3);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btn1) ) {
			new FrameInsertPitcher();
		}else if( e.getSource().equals(btn2) ) {
			new FrameInsertBatter();
		}else if(e.getSource().equals(btn3) ) {
			this.dispose();
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
