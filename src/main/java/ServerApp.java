import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import servlet.ServletLiked;
import servlet.ServletUsers;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        Server server = new Server(8080);
        ServletContextHandler handler = new ServletContextHandler();
        handler.addServlet(ServletUsers.class, "/users");
        handler.addServlet(ServletLiked.class, "/liked");
        server.setHandler(handler);
        server.start();
        server.join();
    }
}
