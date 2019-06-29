package lct1MVCModel1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class View_Board extends JFrame implements ActionListener, WindowListener {

	private JTable jtable;
	private JScrollPane jscrPane;
	private MemDAO dao;
	private JButton writeBtn;
	String columnNames[] = {
			"번호", "제목", "작성자"
	};
	
	Object rowData[][];
	
	DefaultTableModel model;	// 테이블의 넓이 설정
	List<BbsDTO> lst = null;
	
	public View_Board() {
		super("Free Board");
		setLayout(null);
		setBounds(550, 150, 740, 560);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		dao = MemDAO.getInstance();
		
		mkTbl();
		mkBtn();
	}
	
	private class MyMouseListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == 1) {
				int row = jtable.getSelectedRow();
				int seq = Integer.parseInt(jtable.getValueAt(row, 0)+"");
//				JOptionPane.showMessageDialog(null, seq);
				new View_SelectedPost( seq );
			}
		}
	}
	
	public void mkBtn() {
		writeBtn = new JButton("write");
		writeBtn.setBounds(500, 400, 100, 50);
		add(writeBtn);
		
		writeBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				View_NewPost np = new View_NewPost();
			}
		});
	}
	
	public void mkTbl() {
		
		BbsDAO dao = BbsDAO.getInstance();
		lst = dao.getBbsList();
		
		rowData = new Object[lst.size()][3];
		
		for(int i = 0 ; i < lst.size() ; i++ ) {
			BbsDTO d = lst.get(i);
			rowData[i][0] = lst.size() - i;
			rowData[i][1] = d.getTitle();
			rowData[i][2] = d.getId();
		}
		
//		System.out.println(lst.toString());
		
		//테이블 폭을 설정하기 위한 Model 객체 생성 및 설정
		model = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		model.setDataVector(rowData, columnNames);
		
		jtable = new JTable(model);//테이블 생성
		
		// column 폭 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(50);
		jtable.getColumnModel().getColumn(1).setMaxWidth(500);
		jtable.getColumnModel().getColumn(2).setMaxWidth(200);
		
		//테이블 colomn 글 맞춤
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		//번호와 작성자의 컬럼은 글의 중간 맞춤
		jtable.getColumn("번호").setCellRenderer(celAlignCenter);
		jtable.getColumn("작성자").setCellRenderer(celAlignCenter);
		
		jscrPane = new JScrollPane(jtable);
		jscrPane.setBounds(10, 50, 600, 300);
		add(jscrPane);
		
		jtable.addMouseListener(new MyMouseListener());
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
