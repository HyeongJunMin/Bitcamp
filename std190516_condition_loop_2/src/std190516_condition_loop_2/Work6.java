package std190516_condition_loop_2;

public class Work6 {
	void play1() {
		// 모래시계 모양으로 별찍기
		
		int origin = 11;
		int a = origin;
		int b = 0;
		System.out.println("size: " + origin);
		System.out.println();
		
		for (int i = 0; i < origin; i++) {
			for (int j = 0; j < b; j++)
				System.out.print(" ");
			for (int j = 0; j < a; j++)
				System.out.print("*");
			
			
			a = (i<(origin/2))?a-2:a+2;
			b = (i<(origin/2))?b+1:b-1;
			System.out.println();
		}
	}
	void play2() {
		//속이 비어있는 마름모 모양으로 별 찍기
		
		int size = 9;	//행렬 size 설정
		int x=0,y1=size/2,y2=size/2;	//행렬 x,y좌표
		char[][] arr = new char[9][9];
		System.out.println("size: " + size + ", x: " + x + ", y: " + y1);
		System.out.println();
		for (int i = 0; i < size; i++) {
			arr[x][y1] = '*';
			arr[x][y2] = '*';
			x++;
			y1 = ( x > (size/2) )? y1-1 : y1+1;
			y2 = ( x > (size/2) )? y2+1 : y2-1;
		}
		
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) 
				System.out.print(arr[i][j]);
			System.out.println();
		}
		
	}
	
	void play3() {
		//세로로 자른 마름모 모양으로 별 찍기
		int size = 9;
		int a = 0, b = ( size / 2 );
		for (int i = 0; i < size; i++) {
			for (int j = 0; j <= (a+b); j++) {
				if(j>=b)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			if( i < (size/2) ) {
				a++;
				b--;
			} else {
				a--;
				b++;
			}				
		}
	}
	
	void play4() {
		//마름모 모양으로 별 찍기
		int size = 13;
		System.out.println("size: " + size);
		System.out.println();
		int a = ( size / 2 ), b = ( size / 2 );
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(j>=b && j<=a)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
			if( i < (size/2) ) {
				a++;
				b--;
			} else {
				a--;
				b++;
			}				
		}
	}
}

