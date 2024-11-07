<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!-- /*
* Template Name: Blogy
* Template Author: Untree.co
* Template URI: https://untree.co/
* License: https://creativecommons.org/licenses/by/3.0/
*/ -->
<!doctype html>
<html lang="en">
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="author" content="Untree.co">
	<link rel="shortcut icon" href="favicon.png">

	<meta name="description" content="" />
	<meta name="keywords" content="bootstrap, bootstrap5" />

	<link rel="preconnect" href="https://fonts.googleapis.com">
	<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
	<link href="https://fonts.googleapis.com/css2?family=Work+Sans:wght@400;600;700&display=swap" rel="stylesheet">


	<link rel="stylesheet" href="/blog/fonts/icomoon/style.css">
	<link rel="stylesheet" href="/blog/fonts/flaticon/font/flaticon.css">

	<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.1/font/bootstrap-icons.css">

	<link rel="stylesheet" href="/blog/css/tiny-slider.css">
	<link rel="stylesheet" href="/blog/css/aos.css">
	<link rel="stylesheet" href="/blog/css/glightbox.min.css">
	<link rel="stylesheet" href="/blog/css/style.css">

	<link rel="stylesheet" href="/blog/css/flatpickr.min.css">
	
	<!-- util css -->
	<link rel="stylesheet" href="/blog/css/mg_pd.css">
	<link rel="stylesheet" href="/blog/css/btn.css">

	<!-- Font Awesome CSS -->
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
	<link rel="stylesheet" href="/blog/css/material-design-iconic-font/css/materialdesignicons.min.css">

	<title>Blogy &mdash; Free Bootstrap 5 Website Template by Untree.co</title>
