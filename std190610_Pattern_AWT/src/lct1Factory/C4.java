package lct1Factory;

public class C4 extends WeaponBType implements Bomb{
	public void explode() {
		for(int i = 5 ; i > 0 ; i-- )
			System.out.println(i+"...");
		System.out.println("bomb!");
	}
}
