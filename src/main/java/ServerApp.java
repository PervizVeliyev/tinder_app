import filter.CookieFilter;
import heroku.HerokuEnv;
import jakarta.servlet.DispatcherType;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import servlet.*;

import java.util.EnumSet;

public class ServerApp {
    public static void main(String[] args) throws Exception {
        /* https://app-tinderr.herokuapp.com/login */

        Server server = new Server(HerokuEnv.port());
        ServletContextHandler handler = new ServletContextHandler();

        handler.addServlet(LoginServlet.class, "/login");
        handler.addServlet(RegisterServlet.class, "/register");

        EnumSet<DispatcherType> dt = EnumSet.of(DispatcherType.REQUEST);

        handler.addFilter(CookieFilter.class, "/users", dt);
        handler.addFilter(CookieFilter.class, "/liked", dt);
        handler.addFilter(CookieFilter.class, "/message/*", dt);
        handler.addFilter(CookieFilter.class, "/logout", dt);

        handler.addServlet(UserServlet.class, "/users");
        handler.addServlet(LikedServlet.class, "/liked");
        handler.addServlet(MessageServlet.class, "/message/*");
        handler.addServlet(LogoutServlet.class, "/logout");
        handler.addServlet(StaticServlet.class, "/*");
        handler.addServlet(StaticServlet.class, "/message/css/*");

        server.setHandler(handler);
        server.start();
        server.join();
    }
}
