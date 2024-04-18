<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- 메인슬라이드 끝 -->
<link rel="stylesheet" href="/resources/css/reset.css" type="text/css">
<link rel="stylesheet" href="/resources/css/admin.css" type="text/css">
<link rel="stylesheet" href="/resources/css/sub.css" type="text/css">
<link rel="stylesheet" href="http://code.jquery.com/ui/1.8.18/themes/base/jquery-ui.css" type="text/css" /> <!-- jQuery UI CSS파일  -->

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script type="text/javascript" src="/resources/js/admin/index.js"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script> <!-- jQuery 기본 js파일  -->
<script src="http://code.jquery.com/ui/1.8.18/jquery-ui.min.js"></script> <!-- jQuery UI 라이브러리 js파일  -->

<div id="headerUserInfo">${sessionScope.adminLogin.id}</div>
<div style="background:#202020;">
	<div id="adminNav">
		<h1 class="logo"><a href="/admin/index"><img src="/resources/img/logo.png"></a></h1>
		<ul id="adminMenu">
			<li>statistics</li>
			<li>
				Contact
				<ul id="contactUl">
					<li>
						<a href="/admin/ContactListProc?cpage=1&contact=접수">
							-&nbsp;&nbsp;접수
						</a>
					</li>
					<li>
						<a href="/admin/ContactListProc?cpage=1&contact=진행">
							-&nbsp;&nbsp;진행
						</a>
					</li>
					<li>
						<a href="/admin/ContactListProc?cpage=1&contact=완료">
							-&nbsp;&nbsp;완료
						</a>
					</li>
				</ul>
			</li>
		</ul>
	</div>
<div id="con">

