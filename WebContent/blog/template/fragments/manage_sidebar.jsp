<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="col-lg-3 pr-45" style="border-radius: 10px;border:#e6e6e6 solid 1px;">
					<!-- END sidebar-box -->
					<div class="sidebar-box">
						<div class="mb-45">
							<a href="/manage/pw_chk.do?page=1" style="display: flex;justify-content: center;">
							<img class="mt-15" src="/blog/images/${dto.path}" style="width: 214px;height: 214px;">								
							</a>
							<div class="mt-15" style="padding:15px; border-top: #e6e6e6 solid 1px;border-bottom: #e6e6e6 solid 1px;">
								<h3>${dto.b_title }</h3>
								<a href="#"><h5>블로그 바로가기</h5></a>
							</div>
							<div style="padding:15px;border-bottom: #e6e6e6 solid 1px;">
								<a href="single.html" class="btn btn-sm btn-outline-primary" style="width: 80%;">글쓰기</a>
							</div>
						</div>
						<div class="post-entry-sidebar" style="border-bottom:#e6e6e6 solid 1px;">
							<ul>
								<li>
									<a href="">
										<div class="text" style="width: 200px;">
											<i class="fa-solid fa-house float-l mr-5 ml-5"></i>
											<h4>블로그 관리 홈</h4>
										</div>
									</a>
								</li>
							</ul>
						</div>
					</div>
					<!-- END sidebar-box -->

					<div class="sidebar-box">
						<h3 class="heading"><i class="fa-solid fa-newspaper mr-5 ml-5"></i>콘텐츠</h3>
						<ul class="categories ml-5">
							<li><a href="#">글 관리</a></li>
							<li><a href="#">카테고리 관리</a></li>
						</ul>
					</div>
					<!-- END sidebar-box -->
					<div class="sidebar-box">
						<h3 class="heading"><i class="fa-solid fa-newspaper mr-5 ml-5"></i>댓글</h3>
						<ul class="categories ml-5">
							<li><a href="#">댓글 관리</a></li>
						</ul>
					</div>
					<!-- END sidebar-box -->
					<div class="sidebar-box">
						<h3 class="heading"><i class="fa-solid fa-palette mr-5 ml-5"></i>디자인</h3>
						<ul class="categories ml-5">
							<li><a href="#">디자인 관리</a></li>
						</ul>
					</div>
					<!-- END sidebar-box -->
					<div class="sidebar-box">
						<h3 class="heading"><i class="fa-solid fa-user mr-5 ml-5"></i>유저 정보</h3>
						<ul class="categories ml-5">
							<li><a href="/manage/qna_write.do">お問い合わせ</a></li>
							<li><a href="#">お問い合わせ一覧</a></li>
							<li><a href="/manage/pw_chk.do?page=1">プロフィールの設定</a></li>
							<li><a href="/manage/pw_chk.do?page=2">パスワードの変更</a></li>
							<li><a href="/manage/pw_chk.do?page=3">会員退会</a></li>
						</ul>
					</div>
					<!-- END sidebar-box -->
				</div>