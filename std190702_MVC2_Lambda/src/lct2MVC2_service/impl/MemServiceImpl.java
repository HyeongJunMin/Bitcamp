package lct2MVC2_service.impl;

import java.util.List;
import java.util.Map;

import lct2MVC2_DAO.MemberDAO;
import lct2MVC2_DAO.impl.MemberDAOImpl;
import lct2MVC2_model.DTOMem;
import lct2MVC2_service.MemService;

public class MemServiceImpl implements MemService {
	//Service가 DAO를 생성해줌
	public MemberDAO dao = null;
	
	public MemServiceImpl(){
		dao = new MemberDAOImpl();
	}
	
	@Override
	public boolean isAdmin(String id) {
		// TODO Auto-generated method stub
		return dao.isAdmin(id);
	}

	@Override
	public boolean addMem(DTOMem dtoMem) {
		// TODO Auto-generated method stub
		return dao.addMem(dtoMem);
	}

	@Override
	public boolean getId(String id) {
		// TODO Auto-generated method stub
		return dao.getId(id);
	}

	@Override
	public boolean getPw(String pw) {
		// TODO Auto-generated method stub
		return dao.getPw(pw);
	}	
	
	@Override
	public void syncDBToMap() {
		// TODO Auto-generated method stub
		dao.syncDBToMap();
	}
	
	@Override
	public boolean alterAuth(String id) {
		// TODO Auto-generated method stub
		return dao.alterAuth(id);
	}
	
	@Override
	public Map<String, DTOMem> getMap() {
		// TODO Auto-generated method stub
		return dao.getMap();
	}
	
	@Override
	public boolean updateMember(DTOMem dto) {
		// TODO Auto-generated method stub
		return dao.updateMember(dto);
	}
	
	@Override
	public boolean deleteMembers(List<String> ids) {
		// TODO Auto-generated method stub
		return dao.deleteMembers(ids);
	}
}
