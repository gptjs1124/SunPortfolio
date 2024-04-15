package sun.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sun.spring.dto.ContactDTO;

@Repository
public class ContactDAO2 {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public int conInsert(ContactDTO conDTO) throws Exception{
		return mybatis.insert("contact.insert",conDTO);
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
	public List<ContactDTO> boardCount10(int start, int end, ArrayList<Integer> pageNav) throws Exception{
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("start", start);
		map.put("end", end);
		List<ContactDTO> result = mybatis.selectList("contact.boardCount10", map);
		
		//게시글이 없을 때 아웃오브 바운즈 나온다.
		if ( result.size() > 0 ) {
			/*result.get(0).setPageNav(pageNav);*/
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
	
}
