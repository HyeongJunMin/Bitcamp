package work3SetAllLabel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;

public class Work3ServerThread extends Thread {
	
	Socket sck;
	List<Socket> lst;
	
	public Work3ServerThread() { }
	public Work3ServerThread(Socket sck, List<Socket> lst) {
		this.sck = sck;
		this.lst = lst;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		
		try {
			
			while(true) {
				// recv
				// �������κ��� ������ ���� ��Ʈ���� ���� ���� �� ����
				BufferedReader br = new BufferedReader(new InputStreamReader(sck.getInputStream()));

				String str;
				System.out.println("�����غ�");
				str = br.readLine();
				
				System.out.println("Message From Client: " + str + str.equals("true")); // Ŭ���̾�Ʈ �޽��� Ȯ��
				
				// send
				for (int i = 0; i < lst.size(); i++) {
//					if (lst.get(i).equals(sck)) {
						PrintWriter pw = new PrintWriter(lst.get(i).getOutputStream());
						pw.println(str);

						pw.flush();

						System.out.println("write ok, sck: " + lst.get(i).toString() + ", setV:false");

//					}
				}

				System.out.println("�����⵵ ��");
					
		
			}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception ee) {
				System.out.println("Ex in Thread");
			}
		
	}
}
