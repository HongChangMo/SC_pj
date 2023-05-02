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
<title>로그인</title>
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
    <section class="section register min-vh-100 d-flex flex-column align-items-center justify-content-center py-4">
    	<div class="container">
    		<div class="row justify-content-center">
    			<div class="col-lg-4 col-md-6 d-flex flex-column align-items-center justify-content-center">
    				<div class="d-flex justify-content-center py-4">
                        <div id="logo">
                            <h1><a href="/">DS</a></h1>
                            <span>Developer Space</span>
                        </div>
    				</div><!-- End Logo -->
    				<div class="card mb-3">
    					<div class="card-body">
    						<div class="pt-4 pb-2">
    							<h5 class="card-title text-center pb-0 fs-4" style="font-weight:bold">로그인</h5>
    							<p class="text-center small" style="color: red;">아이디 또는 비밀번호가 틀렸습니다.</p>
    						</div>

    						<form id="sendForm" class="row g-3 needs-validation"  method="post">

    							<div class="col-12">
    						  		<label for="userId" class="form-label">아이디</label>
    							    <input id="userId" name="userId" class="form-control mr-sm-2" placeholder="아이디" />
    						    </div>

    						    <div class="col-12">
    							    <label for="userPwd" class="form-label">비밀번호</label>
    							    <input type="password" id="userPwd" name="userPwd" class="form-control mr-sm-2" placeholder="비밀번호" />
    						    </div>

    						    <button class="btn btn-primary w-100" id="login_btn" type="button" onClick="jsSignIn();">로그인</button>
    						    <div class="credits">
    						        <a href="/findAccount" style="float:right;">계정찾기</a>
    						    </div>
    						</form>
    					</div>
    				</div>
    				<div class="credits">
                    아직 회원이 아니신가요?&nbsp;&nbsp;&nbsp;&nbsp;<a href="/register">회원가입</a>
                  </div>
    			</div>
    		</div>
    	</div>
    </section>
    <!-- Vendor JS Files -->
    <script src="/resources/NiceAdmin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/echarts/echarts.min.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/tinymce/tinymce.min.js"></script>

    <!-- Template Main JS File -->
    <script src="/resources/NiceAdmin/assets/js/main.js"></script>

    <script>
        $(document).ready(function() {

        });

        function jsSignIn() {
            const frm = $("#sendForm");
            frm.attr("action", "/login/signIn");
            frm.submit();
        }
    </script>
</body>
</html>