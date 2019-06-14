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

		// �������� ���� �� ����
		try {
			serverSck = new ServerSocket(port);
		} catch (IOException e) {
			e.printStackTrace();
		}

		Socket clientSck = null; // Ŭ���̾�Ʈ ���� ����

		// Ŭ���̾�Ʈ ���ϰ� DTO�� ���� ����Ʈ ����
		Map<Socket, RSPDTO> sckM = new HashMap<Socket, RSPDTO>();
		while (true) { // ��� accept�ϵ���
						
			if (sckM.size() > 50)	break; // ������ 50���� �ʰ��ϸ� �ݺ� ����
			System.out.println("���� ����� ...");

			// accept ���� �� ���� ���
			try {
				clientSck = serverSck.accept();
				System.out.println("Connected Client Info: " + clientSck.toString());
				
				//����Ǹ� Map�� ���� �����ϰ� Ŭ���̾�Ʈ�� Map ��ȣ �ѱ�
				//Ŭ���̾�Ʈ�� Map ��ȣ�� �� Ŭ���̾�Ʈ ��ȣ�� �ν�
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
