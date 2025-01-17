package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logger.Logger;

import java.io.IOException;

@WebServlet("/about")
public class AboutMeServlet extends HttpServlet {
    @Override
    public void init() {
        Logger.log("AboutMeServlet init");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("AboutMeServlet doGet is running");
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        req.getRequestDispatcher("about.html").forward(req, resp);
    }

    @Override
    public void destroy() {
        Logger.log("AboutMeServlet destroy");
    }
}
