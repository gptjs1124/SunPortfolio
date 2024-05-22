package sun.spring.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import org.slf4j.Logger;
import org.slf4j.LoggerFactory;*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import sun.spring.dao.FileDAO;
import sun.spring.dto.ContactDTO;
import sun.spring.dto.FileDTO;

@Controller
@RequestMapping("file")
public class fileController {
	
	@Autowired
	public HttpSession session;
	
	@Autowired
	public FileDAO fdao = new FileDAO();
	
	//private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public FileDTO fileOneInsert(ContactDTO conDTO, String realPath) throws Exception {
		FileDTO fDTO = new FileDTO();
		MultipartFile file = conDTO.getFile();
		File fileRealPath = new File(realPath);
		
		if(!fileRealPath.exists())
		{			
			try{
				boolean fileMkdirReturn = fileRealPath.mkdir(); //폴더 생성합니다. ("새폴더"만 생성)
			    System.out.println("폴더가 생성 :::: "+ fileMkdirReturn);
		        } 
		        catch(Exception e){
			    e.getStackTrace();
			}        
		}
		
		String writeDate = new SimpleDateFormat("YYYY-MM-dd-ss").format(System.currentTimeMillis());
		fDTO.setOriname(file.getOriginalFilename()); //실제 파일 이름
		fDTO.setSysname(writeDate +"_"+ fDTO.getOriname()); //저장될 파일 이름
		fDTO.setRealpath(fileRealPath +"\\"+ fDTO.getSysname()); //실제경로 + 저장될 파일 이름
		
		//파일 저장하기
		File fileDownload = new File(realPath + "/" + fDTO.getSysname());
		file.transferTo(fileDownload); //파일을 서버에 저장한다.
		
		conDTO.setFile(file);
		return fDTO;
	}
	
	// 참고 https://kitty-geno.tistory.com/105
	public FileDTO fileOutputStream(HttpServletRequest request, HttpServletResponse response, ContactDTO conDTO, FileDTO fDTO) throws Exception{
		String fileName = conDTO.getFile().toString();
		String realPath = session.getServletContext().getRealPath("upload/contact/files/");
		
		File fileRealPath = new File(realPath);
		File dFile = new File(fileRealPath, conDTO.getFile().toString());
		int fSize = (int) dFile.length(); //파일 길이를 가져온다.
		
		//파일이 존재하는지 확인
		if(fSize > 0) {
			String encodedFilename = "attachment; filename*=" + "UTF-8" + "''" + URLEncoder.encode(fileName,"UTF-8");
			
			//ContentType 설정
			response.setContentType("application/octet-stream; charset=utf-8");
			
			//Header 설정
			response.setHeader("Context-Disposition", encodedFilename);
			
			//ContentLength 설정
			//response.setContentLengthLong(fSize);
			
			BufferedInputStream in = null;
			BufferedOutputStream out = null;
			
			/*BufferedInputStream
			 * java.io의 가장 기본 파일 입출력 클래스 
			 * 입력 스트림(통로)을 생성해줌
			 * 사용법은 간단하지만, 버퍼를 사용하지 않기 때문에 느림
			 * 속도 문제를 해결하기 위해 버퍼를 사용하는 다른 클래스와 같이 쓰는 경우가 많음.
			 * */
			in = new BufferedInputStream(new FileInputStream(dFile));
			
			/*BufferedOutputStream
			 * java.io의 가장 기본이 되는 파일 입출력 클래스
			 * 출력 스트림(통로)을 생성해줌
			 * 사용법은 간단하지만, 버퍼를 사용하지 않기 때문에 느림.
			 * 속도 문제 생결하기 위해 버퍼를 사용하는 다른 클래스와 같이 쓰는 경우가 많음.
			 * */
			out = new BufferedOutputStream(response.getOutputStream());
			
			try {
				byte[] buffer = new byte[4096];
				int bytesRead = 0;
				
				while((bytesRead = in.read(buffer)) != -1) {
					out.write(buffer, 0, bytesRead);
				}
				
					out.flush();
			} finally {
				/*현재 열려 in,out 스트림을 닫음
				 * 메모리 누수를 방지하고 다른 곳에서 리소스 사용이 가능하게 만듬. */
				in.close();
				out.close();
			}			
		} else {
			throw new FileNotFoundException("파일이 없습니다.");
		}
		
		
		return fDTO;
	}
	
	
}
