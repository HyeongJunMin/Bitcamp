package lct1Network;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientTemplate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * Client 작성 순서
		 * 1. 접속해야 할 Server 주소(IP) 설정
		 * 2. 서버소켓과 연결하기 위한 Socket 생성
		 * 3. 연결 대상 설정
		 * 4. Connect
		 */
		int port = 9000;
		//1. 접속해야 할 Server 주소(IP) 설정
		InetSocketAddress socAddr = new InetSocketAddress("192.168.0.29", 9000);
		//2. 서버소켓과 연결하기 위한 Socket 생성
		Socket sck = new Socket();
		
		try {
			//3. 연결 대상 설정
			sck.connect(socAddr);
			System.out.println("서버 연결 성공");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			sck.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
