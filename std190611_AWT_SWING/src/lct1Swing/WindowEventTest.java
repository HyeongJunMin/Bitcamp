package lct1Swing;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.text.BadLocationException;

public class WindowEventTest extends JFrame{

	JTextField textField;
	JTextArea textArea;
	
	JButton btn1, btn2;
	
	public WindowEventTest() {
		super("textfield");
		
		JPanel panel = new JPanel();
		
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		
		JScrollPane scrPane = new JScrollPane(textArea);
		scrPane.setPreferredSize(new Dimension(400, 300));		
		panel.add(scrPane);
		
		
		JPanel botpan = new JPanel();
		
		textField = new JTextField(20);
		
		btn1 = new JButton("뒷부분에 추가");
		btn1.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("")) return;
				String str = textField.getText();
				textArea.append(str+"\n");
			}
		});
		
		btn2 = new JButton("앞부분에 추가");
		btn2.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					textArea.insert(textField.getText() + "\n", 
							textArea.getLineStartOffset(0));
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		botpan.add(textField);
		botpan.add(btn1);
		botpan.add(btn2);
		
		// Layout
		Container contentPane = getContentPane();		
		contentPane.add(panel, BorderLayout.CENTER);
		contentPane.add(botpan, BorderLayout.SOUTH);
		
		// frame
		setBounds(0, 0, 640, 480);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
