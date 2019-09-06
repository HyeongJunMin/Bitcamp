package bit.com.a.controller;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import bit.com.a.model.Youtube;
import bit.com.a.model.YoutubeSave;
import bit.com.a.service.BitYoutubeService;
import bit.com.a.util.YoutubeParser;

@Controller
public class BitYoutubeController {
	
	@Autowired
	private YoutubeParser youtubeParser;
	
	@Autowired
	private BitYoutubeService bitYoutubeService;
	
	@RequestMapping(value = "yutube.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String yutube(String s_keyword, Model model) throws UnsupportedEncodingException {
				
		model.addAttribute("doc_title", "Youtube");
		
		if( s_keyword != null && s_keyword.equals("") == false ) {
			
			s_keyword = s_keyword.replace("%", "%25"); 
			
			ArrayList<Youtube> getTitles = youtubeParser.getTitles(s_keyword);
			model.addAttribute("yulist", getTitles);
			model.addAttribute("s_keyword", s_keyword);
			
			for( Youtube y : getTitles ) {
				System.out.println(y);
			}
		}		
		
		return "yutube.tiles";
	}
	
	@ResponseBody
	@RequestMapping(value = "yutubesave.do", method = {RequestMethod.POST, RequestMethod.GET})
	public String yutubeSave(YoutubeSave you, Model model) throws UnsupportedEncodingException {
		return "vv";
	}
}
