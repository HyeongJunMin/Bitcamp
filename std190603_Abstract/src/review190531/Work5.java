package review190531;

public class Work5 {
	public static void main(String[] args) {
		/*
		Child c = new Child();
		System.out.println("x="+c.getX());
		*/
		
		
		/*
		Marine unit1[] = new Marine[10];	// 1
		Tank unit2[] = new Tank[5];	// 5
		Dropship unit3[] = new Dropship[3]; // 3
		
		// 200
		Unit unit[] = new Unit[6];
		unit[0] = new Marine();
		unit[1] = new Marine();
		unit[2] = new Marine();
		
		unit[3] = new Tank();		
		unit[4] = new Marine();		
		unit[5] = new Dropship();
		
		// instanceof
		for (int i = 0; i < unit.length; i++) {
			if(unit[i] instanceof Marine) {
				Marine m = (Marine)unit[i];
				m.stimPack();
			}
			else if(unit[i] instanceof Tank) {
				((Tank)unit[i]).changeMode();				
			}
			else if(unit[i] instanceof Dropship) {
				
			}
		}
		*/
		
		
		
		Robot[] arr = { new DanceRobot(), new SingRobot(), new DrawRobot()};
		
		/*
		Robot array[] = new Robot[3];
		array[0] = new DanceRobot();
		array[1] = new SingRobot();
		array[2] = new DrawRobot();
		*/
		
		for(int i=0; i< arr.length;i++) {
			arr[i].Title();
		//	mainClass.action(arr[i]);
		}		
		
	}
	
	static void action(Robot robot) {		
		if(robot instanceof DanceRobot) {
			DanceRobot d = (DanceRobot)robot;
			d.dance();
		}else if(robot instanceof SingRobot) {
			((SingRobot)robot).sing();
		}else if(robot instanceof DrawRobot) {
			DrawRobot d = (DrawRobot)robot;
			d.draw();
		}		
	}
	
}

class Parent {
	int x=100;
	Parent() {		// 1
		this(200);
		System.out.println("Parent Parent() 2");		
	}
	Parent(int x) {	// 2
		this.x = x;
		System.out.println("Parent Parent() 1");	
	}
	int getX() {
		return x;
	}
}

class Child extends Parent {
	int x = 3000;
	Child() {
		this(1000);
		System.out.println("Child Child() 4");
	}
	Child(int x) {
		this.x = x;
		System.out.println("Child Child() 3");
	}
}





class Unit{
	int x, y; // ���� ��ġ
	void move(int x, int y) { 
		/* ������ ��ġ�� �̵� */
		this.x = x;
		this.y = y;
	}
	void stop() { 
		/* ���� ��ġ�� ���� */	
		System.out.println("Unit ���� ��ġ�� ����");
	}
}

class Marine extends Unit{ // ����	
	void stimPack() { 
		/* �������� ����Ѵ�.*/
		System.out.println("Marine �������� ����Ѵ�");
	}
}

class Tank extends Unit{ // ��ũ
	void changeMode() { 
		/* ���ݸ�带 ��ȯ�Ѵ�. */
		System.out.println("Tank ���ݸ�带 ��ȯ�Ѵ�");
	}
}

class Dropship extends Unit{ // ���ۼ�
	void load() { 
		/* ���õ� ����� �¿��.*/ 
		System.out.println("Dropship ���õ� ����� �¿��");
	}
	void unload() { 
		/* ���õ� ����� ������.*/ 
		System.out.println("Dropship ���õ� ����� ������");
	}
}




class Robot {
	void Title() {		
	}	
}

class DanceRobot extends Robot {
	void Title() {	// Over Ride
		System.out.println("���� �� �κ��Դϴ�");
		
		dance();
	}
	void dance() {
		System.out.println("���� ��ϴ�.");
	}
}
class SingRobot extends Robot {
	void Title() {	// Over Ride
		System.out.println("���� ���� �κ��Դϴ�");
		
		sing();
	}
	void sing() {
		System.out.println("�뷡�� �մϴ�.");
	}
}
class DrawRobot extends Robot {
	void Title() {	// Over Ride
		System.out.println("���� �׸��� �κ��Դϴ�");
		
		draw();
	}
	void draw() {
		System.out.println("�׸��� �׸��ϴ�.");
	}
}