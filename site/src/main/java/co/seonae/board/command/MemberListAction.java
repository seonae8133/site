package co.seonae.board.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.seonae.board.common.Action;
import co.seonae.board.common.Paging;
import co.seonae.board.dao.MemberDao;
import co.seonae.board.vo.MemberVO;

public class MemberListAction implements Action {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 회원 리스트 보기 구현
		MemberDao dao = new MemberDao();
		List<MemberVO> list = new ArrayList<MemberVO>();
		
		//페이지번호 파라미터
			String strp = request.getParameter("p");
		//페이지 번호가 없으면 1로 초기화
		int p = 1;
		if(strp != null && !strp.equals("")) {
			p = Integer.parseInt(strp);
		}
		//전체 레코드 건수 조회
		Paging paging = new Paging();
		paging.setPageUnit(5); //한페이지에 5건씩 보여줌 (한페이지에 보여줄 레코드수 ,default 는10)
		paging.setPageSize(3); //버튼으로 보여줄 페이지 번호 수
		paging.setPage(p); //현재 페이지 번호
		
		MemberDao cntdao = new MemberDao();
		MemberVO vo = new MemberVO();
		
		vo.setFirst(paging.getFirst());
		vo.setLast(paging.getLast());
		paging.setTotalRecord(cntdao.count(vo));
		//목록 결과와 페이징 객체를 저장해서 view 페이지로 넘김
		request.setAttribute("paging",paging);

		//해당 페이지의 리스트만 조회
		//list =  dao.selectAll();
		list =  dao.selectAll(vo);
		
	
		request.setAttribute("members", list); //members변수는 jsp 에서 사용함
		
		return "jsp/member/memberList.jsp";
	}

}
