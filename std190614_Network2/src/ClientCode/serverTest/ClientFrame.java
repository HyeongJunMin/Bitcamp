package serverTest;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class ClientFrame extends Frame implements WindowListener, ActionListener {
	
	int myNumber;
	Socket socket;
	
	public DtoClass dto;
	Button button;
	
	public ClientFrame(Socket socket, int myNumber) {
		this.socket = socket;
		this.myNumber = myNumber;
		
		dto = new DtoClass(1);
		
		new ReadThread(socket, this).start();
		
		setLayout(null);
		
		Label label = new Label("client " + myNumber);
		label.setBounds(50, 70, 100, 30);
		add(label);
		
		button = new Button("click");
		button.setBounds(100, 100, 100, 50);
		button.addActionListener(this);
		add(button);
		
		setBounds(0, 0, 640, 480);
		setBackground(Color.green);
		setVisible(true);
				
		addWindowListener(this);			
	}

	@Override
	public void actionPerformed(ActionEvent e) {
						
		// send		
		try {
			if(dto.getClientNumber() == myNumber) {
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				oos.writeObject(dto);
				oos.flush();
			}else {
				JOptionPane.showMessageDialog(null, "당신 차례가 아닙니다");
			}
					
		
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} 

	}

	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub

	}

}
