package sun.spring.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nl.captcha.Captcha;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
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
	public String writeProc(ContactDTO conDTO, String[] categoryArr, Model model) throws Exception{
		conDTO.setTel(conDTO.getSelTel() +" - "+ conDTO.getPhone01() +" - "+ conDTO.getPhone02());
		conDTO.setTel(conDTO.getSelTel() +" - "+ conDTO.getPhone01() +" - "+ conDTO.getPhone02());
		
		FileDTO ftnDTO = new FileDTO();
		try {
			if(conDTO.getFile().getSize() > 0){
				//첨부파일 로컬에 저장
				String realPath = session.getServletContext().getRealPath("upload/contact/files/");
				ftnDTO = fcon.fileOneInsert(conDTO, realPath);

				//오라클 DB에 저장
				int result = cservice.conInsert(conDTO, ftnDTO, categoryArr);
				model.addAttribute("result", result);
			}else{
				//오라클 DB에 저장
				int result = cservice.conInsert(conDTO, ftnDTO, categoryArr);
				model.addAttribute("result", result);
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			model.addAttribute("result", ex.getMessage());
			
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
	
	/******* 자동입력방지 ********/
	// 페이지 매핑
	@GetMapping("/captcha.do")
	public String Captcha() {
		return "captcha";
	}

	// captcha 이미지 가져오는 메서드
	@GetMapping("/captchaImg.do")
	@ResponseBody
	public void captchaImg(HttpServletRequest req, HttpServletResponse res){
		new CaptchaUtil().getImgCaptCha(req, res);
	}

	// 전달받은 문자열로 음성 가져오는 메서드
	@GetMapping("/captchaAudio.do")
	@ResponseBody
	public void captchaAudio(HttpServletRequest req, HttpServletResponse res) throws Exception{
		Captcha captcha = (Captcha) req.getSession().getAttribute(Captcha.NAME);
		String getAnswer = captcha.getAnswer();
		new CaptchaUtil().getAudioCaptCha(req, res, getAnswer);
	}

	// 사용자가 입력한 보안문자 체크하는 메서드
	@PostMapping("/chkAnswer.do")
	@ResponseBody
	public String chkAnswer(HttpServletRequest req, HttpServletResponse res) {
		String result = "";
		Captcha captcha = (Captcha) req.getSession().getAttribute(Captcha.NAME);
		String ans = req.getParameter("answer");
		if(ans!=null && !"".equals(ans)) {
			if(captcha.isCorrect(ans)) {
				req.getSession().removeAttribute(Captcha.NAME);
				result = "200";
			}else {
				result = "300";
			}
		}
		return result;
	}
}



























