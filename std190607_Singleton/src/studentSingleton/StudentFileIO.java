package studentSingleton;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class StudentFileIO {
	private static StudentFileIO single = null;
	public static List<StudentDto> students = null;
	
	private StudentFileIO() {  
		
	}
	
	// �������� ����(���� ��̸���Ʈ ����)
	public static void syncListToFile(File studentsData) {
		try {
			FileWriter fileW = new FileWriter(studentsData);

			// List students�� �ִ� ������ ���Ͽ� �������(���� ���)
			fileW.write("�й�\t�̸�\t����\t����\t����\t\n");

			for (StudentDto s : students) {
				fileW.write(s.getNumber() + "\t" + s.getName() + "\t" + s.getKorScore() + "\t" + s.getEngScore() + "\t"
						+ s.getMthScore() + "\t\n");
			}
			fileW.close();
		} catch (Exception e) {
			System.out.println("���� ��� ����");
		}
	}
		
	public static List<StudentDto> syncFileToList(File studentsData) {
			students = new ArrayList<StudentDto>();
			// List students�� ���ϳ��� �ҷ��ͼ� ����
			BufferedReader bfReader;
			try {
				bfReader = new BufferedReader(new FileReader(studentsData));
				String str;
				String tempStudentsInfo[];

				while ((str = bfReader.readLine()) != null) {
					tempStudentsInfo = str.split("\t");
					if (tempStudentsInfo[0].equals("�й�") == false)
						students.add(new StudentDto(Integer.parseInt(tempStudentsInfo[0]), tempStudentsInfo[1],
								Integer.parseInt(tempStudentsInfo[2]), Integer.parseInt(tempStudentsInfo[3]),
								Integer.parseInt(tempStudentsInfo[4])));
				}

				bfReader.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("���� �б� ����. ���� �˻� ���.");
			}
			
			return students;
		}
	
	public static StudentFileIO getInstance() {
		if( single == null ) {
			single = new StudentFileIO();
		}
		return single;
	}
}
