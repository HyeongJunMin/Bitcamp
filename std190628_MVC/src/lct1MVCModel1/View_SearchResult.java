package lct1MVCModel1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;



public class View_SearchResult extends JFrame implements ActionListener, WindowListener {

	private MemDAO dao;
	private List<BbsDTO> lst;
	String columnNames[] = {
			"번호", "제목", "작성자"
	};
	Object rowData[][];
	DefaultTableModel model;	// 테이블의 넓이 설정
	JTable jtable;
	JScrollPane jscrPane;
	
	public View_SearchResult(String str, int i) {
		super("Search Result");
		setLayout(null);
		setBounds(550, 150, 740, 560);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		dao = MemDAO.getInstance();
		
		mkTbl(str, i);

	}
	
	public void mkTbl(String title, int sel) {
		//sel > 제목=0, 내용=1, 작성자=2
		BbsDAO dao = BbsDAO.getInstance();
		lst = dao.getBbsList(title, sel);
		
		if(lst.size() == 0) {
			JOptionPane.showMessageDialog(null, "검색결과 없음");
			return;
		}
		int row = 0;
		for(BbsDTO d : lst) {
			if(d.getDel() == 1) {
				row++;
			}
		}//삭제되지 않은 게시글 수 만큼만 행 생성
		
		rowData = new Object[row][3];
		
		int pnt = 0;//행 지정 변수
		for(int i = 0 ; i < lst.size() ; i++ ) {
			if(lst.get(i).getDel() == 1) {
				BbsDTO d = lst.get(i);
				rowData[pnt][0] = d.getSeq();
				rowData[pnt][1] = d.getTitle();
				rowData[pnt][2] = d.getId();
				pnt++;
			}			
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
		model.fireTableDataChanged();
	}
	
	private class MyMouseListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == 1) {
				int row = jtable.getSelectedRow();
				int seq = Integer.parseInt(jtable.getValueAt(row, 0)+"");
				JOptionPane.showMessageDialog(null, "seq : " + seq + "  row : " + row);
				new View_SelectedPost( seq );
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

}
