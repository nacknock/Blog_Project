<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Tables</title>

    <!-- Custom fonts for this template -->
    <link href="/blog/admin_front/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/blog/admin_front/css/sb-admin-2.min.css" rel="stylesheet">

    <!-- Custom styles for this page -->
    <link href="/blog/admin_front/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <!-- util css -->
    <link href="/blog/admin_front/css/btn.css" rel="stylesheet">
    <link href="/blog/admin_front/css/mg_pd.css" rel="stylesheet">
    
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="../css/material-design-iconic-font/css/materialdesignicons.min.css">
    
    <!-- util css -->
    <link rel="stylesheet" href="../css/btn.css">
    <link rel="stylesheet" href="../css/mg_pd.css">

</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
		<%@ include file="../fragments/admin/sidebar.jsp"%>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
				<%@ include file="../fragments/admin/topbar.jsp"%>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <h1 class="h3 text-gray-800 mb-15">お問い合わせ詳細</h1>
                    <h6 class="mb-4"><a href="#">Main</a> / <a href="/admin/qna_list.do">お問い合わせ管理</a> / お問い合わせ詳細</h6>
                    <!-- DataTales Example -->
                    <!-- ============================================================== -->
	                <!-- content  -->
	                <!-- ============================================================== -->
	                <div class="row mb-15">
	                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
	                        <div class="card influencer-profile-data">
	                            <div class="card-body">
	                                <div class="row">
	                                    <div class="col-12">
	                                        <div class="user-avatar-info">
	                                            <div class="m-b-20">
	                                                <div class="user-avatar-name" style="text-align: center;">
	                                                    <h2 class="mb-1">${qvo.q_title }</h2>
	                                                </div>
	                                            </div>
	                                                <!--  <div class="float-right"><a href="#" class="user-avatar-email text-secondary">www.henrybarbara.com</a></div> -->
	                                            <div class="user-avatar-address mt-15">
	                                                <p class="border-bottom pb-3" style="display: flex;justify-content: center;">
			                                            <c:if test="${qvo.q_ctgr eq 1}"><span class=" mb-2 d-xl-inline-block d-block ml-xl-4 mr-25">ログイン</span></c:if>
			                                            <c:if test="${qvo.q_ctgr eq 1}"><span class=" mb-2 d-xl-inline-block d-block ml-xl-4 mr-25">機能/使い方</span></c:if>
			                                            <c:if test="${qvo.q_ctgr eq 1}"><span class=" mb-2 d-xl-inline-block d-block ml-xl-4 mr-25">権利侵害</span></c:if>
			                                            <c:if test="${qvo.q_ctgr eq 1}"><span class=" mb-2 d-xl-inline-block d-block ml-xl-4 mr-25">不具合/エラー/トラブル</span></c:if>
	                                                </p>
                                                    <p class="border-bottom pb-3" style="display: flex;justify-content: center;">
	                                                    <span class=" mb-2 d-xl-inline-block d-block ml-xl-4">ユーザー :${qvo.user_id }</span>
	                                                    <span class="mb-2 ml-xl-4 d-xl-inline-block d-block">作成日: ${qvo.created_at }  </span>
	                                                    <span class="mb-2 ml-xl-4 d-xl-inline-block d-block">回答日: 23 June, 2018  </span>
	                                                </p>
	                                            </div>
	                                        </div>
											<div class="user-avatar-info">
	                                            <div class="m-b-20" style="display: flex;justify-content: center;">
	                                                <textarea name="reason" readonly style="border: 1px solid #d1d3e2;border-radius: .35rem;min-height: 500px;width: 800px;">
	                                                ${qvo.q_content }
	                                                </textarea>
	                                            </div>
	                                        </div>
											<div class="user-avatar-info mt-30" style="display: flex;justify-content: center;">
	                                            <div class="m-b-20 col-10" style="display: flex;justify-content: center;flex-wrap: wrap;">
	                                                <img src="/blog/images/${qvo.q_img}" style="width: 300px;height: 400px;border: 1px solid #d1d3e2;">
	                                            </div>
	                                        </div>
	                                        <c:if test="${empty avo }">
											<div class="user-avatar-info mt-30 mb-12" id="q-btn-box" style="display: block;">
	                                            <div class="m-b-20" style="display: flex;justify-content: center;">
													<button class="btn btn-primary" type="button" onclick="answer()" id="to-a-btn">回答する</button>
	                                            </div>
	                                        </div>
	                                        </c:if>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <c:if test="${empty avo }">
							<div class="card influencer-profile-data mt-30 mb-23" id="answer-box" style="display: none;">
	                            <div class="card-body">
	                                <div class="row">
	                                    <div class="col-12">
											<div class="user-avatar-info mb-20">
	                                            <div class="m-b-20">
	                                                <div class="user-avatar-name" style="text-align: center;">
	                                                    <h2 class="mb-1">回答作成</h2>
	                                                </div>
	                                            </div>
	                                        </div>
											<div class="user-avatar-info">
	                                            <div class="m-b-20" style="display: flex;justify-content: center;">
	                                                <textarea id="a-txtarea" name="a_content" style="resize: none;border: 1px solid #d1d3e2;border-radius: .35rem;min-height: 500px;width: 800px;"></textarea>
	                                            </div>
	                                        </div>
											<div class="user-avatar-info mt-30 mb-12">
	                                            <div class="m-b-20" style="display: flex;justify-content: center;">
													<button class="btn btn-primary mr-15" style="width: 106px;" onclick="submit(${qvo.q_idx })">送信する</button>
													<button class="btn btn-danger" style="width: 106px;" onclick="cancel()" id="btn-cancel">キャンセル</button>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        </c:if>
	                        <c:if test="${not empty avo }">
							<div class="card influencer-profile-data mt-30 mb-23" id="answer-box" style="">
	                            <div class="card-body">
	                                <div class="row">
	                                    <div class="col-12">
											<div class="user-avatar-info mb-20">
	                                            <div class="m-b-20">
	                                                <div class="user-avatar-name" style="text-align: center;">
	                                                    <h2 class="mb-1">回答</h2>
	                                                </div>
	                                            </div>
	                                        </div>
											<div class="user-avatar-info">
	                                            <div class="m-b-20" style="display: flex;justify-content: center;">
	                                                <textarea id="a-txtarea" name="a_content" style="resize: none;border: 1px solid #d1d3e2;border-radius: .35rem;min-height: 500px;width: 800px;">
	                                                ${avo.a_content }
	                                                </textarea>
	                                            </div>
	                                        </div>
                                            <div class="col-12 d-flex justify-content-center pt-30 pb-30">
                                                <div class="col-6 d-flex align-items-center" style="flex-direction:column;">
                                                    <label class="mb-30"><h3>評価点</h3></label>
                                                    <div class="mb-30" style="font-size: xx-large;color:#4e73df;">
                                                        <c:if test="${avo.raiting >= 1}"><i class="fa-solid fa-face-angry"></i></c:if><!-- <i class="fa-solid fa-face-angry"></i> -->
                                                        <c:if test="${avo.raiting == 0 }"><i class="fa-regular fa-face-angry"></i></c:if>
                                                        <c:if test="${avo.raiting >= 2 }"><i class="fa-solid fa-face-frown"></i></c:if>
                                                        <c:if test="${avo.raiting < 2 }"><i class="fa-regular fa-face-frown"></i></c:if>
                                                        <c:if test="${avo.raiting >= 3 }"><i class="fa-solid fa-face-meh"></i></c:if>
                                                        <c:if test="${avo.raiting < 3 }"><i class="fa-regular fa-face-meh"></i></c:if>
                                                        <c:if test="${avo.raiting >= 4 }"><i class="fa-solid fa-face-smile"></i></c:if>
                                                        <c:if test="${avo.raiting < 4 }"><i class="fa-regular fa-face-smile"></i></c:if>
                                                        <c:if test="${avo.raiting == 5 }"><i class="fa-solid fa-face-laugh"></i></c:if>
                                                        <c:if test="${avo.raiting < 5 }"><i class="fa-regular fa-face-laugh"></i></c:if>
                                                    </div>
                                                </div>
                                            </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        </c:if>
	                    </div>
	                </div>
					<!-- ============================================================== -->
					<!-- end content  -->
					<!-- ============================================================== -->
                <!-- /.container-fluid -->

            	</div>
            <!-- End of Main Content -->

			<!-- answer form scripts -->
			<script src="../js/question_detail.js"></script>

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2020</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

    <!-- Ban Modal start -->
    <!-- Ban Modal start -->
    <!-- Ban Modal start -->
    <div class="modal fade" id="warn-Modal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
    aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">계정 정지</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                    <select class="form-control clr-category" id="input-select-color" name="ban_date">
                        <option value="">정지 일자</option>
                        <option value="1">1일</option>
                        <option value="3">3일</option>
                        <option value="5">5일</option>
                        <option value="7">7일</option>
                        <option value="15">15일</option>
                        <option value="30">30일</option>
                        <option value="90">90일</option>
                        <option value="-1">영구정지</option>
                    </select>
                    <div id="text-box" style="display: flex;flex-direction: column;">
                        <label style="padding: 10px 5px;margin-bottom: 0;"><span>정지 사유</span></label>
                        <textarea name="reason" style="resize: none;border: 1px solid #d1d3e2;border-radius: .35rem;min-height: 300px;">
                        </textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                    <button class="btn btn-danger" type="danger">계정 정지</button>
                </div>
            </div>
        </div>
    </div>
    <!-- Ban Modal end -->
    <!-- Ban Modal end -->
    <!-- Ban Modal end -->

    <!-- Bootstrap core JavaScript-->
    <script src="/blog/admin_front/vendor/jquery/jquery.min.js"></script>
    <script src="/blog/admin_front/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/blog/admin_front/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/blog/admin_front/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/blog/admin_front/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/blog/admin_front/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/blog/admin_front/js/demo/datatables-demo.js"></script>
    <script src="../../blog/admin_front/js/question_detail.js"></script>

    <!-- modal js -->
    <!-- <script src="../js/simple-modal.js"></script> -->

</body>

</html>