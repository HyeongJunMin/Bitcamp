package work4RSP;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import workDTO.RSPDTO;



public class Work4ServerMain {
	public static void main(String[] args) {
		int port = 9000;
		ServerSocket serverSck = null;

		// 서버소켓 선언 및 생성
		try {
			serverSck = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Socket clientSck = null; // 클라이언트 소켓 선언

		// 클라이언트 소켓과 DTO를 담을 리스트 선언
		Map<Socket, RSPDTO> sckM = new HashMap<Socket, RSPDTO>();
		while (true) { // 계속 accept하도록
						
			if (sckM.size() > 50)	break; // 소켓이 50개를 초과하면 반복 종료
			System.out.println("접속 대기중 ...");

			// accept 끝날 때 까지 대기
			try {
				clientSck = serverSck.accept();
				System.out.println("Connected Client Info: " + clientSck.toString());
				
				//연결되면 Map에 소켓 저장하고 클라이언트로 Map 번호 넘김
				//클라이언트는 Map 번호를 각 클라이언트 번호로 인식
				sckM.put(clientSck, null);
			
				PrintWriter pw = new PrintWriter(clientSck.getOutputStream());
				pw.println(sckM.size() + "");
				pw.flush();
				
				new Work4ServerThread(clientSck, sckM).start();
			} catch (IOException e) {
				System.out.println("Server Accept Exception Occuered");
			} catch (Exception ee) {
				System.out.println("ggg");	
			}
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		try {
			clientSck.close();
			serverSck.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception ee) {
			System.out.println("ggg");
		}
	}
}
