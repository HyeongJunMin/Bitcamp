package lct1Network2_server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatServerThread extends Thread {

	private Socket sck;
	private String addr;

	public ChatServerThread(Socket sck) {
		this.sck = sck;
	}

	@Override
	public void run() {
		super.run();

		try {
			while (true) {
				// recv
				// �������κ��� ������ ���� ��Ʈ���� ���� ���� �� ����
				BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));

				String str = br.readLine();
				System.out.println("Message From Client: " + str); // Ŭ���̾�Ʈ �޽��� Ȯ��

				// send
				for(Socket sckList : ChatSingleton.list) {
					if( sckList.equals(sck) == false) {
						PrintWriter pw = new PrintWriter(sckList.getOutputStream());
						pw.println(str);
						pw.flush();
						System.out.println("write ok, sck: " + sckList.toString());
					}
				}				

				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		} catch (IOException e) {
			System.out.println("ip : " + sck.getInetAddress() + " Disconnected");
			ChatSingleton.list.remove(sck);// ���� ���� ���� ����
			// ���� Ŭ���̾�Ʈ �� Ȯ��
			for (Socket sckk : ChatSingleton.list) {
				System.out.println("Client info IP:" + sckk.getInetAddress() + " Port:" + sckk.getPort());
			}
			try {
				sck.close();
			} catch (IOException e1) {
				System.out.println("Socket Close Exception");
			}
		}

	}

}
