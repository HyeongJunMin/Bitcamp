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

public class View_ModMem extends JFrame implements ActionListener, WindowListener {

	TextField txtId, txtPw, txtName, txtAuth, txtEmail;
	JLabel lblId, lblPw, lblName, lblAuth, lblEmail;
	JButton btnOk, btnCancel;
	String currId = "default";
	MemDAO dao;
	MemDTO dto = null;
	
	public View_ModMem() {
		super("회원정보 수정");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 400, 350);
		setLayout(null);
		setVisible(true);
		
		dao = MemDAO.getInstance();
		
		mkTxt();
		mkLbl();
		mkBtn();
	}
	
	public View_ModMem(String id) {
		super("회원정보 수정");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 400, 350);
		setLayout(null);
		setVisible(true);
		
		dao = MemDAO.getInstance();
		dto = dao.hm.get(id);
		
		currId = id;
		
		mkTxt();
		mkLbl();
		mkBtn();
	}
	
	public void mkBtn() {
		btnOk = new JButton("완료");
		btnCancel = new JButton("취소");
		
		btnOk.setBounds(40, 250, 100, 30);
		btnCancel.setBounds(150, 250, 100, 30);
		
		btnOk.addActionListener(this);
		btnCancel.addActionListener(this);
		
		add(btnOk);
		add(btnCancel);
	}
	
	public void mkLbl() {
		lblId = new JLabel("ID : ");
		lblPw = new JLabel("PW : ");
		lblName = new JLabel("Name : ");
		lblEmail = new JLabel("Email : ");
		lblAuth = new JLabel("Auth : ");
		
		lblId.setBounds(40, 50, 50, 30);
		lblPw.setBounds(40, 90, 50, 30);
		lblName.setBounds(40, 130, 50, 30);
		lblEmail.setBounds(40, 170, 50, 30);
		lblAuth.setBounds(40, 210, 50, 30);
		//지난 주 MVC 모델1 게시판 이어서 (https://dotheright.tistory.com/144)
		add(lblId);
		add(lblPw);
		add(lblName);
		add(lblEmail);
		add(lblAuth);
	}
	
	public void mkTxt() {
		txtId = new TextField();
		txtPw = new TextField();
		txtName = new TextField();
		txtEmail = new TextField();
		txtAuth = new TextField();
		
		txtId.setBounds(100, 50, 150, 30);
		txtPw.setBounds(100, 90, 150, 30);
		txtName.setBounds(100, 130, 150, 30);
		txtEmail.setBounds(100, 170, 150, 30);
		txtAuth.setBounds(100, 210, 150, 30);
		
		add(txtId);
		add(txtPw);
		add(txtName);
		add(txtEmail);
		add(txtAuth);
		
		if(dto != null) {
			txtId.setText(dto.getId());
			txtPw.setText(dto.getPw());
			txtName.setText(dto.getName());
			txtEmail.setText(dto.getEmail());
			txtAuth.setText(dto.getAuth()+"");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btnOk) ) {
			if( txtId.getText().equals(dto.getId()) 
					&&  ( txtPw.getText().equals(dto.getPw()) ) 				
					&& ( txtName.getText().equals(dto.getName()) ) 
					&& ( txtEmail.getText().equals(dto.getEmail()) ) 
					&& ( txtAuth.getText().equals(dto.getAuth()+"") ) ) {				
//				JOptionPane.showMessageDialog(null, "변경없음");
			}else {
//				JOptionPane.showMessageDialog(null, "변경있음");
				if(txtAuth.getText().equals("3") || txtAuth.getText().equals("1")) {
					MemDTO dto2 = new MemDTO(txtId.getText(), txtPw.getText(), txtName.getText(), txtEmail.getText(), Integer.parseInt(txtAuth.getText()));
//					System.out.println(dto2.toString());
					boolean done = dao.updateMember(dto2); 
					if( done ) {
						JOptionPane.showMessageDialog(null, "수정완료");
						dao.syncDBToMap();
					}else {
						JOptionPane.showMessageDialog(null, "오류");
					}					
				}else {
					JOptionPane.showMessageDialog(null, "Auth는 3(사용자) 또는 1(관리자)");
				}
			}
//			if( txtId.getText().equals(dto.getId()) ) {
//				
//			}else if( txtPw.getText().equals(dto.getPw()) ) {
//				
//			}else if( txtName.getText().equals(dto.getName()) ) {
//				
//			}else if( txtEmail.getText().equals(dto.getEmail()) ) {
//				
//			}else if( txtAuth.getText().equals(dto.getAuth()+"") ) {
//				
//			}else {
//				
//			}
//			dao.updateMember(dao.hm.get(currId));			
		}
		
		if( e.getSource().equals(btnCancel) ) {
			dispose();
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
