
function openPop() {
	document.getElementById("popup_layer").style.display = "block";

	$('.category_con').each(function(){
		let cmns_cd = $(this).data('cmnscd');
		$(`input:checkbox[name=${cmns_cd}]`).prop('checked',true);
	});
}


//팝업 닫기
function closePop() {
	document.getElementById("popup_layer").style.display = "none";
}

function sendPop() {
	$('input:checked').each(function(){
		let cmndCd = $(this).val();
		let text = $(this).next().html();
		let htmlCode = `<span class="category_con" data-cmnscd="${cmndCd}">${text}`
			htmlCode += "<button type='button' class='selectCategoryDel'>x</button>"
			htmlCode += "</span>";
		$('#category_area').append(htmlCode);
	});

	closePop();
}

$(document).ready(function() {
	/* 카테고리 X버튼 클릭 시  */
	$('.selectCategoryDel').on("click", function(event){
		event.preventDefault(); //기본동작 막기
		$(this).parent().remove();
	});

	$('.popupTitle').text("카테고리");

	$.ajax({
			type : "post",
			url : "/admin/codeGroupSelect",
			data : {
				cmns_cd_group_id : "CODE_CM" // 다음에 빼기
			}
	}).done(function(resp){
		for(let i = 0; i < resp.length; i++){
			let htmlCode = '';
			let cmnsCd = resp[i].cmns_cd;

			$.ajax({
				type:"post",
				url : "/admin/codeSelect",
				data : {
					cmns_cd_group_id : "CODE_CM", // 다음에 빼기
					cmns_cd : cmnsCd
				}
			}).done(function(resp2){
				htmlCode += "<div class='mb20 " + resp[i].cmns_cd +"'>";
				htmlCode += "<h3 class='pb10'>" + resp[i].cmns_cd_nm + "</h3>";

				for(let j = 0; j < resp2.length; j++){
					htmlCode += "<span class='category_checkbox'>";
					htmlCode += "<input type='checkbox' name='"+ resp2[j].up_cmns_cd +"' id='ck_"+ resp2[j].cmns_cd +"' value='"+ resp2[j].cmns_cd +"'>";
					htmlCode += "<label for='ck_"+ resp2[j].cmns_cd +"'>"+ resp2[j].cmns_cd_nm +"</label>";
					htmlCode += "</span>";
				}
				htmlCode += "</table>";

				htmlCode += "</div>";

				$("#popup_cont").append(htmlCode);
				$(".CM_DV_VAL").css("display", "none");

			}).fail(function(erro1){
				alert(erro1);
			});
		}

	}).fail(function(erro1){
		alert(erro1);
	});

	// 체크박스가 변경될 때마다 실행되는 함수
	$(document).on("change", ".CM_DV input[type='checkbox']",function(){
		let ckDv_01= $("input:checkbox[id='ck_DV_01']").is(":checked");
		let ckDv_02= $("input:checkbox[id='ck_DV_02']").is(":checked");

		if($(this).is(":checked")){
			$(".CM_DV_VAL").css("display", "block");

		}else if(!(ckDv_01 || ckDv_02)){
			$(".CM_DV_VAL").css("display", "none");

			$("input:checkbox[name='CM_DV_VAL']").prop("checked", false);
		}
	});

});