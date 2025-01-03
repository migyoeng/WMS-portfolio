package test;

import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class office_service_imp implements office_service {
	
	@Autowired
	office_mapper om;
	
	
	//지점 삭제
	@Override
	public int delete_office(String oidx) {
		int result = om.delete_office(oidx);
		return result;
	}
	
	//검색한 지점 목록 조회
	@Override
	public List<office_DTO> search_office(String search) {
		List<office_DTO> result = om.search_office(search);
		return result;
	}
	
	//지점 현황 전체 목록 조회
	@Override
	public List<office_DTO> office_list() {
		List<office_DTO> all = om.office_list();
		return all;
	}
}
