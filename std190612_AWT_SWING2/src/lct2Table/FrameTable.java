package lct2Table;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FrameTable extends JFrame implements WindowListener, ActionListener, MouseMotionListener, MouseListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8486128084695746507L;

	JTable tbl;
	JScrollPane scrP;	//ǥ�� ���̰� ������� ��ũ���� ���� ���� ��ȸ�� �� �ֵ��� ��ũ�� Ʋ ����
	
	//�÷� �̸��� ���ڿ� �迭�� ������ ����
	String clmName[] = { "��ǰ��ȣ", "��ǰ��", "��ǰ����", "��ǰȸ��" };
	//Ʃ���� ������ ���� [���ε���][�Ӽ�]
	Object rowData[][]; 
//			= { 
//			{ "a", "b", "c", "d" },
//			{ "e", "f", "g", "h" },
//			{ "k", "l", "m", "n" }
//	};
	List<ProductDTO> lst = new ArrayList<ProductDTO>();
	
	public FrameTable() {
		super("About JTable");
		
		lst.add(new ProductDTO(101, "������", 1000, "����"));
		lst.add(new ProductDTO(102, "��������", 3000, "������"));
		lst.add(new ProductDTO(103, "�ǻ�", 500, "�����"));
		
		rowData = new Object[lst.size()][4];
		
		for (int i = 0; i < lst.size() ; i++) {
			rowData[i][0] = lst.get(i).getSeq();
			rowData[i][1] = lst.get(i).getName();
			rowData[i][2] = lst.get(i).getPrice();
			rowData[i][3] = lst.get(i).getCompany();
		}
		
		tbl = new JTable(rowData, clmName);
		scrP = new JScrollPane( tbl );
		
		scrP.setBounds(15, 15, 700, 210);
		add(scrP);
		tbl.addMouseListener(this);
		tbl.addMouseMotionListener(this);
		
		this.mkLbl();
		
		addMouseListener(this);
		addMouseMotionListener(this);
		setLayout(null);
		setBounds(700, 250, 740, 480);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addWindowListener(this);
	}
	JLabel l1;
	public void mkLbl() {
		l1 = new JLabel("lll");
		l1.setBounds(0, 0, 100, 30);
		l1.setText("gggggg");
		add(l1);
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

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	int posX, posY;
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		posX = e.getX();
		posY = e.getY();
		this.l1.setText("x:"+posX + " y:"+posY);
		this.l1.setBounds(posX, posY-10, 100, 30);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		try {
			
		}catch(Exception ee) {
			return;
		}
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
