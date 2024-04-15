$(document).ready(function(){
	init();

	$(window).on("load", function () {
		var doc_width = $(window).width(); // 문서 로드될 때 문서 넓이 감지
		hdlr_switch(doc_width);
	});

	$(window).resize(function(){
		var doc_width = $(window).width(); // 리사이즈 될 때 문서 넓이 감지
		hdlr_switch(doc_width);
	});

/*
	// gnb복사 lnb 붙여넣기
	for (var i = 1; i <= 10; i++) {
		$(".gnb .menu"+i).clone().appendTo("#lnb.sm"+i+" .menu_li");
	};	
*/

	// menu click
	$menu_btn.click(function(){
		nav_slide(0);
	});

	$nav.find(".close_btn").click(function(){
		nav_slide(-400);
	});

	function nav_slide(num){
		$nav.stop().animate({
			right:num
		});		
	};


	var pathName = location.pathname;
	function isNotEmpty(value){
		// 배열 공백제거 함수
	  return value != "";
	}
	if ( pathName.split("/").filter(isNotEmpty).length <= 1){
		//메인
		//$("#subWrap").remove();
	}else{
		//서브
		$("footer").addClass("sub_f");
		$(".sub_cont").wrap("<section id='subContents'></section>")
		$("#subContents").wrap("<section id='subWrap'></section>")
	};

});

function init(){
	$menu_btn = $(".menu_btn");
	$nav = $("nav");
	$header = $("header");
};


function initEvent_pc(val){
	console.log(val);
};




/*
	모바일 함수 
*/
function initEvent_m(val){

};


function hdlr_switch(val) {
	if (val > 1200) {
		console.log("pc");
		initEvent_pc(val);
	} else {
		console.log("mobile");
		initEvent_m(val);
	};
};

function autoHeightAnimate(element, time){
  var curHeight = element.height(), // Get Default Height
  autoHeight = element.css('height', 'auto').height(); // Get Auto Height
  element.height(curHeight); // Reset to Default Height
  element.stop().animate({ height: autoHeight }, time); // Animate to Auto Height
}



