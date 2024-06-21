package com.kjhe1234.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.kjhe1234.dto.MemberDto;

public class MemberDao {
	
	String driverName = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/spring_projectdb";
	String username = "root";
	String password = "12345";
	
	//회원가입, 회원탈퇴, 회원리스트조회, 회원검색, 회원정보수정
	
	//1. 회원가입
	public int joinMember(String mid, String mpw, String mname, String memail) { //회원가입 메소드
		
		String sql = "INSERT INTO members(mid, mpw, mname, memail) VALUES(?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int success = 0;
		
		try {			
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mid);
			pstmt.setString(2, mpw);
			pstmt.setString(3, mname);
			pstmt.setString(4, memail);			
			
			success = pstmt.executeUpdate();//sql문 실행->1이 반환되면 성공 아니면 실패
			
		} catch (Exception e) {			
			e.printStackTrace();
			
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return success;		
	}
	
	public int deleteMember(String mid) { //회원탈퇴 메소드
		
		String sql = "DELETE FROM members WHERE mid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int success = 0;
		
		try {			
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mid);				
			
			success = pstmt.executeUpdate();//sql문 실행->1이 반환되면 성공 아니면 실패
			
		} catch (Exception e) {			
			e.printStackTrace();
			
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return success;		
	}
	
	public MemberDto searchMember(String searchId) { //회원정보조회 메소드
		
		String sql = "SELECT * FROM members WHERE mid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		
		try {			
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, searchId);				
			
			rs = pstmt.executeQuery();//rs는 반드시 1개의 레코드 또는 0개의 레코드가 반환
			
			if(rs.next()) {//참이면 레코드 1개가 반환되었다는 뜻
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mdate = rs.getString("mdate");
				
				memberDto = new MemberDto(mid, mpw, mname, memail, mdate);
			} 
			
		} catch (Exception e) {			
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return memberDto;		
	}
	
	public ArrayList<MemberDto> listMember() { //모든 회원리스트 조회 메소드
		
		String sql = "SELECT * FROM members";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto memberDto = null;
		ArrayList<MemberDto> memberDtos = new ArrayList<MemberDto>();
		
		try {			
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();//rs에 여러개의 레코드가 들어있음
			
			while(rs.next()) {
				String mid = rs.getString("mid");
				String mpw = rs.getString("mpw");
				String mname = rs.getString("mname");
				String memail = rs.getString("memail");
				String mdate = rs.getString("mdate");
				
				memberDto = new MemberDto(mid, mpw, mname, memail, mdate);
				memberDtos.add(memberDto);
			} 
			
		} catch (Exception e) {			
			e.printStackTrace();
			
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return memberDtos;		
	}

	public int modifyMember(String mname, String memail, String mid) { 
		
		String sql = "UPDATE members SET mname=?, memail=? WHERE mid=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		int success = 0;
		
		try {			
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, mname);
			pstmt.setString(2, memail);	
			pstmt.setString(3, mid);
			
			success = pstmt.executeUpdate();//sql문 실행->1이 반환되면 성공 아니면 실패
			
		} catch (Exception e) {			
			e.printStackTrace();
			
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return success;		
	}
	
	
}
