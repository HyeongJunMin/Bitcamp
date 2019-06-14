package lct2TCPObject;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class TCPObjectServerMain {
	public static void main(String[] args) {
		
		ServerSocket serverSck = null;
		try {
			serverSck = new ServerSocket(9000);
			
			List<Socket> lst = new ArrayList<Socket>();
			
			while(true) {
				System.out.println("¥Î±‚¡ﬂ...");
				Socket sck = serverSck.accept();
				
				new TCPObjectThread(sck, lst).start();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
