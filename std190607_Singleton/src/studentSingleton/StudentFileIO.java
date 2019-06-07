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
	
	// 파일정보 갱신(현재 어레이리스트 기준)
	public static void syncListToFile(File studentsData) {
		try {
			FileWriter fileW = new FileWriter(studentsData);

			// List students에 있는 정보를 파일에 덧씌우기(파일 출력)
			fileW.write("학번\t이름\t국어\t영어\t수학\t\n");

			for (StudentDto s : students) {
				fileW.write(s.getNumber() + "\t" + s.getName() + "\t" + s.getKorScore() + "\t" + s.getEngScore() + "\t"
						+ s.getMthScore() + "\t\n");
			}
			fileW.close();
		} catch (Exception e) {
			System.out.println("파일 출력 실패");
		}
	}
		
	public static List<StudentDto> syncFileToList(File studentsData) {
			students = new ArrayList<StudentDto>();
			// List students에 파일내용 불러와서 저장
			BufferedReader bfReader;
			try {
				bfReader = new BufferedReader(new FileReader(studentsData));
				String str;
				String tempStudentsInfo[];

				while ((str = bfReader.readLine()) != null) {
					tempStudentsInfo = str.split("\t");
					if (tempStudentsInfo[0].equals("학번") == false)
						students.add(new StudentDto(Integer.parseInt(tempStudentsInfo[0]), tempStudentsInfo[1],
								Integer.parseInt(tempStudentsInfo[2]), Integer.parseInt(tempStudentsInfo[3]),
								Integer.parseInt(tempStudentsInfo[4])));
				}

				bfReader.close();

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("파일 읽기 오류. 파일 검사 요망.");
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
