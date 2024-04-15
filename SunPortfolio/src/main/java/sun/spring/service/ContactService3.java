//package sun.spring.service;
//
//import java.math.BigDecimal;
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import sun.spring.dao.ContactDAO;
//import sun.spring.dto.ContactDTO;
//
//@Service
//public class ContactService3 {
//	
//	@Autowired
//	ContactDAO cdao = new ContactDAO();
//	
//	public int conInsert(ContactDTO conDTO) throws Exception{
//		int num = cdao.conInsert(conDTO);
//		if(num == 1) {
//			System.out.println("성공");
//		}else {
//			System.out.println("실패");
//		}
//		return num;
//	}
//	
//	/*게시판 네비게이션*/
//	/* 총 게시물 갯수 */
//	public List<ContactDTO> allBoardCount() throws Exception{
//		int listCnt = cdao.allBoardCount();
//		return cdao.conselect();
//	}
//	
//	/* 게시물 10개씩 출력 */
//	public List<ContactDTO> count10(int cpage) throws Exception{
//		int innerBoradCount = 10; // 한 페이징 안에 들어가는 게시글 갯수
//		int start = 0; //시작 값
//		int end = 0;//마지막 값
//		
//		//총 게시물 갯수
//		int allCount = cdao.allBoardCount();
//
//		//페이지 별 게시글 start와 end값 지정
//		if(cpage == 1) {
//			start = 1;
//			end = innerBoradCount;
//		} else {
//			start = innerBoradCount * (cpage - 1) + 1;
//			end	= cpage * innerBoradCount; 
//		}
//		
//		//cpage(몇번 페이지인지가 기준으로)를 기준으로 데이터베이스에서 게시글을 몇번부터 몇번까지 불러올지 정하기
////		if(cpage == 1) {
////			start = cpage;
////			end = cpage + (innerBoradCount-1);
////		}else {
//			// cpage = 3
////			start = ((cpage-1)*innerBoradCount)+1; 21
////			end = start +(innerBoradCount-1); 30
////		}
//		
//		//하단 네비게이션이 (cpage)가 몇개 나올지 구함
//		int totalPage = ( allCount / innerBoradCount );
//		totalPage = ( allCount % innerBoradCount ) > 0 ? totalPage + 1 : totalPage; 
//				
//		//페이지 네비게이션
//		String prev = "<";
//		String next = ">";
//		
//		ArrayList<Integer> pageNav = new ArrayList<Integer>();
//		for (int i = 1; i <= totalPage; i++) {
//			System.out.print(" " + i + " ");
//			pageNav.add(i);
//		}
//		
//		return cdao.boardCount10(start, end, pageNav);
//	}
//		
//	public ContactDTO conView(ContactDTO conDTO) throws Exception{
//		return cdao.conView(conDTO);
//	}
//	
//	public int conDelete(ContactDTO conDTO) throws Exception{
//		return cdao.conDelete(conDTO);
//	}
//	
//	public int conModify(ContactDTO conDTO) throws Exception{
//		return cdao.conModify(conDTO);
//	}
//}
