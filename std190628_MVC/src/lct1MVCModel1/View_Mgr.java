package lct1MVCModel1;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;
import java.util.Map;

import javax.swing.BoxLayout;
import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class View_Mgr extends JFrame implements ActionListener, WindowListener {

	private Object[] colNames = { "ChkBox", "ID", "이름", "구분" };
	private Object[][] datas = { { false, "system", "admin", "1" }, { true, "minhj", "minhj", "3" } };
	DefaultTableModel dtm;
	JButton btnDel, btnMod, btnAuth;
	JPanel panel, panel2, mainPan;
	JTable table;
	JCheckBox box;
	JScrollPane jsp;
	MemDAO dao;
		
	public View_Mgr() {
		super("Admin");
		
		getUserDataFromDB();
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(500, 200, 400, 300);
		setPreferredSize(new Dimension(400, 350));

//		setContentPane(panel);
//		setContentPane(panel2);		
		
		setVisible(true);
		

		mkPan();
		mkBtn();
		
//		System.out.println(table.getValueAt(0, 0));
//		System.out.println(table.getValueAt(1, 0));
//		System.out.println(table.getValueAt(0, 1));		
		addWindowListener(this);
	}

	DefaultTableCellRenderer dcr = new DefaultTableCellRenderer() {
		public Component getTableCellRendererComponent // 셀렌더러
		(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			JCheckBox box = new JCheckBox();
			box.setSelected(((Boolean) value).booleanValue());
			box.setHorizontalAlignment(JLabel.CENTER);
			return box;
		}
	};
	
	public void mkBtn() {
		btnDel = new JButton("삭제");
		btnDel.setPreferredSize(new Dimension(200,60));
		panel2.add(btnDel);
		
		btnMod = new JButton("수정");
		btnMod.setPreferredSize(new Dimension(200,60));
		panel2.add(btnMod);
		
		btnAuth = new JButton("권한변경");
		btnAuth.setPreferredSize(new Dimension(200,60));
		panel2.add(btnAuth);
		
		
		btnDel.addActionListener(this);
		btnMod.addActionListener(this);
		btnAuth.addActionListener(this);
	}
	
	public void mkPan() {
		
//		getUserDataFromDB();
		
		panel = new JPanel(new BorderLayout());
		dtm = new DefaultTableModel(datas, colNames);
		table = new JTable(dtm);
		table.getColumn("ChkBox").setCellRenderer(dcr);
		box = new JCheckBox();
		box.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("ChkBox").setCellEditor(new DefaultCellEditor(box));
		jsp = new JScrollPane(table);
		panel.add(jsp, "Center");
		
		pack();
		
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
//		this.setLayout(new GridLayout(2,1));
		panel2 = new JPanel();
		panel2.setLayout(new BoxLayout(panel2, BoxLayout.X_AXIS));
		mainPan = new JPanel();
		mainPan.setLayout(new BoxLayout(mainPan, BoxLayout.Y_AXIS));
		
		add(mainPan, BorderLayout.CENTER);
		mainPan.add(panel);
		mainPan.add(panel2);
		
		table.addMouseListener(new MyMouseListener());
	}
	
	public void getUserDataFromDB() {
		dao = MemDAO.getInstance();
		dao.syncDBToMap();
		Map<String, MemDTO> hm = dao.hm;
		
		Iterator it = hm.keySet().iterator();
		
		datas = new Object[hm.size()][4];
		
		int w = 0;
		while( it.hasNext() ) {
			MemDTO d = hm.get(it.next());
			
			datas[w][0] = false;
			datas[w][1] = d.getId();
			datas[w][2] = d.getName();
			datas[w][3] = d.getAuth();
			w++;
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btnAuth) ) {
			
			for(int i = 0 ; i < table.getRowCount() ; i++ ) {
				if( (boolean)table.getValueAt(i, 0) == true ) {
					dao.alterAuth((int)table.getValueAt(i, 3), (String)table.getValueAt(i, 1));
					JOptionPane.showMessageDialog(null, (i+1) + "번째 멤버 권한 변경 완료");
				}
			}
			dtm.fireTableDataChanged();
		}
		
		if( e.getSource().equals(btnMod) ) {
			int row = 0;
			int checked = 0;
			for(int i = 0 ; i < table.getRowCount() ; i++ ) {
				if( (boolean)table.getValueAt(i, 0) == true ) {
					checked++;
					row = i;
				}
			}
			if(checked > 1) {
				JOptionPane.showMessageDialog(null, "1개만 체크 가능");
			}else {
				JOptionPane.showMessageDialog(null, "OK GO");
				new View_ModMem( (String)table.getValueAt(row, 1) );
			}
		}
	}	
	
	private class MyMouseListener extends MouseAdapter{
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getButton() == 1) {
				int row = table.getSelectedRow();
//				JOptionPane.showMessageDialog(null, table.getValueAt(row, 0));
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
