package pracProject190515_bitoperation;

public class Lct_2_Cast {
	void play() {
		/* 형변환에 관한 내용
		 * 
		 * 우선순위			용량
		 * boolean
		 * byte				1
		 * short	char	2
		 * int				4
		 * long				8
		 * float			4
		 * double			8
		 * 
		 * 형변환의 구분
		 * 1. 자동 자료형 변환
		 * 2. 강제 자료형 변환(cast)
		 * 
		 * /**/
		short sh=1;
		int i=sh;//2바이트 short 데이터를 4바이트 int 변수에 대입 
		//자동 자료형 변환 : 자료형이 정해진 변수값을 상대적으로 데이터용량이 작은 자료형의 변수에 저장
		i=25;
		sh= (short)i;//short로 cast(강제 형) 변환
		System.out.println("sh = "+sh);
		// float(8byte)에 long(4byte)를 넣으면?
		long l1=12345678912345L;
		float f1=l1;
		System.out.println("f1 = "+f1);
		double d1=l1;
		System.out.println("d1 = "+d1);
		d1=0.123e-2;
		System.out.println("d1 = 0.123e-2  == "+d1);
		d1=0.123e3;
		System.out.println("d1 = 0.123ehttp://bitly.kr/eQrpfg3  == "+d1);
		int num1=3,num2=2;
		f1=num1/num2;
		System.out.println("f1 = 3/2 == " + f1);
		f1=(float)num1/num2;
		System.out.println("f1 = (float)3/2 == " + f1);
	}
}
