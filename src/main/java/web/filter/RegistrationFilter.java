package web.filter;

import storage.UserStorage;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(servletNames = "RegistrationServlet")
public class RegistrationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        UserStorage userStorage = new UserStorage();

        if(userStorage.existByUsername((String) req.getSession().getAttribute("username"))){
                res.getWriter().println("User already exists.");
        } else {
                chain.doFilter(req, res);
        }

    }
}
