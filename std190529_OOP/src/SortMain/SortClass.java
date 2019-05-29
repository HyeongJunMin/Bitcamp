package SortMain;

public class SortClass implements SortMethodTest{
	//클래스 멤버변수 : 클래스 내부에서만 접근 가능
	//클래스 멤버 메소드 : 
	
	private int number[];
	private int ascDesc;
	
	@Override
	public int[] sortIntegerArray(int[] n) {
		this.number = n;
		int temp = 0;

		// 매개변수가 정수배열 한개인 경우 오름차순
		for (int i = 0; i < this.number.length; i++) {
			for (int j = i; j < this.number.length; j++) {
				if (number[j] < number[i]) {
					temp = number[i];
					number[i] = number[j];
					number[j] = temp;
				}
			}
		}

		return this.number;
	}
	
	public int[] sortIntegerArray(int[] n, int a) {
		this.number = n;
		this.ascDesc = a;
		int temp = 0;
		
		//asdDesc가 1이면 오름차순, 아니면 내림차순
		if( this.ascDesc == 1 ) {
			for(int i = 0 ; i < this.number.length ; i++ ) {
				for(int j = i ; j < this.number.length ; j++ ) {
					if( number[j] < number[i] ) {
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}
				}
			}	
		} else {
			for(int i = 0 ; i < this.number.length ; i++ ) {
				for(int j = i ; j < this.number.length ; j++ ) {
					if( number[j] > number[i] ) {
						temp = number[i];
						number[i] = number[j];
						number[j] = temp;
					}
				}
			}
		}
		return this.number;
	}
}

