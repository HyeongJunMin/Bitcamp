package coffeeOrder_2_Controller;

import java.util.Map;

import coffeeOrder_3_Service.*;
import coffeeOrder_6_DTO.*;
import coffeeOrder_7_View.*;
import coffeeOrder_8_Singleton.Singleton;

public class CoffeeOrderController {
	
	public MemService memSer = new MemServiceImpl();
	public MenuService menuSer = new MenuServiceImpl();
	public LogService logSer = new LogServiceImpl();
		
	//로그인 뷰 생성
	public void login() {
		new View1Login();
	}
	
	//로그인뷰에서 DB의 멤버정보를 받아오는 메소드
	public Map<String, DTOCfMem> getMembersFromDB() {
		return memSer.getMembersFromDB();		
	}
	
	//View1Login에서 입력한 ID정보를 DB에서 가져와 {id, pw} 배열로 리턴
	public String[] chcAccount(String id) {
		return memSer.chcAccount(id);
	}
	
	//회원가입 뷰 생성 View1Login -> View2Signin
	public void signin() {
		new View2Signin();
	}
	
	//View2Signin에서 작성한 DTO를 DB에 추가(INSERT)
	public boolean regNewMember(DTOCfMem dto) {
		return memSer.regNewMember(dto);
	}
	
	//View2Signin에서 입력한 ID 중복검사
	public boolean idChk(String id) {
		return memSer.idChk(id);
	}
	
	//View3MenuSelect 생성
	public void showMenuView() {
		new View3MenuSelect();
	}
	
	//View3MenuSelect에서 메뉴 Combobox에 등록하기 위해 COFFEE_MENU DB에서 값 받아옴
	public Map<Integer, DTOCfMenu> getMemu(){
		return menuSer.getMemu();
	}
	
	//View3MenuSelect에서 메뉴보기 버튼을 클릭하면 View4ShowMenu 생성
	public void showAllMenu() {
		new View4ShowMenu();
	}
	
	//View3MenuSelect에서 주문 버튼을 클릭하면 주문내용이 Map에 담기고 View5ShowOrderList 생성
	public void showOrderList(DTOOrderedMenu dto) {
		Singleton.getInstance().orderBucket.add(dto);
		new View5ShowOrderList();
	}
	
	//메뉴이름과 사이즈에 맞는 가격 리턴
	public int menuPrice(String menuName, String size) {
		return menuSer.menuPrice(menuName, size);
	}
	
	//View5ShowOrderList에서 초기화 버튼을 클릭하면 싱글턴이 갖고있던 내용을 모두 초기화
	public void flushBucket() {
		Singleton.getInstance().orderBucket.clear();
	}
	
	//View5ShowOrderList에서 주문 버튼을 클릭하면 추가된 모든 메뉴를 ORDER_LOG DB에 저장
	public boolean order() {
		return logSer.order();
	}

}
