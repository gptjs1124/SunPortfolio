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
		let cmnsCd = $(this).val();
		let contactstepseq = $(this).prev().val();
		let seq = $(this).prev().prev().val();

		$.ajax({
			type : "post",
			url : "/admin/updateStep",
			data : {
				'cmns_cd' : cmnsCd,
				'seq' : seq,
				'contactstepseq' : contactstepseq
			}
		}).done(function(resp){
			alert("진행상태가 변경되었습니다.");
			location.reload();
		}).fail(function(error1, error2){
			alert("진행상태 변경이 실패하였습니다.");
		});
	});
	
	
	//script 구문 내부에 해당 메소드를 입력합니다.
	$( "#startDate" ).datepicker({
		dateFormat : 'yy-mm-dd'
		,showOn: "both"
		,buttonImage: "/resources/img/calender_icon.png"
		,buttonImageOnly: true
		,buttonText: "선택" //버튼 호버 텍스트
		,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
		,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
		,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
		,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
		,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
		,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
		,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
		,onClose: function(){
			let startDate = $("#startDate").datepicker('getDate');
			let endDate = $("#endDate").datepicker('getDate');

			if(endDate != null){
				if(startDate > endDate){
						alert("기간을 다시 설정해주세요. 종료일로 설정됩니다.");
						$("#datepicker1").val($("#datepicker2").val());
				}
			}
		}
    });

	$( "#endDate" ).datepicker({
		dateFormat : 'yy-mm-dd'
		,showOn: "both"
		,buttonImage: "/resources/img/calender_icon.png"
		,buttonImageOnly: true
		,buttonText: "선택" //버튼 호버 텍스트
		,yearSuffix: "년" //달력의 년도 부분 뒤 텍스트
		,monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 텍스트
		,monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'] //달력의 월 부분 Tooltip
		,dayNamesMin: ['일','월','화','수','목','금','토'] //달력의 요일 텍스트
		,dayNames: ['일요일','월요일','화요일','수요일','목요일','금요일','토요일'] //달력의 요일 Tooltip
		,minDate: "-5Y" //최소 선택일자(-1D:하루전, -1M:한달전, -1Y:일년전)
		,maxDate: "+5y" //최대 선택일자(+1D:하루후, -1M:한달후, -1Y:일년후)
		,beforeShow: function(){
			let startDate = $("#startDate").datepicker('getDate');

			if(startDate != null){
				$(this).datepicker('option', 'minDate', startDate);
			}
		}
	});

	//contact 검색
	/*$("#contact_Search").on("click",function(){
		let cmns_cd_nm = $('#cmns_cd_nm').val();
		let title = $('#title').val();
		let content = $('#content').val();
		let startDate = $('#startDate').datepicker('getDate');
		let endDate = $('#endDate').datepicker('getDate');
		let company = $('#company').val();

		$.ajax({
			type : "post",
			url : "/admin/ContactListProc?cpage=1&cmns_cd_nm="+ cmns_cd_nm,
			data : {
				cmns_cd_nm : cmns_cd_nm,
				title : title,
				content : content,
				startDate : startDate,
				endDate : endDate,
				company : company
			}
		}).done(function(resp){

		}).fail(function(erro1){
			alert(erro1);
		});
	});*/


});
