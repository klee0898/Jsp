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

	// 게시글등록
	public void write(String writer, String title, String content) {
		String sql = "INSERT INTO board VALUES(bbs_seq.nextVal,"
				+ "?,?,?, sysdate, 0,bbs_seq.currVal,0,0)";
		
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
//	public ArrayList<BoardDTO> list() {
	public ArrayList<BoardDTO> list(int currentPage, int limit) {
		ArrayList<BoardDTO> list = new ArrayList<>();
		
//		String sql = "SELECT * FROM board ORDER BY bid DESC";
//		String sql = "SELECT * FROM board ORDER BY bgroup DESC, bstep ASC";
		
		String sql = "select * "
				+ "from (select bbs.*, rownum rnum"
				+ "       from (select * from board order by bgroup desc, bstep asc) bbs) "
				+ "where rnum between ? and ?";
		getConnection();
		
		try {
			// 페이지의 시작 rnum 번호: 1, 11, 21, 31, ....
			int startRow = (currentPage-1)*limit + 1;
			
			// 10, 20, 30,.....
			int endRow = startRow + (limit - 1);
			
			ps = conn.prepareStatement(sql);
			ps.setInt(1, startRow);
			ps.setInt(2, endRow);
			
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
	public BoardDTO view(int bid, boolean increseHit) {
		// 조회수 처리
		if(increseHit)
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

	//----------------- 댓글 처리 -------------
	// 댓글 보기
	public BoardDTO replyView(int bid) {
//		BoardDTO dto = view(bid);
//		return dto;
		
		return view(bid, false);
	}

	// 댓글 등록
	public void addReply(String bid, String writer, String title, 
			String content, String bgroup, String bstep, String bindent) {
		
		replyOrder(bgroup, bstep);
		
		String sql = "INSERT INTO board VALUES(bbs_seq.nextVal,"
				+ "?,?,?, sysdate, 0,?,?,?)";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, title);
			ps.setString(2, writer);
			ps.setString(3, content);
			ps.setString(4, bgroup);
			ps.setInt(5, Integer.parseInt(bstep) + 1);
			ps.setInt(6, Integer.parseInt(bindent) + 1);
			
			ps.executeUpdate();
		} catch (SQLException e) {			
			e.printStackTrace();
		} finally {
			dbClose();
		}		
	}
	
	// 댓글 정렬
	public void replyOrder(String bgroup, String bstep) {	
		
		// 매개변수 bgroup, bstep은 클릭한 게시글의 bgroup과 bstep
		
		// 매개변수 bgroup과 db의 bgroup이 같고 db의 bstep이 매개변수 bstep보다 크면
		// 1증가 시킨다. => 기존의 댓글들은 1씩 증가 시킴
		String sql="UPDATE board SET bstep=bstep+1 "
				+ "WHERE bgroup=? AND bstep > ?";
		
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(bgroup));
			ps.setInt(2, Integer.parseInt(bstep));
			
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}		
	}

	// 전체 행수 구하기
	public int getListCount() {
		int n = 0;
		String sql = "SELECT count(*) FROM board";
		getConnection();
		
		try {
			ps = conn.prepareStatement(sql);			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				n = rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}	
		return n;
	}
	
	
}
