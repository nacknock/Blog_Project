package admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.AnswerVo;
import VO.B_userVo;
import VO.BlogVo;
import VO.PostVo;
import VO.QuestionVo;
import VO.categoryVo;
import util.DBManager;

public class AdminDAO {
	private static AdminDAO instance = new AdminDAO();
	private AdminDAO() {}
	public static AdminDAO getInstance() {
		return instance;
	}
	public int roleCheck(String login_userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select role from b_user where user_id = ?";
		int role = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, login_userid);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				role = rs.getInt("role");
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
		
		return role;
	}
	public int CntAllUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as cnt from b_user where role = 0";
		int cnt = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
	public int CntAllBlog() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as cnt from blog";
		int cnt = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
	public int CntAllPost() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(*) as cnt from post";
		int cnt = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
	public int CntAllHit() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select sum(hit) as cnt from post";
		int cnt = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
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
	public List<Integer> getRaitingGrape() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(raiting) as rat from answer";
		String sql_notz = "select count(raiting) as rat from answer where raiting = ?";
		int cnt_all = 0;
		int[] cnt_notz = new int[6];
		List<Integer> result_list = new ArrayList<Integer>();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				cnt_all = rs.getInt("rat");
			}
			for(int i = 0; i<6;i++) {
				pstmt = conn.prepareStatement(sql_notz);
				pstmt.setInt(1, i);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					cnt_notz[i] = rs.getInt("rat");
				}
			}
			for(int i = 0; i < 6;i++) {
				result_list.add((cnt_notz[i]/cnt_all) * 100);
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
		
		return result_list;
	}
	public List<QuestionVo> getQ5() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM AS rn, q.*\r\n" + 
				"FROM (\r\n" + 
				"    SELECT *\r\n" + 
				"    FROM question\r\n" + 
				"    ORDER BY created_at DESC\r\n" + 
				") q\r\n" + 
				"WHERE ROWNUM <= 5";
		List<QuestionVo> list = new ArrayList<QuestionVo>();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionVo vo = new QuestionVo();
				vo.setQ_idx(rs.getInt("q_idx"));
				vo.setQ_ctgr(rs.getInt("q_ctgr"));
				vo.setQ_title(rs.getString("q_title"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setA_yn(rs.getInt("a_yn"));
				vo.setQ_num(rs.getInt("rn"));
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
	public List<B_userVo> getAllUser() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from b_user order by created_at desc";
		List<B_userVo> list = new ArrayList<B_userVo>();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				B_userVo vo = new B_userVo();
				vo.setIdx(rs.getInt("idx"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setNickname(rs.getString("nickname"));
				vo.setEmail(rs.getString("email"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setRole(rs.getInt("role"));
				vo.setUser_num(i);
				list.add(vo);
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
		
		return list;
	}
	public List<BlogVo> getAllBlog() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select b_idx,b_title,blog.created_at,b_user.user_id,count(post.p_idx) as p_cnt,sum(post.hit) as b_hit from blog\r\n" + 
				"				left join b_user\r\n" + 
				"				on b_user.idx = b_u_idx\r\n" + 
				"				left join post\r\n" + 
				"				on p_b_idx = b_idx\r\n" + 
				"                group by b_idx,b_title,blog.created_at,b_user.user_id\r\n" + 
				"				order by created_at";
		List<BlogVo> list = new ArrayList<BlogVo>();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			int i = 1;
			while(rs.next()) {
				BlogVo vo = new BlogVo();
				vo.setB_idx(rs.getInt("b_idx"));
				vo.setB_title(rs.getString("b_title"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setOne_liner(rs.getString("user_id"));
				vo.setP_cnt(rs.getInt("p_cnt"));
				vo.setB_hit(rs.getInt("b_hit"));
				vo.setB_num(i);
				list.add(vo);
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
		
		return list;
	}
	public BlogVo getB_detail(int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select b_idx,b_title,blog.created_at,u.user_id,sum(p.hit) as b_hit,count(p.p_idx) as p_cnt,count(r.r_idx) as r_cnt\r\n" + 
				"from blog\r\n" + 
				"left join b_user u\r\n" + 
				"on u.idx = blog.b_u_idx\r\n" + 
				"left join post p\r\n" + 
				"on p.p_b_idx = blog.b_idx\r\n" + 
				"left join b_reply r\r\n" + 
				"on r.r_p_idx = p.p_idx\r\n" + 
				"where b_idx = ?"
				+ " group by b_idx,b_title,blog.created_at,u.user_id";
		BlogVo vo = new BlogVo();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				vo.setB_idx(rs.getInt("b_idx"));
				vo.setB_title(rs.getString("b_title"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setOne_liner(rs.getString("user_id"));
				vo.setP_cnt(rs.getInt("p_cnt"));
				vo.setB_hit(rs.getInt("b_hit"));
				vo.setR_cnt(rs.getInt("r_cnt"));
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
	public String getBlogLastPostCre(int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT created_at \r\n" + 
				"FROM (\r\n" + 
				"    SELECT created_at, p_title \r\n" + 
				"    FROM post \r\n" + 
				"    WHERE p_b_idx = ? \r\n" + 
				"    ORDER BY created_at DESC  " + 
				") " + 
				"WHERE ROWNUM = 1";
		String cre = "";
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				cre = rs.getString("created_at");
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
		
		return cre;
	}
	public List<PostVo> getAdminPList(int b_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT *\r\n" + 
				"FROM (\r\n" + 
				"    SELECT p_idx, p_title, p_private, post.created_at,p_b_idx, hit, COUNT(r.r_idx) AS r_cnt, ctgr.ctgr_name\r\n" + 
				"    FROM post\r\n" + 
				"    LEFT JOIN b_reply r ON r.r_p_idx = p_idx\r\n" + 
				"    LEFT JOIN category ctgr ON ctgr.ctgridx = p_ctgr\r\n" + 
				"    WHERE p_b_idx = ?\r\n" + 
				"    GROUP BY p_idx, p_title, p_private, post.created_at, p_b_idx, hit, ctgr.ctgr_name\r\n" + 
				"    ORDER BY post.created_at DESC\r\n" + 
				")\r\n" + 
				"WHERE ROWNUM <= 5";
		List<PostVo> list = new ArrayList<PostVo>();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				PostVo vo = new PostVo();
				BlogVo bvo = new BlogVo();
				categoryVo cvo = new categoryVo();
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_private(rs.getInt("p_private"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setHit(rs.getInt("hit"));
				vo.setR_cnt(rs.getInt("r_cnt"));
				cvo.setCtgr_name(rs.getString("ctgr_name"));
				vo.setP_ctgr(cvo);
				bvo.setB_idx(rs.getInt("p_b_idx"));
				vo.setP_b_idx(bvo);
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
	public List<QuestionVo> getQ_list() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT ROWNUM AS rn, question.*\r\n" + 
				"FROM question";
		List<QuestionVo> list = new ArrayList<QuestionVo>();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				QuestionVo vo = new QuestionVo();
				vo.setQ_idx(rs.getInt("q_idx"));
				vo.setQ_title(rs.getString("q_title"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setQ_ctgr(rs.getInt("q_ctgr"));
				vo.setA_yn(rs.getInt("a_yn"));
				vo.setQ_num(rs.getInt("rn"));
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
	public QuestionVo getQ_detail(int q_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT q_idx,q_title,q.created_at,q_ctgr,q_u_idx,u.user_id,img.img_path,q_content,a_yn\r\n" + 
				"from question q\r\n" + 
				"left join img\r\n" + 
				"on img.q_img = q_idx " +
				"left join b_user u \r\n" +
				"on u.idx = q_u_idx \r\n" ;
		QuestionVo vo = new QuestionVo();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				vo.setQ_idx(rs.getInt("q_idx"));
				vo.setQ_title(rs.getString("q_title"));
				vo.setQ_content(rs.getString("q_content"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setQ_ctgr(rs.getInt("q_ctgr"));
				vo.setA_yn(rs.getInt("a_yn"));
				vo.setQ_img(rs.getString("img_path"));
				vo.setQ_u_idx(rs.getInt("q_u_idx"));
				vo.setUser_id(rs.getString("user_id"));
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
	public int A_write(AnswerVo avo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "insert into answer (a_idx,a_content,a_q_idx,raiting) values (a_seq.nextval,?,?,0)" ;
		int result = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, avo.getA_content());
			pstmt.setInt(2, avo.getA_q_idx());
			result = pstmt.executeUpdate();
			
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
	public int UpA_yn(int q_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = "update question set a_yn = 1 where q_idx = ?" ;
		int result = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q_idx);
			result = pstmt.executeUpdate();
			
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
	public AnswerVo getA_detail(int q_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT a_idx,a.created_at,a.raiting,a_content \r\n" + 
				"from answer a \r\n" + 
				"left join question q\r\n" + 
				"on q.q_idx = a.a_q_idx " +
				"where q_idx = ?";
		AnswerVo vo = new AnswerVo();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, q_idx);
			rs = pstmt.executeQuery();
			while(rs.next()) {
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
	public int getRatingCnt() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select count(raiting) as raiting_cnt from answer";
		int result = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				result = rs.getInt("raiting_cnt");
				
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
		
		return result;
	}
}
