package sun.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.spring.dto.PTCategoryDTO;
import sun.spring.service.PTService;

@Controller
@RequestMapping("/sub/portfolio")
public class PortfolioController {
	
	@Autowired
	private PTService ptService;	
	
	@RequestMapping("list")
	public String list(Model model) throws Exception{
		List<PTCategoryDTO> depth1 = ptService.pt_ctgSelect_DEPTH1();
		model.addAttribute("depth1", depth1);
		return "/sub/portfolio/list";
	}
	
	@ResponseBody
	@RequestMapping("getDepthList")
	public List<PTCategoryDTO> getDepthList (PTCategoryDTO ptDTO) throws Exception{
		List<PTCategoryDTO> depth2 = ptService.pt_ctgSelect_DEPTH2(ptDTO);
		return depth2;
	}
	
	@RequestMapping("bookhi")
	public String bookhi() {
		return "/sub/portfolio/bookhi";
	}
	
	@RequestMapping("chateng")
	public String chateng() {
		return "/sub/portfolio/chateng";
	}
	
	@RequestMapping("ebara")
	public String ebara() {
		return "/sub/portfolio/ebara";
	}
	
	@RequestMapping("everymonday")
	public String everymonday() {
		return "/sub/portfolio/everymonday";
	}
	
	@RequestMapping("mirun")
	public String mirun() {
		return "/sub/portfolio/mirun";
	}
	
	@RequestMapping("openend")
	public String openend() {
		return "/sub/portfolio/openend";
	}
	
	@RequestMapping("ourhome")
	public String ourhome() {
		return "/sub/portfolio/ourhome";
	}
	
	@RequestMapping("smartel")
	public String smartel() {
		return "/sub/portfolio/smartel";
	}
	
	@RequestMapping("b")
	public String b() {
		return "/sub/portfolio/b";
	}
}
