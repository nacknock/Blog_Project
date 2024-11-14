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
						<h2>お問い合わせ </h2>
					</div>
					<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
						<div class="form-group col-md-12">
							<div>
								<input disabled style="border-top: none;border-left: none;border-right: none; text-align: center;" class="form-control" type="text" name="p_title" id="p_title" value="${q_ctgr }">
							</div>
							<div>
								<input disabled style="border-top: none;border-left: none;border-right: none; text-align: center;" class="form-control" type="text" name="p_title" id="p_title" value="${q_vo.q_title }">
							</div>
							<div class="col-12">
								<textarea id="txt_detail" disabled class="form-control" name="q_detail" rows="15"
								style="resize:none;background: white !important;">${q_vo.q_content }</textarea>
							</div>
							<div style="text-align: center;">
								<c:if test="${not empty q_vo.q_img }">
								<h3 class="mt-30 mb-30" style="color: #000;">添付ファイル</h3>
								<div class="pt-30 pb-30" style="border-bottom: 1px solid rgba(0, 0, 0, 0.125);border-top: 1px solid rgba(0, 0, 0, 0.125);">
									<img src="/blog/images/${q_vo.q_img }" style="width: 300px;height: 300px;">
								</div>
								</c:if>
								<c:if test="${empty q_vo.q_img }">
								<h3 class="mt-30 mb-30" style="color: #000;"></h3>
								</c:if>
							</div>
						</div>					
					</div>
					<c:if test="${not empty a_vo }">
					<div class="col-12 mt-15 mb-15 pr-15 pl-15">
						<h2>回答 </h2>
					</div>
					<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
						<div class="form-group col-md-12">
							<div>
								<input disabled style="border-top: none;border-left: none;border-right: none; text-align: center;" class="form-control" type="text" name="p_title" id="p_title">
							</div>
							<div class="col-12">
								<textarea id="txt_detail" disabled class="form-control" id=""a_content"" name="a_content" rows="15"
								style="resize:none;background: white !important;">${a_vo.a_content }</textarea>
							</div>
							<div class="col-12 d-flex justify-content-center pt-30 pb-30">
							<input type="hidden" value="${a_vo.a_idx }" name="a_idx" id="a_idx">
							<c:if test="${a_vo.raiting == 0 }">
								<div class="col-6 d-flex align-items-center" style="flex-direction:column;">
									<label class="mb-30">回答の満足度はいかがでしたか？</label>
									<div class="mb-30" style="font-size: xx-large;color:#214252;">
										<i class="fa-regular fa-face-angry" onclick="raiting(1)"></i><!-- <i class="fa-solid fa-face-angry"></i> -->
										<i class="fa-regular fa-face-frown" onclick="raiting(2)"></i><!-- <i class="fa-solid fa-face-frown"></i> -->
										<i class="fa-regular fa-face-meh" onclick="raiting(3)"></i><!-- <i class="fa-solid fa-face-meh"></i> -->
										<i class="fa-regular fa-face-smile" onclick="raiting(4)"></i><!-- <i class="fa-solid fa-face-smile"></i> -->
										<i class="fa-regular fa-face-laugh" onclick="raiting(5)"></i><!-- <i class="fa-solid fa-face-laugh"></i> -->
									</div>
								</div>
							</c:if>
							<c:if test="${a_vo.raiting != 0 }">
								<div class="col-6 d-flex align-items-center" style="flex-direction:column;">
									<label class="mb-30">評価いただきありがとうございます。</label>
									<div class="mb-30" style="font-size: xx-large;color:#214252;">
										<c:if test="${a_vo.raiting >= 1}"><i class="fa-solid fa-face-angry"></i></c:if><!-- <i class="fa-solid fa-face-angry"></i> -->
                                        <c:if test="${a_vo.raiting == 0 }"><i class="fa-regular fa-face-angry"></i></c:if>
                                        <c:if test="${a_vo.raiting >= 2 }"><i class="fa-solid fa-face-frown"></i></c:if>
                                        <c:if test="${a_vo.raiting < 2 }"><i class="fa-regular fa-face-frown"></i></c:if>
                                        <c:if test="${a_vo.raiting >= 3 }"><i class="fa-solid fa-face-meh"></i></c:if>
                                        <c:if test="${a_vo.raiting < 3 }"><i class="fa-regular fa-face-meh"></i></c:if>
                                        <c:if test="${a_vo.raiting >= 4 }"><i class="fa-solid fa-face-smile"></i></c:if>
                                        <c:if test="${a_vo.raiting < 4 }"><i class="fa-regular fa-face-smile"></i></c:if>
                                        <c:if test="${a_vo.raiting == 5 }"><i class="fa-solid fa-face-laugh"></i></c:if>
                                        <c:if test="${a_vo.raiting < 5 }"><i class="fa-regular fa-face-laugh"></i></c:if>
									</div>
								</div>
							</c:if>
							</div>
						</div>					
					</div>
					</c:if>
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
    <script src="/blog/js/q_detail.js"></script>
    
  </body>
  </html>
