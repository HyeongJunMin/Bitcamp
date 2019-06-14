package lct1Network;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ClientMain {

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
			
			InetAddress inetAddr;
			if( (inetAddr = sck.getInetAddress()) != null ){
				System.out.println("서버 연결 성공 : " + inetAddr);
			}else {
				System.out.println("서버 연결 실패");
			}
			new ReadThread(sck).start();;
			while(true) {
			
			System.out.print("전송 할 문자열 : ");
			Scanner in = new Scanner(System.in);
			String str = in.next();
						
			//send
			PrintWriter pw = new PrintWriter(sck.getOutputStream());
			pw.println(str);
			//flush는 중요해요 -> 여기까지 보내겠다! 는 뜻으로 flush를 만나지 못하면 전송이 끝나지 않음
			pw.flush();
			
//			//recv
//			BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));
//			String str2 = br.readLine();
//			System.out.println("서버에서 받아온 문자열:" + str2);
			
			if( str.equals("그만"))		break;
			
			}
			
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
