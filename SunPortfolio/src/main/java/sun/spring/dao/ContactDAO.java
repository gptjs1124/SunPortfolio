package sun.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sun.spring.dto.CodeGroup;
import sun.spring.dto.ContactDTO;
import sun.spring.dto.FileDTO;

@Repository
public class ContactDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int conInsert(ContactDTO conDTO) throws Exception{
		mybatis.insert("contact.insert",conDTO);
		return conDTO.getSeq(); //채번된 seq
	}
	
	public List<ContactDTO> conselect() throws Exception{
		return mybatis.selectList("contact.select");
	}
	
	/* 총 게시글 카운트 */
	public int allBoardCount() throws Exception{
		return mybatis.selectOne("contact.allBoardCount");
	}
	
	/* 게시물 10개씩 출력 */
	public List<ContactDTO> count10() throws Exception{
//		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
//		map.put(start, start);
//		map.put(end, end);
		return mybatis.selectList("contact.count10");
	}
	
	/* 게시물 10개씩 출력 */
	public List<ContactDTO> boardCount10(int start, int end, StringBuilder sd) throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		List<ContactDTO> result = mybatis.selectList("contact.boardCount10", map);
		if(!result.isEmpty()) {
			result.get(0).setSb(sd);
		}
		return result;
	}
	
	public ContactDTO conView(ContactDTO conDTO) throws Exception{
		return mybatis.selectOne("contact.conview", conDTO);
	}
	
	public int conDelete(ContactDTO conDTO) throws Exception{
		return mybatis.delete("contact.delete", conDTO);
	}
	
	public int conModify(ContactDTO conDTO) throws Exception{
		return mybatis.update("contact.modify", conDTO);
	}
	
	/**/
	public List<ContactDTO> mathRandom() throws Exception{
		return mybatis.selectList("contact.mathRandom");
	}
	
	public int conFileInsert(FileDTO fDTO) throws Exception{
		return mybatis.insert("contact.insert_File", fDTO);
	}

	public int stepInsert(CodeGroup codegroup) throws Exception {
		return mybatis.insert("contact.stepInsert", codegroup);
	}
	
}
