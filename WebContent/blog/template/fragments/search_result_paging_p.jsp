<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:if test="${empty p_list && not empty p_pageMaker.cri.keyword}">
<div class="blog-entry d-flex blog-entry-search-item" style="justify-content: center;margin-top: 60px;">
	<h2><b>${p_pageMaker.cri.keyword}</b> に一致する情報は見つかりませんでした。</h2>
</div>
</c:if>
<c:forEach var="p_list" items="${p_list}">
<div class="blog-entry d-flex blog-entry-search-item">
	<a href="/b/detail.do?blog=${p_list.p_b_idx.b_idx}&&p=${p_list.p_idx}" class="img-link me-4">
		<c:if test="${empty p_list.img_path}">
		<img src="/blog/images/post_not_image.jpg" alt="Image" class="img-fluid" style="width: 230px;height: 230px;">
		</c:if>
		<c:if test="${not empty p_list.img_path}">
		<img src="/blog/images/${p_list.img_path}" alt="Image" class="img-fluid" style="width: 230px;height: 230px;">
		</c:if>
	</a>
	<div>
		<span class="date">${p_list.p_b_idx.b_title} / ${p_list.created_at}</span>
		<h2><a href="/b/detail.do?blog=${p_list.p_b_idx.b_idx}&&p=${p_list.p_idx}">${p_list.p_title}</a></h2>
		<div style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 365px;max-height: 45px;">${p_list.p_content}</div>
		<p><a href="/b/detail.do?blog=${p_list.p_b_idx.b_idx}&&p=${p_list.p_idx}" class="btn btn-sm btn-outline-primary">Read More</a></p>
	</div>
</div>
</c:forEach>
<c:if test="${not empty p_list}">
<div class="row text-start pt-5 border-top">
	<div class="col-md-12">
		<div class="custom-pagination">
			<input type="hidden" id="startPage" value="${p_pageMaker.startPage}">
			<input type="hidden" id="endPage" value="${p_pageMaker.endPage}">
			<input type="hidden" id="amount" value="${p_pageMaker.cri.amount}">
			<input type="hidden" id="type" value="${p_pageMaker.cri.type}">
			<input type="hidden" id="keyword" value="${p_pageMaker.cri.keyword}">
			<input type="hidden" id="term" value="${p_pageMaker.cri.term}">
			<c:if test="${p_pageMaker.prev}">
				<a style="color: #FFF !important;cursor:pointer;" onclick="prev_page('${p_pageMaker.startPage-1}')">←</a>
			</c:if>
			<c:forEach var="page" begin="${p_pageMaker.startPage}" end="${p_pageMaker.endPage}">
				<c:if test="${p_pageMaker.cri.pageNum == page}">
					<span>${page}</span>
				</c:if>
				<c:if test="${p_pageMaker.cri.pageNum != page}">
					<a style="cursor:pointer;color: #FFF !important;" onclick="page('${page}')">${page}</a>
				</c:if>								
			</c:forEach>
			<c:if test="${p_pageMaker.next}">
				<a style="cursor:pointer;color: #FFF !important;" onclick="next_page('${p_pageMaker.endPage+1}')">→</a>
			</c:if>
		</div>
	</div>
</div>
</c:if>