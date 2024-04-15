<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<jsp:include page="../../inc/header.jsp" />
<script type="text/javascript" src="/resources/js/contact/modify.js"></script>
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
			<form action="conModifyProc" method="post">
				<div class="ab_con">
					<table>
						<tr>
							<th>숫자</th>
							<td colspan="3">
								<input type="hidden" name="seq" value="${cdto.seq}">
							</td>
						</tr>
						<tr>
							<th>제목</th>
							<td colspan="3">
								<input type="text" name="title" id="title" value="${cdto.title}" style="width:100%;">
							</td>
						</tr>
						<tr>
							<th>내용</th>
							<td colspan="3">
								<textarea name="content" id="content" style="width: 100%; height: 200px;">
									${cdto.content}
								</textarea>
							</td>
						</tr>
						<!--  
					<tr>
						<th>이메일</th>
						<td colspan="3">
							<input type="text" id="email01"> @ 
							<input type="text" id="email02">
						</td>
					</tr>
					<tr>
						<th>이름</th>
						<td><input type="text" id="name"></td>
						<th>전화번호</th>
						<td>
							<input type="text" id="tel01"> -
							<input type="text" id="tel02"> -
							<input type="text" id="tel03">
						</td>
					</tr>
					-->
					</table>
					<div class="center send">
						<input type="submit" id="sub_btn" value="send">
					</div>
				</div>
			</form>
		</div>
	</div>

	<div class="au_list_05"></div>

	</div>
</article>
<jsp:include page="../../inc/fotter.jsp" />
