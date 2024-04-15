<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>

<jsp:include page="../../inc/header.jsp" />
<script type="text/javascript" src="/resources/js/contact/list.js"></script>
<article id="Aboutus" class="sub_cont">
	<div class="inner1400">

		<div class="tit_s1">
			<dl>
				<dt>List</dt>
				<dd>
					<span>히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛</span>
					<p>고객의 특징을 생각하여 디자인을 하는 디자이너 김혜선입니다. 레이아웃 / 구성 / 사진 / 타이포 등 고객이
						원하는 최상의 디자인을 만들어 드립니다.</p>
				</dd>
			</dl>
		</div>

		<div class="contact">
			<div class="tit_au_c">Self-introduction</div>
				<div class="ab_con">
					<table>
						<tr>
							<th>번호</th>
							<th>제목</th>
							<th>내용</th>
							<th>날짜</th>
						</tr>
						<c:choose>
							<c:when test="${empty allBoardCount}">
								<tr><td colspan="4">등록된 게시글이 없습니다.</td></tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="list" items="${allBoardCount}" varStatus="cnt">
									카운트 : ${cnt.count }
									<c:if test="${ cnt.count == 1 }">
										<c:set var="pageNav" value="${list.pageNav }"/>
									</c:if>
									<tr>
										<td>${list.rnum} <!-- ${cnt.count }--><%-- ${list.seq} --%></td>
										<td>
											<a href="/sub/contact/viewProc?seq=${list.seq}" style="color:rgba(255, 255, 255, 0.3);">${list.title}</a>
										</td>
										<td>${list.content}</td>
										<td>${list.dateWrite}</td>
									</tr>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					
					<div class="page">
						<ul>
							<li> < </li>
								<c:forEach var="nav" items="${pageNav}" varStatus="cnt">
									<li><a href ="/sub/contact/listProc?cpage=${nav}">${nav}</a></li>
								</c:forEach>
							<li> > </li>
						</ul>
					</div>
					
					<button class="btn-write">글쓰기</button>
				</div>
		</div>
	</div>

</article>
<jsp:include page="../../inc/fotter.jsp" />
