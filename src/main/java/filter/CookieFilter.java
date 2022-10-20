package filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utility.Session;

import java.io.IOException;

public class CookieFilter implements HttpFilter {

    private boolean isCookiePresent(HttpServletRequest rq) {
        return Session.findUser(rq).isPresent();
    }

    @Override
    public void doHttpFilter(HttpServletRequest rq, HttpServletResponse rs, FilterChain filterChain) throws IOException, ServletException {
        if (isCookiePresent(rq)) filterChain.doFilter(rq, rs);
        else rs.sendRedirect("/login");
    }
}