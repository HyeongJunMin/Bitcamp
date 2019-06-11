package work1BaseballTeamManagement;

import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;

public class MainFrame extends JFrame implements WindowListener, ActionListener, MouseMotionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 100L;
	
	public MainFrame() {
		super("Baseball Team Management");
		
		
//		mkPnl();
		mkBtn();
//		mkTbl();
		mkLst();
		
		setLayout(null);
		setBounds(700, 250, 740, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);

	}
	JPanel pn1,pn2;
	public void mkPnl() {
		pn1 = new JPanel();
		pn1.setBounds(0, 0, 440, 400);
//		add(pn1);
		pn2 = new JPanel();
		pn2.setBounds(5, 25, 550, 400);
		add(pn2);
	}
	
	JButton btn1, btn2, btn3, btn4, btn5, btn6, btn7;
	public void mkBtn() {
		btn1 = new JButton("새 선수");
		btn2 = new JButton("선수 삭제");
		btn3 = new JButton("검색");
		btn4 = new JButton("선수정보 수정");
		btn5 = new JButton("타율왕 선정");
		btn6 = new JButton("초기화");
		btn7 = new JButton("모두출력");
		
		btn1.setBounds(570, 30, 120, 30);
		btn2.setBounds(570, 65, 120, 30);
		btn3.setBounds(570, 100, 120, 30);
		btn4.setBounds(570, 135, 120, 30);
		btn5.setBounds(570, 170, 120, 30);
		btn6.setBounds(570, 205, 120, 30);
		btn7.setBounds(570, 240, 120, 30);
		
		btn1.setName("btnInsert");
		btn2.setName("btnDelete");
		btn3.setName("btnSearch");
		btn4.setName("btnModify");
		btn5.setName("btnBest");
		btn6.setName("btnReset");
		btn7.setName("btnPrintAll");
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		btn4.addActionListener(this);
		btn5.addActionListener(this);
		btn6.addActionListener(this);
		btn7.addActionListener(this);
		
		add(btn1);
		add(btn2);
		add(btn3);
		add(btn4);
		add(btn5);
		add(btn6);
		add(btn7);
	}
	JTable tbl;
	JScrollPane pn;
	DefaultTableCellRenderer dtcr;
	TableColumnModel tm;
	public void mkTbl() {
		FncFileIO.syncFileToList();
		TeamDAOSingleton.team.get(1);
		
		String[] columnType = { "번호", "구분", "이름", "나이", "신장", "승" ,"패" ,"승률","타석", "유효타", "타율"};
		
		tbl = new JTable(TeamDAOSingleton.tblTuple, columnType);
		JScrollPane pn = new JScrollPane(tbl);
		tbl.setFillsViewportHeight(true);
		
		dtcr = new DefaultTableCellRenderer();
		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		tm = tbl.getColumnModel();
		for(int i = 0 ; i < tm.getColumnCount() ; i++ ) {
			tm.getColumn(i).setCellRenderer(dtcr);
		}
	}
	public static List l;
	public void mkLst() {
		
		FncFileIO.syncFileToList();
		l = new List();
		
		l.setBounds(20, 30, 540, 300);
		add(l);
		
		Iterator it = TeamDAOSingleton.team.keySet().iterator();
		
		int key;
		PitcherDTO p;
		BatterDTO b;
		while( it.hasNext() ) {
			key = (int)it.next();
			if( TeamDAOSingleton.team.get(key) instanceof PitcherDTO ) {
				p = (PitcherDTO)TeamDAOSingleton.team.get(key);
				l.add(p.toString());
			}else {
				b = (BatterDTO)TeamDAOSingleton.team.get(key);
				l.add(b.toString());
			}
		}
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JButton b = (JButton)e.getSource();
		String bName = b.getName();
		if( e.getSource().equals(btn1) ) {
			new FrameInsert();
		}else if( e.getSource().equals(btn2) ) {
			new FrameDeleteMan();
		}else if( e.getSource().equals(btn3) ) {
			new FrameSearch();
		}else if( e.getSource().equals(btn4) ) {
			new FrameEditInfo();
		}else if( e.getSource().equals(btn5) ) {
			new FrameKingOfBatter();
		}else if( e.getSource().equals(btn6) ) {
			l.removeAll();
			Iterator it = TeamDAOSingleton.team.keySet().iterator();
			
			int key;
			PitcherDTO pp;
			BatterDTO bb;
			while( it.hasNext() ) {
				key = (int)it.next();
				if( TeamDAOSingleton.team.get(key) instanceof PitcherDTO ) {
					pp = (PitcherDTO)TeamDAOSingleton.team.get(key);
					l.add(pp.toString());
				}else {
					bb = (BatterDTO)TeamDAOSingleton.team.get(key);
					l.add(bb.toString());
				}
			}
		}else if( e.getSource().equals(btn7) ) {
			new FramePrintAll();
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
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		FncFileIO.syncFileToList();
		this.mkLst();
	}
}
