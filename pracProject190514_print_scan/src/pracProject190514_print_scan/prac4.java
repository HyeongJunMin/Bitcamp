package pracProject190514_print_scan;
import java.util.*;
public class prac4 {
	String eq = "=================================================================";
	String trName="name",trAge="age",trMan="man",trPhone="phone",trHeight="height",trAddress="address";
	String name="";
	int age=0;
	boolean man=true;
	String pnum="";
	double hgt=0;
	String add="";
	void input() {
		Scanner in = new Scanner(System.in);
		System.out.print("이름 : ");
		this.name=in.next();
		System.out.print("나이(정수) : ");
		this.age=in.nextInt();
		System.out.print("성별(true/false) : ");
		this.man = in.nextBoolean();
		System.out.print("전화번호(000-0000-0000) : ");
		this.pnum = in.next();
		System.out.print("키(180.22) : ");
		this.hgt=in.nextDouble();
		System.out.print("주소(서울시) : ");
		this.add = in.next();
	}
	void print() {
		System.out.printf("%s\n",eq);
		System.out.printf("\\\t%s\t%s\t%s\t%s\t\t%s\t%s\t\\\n",trName,trAge,trMan,trPhone,trHeight,trAddress);
		System.out.printf("%s\n",eq);
		System.out.printf("\\\t%s\t%d\t%b\t%s\t%.2f\t%s  \\\n",name,age,man,pnum,hgt,add);
		System.out.printf("%s\n",eq);
	}
}
