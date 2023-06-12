<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="/resources/assets/css/sub.css" />
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
                    <a class="active" href="#">${CommonDTO.cmmNm}</a>
                </div>
                <div class="content-info">
                    <div class="content-sub col-12">
                        <div class="content-title col-9 div-left">
                            <h2>${QnaDTO.qaTitle}</h2>
                        </div>
                        <div class="content-view">
                            <h4>${RegisterDTO.userNickName}</h4>
                            <p>
                                <img src="/resources/images/eye.png" />
                                &nbsp;${QnaDTO.qaViews} <!-- 게시물 조회수 -->
                            </p>
                        </div>
                    </div>
                    <div class="content">
                        <div class="content-detail">
                            <p class="cont">
                                ${QnaDTO.qaContents}
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
                        </div>
                    </div>

                    <br/>
                    <c:if test="${RegisterDTO.userNo eq UserDTO.userNo}">
                        <button type="button" id="qa_deleteBtn" class="btn btn-dark col-1 " style="float:right;">
                            <img src="/resources/images/free-icon-delete-7989218.png" />
                             삭제
                        </button>
                        <button type="button" id="qa_updateBtn" class="btn btn-dark col-1" style="float:right; margin: 0em 1em 0em 1em;">
                            <img src="/resources/images/pencil-white.png" />
                            수정
                        </button>
                    </c:if>

                    <br/>
                    <br/>

                    <!-- 댓글 영역 -->
                    <form name="commentForm" method="post">
                    <input type="hidden" name="cType" value="1" />
                    <input type="hidden" name="cBoardNo" value="${QnaDTO.qaNo}" />
                    <input type="hidden" name="cWriter" value="${UserDTO.userId}" />
                        <div class="content-comment col-12">
                            <textarea name="cContent" class="form-control col-10 div-left"><c:if test="${empty UserDTO}">로그인 후 이용이 가능합니다.</c:if></textarea>
                            <button id="commentBtn" class="comment-btn col-1" type="button" <c:if test="${empty UserDTO}">disabled="disabled"</c:if>>등록</button>
                            <div class="comment-list col-10">
                                <ul>
                                    <c:choose>
                                        <c:when test="${empty CommentList}">
                                            <li>
                                                등록된 댓글이 없습니다.
                                            </li>
                                        </c:when>
                                        <c:otherwise>
                                            <c:forEach items="${CommentList}" var="result">
                                                <li>
                                                    <div class="comment-sub">
                                                        <span class="list-profile">
                                                            <img src="/profile/listImageView?userNo=${result.userDTO.userNo}" alt="Profile" id="profileImg" onerror="this.src='/resources/images/noimages.png'" />
                                                        </span>
                                                        <span class="div-left">${result.userDTO.userNickName}</span>
                                                        <div class="comment-sub-btn">
                                                            &nbsp;
                                                            <c:if test="${UserDTO.userId eq result.CWriter}">
                                                                <a href="javascript:jsCommentDel('${result.CNo}')"><img src="/resources/images/eraser.png" /></a>
                                                            </c:if>
                                                        </div>
                                                        <p>
                                                           ${result.CContent}
                                                        </p>
                                                    </div>
                                                </li>
                                            </c:forEach>
                                        </c:otherwise>
                                    </c:choose>
                                </ul>
                            </div>
                        </div>
                    </form>
                </div>
            </section>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        $("#commentBtn").on('click', function() {
            const content = $('textarea[name="cContent"]').val();

            if(content == '') {
                alert("댓글의 내용을 입력하셔야합니다.");
                return false;
            } else {
                jsCommentAdd();
            }

        });
    });

    // 댓글 등록 함수
    function jsCommentAdd() {
        const commentFrm = $('form[name="commentForm"]').serialize();

        $.ajax({
            url: '/com/commentAdd',
            dataType: 'json',
            data: commentFrm,
            type: 'post',
            success: function(ajaxResult) {
                if(ajaxResult.cNo > 0) {
                    alert("댓글이 등록되었습니다.");
                    location.href="/qa/qaView?qaNo=${QnaDTO.qaNo}";
                }
            },
            error: function(err) {
                alert("댓글 등록에 실패했습니다.");
            }
        });

    }

    //댓글 삭제
    function jsCommentDel(c_no) {
        $.ajax({
            url: '/com/commentDel',
            dataType: 'json',
            data: {cNo : c_no},
            type: 'post',
            success: function(ajaxResult) {
                if(ajaxResult.result > 0) {
                    alert("댓글이 삭제되었습니다.");
                    location.href="/qa/qaView?qaNo=${QnaDTO.qaNo}";
                }
            },
            error: function(err) {
                alert("댓글 삭제에 실패했습니다.");
            }
        });
    }


</script>