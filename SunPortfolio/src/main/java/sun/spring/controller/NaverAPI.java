//package sun.spring.controller;
//
//import java.io.BufferedReader;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.UnsupportedEncodingException;
//import java.net.HttpURLConnection;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.net.URLEncoder;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.regex.Pattern;
//
//import com.google.gson.JsonArray;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonObject;
//import com.google.gson.JsonParser;
//
//public class NaverAPI {
//	//검색창
//	public static void searchNews(String keyword) throws Exception{
//        String clientId = "85aEBN8SE3LhzAG0TbRP"; //애플리케이션 클라이언트 아이디값"
//        String clientSecret = "r1BUxtFy1E"; //애플리케이션 클라이언트 시크릿값"
//
//        String text = null;
//        try {
//            text = URLEncoder.encode(keyword, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException("검색어 인코딩 실패",e);
//        }
//
//        String apiURL = "https://openapi.naver.com/v1/search/news?query=" + text;    // json 결과
//        //String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text; // xml 결과
//
//        Map<String, String> requestHeaders = new HashMap<String, String>();
//        requestHeaders.put("X-Naver-Client-Id", clientId);
//        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
//        String responseBody = get(apiURL,requestHeaders);
//
//        System.out.println(responseBody);
//        
//        JsonElement root = JsonParser.parseString(responseBody); // parse : 분석한다.
//        JsonObject rootObj = root.getAsJsonObject();
//        JsonArray arr = rootObj.getAsJsonArray("items");
//       // System.out.println(arr.get(0));
//        Pattern pattern = Pattern.compile("");
//        for (int i = 0; i < arr.size(); i++) {
//        	JsonObject arrObject = arr.get(i).getAsJsonObject(); //arr i번째 있는 데이터가 어떤 형인지 모르니까 JsonObject형이라고 한번 더 선언해준다.
//        	String newtitle = arrObject.get("title").getAsString();
//        	String title = newtitle.replaceAll("<b>", "");
//        	String title1 = title.replaceAll("</b>", "");
//        	String newpubdate = arrObject.get("pubDate").getAsString();
//        	
//        	System.out.println(
//            		"제목 : " + title1 +"\n날짜 : " + newpubdate+"\n"+
//            		"------------------------------"
//            		);
//		}      
//    }
//
//    private static String get(String apiUrl, Map<String, String> requestHeaders) throws Exception{
//        HttpURLConnection con = connect(apiUrl);
//        try {
//            con.setRequestMethod("GET");
//            for(Map.Entry<String, String> header :requestHeaders.entrySet()) {
//                con.setRequestProperty(header.getKey(), header.getValue());
//            }
//
//            int responseCode = con.getResponseCode();
//            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 호출
//                return readBody(con.getInputStream());
//            } else { // 에러 발생
//                return readBody(con.getErrorStream());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("API 요청과 응답 실패", e);
//        } finally {
//            con.disconnect();
//        }
//    }
//    
//  //파파고
//	public static void translateKorToEng(String papagocall) throws Exception{
//        String clientId = "dhpoMMA8V5JpbOHViYdp";//애플리케이션 클라이언트 아이디값";
//        String clientSecret = "erK3zoZTcr";//애플리케이션 클라이언트 시크릿값";
//
//        //네이버에게 아래 주소 api에 접근하라고 Request에 싸서 보낼 주소
//        String apiURL = "https://openapi.naver.com/v1/papago/n2mt"; //네이버에서 제공하는 번역 사이트주소
//        String text;
//        try {
//            text = URLEncoder.encode(papagocall, "UTF-8"); //글씨 안깨지게 인코딩하는 작업.
//        } catch (UnsupportedEncodingException e) {
//            throw new RuntimeException("인코딩 실패", e);
//        }
//
//        //Request(리퀘스트:요청하다)에 header가 있는데 거기에 클라이언트 id와 시크릿값
//        Map<String, String> requestHeaders = new HashMap<String, String>();
//        requestHeaders.put("X-Naver-Client-Id", clientId);
//        requestHeaders.put("X-Naver-Client-Secret", clientSecret);
//        
//        //post : 우편보내는 매소드 /response는 서버로 부터 돌아오는 응답
//        String responseBody = post(apiURL, requestHeaders, text);
//        
//        //gson - 제이슨 사용
//        JsonElement root = JsonParser.parseString(responseBody); //JsonElement는 무슨타입이 아니고 그냥 JsonElement라고 명시한것 그래서 자료형이 정해진게 아님, 이건 제이슨으로 데이터가 온줄 몰라!
//        JsonObject dataType = root.getAsJsonObject(); //.getAsJsonObject() 무슨형으로 데이터를 가져올지 지정해주는 매소드
//        JsonObject dataType2 = dataType.getAsJsonObject("message");
//        JsonObject dataType3 = dataType2.getAsJsonObject("result");
//        JsonElement value3 =  dataType3.get("translatedText");
//        System.out.println(value3.getAsString());
//        
//        /*JsonObject rootObj =  root.getAsJsonObject(); //자료형이 제이슨 오브젝트라고 치환하는 것
//        JsonObject messageObj = rootObj.getAsJsonObject("message"); // messageObj키 값을 가지고 value값을 messageObj를 넣는다.
//        JsonObject resultObj = messageObj.getAsJsonObject("result");
//        String message = resultObj.get("translatedText").getAsString();
//        System.out.println(message);
// * */
//       
//    }
//	
//	//보내는 작업
//    private static String post(String apiUrl, Map<String, String> requestHeaders, String text) throws Exception{
//        HttpURLConnection con = connect(apiUrl); //HttpURLConnection는? JDK에 들어있는 웹통신 객체, 네이버띄우지 않았지만 네이버랑 통신 가능 ,네이버를 웹에 띄워서 클릭하지 않아도 네이버에 통신을 넣을 수있다.
//        //key=value & key=value & key=value
//        String postParams = "source=ko&target=en&text=" + text; //원본언어: 한국어 (ko) -> 목적언어: 영어 (en)
//        //Params는 파라미터로 읽으면 됨 / key=valuehttps://mvnrepository.com/artifact/com.google.code.gson/gson?repo=redhat-ga
//        try {
//            con.setRequestMethod("POST");
//            for(Map.Entry<String, String> header :requestHeaders.entrySet()) { //entry:키와 벨로 한 쌍
//                con.setRequestProperty(header.getKey(), header.getValue());
//            }
//
//            con.setDoOutput(true);
//            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
//                wr.write(postParams.getBytes());
//                wr.flush();
//            }
//
//            int responseCode = con.getResponseCode(); //responseCode는 404 이런 숫자로 오류가 뜨면 알려주는 코드
//            if (responseCode == HttpURLConnection.HTTP_OK) { // 정상 응답
//                return readBody(con.getInputStream());
//            } else {  // 에러 응답
//                return readBody(con.getErrorStream());
//            }
//        } catch (IOException e) {
//            throw new RuntimeException("API 요청과 응답 실패", e);
//        } finally {
//            con.disconnect();
//        }
//    }
//
//    private static HttpURLConnection connect(String apiUrl){
//        try {
//            URL url = new URL(apiUrl);
//            return (HttpURLConnection)url.openConnection();//HttpURLConnection로 형변환한것
//        } catch (MalformedURLException e) {
//            throw new RuntimeException("API URL이 잘못되었습니다. : " + apiUrl, e);
//        } catch (IOException e) {
//            throw new RuntimeException("연결이 실패했습니다. : " + apiUrl, e);
//        }
//    }
//
//    private static String readBody(InputStream body) throws Exception{
//        InputStreamReader streamReader = new InputStreamReader(body, "UTF-8");
//
//        try (BufferedReader lineReader = new BufferedReader(streamReader)) {
//            StringBuilder responseBody = new StringBuilder();
//
//            String line;
//            while ((line = lineReader.readLine()) != null) {
//                responseBody.append(line);
//            }
//
//            return responseBody.toString();
//        } catch (IOException e) {
//            throw new RuntimeException("API 응답을 읽는데 실패했습니다.", e);
//        }
//    }
//}
//
