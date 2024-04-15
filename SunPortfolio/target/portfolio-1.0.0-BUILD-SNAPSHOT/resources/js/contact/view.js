$(function(){
	$('.btn-write').on('click',function(){
		location.href = "/sub/contact/write";
	});
	
	$('#conModify').on('click',function(){
		var seq = $('#seq').text();
		var title = $('#title').text();
		var con = $('#con').text();
		location.href = "/sub/contact/conModify?seq="+seq+"&title="+title+"&content="+con;
	});
	
	$('#gotoList').on('click',function(){
		var cpage = 1;
		location.href = "/sub/contact/listProc?cpage="+cpage;
	});
	
	$('#conDelete').on('click',function(){
		var deleck = confirm("정말 삭제하시겠습니까?");
		var num = $('#seq').text();
		if(deleck){
			location.href="/sub/contact/conDelete?seq="+num;
		}		
	});
});