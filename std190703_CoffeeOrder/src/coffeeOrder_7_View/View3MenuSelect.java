package coffeeOrder_7_View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import coffeeOrder_6_DTO.DTOCfMenu;
import coffeeOrder_6_DTO.DTOOrderedMenu;
import coffeeOrder_8_Singleton.Singleton;

public class View3MenuSelect extends JFrame implements ActionListener, WindowListener {

	JPanel pnlHeader, pnlSelectMenu, pnlBtm, pnlBtmAmount, pnlSelectMenuSize, pnlSelectMenuSyrup, pnlSelectMenuEtc;
	JButton btnOrder, btnShowMenu, btnLogin, btnShowOrderLog;
	JLabel lblSize, lblSyrup, lblEtc, lblAmountInfo, lblAmount;
	JRadioButton rdSizeShort, rdSizeTall, rdSizeGrande;
	JRadioButton srVanilla, srCaramel, srHazle;
	JCheckBox etcShot, etcWhip;
	ButtonGroup grSize, grSyrup;
	JComboBox<String> headerMenu, selectAmount;
	Singleton s = Singleton.getInstance();
	
	public View3MenuSelect() {
		super("Select Menu");		
		setLayout(new GridLayout(3, 1));
		setBounds(950, 250, 800, 600);
		setVisible(true);
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		addWindowListener(this);
		
		mkPnl();
		mkLbl();
		mkRadio();
		mkChkBox();
		mkHeader();
		mkBottom();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if( e.getSource().equals(btnOrder) ) {	//주문버튼 클릭
			if(headerMenu.getSelectedItem().equals("메뉴선택")) {
				JOptionPane.showMessageDialog(null, "메뉴를 선택해 주세요.");
			}else {

				String menuName = headerMenu.getSelectedItem() + "";
				String info = "주문내용이 맞으면 예, 틀리면 아니오를 클릭하세요.";
				String size = "";
				String syrup = "";
				String shot = "추가안함";
				String whip = "추가안함";
				int amount = Integer.parseInt(selectAmount.getSelectedItem()+"");
				
								
				//선택된 사이즈 문자열 저장
				Enumeration<AbstractButton> enums = grSize.getElements();
				while( enums.hasMoreElements() ) {
					AbstractButton ab = enums.nextElement();
					JRadioButton jb = (JRadioButton)ab;
					if(jb.isSelected()) {
						size = jb.getText();
					}
				}
				
				enums = grSyrup.getElements();
				while( enums.hasMoreElements() ) {
					AbstractButton ab = enums.nextElement();
					JRadioButton jb = (JRadioButton)ab;
					if(jb.isSelected()) {
						syrup = jb.getText();
					}
				}
				
				if(etcShot.isSelected()) {
					shot = "추가";
				}
				
				if(etcWhip.isSelected()) {
					whip = "추가";
				}
				
//				System.out.println("enums 결과입니다 :::::::: " + size);
				
				info = info + "\n메뉴 : " + menuName + "\nsize : " + size + "\nsyrup : " + syrup + "\nshot : " + shot + "\nwhip : " + whip + "\namount : " + amount + "잔";

				int result = JOptionPane.showConfirmDialog(null, info, null	,JOptionPane.YES_NO_OPTION);

				if( result == JOptionPane.YES_OPTION) {
					DTOOrderedMenu dto = new DTOOrderedMenu(s.sessionId, menuName, size, syrup, shot, whip, amount);
					s.ctrl.showOrderList(dto);		
				}				
			}			
		}
		if( e.getSource().equals(btnShowMenu) ) {	//메뉴보기 버튼 클릭
			s.ctrl.showAllMenu(s.menuOpened);
		}
		if( e.getSource().equals(btnLogin) ) {	//돌아가기 버튼 클릭
			this.dispose();
			s.orderBucket.clear();
			s.ctrl.login();
		}
		if( e.getSource().equals(btnShowOrderLog) ) {
			s.ctrl.showOrderLog();
		}
	}	
	
