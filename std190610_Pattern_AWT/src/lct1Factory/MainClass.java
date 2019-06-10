package lct1Factory;

import java.util.*;

public class MainClass {
	public static void main(String[] args) {
		Animal a = AnimalFactory.Create("Cat");
		System.out.println(a.toString());
		
		List<Object> w = new ArrayList<>();
		w.add(new Gun());
		w.add(new Sword());
		w.add(new Dynamite());
		w.add(new C4());
		
		for(Object b : w) {
			if( b instanceof Weapon)
				( (Weapon)b ).attack();
			else
				( (Bomb)b ).explode();
		}
		
			
	}
}
