package controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import commons.util;
import dao.MemberDAO;
import dto.MemberDTO;

@WebServlet("*.register")
public class RegisterController extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String cmd = request.getRequestURI();
		MemberDAO dao = MemberDAO.getInstance();
		Gson g = new Gson();
		System.out.println(cmd);

		try {
			if (cmd.equals("/register.register")) {
				String id = request.getParameter("id");
				String pw = util.getSHA512(request.getParameter("pw"));
				String name = request.getParameter("name");
				String phone = request.getParameter("phone");
				String email = request.getParameter("email");
				String gender = request.getParameter("gender");
				Timestamp currentTime = new Timestamp(System.currentTimeMillis());
				int result = dao.registerMember(
						new MemberDTO(id, pw, name, phone, email, gender, currentTime, null, 0));

				response.sendRedirect("/index.jsp");
			}

		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("error.jsp");
		}

	}
}