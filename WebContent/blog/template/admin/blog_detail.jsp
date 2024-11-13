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

                    <!-- Page Heading -->
                    <h1 class="h3 text-gray-800 mb-15">ブログ詳細</h1>
                    <h6 class="mb-4"><a href="#">Main</a> / <a href="#">ブログ一覧</a> / nawj0603의 블로그</h6>
                    <!-- DataTales Example -->
                    <!-- ============================================================== -->
	                <!-- content  -->
	                <!-- ============================================================== -->
	                <!-- ============================================================== -->
	                <!-- influencer profile  -->
	                <!-- ============================================================== -->
	                <div class="row mb-15">
	                    <div class="col-xl-12 col-lg-12 col-md-12 col-sm-12 col-12">
	                        <div class="card influencer-profile-data">
	                            <div class="card-body">
	                                <div class="row">
	                                        <div class="col-xl-10 col-lg-8 col-md-8 col-sm-8 col-12">
	                                            <div class="user-avatar-info">
	                                                <div class="m-b-20">
	                                                    <div class="user-avatar-name">
	                                                        <h2 class="mb-1">nawj0603의 블로그</h2>
	                                                    </div>
	                                                </div>
	                                                <!--  <div class="float-right"><a href="#" class="user-avatar-email text-secondary">www.henrybarbara.com</a></div> -->
	                                                <div class="user-avatar-address">
	                                                    <p class="border-bottom pb-3">
	                                                        <span class="d-xl-inline-block d-block mb-2"><i class="fa-solid fa-arrow-up-right-from-square" style="color:#4e73df;"></i><a href="#">블로그 바로가기</a></span>
	                                                        <span class="mb-2 ml-xl-4 d-xl-inline-block d-block">作成日: 23 June, 2018  </span>
	                                                        <span class=" mb-2 d-xl-inline-block d-block ml-xl-4">ユーザー : <a href="#">nawj0603</a></span>
	                                                        <span class="mb-2 ml-xl-4 d-xl-inline-block d-block">最新投稿日: 23 June, 2018  </span>
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
	                    <!-- ============================================================== -->
	                    <!-- widgets   -->
	                    <!-- ============================================================== -->
	                    <div class="row" style="justify-content: space-evenly;">
	                        <!-- ============================================================== -->
	                        <!-- four widgets   -->
	                        <!-- ============================================================== -->
	                        <!-- ============================================================== -->
	                        <!-- total views   -->
	                        <!-- ============================================================== -->
	                        <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
	                            <div class="card">
	                                <div class="card-body">
	                                    <div class="d-inline-block">
	                                        <h5 class="text-muted">総閲覧数</h5>
	                                        <h2 class="mb-0"> 10,28,056</h2>
	                                    </div>
	                                    <div class="float-right icon-circle-medium  icon-box-lg  bg-info-light mt-1">
	                                        <i class="fa fa-eye fa-fw fa-sm text-info"></i>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- ============================================================== -->
	                        <!-- end total views   -->
	                        <!-- ============================================================== -->
	                        <!-- ============================================================== -->
	                        <!-- total followers   -->
	                        <!-- ============================================================== -->
	                        <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
	                            <div class="card">
	                                <div class="card-body">
	                                    <div class="d-inline-block">
	                                        <h5 class="text-muted">総投稿数</h5>
	                                        <h2 class="mb-0"> 24,763</h2>
	                                    </div>
	                                    <div class="float-right icon-circle-medium  icon-box-lg  bg-primary-light mt-1">
	                                        <i class="fa-solid fa-newspaper" style="color: #4e73df;"></i>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- ============================================================== -->
	                        <!-- end total followers   -->
	                        <!-- ============================================================== -->
	                        <!-- ============================================================== -->
	                        <!-- partnerships   -->
	                        <!-- ============================================================== -->
	                        <div class="col-xl-3 col-lg-6 col-md-6 col-sm-12 col-12">
	                            <div class="card">
	                                <div class="card-body">
	                                    <div class="d-inline-block">
	                                        <h5 class="text-muted">総コメント数</h5>
	                                        <h2 class="mb-0">14</h2>
	                                    </div>
	                                    <div class="float-right icon-circle-medium  icon-box-lg  bg-secondary-light mt-1">
	                                        <i class="fa-solid fa-comment-dots" style="color: #f6c23e;"></i>
	                                    </div>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- ============================================================== -->
	                        <!-- end partnerships   -->
	                        <!-- ============================================================== -->
	                        <!-- ============================================================== -->
	                        <!-- total earned   -->
	                        <!-- ============================================================== -->
	                        
	                        <!-- ============================================================== -->
	                        <!-- end total earned   -->
	                        <!-- ============================================================== -->
	                    </div>
	                    <!-- ============================================================== -->
	                    <!-- end widgets   -->
	                    <!-- ============================================================== -->
	                    <div class="row mt-15">
	                        <!-- ============================================================== -->
	                        <!-- campaign activities   -->
	                        <!-- ============================================================== -->
	                        <div class="col-lg-12">
	                            <div class="section-block">
	                                <h3 class="section-title">最近の投稿</h3>
	                            </div>
	                            <div class="card">
	                                <div class="campaign-table table-responsive">
	                                    <table class="table">
	                                        <thead>
	                                            <tr class="border-0">
	                                                <th class="border-0">タイトル</th>
	                                                <th class="border-0">公開設定</th>
	                                                <th class="border-0">投稿日</th>
	                                                <th class="border-0">閲覧数</th>
	                                                <th class="border-0">コメント数</th>
	                                                <th class="border-0">カテゴリ</th>
	                                                <th class="border-0">ハッシュタグ</th>
	                                            </tr>
	                                        </thead>
	                                        <tbody>
	                                            <tr onclick="location.href='#'" style="cursor: pointer;">
	                                                <td>글 제목</td>
	                                                <td>공개</td>
	                                                <td>2014-04-09</td>
	                                                <td>1,00,000</td>
	                                                <td>14</td>
	                                                <td>여행</td>
	                                                <td>
	                                                    <div class="dropdown float-right">
	                                                        <a href="#" class="dropdown-toggle card-drop" data-toggle="dropdown" aria-expanded="true">
	                                                                <i class="mdi mdi-dots-vertical"></i>
	                                                                     </a>
	                                                        <div class="dropdown-menu dropdown-menu-right">
	                                                            <!-- item-->
	                                                            <a href="javascript:void(0);" class="dropdown-item">#여행</a>
	                                                            <!-- item-->
	                                                            <a href="javascript:void(0);" class="dropdown-item">#강원도</a>
	                                                            <!-- item-->
	                                                            <a href="javascript:void(0);" class="dropdown-item">#폭설</a>
	                                                            <!-- item-->
	                                                            <a href="javascript:void(0);" class="dropdown-item">#조난</a>
	                                                        </div>
	                                                    </div>
	                                                </td>
	                                            </tr>
	                                        </tbody>
	                                    </table>
	                                </div>
	                            </div>
	                        </div>
	                        <!-- ============================================================== -->
	                        <!-- end campaign activities   -->
	                        <!-- ============================================================== -->
	                    </div>
                        <!-- ============================================================== -->
                        <!-- end content  -->
                        <!-- ============================================================== -->
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