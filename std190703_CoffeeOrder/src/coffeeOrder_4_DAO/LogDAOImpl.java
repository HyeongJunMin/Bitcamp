package coffeeOrder_4_DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import coffeeOrder_5_DB.DBConnection;
import coffeeOrder_6_DTO.DTOCfMenu;
import coffeeOrder_6_DTO.DTOOrderedMenu;
import coffeeOrder_8_Singleton.Singleton;

public class LogDAOImpl implements LogDAO {

	public static Connection memCon = null;
	public static DBConnection d = null;
	

	public LogDAOImpl() {
		memCon = DBConnection.getConnection();
	}
	
	@Override
	public boolean order() {
		// TODO Auto-generated method stub
		boolean complete = false;
		PreparedStatement psmt = null;
		int rs = -1;
		String sql = " INSERT INTO COFFEE_ORDER VALUES(SEQ_COF_ORDER.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE) ";

		try {
			
			Singleton s = Singleton.getInstance();
			System.out.println("????이게안된다고?");
			for(int i = 0 ; i < s.orderBucket.size() ; i++ ) {
				System.out.println("리스트사이즈입니다~~" + s.orderBucket.size());
				psmt = memCon.prepareStatement(sql);
				DTOOrderedMenu dto = s.orderBucket.get(i);
				psmt.setString(1, s.sessionId);
				
				psmt.setString(2, dto.getMenuName());//메뉴이름
				psmt.setString(3, dto.getSize());//사이즈
				psmt.setString(4, dto.getSyrup());//시럽
				psmt.setString(5, dto.getShot());//샷추가
				psmt.setString(6, dto.getWhip());//휘핑추가
				psmt.setInt(7, dto.getAmount());//주문수량
				int amountPrice = 0;
				amountPrice = s.ctrl.menuPrice(dto.getMenuName(), dto.getSize());
				psmt.setInt(8, amountPrice);//총금액
				rs = psmt.executeUpdate();
			}
			
			System.out.println("나는 할일을 다 했다! 인서트는 끝났따!");
						
			
			complete = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				psmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return complete;
	}

	//View6ShowOrderList에 COFFEE_ORDER DB 정보를 List 형태로 전달
	@Override
	public List<DTOOrderedMenu> getOrderLog() {
		// TODO Auto-generated method stub
		
		List<DTOOrderedMenu> lstOrder = new ArrayList<DTOOrderedMenu>();
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM COFFEE_ORDER ";

		try {
			
			int orderNum;
			String customerName;
			String menuName;
			String size;
			String syrup;
			String shot;
			String whip;
			int amount;
			int price = 0;
			String orderDate = "";
			
			Singleton s = Singleton.getInstance();
			
			stmt = memCon.createStatement();
			rs = stmt.executeQuery(sql);
			
			DTOOrderedMenu dto = null;
			
			while( rs.next() ) {
				orderNum = rs.getInt(1);
				customerName = rs.getString(2);
				menuName = rs.getString(3);
				size = rs.getString(4);
				syrup = rs.getString(5);
				shot = rs.getString(6);
				whip = rs.getString(7);
				amount = rs.getInt(8);
				price = (s.ctrl.menuPrice(menuName, size) * amount);
				orderDate = rs.getString(9)+"";
				
				lstOrder.add(new DTOOrderedMenu(orderNum, customerName, menuName, size, syrup, shot, whip, amount, price, orderDate));
			}
						
			
		
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return lstOrder;
	}
	
}
