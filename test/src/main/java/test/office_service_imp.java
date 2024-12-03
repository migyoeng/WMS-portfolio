package test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class office_service_imp implements office_service {
	
	@Autowired
	office_mapper om;

	@Override
	public List<office_DTO> office_list() {
		List<office_DTO> all = om.office_list();
		return all;
	}
}
