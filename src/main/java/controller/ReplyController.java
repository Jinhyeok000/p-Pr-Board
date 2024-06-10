package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dao.ReplyDAO;
import dto.ReplyDTO;


@WebServlet("*.reply")
public class ReplyController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		Gson g=new Gson();
		
		request.setCharacterEncoding("UTF-8");
		String cmd=request.getRequestURI();
		System.out.println(cmd);
		ReplyDAO dao=ReplyDAO.getInstance();
		
		try {
			if(cmd.equals("/insert.reply")) {
				//받은 정보
				String writer=request.getParameter("writer");
				String content=request.getParameter("content");
				int parent_seq=Integer.parseInt(request.getParameter("parent_seq"));
				//보낼 정보
				PrintWriter pw=response.getWriter();
				ReplyDTO cdto=dao.insert(new ReplyDTO(0,writer,content,null,parent_seq));
				pw.append(g.toJson(cdto));
				
			}else if(cmd.equals("/select.reply")) {
				//받은 정보
				int parent_seq=Integer.parseInt(request.getParameter("seq"));
				String loginID=(String)request.getSession().getAttribute("loginID"); 
				
				//보낼 정보
				PrintWriter pw=response.getWriter();
				ArrayList<ReplyDTO> replylist=dao.selectAll();
				JsonObject obj=new JsonObject(); //직렬화
				obj.addProperty("loginID", loginID);
				obj.add("replylist", g.toJsonTree(replylist)); //이게 뭘까?
				String result=g.toJson(obj);
				pw.append(result);
				
			}else if(cmd.equals("/delete.reply")) {
				//받은 정보
				int replyseq=Integer.parseInt(request.getParameter("replyseq"));
				int boardseq=Integer.parseInt(request.getParameter("boardseq"));
				
				//보낼 정보
				int result=dao.deleteBySeq(replyseq);
				request.getRequestDispatcher("/detail.board?seq="+boardseq).forward(request, response);
				
			}else if(cmd.equals("/update.reply")) {
				//받은 정보
				int replyseq=Integer.parseInt(request.getParameter("replyseq"));
				int boardseq=Integer.parseInt(request.getParameter("boardseq"));
				String replycontent=request.getParameter("replycontents");
				
				//보낼 정보
				int result=dao.updateBySeq(replyseq, replycontent);
				request.getRequestDispatcher("/detail.board?seq="+boardseq).forward(request, response);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
