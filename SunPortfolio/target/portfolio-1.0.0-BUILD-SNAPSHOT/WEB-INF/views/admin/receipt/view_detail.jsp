<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/admin.css">
<link rel="stylesheet" href="/resources/css/sub.css">
<link rel="stylesheet" href="/resources/css/popup.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/js/admin/receipt.js"></script>
<script src="/resources/js/code.js"></script>
<script src="/resources/js/getContactMenu.js"></script>

<div class="container adminContact">
	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">상세내용</li>
		<!--
		<li class="tab-link" data-tab="tab-2">메뉴_둘</li>
		<li class="tab-link" data-tab="tab-3">메뉴_셋</li>
		-->
	</ul>
	<div id="tab-1" class="tab-content current">
		<article id="Aboutus" class="sub_cont">
			<div class="inner1400">		
				<div>
					<div>
						<button id="save">저장하기</button>
					</div>
					<input type="hidden" name="boardck" id="boardck" style="width:100%;" value="Y">
					<div class="ab_con">
						<table>
							<tbody>
							<tr>
								<th colspan="1">카테고리</th>
								<td colspan="3">
									<input type="text" id="seq" name ="seq" value="${con.seq}">
									<%--<input type="text" id="category" name="category" value="${con.category}">--%>
									<div id="category_area">
										<c:forEach var="chooseMenu" items="${chooseMenuList}">
											<span class="category_con" data-categprymenuseq="${chooseMenu.categprymenuseq}" data-cmnscd="${chooseMenu.cmns_cd}">${chooseMenu.cmns_cd_nm}<button class="category_delete">x</button> </span>
										</c:forEach>

									</div>
									<a href="javascript:openPop()" id="catagoryModify">수정</a>							
								</td>
							</tr>
							<tr>
								<th colspan="1">제목</th>
								<td colspan="3">
									<input type="text" id="title" name="title" value="${con.title}">		
								</td>
							</tr>
							<tr>
								<th>회사</th>
								<td>
									<input type="text" name="company" id="company" value="${con.company}">		
								</td>
								<th>직급</th>
								<td>
									<input type="text" name="grade" id="grade" value="${con.grade}">
								</td>
							</tr>
							<tr>
								<th>이름</th>
								<td>
									<input type="text" name="name" id="name" value="${con.name}">
								</td>
								<th>전화번호</th>
								<td>
									<input type="text" name="tel" id="tel" value="${con.tel}">
								</td>
							</tr>
							<tr>
								<th colspan="1">상담내용</th>
								<td colspan="3">
									<textarea id="content" name="content" style="width: 556px; height: 254px;">${con.content}</textarea>
								</td>
							</tr>
							<tr>
								<th colspan="1">첨부파일</th>
								<td colspan="3">
									<img src="/upload/contact/files/${con.filename}" alt="이미지">
									<div>
										<button id="download_chmbu">첨부파일 다운로드</button>
									</div>
								</td>
							</tr>
						</tbody>
						</table>
					</div>
				</div>
			</div>
	</article>
	</div>
	<!--<div id="tab-2" class="tab-content" style="height:1000px;">
---- ---- ★------ ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ★-- ---- ---- ------★ ---- ---- ---- ---- ---- ---- -------- ---- ---- ---- ---- ---- ---- ★------ ---- ---- ---- ----
	</div>
	<div id="tab-3" class="tab-content" style="height:200px;">
---- ★-- -------- ---- ---- ---- -★- ---- ---- -------- ---- -★- ---- ---- ---- ---- -------- ---- ---- ---- ---- ---- --★ -------- ★-- ---- ---- ---- ---- ---- -------- ---- ---- --★ ---- ---- ---- -------- ---- ---- ---- --★
	</div>-->
	
	<!-- 레이어팝업 -->
	<div class="popup_layer" id="popup_layer" style="display: none;">
	  <div class="popup_box">
		  <div style="height: 10px; width: 375px;">
			<a href="javascript:closePop();">X</a>
		  </div>

		  <!--팝업 컨텐츠 영역-->
		  <div class="popup_cont" id="popup_cont">
			  <h5>카테고리 수정</h5>
		  </div>

		  <button onclick="sendPop()">제출</button>
		  <!--팝업 버튼 영역-->
		  <div class="popup_btn" style="margin-top: 20px;">
			  <a href="javascript:closePop();">닫기</a>
		  </div>
	  </div>
	</div>
</div>