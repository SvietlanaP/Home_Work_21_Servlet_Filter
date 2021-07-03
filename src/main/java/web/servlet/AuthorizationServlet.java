package web.servlet;

import entity.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AuthorizationServlet", urlPatterns = "/authorization")

public class AuthorizationServlet extends HttpServlet {

    private final UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        User findUsername = userService.findByUsername(username);
        if (findUsername.getPassword().equals(password)){
            req.getSession().setAttribute("user", findUsername);
            resp.getWriter().println("You are logged in.");
        }else{
            resp.getWriter().println("Error password.");
        }


    }
}
