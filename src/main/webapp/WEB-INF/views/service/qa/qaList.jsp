<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="/resources/assets/css/main.css" />
<script src="https://code.jquery.com/jquery-3.6.0.js" type="text/javascript"></script>
<!-- Q&A -->
<div class="container">
    <div class="row">
        <div class="col-12 list-wrap">
            <section>
                <div class="list-info">
                    <header>
                        <h2>Q&A</h2>
                    </header>
                    <div class="list-img">
                        <img src="/resources/images/conversation.png" />
                    </div>
                </div>
                <div class="list-search-wrap col-12 ">
                    <div class="col-9 col-12-small div-left">
                        <input type="text" class="form-control" name="" placeholder="검색어를 입력하세요." />
                    </div>
                    <div class="search-btn col-1 div-left">
                        <button type="button" class="form-control">
                            검색
                        </button>
                    </div>
                    <div class="sel-div col-1 div-right">
                        <select class="sel-default">
                            <option>10</option>
                            <option>20</option>
                            <option>30</option>
                        <select>
                    </div>
                </div>
                <div class="list-item-wrap">
                    <ul>
                        <li>
                            <div class="txt-wrap">
                                <p class="txt-info">
                                    <span>작성자</span>
                                </p>
                                <h3>제목</h3>
                                <p class="hash-tag">
                                    <a href="#"><span>#hash-tag1</span></a>
                                    <a href="#"><span>#hash-tag2</span></a>
                                    <a href="#"><span>#hash-tag3</span></a>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="txt-wrap">
                                <p class="txt-info">
                                    <span>작성자</span>
                                </p>
                                <h3>제목</h3>
                                <p class="hash-tag">
                                    <a href="#"><span>#hash-tag1</span></a>
                                    <a href="#"><span>#hash-tag2</span></a>
                                    <a href="#"><span>#hash-tag3</span></a>
                                </p>
                            </div>
                        </li>
                        <li>
                            <div class="txt-wrap">
                                <p class="txt-info">
                                    <span>작성자</span>
                                </p>
                                <h3>제목</h3>
                                <p class="hash-tag">
                                    <a href="#"><span>#hash-tag1</span></a>
                                    <a href="#"><span>#hash-tag2</span></a>
                                    <a href="#"><span>#hash-tag3</span></a>
                                </p>
                            </div>
                        </li>
                    </ul>

                    <button type="button" id="qa_writeBtn" class="btn btn-dark div-right" >
                        <img src="/resources/images/pencil-white.png" />
                        작성하기
                    </button>


                </div>

                <div class="page-wrap">
                    <ul>
                        <li><a href="#">&laquo;&laquo;</a></li>
                        <li><a href="#">&laquo;</a></li>
                        <li class="active"><a href="#" >1</a></li>
                        <li><a href="#">2</a></li>
                        <li><a href="#">3</a></li>
                        <li><a href="#">4</a></li>
                        <li><a href="#">5</a></li>
                        <li><a href="#">&raquo;</a></li>
                        <li><a href="#">&raquo;&raquo;</a></li>
                    </ul>
                </div>
            </section>
        </div>
    </div>
</div>

<script type="text/javascript">
    $("#qa_writeBtn").click(function() {
        location.href= "/qa/qaWrite";
    })
</script>