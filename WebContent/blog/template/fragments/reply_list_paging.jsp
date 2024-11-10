<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<h3 class="mb-5 heading">コメント(${count})</h3>
<ul class="comment-list">
<c:forEach var="re_list" items="${re_list}">
  <li class="comment">
    <div class="vcard">
    <c:if test="${empty re_list.r_u_idx.img_path }">
      <img src="/blog/images/default_profile.png" alt="Image placeholder">
    </c:if>
    <c:if test="${not empty re_list.r_u_idx.img_path }">
      <img src="/blog/images/${re_list.r_u_idx.img_path}" alt="Image placeholder">
    </c:if>
    </div>
    <c:choose>
	    <c:when test="${re_list.r_grade eq 0 }">
	    <div class="comment-body">
	    	<div style="display: flex;justify-content: space-between;">
		        <h3>${re_list.r_u_idx.nickname}</h3>
		        <div><a href="#" class=""  style="float:right">削除する</a><a href="#" class="" style="float:right;margin-right: 15px;">編集する</a></div>
	      	</div>
	      <div class="meta">${re_list.created_at}</div>
	      <p>${re_list.r_content}</p>
	      <p><a href="#" class="reply rounded">返信する</a></p>
	    </div>
	    </c:when>
	    <c:otherwise>
	    <div class="comment-body">
	    	<div style="display: flex;justify-content: space-between;">
		        <h3>${re_list.r_u_idx.nickname}</h3>
		        <div><a href="#" class=""  style="float:right">削除する</a><a href="#" class="" style="float:right;margin-right: 15px;">編集する</a></div>
	      	</div>
	      <div class="meta">${re_list.created_at}</div>
	      <span style="color: blue;">@${re_list.r_parent.r_u_idx.nickname }</span>
	      <p>${re_list.r_content}</p>
	      <p><a href="#" class="reply rounded">返信する</a></p>
	    </div>
	    </c:otherwise>
    </c:choose>
  </li>
</c:forEach>
</ul>
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