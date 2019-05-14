package pracProject190514_operator;

public class prac6 {
	int a=7;
	int b=0;
	
	void print() {
		b=++a;
		b=a++;
		System.out.println(a);
		System.out.println(b);		
	}
}
