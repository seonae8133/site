package co.seonae.users.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import co.seonae.board.common.Action;
import co.seonae.users.dao.UsersDAO;
import co.seonae.users.dao.UsersDTO;



public class GetUsers implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response)
			 {
		//파라미터를 DTO에 담기
		String id = request.getParameter("id");
		UsersDTO dto = new UsersDTO(id); 
		//조회 처리
		UsersDAO dao = new UsersDAO();
		UsersDTO userDTO = dao.getUser(dto);//위에 아이디를 받아서 단건 조회를 하고
		//조회결과를 응답
		try {
			//여기서 json 구조로 결과 처리
			response.getWriter().print(new JSONObject(userDTO)); //단건인 경우에는 jsonobject씀
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

}
