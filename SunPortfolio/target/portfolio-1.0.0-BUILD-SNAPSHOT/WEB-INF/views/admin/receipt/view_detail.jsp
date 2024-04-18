<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/admin.css">
<link rel="stylesheet" href="/resources/css/popup.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/js/admin/receipt.js"></script>
<script src="/resources/js/admin/popup.js"></script>

<style>
	.container{
		width: 100%;
		margin: 0 auto;
	}
	ul.tabs{
		margin: 0px;
		padding: 0px;
		list-style: none;
	}
	ul.tabs li{
		background: none;
		color: #222;
		display: inline-block;
		padding: 10px 15px;
		cursor: pointer;
	}
	ul.tabs li.current{
		background: #ededed;
		color: #222;
	}
	.tab-content{
		display: none;
		padding: 15px;
	}
	.tab-content.current{
		display: inherit;
	}

	#category_area{
		width:100%; background: #333;  border: none;  padding: 20px;  border-radius: 5px;  color: #fff;  margin-bottom: 20px;
	}
	.category_con{
		background: #555;  border: none;  padding: 10px; margin:5px;  border-radius: 5px;  color: #fff;  margin-bottom: 20px;
	}
	.category_delete{
		display: inline-block; margin-left:5px; background: none; border:none;
	}
</style>

<div class="container adminContact">

	<ul class="tabs">
		<li class="tab-link current" data-tab="tab-1">상세내용</li>
		<!-- <li class="tab-link" data-tab="tab-2">메뉴_둘</li>
		<li class="tab-link" data-tab="tab-3">메뉴_셋</li> -->
	</ul>
	<div id="tab-1" class="tab-content current">
		<article id="Aboutus" class="sub_cont">
			<div class="inner1400">		
				<div class="contact">
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
	</div>  -->
	
	<!-- 레이어팝업 -->
	<div class="popup_layer" id="popup_layer" style="display: none;">
	  <div class="popup_box">
		  <div style="height: 10px; width: 375px; float: top;">
			<a href="javascript:closePop();">X</a>
		  </div>
		  <!--팝업 컨텐츠 영역-->
		  <div class="popup_cont" id="popup_cont">
			  <h5>카테고리 수정</h5>
			  <div class="mb20">
				<h3 class="pb10">웹개발</h3>
				<input type="checkbox" name="border" id="border01" value="border01">
				<label for="border01">일반게시판</label>
				<input type="checkbox" name="border" id="border02" value="border02">
				<label for="border02">커스텀 게시판</label>
			  </div>
			  <div class="mb20">
				<h3 class="pb10">웹개발 부가기능</h3>
				<input type="checkbox" name="val" id="val01" value="print">
				<label for="val01">프린트 기능</label>
				<input type="checkbox" name="val" id="val02" value="mms">
				<label for="val02">문자</label>
				<input type="checkbox" name="val" id="val03" value="excel">
				<label for="val03">엑셀기능</label>
			  </div>
			  <div class="mb20">
				<h3 class="pb10">디자인</h3>
				<input type="checkbox" name="design" id="design01" value="webDesign">
				<label for="design01">웹디자인</label>
				<input type="checkbox" name="design" id="design02" value="popUpDesign">
				<label for="design02">팝업디자인</label>
				<input type="checkbox" name="design" id="design03" value="subPageDesign">
				<label for="design03">서브페이지 디자인</label>
			  </div>
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
		$('input:checkbox[name=border]').each(function(index){
			if($(this).is(":checked")==true){
				console.log("border : " + $(this).val());
				let newSpan = $("<span class='category_con'>"+ $(this).val() +"<button class='category_delete'>x</button> </span>");
				$("#category_area").append(newSpan);
			}
		})

		$('input:checkbox[name=val]').each(function(index){
			if($(this).is(":checked")==true){
				console.log("val : " + $(this).val());
				let newSpan = $("<span class='category_con'>"+ $(this).val() +"<button class='category_delete'>x</button> </span>");
				$("#category_area").append(newSpan);
			}
		})

		$('input:checkbox[name=design]').each(function(index){
			if($(this).is(":checked")==true){
				console.log("design : " + $(this).val());
				let newSpan = $("<span class='category_con'>"+ $(this).val() +"<button class='category_delete'>x</button> </span>");
				$("#category_area").append(newSpan);
			}
		})


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