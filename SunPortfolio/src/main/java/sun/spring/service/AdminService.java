package sun.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sun.spring.dao.AdminDAO;
import sun.spring.dto.AdminDTO;
import sun.spring.dto.AdminIpCkDTO;
import sun.spring.dto.CommentDTO;
import sun.spring.dto.ContactDTO;

@Service
public class AdminService {
	
	@Autowired
	AdminDAO adao = new AdminDAO();
	
	/*게시판 네비게이션*/
	/* 총 게시물 갯수 */
	public List<ContactDTO> allBoardCount() throws Exception{
		int listCnt = adao.allBoardCount();
		return adao.conselect();
	}
	
	/* 게시물 10개씩 출력 */
	public List<ContactDTO> count10(int cpage, ContactDTO cdto) throws Exception{
		int innerBoradCount = 10; // 한 페이징 안에 들어가는 게시글 갯수
		int start = 0; //시작 값
		int end = 0;//마지막 값
		String contact = cdto.getContact();
		
		//총 게시물 갯수
		int allCount = adao.allBoardCount();

		//페이지 별 게시글 start와 end값 지정
		if(cpage == 1) {
			start = cpage;
			end = cpage * innerBoradCount;
		}else {
			start = (cpage-1) * innerBoradCount + 1;  //2페이지 11페이지
			end = start + (innerBoradCount-1); //11+10 = 21
		}
		
		//하단 네비게이션이 디비 데이터가 몇개 들어가 있는지.
		int totalpage = allCount / innerBoradCount;
		totalpage = (allCount % innerBoradCount) > 0 ? totalpage+1 : totalpage;
		
		//하단 네비게이션 < > 기준점
		int startNav = (cpage-1) / innerBoradCount * innerBoradCount + 1;
		int endNav = 0;
		//TODO:: 페이징 고장남 .. 확인 부탁
		endNav = startNav + innerBoradCount - 1; // 이게 원본
		
		//페이지 네비게이션
		StringBuilder sd = new StringBuilder();
		if(startNav >= innerBoradCount) {
			sd.append("<a href = '/sub/contact/adminContactListProc?cpage="+(startNav-1)+"'> < </a>");
		}
		for (int i = startNav; i <= endNav; i++) {
			sd.append("<a href = '/sub/contact/adminContactListProc?cpage="+i+"'>"+i+"</a>");
			if(endNav > totalpage) {
				break;
			}
		}
		if(endNav <= totalpage) {
			sd.append("<a href = '/sub/contact/adminContactListProc?cpage="+(endNav+1)+"'> > </a>");
		}
		
		return adao.boardCount10(start, end, sd, contact);
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
	
	/**/
	public int selectBoxVal(ContactDTO con) throws Exception{
		return adao.selectBoxVal(con);
	}
}
