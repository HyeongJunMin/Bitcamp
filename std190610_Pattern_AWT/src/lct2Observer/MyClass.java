package lct2Observer;

import java.util.Observable;

public class MyClass extends Observable{
	
	private String preArg = null;
	String name = "";
	
	//MyClass를 감시하는 부분
	@Override
	public void notifyObservers(Object arg) {
		
		String str = (String)arg;
		//변화가 없는 경우? 통지하지 않는다.
		if( str.equals(preArg) ) return;
		
		preArg = str;
		
		setChanged();
		
		super.notifyObservers(arg);
		
		clearChanged();	//reset
	}
}
