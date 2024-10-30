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

  <div class="row justify-content-center mt-7" style="background: #214252;margin-top: 0;">
    <div class="col-lg-5 text-center">
      <a href="index.html">
        <img src="assets/img/svg/logo.svg" alt="">
      </a>
      <div class="card mt-5">
        <div class="card-body py-5 px-lg-5">
          <h3 class="fw-normal text-dark mt-4">
            메일 인증
          </h3>
          <p class="mt-4 mb-1">
            메일을 보냈습니다.
          </p>
          <p>
            확인하고 번호를 입력하세요.
          </p>
          <form>
            <div id="otp" class="row mt-4 pt-2 mb-20" style="display: flex;justify-content: center;">
              <input class="m-2 text-center form-control-auth rounded" name="number" style="width: 50px;height: 50px;border: 2px solid #b1b3bc;" type="text" id="first" maxlength="1" />
              <input class="m-2 text-center form-control-auth rounded" name="number" style="width: 50px;height: 50px;border: 2px solid #b1b3bc;" type="text" id="second" maxlength="1" />
              <input class="m-2 text-center form-control-auth rounded" name="number" style="width: 50px;height: 50px;border: 2px solid #b1b3bc;" type="text" id="third" maxlength="1" />
              <input class="m-2 text-center form-control-auth rounded" name="number" style="width: 50px;height: 50px;border: 2px solid #b1b3bc;" type="text" id="fourth" maxlength="1" />
              <input class="m-2 text-center form-control-auth rounded" name="number" style="width: 50px;height: 50px;border: 2px solid #b1b3bc;" type="text" id="fifth" maxlength="1" />
              <input class="m-2 text-center form-control-auth rounded" name="number" style="width: 50px;height: 50px;border: 2px solid #b1b3bc;" type="text" id="sixth" maxlength="1" />
            </div>

            <button type="button" class="btn bsb-btn-2xl btn-primary" id="postbtn">
              인증하기
            </button>
          </form>
        </div>
      </div>

      <p class="text-center text-muted mt-4" style="color: white !important;">
        인증번호가 가지 않았나요?
        <a href="#!" class="text-decoration-none ms-2" style="color: white;">
          다시 받기
        </a>
      </p>
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

    <script src="/blog/js/jquery/jquery.js"></script>
    <script src="/blog/js/jquery/jquery.min.js"></script>

    <script src="/blog/js/bootstrap.bundle.min.js"></script>
    <script src="/blog/js/tiny-slider.js"></script>

    <script src="/blog/js/flatpickr.min.js"></script>


    <script src="/blog/js/aos.js"></script>
    <script src="/blog/js/glightbox.min.js"></script>
    <script src="/blog/js/navbar.js"></script>
    <script src="/blog/js/counter.js"></script>
    <script src="/blog/js/custom.js"></script>
    <script src="/blog/js/mail_auth.js"></script>
    <script>
        document.addEventListener("DOMContentLoaded", function(event) {

        function OTPInput() {
            const inputs = document.querySelectorAll('#otp > *[id]');
            for (let i = 0; i < inputs.length; i++) {
                inputs[i].addEventListener('keydown', function(event) {
                if (event.key==="Backspace" ) {
                    inputs[i].value='' ; if (i !==0) inputs[i - 1].focus(); 
                } else 
                {
                    if (i===inputs.length - 1 && inputs[i].value !=='' ) {
                        return true; 
                    } 
                    else if (event.keyCode> 47 && event.keyCode < 58) {
                        inputs[i].value=event.key; 
                    if (i !==inputs.length - 1) inputs[i + 1].focus(); event.preventDefault(); 
                    }
                    else if (event.keyCode> 64 && event.keyCode < 91) {
                        inputs[i].value=String.fromCharCode(event.keyCode); 
                        if (i !==inputs.length - 1) inputs[i + 1].focus(); event.preventDefault(); 
                    } 
                } 
                });
            } 
        } OTPInput();


        });
    </script>

    
  </body>
  </html>
