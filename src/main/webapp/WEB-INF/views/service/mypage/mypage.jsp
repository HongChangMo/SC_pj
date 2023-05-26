<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="/resources/assets/css/sub.css" />
<script>
    $(document).ready(function() {

        // image preview
        $("#profile-image").on('change', function(e) {
            const file = e.target.files[0];

            let reader = new FileReader();
            reader.onload = function(event) {
                $("#profileImg").attr("src", event.target.result);
            }

            reader.readAsDataURL(file);
        });

        $(".profile-header").mouseover(function() {
            $(".profile-txt").css("display", "block");
            $(".profile-header").css("filter", "brightness(0.5)");
        })
        .mouseout(function() {
            $(".profile-txt").css("display", "none");
            $(".profile-header").css("filter", "brightness(1)");
        });

        // 비밀번호 확인
        $("#userPwd_re").on('keyup', function() {
            if( $("#userPwd").val() != $("#userPwd_re").val() ) {
                $("#pw_corr_feedback").css("color", "red");
                $("#pw_corr_feedback").html("비밀번호가 일치하지 않습니다.");
                $("#pw_corr_result").val("fail");
            } else if( $("#userPwd_re").val() == '' || $("#userPwd").val() == '' ) {
                $("#pw_corr_feedback").css("color", "red");
                $("#pw_corr_feedback").html("비밀번호가 일치하지 않습니다.");
                $("#pw_corr_result").val("fail");
            } else {
                $("#pw_corr_feedback").css("color", "green");
                $("#pw_corr_feedback").html("비밀번호가 일치합니다.");
                $("#pw_corr_result").val("ok");
            }
        });

        $("#userPwd").on('keyup', function() {
            if( $("#userPwd").val() != $("#userPwd_re").val() ) {
                $("#pw_corr_feedback").css("color", "red");
                $("#pw_corr_feedback").html("비밀번호가 일치하지 않습니다.");
                $("#pw_corr_result").val("fail");
            } else if( $("#userPwd_re").val() == '' || $("#userPwd").val() == '' ) {
                $("#pw_corr_feedback").css("color", "red");
                $("#pw_corr_feedback").html("비밀번호가 일치하지 않습니다.");
                $("#pw_corr_result").val("fail");
            } else {
                $("#pw_corr_feedback").css("color", "green");
                $("#pw_corr_feedback").html("비밀번호가 일치합니다.");
                $("#pw_corr_result").val("ok");
            }
        });

        // 회원정보 수정
        $("#profile_btn").on("click", function() {
            const frm = $('form[name="sendForm"]');

            const password = frm.find('input[name="userPwd"]').val();
            const nickname = frm.find('input[name="userNickName"]').val();
            const phone = frm.find('input[name="userPhone"]').val();
            const pwd_check = $("#pw_corr_result").val();

            if( password == '' ) {
                alert("비밀번호를 입력해주세요");
                return false;
            } else if( nickname == '' ) {
                alert("닉네임을 입력해주세요");
                return false;
            } else if( phone == '' ) {
                alert("핸드폰번호를 입력해주세요");
                return false;
            } else if ( phone.length < 10 ) {
                alert("올바른 핸드폰번호를 입력해주세요");
                return false;
            } else if( pwd_check == 'fail' ) {
                alert("비밀번호를 확인해주세요");
                return false;
            } else {
                jsProfileEdit();
            }

        });

    });

    function jsProfileEdit() {
        const frm = $('form[name="sendForm"]')[0];

        const data = new FormData(frm);

        $.ajax({
            url: '/myPage/editInfo',
            type: 'POST',
            data: data,
            contentType: false,
            processData: false,
            enctype: 'multipart/form-data',
            success: function(ajaxResult) {
                if( ajaxResult.result > 0) {
                    alert("회원정보가 정상적으로 수정되었습니다.");
                    location.href = '/';
                } else {
                    alert("회원정보수정 오류");
                }

            },
            error: function(data) {
                alert(data.responseText);
            }
        });
    }

    function jsProfileFileUpload() {
        $("#profile-image").click();
    }
</script>

<div class="container">
    <div class="row">
        <div class="col-6 content-wrap">
            <section>
                <div class="mypage-sub">
                    <h2>회원정보</h2>
                </div>
                <div class="mypage-info">
                    <div class="" id="profile-edit">
                      <!-- Profile Edit Form -->
                      <form name="sendForm" method="post" enctype="multipart/form-data">
                      <input type="hidden" name="userNo" value="${RegisterDTO.userNo}" />
                        <div class="profile-header">
                            <a href="javascript:jsProfileFileUpload();">
                                <img src="/profile/imageview?userNo=${RegisterDTO.userNo}" alt="Profile" id="profileImg" onerror="this.src='/resources/images/noimages.png'" />
                            </a>
                            <input type="file" class="profile-image" id="profile-image" name="profileImage" accept="image/png, image/jpeg, image/jpg" >
                            <span class="profile-txt">편집</span>
                        </div>

                        <div class="content-info col-12 col-13-small">
                            <div class="content-title col-12">
                                <label for="userName" class="col-sm-1 col-form-label">이름</label>
                                <input id="userName" class="form-control" disabled="disabled" value="${RegisterDTO.userName}" />
                            </div>
                            <div class="content-title col-12">
                                <label for="userPwd" class="col-sm-1 col-form-label">비밀번호</label>
                                <input type="password" id="userPwd" class="form-control" name="userPwd"/>
                            </div>

                            <div class="content-title col-12">
                                <label for="userPwd_re" class="col-sm-1 col-form-label">비밀번호 확인</label>
                                <input type="password" id="userPwd_re" class="form-control"/>
                                <span id="pw_corr_feedback"></span><br>
                                <input id="pw_corr_result" type="hidden" value=""/>
                            </div>

                            <div class="content-title col-12">
                                <label for="userNickName" class="col-sm-1 col-form-label">닉네임</label>
                                <input id="userNickName" class="form-control" name="userNickName" value="${RegisterDTO.userNickName}" />
                            </div>

                            <div class="content-title col-12">
                                <label for="userPhone" class="col-sm-1 col-form-label">핸드폰 번호</label>
                                <input id="userPhone" class="form-control" name="userPhone" value="${RegisterDTO.userPhone}" />
                            </div>
                            <br/>
                            <button type="button" id="profile_btn" class="btn btn-dark div-right" style="float:right;">
                                <img src="/resources/images/pencil-white.png" />
                                수정
                            </button>
                        </div>
                      </form><!-- End Profile Edit Form -->
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>