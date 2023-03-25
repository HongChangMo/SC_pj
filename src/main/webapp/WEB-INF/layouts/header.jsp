<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE HTML>
<html>
	<head>
		<title>SC 프로젝트</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="/resources/assets/css/main.css" />
		<link rel="stylesheet" href="/resources/assets/css/loginRestBtn.css" />



	</head>
	<body class="is-preload homepage">
		<div id="page-wrapper">

			<!-- Header -->
				<div id="header-wrapper">
					<header id="header" class="container">

						<!-- Logo -->
							<div id="logo">
								<h1><a href="/">DS</a></h1>
								<span>Developer Space</span>
							</div>
						<!-- Nav -->
							<nav id="nav">
								<ul>
									<li><a href="/qa/qaList">Q&A</a></li>
									<li><a href="/knowledge/knowledgeList">지식</a></li>
									<li><a href="/community/communityList">커뮤니티</a></li>
									<li><a href="/notice/noticeList">공지사항</a></li>
								</ul>
							</nav>
                                 <button type="button" onclick="location.href='/myPage'" class="registerBtn registerBtn-outline-primary" style="float:right; bottom:-20px; left:20px;">마이페이지</button>
                                 <button type="button" onclick="location.href='/register'" class="registerBtn registerBtn-outline-primary" style="float:right; bottom:-20px; left:20px;">회원가입</button>
                                 <button type="button" onclick="location.href='/login'" class="loginBtn login-outline-primary" style="float:right; bottom:-20px; right:-10px;">로그인</button>

							<div class="search-area">
							    <input type="text" class="search-top" name="" placeholder="검색" />
							    <button type="button">
							        <img src="/resources/images/ico-24-search.svg" alt="검색" />
							    </button>
							</div>


							<!--
                            <div class="login-area">
                                <a href="#">로그인</a>
                                <button type="button">회원가입</button>
                            </div>
                            -->
					</header>

				</div>
