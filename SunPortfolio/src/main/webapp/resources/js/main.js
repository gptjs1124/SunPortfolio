$(function(){
	
	// 메인페이지 full
	var win_h = $(window).height();
	var mainVisual = $("#mainVisual");
	var dots_pager = $(".dots_pager");
	var item_len = mainVisual.find(".item").length;
		
		main_h(win_h);
	$(window).resize(function(){
		win_h = $(window).height();
		main_h(win_h);
	});

	function main_h(win_h){
		$("#main").css({
			height:win_h
		});
		
	};

	// 메인페이지 비주얼 갯수에 따른 dot 자동생성
	for (var i=1; i<=item_len; i++){
		dots_pager.find(".dots ul").append('<li><button type="button"></button></li>')
	};
	dots_pager.find("li:eq(0)").addClass("on");

	//메인 비주얼 전체 갯수
	dots_pager.find(".total").text("0"+item_len);
	

	mainVisual.find('.visu').slick({
		centerMode: true,
		infinite: true,
		swipe:false,
		autoplay:false,
		centerPadding: '60px',
		arrows:false,
		slidesToShow:4,
		autoplaySpeed: 7000,
		speed:1000,
		variableWidth: true,
		responsive: [
			{
				breakpoint: 1201,
				settings: {
					slidesToShow:1,
				}
			},
		]
	});
	

	var prev_next_btn = $(".prev_next_btn");

	prev_next_btn.find(".prev").click(function(){
		mainVisual.find('.visu').slick("slickPrev");
	});

	prev_next_btn.find(".next").click(function(){
		mainVisual.find('.visu').slick("slickNext");
	});


	mainVisual.find('.visu').on('beforeChange', function(event, slick, currentSlide, nextSlide) {
		var num = nextSlide+1;
		//var img_on = mainVisual.find(".slick-current + div img").data("b");
		
		//$("#main .bg img").attr("src",img_on);
		dots_pager.find("li").removeClass("on");
		dots_pager.find("li:eq("+nextSlide+")").addClass("on");
		dots_pager.find(".current").text("0"+num);
	});	

	dots_pager.find("li").click(function(){
		var obj = $(this);
		var slideIndex = obj.index();
		obj.siblings().removeClass("on");
		obj.addClass("on");
		mainVisual.find('.visu').slick('slickGoTo', slideIndex, false);
	});

	mainVisual.find('.visu .item').mouseenter(function(){
		var img_on = $(this).find("img").data("b");
		$("#main .bg img").stop().fadeIn();
		$("#main .bg img").attr("src",img_on);
	}).mouseleave(function(){
		$("#main .bg img").stop().fadeOut();
	});
	
	
	//write페이지에서 메인페이지로 갔을 때 레이어팝업 작업
	var contactPop = $("#contactPop").val();
	var layerPOP = $("#layerPOP");
	var layerPOP_x = $("#layerPOP").find(".x");
	if(contactPop != ""){
		layerPOP.css('display','block');
		layerPOP_x.click(function(){
			layerPOP.css('display','none');
		});
	}

});