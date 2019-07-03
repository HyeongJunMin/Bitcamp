package coffeeOrder_4_DAO;

import java.util.Map;

import coffeeOrder_6_DTO.DTOCfMem;

public interface MemDAO {
	public Map<String, DTOCfMem> getMembersFromDB() ;
	
	public boolean syncDBToMap();
	
	public boolean regNewMember(DTOCfMem dto);
	
	public boolean idChk(String id);
	
	public String[] chcAccount(String id);
}
