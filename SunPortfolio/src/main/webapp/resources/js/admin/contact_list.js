$(function(){
	//	
	$('.admin_tit_s1 ul li a').removeClass('current_tab1');
	let tab = $('.admin_tit_s1 ul li a');
	let tab_name = $('#tab_title').text();
	for(let i=0; i<tab.length; i++){
		let tab_href_add = $('.admin_tit_s1 ul li a').eq(i).attr("href");
		let split = tab_href_add.split("contact=");
		let tab_href_add_text = split[1];

		if(tab_href_add_text == tab_name)
		{			
			tab.eq(i).addClass('current_tab1');
			tab.eq(i).css({"color":"black"});
			break;			
		}
	}
	
	
	$('#progress').change(function(){
		var progress = $("#progress option:selected").val();
		
		$.ajax({
			type : "post",
			url : "/admin/progressCk",
			date : progress
		}).done(function(resp){
			alert("진행단계가 변경 되었습니다.");
			
		}).fail(function(error1, error2){
			alert("관리자에게 문의주세요");
		});
	});
	
	$('.StepIng').change(function(){
		var selectBoxVal1 = $(".StepIng option:selected").val();
		var seqNm = $(this).prev().val();

		$.ajax({
			type : "post",
			url : "/admin/contactChange",
			data : {
				'contact' : selectBoxVal1,
				'seq' : seqNm
			}
		}).done(function(resp){
			alert("진행상태가 변경되었습니다.");
			location.reload();
		}).fail(function(error1, error2){
			alert("진행상태 변경이 실패하였습니다.");
		});
	});
	
});
