package lct2Observer;

import java.util.Observable;

public class MyClass extends Observable{
	
	private String preArg = null;
	String name = "";
	
	//MyClass�� �����ϴ� �κ�
	@Override
	public void notifyObservers(Object arg) {
		
		String str = (String)arg;
		//��ȭ�� ���� ���? �������� �ʴ´�.
		if( str.equals(preArg) ) return;
		
		preArg = str;
		
		setChanged();
		
		super.notifyObservers(arg);
		
		clearChanged();	//reset
	}
}
