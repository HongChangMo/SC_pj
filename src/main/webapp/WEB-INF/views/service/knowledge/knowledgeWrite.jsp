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
  <style type="text/css">
  	.ck-editor__editable { height: 700px; }
  </style>
  <script src="https://cdn.ckeditor.com/ckeditor5/35.0.1/classic/ckeditor.js"></script>
  <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
  <script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
<main id="main" class="main">
	<div class="pagetitle">
		<h1>지식 작성</h1>
		<nav>
			<ol class="breadcrumb">
				<li class="breadcrumb-item"><a href="/"><i class="bi bi-house-door"></i></a></li>
				<li class="breadcrumb-item"><a href="/knowledge/knowledgeList">지식</a></li>
				<li class="breadcrumb-item active">New 지식</li>
			</ol>
		</nav>
	</div>

	<div class="container">
		<div class="card">
			<div class="card-header">
				<div class="pagetitle" style="padding-top:80px;">
					<h1 align="center" style="font-size:30px">지식</h1>
				</div>
			</div>

			<div class="card-body mt-4" style="padding-top:3%">
				<form id="insNotice_form"class="row g-3" method="post">

					<div class="row mb-3">
						<label for="input_title" class="col-sm-1 col-form-label">제목</label>
						<div class="">
							<input id="input_title" class="form-control" name="title"/>
						</div>
					</div>
					<div class="col-md12 mt-4" style="height:800px;">
						<label for="editor" class="form-label">내용</label>
						<textarea id="editor" rows="500" cols="500"></textarea>
					</div>

                    <button id="notice_insBtn" class="form-control btn btn-primary" type="button">작성</button>
				</form>

			</div>
		</div>
	</div>
</main>

<script src="/resources/common/js/ckeditor.js"></script>