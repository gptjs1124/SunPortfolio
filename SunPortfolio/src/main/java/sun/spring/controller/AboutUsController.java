package sun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sub/aboutus")
public class AboutUsController {
	
	@RequestMapping("aboutus")
	public String aboutus() {
		return "/sub/aboutus/aboutus";
	}
}
