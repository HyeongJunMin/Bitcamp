package serverTest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class mainClass {

	public static void main(String[] args) {
		ServerSocket serSocket = null;
		
		try {
			serSocket = new ServerSocket(9000);
			
			List<Socket> list = new ArrayList<Socket>();
			int clientNumber = 1;			
			
			while(true) {
				System.out.println("waiting...");
				Socket socket = serSocket.accept();
				
				PrintWriter writer = new PrintWriter(socket.getOutputStream());
				writer.println(clientNumber + "");
				writer.flush();
				
				clientNumber++;
				
				list.add(socket);
				
				new ServerThread(socket, list).start();
				
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
