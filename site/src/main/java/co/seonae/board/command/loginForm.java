package co.seonae.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seonae.board.common.Action;

public class loginForm implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		
		return "jsp/main/loginForm.jsp";
	}

}
