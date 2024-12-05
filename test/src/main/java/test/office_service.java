package test;

import java.util.List;

public interface office_service {

	public List<office_DTO> office_list();
	public List<office_DTO> search_office(String search);
	public int delete_office(String oidx);
}
