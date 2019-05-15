package pracProject190515_bitoperation;

public class prac2 {
	void play() {
		//결과값 확인
		
		int num1, num2;
		
		num1 = 128;
		num2 = 56;
		
		//16진수로 변경
		System.out.printf("num1 : 0x%x\n",num1);
		System.out.printf("num2 : 0x%x\n",num2);
		//template	8421	8421
		//num1		1000	0000
		//num2		0011	1000
		//n1&n2		0000	0000
		//n1|n2		1011	1000
		//n1^n2		1011	1000	==184
				
		num1 = (num1 & num2) | (num1 & num2);
		num2 = ~(num1 ^ num2);
		System.out.println(num1);
		System.out.println(num2);
	}
}
