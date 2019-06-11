package work1BaseballTeamManagement;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrameSearch extends JFrame implements WindowListener, ActionListener, MouseMotionListener {
	public FrameSearch() {
		super("Search Player");
		
		this.mkBtn();
		this.mkLbl();
		this.mkTxtFld();
		
		setLayout(null);
		setBounds(800, 250, 450, 170);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	JButton btn1, btn2, btn3;
	public void mkBtn() {
		btn1 = new JButton("검색");
		btn2 = new JButton("타자 추가");
		btn3 = new JButton("메인메뉴로 돌아가기");
		
		btn1.setBounds(260, 30, 70, 30);
//		btn2.setBounds(120, 10, 100, 50);
		btn3.setBounds(110, 65, 220, 50);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
		add(btn1);
		add(btn2);
		add(btn3);
	}

	JLabel l1, l2, l3, l4, l5;
	public void mkLbl() {
		l1 = new JLabel("이름");
		l2 = new JLabel("나이");
		l3 = new JLabel("신장");
		l4 = new JLabel("승");
		l5 = new JLabel("패");
		
		l1.setBounds(110, 30, 40, 30);
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
	
	JTextField tf1, tf2, tf3, tf4, tf5;
	public void mkTxtFld() {
		tf1 = new JTextField();
		tf2 = new JTextField();
		tf3 = new JTextField();
		tf4 = new JTextField();
		tf5 = new JTextField();
		
		tf1.setBounds(155, 30, 100, 30);
		tf2.setBounds(70, 90, 150, 30);
		tf3.setBounds(70, 150, 150, 30);
		tf4.setBounds(70, 210, 150, 30);
		tf5.setBounds(70, 270, 150, 30);
		
		add(tf1);
//		add(tf2);
//		add(tf3);
//		add(tf4);
//		add(tf5);		
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
		if( e.getSource().equals(btn1) ) {
			try {
				String name = tf1.getText();
				
				Iterator it = TeamDAOSingleton.team.keySet().iterator();
				
				int key;
				while( it.hasNext() ) {
					key = (int)it.next();
					if ( TeamDAOSingleton.team.get(key).getName().equals(name) ) {
						new FrameSearchResult(key);
						
						
						
						break;
					}
					if( it.hasNext() == false ) {
						JOptionPane.showMessageDialog(null, "검색 결과가 없습니다.");
					}
				}				
		
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
	
}
