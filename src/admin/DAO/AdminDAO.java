package admin.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import VO.B_userVo;
import VO.BlogVo;
import VO.PostVo;
import VO.QuestionVo;
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
		String sql = "select count(raiting) as rat from answer where not raiting = 0";
		String sql_notz = "select count(raiting) as rat from answer where raiting = ?";
		int cnt_all = 0;
		int[] cnt_notz = new int[5];
		List<Integer> result_list = new ArrayList<Integer>();
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();pstmt.close();
			if(rs.next()) {
				cnt_all = rs.getInt("rat");
			}
			for(int i = 1; i<6;i++) {
				pstmt = conn.prepareStatement(sql_notz);
				pstmt.setInt(1, i);
				rs = pstmt.executeQuery();pstmt.close();
				if(rs.next()) {
					cnt_notz[i-1] = rs.getInt("rat");
				}
			}
			for(int i = 0; i < 5;i++) {
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
}
