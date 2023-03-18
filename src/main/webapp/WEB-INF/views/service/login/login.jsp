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
  <link href="/resources/NiceAdmin/assets/img/favicon.png" rel="icon">
  <link href="/resources/NiceAdmin/assets/img/apple-touch-icon.png" rel="apple-touch-icon">
  <link href="https://fonts.gstatic.com" rel="preconnect">
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Nunito:300,300i,400,400i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
  <link rel="stylesheet" href="/resources/assets/css/main.css" />
  <link href="/resources/NiceAdmin/assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/vendor/quill/quill.snow.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/vendor/quill/quill.bubble.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/vendor/simple-datatables/style.css" rel="stylesheet">
  <link href="/resources/NiceAdmin/assets/css/style.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.6.0.js" type="text/javascript"></script>
</head>
<body>
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
    							<h5 class="card-title text-center pb-0 fs-4" style="font-weight:bold">로그인</h5>
    							<p class="text-center small">아이디 & 비밀번호를 입력하세요</p>
    						</div>

    						<form id="frm01" class="row g-3 needs-validation"  method="post">

    							<div class="col-12">
    						  		<label for="user_id" class="form-label">아이디</label>
    							    <input id="user_id" name="user_id" class="form-control mr-sm-2" placeholder="아이디" />
    						    </div>

    						    <div class="col-12">
    							    <label for="user_pwd" class="form-label">비밀번호</label>
    							    <input type="password" id="user_pwd" name="user_pwd" class="form-control mr-sm-2" placeholder="비밀번호" />
    						    </div>

    						    <button class="btn btn-primary w-100" id="login_btn" type="button">로그인</button>
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
    <script src="/resources/NiceAdmin/assets/vendor/apexcharts/apexcharts.min.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/chart.js/chart.min.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/echarts/echarts.min.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/quill/quill.min.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/simple-datatables/simple-datatables.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/tinymce/tinymce.min.js"></script>
    <script src="/resources/NiceAdmin/assets/vendor/php-email-form/validate.js"></script>

    <!-- Template Main JS File -->
    <script src="/resources/NiceAdmin/assets/js/main.js"></script>
</body>
</html>