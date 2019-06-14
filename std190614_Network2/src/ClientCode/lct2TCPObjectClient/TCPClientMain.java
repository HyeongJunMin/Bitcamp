package lct2TCPObjectClient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class TCPClientMain {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		
		String addr = "192.168.0.29";
		int port = 9000;
		
		InetSocketAddress sckAddr = new InetSocketAddress(addr, port);
		
		
		
		try {
			
			Socket sck = new Socket();
			sck.connect(sckAddr);
			
			InetAddress inetAddr;
			
			if(  (inetAddr = sck.getInetAddress()) != null  ){
				System.out.println("Connected: " + inetAddr);
			}else {
				System.out.println("Connect Fail");
			}
			
			while(true) {
				System.out.print("Name : ");
				String name = in.next();
				
				System.out.print("Height : ");
				Double height = in.nextDouble();
				
				Member m = new Member(name, height);
				
				
				//send
				ObjectOutputStream oos = new ObjectOutputStream(sck.getOutputStream());
				oos.writeObject(m);
				oos.flush();
				
				
				//recv
				ObjectInputStream ois = new ObjectInputStream(sck.getInputStream());
				Member dto = (Member)ois.readObject();
				
				System.out.println("Transported Object From Server class : " + dto.toString());
				System.out.println("Socket Info : " + sck.toString());
			}
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
