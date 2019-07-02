package lct2MVC2_DAO;

import java.util.List;
import java.util.Map;

import lct2MVC2_model.DTOMem;

public interface MemberDAO {
	
	public boolean isAdmin(String id);
	
	public boolean addMem(DTOMem dto);
	
	public boolean getId(String id);
	
	public boolean getPw(String pw);
	
	public boolean syncDBToMap();	
	
	public boolean alterAuth(String id);
	
	public Map<String, DTOMem> getMap();
	
	public boolean updateMember(DTOMem dto);
	
	public boolean deleteMembers(List<String> ids);
}
