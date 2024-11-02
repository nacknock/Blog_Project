package user.DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ManageUserDTO;
import VO.B_userVo;
import VO.QuestionVo;
import util.Criteria;
import util.DBManager;

public class ManageDAO {
	
	private static ManageDAO instance = new ManageDAO();
	private ManageDAO() {}
	public static ManageDAO getInstance() {
		return instance;
	}
//	public  getMemberId(String id) {
//	
//	Connection conn = null;
//	PreparedStatement pstmt = null;
//	ResultSet rs = null;
//	
//	String sql = "select * from member where id = ?";
//	int result = 0;
//	
//	try {
//		conn = DB_Conn.getInst().conn();
//		pstmt = conn.prepareStatement(sql);
//		pstmt.setString(1, id);
//		rs = pstmt.executeQuery();
//		
//		if(rs.next()) {
//			result = 1;
//		}else {
//			result = -1;
//		}
//	} catch (Exception e) {
//		e.printStackTrace();
//	} finally {
//		try {
//
//			if(pstmt != null) pstmt.close();
//			if(conn != null) conn.close();
//			if(rs != null) rs.close();
//		} catch (Exception e2) {
//			e2.printStackTrace();
//		}
//	}
//	return result;
//}
	public ManageUserDTO loadPage(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageUserDTO dto = new ManageUserDTO();
		
		String sql = "select user_id,idx,email,nickname,b.b_title,b.one_liner,img.img_path\r\n" + 
				"from b_user\r\n" + 
				"left join img\r\n" + 
				"on img.user_img = b_user.idx\r\n" + 
				"left join blog b\r\n" + 
				"on b.b_u_idx = b_user.idx\r\n" + 
				"where b_user.user_id = ?";
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				dto.setUser_id(rs.getString("user_id"));
				dto.setIdx(rs.getInt("idx"));
				dto.setEmail(rs.getString("email"));
				dto.setB_title(rs.getString("b_title"));
				dto.setNickname(rs.getString("nickname"));
				dto.setOne_liner(rs.getString("one_liner"));
				dto.setPath(rs.getString("img_path"));
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
					pstmt.setString(1, dto.getNickname());
					pstmt.setString(2, dto.getEmail());
					pstmt.setInt(3, dto.getIdx());
					pstmt.executeUpdate();
					
					String b_sql = "update blog set one_liner = ?,b_title = ? where b_u_idx = ?";
					
					if(dto.getOne_liner() == null) {
						dto.setOne_liner("");
					}
					if(dto.getB_title() == null || dto.getB_title().equals("")) {
						dto.setB_title(dto.getUser_id()+"のブログ");
					}
					try {
						pstmt = conn.prepareStatement(b_sql);
						pstmt.setString(1, dto.getOne_liner());
						pstmt.setString(2, dto.getB_title());
						pstmt.setInt(3, dto.getIdx());
						pstmt.executeUpdate();
						
						String img_sql = "update img set img_path = ? where user_img = ?";
						try {
							pstmt = conn.prepareStatement(img_sql);
							pstmt.setString(1,dto.getPath());
							pstmt.setInt(2, dto.getIdx());
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
				dto.setIdx(rs.getInt("idx"));
				dto.setB_idx(rs.getInt("b_idx"));
				dto.setB_title(rs.getString("b_title"));
				dto.setPath(rs.getString("img_path"));
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
	public List<QuestionVo> getListWithPaging(Criteria cri, String query_keyword, String query_type, String query_term) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sql_top = "select * from (\r\n" + 
				"select /*+ index_desc(question q_pk) */\r\n" + 
				"rownum rn,q_idx,q_ctgr,q_title,img.img_path,q_content,question.created_at,a_yn,q_u_idx,answer.a_content from question \r\n" + 
				"left join img on img.q_img = q_idx\r\n" + 
				"left join answer on answer.a_q_idx = q_idx ";

		String sql_middle = "where rownum <= ?*? " + query_keyword + query_type + query_term;
		
		String sql_bot = " ) where rn > (?-1)*? ";
		
		sql = sql_top + sql_middle + sql_bot;
		
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
	private int selectQ(QuestionVo vo) {
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
	public int getCount(String query_keyword, String query_type, String query_term) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		
		int cnt = 0;
		
		if(query_keyword == "" && query_type == "") {
			sql = "select count(*) as cnt from question";
		}else {
			sql = "select count(*) as cnt from question where "+ query_keyword + query_type;
		}
		
		if(query_term != "") {
			sql = sql + query_term;
		}
		
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


}
