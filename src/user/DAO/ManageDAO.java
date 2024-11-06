package user.DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import DTO.ManageUserDTO;
import VO.AnswerVo;
import VO.B_userVo;
import VO.BlogVo;
import VO.PostVo;
import VO.QuestionVo;
import VO.TagVo;
import VO.categoryVo;
import util.Criteria;
import util.DBManager;

public class ManageDAO {
	
	private static ManageDAO instance = new ManageDAO();
	private ManageDAO() {}
	public static ManageDAO getInstance() {
		return instance;
	}
	public ManageUserDTO loadPage(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageUserDTO dto = new ManageUserDTO();
		B_userVo uvo = new B_userVo();
		BlogVo bvo = new BlogVo();
		
		String sql = "select user_id,idx,email,nickname,b.b_idx,b.b_title,b.one_liner,img.img_path\r\n" + 
				" from b_user \r\n" + 
				" left join img \r\n" + 
				" on img.user_img = b_user.idx \r\n" + 
				" left join blog b \r\n" + 
				" on b.b_u_idx = b_user.idx \r\n" + 
				" where b_user.user_id = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				uvo.setUser_id(rs.getString("user_id"));
				bvo.setB_idx(rs.getInt("b_idx"));
				uvo.setIdx(rs.getInt("idx"));
				uvo.setEmail(rs.getString("email"));
				bvo.setB_title(rs.getString("b_title"));
				uvo.setNickname(rs.getString("nickname"));
				bvo.setOne_liner(rs.getString("one_liner"));
				uvo.setImg_path(rs.getString("img_path"));
				dto.setUser(uvo);
				dto.setBlog(bvo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	public void setUserModify(ManageUserDTO dto, String fileName, boolean imgChange) {
		//vo = 페이지에서 보내온 수정할 내용이 담긴 vo
				//fileName = 수정 전 원래의 파일경로+파일명(파일 수정시 삭제용도)
				//imgChange = 원래 파일 삭제 여부 / true= 새 파일 등록,원래 파일 삭제  false = 파일 변경없음, 원래 파일 삭제 x
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				//where절의 idx로 수정할 대상 찾기
				String sql = "update b_user set nickname = ?, email = ? where idx = ?";
				
				try {
					conn = DBManager.getInstance().getConnection();
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, dto.getUser().getNickname());
					pstmt.setString(2, dto.getUser().getEmail());
					pstmt.setInt(3, dto.getUser().getIdx());
					pstmt.executeUpdate();
					
					String b_sql = "update blog set one_liner = ?,b_title = ? where b_u_idx = ?";
					
					if(dto.getBlog().getOne_liner() == null) {
						dto.getBlog().setOne_liner("");
					}
					if(dto.getBlog().getB_title() == null || dto.getBlog().getB_title().equals("")) {
						dto.getBlog().setB_title(dto.getUser().getUser_id()+"のブログ");
					}
					try {
						pstmt = conn.prepareStatement(b_sql);
						pstmt.setString(1, dto.getBlog().getOne_liner());
						pstmt.setString(2, dto.getBlog().getB_title());
						pstmt.setInt(3, dto.getUser().getIdx());
						pstmt.executeUpdate();
						
						String img_sql = "update img set img_path = ? where user_img = ?";
						try {
							pstmt = conn.prepareStatement(img_sql);
							pstmt.setString(1,dto.getUser().getImg_path());
							pstmt.setInt(2, dto.getUser().getIdx());
							pstmt.executeUpdate();
							
						}catch (Exception e) {
							e.printStackTrace();
						}
					}catch (Exception e) {
						e.printStackTrace();
					}

					if(imgChange) { //imgChange가 true일 경우 == 새 파일이 등록되어 원래 파일을 삭제할 경우

						System.out.println(fileName + " : filename"); //삭제할 원래 파일의 경로 + 파일명
						File img = new File(fileName); //경로+파일명을 바탕으로 file객체 생성
						System.out.println(img);//file 객체의 내용
						
						if(img != null) { // null이 아닌 경우는 file이 실제로 존재한다는 것
							img.delete(); //File.delete 파일 삭제
						}

					}
				}catch(Exception e) {
					e.printStackTrace();
				}finally {
					try {
						if(conn != null) conn.close();
						if(pstmt != null) pstmt.close();
					}catch (Exception e2) {
						e2.printStackTrace();
					}
				}
	}
	public ManageUserDTO selSidebar(String userid) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageUserDTO dto = new ManageUserDTO();
		
		String sql = "select idx,b.b_idx,img.img_path,b.b_title\r\n" + 
				"		from b_user\r\n" + 
				"		left join img\r\n" + 
				"		on img.user_img = b_user.idx\r\n" + 
				"		left join blog b\r\n" + 
				"		on b.b_u_idx = b_user.idx\r\n" + 
				"		where b_user.user_id = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.getUser().setIdx(rs.getInt("idx"));
				dto.getBlog().setB_idx(rs.getInt("b_idx"));
				dto.getBlog().setB_title(rs.getString("b_title"));
				dto.getUser().setImg_path(rs.getString("img_path"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dto;
	}
	
	public int checkedPw(String userid, String pw) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select pw from b_user where user_id = ?";
		String real_pw = "";
		int result = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				real_pw = rs.getString("pw");
			}
			
			if(real_pw.equals(pw)) {
				result = 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public int updateNewPw(String user_id,String new_pw) {
		//vo = 페이지에서 보내온 수정할 내용이 담긴 vo
		//fileName = 수정 전 원래의 파일경로+파일명(파일 수정시 삭제용도)
		//imgChange = 원래 파일 삭제 여부 / true= 새 파일 등록,원래 파일 삭제  false = 파일 변경없음, 원래 파일 삭제 x
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "update b_user set pw = ? where user_id = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, new_pw);
			pstmt.setString(2, user_id);
			pstmt.executeUpdate();
			result = 1;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public void user_del(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "update b_user set role = -1 where user_id = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	public int setQuestionSave(QuestionVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "insert into question (q_idx,q_ctgr,q_title,q_content,a_yn,q_u_idx) values (q_seq.nextval,?,?,?,0,?)";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getQ_ctgr());
			pstmt.setString(2, vo.getQ_title());
			pstmt.setString(3, vo.getQ_content());
			pstmt.setInt(4, vo.getQ_u_idx());
			pstmt.executeUpdate();
			result = 1;
			
			if(vo.getQ_img() != null) {
				int qidx = selectQ(vo);
				
				String img_sql = "insert into img (img_id,img_path,q_img) values(img_seq.nextval,?,?)";
				
				pstmt = conn.prepareStatement(img_sql);
				pstmt.setString(1, vo.getQ_img());
				pstmt.setInt(2, qidx);
				pstmt.executeUpdate();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public List<QuestionVo> getListWithPagingQnA(Criteria cri, String query_keyword, String query_type, String query_term) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		String sql_top = "SELECT * FROM (\r\n" + 
				"    SELECT /*+ index_desc(question q_pk) */\r\n" + 
				"        q_idx,\r\n" + 
				"        q_ctgr,\r\n" + 
				"        q_title,\r\n" + 
				"        img.img_path,\r\n" + 
				"        q_content,\r\n" + 
				"        question.created_at,\r\n" + 
				"        a_yn,\r\n" + 
				"        q_u_idx,\r\n" + 
				"        answer.a_content,\r\n" + 
				"        ROWNUM AS rn\r\n" + 
				"    FROM (\r\n" + 
				"        SELECT \r\n" + 
				"            q_idx,\r\n" + 
				"            q_ctgr,\r\n" + 
				"            q_title,\r\n" + 
				"            img.img_path,\r\n" + 
				"            q_content,\r\n" + 
				"            question.created_at,\r\n" + 
				"            a_yn,\r\n" + 
				"            q_u_idx,\r\n" + 
				"            answer.a_content\r\n" + 
				"        FROM question \r\n" + 
				"        LEFT JOIN img ON img.q_img = q_idx\r\n" + 
				"        LEFT JOIN answer ON answer.a_q_idx = q_idx \r\n" + 
				        query_term + 
				"    ) question";

		String sql_middle = "\r\n" + 
				"    LEFT JOIN img ON img.q_img = q_idx\r\n" + 
				"    LEFT JOIN answer ON answer.a_q_idx = q_idx "
				+ "where rownum <= ?*? " + query_keyword + query_type ;
		
		String sql_bot = " ) where rn > (?-1)*? ";
		
		sql = sql_top + sql_middle + sql_bot;
		//System.out.println(sql);
		List<QuestionVo> list = new ArrayList<QuestionVo>();
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QuestionVo vo = new QuestionVo();
				vo.setQ_idx(rs.getInt("q_idx"));
				vo.setQ_title(rs.getString("q_title"));
				vo.setQ_content(rs.getString("q_content"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setA_yn(rs.getInt("a_yn"));
				vo.setQ_img(rs.getString("img_path"));
				vo.setQ_ctgr(rs.getInt("q_ctgr"));
				vo.setA_content(rs.getString("a_content"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	public int selectQ(QuestionVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select q_idx from question where q_u_idx = ? order by created_at desc";
		int q_idx = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getQ_u_idx());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				q_idx = rs.getInt("q_idx");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return q_idx;
	}
	public int getCountQnA(String query_keyword, String query_type) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		int cnt = 0;
		
		if(query_keyword == "" && query_type == "") {
			sql = "select count(*) as cnt from question";
		}else {
			sql = "select count(*) as cnt from question where "+ query_keyword +" "+ query_type;
		}
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
	public QuestionVo sel_q_detail(int q_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		QuestionVo vo = new QuestionVo();
		String sql = "select question.*,img.img_path\r\n" + 
				"from question\r\n" + 
				"left join img\r\n" + 
				"on img.q_img = q_idx\r\n" + 
				"where q_idx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setQ_idx(rs.getInt("q_idx"));
				vo.setQ_content(rs.getString("q_content"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setQ_title(rs.getString("q_title"));
				vo.setQ_u_idx(rs.getInt("q_u_idx"));
				vo.setA_yn(rs.getInt("a_yn"));
				vo.setQ_ctgr(rs.getInt("q_ctgr"));
				vo.setQ_img(rs.getString("img_path"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return vo;
	}
	public AnswerVo sel_a_detailByQ(int q_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		AnswerVo vo = new AnswerVo();
		String sql = "select * from answer where a_q_idx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setA_idx(rs.getInt("a_idx"));
				vo.setA_content(rs.getString("a_content"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setRaiting(rs.getInt("raiting"));
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return vo;
	}
	public List<categoryVo> sel_ctgr(int b_idx) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<categoryVo> list = new ArrayList<categoryVo>();
		String sql = "select ctgridx,ctgr_name,ctgr_b_idx,ctgr_private,count(p_idx) as ctgr_p_cnt\r\n" + 
				"from category\r\n" + 
				"left join post\r\n" + 
				"on ctgridx = post.p_ctgr\r\n" + 
				"where ctgr_b_idx = ?\r\n" + 
				"group by ctgridx,ctgr_name,ctgr_b_idx , ctgr_private";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				categoryVo vo = new categoryVo();
				vo.setCtgr_b_idx(rs.getInt("ctgr_b_idx"));
				vo.setCtgr_name(rs.getString("ctgr_name"));
				vo.setCtgridx(rs.getInt("ctgridx"));
				vo.setCtgr_private(rs.getInt("ctgr_private"));
				vo.setCtgr_p_cnt(rs.getInt("ctgr_p_cnt"));
				list.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	public categoryVo saveCtgr(categoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "insert into category (ctgridx,ctgr_name,ctgr_b_idx) values (ctgr_seq.nextval,?,?)";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCtgr_name());
			pstmt.setInt(2, vo.getCtgr_b_idx());
			pstmt.executeUpdate();
			result = 1;
			
			if(result == 1) {
				
				String sel_sql = "select ctgridx from category where ctgr_name = ? and ctgr_b_idx = ?";
				
				pstmt = conn.prepareStatement(sel_sql);
				pstmt.setString(1, vo.getCtgr_name());
				pstmt.setInt(2, vo.getCtgr_b_idx());
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					vo.setCtgridx(rs.getInt("ctgridx"));
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vo;
	}
	public int ModifyCtgr(categoryVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "update category set ctgr_name = ? where ctgridx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getCtgr_name());
			pstmt.setInt(2, vo.getCtgridx());
			pstmt.executeUpdate();
			result = 1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public categoryVo sel_one_ctgr(categoryVo vo) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "select * from category where ctgridx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getCtgr_b_idx());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCtgridx(rs.getInt("ctgridx"));
				vo.setCtgr_name(rs.getString("ctgr_name"));
				vo.setCtgr_b_idx(rs.getInt("ctgr_b_idx"));
				vo.setCtgr_private(rs.getInt("ctgr_private"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return vo;
	}
	public int DelCtgr(int ctgridx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "delete category where ctgridx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ctgridx);
			pstmt.executeUpdate();
			result = 1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public int ctgrChangePri(int pri_bool, int ctgridx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//0 public 1 private
		String sql = null;
		if(pri_bool == 0) {
			sql = "update category set ctgr_private = 0 where ctgridx = ?";
		}else if(pri_bool == 1){
			sql = "update category set ctgr_private = 1 where ctgridx = ?";
		}else {
			return 0;
		}
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, ctgridx);
			pstmt.executeUpdate();
			result = 1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public int sel_one_p_pri_yn(int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int p_pri_yn = 0;
		
		String sql = "select p_pri_yn from blog where b_idx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				p_pri_yn = rs.getInt("p_pri_yn");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return p_pri_yn;
	}
	public int savePost(PostVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "insert into post (p_idx,p_ctgr,p_title,p_content,p_private,p_b_idx) values (post_seq.nextval,?,?,?,?,?)";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getP_ctgr());
			pstmt.setString(2, vo.getP_title());
			pstmt.setString(3, vo.getP_content());
			pstmt.setInt(4, vo.getP_private());
			pstmt.setInt(5, vo.getP_b_idx());
			pstmt.executeUpdate();
			result = 1;
			
			if(vo.getImg_path() != null) {
				int pidx = selectOnePbySave(vo);
				
				String img_sql = "insert into img (img_id,img_path,post_img) values(img_seq.nextval,?,?)";
				
				pstmt = conn.prepareStatement(img_sql);
				pstmt.setString(1, vo.getImg_path());
				pstmt.setInt(2, pidx);
				pstmt.executeUpdate();
			}
			
			sql = "select p_idx from post where p_ctgr = ? and p_title = ? and p_content = ? and p_private = ? and p_b_idx = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getP_ctgr());
			pstmt.setString(2, vo.getP_title());
			pstmt.setString(3, vo.getP_content());
			pstmt.setInt(4, vo.getP_private());
			pstmt.setInt(5, vo.getP_b_idx());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = rs.getInt("p_idx");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	private int selectOnePbySave(PostVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select p_idx from post where p_b_idx = ? and p_ctgr = ? and p_title = ? order by created_at desc";
		int p_idx = 0;
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getP_b_idx());
			pstmt.setInt(2, vo.getP_ctgr());
			pstmt.setString(3, vo.getP_title());
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				p_idx = rs.getInt("p_idx");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return p_idx;
	}
	public List<PostVo> sel_post(int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<PostVo> list = new ArrayList<PostVo>();
		
		PostVo vo = new PostVo();
		
		String sql = "select * from post where b_idx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setHit(rs.getInt("hit"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setModified_at(rs.getString("modified_at"));
				vo.setP_b_idx(rs.getInt("p_b_idx"));
				vo.setP_ctgr(rs.getInt("p_ctgr"));
				vo.setP_private(rs.getInt("p_private"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
	
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(rs != null) rs.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}

	public List<PostVo> getListWithPagingP_Manage(Criteria cri, String query_keyword, String query_type, String query_term, int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sql_top = "select * from (\r\n" + 
				"select /*+ index_desc(post post_pk) */\r\n" + 
				"rownum rn,p_idx,p_ctgr,p_title,p_content,created_at,modified_at,hit,p_b_idx,p_private \r\n" + 
				"from post\r\n";

		String sql_middle = "where rownum <= ?*? and p_b_idx = ? " + query_keyword + query_type + query_term;
		
		String sql_bot = " ) ) where rn > (?-1)*? ";
		
		sql = sql_top + sql_middle + sql_bot;
		
		List<PostVo> list = new ArrayList<PostVo>();
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, b_idx);
			pstmt.setInt(4, cri.getPageNum());
			pstmt.setInt(5, cri.getAmount());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVo vo = new PostVo();
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_ctgr(rs.getInt("p_ctgr"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setModified_at(rs.getString("modifited_at"));
				vo.setHit(rs.getInt("hit"));
				vo.setP_private(rs.getInt("p_private"));
				vo.setP_b_idx(rs.getInt("p_b_idx"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	public int getCountP_Manage(String query_keyword, int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		int cnt = 0;
		
		if(query_keyword == "") {
			sql = "select count(*) as cnt from post where p_b_idx = ? ";
		}else {
			sql = "select count(*) as cnt from post where p_b_idx = ? "+ query_keyword;
		}
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
	public PostVo sel_post_one(int pidx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		PostVo vo = new PostVo();
		String sql = "select post.*,img.img_path "
				+ "from post "
				+ "left join img "
				+ "on post_img = pidx "
				+ "where p_idx = ?";
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pidx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("content"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setHit(rs.getInt("hit"));
				vo.setImg_path(rs.getString("img_path"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return vo;
	}
	public int PostModifyAction(PostVo vo, boolean imgChange) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//where절의 idx로 수정할 대상 찾기
		String sql = "update post set p_title = ?,p_content = ?,modified_at = ?,p_ctgr = ? where p_idx = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getP_title());
			pstmt.setString(2, vo.getP_content());
			pstmt.setString(3, "");
			pstmt.setInt(4, vo.getP_ctgr());
			pstmt.setInt(5, vo.getP_idx());
			pstmt.executeUpdate();
			
			if(imgChange) {
				String img_sql = "update img set img_path = ? where post_img = ?";
				
					pstmt = conn.prepareStatement(img_sql);
					pstmt.setString(1, vo.getImg_path());
					pstmt.setInt(2, vo.getP_idx());
					pstmt.executeUpdate();
					result = 1;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
		
	}
	public int DelPost(int p_idx, String path) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//where절의 idx로 수정할 대상 찾기
		String img_sql = "delete img where post_img = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(img_sql);
			pstmt.setInt(1, p_idx);
			pstmt.executeUpdate();
			
			String sql = "delete post where p_idx = ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_idx);
			pstmt.executeUpdate();
			
			File img = new File(path);
			
			if(img != null) {
				img.delete();
			}
			result = 1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public int PChangePri(int pri_bool, int p_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//0 public 1 private
		String sql = null;
		if(pri_bool == 0) {
			sql = "update post set p_private = 0 where p_idx = ?";
		}else if(pri_bool == 1){
			sql = "update post set p_private = 1 where p_idx = ?";
		}else {
			return 0;
		}
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_idx);
			pstmt.executeUpdate();
			result = 1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public int BChangePri(int pri_bool, int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//0 public 1 private
		String sql = null;
		if(pri_bool == 0) {
			sql = "update blog set p_pri_yn = 0 where b_idx = ?";
		}else if(pri_bool == 1){
			sql = "update post set p_pri_yn = 1 where b_idx = ?";
		}else {
			return 0;
		}
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			pstmt.executeUpdate();
			result = 1;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	
	public List<PostVo> getListWithPagingR_Manage(Criteria cri, String query_keyword, String query_type, String query_term, int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sql_top = "select * from (\r\n" + 
				"select /*+ index_desc(b_reply b_reply_pk) */\r\n" + 
				"rownum rn,r_idx,r_content,re.created_at,re.modified_at,r_u_idx,r_p_idx,r_grade,r_parent,post.p_idx,post.p_title \r\n" + 
				"from b_reply re \r\n"
				+ " left join post "
				+ " on post.p_idx = re.r_p_idx";

		String sql_middle = "where rownum <= ?*? and r_p_idx = (select p_idx from post where p_b_idx = ?) " + query_keyword + query_type + query_term;
		
		String sql_bot = " ) ) where rn > (?-1)*? ";
		
		sql = sql_top + sql_middle + sql_bot;
		
		List<PostVo> list = new ArrayList<PostVo>();
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, b_idx);
			pstmt.setInt(4, cri.getPageNum());
			pstmt.setInt(5, cri.getAmount());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVo vo = new PostVo();
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_ctgr(rs.getInt("p_ctgr"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setModified_at(rs.getString("modifited_at"));
				vo.setHit(rs.getInt("hit"));
				vo.setP_private(rs.getInt("p_private"));
				vo.setP_b_idx(rs.getInt("p_b_idx"));
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return list;
	}
	public int getCountR_Manage(String query_keyword, int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		int cnt = 0;
		
		if(query_keyword == "") {
			sql = "select count(*) as cnt from b_reply where r_p_idx = (select p_idx from post where p_b_idx = ?) ";
		}else {
			sql = "select count(*) as cnt from b_reply where r_p_idx = (select p_idx from post where p_b_idx = ?) "+ query_keyword;
		}
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
	public int reply_del_Action(int r_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "delete b_reply where r_idx = ?";
		
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_idx);
			pstmt.executeUpdate();
			
			result = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	public int SearchResultCountB(String keyword_blog) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		int cnt = 0;
		
		if(keyword_blog == "") {
			sql = "select count(*) as cnt from blog";
		}else {
			sql = "select count(*) as cnt from blog where "+ keyword_blog;
		}
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
	public int SearchResultCountP(String keyword_post) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		int cnt = 0;
		
		if(keyword_post == "") {
			sql = "select count(*) as cnt from post";
		}else {
			sql = "select count(*) as cnt from post where "+ keyword_post;
		}
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
	public int SearchResultBlogCountP(String keyword_post, int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		int cnt = 0;
		
		if(keyword_post == "") {
			sql = "select count(*) as cnt from post where p_b_idx = ?";
		}else {
			sql = "select count(*) as cnt from post where p_b_idx = ? and "+ keyword_post;
		}
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt("cnt");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return cnt;
	}
	public void saveTag(int p_idx, String[] tags) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result = 0;
		String sql = "insert into tag (tag_id,tag_name,tag_p_id) values (tag_seq.nextval,?,?)";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			for(String tag_name : tags) {
				pstmt.setString(1,tag_name );
				pstmt.setInt(2, p_idx);
				pstmt.executeUpdate();
			}
			result = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	public List<TagVo> sel_tags(int pidx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<TagVo> list = new ArrayList<TagVo>();
		String sql = "select * from tag where tag_p_id = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pidx);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				TagVo vo = new TagVo();
				vo.setTag_id(rs.getInt("tag_id"));
				vo.setTag_name(rs.getString("tag_name"));
				vo.setTag_p_id(rs.getInt("tag_p_id"));
				list.add(vo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return list;
	}
	public int tagModifyAction(String[] tags,String[] tag_ids,int p_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update tag set tag_name = ? where tag_id = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int i = 0;i > tags.length;i++) {
				pstmt.setString(1, tags[i]);
				pstmt.setInt(2, Integer.parseInt(tag_ids[i]));
				pstmt.executeQuery();
			}
			result = 1;
			
			int[] tag_ids_all = selTagIdByP(p_idx);
			
			result = tagDelByModify(tag_ids,tag_ids_all);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
	}
	private int tagDelByModify(String[] tag_ids, int[] tag_ids_all) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "delete tag_id from tag where tag_id = ?";
		
		int[] tag_ids_int = Arrays.stream(tag_ids).mapToInt(Integer::parseInt).toArray();
		int result = 0;
		
		HashSet<Integer> tagIdsSet = new HashSet<>();
        for (int id : tag_ids_int) {
            tagIdsSet.add(id);
        }
        
        int[] missingTags = Arrays.stream(tag_ids_all)
                .filter(id -> !tagIdsSet.contains(id)) // tag_ids에 없는 값 필터링
                .toArray(); // 결과를 int[]로 변환
		
		
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			for(int tag_id : missingTags) {
				pstmt.setInt(1, tag_id);
				rs = pstmt.executeQuery();
			}
			result = 1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return result;
		
	}
	private int[] selTagIdByP(int p_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select tag_id from tag where tag_p_id = ?";
		int tag_ids[] = new int[100];
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_idx);
			rs = pstmt.executeQuery();
			
			int i = 0;
			while(rs.next()) {
				tag_ids[i] = rs.getInt("tag_id");
				i++;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
			}catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return tag_ids;
	}
	
}
