/**
 * 접수 상세페이지 
 */
$(document).ready(function(){
	//컨텐트 높이값 변동 되게 가져옴.
	var tabHeight = $('#outerheight').outerHeight(true); 
	parent.heightChange(tabHeight);
	
	//탭변경에 따른 컨텐트 높이값 변동 되게 가져옴.
	$('ul.tabs li').click(function(){
		var tab_id = $(this).attr('data-tab');

		$('ul.tabs li').removeClass('current');
		$('.tab-content').removeClass('current');
		
		$(this).addClass('current');
		$("#"+tab_id).addClass('current');
		
		//컨텐트 높이값 변동 되게 가져옴.
		var tabHeight = $('#outerheight').outerHeight(true); 
		parent.heightChange(tabHeight);
	});
	
	$('#sendSns').click(function(){
		//location.href = "../aligo/adminContactListProc?cpage=1";		
	});
	
	$('#save').click(function(){
		$.ajax({
			type : "post",
			url : "/admin/receiptSave",
			data : {
				seq : $('#seq').val(),
				category : $('#category').val(),
				title : $('#title').val(),
				company : $('#company').val(),
				grade : $('#grade').val(),
				name : $('#name').val(),
				tel : $('#tel').val(),
				content : $('#content').val()
			}
		}).done(function(resp) {
			if (resp > 0) {
				alert("수정이 완료 되었습니다.");
				location.reload();
			}else{
				alert("수정이 실패하였습니다.");
			}
		}).fail(function(error1, error2){
			alert("관리자에게 문의 주세요.");
		});
	});
	
	/* 첨부파일 다운로드 */
	$("#download_chmbu").click(function(){
		$.ajax({
			type : "post",
			url : "/fileController/fileOutputStream",
			data : {
				seq : $('#seq').val(),
				category : $('#category').val(),
				title : $('#title').val()
			}
		}).done(function(resp){
			alert("첨부파일 다운로드가 성공하였습니다.");
			
		}).fail(function(error1, error2){
			alert("첨부파일 다운로드에 실패하였습니다.");
		});
	});
	
	/* comment저장버튼 클릭시 */
	$("#commentSaveBtn").click(function(){
		$.ajax({
			type : "post",
			url : "/admin/commentInsert",
			data : {
				sunportfolioSeq : $('#sunportfolioSeq').val(),
				name : $('#name').val(),
				commentText : $('#commentText').val()				
			}
		}).done(function(resp){
			if(resp>0){
				alert("저장 완료했습니다.");
				location.reload();
			}else {
				alert("저장이 실패하였습니다.");
			}
		}).fail(function(erro1, error2){
			alert("저장 중 에러가 났습니다.");
		});
	});
	
	/* 코멘트 수정하기 */
	$(".commentModify").click(function(){
		
	});
	
	/* 코멘트 수정하기 */
	$(".commentDelete").click(function(){
		$.ajax({
			type : "post",
			url : "/admin/commentDelete",
			data : {
				seq : $(this).closest(".commentLi").find("#seq").val(),
				sunportfolioSeq : $(this).closest(".commentLi").find("#sunportfolioSeq").val()
			}
		}).done(function(resp){
			alert(resp);
			location.reload();
		}).fail(function(erro1,erro2){
			alert(erro1);
		});
	});
		
});






















