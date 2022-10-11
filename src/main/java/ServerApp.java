import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import servlet.LikedServlet;
import servlet.MessageServlet;
import servlet.UserServlet;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(UserServlet.class, "/users");
        handler.addServlet(LikedServlet.class, "/liked");
        handler.addServlet(MessageServlet.class, "/message/*");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
