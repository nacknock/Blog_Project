<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${empty b_list && not empty b_pageMaker.cri.keyword}">
<div class="blog-entry d-flex blog-entry-search-item" style="justify-content: center;margin-top: 60px;">
	<h2><b>${b_pageMaker.cri.keyword}</b> に一致する情報は見つかりませんでした。</h2>
</div>
</c:if>
<c:forEach var="b_list" items="${b_list}">
<div class="blog-entry d-flex blog-entry-search-item">
	<a href="/b/list.do?blog=${b_list.b_idx}" class="img-link me-4">
		<c:if test="${empty b_list.img_path}">
		<img src="/blog/images/default_profile.png" alt="Image" class="img-fluid" style="width: 230px;height: 230px;">
		</c:if>
		<c:if test="${not empty b_list.img_path}">
		<img src="/blog/images/${b_list.img_path}" alt="Image" class="img-fluid" style="width: 230px;height: 230px;">
		</c:if>
	</a>
	<div>
		<h2><a href="/b/list.do?blog=${b_list.b_idx}"><b>${b_list.b_title}</b></a></h2>
		<h3><a href="/b/list.do?blog=${b_list.b_idx}">${b_list.one_liner}</a></h3>
		<p><a href="/b/list.do?blog=${b_list.b_idx}" class="btn btn-sm btn-outline-primary">訪問する</a></p>
	</div>
</div>
</c:forEach>
<c:if test="${not empty b_list}">
<div class="row text-start pt-5 border-top">
	<div class="col-md-12">
		<div class="custom-pagination">
			<input type="hidden" id="startPage" value="${b_pageMaker.startPage}">
			<input type="hidden" id="endPage" value="${b_pageMaker.endPage}">
			<input type="hidden" id="amount" value="${b_pageMaker.cri.amount}">
			<input type="hidden" id="type" value="${b_pageMaker.cri.type}">
			<input type="hidden" id="keyword" value="${b_pageMaker.cri.keyword}">
			<input type="hidden" id="term" value="${b_pageMaker.cri.term}">
			<c:if test="${b_pageMaker.prev}">
				<a style="color: #FFF !important;cursor:pointer;" onclick="prev_page_b('${b_pageMaker.startPage-1}')">←</a>
			</c:if>
			<c:forEach var="page" begin="${b_pageMaker.startPage}" end="${b_pageMaker.endPage}">
				<c:if test="${b_pageMaker.cri.pageNum == page}">
					<span>${page}</span>
				</c:if>
				<c:if test="${b_pageMaker.cri.pageNum != page}">
					<a style="cursor:pointer;color: #FFF !important;" onclick="page_b('${page}')">${page}</a>
				</c:if>								
			</c:forEach>
			<c:if test="${b_pageMaker.next}">
				<a style="cursor:pointer;color: #FFF !important;" onclick="next_page_b('${b_pageMaker.endPage+1}')">→</a>
			</c:if>
		</div>
	</div>
</div>
</c:if>