package std190524_method3;

import java.util.Scanner;

public class Work1 {
	//	5명 학생의 성적을 출력하는 프로그램
	//	제출방법 : 공유폴더에 업로드 ( 교수님 ip 192.168.0.66 )
	//	cmd -> \\192.168.0.66입력하면 공유폴더 열림 ->  과제1폴더에 업로드 ( 민형준폴더에 소스코드만 )
	//	[조건]
	
	public static void main(String[] args) {
		controlInfoSystem();
	}

	//학생정보 조회 시스템 제어
	static void controlInfoSystem() {
		//배열 생성
		String[][] students = new String[5][5];
		Scanner in = new Scanner(System.in);
		
		//학번 초기화
		for(int i = 0 ; i < students.length ; i++) {
			students[i][0] = "2019312"+i;
		}
		System.out.println("학생정보 입력방법 선택");
		System.out.println("랜덤값 설정 : 1,\t직접 입력 : 2");
		String checkSetMethod = in.next();
		if( Integer.parseInt(checkSetMethod.charAt(0)+"") == 2) {
			//학생정보 직접 입력
			inputIteration(students);	
		} else {
			//학생정보 랜덤값으로 초기화
			initStdArr(students);			
		}
		
		String strTemp = "";
		int chc = 1;
		
		while( chc == 1) {
			System.out.print("학생 성적 조회: 1,  성적 합계와 평균 조회: 2,  과목 별 1등 조회: 3 입력");
			strTemp = in.next();
			switch( Integer.parseInt(strTemp.charAt(0)+"") ) {
				case 1 :
					//학생정보 출력
					printAllStudentsInfo(students);										
					break;
				case 2 :
					//학점의 총합, 학점평균을 구한 뒤 출력
					printStudentsSumAndAve(students);
					break;
				case 3:
					System.out.println("과목 별 1등 점수 조회. 과목명 입력(국어/영어/수학) : ");
					strTemp = in.next();
					System.out.println(strTemp + numberOne(students, strTemp));
					break;
				default :
					System.out.println("잘못 입력하셨습니다. 다시 실행해 주세요.");
					break;
			}			

			System.out.println();
			System.out.print("계속 실행:1, 중단:2 입력");
			
			strTemp = in.next();
			chc = Integer.parseInt(strTemp.charAt(0)+"");
			System.out.println();
		}
		in.close();
		System.out.println("프로그램 종료.");
	}
		
	//학생정보 초기화를 위한 메소드
	static void initStdArr(String[][] students) {
		int rndNum = (int)(Math.random()*50);

		for(int i = 0 ; i < students.length ; i++) {
			students[i][1] = "학생"+(i+1);
			students[i][2] = (int)(Math.random()*50)+50+"";
			students[i][3] = (int)(Math.random()*50)+50+"";
			students[i][4] = (int)(Math.random()*50)+50+"";
		}
	}
		
	//학생정보 반복입력을 위한 메소드
	static void inputIteration(String[][] students) {
		int w = 0;
		String a, b, c, d;
		Scanner in = new Scanner(System.in);
		
		while( w < 5 ) {
			System.out.print("학생 " + (w+1) + "이름 : ");
			a = in.next();
			System.out.print("학생 " + (w+1) + "국어점수 : ");
			b = in.next();
			System.out.print("학생 " + (w+1) + "영어점수 : ");
			c = in.next();
			System.out.print("학생 " + (w+1) + "수학점수 : ");
			d = in.next();
			input(students, ("2019312"+w), a, b, c, d);
			w++;
		}
	}
	
	//학생정보 입력을 위한 메소드
	static void input(String[][] students, String stdNum, String name, String korNum, String encNum, String mthNum) {	 
		// 5명의 학생정보를 매개변수를 통해 입력
		// 학번은 내가 정해줌
		// 입력받을 값 : 이름, 국어점수, 영어점수, 수학점수
		// 매개변수로 받은 배열의 요소 중 매개변수로 받은 학번에 해당하는 학생의 정보를 매개변수로 받은 이름, 성적으로 저장 
		for(int i = 0 ; i < students.length ; i++) {
			if(students[i][0].equals(stdNum)) {
				students[i][1] = name;
				students[i][2] = korNum;
				students[i][3] = encNum;
				students[i][4] = mthNum;
			}
		}
	}
	
	//매개변수로 입력받은 학생의 국영수 합계 구하기
	static int sum(String[][] students, int no) {	
		int sum = 0;
		
		for(int i = 2 ; i < 5 ; i++ ) {
			sum += Integer.parseInt(students[no][i]);
		}	
		
		return sum;
	}
	
	//매개변수로 입력받은 학생의 국영수 평균 구하기
	static int avg(int sum) {	
		return sum/3;
	}
	
	//1등 뽑아내기. 과목정보를 매개변수로 받아라
	static String numberOne(String[][] students, String subject) {	
		String result = "잘못된 입력";
		int subjectIndex = 0;
		int temp = 0;
		
		if (subject.contains("국"))		subjectIndex = 2;
		else if (subject.contains("영"))	subjectIndex = 3;
		else if (subject.contains("수"))	subjectIndex = 4;
		
		for(int i = 0 ; i < students.length ; i++) {
			if( Integer.parseInt(students[i][subjectIndex]) > temp ) {
				temp = Integer.parseInt(students[i][subjectIndex]);
				result = students[i][subjectIndex];
			}
		}
		
		return " 과목의 1등 점수는 " + result + "입니다.";
	}
	
	static void printAllStudentsInfo(String[][] students) {	//학생 정보 전부 출력하는 함수
		System.out.println("     학번\t\t이름\t국어\t영어\t수학");
		for(int i = 0 ; i < students.length ; i++) {
			for(int j = 0 ; j < students[i].length ; j++ ) {
				System.out.print(students[i][j]+"\t");
			}
			System.out.println();
		}
	}

	//학생의 총점과 평균 출력
	static void printStudentsSumAndAve(String[][] students) {
		System.out.println("학번\t\t이름\t총점\t평균\t");
		String stdInfo="";
		int sum=0;
		int ave=0;
		for(int i = 0 ; i < students.length ; i++) {
			stdInfo = "";
			stdInfo += students[i][0] + "\t" + 
						students[i][1] + "\t" + 
						sum(students, i) + "\t" + 
						avg(sum(students,i));
			
			sum += sum(students, i);
			System.out.println(stdInfo);
		}
		ave = sum/15;
		System.out.println("전체 학생 통계\t\t" + sum + "\t" + ave);
	}


}
