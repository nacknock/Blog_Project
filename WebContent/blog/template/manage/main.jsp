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
					<!-- <div class="box_blog box_visitor mb-30 pt-20" 
					style="display: flex;justify-content: space-around;
					background-color: rgba(0, 0, 0, 0.03);
					border-radius: 5px;border: 1px solid rgba(0, 0, 0, 0.125);">
						<div class="group_item">
							<dl class="count_visitor float-l pr-15">
								<dt>今日のアクセス数</dt>
								<dd>0</dd>
							</dl>
							<dl class="count_visitor float-l pr-15">
								<dt>昨日のアクセス数</dt>
								<dd>0</dd>
							</dl>
							<dl class="count_visitor float-l pr-15">
								<dt>総アクセス数</dt>
								<dd>7</dd>
							</dl>
						</div>
						<div class="group_item">
							<dl class="count_visitor float-l pr-15">
								<dt>今日のコメント数</dt>
								<dd>0</dd>
							</dl>
							<dl class="count_visitor float-l pr-15">
								<dt>昨日のコメント数</dt>
								<dd>0</dd>
							</dl>
							<dl class="count_visitor float-l pr-15">
								<dt>総コメント数</dt>
								<dd>2</dd>
							</dl>
						</div>
					</div>
					<div class="card shadow mb-4"> -->
						<!-- Card Header - Dropdown -->
						<!-- <div
							class="card-header py-3 d-flex flex-row align-items-center justify-content-between">
							<div class="d-flex flex-row align-items-center justify-content-between">
								<h6 class="m-0 font-weight-bold text-primary" id="chart-text">アクセス解析</h6><small id="chart-small">(基準：1年)</small>
							</div>
							<div class="dropdown no-arrow">
								<a class="dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
									data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
									<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
								</a>
								<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
									aria-labelledby="dropdownMenuLink">
									<div class="dropdown-header">Dropdown Header:</div>
									<a class="dropdown-item" onclick="updateChart('1년')">1년</a>
									<a class="dropdown-item" onclick="updateChart('1달')">1달</a>
									<a class="dropdown-item" onclick="updateChart('1일')">1일</a>
									<div class="dropdown-divider"></div>
									<a class="dropdown-item" onclick="updateChart('조회수')">조회수</a>
									<a class="dropdown-item" onclick="updateChart('게시글')">게시글</a>
									<a class="dropdown-item" onclick="updateChart('댓글')">댓글</a>
								</div>
							</div>
						</div> -->
						<!-- Card Body -->
					<!--<div class="card-body">
							<div class="chart-area">
								<canvas id="myAreaChart" style="height: 300px !important;"></canvas>
							</div>
						</div>
					</div> -->
					<div class="sidebar-box">
						<h3 class="heading">最近投稿した記事</h3>
						<c:if test="${empty p_list3}">
						<div class="post-entry-sidebar">
						<h2>最近投稿した記事はありませんでした</h2>
						</div>
						</c:if>
						<div class="post-entry-sidebar">
							<ul>
							<c:forEach var="p_list3" items="${p_list3 }">
								<li>
									<a href="/b/detail.do?blog=${dto.blog.b_idx}&&p=${p_list3.p_idx}">
									<c:if test="${empty p_list3.img_path }">
										<img src="/blog/images/post_not_image.jpg" alt="Image placeholder" class="me-4 rounded">
									</c:if>
									<c:if test="${not empty p_list3.img_path }">
										<img src="/blog/images/${p_list3.img_path }" alt="Image placeholder" class="me-4 rounded">
									</c:if>
										<div class="text">
											<h4>${p_list3.p_title }</h4>
											<div class="post-meta">
												<span class="mr-2">${p_list3.p_ctgr.ctgr_name } / ${p_list3.created_at } /<i class="fa-solid fa-comment"></i> ${p_list3.r_cnt } </span>
											</div>
										</div>
									</a>
								</li>
							</c:forEach>
							</ul>
						</div>
					</div>
					<div class="sidebar-box">
						<h3 class="heading">最近つけたコメント</h3>
						<c:if test="${empty rep_list3}">
						<div class="post-entry-sidebar">
						<h2>最近ついたコメントはありませんでした</h2>
						</div>
						</c:if>
						<div class="post-entry-sidebar">
							<ul>
							<c:forEach var="rep_list3" items="${rep_list3 }">
								<li>
									<a href="/b/detail.do?blog=${dto.blog.b_idx}&&p=${rep_list3.r_p_idx.p_idx}">
									<c:if test="${empty rep_list3.r_p_idx.img_path }">
										<img src="/blog/images/post_not_image.jpg" alt="Image placeholder" class="me-4 rounded">
									</c:if>
									<c:if test="${not empty rep_list3.r_p_idx.img_path }">
										<img src="/blog/images/${rep_list3.r_p_idx.img_path }" alt="Image placeholder" class="me-4 rounded">
									</c:if>
										<div class="text">
										<c:if test="${rep_list3.r_grade eq 0 }">
											<h4>${rep_list3.r_content }</h4>
										</c:if>
										<c:if test="${rep_list3.r_grade eq 1 }">
											<h4><span class="from" style="color: #306EE8;">[返信]</span>${rep_list3.r_content }</h4>
										</c:if>
											<div class="post-meta">
												<span class="mr-2">${rep_list3.r_p_idx.p_title } / ${rep_list3.created_at }</span>
											</div>
										</div>
									</a>
								</li>
							</c:forEach>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<!-- nav start -->
	<!-- nav start -->
	<!-- nav start -->
	<%@ include file="../fragments/footer.jsp"%>
	<!-- nav end -->
	<!-- nav end -->
	<!-- nav end -->

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
    
  </body>
  </html>
