<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:requestEncoding value="utf-8"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<meta charset="UTF-8">
<title>회원가입</title>
  <link href="/resources/NiceAdmin/assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Oleo+Script&display=swap" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/css/style.css" rel="stylesheet">
  <link rel="stylesheet" href="//code.jquery.com/ui/1.11.4/themes/smoothness/jquery-ui.css">
  <script src="/resources/assets/js/jquery-3.6.0.js"></script>
  <script src="/resources/assets/js/jquery-ui.js"></script>
<style>
	td{text-align:center;}
	label{
		padding-top: 15px;
	}
	#id_valid_feedback{
		margin-left: 15px;
	}
	#logo {
	    display: inline-block;
	}
	#logo h1 {
        background: #444;
        color: #fff;
        border-radius: 6px;
        font-family: 'Oleo Script', serif;
        font-weight: 400;
        padding: 0.25em 0.2em 0.25em 0.2em;
        font-size: 3.25em;
        letter-spacing: 0.05em;
        display: inline-block;
        vertical-align: middle;
    }
    #logo span {
        font-weight: 800;
        line-height: 4.5em;
        letter-spacing: 0.025em;
        font-size: 0.9em;
        vertical-align: middle;
        margin: 0 0 0 1.25em;
    }
    h1 a {
        color: inherit;
        text-decoration: none;
        outline: 0;
    }

    .btn-area {
        margin-top: 2em;
        margin-bottom: 1em;
    }
</style>
</head>

<body>

<main>
	<div class="container">
		<section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
			<div class="container">
				<div class="row justify-content-center">
					<div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
						<div class="d-flex justify-content-center py-4">
							<div id="logo">
                                <h1><a href="/login">DS</a></h1>
                                <span>Developer Space</span>
                            </div>
						</div><!-- End Logo -->
						<div class="card mb-3">
							<div class="card-body">
								<div class="pt-4 pb-2">
									<h5 class="card-title text-center pb-0 fs-4" style="font-weight:bold;">회원가입</h5>
									<p class="text-center small">회원정보를 입력하세요</p>
								</div>
								<form id="join_frm" name="join_frm" method="post" style="width:500px;">
								<input type="hidden" name="userEmail" value="" />
							  		<div class="col-12">
								  		<label for="userId" class="form-label">아이디</label>
									    <input id="userId" name="userId" class="form-control mr-sm-2" placeholder="아이디" /><br>
									    <button id="id_valid_btn" class="btn btn-primary w-30" type="button" style="float:right;" onClick="jsRegisterIdCheck();">중복체크</button><span id="id_valid_feedback"></span>
									    <input id="id_valid_result" type="hidden" value=""/>
								    </div>

								    <div class="col-12">
                                        <label for="userName" class="form-label">이름</label>
                                        <input id="userName" name="userName" class="form-control mr-sm-2" placeholder="이름을 입력해주세요" />
                                    </div>

                                    <div class="col-12">
                                        <label for="userNickName" class="form-label">닉네임</label>
                                        <input type="text" id="userNickName" name="userNickName" class="form-control mr-sm-2" placeholder="닉네임을 입력해주세요" />
                                    </div>

								    <div class="col-12">
									    <label for="userPwd" class="form-label">비밀번호</label>
									    <input type="password" id="userPwd" name="userPwd" class="form-control mr-sm-2" placeholder="비밀번호를 입력해주세요" />
								    </div>

								    <div class="col-12">
									    <label for="userPwd_re" class="form-label">비밀번호 확인</label>
									    <input type="password" id="userPwd_re" class="form-control mr-sm-2" placeholder="비밀번호 확인을 입력해주세요" />
									    <span id="pw_corr_feedback"></span><br>
									    <input id="pw_corr_result" type="hidden" value=""/>
								    </div>

                                    <div class="col-12">
                                        <label for="userAge" class="form-label">생년월일</label>
                                        <input type="text" id="userAge" name="userAge" class="form-control mr-sm-2" placeholder="생년월일을 선택해주세요" />
                                    </div>

                                    <div class="col-12">
                                        <div class="row">
                                            <label for="userEmailId" class="form-label">이메일</label>
                                            <div class="col-5">
                                                <input type="text" id="userEmailId" class="form-control mr-sm-2" placeholder="이메일을 입력해주세요" />
                                            </div>@
                                            <div class="col-6">
                                                <select id="userEmailAddr" class="form-control" onChange="jsSelect();">
                                                    <option value="none">선택하시오</option>
                                                    <option value="naver.com">naver.com</option>
                                                    <option value="hanmail.net">hanmail.net</option>
                                                    <option value="google.com">google.com</option>
                                                    <option value="custom">직접입력</option>
                                                </select>
                                            </div>
                                        </div>
                                    </div>
                                    <div id="custom_email" class="col-12" style="display: none;">
                                        <div class="row">
                                            <div class="col-5">
                                            </div>
                                            <div class="col-6" style="margin-left: 1em; margin-top: 1em;">
                                                <input class="form-control" type="text" id="email_custom" />
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-12">
                                        <label for="userGender" class="form-label">성별</label><br />
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="userGender" name="userGender" value="01" checked />남
                                        </div>
                                        <div class="form-check">
                                            <input type="radio" class="form-check-input" id="userGender" name="userGender" value="02" />여
                                        </div>
                                    </div>
								    <div class="col-12">
                                        <label for="userPhone" class="form-label">연락처</label>
                                        <input type="text" id="userPhone" name="userPhone" class="form-control mr-sm-2" placeholder="ex) 01012341234" />
                                    </div>

							    	<div class="btn-area col-12">
							    	    <button class="btn btn-primary w-100" id="join_btn" type="button" >가입하기</button>
							    	</div>

									<div style="float:right;">이미 회원이신가요?
									    <a href="/login" style="text-align:center;margin-top:30px; text-decoration : underline;">로그인</a>
									</div>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</section>
	</div>
