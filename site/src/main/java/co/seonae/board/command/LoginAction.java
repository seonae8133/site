package co.seonae.board.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import co.seonae.board.common.Action;
import co.seonae.board.dao.MemberDao;
import co.seonae.board.vo.MemberVO;

public class LoginAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		//로그인 인증과정을 처리한다.
		MemberDao dao = new MemberDao();
		MemberVO vo = new MemberVO();
		
		HttpSession session = request.getSession(false);
		
		//String msg;
		
		vo.setId(request.getParameter("id"));
		vo.setPassword(request.getParameter("password"));
		
		vo = dao.select(vo); //MemberDao 를 실행시킨다. vo에 값을 싣고 다시 vo에 담음
//		if(vo.getName()  == null) { //존재하지 않을때 메세지를 실어보냄
//			msg = "존재하지 않는 ID 입니다.";
//			request.setAttribute("msg", msg); // 리퀘스트 객체에 "msg"라는 key 로 msg value를 담아보냄 / 앞:변수명 , 뒤 :값
//		} 
		
		session.setAttribute("id", vo.getId());//session에id담아놓는것
		session.setAttribute("author", vo.getAuthor());//session에author담아놓는것
		session.setAttribute("name", vo.getName());//session에name담아놓는것
		
		request.setAttribute("vo", vo); //존재하든 안하는 멤버를 실어보냄 // request 객체에 String : "vo"변수이름으로 , select(vo) 에서 반환한 값을 vo에 담아 값으로 지정함
		return "jsp/main/loginResult.jsp"; // 위에서 담은 값을 loginResult.jsp 로 넘김/ FrontController 에 dispatcher를 통해서 jsp 로 화면 넘어감
	}

}
