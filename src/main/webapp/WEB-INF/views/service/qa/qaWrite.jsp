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
  <style type="text/css">
  	.ck-editor__editable { height: 700px; }
  </style>
  <script src="https://cdn.ckeditor.com/ckeditor5/35.0.1/classic/ckeditor.js"></script>
  <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
  <script src="https://ckeditor.com/apps/ckfinder/3.5.0/ckfinder.js"></script>
<div class="container">
    <div class="row">
        <div class="col-12 content-wrap">
            <section>
                <div class="breadcrumb">
                    <a href="/">
                    <img src="/resources/images/home.png" />
                    </a>
                    &gt;
                    <a href="#">Q&A</a>
                    &gt;
                    <!-- 카테고리에 맞춰 변경해줘야함 -->
                    <a class="active" href="#">new Q&A</a>
                </div>
                <div class="content-info">
                    <div class="content-topic col-12">
                        <label for="topic">토픽</label>
                        <select id="topic" class="sel-default">
                            <option>선택하시오</option>
                            <option>기술</option>
                            <option>커리어</option>
                            <option>기타</option>
                        <select>
                    </div>
                    <div class="content-title col-12">
                        <label for="input_title" class="col-sm-1 col-form-label">제목</label>
                        <input id="input_title" class="form-control" name="title"/>
                    </div>
                    <div class="content-hashtag col-12">
                        <label for="hash-tag">태그</label>
                        <select id="hash-tag" class="sel-default">
                            <option>이거는 결정을 해야함 combobox API?</option>
                            <option>기술</option>
                            <option>커리어</option>
                            <option>기타</option>
                        <select>
                    </div>
                    <div class="content">
                        <div class="content-detail">
                            <label for="editor" class="form-label">본문</label>
                            <textarea id="editor" rows="500" cols="500"></textarea>
                        </div>
                    </div>
                    <div class="submit-btn div-right col-1">
                        <button id="notice_insBtn" class="form-control content-btn" type="button">작성</button>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>

<script src="/resources/common/js/ckeditor.js"></script>