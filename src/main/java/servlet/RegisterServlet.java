package servlet;

import entity.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import service.UserService;
import utility.FreeMarkerTemplate;

import java.io.IOException;
import java.util.HashMap;

public class RegisterServlet extends HttpServlet {

    UserService userService = new UserService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        freeMarker.render("register.ftl", new HashMap<>(), rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String name = rq.getParameter("name");
        String surname = rq.getParameter("surname");
        String photoLink = rq.getParameter("photo");
        if (photoLink.isEmpty()) photoLink = null;
        String profession = rq.getParameter("profession");
        String mail = rq.getParameter("mail");
        String password = rq.getParameter("password");
        userService.insertUser(new User(1, name, surname, photoLink, mail, password, null, profession));
        rs.sendRedirect("/login");
    }
}
