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
			var chkAnswer = $("#chkAnswer");

			if(!chkAnswer.length){
				alert("자동등록방지를 수행해주세요.");
				return false;
			}

			if(!title.val() || !company.val() || !grade.val()
					|| !name.val() || !selTel.val() || !phone01.val() || !phone02.val() || !content.val() || !chkAnswer.val()){
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
				}else if (chkAnswer.val() != '200'){
					alert("자동등록방지를 수행해주세요.");
					$("#answer").focus();
				}
				return false;
			}

		}else{
			return false;
		}

	});
});


/**
 * 자동입력 방지문자 새로고침
 */
window.onload = function(){
	getImage();	// 이미지 가져오기

	document.querySelector('#check').addEventListener('click', function(){
		var params = {answer : document.getElementById("answer").value};
		$.ajax({
			type : "post",
			url : '/sub/contact/chkAnswer.do',
			data : params
			//data : jsonData
		}).done( function(returnData){
			if(returnData == 200){
				alert('입력값이 일치합니다.');

				// 성공 코드
				let answer = "<input type='hidden' id='chkAnswer' value='"+ returnData +"'>"
				$("#captch").append(answer);

			}else{
				alert('입력값이 일치하지 않습니다.');
				getImage();
				document.querySelector('#answer').setAttribute('value', '');
			}
		}).fail(function(returnData){
			alert(returnData + "<br/> 자동입력 방지문자 프로세스 진행 중 오류가 발생했습니다.");
		});
	});
}
/*매번 랜덤값을 파라미터로 전달하는 이유 : IE의 경우 매번 다른 임의 값을 전달하지 않으면 '새로고침' 클릭해도 정상 호출되지 않아 이미지가 변경되지 않는 문제가 발생된다*/
function audio(){
	var rand = Math.random();
	var uAgent = navigator.userAgent;
	var soundUrl = '/sub/contact/captchaAudio.do?rand='+rand;
	if(uAgent.indexOf('Trident')>-1 || uAgent.indexOf('MISE')>-1){	/*IE 경우 */
		audioPlayer(soundUrl);
	}else if(!!document.createElement('audio').canPlayType){ /*Chrome 경우 */
		try {
			new Audio(soundUrl).play();
		} catch (e) {
			audioPlayer(soundUrl);
		}
	}else{
		window.open(soundUrl,'','width=1,height=1');
	}
}
function getImage(){
	var rand = Math.random();
	var url = '/sub/contact/captchaImg.do?rand='+rand;
	//document.querySelector('img').setAttribute('src', url); captchaImg
	document.querySelector('#captchaImg').setAttribute('src', url);
}
function audioPlayer(objUrl){
	document.querySelector('#ccaudio').innerHTML = '<bgsoun src="' +objUrl +'">';
}