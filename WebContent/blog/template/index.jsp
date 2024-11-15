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
	<%@ include file="fragments/navbar.jsp"%>
	<!-- nav end -->
	<!-- nav end -->
	<!-- nav end -->

	<!-- Start retroy layout blog posts -->
	<!-- 전 카테고리 추천 섹션 start -->
	<!-- 전 카테고리 추천 섹션 start -->
	<!-- 전 카테고리 추천 섹션 start -->
	<section class="section bg-light">
		<div class="container">
			<div class="row align-items-stretch retro-layout">
			<c:forEach var="list" items="${hitTop6list}">
				<div class="col-md-4">
					<a href="/b/list.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}" class="h-entry mb-30 v-height gradient">
					<c:if test="${empty list.img_path }">
		              <div class="featured-img" style="background-image: url('/blog/images/post_not_image.jpg');"></div>
		            </c:if>
		            <c:if test="${not empty list.img_path }">
		              <div class="featured-img" style="background-image: url('/blog/images/${list.img_path }');"></div>
		            </c:if>

						<div class="text">
							<span class="date">${list.created_at}</span>
							<h2>${list.p_title}</h2>
						</div>
					</a>
				</div>
			</c:forEach>
			</div>
		</div>
	</section>	
	<!-- 전 카테고리 추천 섹션 end -->
	<!-- 전 카테고리 추천 섹션 end -->
	<!-- 전 카테고리 추천 섹션 end -->
	<!-- End retroy layout blog posts -->

	<!-- Start posts-entry -->
	<!-- Business section start -->
	<!-- Business section start -->
	<!-- Business section start -->
	<section class="section posts-entry">
		<div class="container">
			<div class="row mb-4">
				<div class="col-sm-6">
					<h2 class="posts-entry-title">#${tag1}</h2>
				</div>
			</div>
			<div class="row g-3">
				<div class="col-md-9">
					<div class="row g-3">
					<c:forEach var="list" items="${cate1list5}">
						<c:if test="${list.rn eq 1 or list.rn eq 2}">
						<div class="col-md-6">
							<div class="blog-entry">
								<a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}" class="img-link">
									<c:if test="${empty list.img_path }">
									<img src="/blog/images/post_not_image.jpg" alt="Image" class="img-fluid" style="width: 476px;height: 476px;">
									</c:if>
									<c:if test="${not empty list.img_path }">
									<img src="/blog/images/${list.img_path }" alt="Image" class="img-fluid" style="width: 476px;height: 476px;">
									</c:if>
								</a>
								<span class="date">${list.created_at}</span>
								<h2><a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}">${list.p_title}</a></h2>
								<p style=" display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;
              					overflow: hidden;text-overflow: ellipsis;max-width: 476px;">${list.p_content}</p>
								<p><a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}"class="btn btn-sm btn-outline-primary">もっと見る</a></p>
							</div>
						</div>
						</c:if>
					</c:forEach>
					</div>
				</div>
				<div class="col-md-3">
					<ul class="list-unstyled blog-entry-sm">
					<c:forEach var="list" items="${cate1list5}">
						<c:if test="${list.rn eq 3 or list.rn eq 4 or list.rn eq 5 or list.rn eq 6 or list.rn eq 7}">
						<li>
							<span class="date">${list.created_at}</span>
							<h3><a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}">${list.p_title}</a></h3>
							<p style=" display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 3;
              				overflow: hidden;text-overflow: ellipsis;max-width: 312px;">${list.p_content}</p>
							<p><a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}" class="read-more">続きを読む</a></p>
						</li>
						</c:if>
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- End posts-entry -->

	<!-- Start posts-entry -->
	
	<!-- Business section end -->
	<!-- Business section end -->
	<!-- Business section end -->
	<!-- End posts-entry -->

	<!-- Start posts-entry -->
	<!-- Culture section start -->
	<!-- Culture section start -->
	<!-- Culture section start -->
	<section class="section posts-entry">
		<div class="container">
			<div class="row mb-4">
				<div class="col-sm-6">
					<h2 class="posts-entry-title">#${tag2}</h2>
				</div>
			</div>
			<div class="row g-3">
				<div class="col-md-9 order-md-2">
					<div class="row g-3">
					<c:forEach var="list" items="${cate2list5}">
						<c:if test="${list.rn eq 1 or list.rn eq 2}">
						<div class="col-md-6">
							<div class="blog-entry">
								<a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}" class="img-link">
									<c:if test="${empty list.img_path }">
									<img src="/blog/images/post_not_image.jpg" alt="Image" class="img-fluid" style="width: 476px;height: 476px;">
									</c:if>
									<c:if test="${not empty list.img_path }">
									<img src="/blog/images/${list.img_path }" alt="Image" class="img-fluid" style="width: 476px;height: 476px;">
									</c:if>
								</a>
								<span class="date">${list.created_at}</span>
								<h2><a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}">${list.p_title}</a></h2>
								<p style=" display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 2;
              					overflow: hidden;text-overflow: ellipsis;max-width: 476px;">${list.p_content}</p>
								<p><a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}" class="btn btn-sm btn-outline-primary">もっと見る</a></p>
							</div>
						</div>
					</c:if>
				</c:forEach>
					</div>
				</div>
				<div class="col-md-3">
					<ul class="list-unstyled blog-entry-sm">
					<c:forEach var="list" items="${cate2list5}">
						<c:if test="${list.rn eq 3 or list.rn eq 4 or list.rn eq 5 or list.rn eq 6 or list.rn eq 7}">
						<li>
							<span class="date">${list.created_at}</span>
							<h3><a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}">${list.p_title}</a></h3>
							<p style=" display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 3;
              					overflow: hidden;text-overflow: ellipsis;max-width: 476px;">${list.p_content}</p>
							<p><a href="/b/detail.do?blog=${list.p_b_idx.b_idx}&&p=${list.p_idx}" class="read-more">続きを読む</a></p>
						</li>
						</c:if>
					</c:forEach>
					</ul>
				</div>
			</div>
		</div>
	</section>
	<!-- Culture section end -->
	<!-- Culture section end -->
	<!-- Culture section end -->

	<!-- Travle section start -->
	<!-- Travle section start -->
	<!-- Travle section start -->
	
	<!-- Travle section end -->
	<!-- Travle section end -->
	<!-- Travle section end -->

	<!-- footer start -->
	<!-- footer start -->
	<!-- footer start -->
	<%@ include file="fragments/footer.jsp"%>
	<!-- footer end -->
	<!-- footer end -->
	<!-- footer end -->

    <!-- Preloader start -->
    <!-- Preloader start -->
    <!-- Preloader start -->
    <div id="overlayer"></div>
    <div class="loader">
    	<div class="spinner-border text-primary" role="status">
    		<span class="visually-hidden">Loading...</span>
    	</div>
    </div>
    <!-- Preloader end -->
    <!-- Preloader end -->
    <!-- Preloader end -->


    <script src="/blog/js/bootstrap.bundle.min.js"></script>
    <script src="/blog/js/tiny-slider.js"></script>

    <script src="/blog/js/flatpickr.min.js"></script>


    <script src="/blog/js/aos.js"></script>
    <script src="/blog/js/glightbox.min.js"></script>
    <script src="/blog/js/navbar.js"></script>
    <script src="/blog/js/counter.js"></script>
    <script src="/blog/js/custom.js"></script>

    
  </body>
  </html>
