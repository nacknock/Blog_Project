package user.DAO;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DTO.ManageUserDTO;
import VO.B_userVo;
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
		//vo = ���������� ������ ������ ������ ��� vo
				//fileName = ���� �� ������ ���ϰ��+���ϸ�(���� ������ �����뵵)
				//imgChange = ���� ���� ���� ���� / true= �� ���� ���,���� ���� ����  false = ���� �������, ���� ���� ���� x
				Connection conn = null;
				PreparedStatement pstmt = null;
				
				//where���� idx�� ������ ��� ã��
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
						dto.setB_title(dto.getUser_id()+"�Ϋ֫���");
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

					if(imgChange) { //imgChange�� true�� ��� == �� ������ ��ϵǾ� ���� ������ ������ ���

						System.out.println(fileName + " : filename"); //������ ���� ������ ��� + ���ϸ�
						File img = new File(fileName); //���+���ϸ��� �������� file��ü ����
						System.out.println(img);//file ��ü�� ����
						
						if(img != null) { // null�� �ƴ� ���� file�� ������ �����Ѵٴ� ��
							img.delete(); //File.delete ���� ����
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
		//vo = ���������� ������ ������ ������ ��� vo
		//fileName = ���� �� ������ ���ϰ��+���ϸ�(���� ������ �����뵵)
		//imgChange = ���� ���� ���� ���� / true= �� ���� ���,���� ���� ����  false = ���� �������, ���� ���� ���� x
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		
		//where���� idx�� ������ ��� ã��
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
		
		//where���� idx�� ������ ��� ã��
		String sql = "delete b_user where user_id = ?";
		
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


}