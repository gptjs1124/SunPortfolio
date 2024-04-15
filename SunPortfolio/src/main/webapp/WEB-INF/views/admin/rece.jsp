<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/admin.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


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
		background: #ededed;
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
					<form action="writeProc" method="post" id="contactProc" enctype="multipart/form-data">
						<input type="hidden" name="boardck" id="boardck" style="width:100%;" value="Y">
						<div class="ab_con">
							<table>
								<tr>
									<th colspan="1">카테고리</th>
									<td colspan="3">
										<input type="text" name ="category" value ="${con.category}">										
									</td>
								</tr>
								<tr>
									<th colspan="1">제목</th>
									<td colspan="3">
										<input type="text" name ="title" value ="${con.title}">
									</td>
								</tr>
								<tr>
									<th>회사</th>
									<td>
										<input type="text" name ="company" value ="${con.company}">
									</td>
									<th>직급</th>
									<td>
										<input type="text" name ="grade" value ="${con.grade}">
									</td>
								</tr>
								<tr>
									<th>이름</th>
									<td>
										<input type="text" name ="name" value ="${con.name}">
									</td>
									<th>전화번호</th>
									<td>
										<input type="text" name ="tel" value ="${con.tel}">
									</td>
								</tr>
								<tr>
									<th colspan="1">상담내용</th>
									<td colspan="3">
										<textarea name ="content" style="width:100%; height:200px;">${con.content}</textarea>
									</td>
								</tr>
								<tr>
									<th colspan="1">첨부파일</th>
									<td colspan="3">
									</td>
								</tr>
							</table>
						</div>
					</form>
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

</div>
