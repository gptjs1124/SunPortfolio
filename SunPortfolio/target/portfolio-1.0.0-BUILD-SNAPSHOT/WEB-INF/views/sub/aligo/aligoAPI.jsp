<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false"%>

<jsp:include page="../../inc/header.jsp" />
<script type="text/javascript" src="/resources/js/contact/list.js"></script>

<script>
	$(function(){
		$("#callAPI").on('click',function(){
			$.ajax({
				
			})
		});
	});
</script>

<article id="Aboutus" class="sub_cont">
	<div class="inner1400">
		<div class="tit_s1">
				<dl>
					<dt>알리고 테스트 페이지</dt>
					<dd>
						<span>히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛</span>
						<p>고객의 특징을 생각하여 디자인을 하는 디자이너 김혜선입니다. 레이아웃 / 구성 / 사진 / 타이포 등 고객이
							원하는 최상의 디자인을 만들어 드립니다.</p>
					</dd>
				</dl>
				<button id="callAPI" type="button">call API</button>
		</div>
	</div>

</article>
<jsp:include page="../../inc/fotter.jsp" />