package lct1Swing;

import java.awt.*;
import javax.swing.*;

public class WindowTest extends JFrame {
	public WindowTest() {
		super("swing 스윙이다 스윙");
		setLayout(new GridLayout(2,2));
		setSize(640, 480);
		setLocation(0,0);
		setVisible(true);
		
		
		this.mkLbl();
		this.mkPnl();
		
		
		
		//윈도우리스너 상속받을 필요 없이 꺼짐기능 갖출 수 있음
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
	}
	JLabel l1;
	JLabel l2;
	JLabel l3;
	public void mkLbl() {
		l1 = new JLabel("Label1");
		l2 = new JLabel("Label2");
		l3 = new JLabel("Label3");
		l1.setFont(new Font("야호", NORMAL, 80));
		add(l1);
	}
	
	JButton btn1 = new JButton("btn1");
	JButton btn2 = new JButton("btn2");
	JButton btn3 = new JButton("btn3");
	JButton btn4 = new JButton("btn4");
	public void mkBtn() {
		
	}
	
	void mkPnl() {
		JPanel pnl1 = new JPanel();
		JPanel pnl2 = new JPanel();
		JPanel pnl3 = new JPanel();
		pnl1.setBackground(Color.white);
		pnl1.setLayout(new GridLayout(4,4));
		pnl2.setBackground(Color.black);
		pnl2.setLayout(new GridLayout(4,4));
		pnl3.setBackground(Color.cyan);
		pnl3.setLayout(new GridLayout(4,4));
		add(pnl1);
		add(pnl2);
		add(pnl3);
		
		pnl1.add(l2);
		pnl1.add(btn1);
		pnl1.add(btn2);
		pnl1.add(btn3);
		pnl1.add(btn4);		
	}
}
