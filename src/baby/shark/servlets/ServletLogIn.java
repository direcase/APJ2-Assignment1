package baby.shark.servlets;

import baby.shark.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ServletLogIn")
public class ServletLogIn extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email=request.getParameter("email");
        String password=request.getParameter("password");
        User user=new User(email,password);
        HttpSession session = request.getSession(true);
        session.setAttribute("user", user);
        Cookie cookie = new Cookie("username",user.email);
        cookie.setMaxAge(90);
        response.addCookie(cookie);
        System.out.println(email+" "+ password);
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if(session!=null){
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath() + "/");
    }
}
