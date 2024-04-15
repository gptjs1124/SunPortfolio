<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/admin.css">
<style>html, body { height:100%;  overflow:hidden; background:none;}</style>

<div id="admin_Main">
	<ul id="admin_mem">
		<li><img src="/resources/img/logo_w.png"></li>
		<li>관리자 모드로 들어 갈 수 있는 로그인페이지입니다.</li>
		<li>
			<form action="adminproc" method="post" id="adminproc">
				<input type="text" id="id" name ="id" placeholder="id">
				<input type="password" id="pw" name="pw" placeholder="password">
				<input type="submit">
			</form>
		</li>
	</ul>
	<iframe frameborder="0" width="120%" height="140%" src="https://www.youtube.com/embed/X6dJEAs0-Gk?start=1&end=20&autoplay=1&amp;mute=1&list=PLfEw4vp4frCccHGFdSMLt6zUJpaaojlK_" frameborder="0" allow="autoplay encrypted-media" allowfullscreen >
	</iframe>
</div>

