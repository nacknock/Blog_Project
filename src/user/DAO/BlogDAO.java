package user.DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.ManageUserDTO;
import VO.AnswerVo;
import VO.B_replyVo;
import VO.B_userVo;
import VO.PostVo;
import VO.QuestionVo;
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
}
