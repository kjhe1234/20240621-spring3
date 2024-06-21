package com.kjhe1234.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kjhe1234.command.MCommand;
import com.kjhe1234.command.MDeleteCommand;
import com.kjhe1234.command.MJoinCommand;
import com.kjhe1234.command.MListCommand;
import com.kjhe1234.command.MModifyCommand;
import com.kjhe1234.command.MSearchCommand;

@Controller
public class JdbcController {
	
	MCommand command = null;
	
	@RequestMapping(value = "/test")
	public void test() {
		
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/spring_projectdb";
		String username = "root";
		String password = "12345";
		
		Connection conn = null;
		
		try {
			Class.forName(driverName);
			conn = DriverManager.getConnection(url, username, password);
			System.out.println(conn);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) {
					conn.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new MJoinCommand();
		int success = command.execute(model);
		
//		String mid = request.getParameter("mid");
//		String mpw = request.getParameter("mpw");
//		String mname = request.getParameter("mname");
//		String memail = request.getParameter("memail");
		
//		MemberDao memberDao = new MemberDao();
		
//		int success = memberDao.joinMember(mid, mpw, mname, memail);
		//success 값이 1이면 sql문 실행 성공 아니면 실패
		
		if(success == 1 ) { //회원 가입 성공			
			model.addAttribute("mid", request.getParameter("mid"));
			model.addAttribute("mname", request.getParameter("mname"));
			
			return "joinOk";
		} else {
			model.addAttribute("error", "회원가입이 실패하였습니다. 다시 시도해주세요.");
			
			return "join";
		}
		
		
	}
	
	@RequestMapping(value = "/delete")
	public String delete() {
		return "delete";
	}
	
	@RequestMapping(value = "/deleteOk")
	public String deleteOk(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new MDeleteCommand();
		int success = command.execute(model);
		
		if(success == 1) {//회원 탈퇴 성공
			
			model.addAttribute("message", "회원 탈퇴 성공! 안녕히가세요!");
			
		} else { //회원 탈퇴 실패
			
			model.addAttribute("message", "회원 탈퇴 실패! 다시확인해 주세요!");
			
		}
		
		return "deleteOk";
	}
	
	@RequestMapping(value = "/search")
	public String search() {
		return "search";
	}
	
	@RequestMapping(value = "/searchOk")
	public String searchOk(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new MSearchCommand();
		command.execute(model);
		
		return "searchOk";
	}
	
	@RequestMapping(value = "/list")
	public String list(HttpServletRequest request, Model model) {
		
		command = new MListCommand();
		command.execute(model);
		
		return "list";
	}
	
	@RequestMapping(value = "/modifyOk")
	public String modifyOk(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new MModifyCommand();
		int success = command.execute(model);		
		
		if(success == 1) {  // 정보 수정 성공
			
			command = new MSearchCommand();
			command.execute(model);
			
			return "modifyOk";
		} else {  // 정보수정 실패 -> 다시 회원 아이디 조회화면으로 이동
			return "search";
		}
		
		
	}
	
	@RequestMapping(value = "/")
	public String index() {
		
		return "index";
	}
	
	
}
