package pds;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileDownLoader extends HttpServlet {

	//업로드한 파일의 경로를 취득하기 위한 변수 선언
	ServletConfig mConfig = null;
	//버퍼 크기 8KB
	static final int BUFFER_SIZE = 8192;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[FileDownloader] do get");
		
		String filename = req.getParameter("filename") + "";
		String sseq = req.getParameter("seq") + "";
		
		// down count 증가(DB)
		
		//response에서 outputstream 얻어옴
		BufferedOutputStream out = new BufferedOutputStream(resp.getOutputStream());
		
		//파일 경로 get
		String filePath = "";
		//tomcat 경로
		filePath = mConfig.getServletContext().getRealPath("/upload");
		//폴더 경로
		// filePath = "d:\\tmp";
		
		//tomcat 경로에 파일이름을 더해주고 확인
		filePath = filePath + "\\" + filename;
		//System.out.println("파일정보 : " + filePath);
		
		File f = new File(filePath);
		
		//파일이 존재하고, 읽을 수 있는 경우(보안)
		if( f.exists() && f.canRead() ) {
			//windows 다운로드 폼 - 전송부분
			resp.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
			resp.setHeader("Content-Transfer-Encoding", "binary;");
			resp.setHeader("Content-Length", "" + f.length());
			resp.setHeader("Pragma", "no-cache;"); 
			resp.setHeader("Expires", "-1;");
			
			//파일 생성 및 기입
			BufferedInputStream fileInput = new BufferedInputStream(new FileInputStream(f));
			byte buffer[] = new byte[BUFFER_SIZE];
			int read = 0 ;
			
			boolean downloadDone = false;
			while( (read = fileInput.read()) != -1 ) {
				out.write(buffer, 0, read); 	//실제 다운로드
				downloadDone = true;
			}
			
			//다운로드가 완료되었으면 다운로드 카운트 ++
			if( downloadDone == true ) {
				PdsDao.getInstance().addCount( Integer.parseInt(sseq) , false, true);
			}
			
			fileInput.close();
			out.flush();
			
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("[FileDownloader] do post");
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		mConfig = config;
	}

}
