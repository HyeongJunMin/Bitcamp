package SortMain;

public class SortClass implements SortMethodTest{
	//Ŭ���� ������� : Ŭ���� ���ο����� ���� ����
	//Ŭ���� ��� �޼ҵ� : 
	
	private int number[];
	private int ascDesc;
	
	@Override
	public int[] sortIntegerArray(int[] n) {
		this.number = n;
		int temp = 0;

		// �Ű������� �����迭 �Ѱ��� ��� ��������
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
		
		//asdDesc�� 1�̸� ��������, �ƴϸ� ��������
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

