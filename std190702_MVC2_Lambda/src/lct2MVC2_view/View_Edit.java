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

public class View_Edit extends JFrame implements ActionListener, WindowListener {

	private View_Board vb;
	private JButton btnWrite, btnCancle;
	private JTextArea txtContent, txtTitle;
	private JLabel lblMajor;
	private DTOBbs dto;
	private Singleton s = Singleton.getInstance();
	
	public View_Edit(DTOBbs dto) {
		super("Edit");
		setLayout(null);
		setBounds(650, 250, 500, 560);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		this.dto = dto;
		
		mkBtn();
		mkTxt();
		mkLbl();
	}
	
	public View_Edit(DTOBbs dto, View_Board vb) {
		super("Edit");
		setLayout(null);
		setBounds(650, 250, 500, 560);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		this.vb = vb;		
		this.dto = dto;		

		
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
		add(txtContent);
		
		txtTitle.setText(dto.getTitle());
		txtContent.setText(dto.getContent());
	}
	
	public void mkBtn() {
		btnWrite = new JButton("적용");
		btnWrite.setBounds(130, 450, 100, 50);
		add(btnWrite);
		btnWrite.addActionListener(this);
		
		btnCancle = new JButton("취소");
		btnCancle.setBounds(240, 450, 100, 50);
		add(btnCancle);
		btnCancle.addActionListener(this);
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		int evtResult = 0;
		if( e.getSource().equals(btnWrite) ) {
			evtResult = JOptionPane.showConfirmDialog(null, "저장 ㄱ?", "Save", JOptionPane.YES_NO_OPTION);
			if(evtResult == JOptionPane.YES_OPTION) {
				dto.setTitle(txtTitle.getText());
				dto.setContent(txtContent.getText());
				
				boolean b = s.memCtrl.updateContent(dto);
				
				if( b ) {
					JOptionPane.showMessageDialog(null, dto.getSeq() + "번 글 수정 완료!");
				}else {
					JOptionPane.showMessageDialog(null, dto.getSeq() + "번 글 수정 실패!!!");
				}
//				dao.updateContent(dto);
				
				//변경사항 테이블에 반영
//				vb.jtable.setValueAt(dto.getTitle() , (vb.jtable.getRowCount() - dto.getSeq()), 1);
//				vb.model.fireTableDataChanged();
				
				this.dispose();
			}else {
				
			}
		}
		if( e.getSource().equals(btnCancle)) {
			if( dto.getTitle().equals(txtTitle.getText()) ) {
				if( dto.getContent().equals(txtContent.getText()) ) {//제목 내용 둘 다 변경 없으면?
					this.dispose();
				}else {//내용에 변경이 있는 경우
					evtResult = JOptionPane.showConfirmDialog(null, "내용에 변경이 있습니다. 그래도 취소??", "Close", JOptionPane.YES_NO_OPTION);
					if(evtResult == JOptionPane.YES_OPTION) {
						this.dispose();
					}
				}
			}else {//제목에 변경이 있는 경우
				evtResult = JOptionPane.showConfirmDialog(null, "제목에 변경이 있습니다. 그래도 취소??", "Close", JOptionPane.YES_NO_OPTION);
				if(evtResult == JOptionPane.YES_OPTION) {
					this.dispose();
				}
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
