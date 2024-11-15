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
  <!-- Font Awesome CSS -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">

  <!-- util css -->
   <link rel="stylesheet" href="/blog/css/btn.css">
   <link rel="stylesheet" href="/blog/css/mg_pd.css">

	<style>
	.img-link {
    display: inline-block; /* 블록 요소로 설정하여 크기 조정 가능 */
    width: 230px; /* 원하는 너비 */
    height: 130px; /* 원하는 높이 */
    overflow: hidden; /* 넘치는 부분 숨김 */
}

.img-link img {
    width: 100%; /* 부모 요소에 맞게 너비 조정 */
    height: 100%; /* 부모 요소에 맞게 높이 조정 */
    object-fit: cover; /* 비율 유지 및 잘리기 */
}
	</style>

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

  <div class="hero overlay inner-page bg-primary py-5">
    <div class="container">
      <div class="row align-items-center justify-content-center text-center pt-5">
        <div class="col-lg-6">
          <h1 class="heading text-white mb-3" data-aos="fade-up">${dto.blog.b_title }</h1>
        </div>
      </div>
    </div>
  </div>

  <div class="section search-result-wrap">
    <div class="container">
      <div class="row posts-entry">
        <div class="col-lg-8">
        <c:if test="${empty list && empty pageMaker.cri.keyword}">
        <div class="blog-entry d-flex justify-content-center mt-105" style="text-align: center;">
        <h1>このブログにはまだ投稿がありません。</h1>
        </div>
        </c:if>
        <c:if test="${empty list && not empty pageMaker.cri.keyword}">
        <div class="blog-entry d-flex justify-content-center mt-105" style="text-align: center;">
        <h1><b>${pageMaker.cri.keyword}</b> に一致する情報は見つかりませんでした。</h1>
        </div>
        </c:if>
      	<c:forEach var="list" items="${list }">
          <div class="blog-entry d-flex blog-entry-search-item">
            <a href="/b/detail.do?blog=${dto.blog.b_idx}&&p=${list.p_idx}" class="" style="width: 230px;height: 230px;margin-right:24px;">
            <c:if test="${empty list.img_path }">
              <img src="/blog/images/post_not_image.jpg" alt="Image" class="" style="width: 230px;height: 230px;border-radius:10px;">
            </c:if>
            <c:if test="${not empty list.img_path }">
              <img src="/blog/images/${list.img_path }" alt="Image" class="" style="width: 230px;height: 230px;border-radius:10px;">
            </c:if>
            </a>
            <div>
              <span class="date">${list.created_at } &bullet; <a href="#">${list.p_ctgr.ctgr_name }</a></span>
              <c:if test="${list.p_private eq 1 || list.p_ctgr.ctgr_private eq 1}">
				<i class="fa-solid fa-eye-slash pri-i"></i>
			  </c:if>
              <h2><a href="/b/detail.do?blog=${dto.blog.b_idx}&&p=${list.p_idx}">${list.p_title }</a></h2>
              <div style=" display: -webkit-box;-webkit-box-orient: vertical;-webkit-line-clamp: 3;
              overflow: hidden;text-overflow: ellipsis;max-width: 301px;">
              	${list.p_content}
              </div>
              <p><a href="/b/detail.do?blog=${dto.blog.b_idx}&&p=${list.p_idx}" class="btn btn-sm btn-outline-primary">もっと見る</a></p>
            </div>
          </div>
		</c:forEach>
		<div class="custom-pagination">
		<input type="hidden" id="startPage" value="${pageMaker.startPage}">
		<input type="hidden" id="endPage" value="${pageMaker.endPage}">
		<input type="hidden" id="amount" value="${pageMaker.cri.amount}">
		<input type="hidden" id="type" value="${pageMaker.cri.type}">
		<input type="hidden" id="keyword" value="${pageMaker.cri.keyword}">
		<input type="hidden" id="term" value="${pageMaker.cri.term}">
		<c:if test="${pageMaker.prev}">
			<a style="color: #FFF !important;cursor:pointer;" href="/b/list.do?blog=${dto.blog.b_idx }&pageNum=${pageMaker.startPage-1}&amount=${pageMaker.cri.amount}&term=${pageMaker.cri.term}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">←</a>
		</c:if>
		<c:forEach var="page" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			<c:if test="${pageMaker.cri.pageNum == page}">
				<span id="nowpage">${page}</span>
			</c:if>
			<c:if test="${pageMaker.cri.pageNum != page}">
				<a style="cursor:pointer;color: #FFF !important;" href="/b/list.do?blog=${dto.blog.b_idx}&pageNum=${page}&amount=${pageMaker.cri.amount}&term=${pageMaker.cri.term}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">${page}</a>
			</c:if>								
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<a style="cursor:pointer;color: #FFF !important;" href="/b/list.do?blog=${dto.blog.b_idx }&pageNum=${pageMaker.endPage+1}&amount=${pageMaker.cri.amount}&term=${pageMaker.cri.term}&type=${pageMaker.cri.type}&keyword=${pageMaker.cri.keyword}">→</a>
		</c:if>
		</div>
        </div>
        <div class="col-md-12 col-lg-4 sidebar">
          <div class="sidebar-box search-form-wrap">
            <form method="get" action="/b/list.do" class="sidebar-search-form">
              <input type="text" class="form-control" id="s" name="keyword" placeholder="このブログを検索する"　value="${pageMaker.cri.keyword}">
              <input type="hidden" name="blog" value="${dto.blog.b_idx }">
            </form>
          </div>
          <!-- END sidebar-box -->
          <div class="sidebar-box">
            <div class="bio text-center">
              <img src="/blog/images/${dto.user.img_path }" alt="Image Placeholder" class="img-fluid mb-3">
              <div class="bio-body">
                <h2>${dto.user.nickname }</h2>
                <p class="mb-4">
                ${dto.blog.one_liner }
                </p>
              </div>
            </div>
          </div>
          <!-- END sidebar-box -->  
          <div class="sidebar-box">
            <h3 class="heading">人気の記事</h3>
            <div class="post-entry-sidebar">
              <ul>
      			<c:forEach var="top3list" items="${top3list }">
                <li>
                  <a href="/b/detail.do?blog=${dto.blog.b_idx}&&p=${top3list.p_idx}">
                    <c:if test="${empty top3list.img_path }">
		              <img src="/blog/images/post_not_image.jpg" alt="Image placeholder" class="me-4 rounded">
		            </c:if>
		            <c:if test="${not empty top3list.img_path }">
		              <img src="/blog/images/${top3list.img_path }" alt="Image placeholder" class="me-4 rounded">
		            </c:if>
                    <div class="text">
                      <h4>${top3list.p_title }</h4>
                      <div class="post-meta">
                        <span class="mr-2">${top3list.created_at } </span>
                      </div>
                    </div>
                  </a>
                </li>
                </c:forEach>
              </ul>
            </div>
          </div>
          <!-- END sidebar-box -->

          <div class="sidebar-box">
            <h3 class="heading">カテゴリ</h3>
            <ul class="categories">
            <c:forEach var="ctgr_list" items="${ctgr_list }">
            <c:if test="${ctgr_list.ctgr_p_cnt > 0 }">
              <li><a href="/b/list.do?blog=${dto.blog.b_idx}&&type=${ctgr_list.ctgridx}">${ctgr_list.ctgr_name } <span>(${ctgr_list.ctgr_p_cnt })</span></a></li>
            </c:if>
            <c:if test="${ctgr_list.ctgr_p_cnt eq 0 }">
              <li><a >${ctgr_list.ctgr_name } <span>(${ctgr_list.ctgr_p_cnt })</span></a></li>
            </c:if>
            </c:forEach>
            </ul>
          </div>
          <!-- END sidebar-box -->

          <div class="sidebar-box">
            <h3 class="heading">ハッシュタグ</h3>
            <ul class="tags">
            <c:forEach var="taglist" items="${taglist }">
              <li><a href="/b/list.do?blog=${dto.blog.b_idx}&&term=${taglist.tag_name}">#${taglist.tag_name }</a></li>
            </c:forEach>
            </ul>
          </div>
        </div>
      </div>
    </div>
  </div>

  	<!-- footer start -->
	<!-- footer start -->
	<!-- footer start -->
	<%@ include file="fragments/footer.jsp"%>
	<!-- footer end -->
	<!-- footer end -->
	<!-- footer end -->

    <!-- Preloader -->

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
