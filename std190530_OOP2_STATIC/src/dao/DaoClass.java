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
	//����(insert), ����(delete), �˻�(select), ����(update), ���(printall)
	Scanner in = new Scanner(System.in);
	List<StudentDto> students;
	private int count;
	File studentsData = new File("d:\\tmp\\Students.txt");
	
	//�л����� �ý��� ������ ���Ͽ��� �ҷ��� �����͸� List�� ����
	public DaoClass() {
		this.students = new ArrayList<>();
		count = 0;		
		BufferedReader bfReader;
		
		//List students�� ���ϳ��� �ҷ��ͼ� ����
		try {
			bfReader = new BufferedReader(new FileReader(studentsData));
			String str ; 
			String tempStudentsInfo[];
			 
			while( (str = bfReader.readLine()) != null ) {
			    tempStudentsInfo = str.split("\t");
			    if( tempStudentsInfo[0].equals("�й�") == false)
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
			System.out.println("���� �б� ����. ���� �˻� ���.");
		}
		 
		this.runSystem();
	}
	
	//�л����� �ý��� �޴� ��� �� �ݺ�
	public void runSystem() {
		char ch = 'Y';
		int selectMenu = 0;
		
		System.out.println("�л����� �ý����� �����մϴ�.");
		while( ch == 'Y' ) {
			System.out.println("�޴��� ������ �ּ���.");
			System.out.print("(1)�л����� ���\t\t(2)�л����� ����\t(3)�л����� Ž��\n(4)��ϵ� �л����� ����\t(5)��� �л����� ���");
			//����(insert), ����(delete), �˻�(select), ����(update), ���(printall)
			selectMenu = this.inputUntilInteger();
			
			switch( selectMenu ) {
				case 1: this.insert(); break;
				case 2: this.deleteStudent(); break;
				case 3: this.selectByNum(); break;
				case 4: this.updateStudents(); break;
				case 5: this.printAllStudents(); break;
				default : break;
			}
			
			System.out.println("����Ͻðڽ��ϱ�? (Y/N)");
			ch = isYOrN();
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
			number = this.inputUntilInteger();
			System.out.print("�̸� : ");
			name = in.next();
			System.out.print("�������� : ");
			korScore = this.inputUntilInteger();
			System.out.print("�������� : ");
			engScore = this.inputUntilInteger();
			System.out.print("�������� : ");
			mthScore = this.inputUntilInteger();
			String strTemp = "�й�: " + number + "\t�̸�: " + name + "\t��������: " + korScore + "\t��������: " + engScore + "\t��������: " + mthScore ;
			System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
			System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
			chcOK = isYOrN();
		}	
		
		try {
			System.out.println("�Է� �Ϸ�!");
			StudentDto dto = new StudentDto(number, name, korScore, engScore, mthScore);
			students.add(dto);
			
			FileWriter fileW = new FileWriter(studentsData, true);
			fileW.write("\n" + number + "\t" + name + "\t" + korScore  + "\t" + engScore + "\t" + mthScore);
			
			fileW.close();
			
		}catch(Exception e) {
			
		}		
		
		
		
		count++;
	}
	
	//����(delete)
	public void deleteStudent() {
		int stdNum = 0;
		char ch = 'N';
		count = this.students.size();

		System.out.println("�й�\t�̸�");
		for (int i = 0; i < count; i++) {
			System.out.println(students.get(i).getNumber() + "\t" + students.get(i).getName());
		}
		System.out.println(count + "���� �л� �� ������ �л��� ��ȣ�� �Է��ϼ��� : ");
		
		stdNum = inputUntilInteger();

		while (ch == 'N') {
			System.out.println("�Է��Ͻ� �й� " + stdNum + "�� ������ �����Ͻðڽ��ϱ�? (Y/N)");
			ch = isYOrN();
		}
		//�й��� �ش��ϴ� ���� ArrayList���� ����
		for (int i = 0; i < count; i++) {
			if( students.get(i).getNumber() == stdNum ) {
				students.remove(i);
				break;
			}
		}		
		//������ �Ϸ�Ǿ��ٸ�?
		if (count > this.students.size()) {
			try {
				FileWriter fileW = new FileWriter(studentsData);

				// List students�� �ִ� ������ ���Ͽ� �������(���� ���)
				fileW.write("�й�\t�̸�\t����\t����\t����\t\n");

				for (StudentDto s : this.students) {
					fileW.write(s.getNumber() + "\t" + s.getName() + "\t" + s.getKorScore() + "\t" + s.getEngScore()
							+ "\t" + s.getMthScore() + "\t\n");
				}
				fileW.close();
				System.out.println("�л����� ���� �Ϸ�.");
			} catch (Exception e) {
				System.out.println("���� �Է� ����(�л���������)");
			}
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
			num = inputUntilInteger();
			System.out.println("�Է��� �й��� " + num + "�Դϴ�. ������ Y, Ʋ���� N�� �Է��ϼ���.");
			ch = isYOrN();
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
			num = inputUntilInteger();
			System.out.println("�Է��� �й��� " + num + "�Դϴ�. ������ Y, Ʋ���� N�� �Է��ϼ���.");
			ch = isYOrN();
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
				number = this.inputUntilInteger();
				System.out.print("�̸� : ");
				name = in.next();
				System.out.print("�������� : ");
				korScore = this.inputUntilInteger();
				System.out.print("�������� : ");
				engScore = this.inputUntilInteger();
				System.out.print("�������� : ");
				mthScore = this.inputUntilInteger();
				String strTemp = "�й�: " + number + "\t�̸�: " + name + "\t��������: " + korScore + "\t��������: " + engScore + "\t��������: " + mthScore ;
				System.out.println("�Է��Ͻ� ������ "+strTemp + "�Դϴ�.");
				System.out.print("������ Y, Ʋ���� N�� �Է��ϼ���.");
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

				// List students�� �ִ� ������ ���Ͽ� �������(���� ���)
				fileW.write("�й�\t�̸�\t����\t����\t����\t\n");

				for (StudentDto s : this.students) {
					fileW.write(s.getNumber() + "\t" + s.getName() + "\t" + s.getKorScore() + "\t" + s.getEngScore()
							+ "\t" + s.getMthScore() + "\t\n");
				}
				fileW.close();				
			} catch (Exception e) {
				System.out.println("���� ���� ����");
			}
		}else {
			System.out.println("�Է��� �й��� �ش��ϴ� �л��� ã�� �� �����ϴ�.");
		}
		
	}
	
	//��� �л� ���� ���
	//���(printall)
	public void printAllStudents() {
		System.out.println("��� �л������� ����մϴ�.");
		
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
	
	
	
	//�������� ����(���� ��̸���Ʈ ����)
	
	//�Է°��� Y�Ǵ� N���� �˻�
	private char isYOrN() {
		char ch = '1';
		
		while( ch != 'Y' && ch != 'N') {
			ch = in.next().toUpperCase().charAt(0);
			
			if( ch != 'Y' && ch != 'N' ) {
				System.out.println("Y�Ǵ� N�� �Է��ϼ���.");
			}			
		}		
		return ch;
	}
		
	//�Է°��� �������� �˻�
	private int inputUntilInteger() {
		int num = 0;		

		char ch = 'f';
		boolean isNotInteger = true;
		
//		while( isNotInteger ) {
//			ch = in.next().charAt(0);
//			if ( isNotInteger = ( ch >= '0' && ch <= '9') ) {
//				isNotInteger = false;
//			}else {
//				System.out.println("������ �ƴմϴ�. ������ �Է��ϼ���.");
//				isNotInteger = true;
//			}
//		}
		while( isNotInteger ) {
		try {
			num = Integer.parseInt(in.next());
			isNotInteger = false;
		}catch (Exception e){
			System.out.println("������ �ƴմϴ�. ������ �Է��ϼ���.");
			isNotInteger = true;
		}
		}
		
		
		return num;
	}
	
	//�Է°� Ȯ��
}
