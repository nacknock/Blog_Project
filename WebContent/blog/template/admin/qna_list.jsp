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
    
    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0-beta3/css/all.min.css">
    <link rel="stylesheet" href="/blog/admin_front/css/material-design-iconic-font/css/materialdesignicons.min.css">

    <!-- Custom styles for this page -->
    <link href="/blog/admin_front/vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    <!-- util css -->
    <link href="/blog/admin_front/css/btn.css" rel="stylesheet">
    <link href="/blog/admin_front/css/mg_pd.css" rel="stylesheet">

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
                    <h1 class="h3 text-gray-800 mb-15">お問い合わせ管理</h1>

                    <!-- DataTales Example -->
                    <div class="card shadow mb-4">
                        <div class="card-header py-3">
                            <h6 class="m-0 font-weight-bold text-primary"><a href="/admin/main.do">Main</a> / お問い合わせ管理</h6>
                        </div>
                        <div class="card-body">
                            <div class="table-responsive">
                                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                    <thead>
                                        <tr>
                                            <th>Num</th>
                                            <th>カテゴリ</th>
                                            <th>タイトル</th>
                                            <th>作成日</th>
                                            <th>回答状況</th>
                                        </tr>
                                    </thead>
                                    <tfoot>
                                        <tr>
                                            <th>Num</th>
                                            <th>カテゴリ</th>
                                            <th>タイトル</th>
                                            <th>作成日</th>
                                            <th>回答状況</th>
                                            <!-- <th>評価点</th> -->
                                        </tr>
                                    </tfoot>
                                    <tbody>
                                    <c:forEach var="list" items="${list }">
                                        <tr onclick="location.href='/admin/qna_detail.do?q_idx=${list.q_idx}'" style="cursor: pointer;">
                                            <th>${list.q_num }</th>
                                            <c:if test="${list.q_ctgr eq 1}"><th>ログイン</th></c:if>
                                            <c:if test="${list.q_ctgr eq 2}"><th>機能/使い方</th></c:if>
                                            <c:if test="${list.q_ctgr eq 3}"><th>権利侵害</th></c:if>
                                            <c:if test="${list.q_ctgr eq 4}"><th>不具合/エラー/トラブル</th></c:if>
                                            <th>${list.q_title }</th>
                                            <th>${list.created_at }</th>
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
    <script src="/blog/admin_front/vendor/datatables/jquery.dataTables.min.js"></script>
    <script src="/blog/admin_front/vendor/datatables/dataTables.bootstrap4.min.js"></script>

    <!-- Page level custom scripts -->
    <script src="/blog/admin_front/js/demo/datatables-demo.js"></script>

</body>

</html>