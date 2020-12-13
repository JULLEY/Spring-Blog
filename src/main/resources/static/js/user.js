let index = {
    init : function(){
        $("#btn-save").on("click", ()=>{    // function(){} , ()=>{} 사용 이유는 this를 바인딩하기위해서
            this.save();
        });
        $("#btn-login").on("click", ()=>{    // function(){} , ()=>{} 사용 이유는 this를 바인딩하기위해서
            this.login();
        });
    },
    save : function(){
        // alert("save함수 호출 TEST");
        let data = {
            username : $("#username").val(),
            password : $("#password").val(),
            email : $("#email").val(),
        }

        // console.log(data)
        // AJAX 통신을 이용해서 3개의 파라미터를 JSON으로 변경하여 INSERT요청
        // ajax 호출시 default가 비동기 호출
        $.ajax({
            type: "POST",
            url: "/auth/joinProc",
            data: JSON.stringify(data), // http body
            contentType: "application/json; charset=utf-8", // body데이터 타입
            dataType: "json"    // 요청에 대한 서버의 응답이 왔을때 기본적으로 모든것이 문자열인데 JSON처럼 생겼으면 => javascript object로바꿔준다
        }).done(function (res) {
            alert("회원가입이 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }

    /*  시큐리티 사용으로 주석
    ,login : function(){
        // alert("save함수 호출 TEST");
        let data = {
            username : $("#username").val(),
            password : $("#password").val(),
        }

        $.ajax({
            type: "POST",
            url: "/api/user/login",
            data: JSON.stringify(data), // http body
            contentType: "application/json; charset=utf-8", // body데이터 타입
            dataType: "json"    // 요청에 대한 서버의 응답이 왔을때 기본적으로 모든것이 문자열인데 JSON처럼 생겼으면 => javascript object로바꿔준다
        }).done(function (res) {
            alert("로그인이이 완료되었습니다.");
            location.href = "/";
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
    */
}

index.init();