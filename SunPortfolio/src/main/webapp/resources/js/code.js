$(document).ready(function() {
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
				htmlCode += "<div class='mb20'>";
				htmlCode += "<h3 class='pb10'>" + resp[i].cmns_cd_nm + "</h3>";

				for(let j = 0; j < resp2.length; j++){
					htmlCode += "<input type='checkbox' name='"+ resp2[j].up_cmns_cd +"' id='"+ resp2[j].cmns_cd +"' value='"+ resp2[j].cmns_cd +"'>";
					htmlCode += "<label for='"+ resp2[j].cmns_cd +"'>"+ resp2[j].cmns_cd_nm +"</label>";
				}

				htmlCode += "</div>";

				$("#popup_cont").append(htmlCode);

			}).fail(function(erro1){
				alert(erro1);
			});
		}

	}).fail(function(erro1){
		alert(erro1);
	});
});


