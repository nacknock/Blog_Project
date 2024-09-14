페이지 구성
총22
★(오래 걸리는거)6
☆(빨리 끝날수도 있는거)4
메인
★index(home),join,login,category_list,★search_result,question,about
유저(개인)
★index,detail,list,write,modify,mypage(change_pw,profile_modify,회원탈퇴,☆방문통계,☆댓글관리),★search_result
관리자
★index,★user_list,notice,☆신고글 리스트,☆신고글 디테일,answer
DB
user(신고당한 게시글,댓글 개수 컬럼)
posts(user)
유저 이동 기록(목적:footer의 개인 추천 게시글)(user,posts,category)user당 최근 30개까지 저장
댓글(posts)
category
notice
question
answer
신고(user/nullable:false,posts/nullable:false,comments/nullable:false)
차단(댓글 못쓰게 하는 기능/user)
post_category(다대다 중간 테이블)
img(user,posts,option)
option(블로그 설정:main img 등)(img)


@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@
메인 인덱스에 필요 요소
header - 로고,카테고리 표시하는 nav(구성:home,category,login/mypage),검색창
(로그인만 nav에 두고 로그인페이지에서 회원가입 연결)
content - 전 카테고리중 인기글,대표 카테고리 3개의 각 인기글(조회수,추천수 기준)(category에 따라서는 글 작성 날짜도 기준에 들어갈지도)
footer - 페이지 바로가기들,글 추천(개인)(비로그인시에는 content에 없는 카테고리들)
필요 테이블(category,posts,user,post_category,img)
~~~~~~~~~~~~~~~~~~~~
유저 메인

