package sun.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.spring.dto.CodeGroup;
import sun.spring.dto.ContactDTO;
import sun.spring.dto.FileDTO;
import sun.spring.service.ContactService;

@Controller
@RequestMapping("/sub/contact")
public class ContactController {
	String link = "/sub/contact/";
	
	@Autowired
	private ContactService cservice;
	
	@Autowired
	private HttpSession session;
	
	@Autowired
	private fileController fcon;
	
	@RequestMapping("write")
	public String write() {
		return link+"write";
	}	
	
	@RequestMapping("writeProc")
	public String writeProc(ContactDTO conDTO, FileDTO fDTO, String[] categoryArr, Model model) throws Exception{
		conDTO.setTel(conDTO.getSelTel() +" - "+ conDTO.getPhone01() +" - "+ conDTO.getPhone02());
		conDTO.setTel(conDTO.getSelTel() +" - "+ conDTO.getPhone01() +" - "+ conDTO.getPhone02());
		
		FileDTO ftnDTO = new FileDTO();
		try {	
		//첨부파일 로컬에 저장
		//TODO:: 서버간의 통신으로 이미지가 보이지 않을 것 같은데, 그럼 첨부파일 이미지는 서버로 다운로드 받고 보이게 수정해야됨.
		//TODO:: 엑셀 다운로드 및 엑셀 업로드 작업하기.
		String realPath = session.getServletContext().getRealPath("upload/contact/files/");
		ftnDTO = fcon.fileOneInsert(conDTO, fDTO, realPath);
		
		//오라클 DB에 저장
		int result = cservice.conInsert(conDTO, ftnDTO, categoryArr);
		model.addAttribute("result", result);
		
		}catch(Exception ex) {
			ex.printStackTrace();
			
			//저장된 파일 이 있을 경우 삭제
			File file = new File(ftnDTO.getRealpath());
			if(file.exists()) {
				file.delete();
			}
		}
		
		//return "index"; //화면 jsp로 가는거
		return "redirect:/"; //url을 다시 발송 하는 것
	}

	@RequestMapping("listProc")
	public String listProc(Model model, int cpage) throws Exception{
		
		// 한 페이지당 10개씩 게시물 보이기
		List<ContactDTO> count10 = cservice.count10(cpage);
//		model.addAttribute("allBoardCount", count10);
		
		return link+"list";
	}
	
	@RequestMapping("viewProc")
	public String viewProc(ContactDTO cdto, Model model) throws Exception{
		ContactDTO conview = cservice.conView(cdto);
		model.addAttribute("conview", conview);
		return link+"view";
	}
	
	@RequestMapping("conDelete")
	public String conDelete(ContactDTO cdto) throws Exception{
		int deleteSecces = cservice.conDelete(cdto);
		return "redirect:"+link+"listProc";
	}
	
	@RequestMapping("conModify")
	public String conModify(ContactDTO cdto, Model model) throws Exception{
		model.addAttribute("cdto", cdto);
		return link+"modify";
	}
	
	@RequestMapping("conModifyProc")
	public String conModifyProc(ContactDTO cdto) throws Exception{
		int deleteSecces = cservice.conModify(cdto);
		return "redirect:"+link+"listProc";
	}
	
	@RequestMapping("mathRandom")
	public String mathRandom() throws Exception{
		int result = cservice.mathRandom();
		return "/";
	}
}



























