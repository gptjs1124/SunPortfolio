<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
							<input type="hidden" id="comment_seq" value ="${commentVO.comment_seq}">
							<input type="hidden" id="seq" value ="${commentVO.seq}">
							<ul>
								<li>
									<span class="clicle"></span>
								</li>
								
								<li>${commentVO.user_idntf_id} <span class="date">${commentVO.comment_date}</span></li>
								<li class="comment">
									<span class="commentText">${commentVO.comment_text}</span>
									<div class="commentTextModify">
										<input type="text" id="commentTextModify" value="${commentVO.comment_text}">
									</div>
									
									<div class="commenBtn">
										<span class="modifyHiddenBtn">
											<button class="commentModify">수정</button>
											<button class="commentDelete">삭제</button>	
										</span>
										<span class="modifyShowBtn">
											<button class="commentSave">저장</button>
											<button class="commentCancel">취소</button>
										</span>							
									</div>
								</li>
							</ul>
							
						</li>
					</c:if>
				</c:forEach>
				</ul>
				
				<div id="commentSave">
					<input type="hidden" id="sunportfolioSeq_comment" value="${con.seq}">
					<input type="hidden" id="name" value="${con.name}">
					<textarea type="text" id="commentText"></textarea>
					<button id="commentSaveBtn">저장</button>
				</div>
			</div>
		</div>
	</div>
</article>

<script>
	let iframe = document.getElementById('iframeA');

	iframe.addEventListener('load', function(){
		iframe.style.height = iframe.contentDocument.body.scrollHeight + 'px';
	});
</script>