</head>
<body>

	<div class="site-mobile-menu site-navbar-target">
		<div class="site-mobile-menu-header">
			<div class="site-mobile-menu-close">
				<span class="icofont-close js-menu-toggle"></span>
			</div>
		</div>
		<div class="site-mobile-menu-body"></div>
	</div>

	<!-- nav start -->
	<!-- nav start -->
	<!-- nav start -->
	<%@ include file="../fragments/navbar.jsp"%>
	<!-- nav end -->
	<!-- nav end -->
	<!-- nav end -->

	<div class="section search-result-wrap">
		<div class="container">
			<div class="row posts-entry tab-content" id="myTabContent">
				<!-- sidebar start -->
				<!-- sidebar start -->
				<!-- sidebar start -->
				<%@ include file="../fragments/manage_sidebar.jsp"%>
				<!-- sidebar end -->
				<!-- sidebar end -->
				<!-- sidebar end -->
				<div class="col-lg-8 tab-pane fade show active ml-45" id="home" role="tabpanel" aria-labelledby="home-tab">
					<div class="col-12 mt-15 mb-15 pr-15 pl-15">
						<h2>カテゴリ管理</h2>
					</div>
					<!-- <div class="card-header py-3 d-flex flex-row align-items-center justify-content-between" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);">
						<div class="d-flex flex-row align-items-center justify-content-between">
							<div class="email-list-actions mr-30 ml-15 pt-7">
								<label class="custom-control custom-checkbox">
									<input class="custom-control-input checkboxes" type="checkbox" value="1" id="one" style="width: 20px;height: 20px;">
								</label>
							</div>
							<h6 class="m-0 font-weight-bold text-primary" id="chart-text">全選択</h6>
							<div class="dropdown no-arrow">
								<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
									aria-labelledby="dropdownMenuLink">
									<div class="dropdown-header">アクション選択:</div>
									<a class="dropdown-item" onclick="updateChart('1년')">公開</a>
									<a class="dropdown-item" onclick="updateChart('1달')">非公開</a>
									<a class="dropdown-item" onclick="updateChart('1일')">削除</a>
								</div>
							</div>
						</div>
					</div> -->
					<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
						<c:if test="${empty list}">
							<div div class="post-entry-sidebar" id="none-div" style=" height: 80px;display: flex;align-items: center;justify-content:center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);">
								<h3>まだカテゴリを作ってありません。</h3>
							</div>
						</c:if>
						<div id="for-box">
						<c:forEach var="list" items="${list}">
							<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
								<div class="email-list">
									<div class="email-list-item email-list-item--unread" style="display: flex;align-items: center;">
										<div class="email-list-actions mr-30 ml-30 pt-7">
											<!-- <label class="custom-control custom-checkbox">
												<input class="custom-control-input checkboxes" type="checkbox" value="1" id="one" style="width: 20px;height: 20px;">
											</label> -->
										</div>
										<div class="email-list-detail" style="display: flex;">
											<input type="hidden" value="${list.ctgridx }" name="ctgridx" class="ctgridx">
											<p class="msg mb-7 ctgr_name" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 365px;">
												${list.ctgr_name }
											</p>
											<input class="input none-input" type="text" value="${list.ctgr_name }" style="display: none;">
											<button class="btn btn-sm btn-danger can-btn" style="display:none;margin-right: 15px;" type="button" onclick="up_cancel(this)">キャンセル</button>
											<button class="btn btn-sm btn-primary sub-btn" style="display:none;width: 99.6px;" type="button" onclick="upAction(this)">保存</button>
											<p class="ml-5 cnt-p">(${list.ctgr_p_cnt })</p>
										</div>
									</div>
								</div>
								<div class="dropdown no-arrow">
									<c:if test="${list.ctgr_private eq 0}">
									<i class="fa-solid fa-eye pri-i"></i><!-- 공개 설정되어있을때 -->
									</c:if>
									<c:if test="${list.ctgr_private eq 1}">
									<i class="fa-solid fa-eye-slash pri-i"></i>
									</c:if>
									<a class="dropdown-toggle mr-17" href="#" role="button" id="dropdownMenuLink"
										data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
										<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
									</a>
									<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
										aria-labelledby="dropdownMenuLink">
										<div class="dropdown-header">オプション:</div>
										<a class="dropdown-item" onclick="update(this)">編集</a>
										<c:if test="${list.ctgr_p_cnt eq 0}">
										<a class="dropdown-item" onclick="del(this)">削除</a>
										</c:if>
										<div class="dropdown-divider"></div>
										<input type="hidden" value="${list.ctgr_private}" class="private">
										<c:if test="${list.ctgr_private eq 1}">
										<a class="dropdown-item pri-a" onclick="chngePriv(this)">公開</a>
										</c:if>
										<c:if test="${list.ctgr_private eq 0}">
										<a class="dropdown-item pri-a" onclick="chngePriv(this)">非公開</a>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
						</div>
						<div>
							<div class="post-entry-sidebar" id="input_box" style="display: none;height: 80px;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
								<div class="col-7" style="width: 60%;height: 100%;">
									<input type="hidden" name="b_idx" id="b_idx" value="${dto.blog.b_idx}">
									<input type="text" name="ctgr_name" id="ctgr_name" style="border-radius: 4px;border-color: #214252;height: 70%;width: 80%;margin-left: 50px;margin-top: 12px;">
								</div>
								<div class="col-5 d-flex justify-content-center">
									<button class="btn btn-sm btn-danger" style="margin-right: 15px;" type="button" id="cancel_btn">キャンセル</button>
									<button class="btn btn-sm btn-primary" style="width: 99.6px;" type="button" id="submit_btn">保存</button>
								</div>
							</div>			
							<div class="post-entry-sidebar" id="add_box" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
								<button type="button" id="addbtn" style="background-color: transparent;
											border: none;color: inherit;
											cursor: pointer;
											width: 100%;
											height: 100%;text-align: center;padding-top: 5px;">
											<h3>+カテゴリを追加する</h3>
								</button>
							</div>		
						</div>		
					</div>
					<!-- <div class="col-12 mt-55 mb-15 pr-15 pl-15" style="display: flex;justify-content: center;">
						<button type="button" class="btn btn-sm btn-outline-primary">保存</button>
					</div>					 -->
				</div>
			</div>
		</div>
	</div>

	<!-- footer start -->
	<!-- footer start -->
	<!-- footer start -->
	<%@ include file="../fragments/footer.jsp"%>
	<!-- footer end -->
	<!-- footer end -->
	<!-- footer end -->

    <!-- Preloader -->
    <div id="overlayer"></div>
    <div class="loader">
    	<div class="spinner-border text-primary" role="status">
    		<span class="visually-hidden">Loading...</span>
    	</div>
    </div>


    <script src="/blog/js/jquery/jquery.min.js"></script>
    <script src="/blog/js/bootstrap.bundle.min.js"></script>
	<script src="/blog/js/bootstrap.bundle.js"></script>
    <script src="/blog/js/tiny-slider.js"></script>

    <script src="/blog/js/flatpickr.min.js"></script>

	<script src="/blog/js/category.js"></script>


    <script src="/blog/js/aos.js"></script>
    <script src="/blog/js/glightbox.min.js"></script>
    <script src="/blog/js/navbar.js"></script>
    <script src="/blog/js/counter.js"></script>
    <script src="/blog/js/custom.js"></script>
    
  </body>
  </html>
