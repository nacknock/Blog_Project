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

    <title>SB Admin 2 - Dashboard</title>

    <!-- Custom fonts for this template-->
    <link href="/blog/admin_front/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
    <link
        href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i"
        rel="stylesheet">

    <!-- Custom styles for this template-->
    <link href="/blog/admin_front/css/sb-admin-2.min.css" rel="stylesheet">
    
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/blog/admin_front/css/material-design-iconic-font/css/materialdesignicons.min.css">
    
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

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-primary shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-primary text-uppercase mb-1">
                                                <span style="font-size: large;">登録ユーザー数</span>
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${usercnt}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fa-solid fa-user" style="font-size: xx-large;color: #4e73df;"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-success shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-success text-uppercase mb-1">
                                                <span style="font-size: large;">ブログ数</span>
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${blogcnt}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fa-brands fa-blogger-b" style="font-size: xx-large;color:#1cc88a;"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Earnings (Monthly) Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-info shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-info text-uppercase mb-1">
                                                <span style="font-size: large;">投稿数</span>
                                            </div>
                                            <div class="row no-gutters align-items-center">
                                                <div class="col-auto">
                                                    <div class="h5 mb-0 font-weight-bold text-gray-800">${postcnt}</div>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fas fa-clipboard-list fa-2x" style="color:#36b9cc;"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!-- Pending Requests Card Example -->
                        <div class="col-xl-3 col-md-6 mb-4">
                            <div class="card border-left-warning shadow h-100 py-2">
                                <div class="card-body">
                                    <div class="row no-gutters align-items-center">
                                        <div class="col mr-2">
                                            <div class="text-xs font-weight-bold text-warning text-uppercase mb-1">
                                                <span style="font-size: large;">閲覧数</span>
                                            </div>
                                            <div class="h5 mb-0 font-weight-bold text-gray-800">${hitcnt}</div>
                                        </div>
                                        <div class="col-auto">
                                            <i class="fa-solid fa-eye" style="font-size: xx-large;color:#f6c23e;"></i>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Content Row -->

                    <!-- Content Row -->
                    <div class="row">

                        <!-- Content Column -->
                        

                        <div class="col-lg-6 mb-4">

                            <!-- Illustrations -->
                            <div class="card shadow mb-4">
                                <div class="card-header py-3">
                                    <h6 class="m-0 font-weight-bold text-primary">お問い合わせ</h6>
                                </div>
                                <div class="card-body">
                                    <div class="text-center">
                                        <div class="tab-pane fade show active" id="qna" role="tabpanel" aria-labelledby="qna-tab">
                                            <table class="table table-bordered" id="qna-table" width="100%" cellspacing="0">
                                                <thead>
                                                    <tr>
                                                        <th>Num</th>
                                                        <th>カテゴリ</th>
                                                        <th>タイトル</th>
                                                        <th>作成日</th>
                                                        <th>回答状況</th>
                                                    </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="list" items="${q_list }">
                                                    <tr onclick="location.href='#'" style="cursor: pointer;">
                                                        <th>${list.q_num}</th>
                                                        <c:if test="${list.q_ctgr eq 1}"><th>ログイン</th></c:if>
                                                        <c:if test="${list.q_ctgr eq 2}"><th>機能/使い方</th></c:if>
                                                        <c:if test="${list.q_ctgr eq 3}"><th>権利侵害</th></c:if>
                                                        <c:if test="${list.q_ctgr eq 4}"><th>不具合/エラー/トラブル</th></c:if>
                                                        <th>${list.q_title}</th>
                                                        <th>${list.created_at}</th>
                                                        <c:if test="${list.a_yn eq 0 }"><th style="color:#FF0000";">未回答</th></c:if>
                                                        <c:if test="${list.a_yn eq 1}"><th>回答済み</th></c:if>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                    
                                </div>
                            </div>

                        </div>
                    </div>

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
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

    <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                <div class="modal-footer">
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    <a class="btn btn-primary" href="login.html">Logout</a>
                </div>
            </div>
        </div>
    </div>

    <!-- Bootstrap core JavaScript-->
    <script src="/blog/admin_front/vendor/jquery/jquery.min.js"></script>
    <script src="/blog/admin_front/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="/blog/admin_front/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="/blog/admin_front/js/sb-admin-2.min.js"></script>

    <!-- Page level plugins -->
    <script src="/blog/admin_front/vendor/chart.js/Chart.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/blog/admin_front/js/demo/chart-area-demo.js"></script><!-- 사각 그래프 -->
    <script src="/blog/admin_front/js/demo/chart-pie-demo.js"></script><!-- 원 그래프 -->
    <script src="/blog/admin_front/js/bootstrap.bundle.min.js"></script>

</body>

</html>