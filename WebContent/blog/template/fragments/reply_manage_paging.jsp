<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
	<c:if test="${empty list && empty pageMaker.cri.keyword}">
	<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: center;">
	<h2>ついたコメントがありません</h2>
	</div>
	</c:if>
	<c:if test="${empty list && not empty pageMaker.cri.keyword}">
	<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: center;">
	<h2><b>${pageMaker.cri.keyword}</b>に一致する情報は見つかりませんでした。</h2>
	</div>
	</c:if>
	<input type="hidden" name="count" id="count" value="${count }">
	<c:forEach var="list" items="${list }">
	<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
		<div class="email-list">
			<div class="email-list-item email-list-item--unread" style="display: flex;align-items: center;">
				<div class="email-list-actions mr-30 ml-30 pt-7">
				</div>
				<div class="email-list-detail">
					<div class="mb-1">
						<span class="from">${list.created_at }</span>
					</div>
					<p class="msg mb-7" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 365px;">
					<c:if test="${list.r_grade eq 0 }">
						${list.r_content }
					</c:if>
					<c:if test="${list.r_grade eq 1 }">
						<span class="from" style="color: #306EE8;">[返信]</span>${list.r_content }
					</c:if>
					</p>
					<div>
						<a href="#">
							<p class="from" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 365px;">
								<i class="fas fa-clipboard-list"></i> ${list.r_p_idx.p_title }
							</p>
						</a>
					</div>
				</div>
			</div>
		</div>
		<div class="dropdown no-arrow">
			<a class="dropdown-toggle mr-17" href="#" role="button" id="dropdownMenuLink"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
			</a>
			<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
				aria-labelledby="dropdownMenuLink">
				<div class="dropdown-header">オプション:</div>
				<!-- <a class="dropdown-item" onclick="updateChart('1년')">編集</a> --><!-- 내 댓글만 보임-->
				<!-- <a class="dropdown-item" onclick="updateChart('1달')"></a> -->
				<a class="dropdown-item" onclick="del('${list.r_idx }')">削除</a>
			</div>
		</div>
	</div>	
	</c:forEach>													
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
				<span id="nowpage">${page}</span>
			</c:if>
			<c:if test="${pageMaker.cri.pageNum != page}">
				<a style="cursor:pointer;color: #FFF !important;" onclick="page('${page}')">${page}</a>
			</c:if>								
		</c:forEach>
		<c:if test="${pageMaker.next}">
			<a style="cursor:pointer;color: #FFF !important;" onclick="next_page('${pageMaker.endPage+1}')">→</a>
		</c:if>
		</div>
	</div>
</div>