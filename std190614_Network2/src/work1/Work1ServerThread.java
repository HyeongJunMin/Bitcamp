package work1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

import lct1Network2_server.ChatSingleton;

public class Work1ServerThread extends Thread {
	
	Socket sck;
	List<Socket> lst;
	
	public Work1ServerThread() {
		
	}
	
	public Work1ServerThread(Socket sck, List<Socket> lst) {
		this.sck = sck;
		this.lst = lst;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		
		try {
			
		while(true) {
			
			// send
			for(int i = 1 ; i <= lst.size() ; i++ ) {
//				if( lst.get(i).equals(sck)) {
					PrintWriter pw = new PrintWriter(lst.get(i-1).getOutputStream());
					pw.println("Client Num : " + i);
					pw.flush();
					System.out.println("write ok, sck: " + lst.get(i-1).toString());
//				}
			}
			System.out.println("�����⵵ ��");
			
			// recv
			// �������κ��� ������ ���� ��Ʈ���� ���� ���� �� ����
			BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));

			String str;
			System.out.println("�����غ�");
			str = br.readLine();
			
			System.out.println("Message From Client: " + str); // Ŭ���̾�Ʈ �޽��� Ȯ��


				
	
		}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
