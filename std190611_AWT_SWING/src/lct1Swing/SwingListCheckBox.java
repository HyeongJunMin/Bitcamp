package lct1Swing;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class SwingListCheckBox extends JFrame implements ItemListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List lst;
	Checkbox check;
	Label lbl1;
	TextField tf;
	
	double toRadian;	
	
	public SwingListCheckBox() {
		super("List and CheckBox");
		
		this.mkTxtFld();
		this.mkLayout();
		this.mklbl();
		this.mkLst();
		this.mkChcBox();
		this.mkFrm();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	void mkFrm() {
		setBounds(0, 0, 640, 480);
		setLayout(new GridLayout());
		setVisible(true);
	}
		
	void mkTxtFld() {
		tf = new TextField();
		tf.setText("여기에 입력");
	}
	GridLayout g;
	GridBagConstraints c;
	void mkLayout() {
		g = new GridLayout();
		c = new GridBagConstraints();
		toRadian = 1.0;
		
	}
	
	void mklbl() {
		lbl1 = new Label("1");
	}
	
	void mkLst() {
		lst = new List();
		lst.add("root");
		lst.add("sin");
		lst.add("cos");
		lst.add("tan");
		add(lst);
		//리스트에 리스너 추가
		lst.addItemListener(this);
	}
	
	void mkChcBox() {
		check = new Checkbox("Degree");
		check.setState(false);//체크안된상태
		add(check);
		add(tf);
		
		//체크박스에 리스너 추가
		check.addItemListener(this);
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
//		JOptionPane.showMessageDialog(null, "짠");
		Object obj = e.getSource();
		if( obj == lst ) {		//이벤트가 발생한 인스턴스가 lst이면 true
			int itemNo = lst.getSelectedIndex();
			double v = Double.parseDouble(tf.getText());
			double result = 0.0;
			switch( itemNo ) {
				case 0: result = Math.sqrt(v); break;
				case 1: result = Math.sin(v); break;
				case 2: result = Math.cos(v); break;
				case 3: result = Math.tan(v); break;
			}
			tf.setText(result + "");
		}else if( obj == check ) {
			if( check.getState() ) {		//체크가 되어있을 때
				double d = Double.parseDouble(tf.getText());
				d = d * Math.PI / 180.0;
				tf.setText(d + "");
			}
		}
	}
}
