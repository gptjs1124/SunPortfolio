package sun.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sun.spring.controller.ContactController;
import sun.spring.dao.AdminDAO;
import sun.spring.dao.ContactDAO;
import sun.spring.dto.CodeGroup;
import sun.spring.dto.ContactDTO;
import sun.spring.dto.FileDTO;

@Service
public class ContactService {
	
	@Autowired
	ContactDAO cdao = new ContactDAO();

	@Autowired
	AdminDAO adao = new AdminDAO();

	@Autowired
	ContactController ccont = new ContactController();
	
	@Transactional("txManager")
	public int conInsert(ContactDTO conDTO, FileDTO fDTO, String[] categoryArr) throws Exception{
		conDTO.setFilename(fDTO.getSysname());
		conDTO.setContact("접수");	
				
		//insert 진행
		int seqKey = cdao.conInsert(conDTO);
		System.out.println(conDTO.getSeq());

		/* 카테고리 insert 진행 */
		//자료형 List로 변경
		List<CodeGroup> listCodeGroup = new ArrayList<CodeGroup>();
		for( int i = 0; i < categoryArr.length; i++){
			CodeGroup codeGroup = new CodeGroup();
			String cmns_cd = categoryArr[i];
			codeGroup.setCmns_cd(cmns_cd);
			codeGroup.setSeq(seqKey); //insert한 key값 가져오기
			listCodeGroup.add(codeGroup);
		}

		int insertResult = 0;
		for( CodeGroup codeGroup : listCodeGroup){
			int cunt = 0;
			CodeGroup selectMenu = adao.insertWithCodeSelect(codeGroup);
			selectMenu.setSeq(seqKey);
			cunt = adao.insertChooseMenu(selectMenu);
			if(cunt > 0){
				insertResult++;
			}
		}

		if(insertResult != listCodeGroup.size()){
			throw new Exception("저장할때 애러가 발생했습니다.");
		}
		
		//첨부파일 오라클DB 저장		
		int numFile = cdao.conFileInsert(fDTO);
		
		if(seqKey > 0 && numFile == 1 && categoryArr.length == insertResult) {
			System.out.println("성공");
		}else {
			System.out.println("실패");
		}
		
		return seqKey;
	}
	
	/*게시판 네비게이션*/
	/* 총 게시물 갯수 */
	public List<ContactDTO> allBoardCount() throws Exception{
		int listCnt = cdao.allBoardCount();
		return cdao.conselect();
	}
	
	/* 게시물 10개씩 출력 */
	public List<ContactDTO> count10(int cpage) throws Exception{
		int innerBoradCount = 30; // 한 페이징 안에 들어가는 게시글 갯수 10
		int start = 0; //시작 값
		int end = 0;//마지막 값
		
		//총 게시물 갯수
		int allCount = cdao.allBoardCount();

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
			sd.append("<a href = '/sub/contact/listProc?cpage="+(startNav-1)+"'> < </a>");
		}
		for (int i = startNav; i <= endNav; i++) {
			sd.append("<a href = '/sub/contact/listProc?cpage="+i+"'>"+i+"</a>");
			if(endNav > totalpage) {
				break;
			}
		}
		if(endNav <= totalpage) {
			sd.append("<a href = '/sub/contact/listProc?cpage="+(endNav+1)+"'> > </a>");
		}
		
		return cdao.boardCount10(start, end, sd);
	}
		
	public ContactDTO conView(ContactDTO conDTO) throws Exception{
		return cdao.conView(conDTO);
	}
	
	public int conDelete(ContactDTO conDTO) throws Exception{
		return cdao.conDelete(conDTO);
	}
	
	public int conModify(ContactDTO conDTO) throws Exception{
		return cdao.conModify(conDTO);
	}
	
	public int mathRandom() throws Exception{
		// 랜덤함수로 간단하게 작업해보자
		// 10개 중에서 5개를 랜덤으로 뽑는로직 중복 허용 안됨.
		List<ContactDTO> mr = cdao.mathRandom();
		List<ContactDTO> ckSame = new ArrayList<ContactDTO>();

		for(int i = 0; i<5; i++) {
			int intValue = (int)(Math.random()*10)+1; // 1부터 10까지 조회
			ckSame.add(i, mr.get(intValue-1));
			
			for(int j = 0; j<i; j++) {
				if(ckSame.get(i) == ckSame.get(j)) {
					ckSame.remove(i);
					i--;
					break;
				}
				
				for(ContactDTO a : ckSame) {
					System.out.println(a.getSeq());
				}
			}
			
			if(ckSame.size() >= 5) {
				break;
			}
		}
		for(ContactDTO a : ckSame) {
			System.out.println(a.getSeq());
		}
		
		ckSame.removeAll(ckSame);
		return 1;
	}

}
