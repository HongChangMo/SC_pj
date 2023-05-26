<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<link rel="stylesheet" href="/resources/assets/css/main.css" />
<link rel="stylesheet" href="/resources/assets/css/sub.css" />
<!-- 지식 -->
<div class="container">
    <div class="row">
        <div class="col-12 list-wrap">
            <section>
                <div class="list-info">
                    <header>
                        <h2>지식</h2>
                    </header>
                    <div class="list-img">
                        <img src="/resources/images/idea.png" />
                    </div>
                </div>
                <form name="knowledgeForm" method="get">
                <input type="hidden" name="page" value="${KnowledgeList.pageable.pageNumber}" />
                <input type="hidden" name="searchTopic" value="${searchTopic }" />
                    <div class="topic-wrap col-12">
                        <ul>
                            <c:choose>
                                <c:when test="${empty cmmCodeList}">
                                    <li>조회된 목록이 없습니다.</li>
                                </c:when>
                                <c:otherwise>
                                    <c:forEach items="${cmmCodeList}" var="topic">
                                        <li id="topic_${topic.cmmCd}" data-value="${topic.cmmCd}">
                                            <a href="javascript:jsSearchTopic('${topic.cmmCd}');">
                                                ${topic.cmmNm}
                                            </a>
                                        </li>
                                    </c:forEach>
                                        <li id="topic-all" class="topic-active">
                                            <a href="javascript:jsSearch();">
                                                전체
                                            </a>
                                        </li>
                                </c:otherwise>
                            </c:choose>
                        </ul>
                    </div>
                    <div class="list-search-wrap col-12 ">
                        <div class="col-12 col-12-small">
                            <div class="col-10">
                                <input type="text" class="form-control" name="searchKeyword" placeholder="검색어를 입력하세요." value="${searchKeyword }"/>
                            </div>
                            <div class="sel-div col-1 div-right">
                                <select class="sel-default" name="size" onChange="jsSearch();">
                                    <option value="10">10</option>
                                    <option value="20">20</option>
                                    <option value="30">30</option>
                                <select>
                            </div>
                        </div>
                        <!--
                        <div class="search-btn col-1 div-left">
                            <button type="button" class="form-control" onClick="jsSearch();">
                                검색
                            </button>
                        </div>
                        -->

                    </div>
                </form>
                <div class="list-item-wrap">
                    <ul>
                        <c:choose>
                            <c:when test="${empty KnowledgeList.content}">
                                조회된 목록이 없습니다.
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${KnowledgeList.content}" var="result">
                                    <li>
                                        <div class="txt-wrap">
                                            <p class="txt-info">
                                                <span class="list-profile">
                                                    <img src="/profile/listImageView?userNo=${result.userDTO.userNo}" alt="Profile" id="profileImg" onerror="this.src='/resources/images/noimages.png'" />
                                                </span>
                                                <span>${result.userDTO.userNickName}</span>
                                            </p>
                                            <h3><a href="javascript:jsView('${result.knNo}')">${result.knTitle}</a></h3>
                                            <p class="hash-tag">
                                                <c:choose>
                                                    <c:when test="${empty TagsList}">
                                                    </c:when>
                                                    <c:otherwise>
                                                        <c:forEach items="${TagsList}" var="tags">
                                                            <c:if test="${tags.htmNo == result.knNo}">
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
                    </ul>

                    <c:choose>
                        <c:when test="${empty UserDTO}">
                        </c:when>
                        <c:otherwise>
                            <button type="button" id="knowledge_writeBtn" class="btn btn-dark div-right" >
                                <img src="/resources/images/pencil-white.png" />
                                작성하기
                            </button>
                        </c:otherwise>
                    </c:choose>
                </div>

                <div class="page-wrap">
                    <ul>
                        <!-- 맨 처음 페이지로  -->
                        <li><a href="javascript:jsSearchPage('0');">&laquo;&laquo;</a></li>
                        <c:choose>
                            <c:when test="${KnowledgeList.pageable.pageNumber > 0 }">
                                <li><a href="javascript:jsSearchPage('${KnowledgeList.pageable.pageNumber -1}');">&laquo;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="javascript:jsSearchPage('0');">&laquo;</a></li>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach begin="${PageDTO.startBlockPage}" end="${PageDTO.endBlockPage}" var = "i">
                            <c:choose>
                                <c:when test="${KnowledgeList.pageable.pageNumber+1 == i}">
                                    <li class="active"><a href="javascript:jsSearchPage('${i-1}');" >${i}</a></li>
                                </c:when>
                                <c:otherwise>
                                    <li><a href="javascript:jsSearchPage('${i-1}');">${i}</a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:choose>
                            <c:when test="${KnowledgeList.pageable.pageNumber + 1 < KnowledgeList.totalPages }">
                                <li><a href="javascript:jsSearchPage('${KnowledgeList.pageable.pageNumber +1}');">&raquo;</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="javascript:jsSearchPage('${KnowledgeList.totalPages -1}');">&raquo;</a></li>
                            </c:otherwise>
                        </c:choose>

                        <li><a href="javascript:jsSearchPage('${KnowledgeList.totalPages -1}');">&raquo;&raquo;</a></li>
                    </ul>
                </div>
            </section>
        </div>
    </div>
</div>

<script>

    $(document).ready(function() {
        jsPageUnit();

        jsTopicSelect();

        // pageUnit Value Set
        function jsPageUnit() {
            const pageUnit = '${KnowledgeList.pageable.pageSize}';

            //console.log(pageUnit);

            $('form[name="knowledgeForm"]').find('select[name="size"]').val(pageUnit).prop("selected", true);
        }
    });

    $("#knowledge_writeBtn").click(function() {
        location.href= "/knowledge/knowledgeWrite";
    });

    // 게시물 상세보기 method : Get
    function jsView(kn_no) {
        location.href = '/knowledge/knowledgeView?knNo='+kn_no;
    }


    function jsSearchPage(page_no) {
        // form hidden에 page value 전달
        $('form[name="knowledgeForm"]').find('input[name="page"]').val(page_no);
        $('form[name="knowledgeForm"]').attr("action", "/knowledge/knowledgeList");
        $('form[name="knowledgeForm"]').submit();
    }

    function jsSearch() {
        $('form[name="knowledgeForm"]').find('input[name="searchTopic"]').val("");
        $('form[name="knowledgeForm"]').attr("action", "/knowledge/knowledgeList");
        $('form[name="knowledgeForm"]').submit();
    }

    // topic search
    function jsSearchTopic(searchTopic) {
        $('form[name="knowledgeForm"]').find('input[name="searchTopic"]').val(searchTopic);
        $('form[name="knowledgeForm"]').attr("action", "/knowledge/knowledgeList");
        $('form[name="knowledgeForm"]').submit();
    }

    // topic active script
    function jsTopicSelect() {
        const topic = $('form[name="knowledgeForm"]').find('input[name="searchTopic"]').val();
        if (topic != "" && topic != null) {
            $("#topic-all").removeClass("topic-active");
            $("#topic_"+topic).addClass("topic-active");
        } else {
            $("#topic-all").addClass("topic-active");
        }
    }
</script>