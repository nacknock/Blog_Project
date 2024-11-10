package user.DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sun.javafx.collections.MappingChange.Map;

import DTO.ManageUserDTO;
import VO.AnswerVo;
import VO.B_replyVo;
import VO.B_userVo;
import VO.BlogVo;
import VO.PostVo;
import VO.QuestionVo;
import VO.TagVo;
import VO.categoryVo;
import util.Criteria;
import util.DBManager;

public class BlogDAO {
	
	private static BlogDAO instance = new BlogDAO();
	private BlogDAO() {}
	public static BlogDAO getInstance() {
		return instance;
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
	
	public boolean checkReply(String userid, int r_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		boolean check = false;
		String sql = "select * from b_reply where r_idx = ? and r_u_idx = (select idx from b_user where user_id = ?)";
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, r_idx);
			pstmt.setString(2, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				 if(rs.getString("r_content") != null &&!rs.getString("r_content").equals("")) {
					 check = true;
				 }
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
		
		return check;
	}
	public int reply_updateAction(B_replyVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = "update b_reply set r_content = ? where r_idx = ?";
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getR_content());
			pstmt.setInt(2, vo.getR_idx());
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
	public B_userVo getUser(String userid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		B_userVo vo = new B_userVo();
		String sql = "select * from user where user_id = ?";
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setIdx(rs.getInt("idx"));
				vo.setUser_id(rs.getString("user_id"));
				vo.setNickname(rs.getString("nickname"));
				
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
	public int reply_write(B_replyVo vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		if(vo.getR_parent() == null) {
			sql = "insert into b_reply (r_idx,r_content,r_u_idx,r_p_idx,r_grade) values (b_reply_seq.nextval,?,?,?,?)";
		}else {
			sql = "insert into b_reply (r_idx,r_content,r_u_idx,r_p_idx,r_grade,r_parent) values (b_reply_seq.nextval,?,?,?,?,?)";
		}
		int result = 0;
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getR_content());
			pstmt.setInt(2, vo.getR_u_idx().getIdx());
			pstmt.setInt(3, vo.getR_p_idx().getP_idx());
			pstmt.setInt(4, vo.getR_grade());
			if(vo.getR_parent() != null) {
				pstmt.setInt(5, vo.getR_parent().getR_idx());
			}
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
	public ManageUserDTO loadPageByBlog(int idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ManageUserDTO dto = new ManageUserDTO();
		
		String sql = "select user_id,idx,email,nickname,b.b_idx,b.b_title,b.one_liner,img.img_path\r\n" + 
				"from b_user\r\n" + 
				"left join img\r\n" + 
				"on img.user_img = b_user.idx\r\n" + 
				"left join blog b\r\n" + 
				"on b.b_u_idx = b_user.idx\r\n" + 
				"where b_idx = ?";
		
		System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				BlogVo bvo = new BlogVo();
				B_userVo uvo = new B_userVo();
				uvo.setUser_id(rs.getString("user_id"));
				bvo.setB_idx(rs.getInt("b_idx"));
				System.out.println(rs.getInt("b_idx")+" : b_idx");
				uvo.setIdx(rs.getInt("idx"));
				uvo.setEmail(rs.getString("email"));
				bvo.setB_title(rs.getString("b_title"));
				uvo.setNickname(rs.getString("nickname"));
				bvo.setOne_liner(rs.getString("one_liner"));
				uvo.setImg_path(rs.getString("img_path"));
				dto.setUser(uvo);
				dto.setBlog(bvo);
			}

			System.out.println("테스트");
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
	public List<PostVo> getListByBlog(Criteria cri, ManageUserDTO dto, String my, String query_keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sql_top = "select * from (\r\n" + 
				"select /*+ index_desc(post post_pk) */\r\n" + 
				"rownum rn,p_idx,p_ctgr,p_private,p_title,p_content,category.ctgr_name,category.ctgr_private,img.img_path,post.created_at,p_b_idx,hit from post \r\n" + 
				"left join img on img.post_img = p_idx\r\n" + 
				"left join blog on post.p_b_idx = blog.b_idx " +
				"left join category on category.ctgridx = post.p_ctgr ";

		String sql_middle = "where rownum <= ?*? and blog.b_idx = ? "+ my + query_keyword + " ";
		
		String sql_bot = " ) where rn > (?-1)*? ";
		
		sql = sql_top + sql_middle + sql_bot;
		
		List<PostVo> list = new ArrayList<PostVo>();
		
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, dto.getBlog().getB_idx());
			pstmt.setInt(4, cri.getPageNum());
			pstmt.setInt(5, cri.getAmount());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVo vo = new PostVo();
				categoryVo cvo = new categoryVo();
				BlogVo bvo = new BlogVo();
				vo.setP_idx(rs.getInt("p_idx"));
				cvo.setCtgridx(rs.getInt("p_ctgr"));
				cvo.setCtgr_name(rs.getString("ctgr_name"));
				cvo.setCtgr_private(rs.getInt("ctgr_private"));
				vo.setP_ctgr(cvo);
				vo.setP_private(rs.getInt("p_private"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setImg_path(rs.getString("img_path"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setHit(rs.getInt("hit"));
				bvo.setB_idx(rs.getInt("p_b_idx"));
				vo.setP_b_idx(bvo);
				
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
	public int getCountByBlogMain(String my, ManageUserDTO dto, String query_keyword) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int cnt = 0;
		if(my.equals("")) {
			sql = " select count(*) as cnt from post "
					+ " left join blog "
					+ " on blog.b_idx = post.p_b_idx "
					+ " where blog.b_idx = ? and post.p_private = 0 " + query_keyword;
		}else {
			sql = " select count(*) as cnt from post "
					+ " left join blog "
					+ " on blog.b_idx = post.p_b_idx "
					+ " where blog.b_idx = ? " + query_keyword;	
		}
		
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBlog().getB_idx());
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
	public List<categoryVo> getCtgrListByBlog(String my, ManageUserDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<categoryVo> list = new ArrayList<categoryVo>();
		if(my.equals("")) {
			sql = " select category.*,count(post.p_idx) as ctgr_p_cnt "
					+ "from category "
					+ "left join post "
					+ "on p_ctgr = category.ctgridx "
					+ "where ctgr_b_idx = ? and post.p_private = 0 and ctgr_private = 0 "
					+ " group by ctgridx,ctgr_name,ctgr_b_idx,ctgr_private ";
		}else {
			sql = " select category.*,count(post.p_idx) as ctgr_p_cnt "
					+ "from category "
					+ "left join post "
					+ "on p_ctgr = category.ctgridx "
					+ "where ctgr_b_idx = ? "
					+ " group by ctgridx,ctgr_name,ctgr_b_idx,ctgr_private ";	
		}
		
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBlog().getB_idx());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				categoryVo vo = new categoryVo();
				vo.setCtgr_b_idx(rs.getInt("ctgr_b_idx"));
				vo.setCtgridx(rs.getInt("ctgridx"));
				vo.setCtgr_name(rs.getString("ctgr_name"));
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
	public List<PostVo> getLoadTop3(ManageUserDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM ( " +
	             "SELECT /*+ index_desc(post post_pk) */ " +
	             "ROWNUM rn, p_idx, p_ctgr, p_private, p_title, img.img_path, post.created_at, p_b_idx, hit " +
	             "FROM ( " +
	             "SELECT post.p_idx, post.p_ctgr, post.p_private, post.p_title, img.img_path, post.created_at, post.p_b_idx, post.hit " +
	             "FROM post " +
	             "LEFT JOIN img ON img.post_img = post.p_idx " +
	             "LEFT JOIN blog ON post.p_b_idx = blog.b_idx " +
	             "LEFT JOIN category ON category.ctgridx = post.p_ctgr " +
	             "WHERE blog.b_idx = ? AND category.ctgr_private = 0 AND post.p_private = 0 " +
	             "ORDER BY hit DESC " +  // 먼저 정렬
	             ") post " +
	             "LEFT JOIN img ON img.post_img = post.p_idx " +
	             "LEFT JOIN blog ON post.p_b_idx = blog.b_idx " +
	             "LEFT JOIN category ON category.ctgridx = post.p_ctgr " +
	             "WHERE ROWNUM <= 3 " +  // 그 후 최대 3개 행 선택
	             ")";
		List<PostVo> list = new ArrayList<PostVo>();
		
		
		//System.out.println(sql + "sdadfdfafs");
		System.out.println(dto.getBlog().getB_idx()+"dsfadfadfsadfsadfsadfss");
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBlog().getB_idx());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVo vo = new PostVo();
				categoryVo cvo = new categoryVo();
				BlogVo bvo = new BlogVo();
				vo.setP_idx(rs.getInt("p_idx"));
				cvo.setCtgridx(rs.getInt("p_ctgr"));
				vo.setP_ctgr(cvo);
				vo.setP_private(rs.getInt("p_private"));
				vo.setP_title(rs.getString("p_title"));
				vo.setImg_path(rs.getString("img_path"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setHit(rs.getInt("hit"));
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
	public PostVo loadDetail(int p_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select p_idx,p_title,p_content,post.created_at,p_ctgr,p_b_idx,hit,p_private,category.ctgr_name,category.ctgr_private,img.img_path "
				+ "from post "
				+ "left join img "
				+ "on img.post_img = post.p_idx "
				+ "left join category "
				+ "on category.ctgridx = post.p_ctgr "
				+ "where p_idx = ?";
		PostVo vo = new PostVo();
		
		
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_idx);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				categoryVo cvo = new categoryVo();
				BlogVo bvo = new BlogVo();
				vo.setP_idx(rs.getInt("p_idx"));
				cvo.setCtgridx(rs.getInt("p_ctgr"));
				cvo.setCtgr_name(rs.getString("ctgr_name"));
				vo.setP_private(rs.getInt("p_private"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setImg_path(rs.getString("img_path"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setHit(rs.getInt("hit"));
				bvo.setB_idx(rs.getInt("p_b_idx"));
				vo.setP_b_idx(bvo);
				if(rs.getInt("ctgr_private") != 0) {
					cvo.setCtgr_private(rs.getInt("ctgr_private"));
				}
				vo.setP_ctgr(cvo);
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
	public List<B_replyVo> getReplyListByBlog(Criteria cri, int p_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = " SELECT * " + 
				"FROM ( " + 
				"    SELECT /*+ index_desc(reply b_reply_pk) */ " + 
				"           ROWNUM rn, reply.r_idx, reply.r_content, reply.created_at, reply.r_u_idx, reply.r_p_idx, reply.r_grade, " + 
				"           reply.r_parent, " + 
				"           loguser.nickname, loguser.user_id,img.img_path, " + 
				"           parnuser.nickname AS parnnick, parnuser.idx AS parnidx " + 
				"    FROM ( " + 
				"        SELECT reply.r_idx, reply.r_content, reply.created_at, reply.r_u_idx, reply.r_p_idx, reply.r_grade, " + 
				"               reply.r_parent, " + 
				"               loguser.nickname, loguser.user_id,img.img_path, " + 
				"               parnuser.nickname AS parnnick, parnuser.idx AS parnidx " + 
				"        FROM b_reply reply " + 
				"        LEFT JOIN post ON post.p_idx = reply.r_p_idx " + 
				"        LEFT JOIN b_user loguser ON loguser.idx = reply.r_u_idx " + 
				"        LEFT JOIN b_reply parent ON parent.r_idx = reply.r_parent " + 
				"        LEFT JOIN b_user parnuser ON parnuser.idx = parent.r_u_idx " + 
				"        LEFT JOIN img ON img.user_img = loguser.idx " + 
				"        WHERE post.p_idx = ? " + 
				"        ORDER BY CASE WHEN reply.r_parent IS NULL THEN 0 ELSE 1 END,   " + 
				"            reply.created_at DESC " + 
				"    ) reply " + 
				"    LEFT JOIN post ON post.p_idx = reply.r_p_idx " + 
				"    LEFT JOIN b_user loguser ON loguser.idx = reply.r_u_idx " + 
				"    LEFT JOIN b_reply parent ON parent.r_idx = reply.r_parent " + 
				"    LEFT JOIN b_user parnuser ON parnuser.idx = parent.r_u_idx " + 
				"        LEFT JOIN img ON img.user_img = loguser.idx " + 
				"    WHERE ROWNUM <= ?*?  " + 
				") " + 
				"WHERE rn > (?-1)*? ";
		
		List<B_replyVo> list = new ArrayList<B_replyVo>();
		
		
		System.out.println(sql+"@@@@@@@@@@reply");
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_idx);
			pstmt.setInt(2, cri.getPageNum());
			pstmt.setInt(3, cri.getAmount());
			pstmt.setInt(4, cri.getPageNum());
			pstmt.setInt(5, cri.getAmount());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				B_replyVo vo = new B_replyVo();
				B_userVo u_vo = new B_userVo();
				PostVo p_vo = new PostVo();
				B_replyVo parent_vo = new B_replyVo();
				B_userVo parn_u_vo = new B_userVo();
				vo.setR_idx(rs.getInt("r_idx"));
				vo.setR_content(rs.getString("r_content"));
				vo.setCreated_at(rs.getString("created_at"));
				u_vo.setIdx(rs.getInt("r_u_idx"));
				u_vo.setNickname(rs.getString("nickname"));
				u_vo.setUser_id(rs.getString("user_id"));
				u_vo.setImg_path(rs.getString("img_path"));
				vo.setR_u_idx(u_vo);
				p_vo.setP_idx(rs.getInt("r_p_idx"));
				vo.setR_p_idx(p_vo);
				vo.setR_grade(rs.getInt("r_grade"));
				parent_vo.setR_idx(rs.getInt("r_parent"));
				parn_u_vo.setIdx(rs.getInt("parnidx"));
				parn_u_vo.setNickname(rs.getString("parnnick"));
				parent_vo.setR_u_idx(parn_u_vo);
				vo.setR_parent(parent_vo);
				
				
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
	public int getCountByReplyPost(int p_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int cnt = 0;
		sql = " select count(*) as cnt from b_reply "
				+ " left join post "
				+ " on post.p_idx = b_reply.r_p_idx "
				+ " where r_p_idx = ? ";	
		
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_idx);
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
	public void upHit(int p_idx) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql = null;
		sql = "update post set hit = hit+1 where p_idx = ?";	
		
		//System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, p_idx);
			pstmt.executeUpdate();
			
			
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
	public List<BlogVo> SearchResultB(Criteria cri, String keyword_blog) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sql_top = "select * from (\r\n" + 
				"select /*+ index_desc(blog blog_pk) */\r\n" + 
				"rownum rn,b_idx,one_liner,b_title,created_at,img.img_path from blog "
				+ "left join img on img.user_img = blog.b_u_idx ";

		String sql_middle = " where rownum <= ?*? "+ keyword_blog + " ";
		
		String sql_bot = " ) where rn > (?-1)*? ";
		
		sql = sql_top + sql_middle + sql_bot;
		
		List<BlogVo> list = new ArrayList<BlogVo>();
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BlogVo vo = new BlogVo();
				vo.setB_idx(rs.getInt("b_idx"));
				vo.setB_title(rs.getString("b_title"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setOne_liner(rs.getString("one_liner"));
				vo.setImg_path(rs.getString("img_path"));
				
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
	public List<PostVo> SearchResultP(Criteria cri, String keyword_post) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sql_top = "select * from (\r\n" + 
				"select /*+ index_desc(post post_pk) */\r\n" + 
				"rownum rn,p_idx,p_title,created_at,img.img_path from post "
				+ "left join img on img.post_img = post.p_idx ";

		String sql_middle = " where rownum <= ?*? "+ keyword_post + " and p_private = 0 ";
		
		String sql_bot = " ) where rn > (?-1)*? ";
		
		sql = sql_top + sql_middle + sql_bot;
		
		List<PostVo> list = new ArrayList<PostVo>();
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVo vo = new PostVo();
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setImg_path(rs.getString("img_path"));
				vo.setP_content(rs.getString("p_content"));
				
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
	public List<PostVo> SearchResultBlogP(Criteria cri, String keyword_post) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String sql_top = "select * from (\r\n" + 
				"select /*+ index_desc(post post_pk) */\r\n" + 
				"rownum rn,p_idx,p_title,created_at,img.img_path from post "
				+ "left join img on img.post_img = post.p_idx ";

		String sql_middle = " where rownum <= ?*? "+ keyword_post + " and p_private = 0 ";
		
		String sql_bot = " ) where rn > (?-1)*? ";
		
		sql = sql_top + sql_middle + sql_bot;
		
		List<PostVo> list = new ArrayList<PostVo>();
		
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cri.getPageNum());
			pstmt.setInt(2, cri.getAmount());
			pstmt.setInt(3, cri.getPageNum());
			pstmt.setInt(4, cri.getAmount());
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				PostVo vo = new PostVo();
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setCreated_at(rs.getString("created_at"));
				vo.setImg_path(rs.getString("img_path"));
				vo.setP_content(rs.getString("p_content"));
				
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
	public List<TagVo> getTagList(ManageUserDTO dto){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<TagVo> list = new ArrayList<TagVo>();
			sql = " select tag.* "
					+ "from tag "
					+ "left join post "
					+ "on tag_p_id = post.p_idx "
					+ "where post.p_b_idx = ? ";
		
		System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBlog().getB_idx());
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
	public List<TagVo> getTagList(String my, ManageUserDTO dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		List<TagVo> list = new ArrayList<TagVo>();
			sql = " select tag.* "
					+ "from tag "
					+ "left join post "
					+ "on tag_p_id = post.p_idx "
					+ "where post.p_b_idx = ? " + my;
		
		System.out.println(sql);
		try {
			conn = DBManager.getInstance().getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getBlog().getB_idx());
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
}
