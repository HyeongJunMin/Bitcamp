package Review190530;

import java.util.Scanner;

public class DaoClass {
	Scanner sc = new Scanner(System.in);

	StudentDto stundents[];
	private int count;
	private int studentNum;

	public DaoClass() {
		stundents = new StudentDto[10];
		count = 0;
		studentNum = 1001;
	}

	// insert
	public void insert() {
		// 학생정보 추가
		// 입력
		/*
		 * System.out.print("이름:"); String name = sc.next();
		 * 
		 * System.out.print("국어:"); int lang = sc.nextInt();
		 * 
		 * System.out.print("영어:"); int eng = sc.nextInt();
		 * 
		 * System.out.print("수학:"); int math = sc.nextInt();
		 * 
		 * StudentDto dto = new StudentDto(studentNum, name, lang, eng, math);
		 */
		StudentDto dto = new StudentDto();

		dto.setNumber(studentNum);

		System.out.print("이름:");
		dto.setName(sc.next());

		System.out.print("국어:");
		dto.setLang(sc.nextInt());

		System.out.print("영어:");
		dto.setEng(sc.nextInt());

		System.out.print("수학:");
		dto.setMath(sc.nextInt());

		stundents[count] = dto;
		count++;
		studentNum++;
	}

	// delete
	public void delete() {
		System.out.print("삭제할 이름:");
		String name = sc.next();

		int index = search(name);
		if (index == -1) {
			System.out.println("학생 이름은 찾을 수 없습니다");
		} else {
			StudentDto dto = stundents[index];
			dto.setNumber(0);
			dto.setName("");
			dto.setLang(0);
			dto.setEng(0);
			dto.setMath(0);
			System.out.println("학생 데이터를 삭제하였습니다");
		}
	}

	// select == search
	public void select() {
		System.out.print("검색할 이름:");
		String name = sc.next();

		int index = search(name);
		if (index == -1) {
			System.out.println("학생 이름은 찾을 수 없습니다");
		} else {
			System.out.print("검색된 학생정보:");
			StudentDto dto = stundents[index];
			System.out.println(dto.toString());
		}
	}

	// update
	public void update() {
		System.out.print("수정할 이름:");
		String name = sc.next();

		int index = search(name);
		if (index == -1) {
			System.out.println("학생 이름은 찾을 수 없습니다");
			return;
		}

		System.out.println("수정 데이터를 입력해 주십시오:");
		System.out.print("국어:");
		int lang = sc.nextInt();

		System.out.print("영어:");
		int eng = sc.nextInt();

		System.out.print("수학:");
		int math = sc.nextInt();

		StudentDto dto = stundents[index];
		dto.setLang(lang);
		dto.setEng(eng);
		dto.setMath(math);

		System.out.println("수정을 완료했습니다");
	}

	// search
	public int search(String name) {
		int findIndex = -1;
		for (int i = 0; i < stundents.length; i++) {
			StudentDto dto = stundents[i];
			if (dto != null && dto.getNumber() != 0) {
				String dtoName = dto.getName();
				if (name.equals(dtoName)) {
					findIndex = i;
					break;
				}
			}
		}
		return findIndex;
	}

	// allprint
	public void allprint() {
		for (int i = 0; i < stundents.length; i++) {
			StudentDto dto = stundents[i];
			if (dto != null /* && dto.getNumber() != 0 */) {
				System.out.println(dto.toString());
			}
		}
	}

}
