package sun.spring.controller;

public class DB {
	/*
	 * create table sunportfolio(
		    title varchar(100) not null,
		    content varchar(1000) not null,
		    con_date timestamp default sysdate not null 
		);
		
		create sequence sunportfolio_seq
		start with 1
		increment by 1
		nomaxvalue
		nocache;
	 * 
	 * 
	 * 
	 * */
	
	public static void main(String[] args) {
		String str = "1,하하하하하|2,히히히히히히";
		String[] row = str.split("\\|"); // 역슬레시 두번 줘야된다 정규식 표현이여서 역슬래세 2번을 줘야 자바가 알아 먹는다.
		
				System.out.println(row[0]);
				System.out.println(row[0].toString());
				System.out.println(row[1]);
				System.out.println(row[1].toString());
				System.out.println(row);
				System.out.println(row.toString());
	}
}
