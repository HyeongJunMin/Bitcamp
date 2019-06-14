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
		
		//서버소켓 선언 및 생성
		try {	serverSck = new ServerSocket(port);	} catch (IOException e) {	e.printStackTrace();	}			
		
		Socket clientSck = null;		//클라이언트 소켓 선언
		ChatSingleton sng = ChatSingleton.getInstance();
		List<Socket> sckList = new ArrayList<Socket>(); //클라이언트 소켓을 담을 리스트 선언
		
		while(true) {	//계속 accep하도록
			
			if(sckList.size() > 50) break;	//소켓이 50개를 초과하면 반복 종료
			
			System.out.println("접속 대기중 ...");
			
			//accept 끝날 때 까지 대기
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
