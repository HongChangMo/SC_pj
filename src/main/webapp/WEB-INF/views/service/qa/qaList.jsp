<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- Q&A -->
<div class="container">
    <div class="row">
        <div class="col-12 list-wrap">
            <section>
                <div class="list-info">
                    <header>
                        <h2>Q&A</h2>
                    </header>
                    <div class="qa-img">
                        <img src="/resources/images/conversation.png" />
                    </div>
                </div>
                <div class="list-search-wrap">
                    <input type="text" name="" placeholder="검색어를 입력하세요." />
                    <button type="button">
                        검색
                    </button>
                    <select>
                        <option>10</option>
                        <option>20</option>
                        <option>30</option>
                    <select>
                </div>
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
                <div class="paging-wrap">

                </div>
            </section>
        </div>
    </div>
</div>