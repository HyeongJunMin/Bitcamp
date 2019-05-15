package pracProject190515_bitoperation;

public class prac1 {
	//결과 값을 기입하고 결과 확인
	void play() {
		int number;
		number=5;
		System.out.println(number);
		
		number = number << 4;
		System.out.println(number);
		//number == 80
		
		number = number >> 5;
		System.out.println(number);
		//80 == 0101 0000
		//80 >> 5 == 0010 == 2
		
		number = number >> 1;
		System.out.println(number);
		//2 == 0010
		//2>>1 == 0001 == 1
	}
}
