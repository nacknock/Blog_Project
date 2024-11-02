<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="sidebar-box mt-30" style="border-radius: 5px; border: 1px solid rgba(0, 0, 0, 0.125);background-color: rgba(0, 0, 0, 0.03);">
						<c:if test="${empty list}">
							<div class="row text-start pt-5 pb-5 border-top" style="text-align: center !important;">
								<h2><b>${pageMaker.cri.keyword}</b> に一致する情報は見つかりませんでした。</h2>
							</div>
						</c:if>
						<c:forEach var="list" items="${list}">
						<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
							<div class="email-list">
								<div class="email-list-item email-list-item--unread" style="display: flex;align-items: center;">
									<div class="email-list-detail ml-30">
										<div class="mb-1">
											<span class="from">${list.created_at }</span>
										</div>
										<div>
											<a href="/manage/qna_detail.do?q_idx=${list.q_idx}">
												<p class="from" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 565px;">
													${list.q_title }
												</p>
											</a>
										</div>
										<c:if test="${not empty list.a_content }">
										<p class="msg mb-7" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 565px;">
											<span class="from" style="color: #306EE8;">[回答]</span>${list.a_content }
										</p>
										</c:if>
									</div>
								</div>
							</div>
							<div class="email-list">
								<div class="email-list-item email-list-item--unread" style="display: flex;align-items: center;">
									<div class="email-list-detail ml-30 mr-30">
										<div class="mb-1">
											<c:if test="${list.a_yn == 1}">
				                                <span class="from" style="color: #306EE8;">回答済み</span>
				                            </c:if>
				                            <c:if test="${list.a_yn == 0}">
				                                <span class="from" style="color: #FF0000;">未回答</span>
				                            </c:if>
										</div>
									</div>
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