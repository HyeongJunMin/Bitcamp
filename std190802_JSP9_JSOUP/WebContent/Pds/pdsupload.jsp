<%@page import="pds.PdsDto"%>
<%@page import="pds.PdsDao"%>
<%@page import="pds.iPdsDao"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="oracle.net.aso.u"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="java.io.File"%>
<%@page import="java.io.IOException"%>
<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%!
// 업로드
public String processUploadFile(FileItem fileItem, String dir) throws IOException{
	
	String filename = fileItem.getName();	// 경로 + 파일명
	long sizeInBytes = fileItem.getSize();
	
	// 파일이 정상
	if(sizeInBytes > 0){	// d:\\tmp\\abc.txt    d:/tmp/abc.txt  
		
		int idx = filename.lastIndexOf("\\");
		if(idx == -1){
			idx = filename.lastIndexOf("/");
		}
		
		filename = filename.substring(idx + 1);	// abc.txt
		
		File uploadFile = new File(dir, filename);
		try{
			fileItem.write(uploadFile);	// 실제 업로드 부분
		}catch(Exception e){}		
	}
	return filename;	// 확인용
}

%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>pdsupload.jsp</title>
</head>
<body>

<%
// tomcat 배포	
String fupload = application.getRealPath("/upload");

// 지정 폴더
// String fupload = "d:\\tmp";

System.out.println("파일업로드 폴더:" + fupload);

String yourTempDir = fupload;

int yourMaxRequestSize = 100 * 1024 * 1024;	// 1 MByte
int yourMaxMemorySize = 100 * 1024;			// 1 KByte

// form field의 데이터를 저장할 변수
String id = "";
String title = "";
String content = "";

// file name
String filename = "";

boolean isMultipart = ServletFileUpload.isMultipartContent(request);

if(isMultipart){
	
	// FileItem 을 생성
	DiskFileItemFactory factory = new DiskFileItemFactory();
	
	factory.setSizeThreshold(yourMaxMemorySize);
	factory.setRepository(new File(yourTempDir));
	
	ServletFileUpload upload = new ServletFileUpload(factory);
	upload.setSizeMax(yourMaxRequestSize);
	
	// list 저장
	List<FileItem> items = upload.parseRequest(request);
	Iterator<FileItem> it = items.iterator();
	
	while(it.hasNext()){
		FileItem item = it.next();
		
		if(item.isFormField()){	// id, title, content
			if(item.getFieldName().equals("id")){
				id = item.getString("utf-8");
			}
			else if(item.getFieldName().equals("title")){
				title = item.getString("utf-8");
			}
			else if(item.getFieldName().equals("content")){
				content = item.getString("utf-8");
			}			
		}else{	// fileload
			if(item.getFieldName().equals("fileload")){
				filename = processUploadFile(item, fupload);
				System.out.println("fupload:" + fupload); 
			}
		}		
	}		
}else{
	System.out.println("multipart 아님");
}

// DB
iPdsDao dao = PdsDao.getInstance();

boolean isS = dao.writePds(new PdsDto(id, title, content, filename));
if(isS){
%>
	<script type="text/javascript">
	alert("파일 업로드 성공!");
	location.href = "pdslist.jsp";
	</script>
<%
}else{
%>
	<script type="text/javascript">
	alert("파일 업로드 실패");
	location.href = "pdslist.jsp";
	</script>
<%
}
%>






</body>
</html>




