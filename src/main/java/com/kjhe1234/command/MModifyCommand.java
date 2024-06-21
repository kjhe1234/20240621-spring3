package com.kjhe1234.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.kjhe1234.dao.MemberDao;

public class MModifyCommand implements MCommand {

	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String mid = request.getParameter("mid");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		
		
		MemberDao memberDao = new MemberDao();
		int success = memberDao.modifyMember(mname, memail, mid);
		
		return success;
	}

}
