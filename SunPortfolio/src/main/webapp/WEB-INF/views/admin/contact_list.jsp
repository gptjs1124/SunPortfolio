<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<jsp:include page="header.jsp" />
<script type="text/javascript" src="/resources/js/admin/contact_list.js"></script>
<article id="Aboutus" class="sub_cont">
	<div class="inner1400">
		<div class="admin_tit_s1">
			<form>
				<div id="tab_title">검색</div>
				<table id="search">
					<tr>
						<th>제목</th>
						<td><input type="text" id="title"></td>
						<th>내용</th>
						<td><input type="text" id="content"></td>
					</tr>
					<tr>
						<th>날씨</th>
						<td>
							<input type="text" id="datepicker1">
							<input type="text" id="datepicker2">
						</td>
						<th>진행단계</th>
						<td>
							<select class="StepIng" name="StepIng">
								<option value="접수" <c:if test="${no.contact eq '접수'}">selected</c:if>>접수</option>
								<option value="진행" <c:if test="${no.contact eq '진행'}">selected</c:if>>진행</option>
								<option value="완료" <c:if test="${no.contact eq '완료'}">selected</c:if>>완료</option>
								<option value="대기" <c:if test="${no.contact eq '대기'}">selected</c:if>>대기</option>
								<option value="삭제" <c:if test="${no.contact eq '삭제'}">selected</c:if>>삭제</option>
							</select>
						</td>
					</tr>
					<tr>
						<td colspan="4" style="border-bottom: none; text-align: right; padding-top:8px;">
							<button>검색</button>
						</td>
					</tr>
				</table>
			</form>
		</div>

		<div class="admin_tit_s1">
			<dl>
				<dt id="tab_title">${cdto.contact}</dt>
				<dd>
					<ul>
						<li>
							<a href="/admin/ContactListProc?cpage=1&contact=접수">접수</a>
						</li>
						<li>
							<a href="/admin/ContactListProc?cpage=1&contact=진행">진행</a>
						</li>
						<li>
							<a href="/admin/ContactListProc?cpage=1&contact=완료">완료</a>
						</li>
					</ul>
				</dd>
			</dl>
		</div>

		<div class="adminContact">
				<div class="ab_con">
					<table>
						<tr>
							<th></th>
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
											<td>
												<input type="checkbox" name="ck" class="ck">
												<input type="hidden" name="allBoardCount" id="allBoardCount" value="${num.count}" >
											</td>
											<td>${no.rnum}</td>
											<td>
												<a href="/admin/viewProc?seq=${no.seq}">${no.title}</a>
											</td>
											<td><span class="target">${no.content}</span></td>
											<td>${no.dateWrite}</td>
											<td>
												<input type="hidden" name="seq" id="seq_${no.seq}" value="${no.seq}" >
												<select class="StepIng" name="StepIng">
													<option value="접수" <c:if test="${no.contact eq '접수'}">selected</c:if>>접수</option>
													<option value="진행" <c:if test="${no.contact eq '진행'}">selected</c:if>>진행</option>
													<option value="완료" <c:if test="${no.contact eq '완료'}">selected</c:if>>완료</option>
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
