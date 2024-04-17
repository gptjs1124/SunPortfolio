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
									<div id="catagory_con">
										
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
	</div>  -->
	
	<!-- 레이어팝업 -->
<div class="popup_layer" id="popup_layer" style="display: none;">
  <div class="popup_box">
      <div style="height: 10px; width: 375px; float: top;">
        <a href="javascript:closePop();"><img src="/static/img/ic_close.svg" class="m_header-banner-close" width="30px" height="30px"></a>
      </div>
      <!--팝업 컨텐츠 영역-->
      <div class="popup_cont" id="popup_cont">
          <h5> POPUP TILTE</h5>
          <p>
          	<h3>웹개발</h3>
          	<input type="checkbox" name="border" id="border01" value="일반게시판">
          	<label for="border01">일반게시판</label>
          	<input type="checkbox" name="border" id="border02" value="커스텀게시판">
          	<label for="border02">커스텀 게시판</label>
          	
          	<h3>웹개발 부가기능</h3>
          	<input type="checkbox" name="val" id="val01" value="">         	
          	<label for="val01">프린트 기능</label>
          	<input type="checkbox" name="val" id="val02">
          	<label for="val02">문자</label>
          	<input type="checkbox" name="val" id="val03">
          	<label for="val03">엑셀기능</label>
          	         	
          	<h3>디자인</h3>
          	<input type="checkbox" name="design" id="design01">         	
          	<label for="design01">웹디자인</label>
          	<input type="checkbox" name="design" id="design02">
          	<label for="design02">팝업디자인</label>
          	<input type="checkbox" name="design" id="design03">
          	<label for="design03">서브페이지 디자인</label>
          </p>
      </div>
      
      <button onclick="sendPop()">제출</button>
      <!--팝업 버튼 영역-->
      <div class="popup_btn" style="float: bottom; margin-top: 200px;">
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
				console.log($(this));
				console.log("border : " + $(this).val());
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
	

</div>