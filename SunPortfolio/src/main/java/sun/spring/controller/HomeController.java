package sun.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sun.spring.dto.AdminIpCkDTO;
import sun.spring.service.AdminService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	@Autowired
	private AdminService as;

	@RequestMapping("/")
	public String home(HttpServletRequest request, String result, Model model) throws Exception{
		/* 잘 들어갔는지 테스트 */
		if ("".equals(result) || result != null) {
			//result.contentEquals("") //조건 자체가 잘못됨. "" 문자열 비교할때 null가능성이 있는건 뒤에서 비교한다. 확실하게 null이 아니면 앞에 사용해도 된다.
			model.addAttribute("result",Integer.parseInt(result));
		}
		
		//ip확인	
		String ip = request.getRemoteAddr();
		AdminIpCkDTO aIpCkdto = new AdminIpCkDTO();
		aIpCkdto.setIp(ip);
		//ip값을 저장한게 있는지 확인
		int ipExistCk = as.selectIpExistCk(aIpCkdto);
		if(ipExistCk != 0){
			as.updateAdminIpCk(aIpCkdto); //ip update
		}else {
			as.adminIpCk(aIpCkdto); //ip insert
		}	
		
		return "index";
	}
	
	
	
}
