package coffeeOrder_7_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import coffeeOrder_6_DTO.DTOCfMenu;
import coffeeOrder_6_DTO.DTOOrderedMenu;
import coffeeOrder_8_Singleton.Singleton;

public class View6ShowOrderLog extends JFrame implements ActionListener, WindowListener {

	public JTable jtable;
	private JScrollPane jscrPane;
	private JButton btnCancel, btnClear, btnOrder;
	public JTextField txtSearch;
	public JComboBox<String> jcb;
	String columnNames[] = {
			"No" ,"주문고객", "메뉴이름", "Size", "시럽", "샷추가", "휘핑크림", "수량", "가격", "주문일시"
	};
	
	Object rowData[][];
	
	DefaultTableModel model;	// 테이블의 넓이 설정
	List<DTOCfMenu> lst = null;	
	Singleton s = Singleton.getInstance();
	
	public View6ShowOrderLog() {
		super("Show Order Log");		
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
		btnCancel = new JButton("창 닫기");
		btnCancel.setBounds(470, 325, 100, 30);
		add(btnCancel);		
		btnCancel.setVisible(false);
		btnCancel.setVisible(true);
		btnCancel.addActionListener(this);
		
		btnClear = new JButton("비우기");
		btnClear.setBounds(290, 325, 100, 30);
		add(btnClear);		
		btnClear.setVisible(false);
		btnClear.setVisible(true);
		btnClear.addActionListener(this);
		
		btnOrder = new JButton("주문");
		btnOrder.setBounds(185, 325, 100, 30);
		add(btnOrder);		
		btnOrder.setVisible(false);
		btnOrder.setVisible(true);
		btnOrder.addActionListener(this);
	}
	
	public void mkTbl() {
		model = null;
		jtable = null;
		lst = null;
		
		List<DTOOrderedMenu> lst = s.ctrl.getOrderLog();
		
		rowData = new Object[lst.size()][10];
		
		//"No" ,"주문고객", "메뉴이름", "Size", "시럽", "샷추가", "휘핑크림", "수량", "가격", "주문일시"
		for(int i = 0 ; i < lst.size() ; i++) {
			if(i < lst.size() ) {
				DTOOrderedMenu dto = lst.get(i);
				rowData[i][0] = dto.getOrderNum();
				rowData[i][1] = dto.getCustomerName();
				rowData[i][2] =	dto.getMenuName();
				rowData[i][3] = dto.getSize();
				rowData[i][4] = dto.getSyrup();
				rowData[i][5] = dto.getShot();
				rowData[i][6] = dto.getWhip();
				rowData[i][7] = dto.getAmount();
				rowData[i][8] = ( s.ctrl.menuPrice(dto.getMenuName(), dto.getSize()) * Integer.parseInt(dto.getAmount()+"") );
				rowData[i][9] = dto.getOrderDate();
			}else {
				rowData[i][0] = " ";
				rowData[i][1] = " ";
				rowData[i][2] = " ";
				rowData[i][3] = " ";
				rowData[i][4] = " ";
				rowData[i][5] = " ";
				rowData[i][6] = " ";
				rowData[i][7] = " ";
				rowData[i][8] = " ";
				rowData[i][9] = " ";
			}
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
		jtable.getColumnModel().getColumn(1).setMaxWidth(200);
		jtable.getColumnModel().getColumn(2).setMaxWidth(60);
		jtable.getColumnModel().getColumn(3).setMaxWidth(60);
		jtable.getColumnModel().getColumn(4).setMaxWidth(60);
		jtable.getColumnModel().getColumn(5).setMaxWidth(60);
		jtable.getColumnModel().getColumn(6).setMaxWidth(60);
		jtable.getColumnModel().getColumn(7).setMaxWidth(60);
		jtable.getColumnModel().getColumn(8).setMaxWidth(60);
		jtable.getColumnModel().getColumn(9).setMaxWidth(60);
		
		//테이블 colomn 글 맞춤
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		// 중간 맞춤
		//"No" ,"주문고객", "메뉴이름", "Size", "시럽", "샷추가", "휘핑크림", "수량", "가격", "주문일시"
		jtable.getColumn("No").setCellRenderer(celAlignCenter);
		jtable.getColumn("주문고객").setCellRenderer(celAlignCenter);
		jtable.getColumn("메뉴이름").setCellRenderer(celAlignCenter);
		jtable.getColumn("Size").setCellRenderer(celAlignCenter);
		jtable.getColumn("시럽").setCellRenderer(celAlignCenter);
		jtable.getColumn("샷추가").setCellRenderer(celAlignCenter);
		jtable.getColumn("휘핑크림").setCellRenderer(celAlignCenter);
		jtable.getColumn("수량").setCellRenderer(celAlignCenter);
		jtable.getColumn("가격").setCellRenderer(celAlignCenter);
		jtable.getColumn("주문일시").setCellRenderer(celAlignCenter);
		
		jscrPane = new JScrollPane(jtable);
		
		jscrPane.setBounds(1, 1, 583, 320);
		add(jscrPane);
		jscrPane.setVisible(false);
		jscrPane.setVisible(true);	
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btnCancel)) {
			dispose();
		}
		if(e.getSource().equals(btnClear)) {
			int result = JOptionPane.showConfirmDialog(null, "정말 삭제하시겠습니까?", "장바구니 비우기", JOptionPane.YES_NO_OPTION);
			if(result == JOptionPane.YES_OPTION) {
				s.ctrl.flushBucket();
				dispose();
				new View5ShowOrderList();
			}
		}
		if(e.getSource().equals(btnOrder)) {
			s.ctrl.order();
			JOptionPane.showMessageDialog(null, "주문 완료.");
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
