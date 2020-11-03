package co.seonae.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seonae.board.common.Action;

public class logoutAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 로그아웃 과정을 처리한다.
		HttpSession session = request.getSession();
		String name = (String)session.getAttribute("name");
		session.invalidate();
		request.setAttribute("name", name);
		return "jsp/main/logout.jsp";
	}

}
