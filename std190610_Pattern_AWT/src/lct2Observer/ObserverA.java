package lct2Observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverA implements Observer{

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		//arg == ��ȭ�� ������ �κп� ���� ���ڿ�
		String str = (String)arg;
		
		System.out.println("ObserverA. Detected a change : " + str);
	}
	
}
