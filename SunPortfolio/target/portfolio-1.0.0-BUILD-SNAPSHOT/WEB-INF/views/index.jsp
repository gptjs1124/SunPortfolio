<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page session="false" %>
<jsp:include page="inc/header.jsp"/>

<script src="/resources/js/main.js"></script>
<style>html, body { height:100%;  overflow:hidden;}</style>

<div class="full_b" id="main">
	<input value="${result}" type="hidden" id="contactPop">
	<div class="bg">
		<img src="/resources/img/main/index_img_01_b.jpg" alt="">
	</div>
	<section id="mainVisual">
		<div class="visu">
			<article class="item" onClick="location.href='http://www.ourhomecatering.com/'">
				<div class="img"><img src="/resources/img/main/index_img_01_s.jpg" alt="" data-b="/resources/img/main/index_img_01_b.jpg"></div>
				<div class="txt_box">
					<div class="tit">Ourhome</div>
					<div class="cate"><p>Landing Page Design</p></div>
				</div>
			</article>
			<article class="item" onClick="location.href='http://everymonday.webmoa21.co.kr/ko/'">
				<div class="img"><img src="/resources/img/main/index_img_02_s.jpg" alt="" data-b="/resources/img/main/index_img_02_b.jpg"></div>
				<div class="txt_box">
					<div class="tit">Everymonday</div>
					<div class="cate"><p>All Design</p></div>
				</div>
			</article>
			<article class="item" onClick="location.href='http://chateng.webmoa21.co.kr/'">
				<div class="img"><img src="/resources/img/main/index_img_03_s.jpg" alt="" data-b="/resources/img/main/index_img_03_b.jpg"></div>
				<div class="txt_box">
					<div class="tit">ChatENG</div>
					<div class="cate"><p>All Design</p></div>
				</div>
			</article>
			<article class="item" onClick="location.href='http://sunshine1124.com/2019/sub/portfolio/mirun.html'">
				<div class="img"><img src="/resources/img/main/index_img_04_s.jpg" alt="" data-b="/resources/img/main/index_img_04_b.jpg"></div>
				<div class="txt_box">
					<div class="tit">Mirunseoul</div>
					<div class="cate"><p>Sub Design</p></div>
				</div>
			</article>
			<article class="item"  onClick="location.href='http://bookhi.webmoa21.co.kr/index.asp'">
				<div class="img"><img src="/resources/img/main/index_img_05_s.jpg" alt="" data-b="/resources/img/main/index_img_05_b.jpg"></div>
				<div class="txt_box">
					<div class="tit">책인사</div>
					<div class="cate"><p>All Design</p></div>
				</div>
			</article>
		</div>
		<div class="prev_next_btn" >
			<div class="inner1500">
				<button type="button" class="prev"></button>
				<button type="button" class="next"></button>
			</div>
		</div>
	</section>
	<div class="dots_pager">
		<div class="inner1800">
			<div class="dots">
				<ul>
					
				</ul>
			</div>
			<div class="pager">
				<p class="current">01</p>
				<p>/</p>
				<p class="total"></p>
			</div>
		</div>
	</div>
</div>

<div id ="layerPOP">
	<div>
		<dl>
			<dt class="title">
				<span class="popLogo">
					<img src="/resources/img/logo_b.png" alt="로고">
				</span>
				문의가 정상적으로 접수 되었습니다.
			</dt>
			<dd>
				요청하신 문의는 2~3일 안으로<br>이메일과 핸드폰으로 연락드리겠습니다.
			</dd>
		</dl>
		<span class="x">
			<img src="/resources/img/x_b.png" alt="x">
		</span>
	</div>
</div>

<jsp:include page="inc/fotter.jsp"/>
