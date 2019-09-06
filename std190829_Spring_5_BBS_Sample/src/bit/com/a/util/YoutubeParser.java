package bit.com.a.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import bit.com.a.model.Youtube;

@Component
public class YoutubeParser {
	String urls = "https://www.youtube.com/results?search_query=";
	ArrayList<String> htmls = new ArrayList<String>();
	
	public ArrayList<String> search(String s){
		htmls.clear();       // 싹 비움
	      
	      BufferedReader br = null;
	      
	      try {
	         String ss = URLEncoder.encode(s, "utf-8");   // 검색어
	         
	         URL url = new URL(urls + ss);
	         br = new BufferedReader(new InputStreamReader(url.openStream(), "utf-8"));
	         
	         String msg = "";
	         while((msg = br.readLine()) != null ) {
	            if(msg.trim().contains("class=\"yt-uix-tile-link yt-ui-ellipsis yt-ui-ellipsis-2 yt-uix-sessionlink")) {
	               htmls.add(msg.trim());
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return htmls;
	}
	
	/** 제목을 주는 메소드
	 * @throws UnsupportedEncodingException 
	 * 
	 */
	public ArrayList<Youtube> getTitles(String key) throws UnsupportedEncodingException {
		
		ArrayList<Youtube> af = new ArrayList<Youtube>();
		int i = 0 ;
		
		ArrayList<String> asd = search(key);
		
		for (int j = 0; j < asd.size() ; j++) {
			String fu[] = asd.get(i).split("\"");
			String url = URLDecoder.decode(fu[5], "EUC-KR");
			String title = URLDecoder.decode(fu[11], "EUC-KR");
			Youtube f = new Youtube(title, toUrl(url), "");
			af.add(f);
			
			i++;
		}
		
		return af;
	}
	
	/** &를 제거
	 * 
	 */
	public String toUrl(String msg) {
		
		if( msg.indexOf("&") == -1 ) {
			return msg;
		}else {
			return msg.substring(0, msg.indexOf("&") );
		}
	}
}
