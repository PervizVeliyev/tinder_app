package servlet;

import entity.User;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import service.LikeService;
import utility.FreeMarkerTemplate;
import utility.Session;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LikedServlet extends HttpServlet {
    LikeService likeService = new LikeService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs){
        int userId = Session.getUserId(rq);
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        Map<String, Object> mapper = new HashMap<>();
        List<User> users = likeService.getAllLikedUsers(userId);
        mapper.put("users", users);
        freeMarker.render("people-list.ftl", mapper, rs);
    }
}
