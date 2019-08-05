package movieJsoup;

import java.util.List;

class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<MovieVO> lst = MovieManager.getCGVData();
		
		for(MovieVO v : lst) {
			System.out.println(v.toString());
		}
	}

}
