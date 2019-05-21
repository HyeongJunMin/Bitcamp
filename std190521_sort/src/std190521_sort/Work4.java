package std190521_sort;

public class Work4 {
	//	트럼프! 카드놀이!
	//	ACE를 합쳐서 1~10 에다가 J Q K 있음
	//	총 52장 ( 문양 별 13장 )
	//	52 셔플
	//	무늬 높은 순서 : 스페이드 - 다이아 - 하트 - 클로버(좁밥)
	
	//	[결과]
	//	1. 랜덤 숫자가 출력됨
	//	2. 랜덤 숫자에 해당하는 카드문자가 출력됨(1~K)
	//	3. 랜덤 숫자에 해당하는 그림이 출력됨
	//	예) 0~51 중 51이면 13(K) 클로버
	//	== 셔플이 잘 되었는지!!! 셔플만 잘 해보시면 됩니다 :)
	//	왜 자꾸 존내 쉬운것만 해주세여... 노잼사 하겠어요...
	void play() {
		int arrLen = 52;

		// 배열 선언
		int r_num[] = new int[arrLen];
		boolean r_swit[] = new boolean[arrLen];
		String[] cardChar = {"A", "2", "3", "4", "5", "6", "7", "8", "9","10", "J", "Q", "K"};
		String[] cardMark = {"스페이드", "다이아", "하트", "클로버"};

		// 초기화
		for (boolean b : r_swit)
			b = false;

		// 반복제어 변수 선언 및 초기화
		int w = 0;
		int rndTemp = 0;

		while (w < arrLen) {
			rndTemp = (int) (Math.random() * 52);
			if (r_swit[rndTemp] == false) { // 랜덤값을 index로 갖는 r_swit가 false이면
				r_swit[rndTemp] = true; // r_swit[rndTemp]에 true 저장
				r_num[w] = rndTemp + 1; // r_num[반복]
				w++; // 반복변수 +1
			}
		}
		String intro = "No\tNum\tMark\t";
		System.out.printf("%s\n",intro);
		
		int charNum = 0 , markNum = 0;
		
		//출력부
		for(int i = 0 ; i < arrLen ; i++ ) {
			charNum = (r_num[i]-1)%13 ;
			markNum = ( (r_num[i]-1)/13 );
//			System.out.printf("%d\t%d\n",charNum, markNum);
			System.out.printf("%d\t%s\t%s\t\n", i+1, cardChar[charNum], cardMark[markNum]);
		}
		


	}
}
