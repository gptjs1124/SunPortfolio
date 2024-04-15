package sun.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class fileController2 {
	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		Connection con = null;
		PreparedStatement stmt = null;
		
		try {
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "kh";
			String pw= "kh";
			con = DriverManager.getConnection(url,user,pw);
			System.out.println("위치지징");
			File f = new File("C:/img/img2.gif");
			System.out.println("위치지정이 잘못 됐나?");
			FileInputStream fis = new FileInputStream(f);
			System.out.println(fis);
			stmt = con.prepareStatement("insert into test1 values(?,?)");
			stmt.setString(1, "2.png");
			stmt.setBinaryStream(2, fis,(int)f.length());
			int rownum = stmt.executeUpdate();
			
			if(rownum > 0) {
				System.out.println("삽입성공");
			}else {
				System.out.println("삽입실패");
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		
		}finally {
			//사용한 객체 close
			try{
				if(con != null) con.close();
				if(stmt != null) stmt.close();
			}catch(Exception e) {
				
			}
		}
	}
}
