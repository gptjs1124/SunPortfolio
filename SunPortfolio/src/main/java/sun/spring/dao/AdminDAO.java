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
	
	/* 총 게시글 카운트 */
	public int allBoardCount(CodeGroup codeGroup, ContactDTO contactDTO) throws Exception{
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("codeGroup", codeGroup);
		map.put("contactDTO", contactDTO);
		return mybatis.selectOne("admin.allBoardCount", map);
	}

	/* 게시물 10개씩 출력 */
	public List<ContactDTO> count10(int start, int end, String cmnsCdNm, ContactDTO contactDTO) throws Exception{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cmns_cd_nm", cmnsCdNm);
		map.put("start", start);
		map.put("end", end);
		map.put("contactDTO", contactDTO);
		return mybatis.selectList("admin.boardCount10", map);
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

	public List<CodeGroup> codeGroupSelect(CodeGroup codeGroup) throws Exception{
		return mybatis.selectList("codeGroupSelect", codeGroup);
	}

	/* 공통코드 불러오기 :: 카테고리 메뉴 */
	public List<CodeGroup> codeSelect(CodeGroup codeGroup) throws Exception{
		return mybatis.selectList("codeSelect", codeGroup);
	}

	public List<CodeGroup> getChooseMenu(ContactDTO cdto) throws Exception{
		return mybatis.selectList("getChooseMenu", cdto);
	}

	public int deleteChooseMenu(CodeGroup codeGroup) throws Exception{
		return mybatis.delete("deleteChooseMenu", codeGroup);
	}

	public int deleteAllMenu(CodeGroup codeGroup) throws Exception{
		return mybatis.delete("deleteAllMenu", codeGroup);
	}

	public int insertChooseMenu(CodeGroup codeGroup) throws Exception{
		return mybatis.insert("insertChooseMenu", codeGroup);
	}

	public CodeGroup insertWithCodeSelect(CodeGroup codeGroup) throws Exception{
		return mybatis.selectOne("insertWithCodeSelect", codeGroup);
	}

	public List<CodeGroup> commonCodeSelect(CodeGroup codeGroup) throws Exception{
		return mybatis.selectList("commonCodeSelect", codeGroup);
	}

	public CodeGroup commonCodeNmSelect(CodeGroup codeGroup) throws Exception{
		return mybatis.selectOne("commonCodeNmSelect", codeGroup);
	}

	public int updateStep(CodeGroup codeGroup) throws Exception{
		return mybatis.update("updateStep",codeGroup);
	}

}
