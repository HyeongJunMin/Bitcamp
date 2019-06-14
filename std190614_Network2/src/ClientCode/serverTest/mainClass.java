package serverTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;

public class mainClass {

	public static void main(String[] args) {
		
		InetSocketAddress sockAddr = new InetSocketAddress("127.0.0.1", 9000);
		
		Socket socket = new Socket();
				
		try {
			// server 접속
			socket.connect(sockAddr);
			
			InetAddress inetAddr;
			if((inetAddr = socket.getInetAddress())!= null) {
				System.out.println("서버 연결 성공:" + inetAddr);
			}else {
				System.out.println("서버 연결 실패");
			}
		
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = reader.readLine();	// 실제 수신
			System.out.println("서버로부터 온 메시지:" + str);
			
			int num = Integer.parseInt(str);		
			new ClientFrame(socket, num);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
