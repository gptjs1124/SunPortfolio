<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<jsp:include page="header.jsp" />

<div id="homePageStats" >
	<ul>
		<li>
			<dl>
				<dt>오늘접속자</dt>
				<dd>${todayVCut}</dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt>어제방문자</dt>
				<dd>${yesterdayVCut}</dd>
			</dl>
		</li>
		<li>
			<dl>
				<dt>누적방문자</dt>
				<dd>${totalVCut}</dd>
			</dl>
		</li>
	</ul>
</div>

<div style="width:100%; padding:200px 0; margin:80px 0; background:#fff;">
	그래프 넣는 곳
</div>

<script>
	$(function() {
		$('#contactList').click(function() {
			location.href = "../admin/adminContactListProc?cpage=1&cmns_cd_nm=접수";
		});
	});
</script>

	<div>
	</div>
</div><!-- con -->
</div><!-- 전체 -->

