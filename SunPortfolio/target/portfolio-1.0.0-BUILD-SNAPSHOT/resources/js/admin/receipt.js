/**
 * 접수 상세페이지 
 */
$(document).ready(function(){
	
	$(".modifyShowBtn").css("display", "none");
	$(".modifyHiddenBtn").css("diplay","inline-block");
	$(".comment .commentTextModify").css("display", "none");
	
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
				seq : $('#sunportfolioSeq_comment').val(),
				user_idntf_id : $('#name').val(),
				comment_text : $('#commentText').val()
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
	$(".commentModify").on('click',function(){
		let target = this;
		console.log(target);
		let comment = target.closest('div');
		comment.parentElement.children[0].style['display'] = 'none'; //commentText
		comment.parentElement.children[1].style['display'] = 'inline-block'; //commentTextModify
		comment.parentElement.children[2].children[0].style['display'] = 'none'; //commenBtn  modifyHiddenBtn
		comment.parentElement.children[2].children[1].style['display'] = 'inline-block'; //commenBtn  modifyShowBtn
	});
	
	/* 코멘트 수정 클릭 후 취소 누를 때 */
	$(".commentCancel").on('click',function(){
		let target = this;
		console.log(target);
		let comment = target.closest('div');
		comment.parentElement.children[0].style['display'] = 'inline-block'; //commentText
		comment.parentElement.children[1].style['display'] = 'none'; //commentTextModify
		comment.parentElement.children[2].children[0].style['display'] = 'inline-block'; //commenBtn  modifyHiddenBtn
		comment.parentElement.children[2].children[1].style['display'] = 'none'; //commenBtn  modifyShowBtn
		
	});
	
	/* 코멘트 삭제하기 */
	$(".commentDelete").click(function(){
		$.ajax({
			type : "post",
			url : "/admin/commentDelete",
			data : {
				comment_seq : $(this).closest(".commentLi").find("#comment_seq").val(),
				seq : $(this).closest(".commentLi").find("#seq").val()
			}
		}).done(function(resp){
			alert(resp);
			location.reload();
		}).fail(function(erro1, erro2){
			alert(erro1);
		});
	});
	
	/*코멘트 수정항목 저장하기 */
	$(".commentSave").click(function(){
		$.ajax({
			type : "post",
			url : "/admin/commentUpdate",
			data : {
				comment_seq : $(this).closest(".commentLi").find("#comment_seq").val(),
				seq : $(this).closest(".commentLi").find("#seq").val(),
				comment_text : $(this).closest(".commentLi").find("#commentTextModify").val()
			}
		}).done(function(resp){
			alert(resp);
			location.reload();
		}).fail(function(erro1,erro2){
			alert(erro1);
		});
	});
});