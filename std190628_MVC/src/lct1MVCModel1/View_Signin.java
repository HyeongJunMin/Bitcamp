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
import javax.swing.JTextField;

public class View_Signin extends JFrame implements WindowListener, ActionListener {

	JLabel lblId, lblPw, lblName, lblEmail;
	TextField txtId, txtPw, txtName, txtEmail;
	JButton btnSignin, btnConfirm;
	View_Login vl;
	MemDAO dao;
	boolean signinOk = false;
	
	public View_Signin() {
		super("Signin");		
		setLayout(null);
		setBounds(950, 250, 340, 360);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		dao = MemDAO.getInstance();
		
		mkLbl();
		mkBtn();
		mkTxt();
	}
	
	public void mkLbl() {
		lblId = new JLabel("ID : ");
		lblId.setBounds(30, 30, 50, 30);
		add(lblId);
		
		lblPw = new JLabel("PW : ");
		lblPw.setBounds(30, 70, 50, 30);
		add(lblPw);
		
		lblName = new JLabel("Name : ");
		lblName.setBounds(30, 110, 50, 30);
		add(lblName);
		
		lblEmail = new JLabel("Email : ");
		lblEmail.setBounds(30, 150, 50, 30);
		add(lblEmail);
	}
	
	public void mkBtn() {
		btnConfirm = new JButton("Confirm");
		btnConfirm.setBounds(215, 30, 100, 30);
		add(btnConfirm);
		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputId = txtId.getText();
				if(inputId.equals("")) {//텍스트필드 비어있으면
					JOptionPane.showMessageDialog(null, "ID를 입력하세요.");
				} else {
					if ( dao.hm.containsKey(inputId) ) {
						JOptionPane.showMessageDialog(null, "중복입니다. 다른 ID를 입력해주세요.");
						signinOk = false;	//중복확인 X
					}else {
						JOptionPane.showMessageDialog(null, "사용가능한 ID입니다.");
						signinOk = true;	//중복확인 완료
					}
				}
				
			}
		});
		
		btnSignin = new JButton("Sign In!");
		btnSignin.setBounds(30, 200, 180, 30);
		add(btnSignin);
		btnSignin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if( signinOk ) {	//중복확인이 되었으면
					String inputId = txtId.getText();
					String inputPw = txtPw.getText();
					String inputName = txtName.getText();
					String inputEmail = txtEmail.getText();
					int auth = 3;
					
					if( inputId.equals("") ) { JOptionPane.showMessageDialog(null, "ID입력누락"); }
					else if( inputPw.equals("") ) { JOptionPane.showMessageDialog(null, "PW입력누락");  }
					else if( inputName.equals("") ) { JOptionPane.showMessageDialog(null, "이름입력누락");  }  
					else {	//입력이 다 되어있다면 put
						dao.hm.put(inputId, new MemDTO(inputId, inputPw, inputName, inputEmail, auth));
						dao.addMem(inputId, inputPw, inputName, inputEmail);
						JOptionPane.showMessageDialog(null, "회원가입 완료! 로그인해주세요!");
						dispose();
					}
					
					

				}else {	//중복확인이 안되었으면
					JOptionPane.showMessageDialog(null, "먼저 중복확인을 해주세요.");
				}
			}
		});
	}
	
	public void mkTxt() {
		txtId = new TextField();
		txtId.setBounds(90, 30, 120, 30);
		add(txtId);
		
		txtPw = new TextField();
		txtPw.setBounds(90, 70, 120, 30);
		add(txtPw);
		
		txtName = new TextField();
		txtName.setBounds(90, 110, 120, 30);
		add(txtName);
		
		txtEmail = new TextField();
		txtEmail.setBounds(90, 150, 120, 30);
		add(txtEmail);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
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
