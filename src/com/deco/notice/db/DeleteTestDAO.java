package com.deco.notice.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class DeleteTestDAO {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";

	private Connection getConnection() {
		try {
			// Context 객체를 생성 (프로젝트 정보를 가지고있는객체)
			Context initCTX = new InitialContext();
			// DB연동 정보를 불러오기(context.xml)
			DataSource ds = (DataSource) initCTX.lookup("java:comp/env/jdbc/deco");

			conn = ds.getConnection();

			System.out.println(" 드라이버 로드, 디비연결 성공! ");
			System.out.println(conn);

		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return conn;
	}
	// getConnection() - 디비연결 끝

	// 자원해제코드 - finally 구문에서 사용
	public void closeDB() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	/*
	 * 인서트 딜리트
	 * 
	 * 업데이트
	 * 
	 * 리스트
	 * 
	 */

	// delete
	public void deleteNotice(int idx) {

		try {
			conn = getConnection();
			sql = "delete from notice where idx=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, idx);
			pstmt.executeUpdate();

			System.out.println("삭제 완료");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

	}// delete

	// noticeList()
	public List noticeList() {
		List noticeList = new ArrayList();
		try {
			conn = getConnection();
			sql = "select idx, title, user_num, create_at, count from notice";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				noticeDTO ndto = new noticeDTO();
				ndto.setIdx(rs.getInt("idx"));
				ndto.setTitle(rs.getString("title"));
				ndto.setUser_num(rs.getInt("user_num"));
				ndto.setCreate_at(rs.getDate("create_at"));
				ndto.setCount(rs.getInt("count"));
			
				// 리스트 한 칸에 목록 하나 저장
				noticeList.add(ndto);

			} // while

			System.out.println("DAO : 상품 정보 저장 완료(일반사용자 상품 목록)");

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeDB();
		}

		return noticeList;
	}
	// noticeList()

}
