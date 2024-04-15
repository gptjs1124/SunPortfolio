package sun.spring.controller;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import sun.spring.dto.ContactDTO;
import sun.spring.service.ContactService;

@Controller
@RequestMapping("/sub/testC")
public class TestC {
	
	
	@Autowired
	private ContactService cservice;
	
	@ResponseBody
	@RequestMapping("viewProc")
	public List<ContactDTO> viewProc(ContactDTO cdto, Model model) throws Exception{
		System.out.println(cdto.getName());
		System.out.println("::::::::::::::::::::::::");
		// 한 페이지당 10개씩 게시물 보이기
		List<ContactDTO> count10 = cservice.count10(1);
		for (ContactDTO contactDTO : count10) {
			System.out.println(contactDTO.getSeq());
		}
		
		JSONObject jsonObject1 = new JSONObject(); // 중괄호에 들어갈 속성 정의 { "a" : "1", "b" : "2" }
        JSONArray jsonArray1 = new JSONArray(); // 대괄호 정의 [{ "a" : "1", "b" : "2" }]
        JSONObject finalJsonObject1 = new JSONObject(); // 중괄호로 감싸 대괄호의 이름을 정의함 { "c" : [{  "a" : "1", "b" : "2" }] }
        
		/*
		 * JSONArray jsonArray = JSONArray.fromObject(count10);
		 * System.out.println("mybeanList - " + jsonArray);
		 */
        
        
        //jsonObject1.put("number", "01");
        //jsonObject1.put("title", "제목 1");
        //jsonObject1.put("content", "배고픈데 뭘 먹을지 고민이네요 ㅎㅎㅎ");
        //jsonObject1.put("writer", "글쓴이");
        //jsonObject1.put("date", "2021/10/09");
        //jsonArray1.add(jsonObject1);
        
		return count10;
	}
	
}
