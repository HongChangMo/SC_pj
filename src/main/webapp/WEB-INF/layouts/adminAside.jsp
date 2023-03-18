<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!-- ======= Sidebar ======= -->
  <aside id="sidebar" class="sidebar">

    <ul class="sidebar-nav" id="sidebar-nav">

      <li class="nav-item">
        <a class="nav-link " href="/admin">
          <i class="bi bi-house"></i>
          <span>홈</span>
        </a>
      </li><!-- End Dashboard Nav -->
    <!-- Start 공지사항 Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="/admin/notice/noticeList">
          <i class="bi bi-megaphone"></i>
            <span>공지사항</span>
        </a>
      </li><!-- End 공지사항 Nav -->

      <!-- Start 사용자 관리 Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#">
          <i class="bi bi-people"></i>
          <span>사용자 관리</span>
        </a>
      </li><!-- End 사용자 관리 Nav -->

      <!-- Start 신고내역 Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" data-bs-target="#charts-nav" data-bs-toggle="collapse" href="#">
          <i class="bi bi-exclamation-circle"></i><span>신고내역</span><i class="bi bi-chevron-down ms-auto"></i>
        </a>
        <ul id="charts-nav" class="nav-content collapse " data-bs-parent="#sidebar-nav">
          <li>
            <a href="#">
              <i class="bi bi-circle"></i><span>게시물 신고내역</span>
            </a>
          </li>
          <li>
            <a href="#">
              <i class="bi bi-circle"></i><span>댓글 신고내역</span>
            </a>
          </li>
        </ul>
      </li><!-- End 신고내역 Nav -->

      <!-- Start 해시태그 관리 Nav -->
      <li class="nav-item">
        <a class="nav-link collapsed" href="#">
          <i class="bi bi-tags"></i>
          <span>해시태그 관리</span>
        </a>
      </li><!-- End 해시태그 관리 Nav -->
  </aside><!-- End Sidebar-->