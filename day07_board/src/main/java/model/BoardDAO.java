package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;

public class BoardDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	// DB에 연결된 Connection(접속된 객체)을 얻어오는 메소드
	public void getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "1212";		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 오라클 서버에 접속된 객체를 반환 받음
			conn = DriverManager.getConnection(url, user, pw);
			System.out.println("데이터베이스 연결 성공~~!");
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	// 자원 반납
	public void dbClose() {
		try {
			if(rs !=null) rs.close();
			if(ps !=null) ps.close();
			if(conn !=null) conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 글등록
	public void write(String writer, String title, String content) {
		String sql = "INSERT INTO board VALUES(bbs_seq.nextVal,"
				+ "?,?,?, sysdate, 0,0,0,0)";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			ps.setString(2, writer);
			ps.setString(3, content);
			
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	// 게시글 리스트
	public ArrayList<BoardDTO> list() {
		ArrayList<BoardDTO> list = new ArrayList<>();
		
		String sql = "SELECT * FROM board ORDER BY bid DESC";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int bid = rs.getInt("bid");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				Timestamp regDate = rs.getTimestamp("reg_date");
				
				int hit = rs.getInt("hit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				// dto로 묶기
				BoardDTO dto = new BoardDTO(bid, title, writer, content, regDate, hit, bgroup, bstep, bindent);
				list.add(dto);
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return list;
	}

	// 글상세보기
	public BoardDTO view(int bid) {
		// 조회수 처리
		plusHit(bid);
		
		String sql = "SELECT * FROM board WHERE bid=?";
		getConnection();
		
		BoardDTO dto=null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				// bid에 재할당
				bid = rs.getInt("bid");
				String title = rs.getString("title");
				String writer = rs.getString("writer");
				String content = rs.getString("content");
				Timestamp regDate = rs.getTimestamp("reg_date");
				
				int hit = rs.getInt("hit");
				int bgroup = rs.getInt("bgroup");
				int bstep = rs.getInt("bstep");
				int bindent = rs.getInt("bindent");
				
				// dto로 묶기
				dto = new BoardDTO(bid, title, writer, content, regDate, hit, bgroup, bstep, bindent);				
			}
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
		return dto;
	}

	// 게시글 삭제
	public void delete(int bid) {
		String sql = "DELETE FROM board WHERE bid = ?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}

	// 게시글 수정
	public void update(int bid, String writer, String title, String content) {
		String sql = "UPDATE board SET title=?, writer=?"
				+ ", content=? WHERE bid = ?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, writer);
			ps.setString(3, content);
			ps.setInt(4, bid);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		
	}
	
	// 조회수 증가
	public void plusHit(int bid) {
		String sql = "UPDATE board SET hit=hit+1 WHERE bid = ?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, bid);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
	}
	
	
}
