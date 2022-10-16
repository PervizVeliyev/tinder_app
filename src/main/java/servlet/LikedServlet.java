package servlet;

import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import service.LikeService;
import utility.FreeMarkerTemplate;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LikedServlet extends HttpServlet {
    LikeService likeService = new LikeService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        int loggedUser = 1;
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        Map<String, Object> mapper = new HashMap<>();
        List<User> users = likeService.getAllLikedUsers(loggedUser);
        mapper.put("users", users);
        freeMarker.render("people-list.ftl", mapper, rs);
    }
}
