package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logger.Logger;

import java.io.IOException;

@WebServlet("/main")
public class MainServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.log("MainServlet init");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("MainServlet doGet is running");
        req.getRequestDispatcher("index.html").forward(req, resp);
    }

    @Override
    public void destroy() {
        Logger.log("MainServlet destroy");
    }
}
