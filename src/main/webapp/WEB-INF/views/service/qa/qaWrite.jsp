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

  	#modal.modal-overlay {
        width: 100%;
        height: 100%;
        position: absolute;
        left: 0;
        top: 0;
        display: none;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        background-color: rgba(255, 255, 255, 0.25);
        box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
        backdrop-filter: blur(1.5px);
        -webkit-backdrop-filter: blur(1.5px);
        border-radius: 10px;
        border: 1px solid rgba(255, 255, 255, 0.18);
    }
    #modal .modal-window {
        background-color: #BDBDBD;
        box-shadow: 0 8px 32px 0 rgba( 31, 38, 135, 0.37 );
        backdrop-filter: blur( 13.5px );
        -webkit-backdrop-filter: blur( 13.5px );
        border-radius: 10px;
        border: 1px solid rgba( 255, 255, 255, 0.18 );
        width: 400px;
        height: 250px;
        position: relative;
        top: -100px;
        padding: 10px;
    }
    #modal .title {
        padding-left: 10px;
        display: inline;
        text-shadow: 1px 1px 2px gray;
        color: white;

    }
    #modal .title h2 {
        display: inline;
        font-size: 20px;
    }
    #modal .close-area {
        display: inline;
        float: right;
        padding-right: 10px;
        cursor: pointer;
        text-shadow: 1px 1px 2px gray;
        color: white;
    }

    #modal .modal-content {
        margin-top: 20px;
        padding: 0px 10px;
        text-shadow: 1px 1px 2px gray;
        color: white;
        border-top: 1px solid;
    }

    #modal .modal-btn {
        margin-top: 1em;
    }
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
                        <select id="topic" name="qaTopic" class="sel-default">
                            <option>Topic을 선택하세요</option>
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
                        <input id="input_title" class="form-control" name="qaTitle"/>
                    </div>
                    <!-- 해시태그 영역 start -->
                    <div class="tag-wrapper col-12">
                        <div class="content-hashtag col-12">
                            <label for="hash-tag">태그</label>
                            <div id="hash-tag" class="tag-select col-12">
                               <span>태그를 선택해주세요</span>
                               <span class="material-icons">expand_more</span>
                            </div><!--select-->
                            <div class="tag-content">
                              <div class="tag-search-box">
                                <span class="material-icons">search</span>
                                <input class="filter" type="text" placeholder="검색">
                              </div><!--search box-->
                              <ul class="options">
                              </ul>
                            </div><!--content-->
                            <div id="select-tag" class="">
                            </div>
                        </div>
                    </div>
                    <!-- 해시태그 영역 end -->
                    <div class="content">
                        <div class="content-detail">
                            <label for="editor" class="form-label">본문</label>
                            <textarea id="editor" name="qaContents" rows="500" cols="500"></textarea>
                        </div>
                    </div>
                    <div class="submit-btn div-right col-1">
                        <button id="submitBtn" class="form-control content-btn" type="button">작성</button>
                    </div>
                </div>
                </form>
            </section>
        </div>
    </div>
</div>

<div id="modal" class="modal-overlay">
    <div class="modal-window">
        <div class="title">
            <h2>태그등록</h2>
        </div>
        <div class="close-area">X</div>
        <div class="modal-content">
            <form name="modalForm" id="modalForm" method="post" onSubmit="return false;">
                <label for="modal-htNm" class="col-sm-1 col-form-label">태그명</label>
                <input id="modal-htNm" type="text" name="htNm" />

                <button type="button" class="modal-btn btn-dark div-right" onClick="jsTagModalAdd();">추가</button>
            </form>
        </div>
    </div>
</div>

