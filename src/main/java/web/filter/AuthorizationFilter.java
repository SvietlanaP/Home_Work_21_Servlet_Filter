package web.filter;

import service.UserService;
import storage.UserStorage;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter (servletNames = "AuthorizationServlet")
public class AuthorizationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        UserService userService = new UserService();
        String username = req.getParameter("username");

        if(!userService.findByUsername((String) req.getSession().getAttribute("username")).getUsername().equals(username)){
            res.getWriter().println("User don't exist.");
        } else {
            chain.doFilter(req, res);
        }
    }
}
