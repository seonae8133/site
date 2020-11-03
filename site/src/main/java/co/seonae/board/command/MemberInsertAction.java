package co.seonae.board.command;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seonae.board.common.Action;
import co.seonae.board.dao.MemberDao;
import co.seonae.board.vo.MemberVO;

public class MemberInsertAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원정보를 db에 입력하는 기능
		MemberDao dao = new MemberDao();
		MemberVO vo = new MemberVO();
		
		vo.setId(request.getParameter("id")); // form 객체에 있는 name 이 id 인것의 값
		vo.setName(request.getParameter("name"));
		vo.setPassword(request.getParameter("password"));
		vo.setAddress(request.getParameter("address"));
		vo.setTel(request.getParameter("tel"));
		vo.setEnterdate(Date.valueOf(request.getParameter("enterdate"))); //Date.valueOf : form에서 넘어오는것은 다 문자열임. 문자로 들어온걸 date 타입으로 바꿔줌
		
		int n = dao.insert(vo);
		String page;
		if(n != 0) {
			page = "jsp/member/insertSuccess.jsp";
		} else {
			page = "jsp/member/insertFail.jsp";
		}
		return page;
	}

}
