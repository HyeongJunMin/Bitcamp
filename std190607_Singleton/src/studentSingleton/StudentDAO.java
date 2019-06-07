package studentSingleton;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentDAO {
	//data access object
	//����(insert), ����(delete), �˻�(select), ����(update), ���(printall)
	Scanner in = new Scanner(System.in);
	List<StudentDto> students;
	private int count;
	File studentsData = new File("d:\\tmp\\Students.txt");
	
	//�л����� �ý��� ������ ���Ͽ��� �ҷ��� �����͸� List�� ����
	public StudentDAO() {
		this.students = StudentFileIO.syncFileToList(studentsData);
		count = 0;				 
	}
	
	//�л����� �ý��� �޴� ��� �� �ݺ�
	public void runSystem() {
		char ch = 'Y';
		int selectMenu = 0;
		
		System.out.println("�л����� �ý����� �����մϴ�.");
		while( ch == 'Y' ) {
			System.out.println("�޴��� ������ �ּ���.");
			System.out.print("(1)�л����� ���\t\t(2)�л����� ����\t(3)�л����� Ž��\n(4)��ϵ� �л����� ����\t(5)��� �л����� ���\t(6)������� ����");
			//����(insert), ����(delete), �˻�(select), ����(update), ���(printall)
			selectMenu = StaticFunction.inputUntilInteger();
			
			switch( selectMenu ) {
				case 1: this.insert(); break;
				case 2: this.deleteStudent(); break;
				case 3: this.selectByNum(); break;
				case 4: this.updateStudents(); break;
				case 5: this.printAllStudents(); break;
				case 6: StudentFileIO.syncListToFile(studentsData); break;
				default : break;
			}
			
			System.out.println("����Ͻðڽ��ϱ�? (Y/N)");
			ch = StaticFunction.isYOrN();
		}		
	}
	
	//����(insert) : �л����� �߰�
	public void insert() {
		char chcOK = '0';
		int number = 0;
		String name = "";
		int korScore = 0;
		int engScore = 0;
		int mthScore = 0;
		
		System.out.println("�л������� �Է��� �ּ��� : ");
		
		while(chcOK != 'Y') {
			System.out.print("�й� : ");
			number = StaticFunction.inputUntilInteger();
			System.out.print("�̸� : ");
			name = in.next();
			System.out.print("�������� : ");
			korScore = StaticFunction.inputUntilInteger();
			System.out.print("�������� : ");
			engScore = StaticFunction.inputUntilInteger();
			System.out.print("�������� : ");
			mthScore = StaticFunction.inputUntilInteger();
			String strTemp = "�й�: " + number + "\t�̸�: " + name + "\t��������: " + korScore + "\t��������: " + engScore + "\t��������: " + mthScore ;
			System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
			System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
			chcOK = StaticFunction.isYOrN();
		}	
		System.out.println("�Է� �Ϸ�!");
		
		StudentFileIO.students.add(new StudentDto(number, name, korScore, engScore, mthScore));
	
		count++;
	}
	
	//����(delete)
	public void deleteStudent() {
		int stdNum = 0;
		char ch = 'N';
		count = this.students.size();

		System.out.println("�й�\t�̸�");
		for (int i = 0; i < count; i++) {
			System.out.println(StudentFileIO.students.get(i).getNumber() + "\t" + StudentFileIO.students.get(i).getName());
		}
		System.out.println(count + "���� �л� �� ������ �л��� ��ȣ�� �Է��ϼ��� : ");
		
		stdNum = StaticFunction.inputUntilInteger();

		while (ch == 'N') {
			System.out.println("�Է��Ͻ� �й� " + stdNum + "�� ������ �����Ͻðڽ��ϱ�? (Y/N)");
			ch = StaticFunction.isYOrN();
		}
		//�й��� �ش��ϴ� ���� ArrayList���� ����
		for (int i = 0; i < count; i++) {
			if( StudentFileIO.students.get(i).getNumber() == stdNum ) {
				StudentFileIO.students.remove(i);
				break;
			}
		}		
		//������ �Ϸ�Ǿ��ٸ�?
		if (count > StudentFileIO.students.size()) {
			System.out.println("�л����� ���� ����.");
		} else {//������ ���� �ʾҴٸ�?
			System.out.println("�л����� ���� ����.");
		}
	}
		
	//�˻�(select)
	public void selectByNum() {
		char ch = 'N';
		int num = 0;
		int i = 0;
		boolean has = false;
		
		System.out.print("�л����� �˻��� �����մϴ�. ������ ��ȸ�� �л��� ��ȣ�� �Է��ϼ��� : ");
		
		while ( ch == 'N' ) {
			num = StaticFunction.inputUntilInteger();
			System.out.println("�Է��� �й��� " + num + "�Դϴ�. ������ Y, Ʋ���� N�� �Է��ϼ���.");
			ch = StaticFunction.isYOrN();
		}
		//�Է¹��� �й��� ��ġ�ϴ� �л��� �ִ��� �˻�
		for (i = 0; i < this.students.size(); i++) {
			if( students.get(i).getNumber() == num ) {
				has = true;
				break;
			}
		}
		if( has ) {
			System.out.println("�й�\t�̸�\t����\t����\t����\t");
			String strTemp = students.get(i).getNumber()+"\t"+
					students.get(i).getName()+"\t"+
					students.get(i).getKorScore()+"\t"+
					students.get(i).getEngScore()+"\t"+
					students.get(i).getMthScore()+"\t";
			System.out.println(strTemp);
		}else {
			System.out.println("�й� " + num + " �� ã�� �� �����ϴ�.");
		}
		System.out.println("�л����� �˻��� �����մϴ�.");
	}
	
	//����(update)
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
		
		System.out.println("�л������� �����մϴ�. ������ �л��� ��ȣ�� �Է��ϼ���.");
		while ( ch == 'N' ) {
			num = StaticFunction.inputUntilInteger();
			System.out.println("�Է��� �й��� " + num + "�Դϴ�. ������ Y, Ʋ���� N�� �Է��ϼ���.");
			ch = StaticFunction.isYOrN();
		}
		
		//�Է¹��� �й��� ��ġ�ϴ� �л��� �ִ��� �˻�
		for (i = 0; i < this.students.size(); i++) {
			if( students.get(i).getNumber() == num ) {
				has = true;
				break;
			}
		}
		
		if( has ) {
			//�л����� �Է�
			while(chcOK != 'Y') {
				System.out.print("�й� : ");
				number = StaticFunction.inputUntilInteger();
				System.out.print("�̸� : ");
				name = in.next();
				System.out.print("�������� : ");
				korScore = StaticFunction.inputUntilInteger();
				System.out.print("�������� : ");
				engScore = StaticFunction.inputUntilInteger();
				System.out.print("�������� : ");
				mthScore = StaticFunction.inputUntilInteger();
				String strTemp = "�й�: " + number + "\t�̸�: " + name + "\t��������: " + korScore + "\t��������: " + engScore + "\t��������: " + mthScore ;
				System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
				System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
				chcOK = StaticFunction.isYOrN();
			}	
			students.get(i).setNumber(number);
			students.get(i).setName(name);
			students.get(i).setKorScore(korScore);
			students.get(i).setEngScore(engScore);
			students.get(i).setMthScore(mthScore);
			//System.out.println(students.get(i).toString());
			System.out.println("���� ���� ����");
		}else {
			System.out.println("�Է��� �й��� �ش��ϴ� �л��� ã�� �� �����ϴ�.");
		}
		
	}
	
	//��� �л� ���� ���
	//���(printall)
	public void printAllStudents() {
		System.out.println("��� �л������� ����մϴ�.");
		System.out.println("�й�\t�̸�\t����\t����\t����");
		for(StudentDto s : students) {
			System.out.println(s.toString());
		}
	}

}
