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
</head>
<div class="container">
    <div class="row">
        <div class="col-12 content-wrap">
            <section>
                <div class="breadcrumb">
                    <a href="/">
                    <img src="/resources/images/home.png" />
                    </a>
                    &gt;
                    <a href="/qa/qaList">Q&A</a>
                    &gt;
                    <!-- 카테고리에 맞춰 변경해줘야함 -->
                    <a class="active" href="/qa/qaWrite">new Q&A</a>
                </div>
                <form id="sendForm" name="sendForm" method="post">
                <div class="content-info">
                    <div class="content-topic col-12">
                        <label for="topic">토픽</label>
                        <select id="topic" class="sel-default">
                            <option>선택하시오</option>
                            <c:choose>
                                <c:when test="${empty cmmCodeList} ">

                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${cmmCodeList}" var="result">
                                        <option value="${result.cmmCd}">${result.cmmNm}</option>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                        <select>
                    </div>
                    <div class="content-title col-12">
                        <label for="input_title" class="col-sm-1 col-form-label">제목</label>
                        <input id="input_title" class="form-control" name="title"/>
                    </div>
                    <div class="content-hashtag col-12">
                        <label for="hash-tag">태그</label>
                        <div id="hash-tag" onChange="javascript:jsHashTagSelect();" class="col-12">
                        </div>
                        <div id="select-tag" class="">

                        </div>
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
                </form>
            </section>
        </div>
    </div>
</div>

<script src="/resources/common/js/ckeditor.js"></script>
<script>

    $(document).ready(function () {

        // 엔터키 처리
        $("form[name=sendForm]").find('select').keypress(function(e) {
            if (e.keyCode === 13) {
                jsHashTagSelect();
            }
        });

        var source = [
            { value: 1 , label: '태그1' },
            { value: 2 , label: '태그2'},
            { value: 3 , label: '태그3' }
        ];


        // Create a jqxComboBox
        $("#hash-tag").jqxComboBox({source: source, width: '100%', height: '35px'});

    });

    function jsHashTagSelect() {
        const item = $("#hash-tag").jqxComboBox('getSelectedItem').label;
        const id = $("#hash-tag").jqxComboBox('getSelectedItem').value;

        // 중복체크
        if( $("#no_"+id).length > 0 ) {

            alert("이미 선택된 태그입니다.");

            return false;
        }

        //const appendHtml = '<input type="button" class="ht_no_btn" id="no_'+ id +'" value="# '+ item +'"/>'
        //+ '<img class="ht_img" src="/resources/images/close.png" />';

        const appendHtml = '<a class="ht_no_btn" id="no_'+ id +'" data-id="'+ id +'" href="javascript:jsHashTagDel('+ id +');">'
        + '<span># '+ item +'</span>'
        + '<img class="ht_img" src="/resources/images/close.png" />'
        + '</a>';

        $("#select-tag").append(appendHtml);

        $("#hash-tag").val("");
    }

    // 태그 html 삭제
    function jsHashTagDel(target_id) {
        $("#no_"+target_id).remove();
    }

</script>