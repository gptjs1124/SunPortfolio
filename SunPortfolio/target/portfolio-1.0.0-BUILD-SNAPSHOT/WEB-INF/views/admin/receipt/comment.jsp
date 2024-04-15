<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>

<jsp:include page="../header.jsp" />
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="/resources/js/admin/receipt.js"></script>

<article id="Aboutus" class="sub_cont">
	<div class="inner1400">
		<div class="admin_tit_s1">
			<dl>
				<dt>${con.company}</dt>
				<dd>
					<span>${con.title}</span>
					<p>${con.content}</p>
				</dd>
			</dl>
		</div>

		<div class="adminContact">
			<iframe id ="iframeA" src="receiptProc.html?seq=${con.seq}"></iframe>
			<div id = "comment">
				<h3>comment</h3>
				<ul>
				<c:forEach var="commentVO" items="${requestScope.commentList}" varStatus="num">
					<c:if test="${num.count >= 1}">
						<li class="commentLi">
							<input type="hidden" id="seq" value ="${commentVO.seq}">
							<input type="hidden" id="sunportfolioSeq" value ="${commentVO.sunportfolioSeq}">
							<ul>
								<li>
									<span class="clicle"></span>
								</li>
								
								<li>${commentVO.name} <span class="date">${commentVO.commentDate}</span></li>
								<li class="commentext">
									${commentVO.commentText}
								</li>
							</ul>
							<div class="commenBtn">
								<button class="commentModify">수정</button>
								<button class="commentDelete">삭제</button>
							</div>
						</li>
					</c:if>
				</c:forEach>
				</ul>
				
				<div id="commentSave">
					<input type="hidden" id="sunportfolioSeq" value="${con.seq}">
					<input type="hidden" id="name" value="${con.name}">
					<textarea type="text" id="commentText"></textarea>
					<button id="commentSaveBtn">저장</button>
				</div>
			</div>
		</div>

		
	</div>

</article>
