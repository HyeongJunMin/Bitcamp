package pracProject190515_bitoperation;

public class Lct_3_Array {
	void play() {
		/*
		 * Array(배열) : 같은 자료형 변수의 묶음
		 * 배열 수동 초기화는 선언시에만 가능 ex) int arr[] = {1,2,3,4};
		 * 
		 * /**/
		int[] arr=new int[43];
		int a=1,i=0;
		for(i=0;i<arr.length;i++)
			arr[i]=a++;
		
		for(int j:arr)
			System.out.print(j+" ");
		System.out.println();
		char[] ch = new char[5];
		//					할당==[5]
		ch[0]='1';
		String[] str= {"h","e","l"};
		System.out.println(str[0]);
		
		String ab1="222";
		String ab2=ab1;
		String ab3=ab2;
		System.out.println(ab1);
		ab3="111";
		System.out.println(ab1);
		String arrS[]= {"11","22","33"};
		String arrS2[] = arrS;
		String arrS3[] = arrS2;
		System.out.println(arrS3[2]);
		arrS3[2]="44";
		System.out.println(arrS3[2]);
	}
}
