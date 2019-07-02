package lct2MVC2_controller;

import java.util.List;
import java.util.Map;

import javax.swing.JOptionPane;

import lct2MVC2_model.DTOBbs;
import lct2MVC2_model.DTOMem;
import lct2MVC2_service.BbsService;
import lct2MVC2_service.MemService;
import lct2MVC2_service.impl.BbsServiceImpl;
import lct2MVC2_service.impl.MemServiceImpl;
import lct2MVC2_single.Singleton;
import lct2MVC2_view.View_Board;
import lct2MVC2_view.View_Edit;
import lct2MVC2_view.View_Login;
import lct2MVC2_view.View_Mgr;
import lct2MVC2_view.View_ModMem;
import lct2MVC2_view.View_NewPost;
import lct2MVC2_view.View_SelectedPost;
import lct2MVC2_view.View_Signin;

//Controller는 어디서든지 접근할 수 있어야 하기 때문에 싱글턴에 포함시켜야 함
public class MemberController {
	//Controller는 Service를 생성해준다.
	public MemService memService = new MemServiceImpl();
	public BbsService bbsService = new BbsServiceImpl();
	
	//MEMBER 관련 메소드
	//MEMBER DB가 가진 내용을 Model이 가진 Map에 저장하는 메소드
	public void syncDBToMap() {
		memService.syncDBToMap();
	}
	
	//로그인뷰 생성
	public void login() {
		new View_Login();
	}
	
	//로그인뷰 -> 회원가입뷰로 이동
	public void regi() {	
		new View_Signin();
	}
	
	//로그인 성공하면 게시판 뷰로 이동, 싱글턴 클래스에 현재 세션 아이디 저장
	public void board(String id) {	
		new View_Board();
		Singleton.getInstance().sessionId = id;
	}
	
	//로그인 성공했을 때 관리자이면 관리자 페이지로 이동
	public void admin() {
		new View_Mgr();
	}
	
	//View_Mgr에서 관리자권한을 부여 및 회수하는 메소드
	public boolean alterAuth(String id ) {
		return memService.alterAuth(id);
	}
	
	//매개변수로 받은 아이디가 관리자계정인지 확인해주는 메소드
	public boolean isAdmin(String id) {
		return memService.isAdmin(id);
	}
	
	//MEMBER DB정보를 Map으로 리턴하는 메소드 
	public Map<String, DTOMem> getMap(){
		return memService.getMap();
	}
	
	//View_Mgr에서 수정을 클릭했을 때 회원정보를 수정하는 메소드
	public void modMember(String id) {
		new View_ModMem(id);
	}
	
	//View_Mgr에서 선택한 계정들을 MEMBER DB에서 삭제하는 메소드
	public boolean deleteMembers(List<String> ids) {
		return memService.deleteMembers(ids);
	}
	
	//View_ModMem에서 입력한 값으로 회원정보를 수정하는 메소드
	public boolean updateMember(DTOMem dto) {
		return memService.updateMember(dto);
	}
	
	//view_login, view_signin에서 아이디 검사
	public boolean idChk(String id) {
		return memService.getId(id);
	}
	
	//view_login에서 비밀번호 검사
	public boolean pwChk(String pw) {
		return memService.getPw(pw);
	}
	
	//회원가입뷰 후에 실행할 메소드
	public void regiAf(String id,String pw,String name,String email) {	
		//이건 특수한 케이스이고 데이터를 받았을 때에는 뷰에서 처리해줘도 된다.
		boolean b = memService.addMem(new DTOMem(id, pw, name, email, 3));
		if( b ) {
			JOptionPane.showMessageDialog(null, "회원가입 성공");
			login();	//로그인뷰를 가진 메소드로 이동
		}else {
			JOptionPane.showMessageDialog(null, "회원가입 실패");
			regi();		//회원가입뷰를 가진 메소드로 이동
		}
	}
	
	//BBS 관련 메소드	
	//view_board에 게시글 리스트를 리턴
	public List<DTOBbs> getBbsList(){	
		return bbsService.getBbsList();
	}
	
	//view_board에 검색조건에 맞는 게시글 리스트를 리턴
	public List<DTOBbs> getBbsList(String txt, int choice){	
		return bbsService.getBbsList(txt, choice);
	}
	
	//view_board에서 테이블 클릭시 선택된 글 상세정보 뷰로 이동 및 조회수 ++
	public void boardPost(int sequence) {
		DTOBbs dto = bbsService.selectContent(sequence);
		new View_SelectedPost(dto);
		bbsService.updateReadCount(sequence);
	}
	
	//view_board에서 write버튼 클릭 시 새 글 작성 뷰 생성
	public void writeNewPost() {
		new View_NewPost();
	}
	
	//view_NewPost에서 저장 버튼 클릭 시 새 글 저장
	public void insertNewWrite(DTOBbs dto) {
		bbsService.insertNewWrite(dto);
	}
	
	//view_SelectedPost에서 수정 버튼 클릭 시 view_edit생성
	public void editContect(DTOBbs dto) {
		new View_Edit(dto);
	}
	
	//view_SelectedPost에서 삭제 버튼 클릭 시 view_edit생성
	public boolean deleteContect(DTOBbs dto) {
		return bbsService.deleteContent(dto);
	}	
	
	//View_Edit에서 저장 버튼 클릭 시 DB에 수정한 내용 저장 
	public boolean updateContent(DTOBbs dto) {
		return bbsService.updateContent(dto);
	}

}
