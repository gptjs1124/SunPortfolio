<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/admin.css">
<link rel="stylesheet" href="/resources/css/sub.css">
<link rel="stylesheet" href="/resources/css/popup.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/js/admin/receipt.js"></script>
<script src="/resources/js/code.js"></script>

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
									<input type="text" id="category" name="category" value="${con.category}">
									<div id="category_area"></div>
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
			  <%--<c:forEach var="item" items="${codeGroupList}">
				  <div class="mb20">
				  <c:choose>
					  <c:when test="${empty item.up_cmns_cd && item.cmns_cd == 'CM_DV'}">
							  <h3 class="pb10">${item.cmns_cd_nm}</h3>
					  </c:when>
					  <c:when test="${item.up_cmns_cd == 'CM_DV'}">
						  <input type="checkbox" name="${item.up_cmns_cd}" id="border01" value="${item.cmns_cd}">
						  <label for="border01">${item.cmns_cd_nm}</label>
					  </c:when>
				  </c:choose>
				  </div>
			  </c:forEach>--%>
		  </div>

		  <button onclick="sendPop()">제출</button>
		  <!--팝업 버튼 영역-->
		  <div class="popup_btn" style="margin-top: 20px;">
			  <a href="javascript:closePop();">닫기</a>
		  </div>
	  </div>
	</div>
</div>

<script>
	function sendPop(){
		$("#popup_cont").is(":checked");
		$('input:checkbox[name=CM_DV]').each(function(index){
			let getName = $(this).next().text();
			if($(this).is(":checked") === true){
				let newSpan = $("<span class='category_con' data-d ='"+ $(this).val() +"'>"+ getName +"<button class='category_delete'>x</button> </span>");
				$("#category_area").append(newSpan);
			}
		})

		$('input:checkbox[name=CM_DV_VAL]').each(function(index){
			if($(this).is(":checked") === true){
				let newSpan = $("<span class='category_con'>"+ $(this).val() +"<button class='category_delete'>x</button> </span>");
				$("#category_area").append(newSpan);
			}
		})

		$('input:checkbox[name=CM_DS]').each(function(index){
			if($(this).is(":checked") === true){
				let newSpan = $("<span class='category_con'>"+ $(this).val() +"<button class='category_delete'>x</button> </span>");
				$("#category_area").append(newSpan);
			}
		});
/*
		$.ajax({
			type : "post",
			url : "/admin/categoryUpdate",
			data : {

			}
		});*/

		$("#popup_layer").css("display","none");

	}

	//팝업 띄우기
	function openPop() {
		document.getElementById("popup_layer").style.display = "block";
	}

	//팝업 닫기
	function closePop() {
		document.getElementById("popup_layer").style.display = "none";
	}
</script>