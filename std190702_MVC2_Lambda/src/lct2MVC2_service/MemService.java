package lct2MVC2_service;

import java.util.List;
import java.util.Map;

import lct2MVC2_model.DTOMem;

public interface MemService {

	public boolean isAdmin(String id);
	
	boolean addMem(DTOMem dtoMem);
	
	boolean getId(String id);

	boolean getPw(String pw);
	
	public void syncDBToMap();
	
	public boolean alterAuth(String id);
	
	public Map<String, DTOMem> getMap();
	
	public boolean updateMember(DTOMem dto);
	
	public boolean deleteMembers(List<String> ids);
}
