package sun.spring.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class BoardCount {
	private Connection getConnection() throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "kh";
		String password = "kh";
		Connection con = DriverManager.getConnection(url, user, password);
		return con;
	}
	public static void main(String[] args) throws Exception{
		Connection con = new BoardCount().getConnection();
		Statement stat = con.createStatement();
		for(int i =0;i<100;i++ ) {
			stat.executeUpdate("insert into sunportfolio values("
					+ "nextval('sunportfolio_seq'),'홈페이지제작', '하나하나"+i+"', '핫둘핫둘', '담당', '임하나', '031-377-6886', '꾹꾹꾸꾹꾺꾹',CURRENT_TIMESTAMP)");
			Thread.sleep(1000);
			System.out.println(i+"번째데이터 입력");
		}
		for(int i =0;i<100;i++ ) {
			stat.executeUpdate("insert into sunportfolio values("
					+ "nextval('sunportfolio_seq'),'홈페이지제작', '둘둘둘둘"+i+"', '두울두울두울', '담당', '스티나', '031-377-6886', '망망망망망망망망망망망망망망망망망망',CURRENT_TIMESTAMP)");
			Thread.sleep(1000);
			System.out.println(i+"번째데이터 입력");
		}
}
}
