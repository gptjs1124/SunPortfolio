/* 카테고리 분류 */
/*let depth1 = document.querySelector('#depth1');

for(let i = 0; i < depth1.length; i++){
	console.log(depth1[i].ctg_nm);
}*/

//선택한 option value값 가져오기
//window.onload : window 객체의 load 이벤트는 스타일, 이미지 등의 리소스들이 모두 로드되었을 때 실행 돼!
function changeDepth1(){
	let depth1Select = document.getElementById('depth1');
	let depth1SelectValue = depth1Select.options[depth1Select.selectedIndex].value;
	let depth2 = document.getElementById("depth2");
	
	//Depth02 option 초기화
	let depth2Option = document.querySelectorAll("#depth2 option");
	depth2Option.forEach(o => o.remove());
	
	//하위메뉴 가져오기.
	getDepth(depth2, depth1SelectValue);
}

function changeDepth2(){
	let depth2Select = document.getElementById("depth2");
	let depth2SelectValue = depth2Select.options[depth2Select.selectedIndex].value;
	let depth3 = document.getElementById("depth3");
	
	//Depth03 option 초기화
	let depth3Option = document.querySelectorAll("#depth3 option");
	depth3Option.forEach(o => o.remove());
	
	getDepth(depth3, depth2SelectValue);
}

function getDepth(depth, SelectValue){
	let depth_OptionAdd = "";
	depth.innerHTML += "<option>:::: 선택해주세요 ::::</option>" 

	let sendData = {
		"up_ctg_no" : SelectValue
	}
	
	$.ajax({
		type:"post",
		url : "getDepthList",
		data : sendData
	}).done(function(resp){
		console.log("resp   :: " +resp);
		let depth2_OptionAdd = "";
		for(let i = 0; i < resp.length; i++){
			depth_OptionAdd += "<option value="+ resp[i].ctg_no +">"+ resp[i].ctg_nm +"</option>" 
		};		
		
		depth.innerHTML += depth_OptionAdd;
		
	}).fail(function(error1, error2){		
		console.log(error1);
		console.log(error2);
	});
}



