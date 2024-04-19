<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Insert title here</title>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
		<script src="/resources/js/admin/receipt.js"></script>
	</head>
	<body>
		<div id="outerheight">
			<div class ="admContactViewBtn">
				<button id="sendSns">메세지 보내기</button>
			</div>
			<div id="test" style="width:100%; background:#2f2f2f;">
				<jsp:include page="view_detail.jsp">
					<jsp:param name ="seq" value="${seq}"/>
				</jsp:include>
			</div>
		</div>
	</body>
</html>