package lct2MVC2_view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.StringTokenizer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import lct2MVC2_DAO.BbsDAO;
import lct2MVC2_model.DTOBbs;
import lct2MVC2_single.Singleton;

public class View_SelectedPost extends JFrame implements ActionListener, WindowListener {

	private JLabel lblTitle, lblHit, lblAuthor, lblDate;
	private JButton btnGoToList, btnEdit, btnDelete;
	private JTextArea txtContent;
	private int seq = 1;
	private DTOBbs dto = null;
	private View_Board vb = null;
	
	Singleton s = Singleton.getInstance();
	
	public View_SelectedPost(){
		super("글 내용");
	}
	
	public View_SelectedPost(int seq){
		super("Post Content");
		this.seq = seq;
		setLayout(null);
		setBounds(600, 200, 670, 510);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		mkLbl();
		mkTxt();
		mkBtn();
	}
	
	public View_SelectedPost(DTOBbs dto){
		super("Post Content");
		this.dto = dto;
		
		setLayout(null);
		setBounds(600, 200, 670, 510);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		mkLbl();
		mkTxt();
		mkBtn();
	}
	
	public View_SelectedPost(int seq, View_Board vb){
		super("Post Content");
		this.seq = seq;
		setLayout(null);
		setBounds(600, 200, 670, 510);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		this.vb = vb;
		

		
//		dto = dao.selectContent(seq);
		mkLbl();
		mkTxt();
		mkBtn();
	}
	
	public void mkLbl() {
		lblTitle = new JLabel();
		lblTitle.setBounds(20, 30, 300, 30);
		add(lblTitle);
		lblTitle.setText("제목 : " + dto.getTitle());
		
		lblHit = new JLabel();
		lblHit.setBounds(220, 30, 300, 30);
		lblHit.setText("조회수 : ");
		add(lblHit);
		
		lblAuthor = new JLabel();
		lblAuthor.setBounds(20, 60, 300, 30);
		add(lblAuthor);
		lblAuthor.setText("작성자 : " + dto.getId());
		
		lblDate = new JLabel();
		lblDate.setBounds(220, 60, 300, 30);
		add(lblDate);
		lblDate.setText("작성일 : " + dto.getWdate().toString());
	}
	
	public void mkTxt() {
		String str = dto.getContent();

		StringTokenizer st = new StringTokenizer(str);
		
		txtContent = new JTextArea();
		txtContent.setBounds(20, 90, 500, 300);
		add(txtContent);
		txtContent.setText("내용입니다 :) \n내용이다내용");
		txtContent.setEditable(false);
		txtContent.setText(str);
		lblHit.setText("조회수 : " + dto.getReadcount());
		
//		System.out.println(str);
	}
	
	public void mkBtn() {
		btnGoToList = new JButton("목록으로");
		btnGoToList.setBounds(20, 400, 100, 30);
		add(btnGoToList);
		
		btnEdit = new JButton("수정");
		btnEdit.setBounds(125, 400, 100, 30);
		btnEdit.setVisible(false);
		add(btnEdit);
		
		btnDelete = new JButton("삭제");
		btnDelete.setBounds(230, 400, 100, 30);		
		btnDelete.setVisible(false);
		add(btnDelete);
		
		btnGoToList.addActionListener(this);
		btnEdit.addActionListener(this);
		btnDelete.addActionListener(this);

		
		if( s.sessionId.equals(dto.getId())) {//작성자와 현재 로그인한 아이디가 동일하면
			btnEdit.setVisible(true);
			btnDelete.setVisible(true);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btnGoToList)) {	this.dispose();	}
		if( e.getSource().equals(btnEdit)) {
			s.memCtrl.editContect(dto);
//			new View_Edit(dto, vb);
//			vb.model.fireTableDataChanged();
		}
		if( e.getSource().equals(btnDelete)) {
			int re = JOptionPane.showConfirmDialog(null, "정말 삭제?", "Delete", JOptionPane.YES_NO_CANCEL_OPTION);
			if( re == JOptionPane.YES_OPTION) {
				boolean b = s.memCtrl.deleteContect(dto);
				if( b ) {
					JOptionPane.showMessageDialog(null, "삭제 성공");
				}else {
					JOptionPane.showMessageDialog(null, "삭제 실패!!!");
				}
//				dao.deleteContent(dto);
//				JOptionPane.showMessageDialog(null, "삭제 완료");
			}				
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
