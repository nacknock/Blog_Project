<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    <nav class="site-nav">
		<div class="container">
			<div class="menu-bg-wrap">
				<div class="site-navigation">
					<div class="row g-0 align-items-center">
						<div class="col-2">
							<a href="index.html" class="logo m-0 float-start">Blogy<span class="text-primary">.</span></a>
						</div>
						<div class="col-8 text-center">
							<form action="#" class="search-form d-inline-block d-lg-none">
								<input type="text" class="form-control" placeholder="Search...">
								<span class="bi-search"></span>
							</form>

							<ul class="js-clone-nav d-none d-lg-inline-block text-start site-menu mx-auto">
								<li class="active"><a href="/">ホーム</a></li>
								<!-- <li class="has-children">
									<a href="category.html">Pages</a>
									<ul class="dropdown">
										<li><a href="search-result.html">Search Result</a></li>
										<li><a href="blog.html">Blog</a></li>
										<li><a href="single.html">Blog Single</a></li>
										<li><a href="category.html">Category</a></li>
										<li><a href="about.html">About</a></li>
										<li><a href="contact.html">Contact Us</a></li>
										<li><a href="#">Menu One</a></li>
										<li><a href="#">Menu Two</a></li>
										<li class="has-children">
											<a href="#">Dropdown</a>
											<ul class="dropdown">
												<li><a href="#">Sub Menu One</a></li>
												<li><a href="#">Sub Menu Two</a></li>
												<li><a href="#">Sub Menu Three</a></li>
											</ul>
										</li>
									</ul>
								</li> 
								<li><a href="category.html">Culture</a></li>
								<li><a href="category.html">Business</a></li>
								<li><a href="category.html">Politics</a></li> -->
								<li class="has-children">
									<a>ユーザー</a>
									<c:if test = "${not empty userid }">
                      					<ul class="dropdown">
											<li><a href="/sign/logout.do">ログアウト</a></li>
											<li><a href="/manage/main.do">ブログ管理</a></li>
										</ul>
	                   				</c:if>
									<c:if test = "${empty userid }">
                      					<ul class="dropdown">
											<li><a href="/sign/login.do">ログイン</a></li>
											<li><a href="/sign/join.do">新規登録</a></li>
										</ul>
	                   				</c:if>
								</li>
							</ul>
						</div>
						<div class="col-2 text-end">
							<a href="#" class="burger ms-auto float-end site-menu-toggle js-menu-toggle d-inline-block d-lg-none light">
								<span></span>
							</a>
							<form method="post" action="/b/search_result.do" class="search-form d-none d-lg-inline-block">
								<input type="text" class="form-control" id="bp_keyword" name="bp_keyword" value="${bp_keyword}" placeholder="検索">
								<i class="bi-search"></i>
							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</nav>
	<script scr="/blog/js/search.js"></script>