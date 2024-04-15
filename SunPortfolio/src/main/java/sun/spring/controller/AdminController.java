package sun.spring.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.spring.dto.AdminDTO;
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
	public String listProc(Model model, int cpage, ContactDTO cdto) throws Exception{
		// 한 페이지당 10개씩 게시물 보이기
		List<ContactDTO> count10 = aservice.count10(cpage, cdto);
		model.addAttribute("allBoardCount", count10);
		model.addAttribute("cdto",cdto);
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
		
		model.addAttribute("con", con);
		return "/admin/receipt/receiptProc";
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
	@RequestMapping("contactChange")
	public int contactChange(ContactDTO contactDTO) throws Exception{
		//TODO:: 컨트롤러에서 ‘진행’이라는 글자가 맞는지 확인해야된다. 이유는 …. SQL Select만 할 시는 화면에 value값의 값을 가져와도 괜찮은데, update를 수행 시 저 진행이라는 값을 그대로 DB에 넣기 때문에 문제가 발생한다.
		int result = aservice.selectBoxVal(contactDTO);
		return 0;
	}
	
}






















