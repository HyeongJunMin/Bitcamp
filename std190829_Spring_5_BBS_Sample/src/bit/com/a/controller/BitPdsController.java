package bit.com.a.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import bit.com.a.model.PdsDto;
import bit.com.a.service.BitPdsService;
import bit.com.a.util.FUpUtil;

@Controller
public class BitPdsController {
	
	@Autowired
	private BitPdsService pdsService;
	
	@RequestMapping(value = "pdslist.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String getPdsList(Model model) {
		
		model.addAttribute("doc_title", "자료실 > 자료목록");
		
		List<PdsDto> list = pdsService.getPdsList();
		model.addAttribute("pdslist", list);
		
		
		return "pdslist.tiles";
	}
	
	/**새 자료 추가 뷰로 이동하는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "pdswrite.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsWrite(Model model) {
		
		model.addAttribute("doc_title", "자료실 > 업로드");
		
		return "pdswrite.tiles";
	}

	/**자료실 게시물 상세보기 뷰로 이동하는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "pdsdetail.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsDetail(Model model, int seq) {
		
		model.addAttribute("doc_title", "자료실 > 게시글 상세 (" + seq + ")");
		model.addAttribute("pds", pdsService.getOnePds(seq) );
		
		return "pdsdetail.tiles";
	}
	
	/**자료실 게시물 수정 뷰로 이동하는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "pdsmod.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsMod(Model model, int seq) {
		
		model.addAttribute("doc_title", "자료실 > 게시글 수정");
		
		model.addAttribute("pds", pdsService.getOnePds(seq) );
		
		return "pdsmod.tiles";
	}
	
	/**자료실 게시물 수정 후 변경내용을 저장하는 메소드
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "pdsmodAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsModAf(PdsDto pdsdto, @RequestParam(value="fileload", required = false) MultipartFile fileload
							, HttpServletRequest req) {
		
		String filename = fileload.getOriginalFilename();
		
		return "pdsmod.tiles";
	}
	
	
	/**파일을 제외한 정보는 PdsDto로 받고, 파일은 MultipartFile로 받음
	 *  - @Bean multipartResolver를 설정했기 때문에
	 * RequestParam 설정
	 * 	- value : 폼에서의 name
	 * 	- required : 캐시에 저장할거냐?
	 * @param pdsdto
	 * @param fileload
	 * @return
	 */
	@RequestMapping(value = "pdswriteAf.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsUpload(PdsDto pdsdto, @RequestParam(value="fileload", required = false) MultipartFile fileload
			, HttpServletRequest req) {

		//서버에 파일을 저장할 때에는 파일명을 시간값으로 변경
		//DB에 저장할 때에는 원본 파일명과 시간값을 모두 저장
		//filename 취득
		String filename = fileload.getOriginalFilename();
		pdsdto.setFilename(filename);
		pdsdto.setOrigin_filename(filename);
		System.out.println("pdswriteAf.do !!!! " + pdsdto.toString());
		//upload 경로 설정(tomcat realpath)
		String fupload = req.getServletContext().getRealPath("/upload");
		System.out.println(fupload);
		//폴더 경로 설정
		String f = pdsdto.getFilename();
		String newfilename = FUpUtil.name(f);
		
		//업로드 수행
		pdsdto.setFilename(newfilename);
		
		File file = new File(fupload + "/" + newfilename);
		
		try {
			//실제 파일이 업로드 되는 부분
			FileUtils.writeByteArrayToFile(file, fileload.getBytes() );
			
			//db에 값 저장
			pdsService.uploadPds(pdsdto);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//업로드가 완료되면 자료실 리스트페이지로 이동
		return "redirect:/pdslist.do";
	}
	
	/**model에 filename, seq, 다운로드경로(req)를 얹어서 보냄
	 * @param model
	 * @param filename
	 * @param seq
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "fileDownload.do", method = {RequestMethod.GET, RequestMethod.POST})
	public String pdsFileDownload(Model model, String filename, int seq, HttpServletRequest req) {
		//download 경로
		String fupload = req.getServletContext().getRealPath("/upload");
		
		File downloadFile = new File(fupload + "/" + filename);
		
		model.addAttribute("downloadFile", downloadFile);
		model.addAttribute("seq", seq);
		
		//bean으로 데이터 흐름이 이동함
		return "downloadView";
	}
}
