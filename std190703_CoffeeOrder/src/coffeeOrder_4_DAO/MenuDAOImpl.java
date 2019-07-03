package coffeeOrder_4_DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import coffeeOrder_5_DB.DBConnection;
import coffeeOrder_6_DTO.DTOCfMem;
import coffeeOrder_6_DTO.DTOCfMenu;

public class MenuDAOImpl implements MenuDAO {

	public Map<Integer, DTOCfMenu> hmMenu = null;
	public static Connection memCon = null;
	public static DBConnection d = null;

	public MenuDAOImpl() {
//		memCon = d.getConnection();
	}

	@Override
	public Map<Integer, DTOCfMenu> getMemu() {
		// TODO Auto-generated method stub
		this.syncDBToMap();
		return this.hmMenu;
	}

	// COFFEE_MEM DB의 값을 가져와서 Map에 저장하는 메소드
	@Override
	public boolean syncDBToMap() {
		// TODO Auto-generated method stub
		boolean complete = false;

		hmMenu = new HashMap<Integer, DTOCfMenu>();

		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM COFFEE_MENU ";

		int seq;
		String name;
		String priceShort;
		String priceTall;
		String priceGrande;

		try {
			stmt = DBConnection.getConnection().createStatement();
			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				seq = rs.getInt(1);
				name = rs.getString(2);
				priceShort = rs.getString(3);
				priceTall = rs.getString(4);
				priceGrande = rs.getString(5);
				
				hmMenu.put(seq, new DTOCfMenu(seq, name, priceShort, priceTall, priceGrande));
			}
				complete = true;
//				System.out.println("DAO Map bring data from DB.");
		} catch (SQLException e) {
			System.out.println("DB Connection Fail(Sync DB To Map)");
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return complete;
	}

	@Override
	public int menuPrice(String menuName, String size) {
		// TODO Auto-generated method stub
		int result = -1;
		
		String price = null;
		
		switch(size) {
			case "Short" : price = "PRICE_SHORT"; break;
			case "Tall" : price = "PRICE_TALL"; break;
			case "Grande" : price = "PRICE_GRANDE"; break;
			default : break;
		}

		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT " + price + "  FROM COFFEE_MENU WHERE NAME = '" + menuName + "' ";

		try {
			stmt = DBConnection.getConnection().createStatement();
			rs = stmt.executeQuery(sql);
			
			rs.next();
			
			result = rs.getInt(1);

		} catch (SQLException e) {
			System.out.println("DB Connection Fail(MenuDAOImple.menuPrice())");
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}
