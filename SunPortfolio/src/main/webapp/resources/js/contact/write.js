$(function(){

	$('#sendAligo').on('click', function(){
		location.href="/aligo/aligoAPI";
	});

	$('#sub_btn').on('click',function(){
		let result = confirm('보내기 버튼을 눌렀을 때, 수정이 불가능 합니다. 입력하신 정보가 맞는지 확인해주세요.');

		//카테고리 항목 배열로 만들어서 넣기
		let categoryArr = [];

		let categorySelecter = $(".category_con");
		if(categorySelecter.length < 0){
			alert("카테고리를 선택해주세요.");
			return false;
		}
		for(let i = 0; i < categorySelecter.length; i++){
			let cmnsCd = categorySelecter[i].dataset.cmnscd;
			categoryArr.push(cmnsCd);
		}

		$("#categoryArr").val(categoryArr);

		if(result == true){
			// 데이터를 다 썼는지 확인하는 로직 짜야함.
			var one = $("#one");
			var title = $("#title");
			var company = $("#company");
			var grade = $("#grade");
			var name = $("#name");
			var selTel = $("#selTel");
			var phone01 = $("#phone01");
			var phone02 = $("#phone02");
			var content = $("#content");

			if(!title.val() || !company.val() || !grade.val()
					|| !name.val() || !selTel.val() || !phone01.val() || !phone02.val() || !content.val()){
				if(!title.val()){
					alert("제목을 작성해주세요.");
					title.focus();
				}else if(!company.val()){
					alert("회사를 작성해주세요.");
					company.focus();
				}else if(!grade.val()){
					alert("직급을 작성해주세요.");
					grade.focus();
				}else if(!name.val()){
					alert("이름을 작성해주세요.");
					name.focus();
				}else if(!selTel.val()){
					alert("전화번호를 설정해주세요.");
					selTel.focus();
				}else if(!phone01.val()){
					alert("전화번호를 작성해주세요.");
					phone01.focus();
				}else if(!phone02.val()){
					alert("전화번호를 작성해주세요.");
					phone02.focus();
				}else if(!content.val()){
					alert("상담내용을 작성해주세요.");
					content.focus();
				}
				return false;
			}

		}else{
			return false;
		}

	});

});
