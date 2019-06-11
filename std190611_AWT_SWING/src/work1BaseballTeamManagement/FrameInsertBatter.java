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
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrameInsertBatter extends JFrame implements WindowListener, ActionListener, MouseMotionListener {
	public FrameInsertBatter() {
		super("Insert Batter");
		
		mkBtn();
		mkTxtFld();
		mkLbl();
		
		setLayout(null);
		setBounds(820, 270, 250, 500);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
		
		addMouseMotionListener(this);
	}
	JLabel l1, l2, l3, l4, l5;
	public void mkLbl() {
		l1 = new JLabel("이름");
		l2 = new JLabel("나이");
		l3 = new JLabel("신장");
		l4 = new JLabel("타석");
		l5 = new JLabel("유효타");
		
		l1.setBounds(20, 30, 40, 30);
		l2.setBounds(20, 90, 40, 30);
		l3.setBounds(20, 150, 40, 30);
		l4.setBounds(20, 210, 40, 30);
		l5.setBounds(20, 270, 40, 30);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
	}
	
	JTextField tf1, tf2, tf3, tf4, tf5;
	public void mkTxtFld() {
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		
		tf1.setBounds(70, 30, 150, 30);
		tf2.setBounds(70, 90, 150, 30);
		tf3.setBounds(70, 150, 150, 30);
		tf4.setBounds(70, 210, 150, 30);
		tf5.setBounds(70, 270, 150, 30);
		
		add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);		
	}
	
	JButton btn1, btn2, btn3;
	public void mkBtn() {
		btn1 = new JButton("추가");
		btn2 = new JButton("초기화");
		btn3 = new JButton("메인메뉴로 돌아가기");
		
		btn1.setBounds(10, 335, 100, 30);
		btn2.setBounds(120, 335, 100, 30);
		btn3.setBounds(10, 380, 210, 30);
		
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
			try {
				String name = tf1.getText();
				int age = Integer.parseInt(tf2.getText());
				double height = Double.parseDouble(tf3.getText());
				int swing = Integer.parseInt(tf4.getText());
				int hit = Integer.parseInt(tf5.getText());
				double hitR = (swing == 0) ? 0.0 : ((double) hit) / (swing);
				BatterDTO b = new BatterDTO(TeamDAOSingleton.team.size() + 1, name, age, height, swing, hit, hitR);
				TeamDAOSingleton.team.put(TeamDAOSingleton.team.size() + 1, b);
				JOptionPane.showMessageDialog(null, name + "선수 입력 성공!");
				FncFileIO.syncListToFile();
				MainFrame.l.add(b.toString());
			} catch (Exception ee) {
				JOptionPane.showMessageDialog(null, "입력오류. 다시입력하세요.");
			}
			
			
		}else if( e.getSource().equals(btn2) ) {
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	int posX, posY;
	JLabel ll1 = new JLabel(); 
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		posX = e.getX();
		posY = e.getY();
		ll1.setText("x = " + posX + " y = " + posY);
		ll1.setBounds(e.getX(), e.getY() - 20, 200, 50);
	}

}
