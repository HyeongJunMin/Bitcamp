package lct1MVCModel1;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class View_Login extends JFrame implements ActionListener, WindowListener {

	JLabel lblId, lblPw;
	JButton btnLogin, btnSignin;
	TextField txtId, txtPw;
	MemDAO dao;
	
	public View_Login() {
		super("Login");		
		setLayout(null);
		setBounds(1000, 350, 240, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
		
		dao = MemDAO.getInstance();
		
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
		btnLogin = new JButton("Login");
		btnLogin.setBounds(20, 110, 80, 30);
		add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemDTO dto = null;
				String inputId = null;
				String inputPw = null;
				try {
					inputId = txtId.getText();
					inputPw = txtPw.getText();
				} catch(Exception ee) {
					JOptionPane.showMessageDialog(null, "Input Exception");
				}
				
				dto = dao.hm.get(inputId);
				System.out.println(dao.hm.toString());
				if( dto == null ) {//ID없음
					JOptionPane.showMessageDialog(null, "Invalid Account. plz Retry or Sign in");
				}else {	//ID있음
					if(dto.getPw().equals(inputPw)) {
						dao.currId = dto.getId();
						if(dto.getId().equals("1")) {
							JOptionPane.showMessageDialog(null, "Manager Login.");
							new View_Mgr();
						}else {
							JOptionPane.showMessageDialog(null, "Login Success.");							
							new View_Board();
						}
					}else {
						JOptionPane.showMessageDialog(null, "Wrong Password.");
					}
					
				}
				
			}
		});
		
		
		btnSignin = new JButton("Sign in");
		btnSignin.setBounds(110, 110, 80, 30);
		add(btnSignin);
		btnSignin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				View_Signin vs = new View_Signin();
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
