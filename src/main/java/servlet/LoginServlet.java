package servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import service.LoginService;
import utility.FreeMarkerTemplate;
import utility.Session;

import java.io.IOException;
import java.util.HashMap;

public class LoginServlet extends HttpServlet {
    LoginService loginService = new LoginService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        freeMarker.render("login.ftl", new HashMap<>(), rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String mail = rq.getParameter("mail");
        String password = rq.getParameter("password");
        User user = loginService.getUser(mail, password);
        if (user != null) {
            int id = user.getId();
            loginService.setLastLogin(id);
            Cookie cookie = Session.setUser(id);
            UserServlet.counter = 0;
            rs.addCookie(cookie);
            rs.sendRedirect("/users");
        } else rs.sendRedirect("/login");
    }
}
