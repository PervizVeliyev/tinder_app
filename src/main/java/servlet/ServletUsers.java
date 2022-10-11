package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class ServletUsers extends HttpServlet {
    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        String fileName = "C:\\Users\\Perviz Veliyev\\IdeaProjects\\tinder_app\\src\\main\\resources\\templates\\like-page.ftl";
        try (ServletOutputStream os = rs.getOutputStream()) {
            Files.copy(Path.of(fileName), os);
        }
    }

    @Override
    protected void doPost(HttpServletRequest rq, HttpServletResponse rs) throws ServletException, IOException {
        try(PrintWriter writer = rs.getWriter()) {
            String button = rq.getParameter("button");
            rs.sendRedirect("/users");
        }
    }
}