</main>
<!-- Vendor JS Files -->
<script src="/resources/NiceAdmin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="/resources/NiceAdmin/assets/vendor/echarts/echarts.min.js"></script>
<script src="/resources/NiceAdmin/assets/vendor/tinymce/tinymce.min.js"></script>

<!-- Template Main JS File -->
<script src="/resources/NiceAdmin/assets/js/main.js"></script>

<script>
    $.datepicker.setDefaults({
        dateFormat: 'yymmdd',
        changeMonth: true,
        changeYear: true,
        closeText: '닫기',
        prevText: '이전 달',
        nextText: '다음 달',
        monthNames: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        monthNamesShort: ['1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월'],
        dayNames: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesShort: ['일', '월', '화', '수', '목', '금', '토'],
        dayNamesMin: ['일', '월', '화', '수', '목', '금', '토'],
        showMonthAfterYear: true,
        yearSuffix: '년',
        yearRange: 'c-99:c+99'
    });

    $(document).ready(function() {
        $("#userAge").datepicker();

        $("#join_btn").on('click', function(){
            jsRegisterEmailSet();

            const frm = $('form[name="join_frm"]');

            const id = frm.find('input[name="userId"]').val();
            const password = frm.find('input[name="userPwd"]').val();
            const name = frm.find('input[name="userName"]').val();
            const nickname = frm.find('input[name="userNickName"]').val();
            const email = frm.find('input[name="userEmail"]').val();
            const gender = frm.find('input[name="userGender"]:checked').val();
            const phone = frm.find('input[name="userPhone"]').val();
            const age = frm.find('input[name="userAge"]').val();

            if( id == '' || password == '' || name == '' || nickname == '' || email == '' || gender == '' || phone == '' || age == '' ) {
                alert('필수항목을 모두 입력해주세요');
                return false;
            } else if( $("#id_valid_result").val() != 'ok' ) {
                alert('아이디 중복체크를 해주세요');
                return false;
            } else {
                jsRegisterAdd();
            }
        });

        $("#userPwd_re").on('keyup', function(){
            if( $("#userPwd").val() != $("#userPwd_re").val() ) {
                $("#pw_corr_feedback").css("color", "red");
                $("#pw_corr_feedback").html("비밀번호가 일치하지 않습니다.");
                $("#pw_corr_result").val("fail");
            } else {
                $("#pw_corr_feedback").css("color", "green");
                $("#pw_corr_feedback").html("비밀번호가 일치합니다.");
                $("#pw_corr_result").val("ok");
            }
        });

    });

    function jsSelect() {
        const selectVal = $("#userEmailAddr option:selected").val();

        if( selectVal == 'custom' ) {
            $("#custom_email").css("display", "block");
        } else {
            $("#custom_email").css("display", "none");
        }
    }

    function jsRegisterEmailSet() {
        const selectVal = $("#userEmailAddr option:selected").val();

        const frm = $('form[name="join_frm"]');
        const userEmailId = $("#userEmailId").val();

        // Email value set
        if( selectVal == 'custom' ) {
            // 직접입력일경우
            const custom_email = $("#email_custom").val();

            frm.find('input[name="userEmail"]').val(userEmailId+"@"+custom_email);

        } else {
            // select box 선택
            frm.find('input[name="userEmail"]').val(userEmailId+"@"+selectVal);
        }
    }

    function jsRegisterAdd() {
        const frm = $('form[name="join_frm"]').serialize();

        $.ajax({
            url: '/register/addUser',
            type: 'POST',
            data: frm,
            dataType: 'json',
            success: function(ajaxResult) {
                alert("정상적으로 회원가입이 완료되었습니다.");
                location.href = "/login";
            },
            error: function(data) {
                alert(data.responseText);
            }
        });
    }

    function jsRegisterIdCheck() {
        const id = $('form[name="join_frm"]').find('input[name="userId"]').val();

        $.ajax({
            url: '/register/idCheck',
            type: 'POST',
            data: {"id": id},
            dataType: 'json',
            success: function(ajaxResult) {
                if( ajaxResult > 0 ) {
                    alert("사용불가능한 아이디입니다.");
                    // input 초기화
                    $("#id_valid_result").val("fail");
                    $("#id_valid_feedback").css("color", "red");
                    $("#id_valid_feedback").html("사용불가능한 아이디");
                } else {
                    alert("사용가능한 아이디입니다.");
                    $("#id_valid_result").val("ok");
                    $("#id_valid_feedback").css("color", "green");
                    $("#id_valid_feedback").html("사용가능한 아이디");
                }
            },
            error: function(data) {
                alert(data.responseText);
            }
        })
    }

</script>

</body>
</html>