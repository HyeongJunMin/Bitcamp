package work1BaseballTeamManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class FramePrintAll extends JFrame implements WindowListener, ActionListener, MouseMotionListener{
	JButton btn1 ;
	public FramePrintAll() {
		super("Baseball Team Member");
		
		
		JTextArea ta = new JTextArea();
		ta.setBounds(5, 5, 1025, 320);
		add(ta);
		
		ta.append("선수번호\t구분\t이름\t나이\t신장\t승\t패\t승률\t타석\t유효타\t타율");
		
		TeamDAOSingleton t = TeamDAOSingleton.getInstance();
		int number = 0;
		String name = "";
		int age = 0;
		double height = 0;
		int winOrSwing = 0;
		int loseOrHit = 0;
		double dfcOrHitRate = 0.0;
		PitcherDTO ptc;
		BatterDTO btt;

		for (int i = 1; i < TeamDAOSingleton.team.size() + 1; i++) {
			if (TeamDAOSingleton.team.get(i) instanceof PitcherDTO) { // 투수인 경우
				ptc = (PitcherDTO) TeamDAOSingleton.team.get(i);
				number = ptc.getNum();
				name = ptc.getName();
				age = ptc.getAge();
				height = ptc.getHeight();
				winOrSwing = ptc.getWin();
				loseOrHit = ptc.getLose();
				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) winOrSwing) / (winOrSwing + loseOrHit);
				dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
				ta.append("\n" + number + "\t투수\t" + name + "\t" + age + "\t" + height + "\t" + winOrSwing + "\t"
						+ loseOrHit + "\t" + dfcOrHitRate);
			} else { // 타자인 경우
				btt = (BatterDTO) TeamDAOSingleton.team.get(i);
				number = btt.getNum();
				name = btt.getName();
				age = btt.getAge();
				height = btt.getHeight();
				winOrSwing = btt.getSwing();
				loseOrHit = btt.getHit();
				dfcOrHitRate = ((winOrSwing + loseOrHit) == 0) ? 0.0 : ((double) loseOrHit) / (winOrSwing);
				dfcOrHitRate = (Math.round(dfcOrHitRate * 100)) / 100.0;
				ta.append("\n" + number + "\t타자\t" + name + "\t" + age + "\t" + height + "\t\t\t\t" + winOrSwing + "\t"
						+ loseOrHit + "\t" + dfcOrHitRate);
			}
		}

		setLayout(null);
		setBounds(770, 250, 1050, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);

		
		btn1 = new JButton("메인메뉴로 돌아가기");
		btn1.setBounds(0,330,1035,30);
		add(btn1);
		btn1.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btn1)) {
			this.dispose();
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
