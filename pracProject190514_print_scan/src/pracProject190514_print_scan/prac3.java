package pracProject190514_print_scan;

public class prac3 {
	void print() {
	String eq = "=================================================================";
	String trName="name",trAge="age",trMan="man",trPhone="phone",trHeight="height",trAddress="address";
	String name1="\"홍길동\"",name2="\"일지매\"",name3="\"장옥정\"";
	int age1=20,age2=18,age3=14;
	boolean bl1=true,bl2=true,bl3=false;
	String pnum1="010-111-2222",pnum2="02-123-4567",pnum3="02-345-7890";
	double hgt1=175.12,hgt2=180.01,hgt3=155.78;
	String add1="\"경기도\"",add2="\"서울\"",add3="\"부산\"";
	System.out.printf("%s\n",eq);
	System.out.printf("\\\t%s\t%s\t%s\t%s\t\t%s\t%s\t\\\n",trName,trAge,trMan,trPhone,trHeight,trAddress);
	System.out.printf("%s\n",eq);
	System.out.printf("\\\t%s\t%d\t%b\t%s\t%.2f\t%s  \\\n",name1,age1,bl1,pnum1,hgt1,add1);
	System.out.printf("\\\t%s\t%d\t%b\t%s\t%.2f\t%s  \\\n",name2,age2,bl2,pnum2,hgt2,add2);
	System.out.printf("\\\t%s\t%d\t%b\t%s\t%.2f\t%s  \\\n",name2,age2,bl3,pnum3,hgt3,add3);
	System.out.printf("%s\n",eq);
	}
}
