<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<%@ include file="fragments/navbar.jsp"%>
	<!-- nav end -->
	<!-- nav end -->
	<!-- nav end -->

  <div class="site-cover site-cover-sm same-height single-page" style="background:#214252 !important;">
    <div class="container">
      <div class="row same-height justify-content-center">
        <div class="col-md-6">
          <div class="post-entry text-center">
              <input type="hidden" name="blog" value="${dto.blog.b_idx }" id="blog">
            <h1 class="mb-4">${vo.p_title }</h1>
            <div class="post-meta align-items-center text-center">
            <c:if test="${not empty dto.user.img_path }">
              <figure class="author-figure mb-0 me-3 d-inline-block"><img src="/blog/images/${dto.user.img_path }" alt="Image" class="img-fluid"></figure>
            </c:if>
            <c:if test="${empty dto.user.img_path }">
              <figure class="author-figure mb-0 me-3 d-inline-block"><img src="/blog/images/default_profile.png" alt="Image" class="img-fluid"></figure>
            </c:if>
              <span class="d-inline-block mt-1">${dto.user.nickname}</span>
              <span>&nbsp;-&nbsp; <c:out value="${fn:substring(vo.created_at, 0, 10)}" /></span>
              <span>&nbsp;-&nbsp; ${vo.p_ctgr.ctgr_name}</span>
              <span>&nbsp;-&nbsp; ${vo.hit}</span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>

  <section class="section">
    <div class="container">

      <div class="row blog-entries element-animate">

        <div class="col-md-12 col-lg-8 main-content">

          <div class="post-content-body">
              
            <c:if test="${not empty vo.img_path}">
	          <div class="col-md-12 mb-4">
                <img src="/blog/images/${vo.img_path }" alt="Image" class="img-fluid">
              </div>
	        </c:if>
          	${vo.p_content }
          </div>


          <div class="pt-5">
            <p>
            <c:forEach var="Ptaglist" items="${Ptaglist }">
            	<a href="#">#${Ptaglist.tag_name }</a>
           	</c:forEach>
            </p>
          </div>
          <div class="pt-5 d-flex">
          <c:if test="${my eq true}">
            <form method="post" action="/manage/openP_modify.do">
	            <input type="hidden" name="p_idx" value="${vo.p_idx }">
	            <button type="submit" style="background-color: transparent;border: none; color: black;cursor: pointer;padding: 10px 20px;font-size: 16px;">
	              <i class="fa-solid fa-pen-to-square" style="font-size: xx-large;"></i>
	            </button>
            </form>
            <form method="post" action="/b/del_post.do">
	            <input type="hidden" name="blog" value="${dto.blog.b_idx }">
	            <input type="hidden" name="p_idx" value="${vo.p_idx }">
	            <button type="submit" style="background-color: transparent;border: none; color: black;cursor: pointer;padding: 10px 20px;font-size: 16px;">
	              <i class="fa-solid fa-square-xmark" style="font-size: xx-large;"></i>
	            </button>
            </form>
          </c:if>
            <!--<a href="#" class="">-->
              <!-- <i class="fa-solid fa-face-frown" style="color: red; font-size: xx-large;float: right;"></i> -->
            <!--</a>-->
          </div>


          <div class="pt-3 comment-wrap">
            <!-- Start comment-list -->
            <!-- Start comment-list -->
            <!-- Start comment-list -->
            <input type="hidden" id="p_idx" value="${vo.p_idx}">
            <div id="comm-paging">
            </div>
            <!-- END comment-list -->
            <!-- END comment-list -->
            <!-- END comment-list -->

            <div class="comment-form-wrap pt-5">
              <h3 class="mb-5">コメントする</h3>
              <form action="/b/reply_write.do" method="post" class="p-5 bg-light">
              <input type="hidden" name="p_idx" class="form-control" id="p_idx_input" value="${vo.p_idx}">
              <input type="hidden" name="b_idx" class="form-control" id="b_idx_input" value="${vo.p_b_idx.b_idx}">

                <div class="form-group">
                  <label for="message">コメントを入力</label>
                  <textarea name="r_content" id="message" cols="30" rows="10" class="form-control"></textarea>
                </div>
                <div class="form-group">
                  <input type="submit" value="コメントを送信する" class="btn btn-primary">
                </div>

              </form>
            </div>
          </div>

        </div>

        <!-- END main-content -->

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
              <li><a href="/b/list.do?type=${ctgr_list.ctgridx}">${ctgr_list.ctgr_name } <span>(${ctgr_list.ctgr_p_cnt })</span></a></li>
            </c:forEach>
            </ul>
          </div>
          <!-- END sidebar-box -->

          <div class="sidebar-box">
            <h3 class="heading">ハッシュタグ</h3>
            <ul class="tags">
            <c:forEach var="taglist" items="${taglist }">
              <li><a href="/b/list.do?term=${taglist.tag_id}">#${taglist.tag_name }</a></li>
            </c:forEach>
            </ul>
          </div>
        </div>
        <!-- END sidebar -->

      </div>
    </div>
  </section>


  <!-- Start posts-entry -->
  <section class="section posts-entry posts-entry-sm bg-light">
    <div class="container">
      <div class="row mb-4">
        <div class="col-12 text-uppercase text-black">同じカテゴリ「<span style="color:blue;">${vo.p_ctgr.ctgr_name}</span>」の記事</div>
      </div>
      <div class="row">
      <c:forEach var="p_list" items="${recommlist}">
        <div class="col-md-6 col-lg-3">
          <div class="blog-entry">
            <a href="/b/detail/blog=${p_list.p_b_idx.b_idx}&&p=${p_list.p_idx}" class="img-link">
              <c:if test="${empty p_list.img_path}">
			  <img src="/blog/images/post_not_image.jpg" alt="Image" class="img-fluid" style="width: 306px;height: 192px;">
			  </c:if>
			  <c:if test="${not empty p_list.img_path}">
			  <img src="/blog/images/${p_list.img_path}" alt="Image" class="img-fluid" style="width: 306px;height: 192px;">
			  </c:if>
            </a>
            <span class="date">${p_list.created_at}</span>
            <h2><a href="/b/detail/blog=${p_list.p_b_idx.b_idx}&&p=${p_list.p_idx}">${p_list.p_title}</a></h2>
            <p style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 306px;">${p_list.p_content}</p>
            <p><a href="/b/detail/blog=${p_list.p_b_idx.b_idx}&&p=${p_list.p_idx}" class="read-more">もっと見る</a></p>
          </div>
        </div>
      </c:forEach>
      </div>
    </div>
  </section>
  <!-- End posts-entry -->

  	<!-- footer start -->
	<!-- footer start -->
	<!-- footer start -->
	<%@ include file="fragments/footer.jsp"%>
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
    <script src="/blog/js/tiny-slider.js"></script>

    <script src="/blog/js/flatpickr.min.js"></script>


    <script src="/blog/js/aos.js"></script>
    <script src="/blog/js/glightbox.min.js"></script>
    <script src="/blog/js/navbar.js"></script>
    <script src="/blog/js/counter.js"></script>
    <script src="/blog/js/custom.js"></script>
    <script src="/blog/js/detail.js"></script>

    
  </body>
  </html>
