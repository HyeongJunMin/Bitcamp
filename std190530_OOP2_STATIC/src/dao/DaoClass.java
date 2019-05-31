package dao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dto.StudentDto;

public class DaoClass {
	//data access object
	//삽입(insert), 삭제(delete), 검색(select), 수정(update), 출력(printall)
	Scanner in = new Scanner(System.in);
	List<StudentDto> students;
	private int count;
	File studentsData = new File("d:\\tmp\\Students.txt");
	
	//학생관리 시스템 데이터 파일에서 불러온 데이터를 List에 저장
	public DaoClass() {
		this.students = new ArrayList<>();
		count = 0;		
		BufferedReader bfReader;
		
		//List students에 파일내용 불러와서 저장
		try {
			bfReader = new BufferedReader(new FileReader(studentsData));
			String str ; 
			String tempStudentsInfo[];
			 
			while( (str = bfReader.readLine()) != null ) {
			    tempStudentsInfo = str.split("\t");
			    if( tempStudentsInfo[0].equals("학번") == false)
			    students.add(new StudentDto(
			    				Integer.parseInt(tempStudentsInfo[0]),
			    				tempStudentsInfo[1],
			    				Integer.parseInt(tempStudentsInfo[2]),
			    				Integer.parseInt(tempStudentsInfo[3]),
			    				Integer.parseInt(tempStudentsInfo[4]) ));
			}
			 
			bfReader.close();
			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("파일 읽기 오류. 파일 검사 요망.");
		}
		 
		this.runSystem();
	}
	
	//학생정보 시스템 메뉴 출력 및 반복
	public void runSystem() {
		char ch = 'Y';
		int selectMenu = 0;
		
		System.out.println("학생정보 시스템을 시작합니다.");
		while( ch == 'Y' ) {
			System.out.println("메뉴를 선택해 주세요.");
			System.out.print("(1)학생정보 등록\t\t(2)학생정보 삭제\t(3)학생정보 탐색\n(4)등록된 학생정보 수정\t(5)모든 학생정보 출력");
			//삽입(insert), 삭제(delete), 검색(select), 수정(update), 출력(printall)
			selectMenu = this.inputUntilInteger();
			
			switch( selectMenu ) {
				case 1: this.insert(); break;
				case 2: this.deleteStudent(); break;
				case 3: this.selectByNum(); break;
				case 4: this.updateStudents(); break;
				case 5: this.printAllStudents(); break;
				default : break;
			}
			
			System.out.println("계속하시겠습니까? (Y/N)");
			ch = isYOrN();
		}		
	}
	
	//삽입(insert) : 학생정보 추가
	public void insert() {
		char chcOK = '0';
		int number = 0;
		String name = "";
		int korScore = 0;
		int engScore = 0;
		int mthScore = 0;
		
		System.out.println("학생정보를 입력해 주세요 : ");
		
		while(chcOK != 'Y') {
			System.out.print("학번 : ");
			number = this.inputUntilInteger();
			System.out.print("이름 : ");
			name = in.next();
			System.out.print("국어점수 : ");
			korScore = this.inputUntilInteger();
			System.out.print("영어점수 : ");
			engScore = this.inputUntilInteger();
			System.out.print("수학점수 : ");
			mthScore = this.inputUntilInteger();
			String strTemp = "학번: " + number + "\t이름: " + name + "\t국어점수: " + korScore + "\t영어점수: " + engScore + "\t수학점수: " + mthScore ;
			System.out.println("입력하신 정보는 "+strTemp + "입니다.");
			System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
			chcOK = isYOrN();
		}	
		
		try {
			System.out.println("입력 완료!");
			StudentDto dto = new StudentDto(number, name, korScore, engScore, mthScore);
			students.add(dto);
			
			FileWriter fileW = new FileWriter(studentsData, true);
			fileW.write("\n" + number + "\t" + name + "\t" + korScore  + "\t" + engScore + "\t" + mthScore);
			
			fileW.close();
			
		}catch(Exception e) {
			
		}		
		
		
		
		count++;
	}
	
	//삭제(delete)
	public void deleteStudent() {
		int stdNum = 0;
		char ch = 'N';
		count = this.students.size();

		System.out.println("학번\t이름");
		for (int i = 0; i < count; i++) {
			System.out.println(students.get(i).getNumber() + "\t" + students.get(i).getName());
		}
		System.out.println(count + "명의 학생 중 삭제할 학생의 번호를 입력하세요 : ");
		
		stdNum = inputUntilInteger();

		while (ch == 'N') {
			System.out.println("입력하신 학번 " + stdNum + "의 정보를 삭제하시겠습니까? (Y/N)");
			ch = isYOrN();
		}
		//학번에 해당하는 정보 ArrayList에서 삭제
		for (int i = 0; i < count; i++) {
			if( students.get(i).getNumber() == stdNum ) {
				students.remove(i);
				break;
			}
		}		
		//삭제가 완료되었다면?
		if (count > this.students.size()) {
			try {
				FileWriter fileW = new FileWriter(studentsData);

				// List students에 있는 정보를 파일에 덧씌우기(파일 출력)
				fileW.write("학번\t이름\t국어\t영어\t수학\t\n");

				for (StudentDto s : this.students) {
					fileW.write(s.getNumber() + "\t" + s.getName() + "\t" + s.getKorScore() + "\t" + s.getEngScore()
							+ "\t" + s.getMthScore() + "\t\n");
				}
				fileW.close();
				System.out.println("학생정보 삭제 완료.");
			} catch (Exception e) {
				System.out.println("파일 입력 실패(학생정보삭제)");
			}
		} else {//삭제를 하지 않았다면?
			System.out.println("학생정보 삭제 실패.");
		}
	}
	
	
	//검색(select)
	public void selectByNum() {
		char ch = 'N';
		int num = 0;
		int i = 0;
		boolean has = false;
		
		System.out.print("학생정보 검색을 시작합니다. 정보를 조회할 학생의 번호를 입력하세요 : ");
		
		while ( ch == 'N' ) {
			num = inputUntilInteger();
			System.out.println("입력한 학번은 " + num + "입니다. 맞으면 Y, 틀리면 N을 입력하세요.");
			ch = isYOrN();
		}
		//입력받은 학번과 일치하는 학생이 있는지 검사
		for (i = 0; i < this.students.size(); i++) {
			if( students.get(i).getNumber() == num ) {
				has = true;
				break;
			}
		}
		if( has ) {
			System.out.println("학번\t이름\t국어\t영어\t수학\t");
			String strTemp = students.get(i).getNumber()+"\t"+
					students.get(i).getName()+"\t"+
					students.get(i).getKorScore()+"\t"+
					students.get(i).getEngScore()+"\t"+
					students.get(i).getMthScore()+"\t";
			System.out.println(strTemp);
		}else {
			System.out.println("학번 " + num + " 을 찾을 수 없습니다.");
		}
		System.out.println("학생정보 검색을 종료합니다.");
	}
	
