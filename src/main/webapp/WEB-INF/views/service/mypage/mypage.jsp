<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

			<!-- Features -->
					<div class="container">
						<div class="row">
							<div class="col-6 content-wrap">
                                <section>
                                        <div class="col-xl-4">
                                          <div class="">
                                            <div class="">
                                              <h2>회원정보</h2>
                                            </div>
                                          </div>
                                        </div>
                                        <div class="" style="position: relative; left: 50%;">
                                          <div class="">
                                            <div class="">
                                              <div class="">
                                                <div class="" id="profile-edit">
                                                  <!-- Profile Edit Form -->
                                                  <form>
                                                    <div class="profile-header" style="position: relative; left: 40%;">
                                                      <label for="profileImage" class="" style="position: relative; left: 16px;">Profile Image</label>
                                                      <div class="">
                                                        <img src="/resources/NiceAdmin/assets/img/profile-img.jpg" alt="Profile" style="border-radius: 60px;">
                                                        <div class="">
                                                          <a href="#" class="btn btn-primary btn-sm" title="Upload new profile image"><i class=""></i></a>
                                                          <a href="#" class="btn btn-danger btn-sm" title="Remove my profile image"><i class=""></i></a>
                                                        </div>
                                                      </div>

                                                    </div>

                                                    <div class="content-info col-12 col-13-small">
                                                        <div class="content-title col-12">
                                                            <label for="input_title" class="col-sm-1 col-form-label">이름</label>
                                                            <input id="input_title" class="form-control" name="title"/>
                                                        </div>
                                                        <div class="content-title col-12">
                                                            <label for="input_title" class="col-sm-1 col-form-label">비밀번호</label>
                                                            <input id="input_title" class="form-control" name="title"/>
                                                        </div>

                                                        <div class="content-title col-12">
                                                            <label for="input_title" class="col-sm-1 col-form-label">비밀번호 확인</label>
                                                            <input id="input_title" class="form-control" name="title"/>
                                                        </div>

                                                        <div class="content-title col-12">
                                                            <label for="input_title" class="col-sm-1 col-form-label">닉네임</label>
                                                            <input id="input_title" class="form-control" name="title"/>
                                                        </div>

                                                        <div class="content-title col-12">
                                                            <label for="input_title" class="col-sm-1 col-form-label">핸드폰 번호</label>
                                                            <input id="input_title" class="form-control" name="title"/>
                                                        </div>
                                                        <br/>
                                                        <button type="button" id="" class="btn btn-dark div-right" style="float:right;">
                                                            <img src="/resources/images/pencil-white.png" />
                                                            수정
                                                        </button>
                                                    </div>
                                                  </form><!-- End Profile Edit Form -->
                                                </div>

                                              </div><!-- End Bordered Tabs -->

                                            </div>
                                          </div>

                                        </div>

                                    </section>
                            </div>
						</div>
					</div>