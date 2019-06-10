package lct2Observer;

import java.util.Observable;
import java.util.Observer;

public class ObserverMain {
	public static void main(String[] args) {
		MyClass h = new MyClass();
		h.addObserver(new ObserverA());
		h.addObserver(new ObserverB());
		
		for(int i = 0 ; i < 10 ; i++ ) {
			System.out.println("��ȭ " + (i+1));
			h.notifyObservers("��й�ȣ");
			h.notifyObservers(h.name);
			if(i==5) {
				h.name = "12";
				h.notifyObservers(h.name);	
			}
		}
	}
}
