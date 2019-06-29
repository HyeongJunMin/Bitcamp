package lct1MVCModel1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.StringTokenizer;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class View_SelectedPost extends JFrame implements ActionListener, WindowListener {

	private BbsDAO dao;
	private JLabel lblTitle, lblHit;
	private JTextArea txtContent;
	private int seq = 1;
	private BbsDTO dto = null;
	
	public View_SelectedPost(){
		super("글 내용");
	}
	
	public View_SelectedPost(int seq){
		super("Post Content");
		this.seq = seq;
		setLayout(null);
		setBounds(600, 200, 640, 460);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		dao = BbsDAO.getInstance();
		dto = dao.selectContent(seq);
		mkLbl();
		mkTxt();
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
	}
	
	public void mkTxt() {
		String str = dto.getContent();

		StringTokenizer st = new StringTokenizer(str);
		
		txtContent = new JTextArea();
		txtContent.setBounds(20, 80, 500, 300);
		add(txtContent);
		txtContent.setText("내용입니다 :) \n내용이다내용");
		txtContent.setEditable(false);
		txtContent.setText(str);
		lblHit.setText("조회수 : " + dto.getReadcount());
		dao.updateReadCount(seq);
//		System.out.println(str);
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
