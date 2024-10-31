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
						<h2>お問い合わせ一覧 </h2>
					</div>
					<div class="card-header py-3 d-flex justify-content-end" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);">						
						<div class="dropdown no-arrow" style="display: flex;align-items: center;">
							<form name="myform" method="get" action="/manage/qna_list.do" class=""  style="display: flex;align-items: center;">
								<input type="text" name="keyword" value="${pageMaker.cri.keyword}" class="form-control" placeholder="Search/blog." style="margin-bottom: 0; height: 30px;">
							</form>
							<a class="dropdown-toggle ml-20" href="#" role="button" id="dropdownMenuLink"
								data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
							</a>
							<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
								aria-labelledby="dropdownMenuLink">
								<div class="dropdown-header">表示基準:</div>
								<a class="dropdown-item" onclick="updateChart('1년')">最新順</a>
								<a class="dropdown-item" onclick="updateChart('1달')">古い順</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" onclick="updateChart('조회수')">全て</a>
								<a class="dropdown-item" onclick="updateChart('게시글')">回答済み</a>
							</div>
						</div>
					</div>
					<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
						<c:forEach var="list" items="${list}">
						<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
							<div class="email-list">
								<div class="email-list-item email-list-item--unread" style="display: flex;align-items: center;">
									<div class="email-list-detail ml-30">
										<div class="mb-1">
											<span class="from">${list.created_at }</span>
										</div>
										<div>
											<a href="#">
												<p class="from" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 565px;">
													${list.q_title }
												</p>
											</a>
										</div>
										<c:if test="${not empty list.a_content }">
										<p class="msg mb-7" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 565px;">
											<span class="from" style="color: #306EE8;">[回答]</span>${list.a_content }
										</p>
										</c:if>
									</div>
								</div>
							</div>
							<div class="email-list">
								<div class="email-list-item email-list-item--unread" style="display: flex;align-items: center;">
									<div class="email-list-detail ml-30 mr-30">
										<div class="mb-1">
											<c:if test="${list.a_yn == 1}">
				                                <span class="from" style="color: #306EE8;">回答済み</span>
				                            </c:if>
				                            <c:if test="${list.a_yn == 0}">
				                                <span class="from" style="color: #FF0000;">未回答</span>
				                            </c:if>
										</div>
									</div>
								</div>
							</div>
						</div>	
						</c:forEach>				
					</div>
					<div class="row text-start pt-5 border-top">
						<div class="col-md-12">
							<div class="custom-pagination">
								<a href="#">←</a>
								<span>1</span>
								<a href="#">2</a>
								<a href="#">3</a>
								<a href="#">4</a>
								<span>/blog.</span>
								<a href="#">15</a>
								<a href="#">→</a>
							</div>
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
    		<span class="visually-hidden">Loading/blog.</span>
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
    
  </body>
  </html>
