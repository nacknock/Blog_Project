<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
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
						<h2>記事の管理 <small id="cnt-text"></small></h2>
						<input type="hidden" value="${ dto.blog.b_idx}" id="b_idx" name="b_idx">
					</div>
					<div class="card-header py-3 d-flex flex-row align-items-center justify-content-between" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);">
						<div class="d-flex flex-row align-items-center justify-content-between">
							<!--  <div class="email-list-actions mr-30 ml-15 pt-7">
								<label class="custom-control custom-checkbox">
									<input class="custom-control-input checkboxes" type="checkbox" value="1" id="one" style="width: 20px;height: 20px;">
								</label>
							</div>
							<h6 class="m-0 font-weight-bold text-primary" id="chart-text">일괄 적용</h6>
							<div class="dropdown no-arrow">
								<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
									aria-labelledby="dropdownMenuLink">
									<div class="dropdown-header">상태 변경:</div>
									<a class="dropdown-item" onclick="updateChart('1년')">공개</a>
									<a class="dropdown-item" onclick="updateChart('1달')">비공개</a>
									<a class="dropdown-item" onclick="updateChart('1일')">삭제</a>
								</div>
							</div> -->
						</div>
						<div class="dropdown no-arrow" style="display: flex;align-items: center;">
							<form name="myform" method="get" class=""  style="display: flex;align-items: center;" onsubmit="return page_keyword(event);">
								<input type="text" name="keyword" value="${pageMaker.cri.keyword}" class="form-control" placeholder="検索" style="margin-bottom: 0; height: 30px;">
							</form>
							<a class="dropdown-toggle ml-20" href="#" role="button" id="dropdownMenuLink"
								data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
							</a>
							<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
								aria-labelledby="dropdownMenuLink">
								<div class="dropdown-header">表示基準:</div>
								<a class="dropdown-item" onclick="page_term('desc')">最新順</a>
								<a class="dropdown-item" onclick="page_term('asc')">古い順</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" onclick="page_type('up')"> 閲覧数が多い順 </a>
								<a class="dropdown-item" onclick="page_type('down')">閲覧数が少ない順</a>
							</div>
						</div>
					</div>
					<div id="p-paging">
					</div>
					<div class="col-12 mt-55 mb-15 pr-15 pl-15">
						<h2>設定</h2>
					</div>
					<div class="sidebar-box" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
						<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: center;">
							<div class="email-list">
								<div class="email-list-item email-list-item--unread">									
									<div class="email-list-detail" style="width: 450px;">
										<p class="msg mb-7 ml-15 float-l" style="color: #000;">
											記事を投稿する際の初期設定は
										</p>
										<select class="float-l mr-15 ml-15" id="p_pri_yn">
										<c:if test="${dto.blog.p_pri_yn eq 0 }">
											<option value="0">公開</option>
											<option value="1">非公開</option>
										</c:if>
										<c:if test="${dto.blog.p_pri_yn eq 1 }">
											<option value="1">非公開</option>
											<option value="0">公開</option>
										</c:if>
										</select>
										<p>に設定します。</p>
									</div>
								</div>
							</div>
						</div>				
						<div class="mt-15" style="margin-bottom: 15px !important; display: flex;justify-content: center;">
							<button type="button" class="btn btn-sm btn-outline-primary" onclick="chngeB_priv(${dto.blog.b_idx })">保存</button>
						</div>							
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
    <script src="/blog/js/post_manage.js"></script>
    
  </body>
  </html>
