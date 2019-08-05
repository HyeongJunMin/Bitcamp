package movieJsoup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MovieManager {
	
	public static List<MovieVO> getCGVData(){
		
		Document doc = null;
		List<MovieVO> list = new ArrayList<>();
		
		try {			
			//해당 URL의 문서를 객체에 저장
			doc = Jsoup.connect("http://www.cgv.co.kr/movies/").get();
			
			//영화 제목을 가져오기 위한 코드. 매개변수는 cssQuery()
			Elements titles = doc.select("div.box-contents strong.title");
			/* CGV 홈페이지의 소스코드
			  <div class="box-contents">
                <a href="/movies/detail-view/?midx=82012">
                    <strong class="title">엑시트</strong>
                </a>

			 */
			
			Elements likes = doc.select("div.box-contents span.count strong i");
			/*
			<div class="box-contents">
			 <span class="like"> 
                <button class="btn-like" value="82012">영화 찜하기</button>
                <span class="count"> 
                    <strong><i>8,852</i><span>명이 선택</span></strong> 
                    <i class="corner-RT"></i><i class="corner-LT"></i><i class="corner-LB"></i><i class="corner-RB"></i><i class="corner-arrow"></i>
                </span>
                <a class="link-reservation" href="/ticket/?MOVIE_CD=20020039&MOVIE_CD_GROUP=20020039">예매</a>
             </span>
             </div>
			 */			
//			for(Element e : titles) {
//				System.out.println(e.toString());
//			}
			
			for(int i = 0 ; i < 7 ; i++ ) {
				Element eTitle = titles.get(i);
				Element eLike = likes.get(i);
				
				int like = Integer.parseInt( eLike.text().replace(",", "") );
				
				System.out.println( "title: " + eTitle.text() + "\t like: " + eLike.text() );
				list.add(new MovieVO( eTitle.text() , like ));
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return list;
	}
	
}
