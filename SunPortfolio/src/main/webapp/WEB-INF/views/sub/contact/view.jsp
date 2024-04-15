<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page session="false"%>

<jsp:include page="../../inc/header.jsp" />
<script type="text/javascript" src="/resources/js/contact/view.js"></script>
<article id="Aboutus" class="sub_cont">
	<div class="inner1400">

		<div class="tit_s1">
			<dl>
				<dt>view</dt>
				<dd>
					<span>히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛히힛</span>
					<p>고객의 특징을 생각하여 디자인을 하는 디자이너 김혜선입니다. 레이아웃 / 구성 / 사진 / 타이포 등 고객이
						원하는 최상의 디자인을 만들어 드립니다.</p>
				</dd>
			</dl>
		</div>

		<div class="contact">
			<div class="tit_au_c">Self-introduction</div>
			<div class="ab_con">
				<table>
						<tr>
							<th>번호</th>
							<td>
								${conview.seq}
							</td>
							<th>카테고리</th>
							<td>
								${conview.category}
							</td>
						</tr>
						<tr>
							<th colspan="2">제목</th>
							<td colspan="2">
								${conview.title}
							</td>
						</tr>
						<tr>
							<th>회사</th>
							<td>
								${conview.company}
							</td>
							<th>직급</th>
							<td>
								${conview.grade}
							</td>
						</tr>
						<tr>
							<th>이름</th>
							<td>
								${conview.name}
							</td>
							<th>전화번호</th>
							<td>
								${conview.tel}
							</td>
						</tr>
						<tr>
							<th colspan="2">상담내용</th>
							<td colspan="2">
								<span class="target2">${conview.content}</span>
							</td>
						</tr>
						<tr>
							<th colspan="2">첨부파일</th>
							<td colspan="2">
								<img src="/upload/contact/files/${conview.filename}" alt="이미지">								
							</td>
						</tr>
					</table>
				<div class="center send">
					<button type="button" id="gotoList">리스트로 돌아가기</button>
					<button type="button" id="conModify">수정하기</button>
					<button type="button" id="conDelete">삭제하기</button>
				</div>
			</div>
		</div>
	</div>

</article>
<jsp:include page="../../inc/fotter.jsp" />
