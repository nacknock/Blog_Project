<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
	<input type="hidden" name="count" id="count" value="${count}">
	<c:if test="${empty list && empty pageMaker.cri.keyword}">
	<div class="post-entry-sidebar" id="empty-page" style=" height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: center;">
		<h2>投稿した記事がありません。</h2>
	</div>	
	</c:if>
	<c:if test="${empty list && not empty pageMaker.cri.keyword}">
	<div class="post-entry-sidebar" id="empty-page" style=" height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: center;">
		<h2><b>${pageMaker.cri.keyword}</b> に一致する情報は見つかりませんでした。</h2>
	</div>	
	</c:if>
	<c:forEach var="list" items="${list }">
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
			<c:if test="${list.p_private eq 0}">
			<i class="fa-solid fa-eye pri-i"></i><!-- 공개 설정되어있을때 -->
			</c:if>
			<c:if test="${list.p_private eq 1}">
			<i class="fa-solid fa-eye-slash pri-i"></i>
			</c:if>
			<a class="dropdown-toggle mr-17" href="#" role="button" id="dropdownMenuLink"
				data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
				<i class="fas fa-ellipsis-v fa-sm fa-fw text-gray-400"></i>
			</a>
			<div class="dropdown-menu dropdown-menu-right shadow animated--fade-in"
				aria-labelledby="dropdownMenuLink">
				<input type="hidden" name="pidx" class="pidx" value="${list.p_idx }">
				<div class="dropdown-header">オプション:</div>
				<a class="dropdown-item" href="/manage/openP_modify.do">編集</a>
				<a class="dropdown-item" onclick="del(this)">削除</a>
				<div class="dropdown-divider"></div>
				<a class="dropdown-item" onclick="chngePriv(this)">公開</a>
				<a class="dropdown-item" onclick="chngePriv(this)">非公開</a>
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
		<div class="paging">
		
		
		
	</div>
</div>