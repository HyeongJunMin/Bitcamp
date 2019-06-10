package lct1Factory;

public class AniCat implements Animal{
	
	private String name;
	
	public AniCat() {
		this.name = "CAT";
	}
	
	@Override
	public String toString() {
		return "AniCat : " + this.name;
	}
}
