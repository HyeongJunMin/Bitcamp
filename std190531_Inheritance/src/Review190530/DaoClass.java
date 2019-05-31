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
		// �л����� �߰�
		// �Է�
		/*
		 * System.out.print("�̸�:"); String name = sc.next();
		 * 
		 * System.out.print("����:"); int lang = sc.nextInt();
		 * 
		 * System.out.print("����:"); int eng = sc.nextInt();
		 * 
		 * System.out.print("����:"); int math = sc.nextInt();
		 * 
		 * StudentDto dto = new StudentDto(studentNum, name, lang, eng, math);
		 */
		StudentDto dto = new StudentDto();

		dto.setNumber(studentNum);

		System.out.print("�̸�:");
		dto.setName(sc.next());

		System.out.print("����:");
		dto.setLang(sc.nextInt());

		System.out.print("����:");
		dto.setEng(sc.nextInt());

		System.out.print("����:");
		dto.setMath(sc.nextInt());

		stundents[count] = dto;
		count++;
		studentNum++;
	}

	// delete
	public void delete() {
		System.out.print("������ �̸�:");
		String name = sc.next();

		int index = search(name);
		if (index == -1) {
			System.out.println("�л� �̸��� ã�� �� �����ϴ�");
		} else {
			StudentDto dto = stundents[index];
			dto.setNumber(0);
			dto.setName("");
			dto.setLang(0);
			dto.setEng(0);
			dto.setMath(0);
			System.out.println("�л� �����͸� �����Ͽ����ϴ�");
		}
	}

	// select == search
	public void select() {
		System.out.print("�˻��� �̸�:");
		String name = sc.next();

		int index = search(name);
		if (index == -1) {
			System.out.println("�л� �̸��� ã�� �� �����ϴ�");
		} else {
			System.out.print("�˻��� �л�����:");
			StudentDto dto = stundents[index];
			System.out.println(dto.toString());
		}
	}

	// update
	public void update() {
		System.out.print("������ �̸�:");
		String name = sc.next();

		int index = search(name);
		if (index == -1) {
			System.out.println("�л� �̸��� ã�� �� �����ϴ�");
			return;
		}

		System.out.println("���� �����͸� �Է��� �ֽʽÿ�:");
		System.out.print("����:");
		int lang = sc.nextInt();

		System.out.print("����:");
		int eng = sc.nextInt();

		System.out.print("����:");
		int math = sc.nextInt();

		StudentDto dto = stundents[index];
		dto.setLang(lang);
		dto.setEng(eng);
		dto.setMath(math);

		System.out.println("������ �Ϸ��߽��ϴ�");
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
