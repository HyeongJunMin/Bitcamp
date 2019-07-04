package coffeeOrder_7_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import coffeeOrder_6_DTO.DTOCfMenu;
import coffeeOrder_8_Singleton.Singleton;

public class View4ShowMenu extends JFrame implements ActionListener, WindowListener {

	Singleton s = Singleton.getInstance();
	public JTable jtable;
	private JScrollPane jscrPane;
	private JButton btnClose;
	public JTextField txtSearch;
	public JComboBox<String> jcb;
	String columnNames[] = {
			"No" ,"메뉴이름", "Short", "Tall", "Grande"
	};
	
	Object rowData[][];
	
	DefaultTableModel model;	// 테이블의 넓이 설정
	List<DTOCfMenu> lst = null;
	
	public View4ShowMenu() {
		super("Show All Menu");		
		setLayout(null);
		setBounds(1050, 350, 600, 400);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		mkTbl();
		mkBtn();
	}
	
	public void mkBtn() {
		btnClose = new JButton("메뉴 닫기");
		btnClose.setBounds(200, 325, 200, 30);
		btnClose.setVisible(true);
		add(btnClose);
		
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				s.menuOpened = false;
				System.out.println("menu opened" + s.menuOpened);
				dispose();
			}
		});
	}
	
	public void mkTbl() {
		model = null;
		jtable = null;
		lst = null;
		
		Map<Integer, DTOCfMenu> m = s.ctrl.getMemu();
		
		rowData = new Object[m.size()][5];
		
		//"No" ,"메뉴이름", "Short", "Tall", "Grande"
		for(int i = 0 ; i < m.size() ; i++) {
			DTOCfMenu menu = m.get( (i+1) );
			rowData[i][0] = menu.getSeq();
			rowData[i][1] = menu.getName();
			rowData[i][2] = menu.getPriceShort();
			rowData[i][3] = menu.getPriceTall();
			rowData[i][4] = menu.getPriceGrande();
		}
//		System.out.println("OK" + rowData[4][1]);
		
		model = new DefaultTableModel(columnNames, 0) {
			public boolean isCellEditable(int i, int c) {
				return false;
			}
		};
		
		model.setDataVector(rowData, columnNames);
		
		jtable = new JTable(model);
		
		// column 폭 설정
		jtable.getColumnModel().getColumn(0).setMaxWidth(30);
		jtable.getColumnModel().getColumn(1).setMaxWidth(300);
		jtable.getColumnModel().getColumn(2).setMaxWidth(90);
		jtable.getColumnModel().getColumn(3).setMaxWidth(90);
		jtable.getColumnModel().getColumn(4).setMaxWidth(90);
		
		//테이블 colomn 글 맞춤
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		// 중간 맞춤
		//"No" ,"메뉴이름", "Short", "Tall", "Grande"
		jtable.getColumn("No").setCellRenderer(celAlignCenter);
		jtable.getColumn("메뉴이름").setCellRenderer(celAlignCenter);
		jtable.getColumn("Short").setCellRenderer(celAlignCenter);
		jtable.getColumn("Tall").setCellRenderer(celAlignCenter);
		jtable.getColumn("Grande").setCellRenderer(celAlignCenter);
		
		jscrPane = new JScrollPane(jtable);
		
		jscrPane.setBounds(1, 1, 583, 320);
		add(jscrPane);
		jscrPane.setVisible(false);
		jscrPane.setVisible(true);	
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
		s.menuOpened = false;
		dispose();
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
