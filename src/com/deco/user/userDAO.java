package com.deco.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class userDAO {
	
	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;
	private String sql = "";
	
	
	private Connection getConnection(){
		try {
			//Context 객체를 생성 (프로젝트 정보를 가지고있는객체)
			Context initCTX = new InitialContext();
			// DB연동 정보를 불러오기(context.xml)
			DataSource ds =
			(DataSource) initCTX.lookup("java:comp/env/jdbc/deco");
			
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
	public void closeDB(){
		try {
			if(rs != null){ rs.close(); }
			if(pstmt != null){ pstmt.close();}
			if(conn != null){ conn.close();}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//getUserNickNameByNum
	public String getUserNickNameByNum(int userNum){
		String UserName = null;
		
		try {
			conn = getConnection();
			sql = "select nickname from user where user_num=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				UserName = rs.getString(1);
				System.out.println(rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return UserName;
	}
	//getUserNickNameByNum

	//getAdminByNum
	public int getAdminByNum(int userNum){
		
		//0 -> 일반  |  1 -> 관리자  | -1 -> 에러
		int flag = -1;

		try {
			conn = getConnection();
			sql = "select admin_auth from user where user_num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, userNum);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				flag = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
	}
	//getAdminByNum
	
}
