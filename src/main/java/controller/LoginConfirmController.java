//package controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import java.sql.Timestamp;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import com.google.gson.Gson;
//
//import commons.util;
//import dao.MemberDAO;
//import dto.MemberDTO;
//
///**
// * Servlet implementation class LoginController
// */
//@WebServlet("*.login")
//public class LoginConfirmController extends HttpServlet {
//
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("UTF-8");
//        String cmd = request.getRequestURI();
//        MemberDAO dao = MemberDAO.getInstance();
//        Gson g = new Gson();
//        System.out.println(cmd);
//        
//        try {
//            if(cmd.equals("/register.members")) {
//                String id = request.getParameter("id");
//                String pw = util.getSHA512(request.getParameter("pw"));
//                String name = request.getParameter("name");
//                String phone = request.getParameter("phone");
//                String email = request.getParameter("email");
//                String zipcode = request.getParameter("zipcode");
//                String address1 = request.getParameter("address1");
//                String address2 = request.getParameter("address2");
//                String favoriteGame = request.getParameter("favoriteGame"); // 좋아하는 게임 필드 추가
//                Timestamp currentTime = new Timestamp(System.currentTimeMillis());
//                System.out.println(favoriteGame);
//                int result = dao.addMember(new MemberDTO(id, pw, name, phone, email, zipcode, address1, address2, currentTime, favoriteGame));
//
//                response.sendRedirect("/index.jsp");
//            }
//            
//            if(cmd.equals("/idCheck.members")) {
//                String id = request.getParameter("id");
//                System.out.println(id);
//                boolean result = dao.findId(id);
//                System.out.println(id);
//                System.out.println(result);
//                
//                String result1 = g.toJson(result);
//    			PrintWriter pw = response.getWriter();
//    			
//    			pw.append(result1);
//
//            }
//            
//            if(cmd.equals("/login.members")) {
//                String id = request.getParameter("id");
//                String pw = util.getSHA512(request.getParameter("pw"));
//                MemberDTO dto = dao.selectAll(id);
//                String name = dto.getName();
//                
//                boolean result = dao.loginId(id, pw);
//                if(result) {
//                    HttpSession session = request.getSession();
//                    session.setAttribute("loginID", id);
//                    session.setAttribute("loginName", name);
//                   
//                }
//                response.sendRedirect("/index.jsp");
//            }
//
//            if(cmd.equals("/logout.members")) {
//                HttpSession session = request.getSession();
//                session.invalidate();
//                response.sendRedirect("/index.jsp");
//            }
//            
//            if(cmd.equals("/memberout.members")) {
//                HttpSession session = request.getSession();
//                String id = (String) session.getAttribute("loginID");                
//                dao.deleteMembers(id);
//                session.invalidate();
//                response.sendRedirect("/index.jsp");
//            }
//            
//            if(cmd.equals("/myPage.members")) {
//                String id = (String) request.getSession().getAttribute("loginID");
//                MemberDTO dto = dao.selectAll(id);
//                request.setAttribute("dto", dto);
//                request.getRequestDispatcher("/members/myPage.jsp").forward(request, response);
//            }
//            
//            if(cmd.equals("/update.members")) {
//                String id = (String) request.getSession().getAttribute("loginID");
//                String name = request.getParameter("name");
//                String phone = request.getParameter("phone");
//                String email = request.getParameter("email");
//                String zipcode = request.getParameter("zipcode");
//                String address1 = request.getParameter("address1");
//                String address2 = request.getParameter("address2");
//                String favoriteGame = request.getParameter("favoriteGame");
//                
//                // 빈 값 처리
//                if(phone == null || phone.trim().isEmpty()) phone = "";
//                if(email == null || email.trim().isEmpty()) email = "";
//                if(zipcode == null || zipcode.trim().isEmpty()) zipcode = "";
//                if(address1 == null || address1.trim().isEmpty()) address1 = "";
//                if(address2 == null || address2.trim().isEmpty()) address2 = "";
//
//                System.out.println("업데이트할 데이터: " + id + ", " + name + ", " + phone + ", " + email + ", " + zipcode + ", " + address1 + ", " + address2);
//                
//                int updateResult = dao.updateMembers(id, name, phone, email, zipcode, address1, address2, favoriteGame);
//                System.out.println("업데이트 결과: " + updateResult);
//                
//                response.sendRedirect("/myPage.members");
//            }
//        } catch(Exception e) {
//            e.printStackTrace();
//            response.sendRedirect("error.jsp");
//        }
//        
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//		doGet(request, response);
//	}
//
//}
