package servlet;

import entity.Message;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import service.MessageService;
import service.UserService;
import utility.FreeMarkerTemplate;
import utility.Session;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class MessageServlet extends HttpServlet {
    MessageService messageService = new MessageService();
    UserService userService = new UserService();

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs){
        int userId = Session.getUserId(rq);
        HashMap<String, Object> data = new HashMap<>();
        int receiverId = Integer.parseInt(rq.getPathInfo().substring(1));
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        List<Message> messages = messageService.getAllMessages(userId, receiverId);
        data.put("messages", messages);
        data.put("sender", userId);
        data.put("receiver", userService.getUser(receiverId));
        freeMarker.render("chat.ftl", data, rs);
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        int userId = Session.getUserId(rq);
        int receiverId = Integer.parseInt(rq.getPathInfo().substring(1));
        String message = rq.getParameter("message");
        if(!message.isEmpty()) messageService.insertMessage(new Message(userId, receiverId, message));
        rs.sendRedirect("/message/" + receiverId);
    }
}
