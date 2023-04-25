<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="/resources/assets/css/main.css" />
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
                <form name="qnaForm" method="get">
                <input type="hidden" name="page" value="${QnaList.pageable.pageNumber}">
                    <div class="list-search-wrap col-12 ">
                        <div class="col-9 col-12-small div-left">
                            <input type="text" class="form-control" name="searchKeyword" placeholder="검색어를 입력하세요." value="${searchKeyword }"/>
                        </div>
                        <div class="search-btn col-1 div-left">
                            <button type="button" class="form-control" onClick="jsSearch();">
                                검색
                            </button>
                        </div>
                        <div class="sel-div col-1 div-right">
                            <select class="sel-default" name="size" onChange="jsSearch();">
                                <option value="10">10</option>
                                <option value="20">20</option>
                                <option value="30">30</option>
                            <select>
                        </div>
                    </div>
                </form>
                <div class="list-item-wrap">
                    <ul>
                        <c:choose>
                            <c:when test="${empty QnaList.content}">
                                조회된 목록이 없습니다.
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${QnaList.content}" var="result">
                                    <li>
                                        <div class="txt-wrap">
                                            <p class="txt-info">
                                                <span>${result.userDTO.userName}</span>
                                            </p>
                                            <h3><a href="javascript:jsView('${result.qaNo}')">${result.qaTitle}</a></h3>
                                            <p class="hash-tag">
                                                <c:choose>
                                                    <c:when test="${empty TagsList}">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:forEach items="${TagsList}" var="tags">
                                                            <c:if test="${tags.htmNo == result.qaNo}">
                                                                <a href="#">
                                                                    <span>#${tags.comHashTagDTO.htNm}</span>
                                                                </a>
                                                            </c:if>
                                                        </c:forEach>
                                                    </c:otherwise>
                                                </c:choose>
                                            </p>
                                        </div>
                                    </li>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
                        <!--
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
                        </li> -->
                    </ul>

                    <button type="button" id="qa_writeBtn" class="btn btn-dark div-right" >
                        <img src="/resources/images/pencil-white.png" />
                        작성하기
                    </button>


                </div>

                <div class="page-wrap">
                    <ul>
                        <!-- 맨 처음 페이지로  -->
                        <li><a href="javascript:jsSearchPage('0');">&laquo;&laquo;</a></li>
                        <c:choose>
                            <c:when test="${QnaList.pageable.pageNumber > 0 }">
                                <li><a href="javascript:jsSearchPage('${QnaList.pageable.pageNumber -1}');">&laquo;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="javascript:jsSearchPage('0');">&laquo;</a></li>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach begin="${PageDTO.startBlockPage}" end="${PageDTO.endBlockPage}" var = "i">
                            <c:choose>
                                <c:when test="${QnaList.pageable.pageNumber+1 == i}">
                                    <li class="active"><a href="javascript:jsSearchPage('${i-1}');" >${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="javascript:jsSearchPage('${i-1}');">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${QnaList.pageable.pageNumber + 1 < QnaList.totalPages }">
                                <li><a href="javascript:jsSearchPage('${QnaList.pageable.pageNumber +1}');">&raquo;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="javascript:jsSearchPage('${QnaList.totalPages -1}');">&raquo;</a></li>
                            </c:otherwise>
                        </c:choose>

                        <li><a href="javascript:jsSearchPage('${QnaList.totalPages -1}');">&raquo;&raquo;</a></li>
                    </ul>
                </div>
            </section>
        </div>
    </div>
</div>

<script>
    $(document).ready(function() {
        jsPageUnit();

        // pageUnit Value Set
        function jsPageUnit() {
            const pageUnit = '${QnaList.pageable.pageSize}';

            //console.log(pageUnit);

            $('form[name="qnaForm"]').find('select[name="size"]').val(pageUnit).prop("selected", true);
        }
    });
    $("#qa_writeBtn").click(function() {
        location.href= "/qa/qaWrite";
    });

    // 게시물 상세보기 method : Get
    function jsView(qa_no) {
        location.href = '/qa/qaView?qaNo='+qa_no;
    }

    function jsSearchPage(page_no) {
        // form hidden에 page value 전달
        $('form[name="qnaForm"]').find('input[name="page"]').val(page_no);
        $('form[name="qnaForm"]').attr("action", "/qa/qaList");
        $('form[name="qnaForm"]').submit();
    }

    function jsSearch() {
        $('form[name="qnaForm"]').attr("action", "/qa/qaList");
        $('form[name="qnaForm"]').submit();
    }
</script>