	public void mkPnl() {
		pnlHeader = new JPanel();
		pnlHeader.setLayout(null);
		pnlHeader.setBackground(new Color(255, 245, 245));
		add(pnlHeader);
		
		pnlSelectMenu = new JPanel();
		pnlSelectMenu.setLayout(null);
		pnlSelectMenu.setBackground(new Color(255, 245, 245));
		add(pnlSelectMenu);		
		
		pnlSelectMenuSize = new JPanel();
		pnlSelectMenuSize.setLayout(null);
		pnlSelectMenuSize.setBounds(90, 5, 200, 175);
		pnlSelectMenuSize.setBackground(new Color(255, 225, 225));
		pnlSelectMenu.add(pnlSelectMenuSize);
		
		pnlSelectMenuSyrup = new JPanel();
		pnlSelectMenuSyrup.setLayout(null);
		pnlSelectMenuSyrup.setBounds(310, 5, 200, 175);
		pnlSelectMenuSyrup.setBackground(new Color(255, 225, 225));
		pnlSelectMenu.add(pnlSelectMenuSyrup);
		
		pnlSelectMenuEtc = new JPanel();
		pnlSelectMenuEtc.setLayout(null);
		pnlSelectMenuEtc.setBounds(520, 5, 200, 175);
		pnlSelectMenuEtc.setBackground(new Color(255, 225, 225));
		pnlSelectMenu.add(pnlSelectMenuEtc);
		
		pnlBtm = new JPanel();
		pnlBtm.setLayout(null);
		pnlBtm.setBackground(new Color(255, 245, 245));
		add(pnlBtm);
		
		pnlBtmAmount = new JPanel();
		pnlBtmAmount.setLayout(null);
		pnlBtmAmount.setBackground(new Color(205, 205, 205));
		pnlBtm.add(pnlBtmAmount);
	}
	
	public void mkLbl() {
		lblSize = new JLabel("크기");
		lblSize.setBounds(10, 1, 100, 30);
		pnlSelectMenuSize.add(lblSize);
		
		lblSyrup = new JLabel("시럽");
		lblSyrup.setBounds(10, 1, 100, 30);
		pnlSelectMenuSyrup.add(lblSyrup);
		
		lblEtc = new JLabel("기타");
		lblEtc.setBounds(10, 1, 100, 30);
		pnlSelectMenuEtc.add(lblEtc);
	}

	public void mkRadio() {
		rdSizeShort = new JRadioButton("Short");
		rdSizeShort.setBounds(10, 35, 100, 30);
		rdSizeShort.setBackground(new Color(255, 225, 225));
		pnlSelectMenuSize.add(rdSizeShort);
		
		rdSizeTall = new JRadioButton("Tall");
		rdSizeTall.setBounds(10, 75, 100, 30);
		rdSizeTall.setBackground(new Color(255, 225, 225));
		pnlSelectMenuSize.add(rdSizeTall);
		
		rdSizeGrande = new JRadioButton("Grande");
		rdSizeGrande.setBounds(10, 115, 100, 30);
		rdSizeGrande.setBackground(new Color(255, 225, 225));
		pnlSelectMenuSize.add(rdSizeGrande);
		
		grSize = new ButtonGroup();
		grSize.add(rdSizeShort);
		grSize.add(rdSizeTall);
		grSize.add(rdSizeGrande);
		
		//첫 뷰 그릴 때 안보여서 한번씩 골라줌
		rdSizeTall.setSelected(true);
		rdSizeGrande.setSelected(true);
		rdSizeShort.setSelected(true);
		
		//JRadioButton srVanilla, srCaramel, srHazle;
		srVanilla = new JRadioButton("바닐라");
		srVanilla.setBounds(10, 35, 100, 30);
		srVanilla.setBackground(new Color(255, 225, 225));
		pnlSelectMenuSyrup.add(srVanilla);
		
		srCaramel = new JRadioButton("카라멜");
		srCaramel.setBounds(10, 75, 100, 30);
		srCaramel.setBackground(new Color(255, 225, 225));
		pnlSelectMenuSyrup.add(srCaramel);
		
		srHazle = new JRadioButton("헤이즐넛");
		srHazle.setBounds(10, 115, 100, 30);
		srHazle.setBackground(new Color(255, 225, 225));
		pnlSelectMenuSyrup.add(srHazle);
		
		grSyrup = new ButtonGroup();
		grSyrup.add(srVanilla);
		grSyrup.add(srCaramel);
		grSyrup.add(srHazle);
		
		srHazle.setSelected(true);
		srCaramel.setSelected(true);
		srVanilla.setSelected(true);
	}
	
