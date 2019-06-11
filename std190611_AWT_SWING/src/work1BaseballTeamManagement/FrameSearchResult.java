package work1BaseballTeamManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameSearchResult  extends JFrame implements WindowListener, ActionListener, MouseMotionListener {

	public FrameSearchResult() {
		super("Player Info");
		
		this.mkBtn();
		this.mkLbl();
		
		
		setLayout(null);
		setBounds(800, 250, 550, 170);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public FrameSearchResult(int i) {
		this();
		l1.setText(TeamDAOSingleton.team.get(i).toString());
	}
	
	JButton btn1, btn2, btn3;
	public void mkBtn() {
		btn1 = new JButton("검색");
		btn2 = new JButton("타자 추가");
		btn3 = new JButton("메인메뉴로 돌아가기");
		
		btn1.setBounds(260, 30, 70, 30);
//		btn2.setBounds(120, 10, 100, 50);
		btn3.setBounds(110, 85, 220, 30);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
//		add(btn1);
//		add(btn2);
		add(btn3);
	}

	JLabel l1, l2, l3, l4, l5;
	public void mkLbl() {
		l1 = new JLabel("이름");
		l2 = new JLabel("나이");
		l3 = new JLabel("신장");
		l4 = new JLabel("승");
		l5 = new JLabel("패");
		
		l1.setBounds(5, 30, 545, 30);
		l2.setBounds(20, 90, 40, 30);
		l3.setBounds(20, 150, 40, 30);
		l4.setBounds(20, 210, 40, 30);
		l5.setBounds(20, 270, 40, 30);
		
		add(l1);
//		add(l2);
//		add(l3);
//		add(l4);
//		add(l5);
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
		if(e.getSource().equals(btn3) ) {
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
