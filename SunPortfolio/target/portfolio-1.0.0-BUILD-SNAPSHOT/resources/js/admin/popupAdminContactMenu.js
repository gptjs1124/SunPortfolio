
//popup 메뉴 수정 제출 버튼 클릭 시
function sendPop(){
    let checkObjectSend = new Object();
    let num = 0;
    let seq = $("#seq").val();
    $('input:checked').each(function(){
        let checkObject = new Object();
        let getName = $(this).val();
        checkObject["cmns_cd"] = getName;
        checkObject["seq"] = seq;
        checkObjectSend["num_"+num] = checkObject;
        num++;
    })

    //checkedValues  배열을 JSON 문자열로 변환
    let jsonData = JSON.stringify(checkObjectSend);

    $.ajax({
        type:'POST',
        url:"/admin/deleteInsertChooseMenu",
        contentType:'application/json; charset=UTF-8',
        data: jsonData
    }).done(function(resp){
        closePop();
        let htmlCode = "";
        for(let i = 0; i <resp.length; i++){
            htmlCode += `<span class="category_con" data-cmnsCd="${resp[i].cmns_cd}" data-categprymenuseq="${resp[i].categprymenuseq}">${resp[i].cmns_cd_nm}<button class="category_delete">x</button></span>`;
        }

        $('#category_area').empty();
        $('#category_area').append(htmlCode);

        alert("저장되었습니다.");

    }).fail(function(erro1){
        alert("실패");
        console.log(erro1);
    });
}

$(document).ready(function(){
    $('.popupTitle').text("카테고리 수정");
    //카테고리 삭제
    $(document).on('click', ".category_delete",function(){
        //$(".category_delete").on('click', function(){
        alert("x버튼 누른 것");
        let target = this;
        let categprymenuseq = target.parentElement.getAttribute('data-categprymenuseq');
        let seq = $("#seq").val();
        let htmlCode = '';

        $.ajax({
            type : "post",
            url : "/admin/deleteChooseMenu",
            data : {
                seq : seq,
                categprymenuseq : categprymenuseq
            }
        }).done(function(resp){
            for(let i = 0; i <resp.length; i++){
                htmlCode += "<span class='category_checkbox'>";
                htmlCode += `<span class="category_con" data-cmnsCd="${resp[i].cmns_cd}" data-categprymenuseq="${resp[i].categprymenuseq}">${resp[i].cmns_cd_nm}<button class="category_delete">x</button></span>`;
                htmlCode += "</span>";
            }

            $('#category_area').empty();
            $('#category_area').append(htmlCode);

            alert("삭제되었습니다.");

        }).fail(function(erro1){
            alert(erro1);
        });
    });
})