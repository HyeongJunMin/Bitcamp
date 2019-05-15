package pracProject190515_bitoperation;
import java.math.*;
public class prac4 {
	//랜덤 숫자 취득
	void play() {
		int result=0,i=0;
		double ran =0.0;
		int arr[] = new int[1000];
		
		result = (int)(Math.random()*100) ;
		System.out.println("0부터 99까지의 정수를 출력합니다 : "+result);
//		for(i=0; i<arr.length; i++)
//			arr[i]=(int)(Math.random()*100) ;
//		for(int j:arr) {
//			if(j>99)
//				System.out.print(j+" ");
//			if(j<0)
//				System.out.print(j+" ");
//		}   검증용 코드
		
		result = (int)( (Math.random()*5)+11 ) ;
		System.out.println("11부터 15까지의 정수를 출력합니다 : "+result);
		
//		for(i=0; i<arr.length; i++)
//		arr[i]=(int)((Math.random()*5)+11) ;
//	for(int j:arr) {
//		if(j>15)
//			System.out.print(j+" ");
//		if(j<11)
//			System.out.print(j+" ");
//	}	검증용 코드
		
		result = (int)( (Math.random()*5) ) ;
		//0,1,2,3,4
		int[] arrInt = {3,7,9,13,15};
		//				0 1 2 3 4
		System.out.println("정수 3,7,9,13,15 중 1개 출력 : "+arrInt[result]);		
			
		
	}
}
