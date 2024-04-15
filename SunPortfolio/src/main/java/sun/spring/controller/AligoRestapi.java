package sun.spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/aligo/")
public class AligoRestapi {
	
	/*
	 * 메지시 발송 페이지 
	 */
	@RequestMapping(value="sendMessagePop", produces="application/json;charset=utf8", method = RequestMethod.POST)
	private String MessageSend()
	{
		return "/admin/sendMessagePop";
	}
	
//	/**
//     * REST API 호출
//     *  
//     * @param paramUrl
//     * @param jsonObject void
//     */
//	@ResponseBody
//	@RequestMapping(value="aligoAPI_test", produces="application/json;charset=utf8", method=RequestMethod.POST)
//    private void RestCall2(JSONObject jsonObject){ /*String paramUrl,*/
//    	try {
//            URL url = new URL("kakaoapi.aligo.in");
//            /* HttpURLConnection 서버와 클라이언트의 통신에 사용되는 규약
//             * http request와 response는 데이터의 정보를 담는 header, body로 구성된다.
//             * header의 정보들의 개행으로 구분되며 개행이  두번 되는 지점부터 BODY가 시작된다.
//             */
//            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("X-Auth-Token", "kakaoapi.aligo.in");            
//            conn.setRequestProperty("X-Data-Type", "application/json");
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setDoOutput(true);
//
//            OutputStreamWriter osw = new OutputStreamWriter(conn.getOutputStream(),"UTF-8");
//            osw.write(jsonObject.toString());
//            osw.flush(); // 트럭에 태워서 출발하라는 의미
//            osw.close(); // 닫음
//            
//            BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(),"UTF-8"));
//            System.out.println(br);
//            if (conn.getResponseCode() != 200) {
//                System.out.println("Failed: HTTP error code : " + conn.getResponseCode());
//            	throw new RuntimeException("Failed: HTTP error code : " + conn.getResponseCode());
//            } else {
//                System.out.println("발송 성공");
//            }
//            
//            String line = null;
//            while((line = br.readLine()) != null){
//                System.out.println(line);
//            }
//            br.close();           
//            conn.disconnect();
//        } catch (IOException e) {
//            System.out.println("RestCall Fail : " + e.getMessage());
//        }
//    }
//	
//	
//	
//	@ResponseBody
//	@RequestMapping(value="aligoAPI_test", produces="application/json;charset=utf8", method=RequestMethod.POST)
//    public static void RestCall(JSONObject jsonObject){
//		String resourceUrl = "https://kakaoapi.aligo.in/akv10/token/create/30/s/";
//    }
	
}