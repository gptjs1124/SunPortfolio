<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<link rel="stylesheet" href="/resources/css/reset.css">
<link rel="stylesheet" href="/resources/css/admin.css">
<link rel="stylesheet" href="/resources/css/sub.css">
<link rel="stylesheet" href="/resources/css/popup.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>


<!-- 레이어팝업 -->
<div class="popup_layer" id="popup_layer" style="display: none;">
    <div class="popup_box">
        <div class="popup_X">
            <a href="javascript:closePop();">X</a>
        </div>

        <!--팝업 컨텐츠 영역-->
        <div class="popup_cont" id="popup_cont">
            <h3 class="popupTitle"></h3>
        </div>

        <!--팝업 버튼 영역-->
        <div class="popup_btn">
            <a onclick="sendPop()">제출</a>
        </div>
    </div>
</div>