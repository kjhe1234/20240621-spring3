package com.kjhe1234.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.kjhe1234.dao.MemberDao;
import com.kjhe1234.dto.MemberDto;

public class MListCommand implements MCommand {

	@Override
	public int execute(Model model) {
		// TODO Auto-generated method stub
		
		MemberDao memberDao = new MemberDao();
		ArrayList<MemberDto> mDtos = memberDao.listMember();
		
		model.addAttribute("mDtos", mDtos);
		
		return 0;
	}

}
