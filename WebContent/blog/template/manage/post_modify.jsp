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

	<!-- Editor -->
    <script src="https://cdn.ckeditor.com/ckeditor5/40.1.0/classic/ckeditor.js"></script>
    <script src="https://cdn.ckeditor.com/ckeditor5/34.0.0/classic/translations/ko.js"></script>
    <!-- select박스 직접입력 추가용 selectize -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/selectize/dist/css/selectize.default.css">

	<style>
		.ck {
        height: 500px; /* 높이 설정 */
        width: 100%;   /* 너비 설정 */
    	}
		.item {
			background: #214252 !important;
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
						<h2>ブログを書く</h2>
					</div>
					<form method="post" action="/manage/postModifyAction.do" enctype="multipart/form-data" name="p_wrt_form" onsubmit="return check(event)">
						<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
							<div class="form-group col-md-12">
								<div class="mt-30 mb-15" style="display: flex;justify-content: center;">
									<select class="form-control" name="p_ctgr" style="width: 60%;height: 50%;text-align: center;background: white !important;">
									<option value="${vo.p_ctgr.ctgridx}">${vo.p_ctgr.ctgr_name}</option>
									<c:forEach var="list" items="${ctgr_list}">
										<option value="${list.ctgridx }">${list.ctgr_name }</option>
									</c:forEach>
									</select>
									<input type="hidden" name="b_idx" id="wrt_b_idx" value="${dto.blog.b_idx }">
									<input type="hidden" name="p_idx" id="p_idx" value="${vo.p_idx }">
									<input type="hidden" name="p_private" id="p_private" value="${vo.p_private }">
									<!-- <input type="hidden" name="p_private" value="${p_pri_yn }"> -->
								</div>
								<div>
									<input value="${vo.p_title}" style="border-top: none;border-left: none;border-right: none; text-align: center;" class="form-control" type="text" placeholder="title" name="p_title" id="p_title">
								</div>
								<div class="col-12">
									<textarea hidden="hidden" id="txt_detail" class="form-control" name="p_content" rows="5"
									style="resize:none"></textarea>
									<div id="editor"></div>
								</div>
								<div>
									<input style="height: 37px;" multiple class="form-control" type="file" placeholder="title" name="img" id="img">
									<c:if test="${not empty vo.img_path }">
									<input type="hidden" name="imgurl" value="/blog/upload/${vo.img_path}">
									</c:if>
								</div>
								<div style="display: flex;padding: 30px 10px;">
									<label class="mr-15 pt-7" for="tagSelect">#ハッシュタグ</label>
									<div style="width: 80%;">
										<select class="js-example-basic-multiple" multiple="multiple" name="tags" id="tagSelect"><!-- sendto배열로 db에 넘긴 후 바꿈-->
										<c:forEach var="list" items="${taglist}">
										<option value="${list.tag_name}" selected="selected">
										${list.tag_name}
										</option>
										</c:forEach>
										</select>
									</div>
								</div>
							</div>
							<div class="mt-15" style="margin-bottom: 15px !important; display: flex;justify-content: center;">
								<button type="submit" class="btn btn-sm btn-outline-primary">保存する</button>
							</div>							
						</div>
					</form>
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
    <!-- select박스 직접입력 추가용 selectize || 항상 jquery보다 뒤에 위치해야함 -->
    <script src="https://cdn.jsdelivr.net/npm/selectize/dist/js/standalone/selectize.min.js"></script>

    <script src="/blog/js/flatpickr.min.js"></script>


    <script src="/blog/js/aos.js"></script>
    <script src="/blog/js/glightbox.min.js"></script>
    <script src="/blog/js/navbar.js"></script>
    <script src="/blog/js/counter.js"></script>
    <script src="/blog/js/custom.js"></script>

	<script>
		let editor;

		ClassicEditor.create(document.querySelector('#editor'), {
			language: 'ko',
			toolbar: ['heading', '|', 'bold', 'italic']
		})
			.then(newEditor => {
				editor = newEditor;
				 editor.setData('${vo.p_content}');
			})
			.catch(error => {
				console.error(error);
			});
		$(document).ready(function() {

			$('#tagSelect').selectize({
				create: function(input) {
					return { value: input, text: input };
					
				},
				placeholder: '#'
			});
		});
		
		function check(event) {
			event.preventDefault();
			if(p_wrt_form.p_title.value=="") {
				alert("タイトルを入力してください。");
				p_wrt_form.p_title.focus();
				return false;
			}
			if(p_wrt_form.p_ctgr.value=="") {
				alert("カテゴリを選択してください。");
				p_wrt_form.ctgridx.focus();
				return false;
			}
			if(editor.getData()==="") {
				alert("文字を入力してください。");
				p_wrt_form.p_content.focus();
				return false;
			}else{
				p_wrt_form.p_content.value = editor.getData();
			}
			p_wrt_form.submit();
			return true;
		}
	</script>
    
  </body>
  </html>
