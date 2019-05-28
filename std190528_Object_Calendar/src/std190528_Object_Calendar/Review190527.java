package std190528_Object_Calendar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class Review190527 {
	//0528추가 : 이름으로 검색
	
	//할일
	//1. 파일 생성
	//	파일 명 입력받아서
	//2. 파일 삭제
	//	파일 명 입력받아서
	//3. 파일 쓰기
	//	파일 명 + 쓸 문자열 입력받아서
	//4. 파일 읽기
	//	파일 명 입력받아서 불러들인 문자열은 String에 저장해주세요~
	//5. 파일 추가쓰기(누적)
	//	파일 명 입력받아서 
	//6. 모두 출력
	//	읽어 온 데이터 모두 출력
	//7. 프로그램 종료 메뉴
	public static Scanner in = new Scanner(System.in);
	void runFileIOSystem() {
		char continueSystem = 'Y';
		
		String intro = "파일 입출력 시스템 시작.\n메뉴를 선택하세요.\n(1)파일생성\t(2)파일삭제\t(3)파일쓰기\t(4)파일읽기\n(5)파일추가쓰기\t(6)모두출력\t(7)프로그램 종료\t(8)데이터검색";
		
		while( continueSystem == 'Y' ) {
			System.out.println(intro);			
			
			
			
			//inputRightValue 함수를 통해 1~7값을 사용자로 부터 입력받음
			//1~7에 해당하는 메뉴를 실행
			switch( inputRightValue() ) {
				case '1': mkFile(); break;
				case '2': dltFile(); break;
				case '3': wrtFile(); break;
				case '4': rdFile(); break;
				case '5': wrtToExsFile(); break;
				case '6': printAll(); break;
				case '7': continueSystem = '7'; break;
				case '8': searchData(); break;
				default : break;
			}
			
			
			
			
			//프로그램 시작종료 사용자 입력
//			if (continueSystem != '7') {
//				System.out.println("계속하시겠습니까? (Y/N)");
//				continueSystem = endOrContinueSystem();
//			}
		}
		
		System.out.println("프로그램을 종료합니다.");
		
		in.close();
	}
	
		
	//파일이름 입력받아 해당 이름으로 파일을 생성하는 메소드
	void mkFile() {
		String str="";
		char strChc = 'N';
		
		System.out.println("파일 생성을 시작합니다. 파일 이름을 입력하세요 : ");
		
		//Y 또는 N이 입력되면 종료
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("입력하신 파일명은 " + str + " 입니다. 맞으면 Y, 다시입력하려면 N을 입력하세요.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("파일명을 다시 입력해 주세요 : ");
		}
		
		String fileName = "d:\\tmp\\" + str + ".txt";
		
		
		File file  = new File(fileName);
		try {
			FileWriter fileW = new FileWriter(file, true);
			fileW.close();
			System.out.println("파일생성 완료 (" + str + ".txt)");
		}catch (Exception e){
			System.out.println("파일 생성 실패");			
		}
	}
	
	
	//파일 목록을 출력해주고 파일 이름을 입력받아서 해당 이름의 파일을 삭제하는 메소드
	void dltFile() {
		String str="";
		char strChc = 'N';
		
		//파일목록 view 부분
		
		System.out.println("파일 삭제를 시작합니다. 현재 생성된 파일 목록은 아래와 같습니다.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		if( fileList.length < 1) {
			System.out.println("파일이 없습니다. 파일 삭제 기능을 종료합니다.");
			return;
		}else {
			System.out.println(Arrays.toString(fileList));
		}
				
		
		
		//파일삭제 부분
		System.out.print("삭제하실 파일명을 입력 해 주세요(확장자제외) : ");
		//Y 또는 N이 입력되면 종료
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("입력하신 파일명은 " + str + " 입니다. 맞으면 Y, 다시입력하려면 N을 입력하세요.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("파일명을 다시 입력해 주세요 : ");
		}
		
		String fileName = "d:\\tmp\\" + str + ".txt";
		
		
		File file  = new File(fileName);
		try {
			file.delete();
			System.out.println("파일삭제 완료 (" + str + ".txt)");
		}catch (Exception e){
			System.out.println("파일 삭제 실패");			
		}
	}
	
	//파일쓰기
	void wrtFile() {
		String str="";
		String strWarn = "은 이미 존재하는 파일입니다.\n계속하시면 파일에 있던 내용은 삭제되고 새로이 입력된 내용으로 대체됩니다.\n계속하시겠습니까?(Y/N)";
		char strChc = 'N';
		
		//파일목록 view 부분
		
		System.out.println("파일 내용 입력을 시작합니다. 현재 생성된 파일 목록은 아래와 같습니다.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		System.out.println(Arrays.toString(fileList));
		
		
		//파일입력 부분
		System.out.print("내용을 입력할 파일명을 입력 해 주세요(확장자제외) : ");
		//Y 또는 N이 입력되면 종료
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("입력하신 파일명은 " + str + " 입니다. 맞으면 Y, 다시입력하려면 N을 입력하세요.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("파일명을 다시 입력해 주세요 : ");
			for(int i = 0 ; i < fileList.length ; i++ ) {
				if(fileList[i].equals(str+".txt")) {
					System.out.println(str + strWarn);
				}
			}
			strChc = in.next().toUpperCase().charAt(0);
		}
		

		
		String fileName = "d:\\tmp\\" + str + ".txt";
		String inputStr ="";
		
		System.out.print("파일 내부에 저장할 내용 입력 : ");
		
		strChc = 'n';
		//파일에 저장할 텍스트 입력하고 확인
		while(strChc != 'Y') {
			inputStr = in.next();
			System.out.println("입력하신 내용은 " + inputStr + " 입니다. 맞으면 Y, 다시입력하려면 N을 입력하세요.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("파일명을 다시 입력해 주세요 : ");
		}
		
		try {
			FileWriter fileW = new FileWriter(fileName);
			
			fileW.write(inputStr);
			System.out.println("파일내용입력 완료 (" + str + ".txt)");
			fileW.close();
		} catch (Exception e) {
			System.out.println("파일 입력실패!");
		} 
	}
	
	//파일 내용 읽기
	void rdFile() {
		String str="";
		char strChc = 'N';
		
		//파일목록 view 부분
		System.out.println("파일내용 읽기를 시작합니다. 현재 생성된 파일 목록은 아래와 같습니다.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		if( fileList.length < 1) {
			System.out.println("파일이 없습니다. 파일내용 읽기 기능을 종료합니다.");
			return;
		}else {
			System.out.println(Arrays.toString(fileList));
		}

		//파일선택 부분
		System.out.print("읽어오실 파일명을 입력 해 주세요(확장자제외) : ");
		//Y 또는 N이 입력되면 종료
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("입력하신 파일명은 " + str + " 입니다. 맞으면 Y, 다시입력하려면 N을 입력하세요.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("파일명을 다시 입력해 주세요 : ");
		}


		
		String fileName = "d:\\tmp\\" + str + ".txt";
		File fileToRead = new File(fileName);
		
		if( checkBeforeReadFile(fileToRead) ) {
			try {
				BufferedReader bfReader = new BufferedReader(new FileReader(fileToRead));
				System.out.println("파일 내용 : ");
				while( (str = bfReader.readLine()) != null ) {
					System.out.println(str);
				}
				
				bfReader.close();
				System.out.println("파일 읽기 종료.");
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		
		} else {
			System.out.println("파일을 찾을 수 없어요");
		}
	}
	
	//파일 내용에 누적으로 쓰기
	void wrtToExsFile() {
		String str="";
//		String strWarn = "은 이미 존재하는 파일입니다.\n계속하시면 파일에 있던 내용은 삭제되고 새로이 입력된 내용으로 대체됩니다.\n계속하시겠습니까?(Y/N)";
		char strChc = 'N';
		
		//파일목록 view 부분
		
		System.out.println("파일 내용 입력을 시작합니다. 현재 생성된 파일 목록은 아래와 같습니다.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		System.out.println(Arrays.toString(fileList));
		
		
		//파일입력 부분		
		System.out.print("내용을 입력할 파일명을 입력 해 주세요(확장자제외) : ");
		//Y 또는 N이 입력되면 종료
		while(strChc != 'Y') {
			str = in.next();
			System.out.println("입력하신 파일명은 " + str + " 입니다. 맞으면 Y, 다시입력하려면 N을 입력하세요.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("파일명을 다시 입력해 주세요 : ");
//			for(int i = 0 ; i < fileList.length ; i++ ) {
//				if(fileList[i].equals(str+".txt")) {
//					System.out.println(str + strWarn);
//				}
//			}
			strChc = in.next().toUpperCase().charAt(0);
		}
		

		
		String fileName = "d:\\tmp\\" + str + ".txt";
		String inputStr ="";
		
		System.out.print("파일 내부에 추가할 내용 입력 : ");
		
		strChc = 'n';
		//파일에 저장할 텍스트 입력하고 확인
		while(strChc != 'Y') {
			inputStr = in.next();
			System.out.println("입력하신 내용은 " + inputStr + " 입니다. 맞으면 Y, 다시입력하려면 N을 입력하세요.");
			strChc = in.next().toUpperCase().charAt(0);
			if( strChc != 'Y' )
				System.out.print("다시 입력해 주세요 : ");
		}
		
		inputStr  = "\n" + inputStr;
		
		try {
			FileWriter fileW = new FileWriter(fileName, true);
			
			fileW.write(inputStr);
			System.out.println("파일내용입력 완료 (" + str + ".txt)");
			fileW.close();
		} catch (Exception e) {
			System.out.println("파일 입력실패!");
		} 
		
	}
	
	//모든 파일 출력
	void printAll() {
		String str = "";
		//파일목록 view 부분
		System.out.println("파일내용 출력을 시작합니다. 현재 생성된 파일 목록은 아래와 같습니다.");
		File fileL = new File("D:\\tmp");
		String[] fileList = fileL.list();
		
		
		//현재 경로에 파일이 아무것도 없으면 기능 중단
		if( fileList.length < 1) {
			System.out.println("파일이 없습니다. 파일내용 읽기 기능을 종료합니다.");
			return;
		}else {
			System.out.println(Arrays.toString(fileList)+"\n");
		}
		
		
		

		try {
			
			for( int i = 0 ; i < fileList.length ; i++) {
				str = fileList[i];
				System.out.println("파일명 : " + str);
				String fileName = "d:\\tmp\\" + str;
				File fileToRead = new File(fileName);
				BufferedReader bfReader = new BufferedReader(new FileReader(fileToRead));
				System.out.println("파일 내용 : ");
				while ((str = bfReader.readLine()) != null) {
					System.out.println(str);
				}
				System.out.println(fileName + " 완료\n");
				bfReader.close();
			}
			
			System.out.println("파일 읽기 종료.\n");
			

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//이름으로 검색
	void searchData() {
		
			String str="";
			char strChc = 'N';
			
			//파일목록 view 부분
			System.out.println("파일 검색을 시작합니다. 현재 생성된 파일 목록은 아래와 같습니다.");
			File fileL = new File("D:\\tmp");
			String[] fileList = fileL.list();
			if( fileList.length < 1) {
				System.out.println("파일이 없습니다. 파일검색 기능을 종료합니다.");
				return;
			}else {
				System.out.println(Arrays.toString(fileList));
			}

			//파일선택 부분
			System.out.print("검색 대상 파일명을 입력 해 주세요(확장자제외) : ");
			//Y 또는 N이 입력되면 종료
			while(strChc != 'Y') {
				str = in.next();
				System.out.println("입력하신 파일명은 " + str + " 입니다. 맞으면 Y, 다시입력하려면 N을 입력하세요.");
				strChc = in.next().toUpperCase().charAt(0);
				if( strChc != 'Y' )
					System.out.print("파일명을 다시 입력해 주세요 : ");
			}

			//검색 대상 파일의 정보
			String fileName = "d:\\tmp\\" + str + ".txt";
			File fileToRead = new File(fileName);
			
			//검색 대상 파일의 문자열이 저장될 배열
			String[] fileData = new String[100];
			
			//검색어 저장 변수
			String userInputDataForSearch = "";
			
			
			if( checkBeforeReadFile(fileToRead) ) {
				try {
					strChc = 'Y';
					while(strChc == 'Y') {
						System.out.print("검색을 시작합니다. 이름을 입력해 주세요 : ");
						userInputDataForSearch = in.next();
						System.out.println("입력하신 검색어는 " + userInputDataForSearch + " 입니다.");

						
						//파일 내용을 문자열 배열에 저장
						BufferedReader bfReader = new BufferedReader(new FileReader(fileToRead));

						//반복제어변수
						int w = 0;
						while( (str = bfReader.readLine()) != null ) {
							fileData = str.split("-");
							w++;
							for( int i = 0 ; i < fileData.length; i++ ) {
								if( fileData[0].equals(userInputDataForSearch) ) {
									System.out.println("나이\t거주지");
									System.out.println(fileData[1]+"\t"+fileData[2]);
									w = 100;
									break;
								}
							}
							if(w == 100)
								break;
						}
						if(w != 100)
							System.out.println("검색 결과가 없습니다.");
						//검색부
//						for( int i = 0 ; i < fileData.length; i++ ) {
//							if( fileData[i][0].equals(userInputDataForSearch) ) {
//								System.out.println(fileData[i][1]+"\t"+fileData[i][2]);
//								break;
//							}
//						}
						if (strChc == 'Y') {
							System.out.println("계속 검색하시겠습니까? (Y/N)");
							strChc = endOrContinueSystem();
						}
					}			
					System.out.println("파일 검색 종료.");

					
				} catch (Exception e) {
					e.printStackTrace();
				}
					
			
			} else {
				System.out.println("파일을 찾을 수 없어요");
			}
		
	}
		
	char inputRightValue() {
		char a = 'a';
		
		while(a < '1' || a > '8') {
			a = in.next().charAt(0);
			if( a < '1' || a > '8' )
				System.out.println("잘못된 값을 입력했습니다. 다시 입력해 주세요. (1~7)");
		}		
		
		return a;
	}

	char endOrContinueSystem() {
		char a=0;
		
		//Y 또는 N이 입력되면 종료
		while(a != 'Y' && a != 'N') {
			a = in.next().toUpperCase().charAt(0);
			if( a != 'Y' && a != 'N' )
				System.out.println("잘못된 값을 입력했습니다. 다시 입력해 주세요. (Y, N)");
		}
		
		return a;
	}
	
	//파일을 읽어올 때 파일이 존재하는지 여부 확인
	static boolean checkBeforeReadFile(File f) {
		if( f.exists() ) {
			if( f.isFile() && f.canRead() ) {
				return true;
			}
		}
		return false;
	}

	

}
