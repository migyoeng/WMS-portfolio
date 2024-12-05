package test;

import org.springframework.stereotype.Repository;

import lombok.Data;

@Data
@Repository("office_DTO")
public class office_DTO {
	int oidx, opost;
	String officename, ohp, omaintel, mname, oemail, oaddress, view;
	
	//검색어
	String search;
}
