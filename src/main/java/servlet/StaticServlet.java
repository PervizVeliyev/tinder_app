package servlet;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import utility.FreeMarkerTemplate;

import java.io.IOException;
import java.util.HashMap;

public class StaticServlet extends HttpServlet {

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws IOException {
        String requestPath = !rq.getPathInfo().startsWith("/css") ? "/css".concat(rq.getPathInfo()) : rq.getPathInfo();
        FreeMarkerTemplate freeMarker = new FreeMarkerTemplate();
        freeMarker.render(requestPath, new HashMap<>(), rs);
    }
}
