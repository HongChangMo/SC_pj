<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
                    <a class="active" href="#">기술</a>
                </div>
                <div class="content-info">
                    <div class="content-sub col-12">
                        <div class="content-title col-9 div-left">
                            <h2>제목</h2>
                        </div>
                        <div class="content-view">
                            <h4>작성자</h4>
                            <p>
                                <img src="/resources/images/eye.png" />
                                &nbsp;2
                            </p>
                        </div>
                    </div>
                    <div class="content">
                        <div class="content-detail">
                            <p class="cont">
                                asdasdasd<br />
                                asdasdasdasdasdasd<br />
                                asdasdasd<br />
                                asdasdasd<br />
                                asdasdasd<br />
                                asdasdasd
                            </p>
                        </div>
                        <!-- 첨부파일 영역 -->
                        <div class="content-file">
                            <ul class="file-list">
                                <li>
                                    <img src="/resources/images/jpg-file.png" />
                                    첨부파일1
                                </li>
                                <li>
                                    <img src="/resources/images/doc-file.png" />
                                    첨부파일2
                                </li>
                                <li>
                                    <img src="/resources/images/pdf-file.png" />
                                    첨부파일3
                                </li>
                                <li>
                                    <img src="/resources/images/ppt-file.png" />
                                    첨부파일4
                                </li>
                                <li>
                                    <img src="/resources/images/xls-file.png" />
                                    첨부파일5
                                </li>
                            </ul>
                        </div>
                        <!-- 해시태그 영역 -->
                        <div class="content-hashtag">
                            <a href="#"><span>#자바</span></a>
                            <a href="#"><span>#자바스크립트</span></a>
                        </div>
                    </div>

                    <br/>
                    <button type="button" id="qa_deleteBtn" class="comment-btn col-1 " style="float:right;">
                        <img src="/resources/images/free-icon-delete-7989218.png" />
                         삭제
                    </button>
                    <button type="button" id="qa_updateBtn" class="comment-btn col-1" style="float:right;">
                        <img src="/resources/images/pencil-white.png" />
                        수정
                    </button>
                    <br/>
                    <br/>

                    <!-- 댓글 영역 -->
                    <div class="content-comment col-12">
                        <textarea class="form-control col-10 div-left"></textarea>
                        <button class="comment-btn col-1" type="button">등록</button>
                        <div class="comment-list col-10">
                            <ul>
                                <li>
                                    <div class="comment-sub">
                                        <span class="div-left">작성자</span>
                                        <div class="comment-sub-btn">
                                            <a href="#"><img src="/resources/images/pencil.png" /></a>&nbsp;
                                            <a href="#"><img src="/resources/images/eraser.png" /></a>
                                        </div>
                                        <p>
                                           댓글 내용입니다.
                                        </p>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </section>
        </div>
    </div>
</div>