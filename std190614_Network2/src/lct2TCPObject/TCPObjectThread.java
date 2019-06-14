package lct2TCPObject;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lct2TCPObjectClient.Member;

public class TCPObjectThread extends Thread {
	
	private Socket sck;
	private List<Socket> lst;
	
	public TCPObjectThread (Socket sck, List lst) {
		this.sck = sck;
		this.lst = lst;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			//Object�� �־��ִ� ��Ʈ��(read)
			ObjectInputStream ois = new ObjectInputStream(sck.getInputStream());
			Member m = (Member)ois.readObject();
			
			
			System.out.println("���۵� Object : " + m.toString());
			
			m.setHeight(100.0);
			
			//Object�� �������� ��Ʈ��(write)
			ObjectOutputStream oos = new ObjectOutputStream(sck.getOutputStream());
			oos.writeObject(m);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
