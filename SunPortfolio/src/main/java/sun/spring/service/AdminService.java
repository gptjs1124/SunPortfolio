package sun.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import org.springframework.transaction.annotation.Transactional;
import sun.spring.controller.Configuration;
import sun.spring.dao.AdminDAO;
import sun.spring.dto.*;


@Service
public class AdminService {
	
	@Autowired
	AdminDAO adao = new AdminDAO();
	
	/*게시판 네비게이션*/
	/* 총 게시물 갯수 */
	public int boardCount(CodeGroup codeGroup) throws Exception{
		return adao.allBoardCount(codeGroup);
	}

	/* List & Navi bar */
	public String getPageNavi(int cpage, CodeGroup codeGroup) throws Exception{
		int pageTotalCount = 0; // 네비게이션 페이지 갯수

		//전체 count
		int allCount = boardCount(codeGroup);

		//페이지 갯수 계산하기
		if(allCount % Configuration.RECORD_COUNT_PER_PAGE > 0){
			pageTotalCount = allCount / Configuration.RECORD_COUNT_PER_PAGE + 1;
		}else{
			pageTotalCount = allCount / Configuration.RECORD_COUNT_PER_PAGE;
		}

		//페이지 별 게시글 start와 end값 지정
		if(cpage < 1) { // cpage가 0 이하일 경우 해커를 방지
			cpage = 1;
		}else if(cpage > allCount){
			cpage = pageTotalCount;
		}
		
		//하단 네비게이션 < > 기준점
		int startNav = (cpage - 1) / Configuration.NAVI_COUNT_PER_PAGE * Configuration.NAVI_COUNT_PER_PAGE + 1; // <
		int endNav = startNav + Configuration.NAVI_COUNT_PER_PAGE - 1; // >
		if(endNav > pageTotalCount) {endNav = pageTotalCount;} //마지막 페이지 설정

		boolean needPrev = true;
		boolean needNext = true;

		if(startNav == 1) {needPrev = false;}
		if(endNav == pageTotalCount) {needNext = false;}
		
		//페이지 네비게이션
		StringBuilder sb = new StringBuilder();

		sb.append("<ul>");

		String needPrevLink = "";
		String needNextLink = "";
		String link_On = "";
		String link = "";
		if(codeGroup.getCmns_cd_nm() == null){
			needPrevLink = "<li><a href ='/admin/ContactListProc?cpage="+(startNav-1)+"'> < </a></li>";
			needNextLink = "<li><a href = '/admin/ContactListProc?cpage="+(endNav+1)+"'> > </a></li>";

			for (int i = startNav; i <= endNav; i++) {
				if(cpage == i) {
					link_On = "<li class='on'><a href='/admin/ContactListProc?cpage="+i+"'>"+i+"</a></li>";
				}else{
					link = "<li><a href='/admin/ContactListProc?cpage="+i+"'>"+i+"</a></li>";
				}
			}
		}else{
			needPrevLink = "<li><a href ='/admin/ContactListProc?cpage="+(startNav-1)+"&cmns_cd_nm="+codeGroup.getCmns_cd_nm()+"'> < </a></li>";
			needNextLink = "<li><a href = '/admin/ContactListProc?cpage="+(endNav+1)+"&cmns_cd_nm="+codeGroup.getCmns_cd_nm()+"'> > </a></li>";

			for (int i = startNav; i <= endNav; i++) {
				if(cpage == i) {
					link_On = "<li class='on'><a href='/admin/ContactListProc?cpage="+i+"&cmns_cd_nm="+codeGroup.getCmns_cd_nm()+"'>"+i+"</a></li>";
				}else{
					link = "<li><a href='/admin/ContactListProc?cpage="+i+"&cmns_cd_nm="+codeGroup.getCmns_cd_nm()+"'>"+i+"</a></li>";
				}
			}
		}

		if(needPrev) {
			sb.append(needPrevLink);
		}
		for (int i = startNav; i <= endNav; i++) {
			if(cpage == i) {
				sb.append(link_On);
			}else{
				sb.append(link);
			}
		}
		if(needNext) {
			sb.append(needNextLink);
		}
		sb.append("</ul>");
		
		return sb.toString();
	}

	/* 게시물 10개씩 출력 */
	public List<ContactDTO> count10(int cpage, CodeGroup codeGroup, ContactDTO contactDTO) throws Exception{
		int start = cpage * Configuration.RECORD_COUNT_PER_PAGE - (Configuration.RECORD_COUNT_PER_PAGE - 1); //시작 값
		int end = start + (Configuration.RECORD_COUNT_PER_PAGE - 1); //마지막 값
		String cmnsCdNm = codeGroup.getCmns_cd_nm();

		return adao.count10(start, end, cmnsCdNm, contactDTO);
	}
	
	/**/
	public ContactDTO conView(ContactDTO cdto) throws Exception{
		return adao.conView(cdto);
	}
	
