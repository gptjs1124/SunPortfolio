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
//public class ContactService2 {
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
//		int innerBoradCount = 7; // 한 페이징 안에 들어가는 게시글 갯수
//		//int cpage = conDTO.getCpage(); //count10여기에 인자값으로 넣어줄 것
//		int start = 0; //시작 값
//		int end = 0;//마지막 값
//		
//		//총 게시물 갯수
//		int allCount = cdao.allBoardCount();
//		
//		//총 게시물 기준 페이징이 몇개 나오는지?
////		BigDecimal d1 = new BigDecimal(allCount);
////		BigDecimal d2 = new BigDecimal(innerBoradCount);
////		BigDecimal divide = d1.divide(d2);
////		double double_digDecimal = divide.doubleValue();
////		int pagePostNum = (int)(Math.ceil(double_digDecimal));
////		System.out.println(pagePostNum + "  총 게시물 기준 페이징이 몇개 나오는지?");
//		
////		1 페이지 -> 1~innerBoradCount
////		2 페이지 -> 21~40
////		3 페이지 -> 41~60
//		if(cpage == 1) {
//			start = 1;
//			end = innerBoradCount;
//		} else {
//			start = innerBoradCount * (cpage - 1) + 1;
//			end	= cpage * innerBoradCount;
//		}
//		//cpage(몇번 페이지인지가 기준으로)를 기준으로 데이터베이스에서 게시글을 몇번부터 몇번까지 불러올지 정하기
////		if(cpage == 1) {
////			start = cpage;
////			end = cpage + (innerBoradCount-1);
////		}else {
////			start = ((cpage-1)*innerBoradCount)+1;
////			end = start +(innerBoradCount-1);
////		}
//		
//		int totalPage = ( allCount / innerBoradCount );
//		totalPage = ( allCount % innerBoradCount ) > 0 ? totalPage + 1 : totalPage; 
//				
//		//페이지 네비게이션
//		/* 1. 게시글이 100개면 <와 >는 노출되면 안된다.
//		 * 2. 게시글이 10개면 페이지 네비게이션은 1만 나와야 된다.
//		 * 3. cpage가 11이면 하단 네비게이션은 11~21이 노출되야 한다.
//		 * 4. 일단 stringBuilder를 노출 시키자
//		 */
//		StringBuilder sb = new StringBuilder();
//		String prev = "<";
//		String next = ">";
//		
//		ArrayList<Integer> pageNav = new ArrayList<Integer>();
//		sb.append(prev);
//		System.out.print("< ");
//		for (int i = 1; i <= totalPage; i++) {
//			sb.append("<li><a href ='/sub/contact/listProc?cpage=1'>"+i+"</a></li>");
//			System.out.print(" " + i + " ");
//			pageNav.add(i);
//		}
//		System.out.print("> [ "+ start + " ~ " + end + " ]");
//		sb.append(next);
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
