package coffeeOrder_3_Service;

import java.util.Map;

import coffeeOrder_6_DTO.DTOCfMem;

public interface MemService {
	public Map<String, DTOCfMem> getMembersFromDB() ;
	
	public boolean regNewMember(DTOCfMem dto);
	
	public boolean idChk(String id);
	
	public String[] chcAccount(String id);
}
