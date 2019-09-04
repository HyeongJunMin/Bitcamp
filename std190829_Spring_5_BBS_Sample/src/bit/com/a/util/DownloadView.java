package bit.com.a.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.servlet.view.AbstractView;

import bit.com.a.service.BitPdsService;

public class DownloadView extends AbstractView{

	@Autowired
	private BitPdsService pdsService;
	
	@Override
	protected void renderMergedOutputModel(Map<String, Object> model, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		File file = (File)model.get("downloadFile");
		int currSeq = Integer.parseInt( model.get("seq") + "" );
		String currOriginFileName = pdsService.getOnePds(currSeq).getOrigin_filename();
		
		// 파일의 타입과 길이값 설정
		response.setContentType(this.getContentType());
		response.setContentLength((int)file.length());
		
		//브라우저 별 설정
		String userAgent = request.getHeader("user-Agent");
		boolean ie = userAgent.indexOf("MSIE") > -1;	//-1보다 크면 IE
		
		String filename = null;
		if( ie == true ) {
			filename = URLEncoder.encode(file.getName(), "utf-8");
		}else {
			filename = new String(file.getName().getBytes("utf-8"), "iso-8859-1");
		}
		
		//클라이언트에서 다운로드를 받을 수 있도록 window download 인터페이스 설정
//		response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + currOriginFileName + "\";");
		response.setHeader("Content-Transfer-Encoding", "binary;");
		response.setHeader("Content-Length", "" + file.length());
		response.setHeader("Pragma", "no-cache;"); 
		response.setHeader("Expires", "-1;");
		
		OutputStream out = response.getOutputStream();
		FileInputStream fi = null;
		
		fi = new FileInputStream(file);
		FileCopyUtils.copy(fi, out);//실질적으로 파일 다운로드를 수행하는 코드
		//download count 증가
		pdsService.plusDownCount( currSeq );
		
		if( fi != null ) {
			fi.close();
		}
	}	
}
