<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>

<jsp:include page="../../inc/header.jsp" />
<script type="text/javascript" src="/resources/js/contact/write.js"></script>
<article id="Aboutus" class="sub_cont">
	<div class="inner1400">

		<div class="tit_s1">
			<dl>
				<dt>Contact</dt>
				<dd>
					<span>히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛</span>
					<p>고객의 특징을 생각하여 디자인을 하는 디자이너 김혜선입니다. 레이아웃 / 구성 / 사진 / 타이포 등 고객이
						원하는 최상의 디자인을 만들어 드립니다.</p>
				</dd>
			</dl>
		</div>

		<div class="contact">
			<div class="tit_au_c">Self-introduction</div>
			<form action="writeProc" method="post" id="contactProc" enctype="multipart/form-data">
				<input type="hidden" name="boardck" id="boardck" style="width:100%;" value="Y">
				<div class="ab_con">
					<table>
						<tr>
							<th colspan="1">카테고리</th>
							<td colspan="3">
								<select id="category" name="category">
									<option id="one">:::: 문의사항을 선택해주세요 ::::</option>
									<option value="홈페이지">홈페이지</option>
									<option value="상세페이지">상세페이지</option>
									<option value="서브페이지">서브페이지</option>
									<option value="팝업 및 메인슬라이드">팝업 및 메인슬라이드</option>
									<option value="기타">기타</option>
								</select>
							</td>
						</tr>
						<tr>
							<th colspan="1">제목</th>
							<td colspan="3">
								<input type="text" name="title" id="title" style="width:100%;">
							</td>
						</tr>
						<tr>
							<th>회사</th>
							<td>
								<input type="text" name="company" id="company">
							</td>
							<th>직급</th>
							<td>
								<input type="text" name="grade" id="grade">
							</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>
								<input type="text" name="name" id="name">
							</td>
							<th>전화번호</th>
							<td>
								<select  id="selTel" name="selTel">
									<option value="010">010</option>
									<option value="011">011</option>
									<option value="019">019</option>
									<option value="000">직접입력</option>
								</select>
								-
								<input type="text" name="phone01" id="phone01">
								-
								<input type="text" name="phone02" id="phone02">
							</td>
						</tr>
						<tr>
							<th colspan="1">상담내용</th>
							<td colspan="3">
								<textarea name="content" id="content" style="width: 100%; height: 200px;"></textarea>
							</td>
						</tr>
						<tr>
							<th colspan="1">첨부파일</th>
							<td colspan="3">
								<input type="file" name="file" id="file">
							</td>
						</tr>
						<tr>
							<th colspan="1">자동등록방지</th>
							<td colspan="3">
								캡챠는 도메인연결하고 진행하기
							</td>
						</tr>
					</table>
					<div class="center send">
						<input type="submit" id="sub_btn" value="send">
					</div>
				</div>
			</form>
		</div>
	</div>
	
</article>
<jsp:include page="../../inc/fotter.jsp" />
