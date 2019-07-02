package lct2MVC2_view;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import lct2MVC2_single.Singleton;

public class View_Login extends JFrame implements ActionListener, WindowListener {

	JLabel lblId, lblPw;
	JButton btnLogin, btnSignin;
	TextField txtId, txtPw;
	
	public View_Login() {
		super("Login");		
		setLayout(null);
		setBounds(1000, 350, 240, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		
//		dao = MemDAO.getInstance();
		
		mkLbl();
		mkBtn();
		mkTxt();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}
	
	public void mkLbl() {
		 lblId = new JLabel("ID : ");
		 lblId.setBounds(20,30,50,30);
		 add(lblId);
		 
		 lblPw = new JLabel("PW : ");
		 lblPw.setBounds(20,60,50,30);
		 add(lblPw);
	}
	
	public void mkBtn() {
		Singleton s = Singleton.getInstance();
		btnLogin = new JButton("Login");
		btnLogin.setBounds(20, 110, 80, 30);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				boolean b = s.memCtrl.idChk(txtId.getText());
				
				if( b ) {
					b = s.memCtrl.pwChk(txtPw.getText());
					if( b ) {
						
						
						if( s.memCtrl.isAdmin(txtId.getText()) ) {
							JOptionPane.showMessageDialog(null, "Hello Admin!");
							s.memCtrl.admin();
						}else {
							JOptionPane.showMessageDialog(null, "login success");
							s.memCtrl.board(txtId.getText());
						}
						
						dispose();
					}else {
						JOptionPane.showMessageDialog(null, "wrong pw");
					}					
				}else {
					JOptionPane.showMessageDialog(null, "wrong id");
				}
			}
		});
		
		btnSignin = new JButton("Sign in");
		btnSignin.setBounds(110, 110, 80, 30);
		add(btnSignin);
		btnSignin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Singleton.getInstance().memCtrl.regi();

				dispose();
			}
		});
	}
	
	public void mkTxt() {
		txtId = new TextField();
		txtId.setBounds(70, 30, 100, 30);
		add(txtId);
		
		txtPw = new TextField();
		txtPw.setBounds(70, 60, 100, 30);
		add(txtPw);
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
