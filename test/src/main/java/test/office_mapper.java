package test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface office_mapper {

	public List<office_DTO> office_list();
}
