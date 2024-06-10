package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.BoardDAO;
import dto.BoardDTO;


@WebServlet("*.board")
public class BoardController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cmd = request.getRequestURI();
		System.out.println(cmd);
		BoardDAO manager = BoardDAO.getInstance();

		
		try {
			if(cmd.equals("/list.board")){
				List<BoardDTO> list = manager.getList();
				
				
			} else if(cmd.equals("/write.board")) {
				HttpSession session = request.getSession();
				String writer = (String)request.getSession().getAttribute("id");

				String title = request.getParameter("title");
				String content = request.getParameter("content");
				int result = manager.insert(new BoardDTO(0,writer,title,content,null));
				
				response.sendRedirect("/list.board");
				
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
