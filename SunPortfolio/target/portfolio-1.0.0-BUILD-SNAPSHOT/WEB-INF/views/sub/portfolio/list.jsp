<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page session="false"%>
<jsp:include page="../../inc/header.jsp" />

<script type="text/javascript" src="/resources/js/pt/pt.js"></script>
<article id="portfolio" class="sub_cont">
	<div class="inner1400">

		<div class="tit_s1">
			<dl>
				<dt>Portfolio</dt>
				<dd>
					<span>The real target for designers is the client of the
						client, not the client.</span>
					<p>
						클라이언트의 니즈가 빠지며 고객의 편리함이 결여되면 디자인이 아무리 예쁘고 독특하다 할 지라도 사용자는 홈페이지를 바로
						닫아버리기 때문입니다. <br />클라이언트의 클라이언트가 접하기 쉬운 홈페이지를 만드는 것이 저의 목표입니다.
					</p>
				</dd>
			</dl>
			
			<!-- 카테고리 분류 -->
			<div id="portfolio_category">
				<select id="depth1" onchange="changeDepth1()">
					<option>::: 선택하세요 :::</option>
					<c:forEach var="depth" items ="${depth1}">
						<option value="${depth.ctg_no}">${depth.ctg_nm}</option>
					</c:forEach>
				</select>
				<select id="depth2" onchange="changeDepth2()">
					<option>:::: 선택해주세요 ::::</option>
				</select>
				<select id="depth3">
					<option>:::: 선택해주세요 ::::</option>
				</select>
			</div>
		</div>
		
		<div class="list_s1">
			<ul class="s1">
				<li><a href="/sub/portfolio/ourhome">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img01.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								즐거운 요리가<br /> 가득한 행복한 집
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
				<li><a href="/sub/portfolio/everymonday">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img02.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								다양한 디자인의<br/ >팩토리엄,<br/ >에브리먼데이
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
			</ul>
		</div>
		<div class="list_s4">
			<ul class="s1">
				<li><a href="/sub/portfolio/b">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img07.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								임상시험종사자<br/ >커뮤니티 & 채용공간
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
				<li><a href="/sub/portfolio/smartel">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img08.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								똑똑한 소비자의 선택,<br/ >스마텔
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
				<li><a href="/sub/portfolio/ebara">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img09.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								반도체 장비의 선두주자,<br/ >한국에바라정밀
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
			</ul>
		</div>

		<div class="list_s1">
			<ul class="s1">
				<li><a href="/sub/portfolio/openend">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img06.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								장소의 잠재력을<br/ >극대화 해주는 열린공간
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
			</ul>
		</div>

		<div class="list_s2">
			<ul class="s1">
				<li><a href="/sub/portfolio/bookhi">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img03.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								미국 교실 그대로,<br/ >온라인 화상영어
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
				<li><a href="/sub/portfolio/mirun">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img04.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								아디다스 주최 마라톤 대회<br/ >마이런
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
				<li><a href="/sub/portfolio/bookhi">
						<div class="img">
							<img src="/resources/img/sub/portfolio_img05.jpg" alt="" />
						</div>
						<div class="txt">
							<p>
								사람과 사람을 이어주는<br/ >스토리의 힘
							</p>
							<div class="more_s1"></div>
						</div>
				</a></li>
			</ul>
		</div>

	</div>
</article>
<jsp:include page="../../inc/fotter.jsp" />