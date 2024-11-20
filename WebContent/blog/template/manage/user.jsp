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
						<h2>プロフィールの設定 </h2>
					</div>
					<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
						<form name="update" method="post" enctype="multipart/form-data" action="/manage/user_update.do" onsubmit="return check()">
							<div class="post-entry-sidebar" style="display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: center;">
								<div class="email-list">
									<div class="email-list-item email-list-item--unread">									
										<div class="email-list-detail pb-30" style="text-align: center;">
											<p class="msg mb-7 ml-15 pt-15 pb-15" style="color: #000;">
												画像を変更
											</p>
											<input type="hidden" name="idx" id="idx" value="${dto.user.idx }">
											<input type="file" class="form-control mb-30" name="img" id="img" style="height: 38px;">
											<input type="hidden" name="imgurl" value="/blog/images/${dto.user.img_path}">
											<img src="/blog/images/${dto.user.img_path}" id="preview" style="width:168px;height:168px;">
										</div>
									</div>
								</div>
							</div>
							<div class="post-entry-sidebar mb-30" style="display: flex;flex-direction: column;">
								<div class="mt-15" style="display: flex;justify-content: center;">
									<div>
										<h4 style="color: #000;">ID</h4>
									</div>
									<div class="ml-15">
										<input class="form-control" disabled type="text" id="user_id" name="user_id" value="${dto.user.user_id }" style="height: 30px; background: white !important;">
									</div>
								</div>
								<div class="mt-15 ml-68" style="display: flex;justify-content: center;">
									<div>
										<h4 style="color: #000;">メール</h4>
									</div>
									<div class="ml-15">
										<input class="form-control" type="text" id="email" name="email" value="${dto.user.email }" style="height: 30px; background: white !important;">
									</div>
									<div>
										<button type="button" id="btn-email" class="btn btn-sm btn-primary ml-10" style="height: 30px;display: flex;align-items: center;">
											<span>メール認証</span>
										</button>
									</div>
								</div>
								<div class="mt-15 ml-28" style="display: flex;justify-content: center;"><!-- 기본 none 블럭 -->
									<div>
										<h4 style="color: #000;">認証コード</h4>
									</div>
									<div class="ml-15">
										<input class="form-control" type="text" id="certinumber" name="auth_num" style="height: 30px; background: white !important;">
									</div>
									<div>
										<button type="button" id="email_ok" class="btn btn-sm btn-warning ml-10" style="height: 30px;display: flex;align-items: center;">
											<span>コードを入力</span>
										</button>
									</div>
								</div>
								<div class="mt-15 mr-120" style="display: flex;justify-content: center;">
									<div>
										<h4 style="color: #000;">ニックネーム</h4>
									</div>
									<div class="ml-15">
										<input class="form-control" type="text" id="nickname" value="${dto.user.nickname }" name="nickname" style="height: 30px; background: white !important;">
									</div>
								</div>
								<div class="mt-15 mr-70" style="display: flex;justify-content: center;">
									<div>
										<h4 style="color: #000;">ブログ名</h4>
									</div>
									<div class="ml-15">
										<input class="form-control" type="text" id="b_title" name="b_title" value="${dto.blog.b_title }" style="height: 30px; background: white !important;">
									</div>
								</div>
								<div class="mt-15 mr-25" style="display: flex;justify-content: center;">
									<div>
										<h4 style="color: #000;">説明</h4>
									</div>
									<div class="ml-15">
										<textarea class="form-control" id="one_liner" name="one_liner" style="resize: none; width: 216px; height: 120px !important; background: white !important;">
										<c:if test="${not empty dto.blog.one_liner }">
											${dto.blog.one_liner }
										</c:if>
										</textarea>
									</div>
								</div>
							</div>
							<div class="mt-15" style="margin-bottom: 15px !important; display: flex;justify-content: center;">
								<button type="submit" id="btn_submit" class="btn btn-sm btn-outline-primary">変更を保存</button>
							</div>
						</form>							
					</div>
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


    <script src="/blog/js/aos.js"></script>
    <script src="/blog/js/glightbox.min.js"></script>
    <script src="/blog/js/navbar.js"></script>
    <script src="/blog/js/counter.js"></script>
    <script src="/blog/js/custom.js"></script>

    <!-- Page level plugins -->
    <script src="/blog/js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/blog/js/chart-area-demo.js"></script><!-- 사각 그래프 -->
    
    <script src="/blog/js/manage_user.js"></script>
    
  </body>
  </html>
