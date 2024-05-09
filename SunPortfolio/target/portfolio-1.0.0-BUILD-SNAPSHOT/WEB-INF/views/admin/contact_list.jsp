<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page session="false"%>

<jsp:include page="header.jsp" />
<script type="text/javascript" src="/resources/js/admin/contact_list.js"></script>
<article id="Aboutus" class="sub_cont">
	<div class="inner1400">
		<div class="admin_tit_s1">
			<div id="serch_title">검색</div>
			<form action="/admin/ContactListProc" method="post">
				<input type="hidden" id="cpage" name="cpage" value ="1">
				<input type="hidden" id="cmns_cd_nm" name="cmns_cd_nm" value ="${param.cmns_cd_nm}">

				<table id="search">
					<tr>
						<th>제목</th>
						<td><input type="text" id="title" name="title"></td>
						<th>내용</th>
						<td><input type="text" id="content" name="content"></td>
					</tr>
					<tr>
						<th>날짜</th>
						<td>
							<input type="text" id="startDate" name="startDate">
							 ~
							<input type="text" id="endDate" name="endDate">
						</td>
						<th>회사명</th>
						<td><input type="text" id="company" name="company"></td>
					</tr>
					<tr>
						<td colspan="4" style="border-bottom: none; text-align: center; padding-top:8px;">
							<button id="contact_Search">검색</button>
						</td>
					</tr>
				</table>
			</form>
		</div>

		<div class="admin_tit_s1">
			<dl>
				<c:choose>
					<c:when test="${empty param.cmns_cd_nm}">
						<dt id="tab_title">전체</dt>
					</c:when>
					<c:otherwise>
						<dt id="tab_title">${param.cmns_cd_nm}</dt>
					</c:otherwise>
				</c:choose>

				<dd>
					<ul>
						<li>
							<a href="/admin/ContactListProc?cpage=1">전체</a>
						</li>
						<!-- 탭메뉴생성 -->
						<c:forEach var ="step" items="${stepCommenCode}">
							<li>
								<a href="/admin/ContactListProc?cpage=1&cmns_cd_nm=${step.cmns_cd_nm}">${step.cmns_cd_nm}</a>
							</li>
						</c:forEach>
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
							<c:when test="${empty count10}">
								<tr><td colspan="6">등록된 게시글이 없습니다.</td></tr>
							</c:when>
							<c:otherwise>
								<c:forEach var="selectList" items="${count10}" varStatus="num">
									<c:if test="${num.count > 0}">
										<tr>
											<td>
												<input type="checkbox" name="ck" class="ck">
												<input type="hidden" name="count10" id="count10" value="${num.count}" >
											</td>
											<td>${selectList.row_num}</td>
											<td>
												<a href="/admin/viewProc?seq=${selectList.seq}">${selectList.title}</a>
											</td>
											<td><span class="target">${selectList.content}</span></td>
											<td>${selectList.dateWrite}</td>
											<td>
												<input type="hidden" name="seq" id="seq_${selectList.seq}" value="${selectList.seq}" >
												<input type="hidden" name="contactstepseq" id="contactstepseq_${selectList.contactstepseq}" value="${selectList.contactstepseq}" >
												<select class="StepIng" name="StepIng">
													<c:forEach var ="step" items="${stepCommenCode}">
														<option value="${step.cmns_cd}" <c:if test="${step.cmns_cd_nm eq selectList.cmns_cd_nm}">selected</c:if>>${step.cmns_cd_nm}</option>
													</c:forEach>
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
								${pageNavi}
							<li>
						</ul>
					</div>
									
					<button class="btn-write">글쓰기</button>
				</div>
		</div>
	</div>

</article>
