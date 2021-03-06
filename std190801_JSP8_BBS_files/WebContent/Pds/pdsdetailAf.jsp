<%@page import="pds.PdsDao"%>
<%@page import="pds.PdsDto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	//업로드를 위한 함수. 매개변수는 apache.commons.fileupload.FileItem
	//파일이 없을 가능성이 있으므로 IOException
	public String processUploadFile(FileItem fileItem, String dir) throws IOException{
		
		String filename = fileItem.getName();
		long sizeInBytes = fileItem.getSize();
		
		//파일이 정상인지 확인(사이즈가 0보다 큰가?)
		if( sizeInBytes > 0 ){
			//파일 이름 : d:\\tmp\\abc.txt
			
			//마지막 \\의 인덱스를 찾고, 인덱스가 없으면 /로 찾음
			int idx = filename.lastIndexOf("\\");
			if( idx == -1 ){
				idx = filename.lastIndexOf("/");
			}
			
			//마지막 구분자 위치의 뒤에있는 모든 문자열을 filename으로 갱신 
			filename = filename.substring(idx + 1);
			
			//파일을 저장할 위치와 파일명 입력
			File uploadFile = new File(dir, filename);
			
			try{
				//실제 업로드 부분
				fileItem.write(uploadFile);
			}catch(Exception e){	}			
		}		
		//업로드된 파일의 이름을 리턴
		return filename;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	if( request.getParameter("del") == null ){
		
	
	//tomcat 배포
	//String fupload = application.setAttribute(arg0, arg1); application내장객체 attr set/get 가능
	//WebContent 폴더(루트) 아래에 upload폴더 생성 
	
	String fupload = application.getRealPath("/upload");
	
	//지정폴더 배포
	//String fupload = "d:\\tmp";
	//System.out.println("파일 업로드 경로 : " + fupload);
	
	String yourTempDir = fupload;
	
	//전송할 때 사이즈 1MB(총 용량), 메모리사이즈 1KB(버퍼용량)로 설정
	int yourMaxRequestSize = 1000 * 1024 * 1024 ;
	int yourMaxMemorySize = 100 * 1024;
	
	//form field의 데이터. multipart 방식이므로 좀 다름
	int seq = 0;
	String id = "";
	String title = "";
	String content = "";	
	String filename = ""; //DB에 저장하기 위한 filename 선언
	
	boolean isMultipart = ServletFileUpload.isMultipartContent(request);
	
	if( isMultipart == true ){
		//FileItem 생성 - factory 생성 및 설정 후 매개변수로 전달하여 upload객체생성
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(yourMaxMemorySize); //thresh hold 사이즈 설정
		factory.setRepository(new File(yourTempDir)); //repository 경로 설정
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(yourMaxRequestSize);
		
		//list 저장
		List<FileItem> items = upload.parseRequest(request);
		Iterator<FileItem> it = items.iterator();
		while( it.hasNext() ){
			FileItem item = it.next();
			if( item.isFormField() ){//id, title, content가 넘어오는 경우
				if(item.getFieldName().equals("author")){
					id = item.getString("UTF-8");
				}else if(item.getFieldName().equals("title")){
					title = item.getString("UTF-8");
				}else if(item.getFieldName().equals("content")){
					content = item.getString("UTF-8");
				}else if(item.getFieldName().equals("seq")){
					seq = Integer.parseInt( item.getString("UTF-8") + ""  );
				}
			}else{	//fileload. file이 넘어온 경우
				if( item.getFieldName().equals("inputFile") ){
					filename = processUploadFile(item, fupload);
					//System.out.println("fupload : " + fupload);
					System.out.println("filename : " + filename);
				}
			}
		}
		out.println("ID : " + id + "<br/>");
		out.println("title : " + title + "<br/>");
		out.println("content : " + content + "<br/>");
		out.println("filename : " + filename + "<br/>");
	}else{
		System.out.println("multipart가 아닙니다.");
	}

	//DB저장
	PdsDto dto = new PdsDto(seq, id, title, content, filename);
	boolean isDone = PdsDao.getInstance().updateOnePds(dto);
	System.out.println("done!!!!!!!!!!!!!!!!!!");
	if( isDone == true ){
		//DB저장이 성공한 경우
		%>
			<script type="text/javascript">
				alert('파일 업로드 성공!');
				location.href='pdslist.jsp';
			</script>		
		<%
	}else{
		//DB저장 실패한 경우
		%>
		<script type="text/javascript">
			alert('파일 업로드 실패!');
			history.back();
		</script>		
	<%		
	}
	
	//명령이 delete이면 게시물 삭제
	}else if( request.getParameter("del") != null ){
		int seq = Integer.parseInt( request.getParameter("seq") + "" );
		boolean isDone = PdsDao.getInstance().delOnePds(seq);
		
		//삭제가완료된 경우 pdslist로 이동
		if( isDone == true ){
			%>
				<script type="text/javascript">
				alert('파일 삭제 성공!');
				location.href='pdslist.jsp';
			</script>	
			<%
		}else{
			%>
			<script type="text/javascript">
			alert('파일 삭제 실패!');
			history.back();
		</script>	
		<%
		}
	}
%>
</body>
</html>