<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
	<c:if test="${empty list && empty keyword}">
	<div class="post-entry-sidebar" id="empty-page" style="text-align:center; height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
		<h2>投稿した記事がありません。</h2>
	</div>	
	</c:if>
	<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
		<div class="email-list">
			<div class="email-list-item email-list-item--unread" style="display: flex;align-items: center;">
				<div class="email-list-actions mr-30 ml-30 pt-7">
					<!--<label class="custom-control custom-checkbox">
						<input class="custom-control-input checkboxes" type="checkbox" value="1" id="one" style="width: 20px;height: 20px;">
					</label>-->
				</div>
				<div class="email-list-detail">
					<p class="msg mb-7" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 365px;">
						${list.p_title }
					</p>
					<div>
						<span class="from" style="color: #f54;">${list.p_ctgr.ctgr_name}</span> ・ <span class="from">${list.created_at}</span>
					</div>
				</div>
			</div>
		</div>
		<div class="dropdown no-arrow">
			<i class="fa-solid fa-eye"></i><!-- 공개 설정되어있을때 -->
			<a class="dropdown-toggle mr-17" href="#" role="button" id="dropdownMenuLink"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
			</a>
			<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
				aria-labelledby="dropdownMenuLink">
				<div class="dropdown-header">설정:</div>
				<a class="dropdown-item" onclick="updateChart('1년')">수정</a>
				<a class="dropdown-item" onclick="updateChart('1달')">삭제</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" onclick="updateChart('조회수')">공개</a>
				<a class="dropdown-item" onclick="updateChart('게시글')">비공개</a>
			</div>
		</div>
	</div>									
</div>
<div class="row text-start pt-5 border-top">
	<div class="col-md-12">
		<div class="custom-pagination">
		<input type="hidden" id="startPage" value="${pageMaker.startPage}">
		<input type="hidden" id="endPage" value="${pageMaker.endPage}">
		<input type="hidden" id="amount" value="${pageMaker.cri.amount}">
		<input type="hidden" id="type" value="${pageMaker.cri.type}">
		<input type="hidden" id="keyword" value="${pageMaker.cri.keyword}">
		<input type="hidden" id="term" value="${pageMaker.cri.term}">
		<c:if test="${pageMaker.prev}">
			<a style="color: #FFF !important;cursor:pointer;" onclick="prev_page('${pageMaker.startPage-1}')">←</a>
		</c:if>
		<c:forEach var="page" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
			<c:if test="${pageMaker.cri.pageNum == page}">
				<span>${page}</span>
			</c:if>
			<c:if test="${pageMaker.cri.pageNum != page}">
				<a style="cursor:pointer;color: #FFF !important;" onclick="page('${page}')">${page}</a>
			</c:if>								
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<a style="cursor:pointer;color: #FFF !important;" onclick="next_page('${pageMaker.endPage+1}')">→</a>
		</c:if>
		</div>
		<div class="paging">
		
		
		
	</div>
</div>