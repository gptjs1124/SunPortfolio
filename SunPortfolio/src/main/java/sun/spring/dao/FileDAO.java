package sun.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sun.spring.dto.ContactDTO;

@Repository
public class FileDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<ContactDTO> conselect() throws Exception{
		return mybatis.selectList("contact.select");
	}
}
