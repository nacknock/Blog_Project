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

  <div class="hero overlay inner-page bg-primary py-5">
    <div class="container">
      <div class="row align-items-center justify-content-center text-center pt-5">
        <div class="col-lg-6">
          <h1 class="heading text-white mb-3" data-aos="fade-up">Blogy</h1>
        </div>
      </div>
    </div>
  </div>

  <section class="bg-primary p-3 p-md-4 p-xl-5">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-12 col-md-9 col-lg-7 col-xl-6 col-xxl-5">
          <div class="card border-0 shadow-sm rounded-4">
            <div class="card-body p-3 p-md-4 p-xl-5">
              <div class="row">
                <div class="col-12">
                  <div class="mb-5">
                    <h3>新規登録</h3>
                  </div>
                </div>
              </div>
              <form method="post" action="/sign/mailAction.do">
                <div class="row gy-3 overflow-hidden">
                  <div class="col-12">
                    <div class="form-floating mb-3">
                      <input type="text" class="form-control" name="userid" id="userid" placeholder="id" required>
                      <label for="userid" class="form-label">Id</label>
                    </div>
                    <c:if test = "${not empty msg }">
                      		<label style="margin: 0 0 0 90px;color: red;">${msg}</label>
	                   	<c:remove var="msg" scope="session" /><!-- 세션 안에 있는 msg라는 속성을 삭제 -->
                   	</c:if>
                  </div>
                  <div class="col-12">
                    <div class="form-floating mb-3">
                      <input type="password" class="form-control" name="pw" id="password" value="" placeholder="半角英数字記号・9文字以上13文字以下" required>
                      <label for="password" class="form-label">半角英数字記号・9文字以上13文字以下</label>
                    </div>
                    <c:if test = "${not empty msg_pw }">
                      		<label style="margin: 0 0 0 10px;color: red;">${msg_pw}</label>
	                   	<c:remove var="msg_pw" scope="session" /><!-- 세션 안에 있는 msg라는 속성을 삭제 -->
                   	</c:if>
                  </div>
                  <div class="col-12">
                    <div class="form-floating mb-3">
                      <input type="password" class="form-control" name="pw_chk" id="pw_chk" value="" placeholder="パスワード確認" required>
                      <label for="pw_chk" class="form-label">パスワード確認</label>
                    </div>
                    <c:if test = "${not empty msg_pw_chk }">
                      		<label style="margin: 0 0 0 90px;color: red;">${msg_pw_chk}</label>
	                   	<c:remove var="msg_pw_chk" scope="session" /><!-- 세션 안에 있는 msg라는 속성을 삭제 -->
                   	</c:if>
                  </div>
                  <div class="col-12">
                    <div class="form-floating mb-3">
                      <input type="email" class="form-control" name="email" id="email" placeholder="name@example.com" required>
                      <label for="email" class="form-label">メールアドレス</label>
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="form-floating mb-3">
                      <input type="text" class="form-control" name="nickname" id="nickname" placeholder="name@example.com" required>
                      <label for="nickname" class="form-label">ニックネーム</label>
                    </div>
                  </div>
                  <div class="col-12">
                    <div class="d-grid">
                      <button class="btn bsb-btn-2xl btn-primary" type="submit">登録する</button>
                    </div>
                  </div>
                </div>
              </form>
              <div class="row">
                <div class="col-12">
                  <hr class="mt-5 mb-4 border-secondary-subtle">
                  <div class="d-flex gap-2 gap-md-4 flex-column flex-md-row justify-content-md-end">
                    <a href="/sign/login.do" class="link-secondary text-decoration-none">ログイン</a>
                  </div>
                </div>
              </div>              
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>

  	<!-- footer start -->
	<!-- footer start -->
	<!-- footer start -->
	<%@ include file="../fragments/footer.jsp"%>
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
    