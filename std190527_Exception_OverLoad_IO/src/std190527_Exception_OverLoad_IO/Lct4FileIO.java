package std190527_Exception_OverLoad_IO;
import java.io.File;
import java.io.IOException;

public class Lct4FileIO {
	//	파일입출력에 관한 내용
	//	파일이 뭐에요 ?? == 저장매체 == 기능 == 내가 머리쓰는게 아니고 가져다 쓰는거임
	//	Database활용 배울 때 oracle쓸건데 이것도 결국 파일입출력이야
	

	static void play1() {
		File file = new File("C:\\");
//		경로의 파일 명을 조사
//		String[] fileList = file.list();
//		System.out.println(Arrays.toString(fileList));
		
		//경로의 파일을 그대로 가져옴
//		File filelist[] = file.listFiles();
//		for( int i = 0 ; i < filelist.length ; i++ ) {
//			if( filelist[i].isFile() ) {
//				System.out.println("[파일]"+filelist[i].getName());
//			}else if( filelist[i].isDirectory() ) {
//				System.out.println("[폴더]"+filelist[i].getName());
//			}else {
//				System.out.println("[?]"+filelist[i].getName());
//			}
//		}
	}
	
	static void play2(){
		//	파일 만들기
		File newFile = new File("d:\\tmp\\newFile.txt");
		System.out.println("ok");
				
		try {
			if ( newFile.createNewFile() ) {
				System.out.println("create ok");
			} else {
				System.out.println("create fail");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}	
		
		//	폴더 생성
		String dirStr = "d:\\tmp1";
		File newDir = new File(dirStr);
		//mkdir은 더 하나만
		//mkdirs는 폴더 두개 이상. 지금은 tmp1, sub 총 2개 만들어야 되니까 mkdirs
		if( newDir.mkdir() ) {
			System.out.println("폴더생성 성공");
		} else {
			System.out.println("폴더생성 실패");
		}
		
		//	File 존재 여부
		if( newFile.exists() ) {
			System.out.println(newFile.getName() + " 파일이 있네요");
		}
		
		//	File 권한 검사
		if( newFile.canWrite() )
			System.out.println(newFile.getName() + " 파일 쓰기 쌉가능");
		else
			System.out.println("ㄴㄴ");
		
		//	File 삭제
		if( newFile.delete() )
			System.out.println(newFile.getName() + " 파일 삭제 완료");
		else
			System.out.println(newFile.getName() + " 파일 삭제 실패");
		
	}
}