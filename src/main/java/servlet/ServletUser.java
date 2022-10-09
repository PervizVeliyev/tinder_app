package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

public class ServletUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fileName = Objects.requireNonNull(getClass().getClassLoader().getResource("like-page.html")).getFile();
        List<String> lines = Files.readAllLines(Path.of(fileName.substring(1)));
        try(PrintWriter writer = rs.getWriter()){
            for(String line : lines) writer.println(line);
        }
    }
}
