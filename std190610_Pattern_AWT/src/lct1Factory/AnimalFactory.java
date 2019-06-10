package lct1Factory;

public class AnimalFactory {
	public static Animal Create(String str) {
		Animal a = null; 
		
		if( str.equals("Cat") ) {
			a = new AniCat();
		}else {
			return null;					
		}		
		
		return a;
	}
}
