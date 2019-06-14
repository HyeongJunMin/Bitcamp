package lct1Network2_server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerMain {
	public static void main(String[] args) {
		
		int port = 9000;
		ServerSocket serverSck = null;
		
		//�������� ���� �� ����
		try {	serverSck = new ServerSocket(port);	} catch (IOException e) {	e.printStackTrace();	}			
		
		Socket clientSck = null;		//Ŭ���̾�Ʈ ���� ����
		ChatSingleton sng = ChatSingleton.getInstance();
		List<Socket> sckList = new ArrayList<Socket>(); //Ŭ���̾�Ʈ ������ ���� ����Ʈ ����
		
		while(true) {	//��� accep�ϵ���
			
			if(sckList.size() > 50) break;	//������ 50���� �ʰ��ϸ� �ݺ� ����
			
			System.out.println("���� ����� ...");
			
			//accept ���� �� ���� ���
			try {
				clientSck = serverSck.accept();
				System.out.println("Connected Client Info: " + clientSck.toString());
//				sckList.add(clientSck);
				sng.list.add(clientSck);
				new ChatServerThread(clientSck).start();
			} catch (IOException e) {
				System.out.println("Server Accept Exception Occuered");
			}
		}
		
		try {
			clientSck.close();
			serverSck.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
