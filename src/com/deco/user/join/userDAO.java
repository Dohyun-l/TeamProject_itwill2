package com.deco.user.join;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.mindrot.jbcrypt.BCrypt;

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
		}finally{
			closeDB();
		}
		
		return flag;
	}
	//getAdminByNum
	
	//HashPW
	private String HashPW(String pw){
		return BCrypt.hashpw(pw, BCrypt.gensalt(5));
	}
	//HashPW
	
	//setJoinPreState
	private void setJoinPreState(userDTO uDTO) throws SQLException{
		pstmt.setInt(1, uDTO.getUser_num());
		pstmt.setString(2, uDTO.getEmail());
		pstmt.setString(3, HashPW(uDTO.getPw()));
		pstmt.setString(4, uDTO.getName());
		pstmt.setString(5, uDTO.getNickname());
		pstmt.setString(6, uDTO.getAddr());
		pstmt.setString(7, uDTO.getPhone());
		pstmt.setString(8, uDTO.getMajor());
		pstmt.setString(9, uDTO.getInter());
		
		//private user는 기본적으로 계정 공개로 0으로 설정(참고: 비공개는 1로 함)
		pstmt.setInt(10, 0);
		
		//회원가입한 유저는 -1로 이메일 인증을 안한 유저이다.
		pstmt.setInt(11, -1);
	}
	//setJoinPreState
	
	//insertUser
	public int insertUser(userDTO uDTO){
		int flag = -5; 
		
		try {
			conn = getConnection();
			
			//user_num 얻기
			sql = "select max(user_num) from user";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				uDTO.setUser_num(rs.getInt(1) + 1);
			}
			
			//유저 DB에 넣기
			//관리자면 1, 일반 유저 0, 이메일 인증전 유저 -1
			sql = "insert into user (user_num, email, pw, name, nickname, addr, "
					+ "phone, major, inter, create_at, last_login, private_user, admin_auth) "
					+ "values(?,?,?,?,?,?,?,?,?,now(),now(),?,?)";

			pstmt = conn.prepareStatement(sql);
			setJoinPreState(uDTO);
			pstmt.executeUpdate();
			
			flag = 1;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return flag;
	}
	//insertUser
	
	//searchUserEmail
	public boolean searchUserEmail(String nowEmail){
		boolean flag = false;
		
		try {
			conn = getConnection();
			sql = "select user_num from user where email=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nowEmail);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return flag;
	}
	//serachUserEmail
	
	//searchUserNickname
	public boolean searchUserNickname(String nowNickname){
		boolean flag = false;
		
		try {
			conn = getConnection();
			sql = "select user_num from user where nickname=?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, nowNickname);
			
			rs = pstmt.executeQuery();
			if(rs.next()){
				flag = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			closeDB();
		}
		
		return flag;
	}
	//searchUserNickname
}
