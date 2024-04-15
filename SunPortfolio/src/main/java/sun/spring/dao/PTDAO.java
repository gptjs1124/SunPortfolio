package sun.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sun.spring.dto.PTCategoryDTO;

@Repository
public class PTDAO {
	@Autowired
	private SqlSessionTemplate mybatis;

	public List<PTCategoryDTO> pt_ctgSelect_DEPTH1() throws Exception{
		return mybatis.selectList("pt.pt_ctgSelect_DEPTH1");
	}
	
	public List<PTCategoryDTO> pt_ctgSelect_DEPTH2(PTCategoryDTO ptcon) throws Exception{
		return mybatis.selectList("pt.pt_ctgSelect_DEPTH2",ptcon);
	}
}
