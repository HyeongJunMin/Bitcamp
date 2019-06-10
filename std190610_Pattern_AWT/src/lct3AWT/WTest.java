package lct3AWT;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class WTest extends Frame implements WindowListener, ActionListener {

	Label lbl1 ;
	Label lbl2 ;
	Label l1, l2, l3;
	String str = "";
	int result = 0, rnd = 0;
	Button btn1, btn2, btn4, b1, b2, b3, b4 ;
	TextField tf ;
	JTextArea jt;
	
	
	public WTest() {
		// TODO Auto-generated constructor stub
		super("about layout");
		this.setBounds(500, 300, 1280, 480);
		setVisible(true);
		addWindowListener(this);
		
//		setLayout(new FlowLayout());
//		setLayout(new GridLayout(5, 5));
		setLayout(null);
		
		this.addlbl1();
		this.addbtn1();
		this.addtxtf();
		this.jpWrite();
		this.runGame();
//		JOptionPane.showMessageDialog(null, "뀨");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button btn3 = (Button)e.getSource();
		String btn3Name = btn3.getLabel();
		if( btn3Name.equals("Button")) {
			lbl1.setText("btn1111111");
			result = Integer.parseInt(lbl2.getText());
			lbl2.setText((result+1)+"");
		} else if (btn3Name.equals("Button2")) {
			lbl1.setText("btn22222222222");
			result = Integer.parseInt(lbl2.getText());

			if (result <= 0) {

			} else {
				lbl2.setText((result - 1) + "");
			}
		} else if (btn3Name.equals("Button4")) {
			lbl2.setText("0");
		} else if (btn3Name.equals("reset") ) {
			lbl2.setText("0");
			rnd = (int) (Math.random() * 80) + 20;
			tf.setText(rnd + "");
		} else {
			JOptionPane.showMessageDialog(null, "Label");
		}
	}
	
	public void addlbl1() {
		lbl1 = new Label("Label");
		lbl1.setBackground(new Color(255, 140, 190));
		lbl1.setBounds(10, 30, 1280, 15);
		lbl2 = new Label("0");
		lbl2.setBounds(170, 80, 50, 38);
		add(lbl1);
		add(lbl2);
		
		l1 = new Label("rnd");
		l2 = new Label("result");
		l1.setBounds(800, 200, 50, 50);
		l2.setBounds(800, 120, 50, 50);
		add(l1);
		add(l2);
	}
	
	public void addbtn1() {
		btn1 = new Button();
		btn2 = new Button();
		btn4 = new Button();
		btn1.setLabel("Button");
		btn2.setLabel("Button2");
		btn4.setLabel("Button4");
		btn1.setBounds(80, 120, 100, 50);
		btn2.setBounds(190, 120, 100, 50);
		btn4.setBounds(80, 175, 210, 50);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn4.addActionListener(this);
		
		add(btn1);
		add(btn2);
		add(btn4);
		
		b1 = new Button();
		b2 = new Button();
		b3 = new Button();
		b1.setBounds(700, 120, 100, 50);
		b1.setLabel("입력");
		b2.setBounds(700, 170, 100, 50);
		b2.setLabel("reset");
		b2.setName("reset");
		
		add(b1);
		add(b2);
	}
	
	public void addtxtf() {
		tf = new TextField();
		tf.setName("tf");
		tf.setBounds(700, 100, 80, 20);
		
		tf.setText("");
		add(tf);
		
		jt = new JTextArea();
		jt.setBounds(20,250, 1200, 200);
		jt.setEditable(true);
		
		JScrollPane jp = new JScrollPane();
		jp.setBounds(20, 250, 1200, 200);
		jp.setVisible(true);
		this.add(jp);
		jp.getViewport().add(jt);
		
		
	}
	
	public void runGame() {
		rnd = (int)(Math.random()*80)+20;
		tf.setText(rnd+"");
	}
	
	public void jpWrite() {
		PitcherDTO p;
		BatterDTO b;
		FileIO.getInstance();
		String text = "";
		
		Iterator it = FileIO.team.keySet().iterator();
		text += "선수번호\t구분\t이름\t나이\t신장\t승\t패\t승률\t타석\t유효타\t타율\n";
		while( it.hasNext() ) {
			int k = (int)it.next();
			if( FileIO.team.get(k) instanceof PitcherDTO) {
				p = (PitcherDTO)FileIO.team.get(k);
				text += p.getNum() + "\t투수\t";
				text += p.getName() + "\t";
				text += p.getAge() + "\t";
				text += p.getHeight() + "\t";
				text += p.getWin() + "\t";
				text += p.getLose() + "\t";
				text += p.getDefenceRate() + "\n";
			}else {
				b = (BatterDTO)FileIO.team.get(k);
				text += b.getNum() + "\t타자\t";
				text += b.getName() + "\t";
				text += b.getAge() + "\t";
				text += b.getHeight() + "\t\t\t\t";
				text += b.getSwing() + "\t";
				text += b.getHit() + "\t";
				text += b.getHitRate() + "\n";
			}
			
		}
		jt.setText(text);
	}
	
	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
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
