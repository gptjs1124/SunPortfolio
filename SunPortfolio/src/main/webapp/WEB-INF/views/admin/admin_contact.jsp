<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>=
<%@ page session="false"%>

<jsp:include page="../inc/header_admin.jsp" />
<script type="text/javascript" src="/resources/js/admin/contact_list.js"></script>
<article id="Aboutus" class="sub_cont">
	<div class="inner1400">
		<div>
			진행사항
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
							<th>진행단계</th>
						</tr>
						
						<c:choose>
							<c:when test="${empty allBoardCount}">
								<tr><td colspan="4">등록된 게시글이 없습니다.</td></tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="no" items="${allBoardCount}" varStatus="num">
									<c:if test="${num.count >= 1}">
										<tr>
											<td>${no.rownum}</td>
											<td><a href="/sub/contact/viewProc?seq=${no.seq}">${no.title}</a></td>
											<td><sapn class="target">${no.content}</sapn></td>
											<td>${no.dateWrite}</td>
											<td>
												<select id="progress">
													<option value="접수">접수</option>
													<option value="진행">진행</option>
													<option value="완료">완료</option>
												</select>
											</td>
										</tr>
									</c:if>
								</c:forEach>
							</c:otherwise>
						</c:choose>
					</table>
					
					
					<div class="page">
						<ul>
							<li>
								<c:if test ="${not empty allBoardCount}">
									${allBoardCount.get(0).getSb()}
								</c:if>
							<li>
						</ul>
					</div>
									
					<button class="btn-write">글쓰기</button>
				</div>
		</div>
	</div>

</article>
<jsp:include page="../inc/fotter.jsp" />
