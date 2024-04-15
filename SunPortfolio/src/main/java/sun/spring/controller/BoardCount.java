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
					+ "sunportfolio_seq.nextval,'홈페이지제작', '주의 은혜~ 너를 위해 천대까지"+i+"', '흘러가리', '대리', '잇샤', '031-377-6886', '위하시네에~위하시네에~위하시네에~위하시네에~위하시네에~위하시네에~',sysdate)");
			Thread.sleep(1000);
			System.out.println(i+"번째데이터 입력");
		}
		for(int i =0;i<100;i++ ) {
			stat.executeUpdate("insert into sunportfolio values("
					+ "sunportfolio_seq.nextval,'홈페이지제작', '주의 말씀에 순종하는자"+i+"', '복을받으리니', '대리', '잇쉬', '031-377-6886', '할렐루 할렐루야~할렐루 할렐루야~할렐루 할렐루야~할렐루 할렐루야~',sysdate)");
			Thread.sleep(1000);
			System.out.println(i+"번째데이터 입력");
		}
}
}
