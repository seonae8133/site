package co.seonae.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import co.seonae.board.common.Action;
import co.seonae.board.dao.MemberDao;
import co.seonae.board.vo.MemberVO;

public class AjaxMemberList implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		response.setContentType("text/html; charset=UTF-8");
		MemberDao dao = new MemberDao() ;
		MemberVO vo = new MemberVO();
		vo.setFirst(1);
		vo.setLast(5);
		List<MemberVO> list = dao.selectAll(vo);
		JSONArray arr = new JSONArray(list);
		try {
			response.getWriter().print(arr);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
