������ ����
��22
��(���� �ɸ��°�)6
��(���� �������� �ִ°�)4
����
��index(home),join,login,category_list,��search_result,question,about
����(����)
��index,detail,list,write,modify,mypage(change_pw,profile_modify,ȸ��Ż��,�ٹ湮���,�ٴ�۰���),��search_result
������
��index,��user_list,notice,�ٽŰ�� ����Ʈ,�ٽŰ�� ������,answer
DB
user(�Ű���� �Խñ�,��� ���� �÷�)
posts(user)
���� �̵� ���(����:footer�� ���� ��õ �Խñ�)(user,posts,category)user�� �ֱ� 30������ ����
���(posts)
category
notice
question
answer
�Ű�(user/nullable:false,posts/nullable:false,comments/nullable:false)
����(��� ������ �ϴ� ���/user)
post_category(�ٴ�� �߰� ���̺�)
img(user,posts,option)
option(��α� ����:main img ��)(img)


@@@@@@@@@@@@@@@@@@@@
@@@@@@@@@@@@@@@@@@@@
���� �ε����� �ʿ� ���
header - �ΰ�,ī�װ� ǥ���ϴ� nav(����:home,category,login/mypage),�˻�â
(�α��θ� nav�� �ΰ� �α������������� ȸ������ ����)
content - �� ī�װ��� �α��,��ǥ ī�װ� 3���� �� �α��(��ȸ��,��õ�� ����)(category�� ���󼭴� �� �ۼ� ��¥�� ���ؿ� ������)
footer - ������ �ٷΰ����,�� ��õ(����)(��α��νÿ��� content�� ���� ī�װ���)
�ʿ� ���̺�(category,posts,user,post_category,img)
~~~~~~~~~~~~~~~~~~~~
���� ����

