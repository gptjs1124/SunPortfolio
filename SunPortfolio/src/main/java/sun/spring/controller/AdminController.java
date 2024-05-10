package sun.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.spring.dto.AdminDTO;
import sun.spring.dto.CodeGroup;
import sun.spring.dto.CommentDTO;
import sun.spring.dto.ContactDTO;
import sun.spring.service.AdminService;
import sun.spring.service.ContactService;


@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private AdminService aservice;
	
	@Autowired
	private ContactService cservice;
	
	@Autowired
	private HttpSession session;
	
	@RequestMapping("login")
	public String login() {
		return "/admin/login";
	}
	
	@RequestMapping("adminproc")
	public String adminproc(AdminDTO adto, Model model) throws Exception{
		AdminDTO adminDTO = aservice.adminMember(adto);
		if(!StringUtils.isEmpty(adminDTO)) {			
			session.setAttribute("adminLogin",adminDTO);
			return "/admin/index";
		}else {
			model.addAttribute("message","관리자");
			return "/admin/login";
		}		
	}
	
	@RequestMapping("index")
	public String index(Model model) throws Exception{
		int toDayVisitCount = aservice.selectTodayTotalCut();
		Integer yesterdayVCut = aservice.selectYesterDayTotalCut();
		int totalV = aservice.selectTotalV();
		model.addAttribute("todayVCut",toDayVisitCount);
		model.addAttribute("yesterdayVCut",yesterdayVCut);
		model.addAttribute("totalVCut",totalV);
		return "/admin/index";
	}
	
	//admin_contact 페이지 이동
	@RequestMapping("admin_contact")
	public String admin_contact() {
		return "/admin/admin_contact";
	}
	
	//admin_contact 페이지 이동
	@RequestMapping("adminContactListProc")
	public String adminContactListProc(Model model) throws Exception{
		return "/admin/listProc?cpage=1";
	}
	
	/* 접수 :::::::::::::::::::::::::::::::::::::::::::::::::::: */
	@RequestMapping("ContactListProc")
	public String listProc(Model model, int cpage, CodeGroup codeGroup, ContactDTO contactDTO) throws Exception{
		String pageNavi = aservice.getPageNavi(cpage, codeGroup, contactDTO); //page 네비게이션
		model.addAttribute("pageNavi", pageNavi);
		
		List<ContactDTO> count10 = aservice.count10(cpage, codeGroup, contactDTO); //게시글 10개씩 노출
		model.addAttribute("count10", count10); //allBoardCount
		model.addAttribute("codeGroup",codeGroup); //cdto

		//진행단계 조회
		codeGroup.setCmns_cd_group_id("CODE_STEP"); //공동코드
		List<CodeGroup> stepCommenCode = aservice.commonCodeSelect(codeGroup);
		model.addAttribute("stepCommenCode",stepCommenCode);

		return "/admin/contact_list";
	}
	
	//admin_contact 페이지 이동
	@ResponseBody
	@RequestMapping("progressCk")
	public String progressCk() {
		return "/admin/admin_contact";
	}
	
	//admin_view ====================================================================================
	@RequestMapping("viewProc")
	public String viewProc(HttpServletRequest request, Model model) throws Exception{
		String seq = request.getParameter("seq");
		ContactDTO con = new ContactDTO();
		con.setSeq(Integer.parseInt(seq));
		con = aservice.conView(con);

		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setSunportfolioSeq(Integer.parseInt(seq));
		List<CommentDTO> commentList = aservice.commentSelect(commentDTO);

		model.addAttribute("con", con);
		model.addAttribute("commentList", commentList);

		return "/admin/receipt/comment";
	}
	
	//접수 view 페이지
	@RequestMapping("receiptProc")
	public String receiptProc(HttpServletRequest request, Model model) throws Exception{
		String seq = request.getParameter("seq");
		ContactDTO con = new ContactDTO();
		con.setSeq(Integer.parseInt(seq));
		con = aservice.conView(con);

		List<CodeGroup> chooseMenuList = aservice.getChooseMenu(con);

		model.addAttribute("con", con);
		model.addAttribute("chooseMenuList", chooseMenuList);

		return "/admin/receipt/receiptProc";
	}

	@ResponseBody
	@RequestMapping("codeGroupSelect")
	public List<CodeGroup> codeGroupSelect(HttpServletRequest request, Model model) throws Exception{
		CodeGroup codeGroup = new CodeGroup();
		String cmnsCdGroupId = request.getParameter("cmns_cd_group_id"); // 프로젝트 < 카테고리
		codeGroup.setCmns_cd_group_id(cmnsCdGroupId);

		return aservice.codeGroupSelect(codeGroup);
	}

	@ResponseBody
	@RequestMapping("codeSelect")
	public List<CodeGroup> codeSelect(HttpServletRequest request, Model model) throws Exception{
		CodeGroup codeGroup = new CodeGroup();
		String cmnsCdGroupId = request.getParameter("cmns_cd_group_id");
		String cmnsCd = request.getParameter("cmns_cd"); // 프로젝트 < 카테고리
		codeGroup.setCmns_cd_group_id(cmnsCdGroupId);
		codeGroup.setCmns_cd(cmnsCd);

		return aservice.codeSelect(codeGroup);
	}
	
	@ResponseBody
	@RequestMapping("receiptSave")
	public String receiptUpdate(HttpServletRequest request, Model model) throws Exception{
		ContactDTO con = new ContactDTO();
		con.setSeq(Integer.parseInt(request.getParameter("seq")));
		con.setCategory(request.getParameter("category"));
		con.setTitle(request.getParameter("title"));
		con.setCompany(request.getParameter("company"));
		con.setGrade(request.getParameter("grade"));
		con.setName(request.getParameter("name"));
		con.setTel(request.getParameter("tel"));
		con.setContent(request.getParameter("content"));

		int result = aservice.receiptUpdate(con);		
		return Integer.toString(result);	
	}
	
	@ResponseBody
	@RequestMapping("commentInsert")
	public String commentInsert(HttpServletRequest request, Model model) throws Exception{
		
		CommentDTO commentDTO = new CommentDTO();
		String sunportfolioSeq = request.getParameter("sunportfolioSeq");
		commentDTO.setSunportfolioSeq(Integer.parseInt(sunportfolioSeq));
		int reuslt = 0;
		try {		
			// 관리자로 로그인 되어 있는지 확인하기
			AdminDTO adminLogin = (AdminDTO)session.getAttribute("adminLogin");
			if(adminLogin.getId().equals("admin")) {
				commentDTO.setName(adminLogin.getId());
			}else {
				commentDTO.setName(request.getParameter("name"));
			}
			commentDTO.setCommentText(request.getParameter("commentText"));
			
			reuslt = aservice.commentInsert(commentDTO);					
		
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		
		return Integer.toString(reuslt);	
	}
	
	@ResponseBody
	@RequestMapping(value="commentDelete", produces="text/plain; charset=UTF-8")
	public String commentDelete(HttpServletRequest request, Model model) throws Exception{
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setSeq(Integer.parseInt(request.getParameter("seq")));
		commentDTO.setSunportfolioSeq(Integer.parseInt(request.getParameter("sunportfolioSeq")));
		int result = aservice.commentDelete(commentDTO);
		
		String message = "";
		if(result > 0) {
			message = "삭제 되었습니다.";
		}else {
			message = "삭제되지 않았습니다.";
		}
		
		return message;
	}
	
	@ResponseBody
	@RequestMapping(value="commentUpdate", produces="text/plain; charset=UTF-8")
	public String commentUpdate(HttpServletRequest request, Model model) throws Exception{
		CommentDTO commentDTO = new CommentDTO();
		commentDTO.setSeq(Integer.parseInt(request.getParameter("seq")));
		commentDTO.setSunportfolioSeq(Integer.parseInt(request.getParameter("sunportfolioSeq")));
		commentDTO.setCommentText(request.getParameter("commentText"));
		int result = aservice.commentUpdate(commentDTO);
		
		String message = "";
		if(result > 0) {
			message = "수정 되었습니다.";
		}else {
			message = "수정되지 않았습니다.";
		}
		
		return message;
	}
	
	@ResponseBody
	@RequestMapping("updateStep")
	public int updateStep(CodeGroup codeGroup) throws Exception{
		int result = aservice.updateStep(codeGroup);
		return 0;
	}

	@ResponseBody
	@RequestMapping("deleteChooseMenu")
	public List<CodeGroup> deleteChooseMenu(CodeGroup codeGroup) throws Exception{
		int result = aservice.deleteChooseMenu(codeGroup);
		List<CodeGroup> chooseMenuList = new ArrayList<CodeGroup>();

		if(result > 0){
			ContactDTO cdto = new ContactDTO();
			cdto.setSeq(codeGroup.getSeq());
			chooseMenuList = aservice.getChooseMenu(cdto);
		}

		return chooseMenuList;
	}

	@ResponseBody
	@RequestMapping("deleteInsertChooseMenu")
	public List<CodeGroup> deleteInsertChooseMenu(@RequestBody HashMap<String, Object> map) throws Exception{

		List<CodeGroup> codeGroupList = new ArrayList<CodeGroup>();
		for(Map.Entry<String, Object> pair : map.entrySet()){
			Map<String, Object> innerMap = (Map<String, Object>)pair.getValue();

			CodeGroup codeGroup = new CodeGroup();
			for(Map.Entry<String, Object> pair2 : innerMap.entrySet()){
				String key = pair2.getKey();

				if (key.equals("seq")) {
					codeGroup.setSeq(Integer.parseInt(pair2.getValue().toString()));
				} else if (key.equals("cmns_cd")) {
					codeGroup.setCmns_cd(pair2.getValue().toString());
				} else {
					System.out.println("값이 없습니다.");
				}
			}
			codeGroupList.add(codeGroup);
		}

		return aservice.deleteInsertChooseMenu(codeGroupList);
	}
}






















