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
                    <a href="/kn/knList">지식</a>
                    &gt;
                    <!-- 카테고리에 맞춰 변경해줘야함 -->
                    <a class="active" href="#">${CommonDTO.cmmNm}</a>
                </div>
                <div class="content-info">
                    <div class="content-sub col-12">
                        <div class="content-title col-9 div-left">
                            <h2>${KnowledgeDTO.knTitle}</h2>
                        </div>
                        <div class="content-view">
                            <h4>${KnowledgeDTO.knWriter}</h4>
                            <p>
                                <img src="/resources/images/eye.png" />
                                &nbsp;${KnowledgeDTO.knViews} <!-- 게시물 조회수 -->
                            </p>
                        </div>
                    </div>
                    <div class="content">
                        <div class="content-detail">
                            <p class="cont">
                                ${KnowledgeDTO.knContents}
                            </p>
                        </div>
                        <!-- 해시태그 영역 -->
                        <div class="content-hashtag">
                            <c:choose>
                                <c:when test="${empty hashTagList }">
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${hashTagList}" var="result">
                                        <a href="#">
                                            <span># ${result.htNm}</span>
                                        </a>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>
                            <!--
                            <a href="#"><span>#자바</span></a>
                            <a href="#"><span>#자바스크립트</span></a>
                            -->
                        </div>
                    </div>

                    <br/>
                    <button type="button" id="kn_deleteBtn" class="btn btn-dark col-1 " style="float:right;">
                        <img src="/resources/images/free-icon-delete-7989218.png" />
                         삭제
                    </button>
                    <button type="button" id="kn_updateBtn" class="btn btn-dark col-1" style="float:right; margin: 0em 1em 0em 1em;">
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