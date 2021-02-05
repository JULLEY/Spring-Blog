let index = {
    init : function(){
        $("#btn-save").on("click", ()=>{
            this.save();
        });
    },
    save : function(){
        // alert("save함수 호출 TEST");
        let data = {
            title : $("#title").val(),
            content : $("#content").val()
        }

        $.ajax({
            type: "POST",
            url: "/api/board",
            data: JSON.stringify(data), // http body
            contentType: "application/json; charset=utf-8", // body데이터 타입
            dataType: "json"    // 요청에 대한 서버의 응답이 왔을때 기본적으로 모든것이 문자열인데 JSON처럼 생겼으면 => javascript object로바꿔준다
        }).done(function (res) {
            alert("글쓰기가 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
}

index.init();