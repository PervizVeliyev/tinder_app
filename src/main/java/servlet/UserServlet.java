package servlet;

import entity.Like;
import entity.User;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import service.LikeService;
import service.UserService;
import utility.FreeMarkerTemplate;
import utility.Session;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserServlet extends HttpServlet {
    UserService userService = new UserService();
    LikeService likeService = new LikeService();
    public static int counter = 0;

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) {
        int userId = Session.getUserId(rq);
        List<User> users = userService.getAllUsers().stream()
                .filter(u -> u.getId() != userId).toList();
        if (counter == users.size()) rs.sendRedirect("/liked");

        User user = users.get(counter);
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        Map<String, Object> mapper = new HashMap<>();
        mapper.put("image", user.getPhotoLink());
        mapper.put("name", user.getName());
        mapper.put("surname", user.getSurname());
        counter++;

        freeMarker.render("like-page.ftl", mapper, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String button = rq.getParameter("button");
        int userId = Session.getUserId(rq);
        Like like = new Like(userId, userService.getAllUsers().get(counter - 1).getId());
        if (button.equalsIgnoreCase("like") && !likeService.getAllLikes().contains(like)) {
            likeService.insertLike(like);
        } else if (button.equalsIgnoreCase("dislike") && likeService.getAllLikes().contains(like)) {
            likeService.removeLike(like);
        }
        rs.sendRedirect("/users");
    }
}
