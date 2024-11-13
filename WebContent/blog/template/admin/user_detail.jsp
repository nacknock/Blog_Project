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
    
    <!-- util css -->
    <link rel="stylesheet" href="/blog/admin_front/css/btn.css">
    <link rel="stylesheet" href="/blog/admin_front/css/mg_pd.css">

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
                    <h1 class="h3 text-gray-800 mb-15">ユーザー詳細</h1>
                    <h6 class="mb-4"><a href="/admin/main.do">Main</a> / <a href="/admin/user_list.do">ユーザー一覧</a> / nawj0603</h6>
                    <!-- DataTales Example -->
                    <div class="row">
	                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
	                        <div class="card influencer-profile-data">
	                            <div class="card-body">
	                                <div class="row">
	                                    <div class="col-xl-2 col-lg-4 col-md-4 col-sm-4 col-12">
	                                        <div class="text-center">
	                                            <img src="../img/undraw_profile_1.jpg" alt="User Avatar" class="rounded-circle user-avatar-xxl">
	                                            </div>
	                                        </div>
	                                        <div class="col-xl-10 col-lg-8 col-md-8 col-sm-8 col-12">
	                                            <div class="user-avatar-info">
	                                                <div class="m-b-20">
	                                                    <div class="user-avatar-name">
	                                                        <h2 class="mb-1">nawj0603</h2>
	                                                    </div>
	                                                </div>
	                                                <!--  <div class="float-right"><a href="#" class="user-avatar-email text-secondary">www.henrybarbara.com</a></div> -->
	                                                <div class="user-avatar-address">
	                                                    <p class="border-bottom pb-3">
	                                                        <span class="d-xl-inline-block d-block mb-2"><i class="fa-solid fa-at mr-2 text-primary "></i>nawj0603@naver.com</span>
	                                                        <span class="mb-2 ml-xl-4 d-xl-inline-block d-block">계정생성일: 2018-09-08  </span>
                                                        	<span class="mb-2 ml-xl-4 d-xl-inline-block d-block mr-15" style="width: 188px;">닉네임 : 無駄無駄無駄無駄</span>
	                                                        <span class=" mb-2 d-xl-inline-block d-block ml-xl-4"><a href="#">계정 정지 이력</a> : 0 </span>
	                                                    </p>
                                                        
	                                                </div>
	                                            </div>
	                                        </div>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                    </div>
	                    <!-- ============================================================== -->
	                    <!-- end influencer profile  -->
	                    <!-- ============================================================== -->
	                    <div class="row mt-15">
	                        <!-- ============================================================== -->
	                        <!-- campaign activities   -->
	                        <!-- ============================================================== -->
	                        
	                        <!-- ============================================================== -->
	                        <!-- end campaign activities   -->
	                        <!-- ============================================================== -->
	                    </div>
                        <div id="btn-div" style="display: flex;justify-content: center;height: 100px;align-items: center;">
                            <button class="btn btn-danger mr-15" id="warn-btn" data-toggle="modal" data-target="#warn-Modal">계정 정지</button>
                            <button class="btn btn-primary">정지 취소</button>
                        </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

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

    <!-- modal js -->
    <!-- <script src="../js/simple-modal.js"></script> -->

</body>

</html>