	public void mkChkBox() {
		//JCheckBox etcShot, etcWhip;
		etcShot = new JCheckBox("샷추가");
		etcShot.setBackground(new Color(255, 225, 225));
		etcShot.setBounds(10, 35, 100, 30);
		pnlSelectMenuEtc.add(etcShot);
		etcShot.setSelected(true);
		etcShot.setSelected(false);
		
		etcWhip = new JCheckBox("휘핑추가");
		etcWhip.setBackground(new Color(255, 225, 225));
		etcWhip.setBounds(10, 75, 100, 30);
		pnlSelectMenuEtc.add(etcWhip);
		etcWhip.setSelected(true);
		etcWhip.setSelected(false);
	}
	
	public void mkHeader() {
		//위치 및 크기 지정
		headerMenu = new JComboBox<String>();
		headerMenu.setBounds(200, 80, 400, 30);
		pnlHeader.add(headerMenu);
		headerMenu.setVisible(true);
		//아이템 추가
		headerMenu.addItem("메뉴선택");
		TreeMap<Integer, DTOCfMenu> map = new TreeMap<Integer, DTOCfMenu>(s.ctrl.getMemu());
		
		Iterator it = map.descendingKeySet().iterator();
		
		while(it.hasNext()) {
			int k = Integer.parseInt(it.next()+"");
			headerMenu.addItem(map.get(k).getName());
		}
		
		btnShowMenu = new JButton("모든 메뉴 보기");
		btnShowMenu.setBounds(650, 10, 130, 20);
		pnlHeader.add(btnShowMenu);
		btnShowMenu.setVisible(false);
		btnShowMenu.setVisible(true);
		btnShowMenu.addActionListener(this);
	}

	public void mkBottom() {
		btnOrder = new JButton("주문");
		btnOrder.setPreferredSize(new Dimension(200, 80));
		btnOrder.setBounds(470, 40, 150, 70);
		pnlBtm.add(btnOrder);
		btnOrder.setVisible(false);
		btnOrder.setVisible(true);
		btnOrder.addActionListener(this);
		
		btnLogin = new JButton("돌아가기");
		btnLogin.setPreferredSize(new Dimension(200, 80));
		btnLogin.setBounds(330, 145, 150, 30);
		pnlBtm.add(btnLogin);
		btnLogin.setVisible(false);
		btnLogin.setVisible(true);
		btnLogin.addActionListener(this);
		
		btnShowOrderLog = new JButton("주문기록 열람");
		btnShowOrderLog.setBounds(50, 145, 150, 30);
		pnlBtm.add(btnShowOrderLog);
		btnShowOrderLog.addActionListener(this);
		
		selectAmount = new JComboBox<String>();
		selectAmount.setBounds(230, 60, 50, 30);
		pnlBtm.add(selectAmount);
		selectAmount.setVisible(true);
		
		selectAmount.addItem("1");
		selectAmount.addItem("2");
		selectAmount.addItem("3");
		selectAmount.addItem("4");
		selectAmount.addItem("5");
		
		lblAmount = new JLabel("수량 :");
		lblAmount.setBounds(190, 60, 35, 30);
		pnlBtm.add(lblAmount);
		lblAmount.setVisible(false);
		lblAmount.setVisible(true);
		
		lblAmountInfo = new JLabel("잔");
		lblAmountInfo.setBounds(290, 60, 35, 30);
		pnlBtm.add(lblAmountInfo);
		lblAmountInfo.setVisible(false);
		lblAmountInfo.setVisible(true);
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