<script src="/resources/common/js/ckeditor.js"></script>
<script src="/resources/common/js/editor.js" type="module"></script>
<script>
    const wrapper = document.querySelector('.tag-wrapper');//전체 frame
    const select = document.querySelector('.tag-select');//선택영역
    const options = document.querySelector('.options');
    const input = document.querySelector('.filter');//input element

    let datas = [];

    $(document).ready(function () {

    $("#submitBtn").on('click', function() {

        const topic = $('form[name="sendForm"]').find('select[name="qaTopic"]').val();
        const title = $('form[name="sendForm"]').find('input[name="qaTitle"]').val();

    });

    //jsCallHashTag("j");

        select.addEventListener('click',function(){
          let c = wrapper.className;
          wrapper.classList.toggle('active');
        });

        //input에 글자를 적을 때마다 event발생.
        input.addEventListener('keyup',function(){
          //사용자가 적은 값과 일치하는 태그를 집어넣을 새로운 배열.
          let arr = [];
          let searchWord = input.value;//사용자 입력값

          if(searchWord.length>0){//사용자 입력값이 존재하는 경우
            //filter메서드를 사용해서 arr로 보냄

            $.ajax({
                type: 'post',
                url: '/com/hashtagList',
                dataType: 'json',
                async: false,
                data: {htNm: searchWord},
                success: function(ajaxResult) {
                    datas = ajaxResult;
                },
                error: function(err) {
                    alert("데이터 오류");
                }
            });

            arr= datas.filter(data=>{
            return data.name.startsWith(searchWord.toUpperCase());
          }).map(data=>'<li class="tag-li'+data.id+'" onclick="jsHashTagSelect('+ data.id +')" data-value="'+data.name+'">'+data.name+'</li>').join("");
          //map을 사용해서 데이터를 <li>태그로 감싼 것처럼 처리함.
          //join함수를 사용해서 새배열(arr)에서 출력되는','를 없앰
            options.innerHTML= arr ? arr : '<p>조회된 태그가 없습니다.</p><a href="javascript:jsTagModalOpen();">태그 추가하기</a>';
            //조회되는 아이템이 없는 경우 보여주는 글귀 설정.
          }else{
          	//사용자 입력값이 존재하지않는 경우
            options.innerHTML="";// option 초기화
          }


        });//input keyup event.

        // modal X버튼 클릭 Event
        $(".close-area").on("click", function() {
            jsTagModalClose();
        });

    });

    function jsHashTagSelect(id) {

        name = $(".tag-li"+id).attr("data-value");

        // 중복체크
        if( $("#no_"+id).length > 0 ) {

            alert("이미 선택된 태그입니다.");

            return false;
        }

        const appendHtml = '<a class="ht_no_btn" id="no_'+ id +'" data-id="'+ id +'" href="javascript:jsHashTagDel('+ id +');">'
        + '<span># '+ name +'</span>'
        + '<img class="ht_img" src="/resources/images/close.png" />'
        + '</a>';

        $("#select-tag").append(appendHtml);

        // hashtag input으로 전송(배열형식)
        const appendInput = '<input type="hidden" name="hashtags" value='+ id +' />';
        $('form[name="sendForm"]').append(appendInput);

        input.value="";//input 초기화.
        wrapper.classList.remove('active');//classList사용해서 active 클래스명 삭제.
        options.innerHTML="";//option 초기화.
    }

    // 태그 html 삭제
    function jsHashTagDel(target_id) {
        $("#no_"+target_id).remove();
    }

    // 해시태그 추가 모달 open
    function jsTagModalOpen() {
        $("#modal").css("display", "flex");
    }

    // 해시태그 추가 모달 close
    function jsTagModalClose() {
        //input 초기화
        $("#modal-htNm").val("");
        $("#modal").css("display", "none");
    }

    // 해시태그 추가
    function jsTagModalAdd() {

        let form = $("form[name=modalForm]").serialize();

        $.ajax({
            type: 'post',
            url: '/com/hashtagAdd',
            dataType: 'json',
            data: form,
            success: function(ajaxResult) {
                alert("태그를 추가하였습니다.");
                input.value="";//input 초기화.
                wrapper.classList.remove('active');//classList사용해서 active 클래스명 삭제.
                options.innerHTML="";//option 초기화.
                jsTagModalClose();
            },
            error: function(err) {
                alert("태그 저장 오류");
            }
        });
    }

</script>