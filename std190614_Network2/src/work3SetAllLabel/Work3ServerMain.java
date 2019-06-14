package work3SetAllLabel;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Work3ServerMain {
	public static void main(String[] args) {
		int port = 9000;
		ServerSocket serverSck = null;

		// �������� ���� �� ����
		try {
			serverSck = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Socket clientSck = null; // Ŭ���̾�Ʈ ���� ����

		List<Socket> sckList = new ArrayList<Socket>(); // Ŭ���̾�Ʈ ������ ���� ����Ʈ ����

		while (true) { // ��� accept�ϵ���

			if (sckList.size() > 50)
				break; // ������ 50���� �ʰ��ϸ� �ݺ� ����

			System.out.println("���� ����� ...");

			// accept ���� �� ���� ���
			try {
				clientSck = serverSck.accept();
				System.out.println("Connected Client Info: " + clientSck.toString());
				sckList.add(clientSck);
				new Work3ServerThread(clientSck, sckList).start();
			} catch (IOException e) {
				System.out.println("Server Accept Exception Occuered");
			} catch (Exception ee) {
				System.out.println("ggg");	
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
