package importTeest;

import java.awt.BorderLayout;
import java.awt.Component;

import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class Test extends JFrame {
	private final Object[] colNames = { "ChkBox", "이름", "나이", "성별" };
	private Object[][] datas = { { false, "홍길동", "20", "남" }, { true, "김말자", "18", "여" } };

	public Test() {
		super("JTable Tester");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel(new BorderLayout());
		DefaultTableModel dtm = new DefaultTableModel(datas, colNames);
		JTable table = new JTable(dtm);
		table.getColumn("ChkBox").setCellRenderer(dcr);
		JCheckBox box = new JCheckBox();
		box.setHorizontalAlignment(JLabel.CENTER);
		table.getColumn("ChkBox").setCellEditor(new DefaultCellEditor(box));
		JScrollPane jsp = new JScrollPane(table);
		panel.add(jsp, "Center");
		setContentPane(panel);
		pack();
		setVisible(true);
		
		
		System.out.println(table.getValueAt(0, 0));
		System.out.println(table.getValueAt(1, 0));
		System.out.println(table.getValueAt(0, 1));
	}

	public static void main(String[] args) {
		new Test();
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
}
