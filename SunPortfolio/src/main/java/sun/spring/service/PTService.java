package sun.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.spring.dao.PTDAO;
import sun.spring.dto.PTCategoryDTO;

@Service
public class PTService {
	
	@Autowired
	PTDAO ptdao = new PTDAO();
	
	public List<PTCategoryDTO> pt_ctgSelect_DEPTH1() throws Exception{
		return ptdao.pt_ctgSelect_DEPTH1();
	}
	
	public List<PTCategoryDTO> pt_ctgSelect_DEPTH2(PTCategoryDTO ptcon) throws Exception{
		return ptdao.pt_ctgSelect_DEPTH2(ptcon);
	}
}
