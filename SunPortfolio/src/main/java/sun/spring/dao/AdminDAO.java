package sun.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import sun.spring.dto.*;

@Repository
public class AdminDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
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
	public List<ContactDTO> boardCount10(int start, int end, StringBuilder sd, String contact) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("start", start);
		map.put("end", end);
		map.put("contact", contact);
		List<ContactDTO> result = mybatis.selectList("admin.boardCount10", map);
		if(!result.isEmpty()) {
			result.get(0).setSb(sd);
		}
		return result;
	}
	
	/**/
	public ContactDTO conView(ContactDTO cdto) throws Exception{
		System.out.println(cdto.getSeq());
		return mybatis.selectOne("admin.conview", cdto);
	}
	
	/* admin Member Select */
	public AdminDTO adminMember(AdminDTO adto) throws Exception{
		return mybatis.selectOne("admin.selectMember", adto);
	}
	
	/* ip ck*/
	public int adminIpCk(AdminIpCkDTO aIpCkdto) throws Exception{
		return mybatis.insert("admin.insertAdminIpCk", aIpCkdto);
	}
	
	/* ip ck visite update*/
	public int updateAdminIpCk(AdminIpCkDTO aIpCkdto) throws Exception{
		return mybatis.update("admin.updateAdminIpCk", aIpCkdto);
	}
	
	/* ip is exist ck*/
	public int selectIpExistCk(AdminIpCkDTO aIpCkdto) throws Exception{
		int result = mybatis.selectOne("admin.selectIpExistCk", aIpCkdto);
		return result;
	}
	
	/* How many people came in today?*/
	public int selectTodayTotalCut() throws Exception{
		return mybatis.selectOne("admin.selectTodayTotalCut");
	}
	
	/* How many people came in Yesterday?*/
	public Integer selectYesterDayTotalCut() throws Exception{
		Integer count = mybatis.selectOne("admin.selectYesterDayTotalCut");
		if(count == null) {
			count = 0;
		}
		return count;
	}
	
	/* Total Visitors */
	public int selectTotalV() throws Exception{
		return mybatis.selectOne("admin.selectTotalV");
	}
	
	/* 접수 저장 */
	public int receiptUpdate(ContactDTO con) throws Exception{
		return mybatis.update("admin.receiptUpdate", con);
	}
	
	/*commentInsert*/
	public int commentInsert(CommentDTO commentDTO) throws Exception{
		return mybatis.insert("admin.commentInsert", commentDTO);
	}
	
	/*commentSelect*/
	public List<CommentDTO> commentSelect(CommentDTO commentDTO) throws Exception{
		return mybatis.selectList("commentSelect", commentDTO);
	}
	
	/*commentDelete*/
	public int commentDelete(CommentDTO commentDTO) throws Exception{
		return mybatis.delete("commentDelete", commentDTO);
	}
	
	/*commentUpdate*/
	public int commentUpdate(CommentDTO commentDTO) throws Exception{
		return mybatis.delete("commentUpdate", commentDTO);
	}
	
	public int selectBoxVal(ContactDTO con) throws Exception{
		return mybatis.update("contactChange",con);
	}

	public List<CodeGroup> codeGroupSelect(CodeGroup codeGroup) throws Exception{
		return mybatis.selectList("codeGroupSelect", codeGroup);
	}

	/* 공통코드 불러오기 :: 카테고리 메뉴 */
	public List<CodeGroup> codeSelect(CodeGroup codeGroup) throws Exception{
		return mybatis.selectList("codeSelect", codeGroup);
	}

}
