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
		        <c:if test="${loginUser eq re_list.r_u_idx.user_id}">
		        <div><a href="" class="rounded" style="float:right" onclick="del(${re_list.r_idx})">削除する</a><a class="" style="float:right;margin-right: 15px;"onclick=" re_update(this)">編集する</a></div>
		        </c:if>
	      	</div>
	      <div class="meta">${re_list.created_at}</div>
	      <p>${re_list.r_content}</p>
	      <p><a onclick="re_reply(this)" class="reply rounded">返信する</a></p>
	      <form action="/b/reply_write.do" method="post" class="p-5 bg-light re_re_form" style="display:none;">
              <input type="hidden" name="p_idx" class="form-control" value="${re_list.r_p_idx.p_idx}">
              <input type="hidden" name="b_idx" class="form-control" value="${b_idx}">
              <input type="hidden" name="r_parent" class="form-control" value="${re_list.r_idx}">
              <input type="hidden" name="r_group" class="form-control" value="${re_list.r_group}">
              <input type="hidden" name="r_grade" class="form-control" value="${re_list.r_grade}">
              <input type="hidden" name="parent_nick" class="form-control" value="${re_list.r_u_idx.nickname}">

                <div class="form-group">
                  <label for="message">コメントを入力</label>
                  <textarea name="r_content" id="message" cols="30" rows="10" class="form-control r_con"></textarea>
                </div>
                <div class="form-group" style="display:flex !important;justify-content: space-between;">
                  <input type="submit" value="返信を送信する" class="btn btn-primary">
                  <input type="button" value="キャンセル" class="btn btn-danger" onclick="cancelRE(this)">
                </div>

           </form>
           <form action="/b/reply_update.do" method="post" class="p-5 bg-light re_up_form" style="display:none;">
              <input type="hidden" name="r_idx" class="form-control" value="${re_list.r_idx}">
              <input type="hidden" name="p_idx" class="form-control" value="${re_list.r_p_idx.p_idx}">
              <input type="hidden" name="b_idx" class="form-control" value="${b_idx}">

                <div class="form-group">
                  <label for="message">コメントを入力</label>
                  <textarea style="display:none;" id="message" cols="30" rows="10" class="form-control r_con_hidden">${re_list.r_content}</textarea>
                  <textarea name="r_content" id="message" cols="30" rows="10" class="form-control r_con"></textarea>
                </div>
                <div class="form-group" style="display:flex !important;justify-content: space-between;">
                  <input type="submit" value="コメントをを編集する" class="btn btn-primary">
                  <input type="button" value="キャンセル" class="btn btn-danger" onclick="cancelUP(this)">
                </div>

           </form>
	    </div>
	    </c:when>
	    <c:otherwise>
	    <div class="comment-body">
	    	<div style="display: flex;justify-content: space-between;">
		        <h3>${re_list.r_u_idx.nickname}</h3>
		        <c:if test="${loginUser eq re_list.r_u_idx.user_id}">
		        <div><a href="" onclick="del(${re_list.r_idx})" class="rounded"  style="float:right">削除する</a><a class="" style="float:right;margin-right: 15px;"onclick=" re_update(this)">編集する</a></div>
		        </c:if>
	      	</div>
	      <div class="meta">${re_list.created_at}</div>
	      <span style="color: blue;">@${re_list.parentNickname }</span>
	      <p>${re_list.r_content}</p>
	      <p><a onclick="re_reply(this)" class="reply rounded">返信する</a></p>
	      <form action="/b/reply_write.do" method="post" class="p-5 bg-light re_re_form" style="display:none;">
              <input type="hidden" name="p_idx" class="form-control" value="${re_list.r_p_idx.p_idx}">
              <input type="hidden" name="b_idx" class="form-control" value="${b_idx}">
              <input type="hidden" name="r_parent" class="form-control" value="${re_list.r_idx}">
              <input type="hidden" name="r_group" class="form-control" value="${re_list.r_group}">
              <input type="hidden" name="r_grade" class="form-control" value="${re_list.r_grade}">
              <input type="hidden" name="parent_nick" class="form-control" value="${re_list.r_u_idx.nickname}">

                <div class="form-group">
                  <label for="message">コメントを入力</label>
                  <textarea style="display:none;" id="message" cols="30" rows="10" class="form-control r_con_hidden">${re_list.r_content}</textarea>
                  <textarea name="r_content" id="message" cols="30" rows="10" class="form-control r_con"></textarea>
                </div>
                <div class="form-group" style="display:flex !important;justify-content: space-between;">
                  <input type="submit" value="返信を送信する" class="btn btn-primary">
                  <input type="button" value="キャンセル" class="btn btn-danger" onclick="cancelRE(this)">
                </div>

           </form>
           <form action="/b/reply_update.do" method="post" class="p-5 bg-light re_up_form" style="display:none;">
              <input type="hidden" name="r_idx" class="form-control" value="${re_list.r_idx}">
              <input type="hidden" name="p_idx" class="form-control" value="${re_list.r_p_idx.p_idx}">
              <input type="hidden" name="b_idx" class="form-control" value="${b_idx}">

                <div class="form-group">
                  <label for="message">コメントを入力</label>
                  <textarea name="r_content" style="display:none;" id="message" cols="30" rows="10" class="form-control r_con_hidden">${re_list.r_content}</textarea>
                  <textarea name="r_content" id="message" cols="30" rows="10" class="form-control r_con"></textarea>
                </div>
                <div class="form-group" style="display:flex !important;justify-content: space-between;">
                  <input type="submit" value="コメントをを編集する" class="btn btn-primary">
                  <input type="button" value="キャンセル" class="btn btn-danger" onclick="cancelUP(this)">
                </div>

           </form>
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