	//수정(update)
	public void updateStudents() {
		char chcOK = '0';
		int number = 0;
		String name = "";
		int korScore = 0;
		int engScore = 0;
		int mthScore = 0;
		int num = 0;
		int i = 0;
		boolean has = false;
		char ch = 'N';
		System.out.println("학생정보를 수정합니다. 수정할 학생의 번호를 입력하세요.");
		while ( ch == 'N' ) {
			num = inputUntilInteger();
			System.out.println("입력한 학번은 " + num + "입니다. 맞으면 Y, 틀리면 N을 입력하세요.");
			ch = isYOrN();
		}
		//입력받은 학번과 일치하는 학생이 있는지 검사
		for (i = 0; i < this.students.size(); i++) {
			if( students.get(i).getNumber() == num ) {
				has = true;
				break;
			}
		}
		if( has ) {
			//학생정보 입력
			while(chcOK != 'Y') {
				System.out.print("학번 : ");
				number = this.inputUntilInteger();
				System.out.print("이름 : ");
				name = in.next();
				System.out.print("국어점수 : ");
				korScore = this.inputUntilInteger();
				System.out.print("영어점수 : ");
				engScore = this.inputUntilInteger();
				System.out.print("수학점수 : ");
				mthScore = this.inputUntilInteger();
				String strTemp = "학번: " + number + "\t이름: " + name + "\t국어점수: " + korScore + "\t영어점수: " + engScore + "\t수학점수: " + mthScore ;
				System.out.println("입력하신 정보는 "+strTemp + "입니다.");
				System.out.print("맞으면 Y, 틀리면 N을 입력하세요.");
				chcOK = isYOrN();
			}	
			students.get(i).setNumber(number);
			students.get(i).setName(name);
			students.get(i).setKorScore(korScore);
			students.get(i).setEngScore(engScore);
			students.get(i).setMthScore(mthScore);
			//System.out.println(students.get(i).toString());
			try {
				FileWriter fileW = new FileWriter(studentsData);

				// List students에 있는 정보를 파일에 덧씌우기(파일 출력)
				fileW.write("학번\t이름\t국어\t영어\t수학\t\n");

				for (StudentDto s : this.students) {
					fileW.write(s.getNumber() + "\t" + s.getName() + "\t" + s.getKorScore() + "\t" + s.getEngScore()
							+ "\t" + s.getMthScore() + "\t\n");
				}
				fileW.close();				
			} catch (Exception e) {
				System.out.println("파일 갱신 실패");
			}
		}else {
			System.out.println("입력한 학번에 해당하는 학생을 찾을 수 없습니다.");
		}
		
	}
	
	//모든 학생 정보 출력
	//출력(printall)
	public void printAllStudents() {
		System.out.println("모든 학생정보를 출력합니다.");
		
		try {
			BufferedReader bfReader = new BufferedReader(new FileReader(studentsData));
			String str;
			while( (str = bfReader.readLine()) != null) {
				System.out.println(str);
			}
			bfReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	//파일정보 갱신(현재 어레이리스트 기준)
	
	//입력값이 Y또는 N인지 검사
	private char isYOrN() {
		char ch = '1';
		
		while( ch != 'Y' && ch != 'N') {
			ch = in.next().toUpperCase().charAt(0);
			
			if( ch != 'Y' && ch != 'N' ) {
				System.out.println("Y또는 N을 입력하세요.");
			}			
		}		
		return ch;
	}
		
	//입력값이 정수인지 검사
	private int inputUntilInteger() {
		int num = 0;		

		char ch = 'f';
		boolean isNotInteger = true;
		
//		while( isNotInteger ) {
//			ch = in.next().charAt(0);
//			if ( isNotInteger = ( ch >= '0' && ch <= '9') ) {
//				isNotInteger = false;
//			}else {
//				System.out.println("정수가 아닙니다. 정수를 입력하세요.");
//				isNotInteger = true;
//			}
//		}
		while( isNotInteger ) {
		try {
			num = Integer.parseInt(in.next());
			isNotInteger = false;
		}catch (Exception e){
			System.out.println("정수가 아닙니다. 정수를 입력하세요.");
			isNotInteger = true;
		}
		}
		
		
		return num;
	}
	
	//입력값 확인
}
