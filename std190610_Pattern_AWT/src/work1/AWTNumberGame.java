package work1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JOptionPane;

public class AWTNumberGame extends Frame implements WindowListener, ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Label l1, l2, l3;
	Button b1, b2, b3;
	TextField tf;
	int result = 0, rnd = 0, inputNum;
	
	public AWTNumberGame() {
		super("number game");
		this.setBounds(1100, 300, 300, 200);
		setVisible(true);
		addWindowListener(this);
		this.setLayout(null);
		
		
		this.mklbl();
		this.mkBtn();
		this.mktxt();
		tf.requestFocusInWindow();
	}
	
	public void mklbl() {
		l1 = new Label("rnd");
		l2 = new Label("1~10 정수를 입력하세요.");
		l3 = new Label();
		l1.setName("l1");
		l1.setBounds(90, 170, 40, 30);
		
		rnd = (int) (Math.random() * 80) + 20;
		l1.setText(rnd+"");
		
		l2.setName("l2");
		l2.setBounds(76,30,200,30);
		
		add(l1);
		add(l2);
	}
	
	public void mkBtn() {
		b1 = new Button();
		b2 = new Button();
		b3 = new Button();

		b1.setName("input");
		b1.setLabel("입력값으로 시도!");
		b1.setBounds(90, 90, 100, 40);
		b2.setName("reset");
		b2.setLabel("reset");
		b2.setBounds(90, 130, 100, 40);

		b1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					inputNum = Integer.parseInt( tf.getText() );

					if ( inputNum > 10 || inputNum < 0 ) {
						tf.setText("1~10똑바로");
					} else {
						rnd -= inputNum;
						tf.setText("");
						tf.requestFocusInWindow();
					}
				}catch(Exception e1) {
					tf.setText("1~10똑바로");
					
				}finally {
					tf.requestFocusInWindow();
				}
				
				if(rnd <= 0) {
					tf.setText("***겜터짐***");
				}
				l1.setText(rnd+"");
			}
		});
		
		b2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				rnd = (int) (Math.random() * 80) + 20;
				l1.setText(rnd+"");
				tf.setText("다시 ㄱ");
				tf.requestFocusInWindow();
			}
		});
				
		add(b1);
		add(b2);		
	}

	public void mktxt() {
		tf = new TextField();
		tf.setName("tf");
		tf.setBounds(90, 70, 100, 20);
		
		add(tf);
		tf.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					inputNum = Integer.parseInt( tf.getText() );

					if ( inputNum > 10 || inputNum < 0 ) {
						tf.setText("1~10똑바로");
					} else {
						rnd -= inputNum;
						tf.setText("");
						tf.requestFocusInWindow();
					}
				}catch(Exception e1) {
					tf.setText("1~10똑바로");
					
				}finally {
					tf.requestFocusInWindow();
				}
				
				if(rnd <= 0) {
					tf.setText("***겜터짐***");
				}
				l1.setText(rnd+"");
			}
		});
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button btIn = (Button)e.getSource();
		String btInName = btIn.getLabel();
		
		if( btInName.equals(b1.getName())) {
			
		}else if( btInName.equals( "reset" ) ) {
			JOptionPane.showMessageDialog(null, "Label");
		}else {
			
		}
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