	/* admin Member Select */
	public AdminDTO adminMember(AdminDTO adto) throws Exception{
		return adao.adminMember(adto);
	}
	
	/* ip ck*/
	public int adminIpCk(AdminIpCkDTO aIpCkdto) throws Exception{
		return adao.adminIpCk(aIpCkdto);
	}
	
	/* ip ck visite update*/
	public int updateAdminIpCk(AdminIpCkDTO aIpCkdto) throws Exception{
		return adao.updateAdminIpCk(aIpCkdto);
	}
	
	/* ip is exist ck*/
	public int selectIpExistCk(AdminIpCkDTO aIpCkdto) throws Exception{
		return adao.selectIpExistCk(aIpCkdto);
	}
	
	/* How many people came in today?*/
	public int selectTodayTotalCut() throws Exception{
		return adao.selectTodayTotalCut();
	}
	
	/* How many people came in Yesterday?*/
	public Integer selectYesterDayTotalCut() throws Exception{
		return adao.selectYesterDayTotalCut();
	}
	
	/* Total Visitors */
	public int selectTotalV() throws Exception{
		return adao.selectTotalV();
	}
	
	public int receiptUpdate(ContactDTO con) throws Exception{
		return adao.receiptUpdate(con);
	}
	
	/*commentInsert*/
	public int commentInsert(CommentDTO commentDTO) throws Exception{
		return adao.commentInsert(commentDTO);
	}
	
	/*commentSelect*/
	public List<CommentDTO> commentSelect(CommentDTO commentDTO) throws Exception{
		return adao.commentSelect(commentDTO);
	}
	
	/*commentDelete*/
	public int commentDelete(CommentDTO commentDTO) throws Exception{
		return adao.commentDelete(commentDTO);
	}
	
	/*commentUpdate*/
	public int commentUpdate(CommentDTO commentDTO) throws Exception{
		return adao.commentUpdate(commentDTO);
	}

	public List<CodeGroup> codeGroupSelect(CodeGroup codeGroup) throws Exception{
		List<CodeGroup> codeGroupSelectData = adao.codeGroupSelect(codeGroup);
		return codeGroupSelectData;
	}

	public List<CodeGroup> codeSelect(CodeGroup codeGroup) throws Exception{
		List<CodeGroup> codeSelect = adao.codeSelect(codeGroup);
		return codeSelect;
	}

	public List<CodeGroup> getChooseMenu(ContactDTO cdto) throws Exception{
		return adao.getChooseMenu(cdto);
	}

	public int deleteChooseMenu(CodeGroup codeGroup) throws Exception{
		return  adao.deleteChooseMenu(codeGroup);
	}

	//@Transactional
	@Transactional("txManager")
	public List<CodeGroup> deleteInsertChooseMenu(List<CodeGroup> codeGroupList) throws Exception{
		//seq 기준 삭제
		int updateResult = 0;
		for( CodeGroup codeGroup : codeGroupList){
			updateResult = adao.deleteAllMenu(codeGroup);
			break; //한번만 삭제하면 해당 seq는 전부 삭제
		}

		List<CodeGroup> insertMenu = new ArrayList<CodeGroup>();
		int insertResult = 0;
		int seq = 0;
		for( CodeGroup codeGroup : codeGroupList){
			int cunt = 0;
			seq = codeGroup.getSeq();
			//if(updateResult > 0){
				CodeGroup selectMenu = adao.insertWithCodeSelect(codeGroup);
				selectMenu.setSeq(seq);
				cunt = adao.insertChooseMenu(selectMenu);
				if(cunt > 0){
					insertResult++;
				}

			//}
		}
		if(insertResult > insertMenu.size()-1){
			ContactDTO cdto = new ContactDTO();
			cdto.setSeq(seq);
			insertMenu = adao.getChooseMenu(cdto);
		}else{
			throw new Exception("insert 갯수가 안맞아");
		}

		return insertMenu;
	}

	public List<CodeGroup> commonCodeSelect(CodeGroup codeGroup) throws Exception{
		return adao.commonCodeSelect(codeGroup);
	}

	/**/
	public int updateStep(CodeGroup codeGroup) throws Exception{
		CodeGroup codeGroup2 = adao.commonCodeNmSelect(codeGroup);
		codeGroup.setCmns_cd(codeGroup2.getCmns_cd());
		codeGroup.setCmns_cd_nm(codeGroup2.getCmns_cd_nm());
		codeGroup.setLast_mdfr_id("admin");
		codeGroup.setCmns_cd_group_id(codeGroup2.getCmns_cd_group_id());
		codeGroup.setUp_cmns_cd(codeGroup2.getUp_cmns_cd());
		codeGroup.setUp_cmns_cd_group_id(codeGroup2.getUp_cmns_cd_group_id());
		adao.updateStep(codeGroup);

		return 0;
	}

}
