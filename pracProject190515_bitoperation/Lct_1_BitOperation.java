package pracProject190515_bitoperation;

public class Lct_1_BitOperation {
	void play() {
		// bit연산은 고급연산이라고 말씀하십니다
		/*	bit : 0/1
		 *	&	AND
		 * 	|	OR
		 * 	^	XOR
		 * 	<<	left shift
		 *	>>	right shift
		 *	~	반전
		 * /**/
		//AND연산
		int num1=0x71, num2=0xb5,result=0;
		result = num1 & num2;
		//8421 8421
		//0111 0001
		//1011 0101
		//0011 1011-> 0x31
		System.out.println("AND : "+result);
		System.out.printf("0x%x\n",result);
		//OR연산
		//8421 8421
		//0111 0001
		//1011 0101
		//1111 0101->0xf5 == 245
		result = num1 | num2;
		System.out.println("OR : "+result);
		System.out.printf("0x%x\n",result);
		//XOR연산
		//8421 8421
		//0111 0001
		//1011 0101
		//1100 0100-> 0xc4
		result = num1 ^ num2;
		System.out.println("XOR : "+result);
		System.out.printf("0x%x\n",result);
		//left shift 연산
		//left == *2결과, right == /2결과
		//8421 8421
		//0111 0001
		//1110 0010-> 0xd2
		num1=0x5;
		result = num1 << 4;
		System.out.println("left shift : "+result);
		System.out.printf("0x%x\n",result);
		//right shift 연산
		//8421	8421
		//0111	0001
		//0011	1000 -> 0x38 == 56
		num1=0x71;//0x71==113
		result = num1 >> 1;
		System.out.println("right shift : "+result);
		System.out.printf("0x%x\n",result);
		//음수 right shift 연산
		//-7을 우측 시프트
		//7==(0111) 7의 1의 보수==(1000) 7의 2의 보수==(1001)==-7
		//7의 2의 보수를 우측 시프트 == (1100)
		byte b2 = -7;
		result = b2 >> 1;
		System.out.println(Integer.toBinaryString(b2));
		System.out.println(Integer.toBinaryString(result));
		System.out.println("(negative) right shift : "+result);
		System.out.printf("0x%x\n",result);
		//~ 연산 : 부호비트까지 해당됨. 0->1, 1->0 
		//8421 8421 
		//0101 0101 == 0x55
		//1010 1010-> 0xaa
		//1111 1111 1111 1111 1111 1111 0101 0101
		result= ~(0x55);
		System.out.println("shift : "+result);
		System.out.printf("0x%x\n",result);
		//결과값은 8자리가 나옴 = 4byte = 32bit
		//aa를 얻고싶으면 0xffffff55 반전하면 됨
		byte b1 = ~(0x55);
		System.out.printf("0x%x\n",b1);
		//3항연산자
		//(조건)?조건이참일경우리턴값:조건이거짓일경우리턴값;
		char c;
		int num=5;
		c=(num>0)?'Y':'N';
		System.out.println("c = "+c);
		String str = (num<=0)?"0보다 작거나 같다":"0보다 크다";
		System.out.println("str = (num<=0)?\"0보다 작거나 같다\":\"0보다 크다\" = "+str);
	}
}
