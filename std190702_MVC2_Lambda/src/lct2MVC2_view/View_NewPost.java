package lct2MVC2_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import lct2MVC2_model.DTOBbs;
import lct2MVC2_single.Singleton;

public class View_NewPost extends JFrame implements ActionListener, WindowListener {

	private JButton btnWrite, btnCancle;
	private JTextArea txtContent, txtTitle;
	private JLabel lblMajor;
	private Singleton s = Singleton.getInstance();
	
	public View_NewPost() {
		super("Write");
		setLayout(null);
		setBounds(650, 250, 500, 560);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
//		dao = BbsDAO.getInstance();
		mkBtn();
		mkTxt();
		mkLbl();
	}
	
	public void mkLbl() {
		lblMajor = new JLabel("제목 : ");
		lblMajor.setBounds(20, 30, 60, 30);
		add(lblMajor);
	}
	
	public void mkTxt() {
		txtTitle = new JTextArea();
		txtTitle.setBounds(55, 30, 370, 30);
		add(txtTitle);
		
		txtContent = new JTextArea();
		txtContent.setBounds(20, 70, 430, 350);
		txtContent.setLineWrap(true);
		
		//테스트영역
		String str = "ksdjfoiwejf\nlsdkajfoiwjeofij\ndkmd\nksdmnvkxcjn\bsdkmcoemcoimcve\ntest";
		txtContent.setText(str);
		add(txtContent);
		String s = txtContent.getText();
		String[] sArr = s.split("\n");
		for(String n : sArr) {
			System.out.println(n);
		}
	}
	
	public void mkBtn() {
		btnWrite = new JButton("게시");
		btnWrite.setBounds(130, 450, 100, 50);
		add(btnWrite);
		btnWrite.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(txtTitle.getText().equals("")) { JOptionPane.showMessageDialog(null, "Write Title!"); }
				else if(txtContent.getText().equals("")) { JOptionPane.showMessageDialog(null, "Write Content!"); }
				else {
					JOptionPane.showMessageDialog(null, s.sessionId);
					DTOBbs dto = new DTOBbs(s.sessionId, txtTitle.getText(), txtContent.getText());
					s.memCtrl.insertNewWrite(dto);
					dispose();
				}
			}
		});
		
		
		btnCancle = new JButton("취소");
		btnCancle.setBounds(240, 450, 100, 50);
		add(btnCancle);
		btnCancle.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
