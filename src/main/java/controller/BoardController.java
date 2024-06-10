package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;
import dto.BoardDTO;

@WebServlet("*.board")
public class BoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		BoardDAO manager = BoardDAO.getInstance();
		
		try {
			//메인페이지 각 페이지에 표시될 게시글 로드
			if(cmd.equals("/list.board")){
				String cpage = request.getParameter("cpage");
				if (cpage == null) {
					cpage = "1";
				}
				int cpageInt = Integer.parseInt(cpage);
				
				int recordCountPerPage = 10;
				int naviCountPerPage = 10;
				
				int startNum = cpageInt * recordCountPerPage - (recordCountPerPage-1);
				int endNum = cpageInt * recordCountPerPage;
				
				List<BoardDTO> list = manager.getList(startNum, endNum);
				
				request.setAttribute("cpage", cpageInt);
				request.setAttribute("record_count_per_page", recordCountPerPage);
				request.setAttribute("navi_count_per_page", naviCountPerPage);
				request.setAttribute("record_total_count", manager.getList().size());
				request.setAttribute("list", list);
				
				request.getRequestDispatcher("/board/mainBoard.jsp").forward(request, response);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
