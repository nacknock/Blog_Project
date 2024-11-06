<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<div class="post-entry-sidebar" style="height: 80px;display: flex;align-items: center;border-bottom: 1px solid rgba(0, 0, 0, 0.125);justify-content: space-between;">
	<div class="email-list">
		<div class="email-list-item email-list-item--unread" style="display: flex;align-items: center;">
			<div class="email-list-actions mr-30 ml-30 pt-7">
				<label class="custom-control custom-checkbox">
					<input class="custom-control-input checkboxes" type="checkbox" value="1" id="one" style="width: 20px;height: 20px;">
				</label>
			</div>
			<div class="email-list-detail" style="display: flex;">
				<p class="msg mb-7 ctgr_name" style="white-space: nowrap;overflow: hidden;text-overflow: ellipsis;max-width: 365px;">
					${vo.ctgr_name }
				</p>
				<input class="input none-input" type="text" value="${vo.ctgr_name }" style="display: none;">
				<button class="btn btn-sm btn-danger can-btn" style="display:none;margin-right: 15px;" type="button" onclick="up_cancel(this)">キャンセル</button>
				<button class="btn btn-sm btn-primary sub-btn" style="display:none;width: 99.6px;" type="button" onclick="upAction(this)">保存</button>
				<p class="ml-5 cnt-p">(${vo.ctgr_p_cnt })</p>
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
			<div class="dropdown-header">オプション:</div>
			<a class="dropdown-item" onclick="update(this)">編集</a>
			<a class="dropdown-item" onclick="del(this)">削除</a>
			<div class="dropdown-divider"></div>
			<a class="dropdown-item" onclick="updateChart('조회수')">公開</a>
			<a class="dropdown-item" onclick="updateChart('게시글')">非公開</a>
		</div>
	</div>
</div>