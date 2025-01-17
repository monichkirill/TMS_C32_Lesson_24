package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import logger.Logger;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/count")
public class CounterServlet extends HttpServlet {
    @Override
    public void init() {
        Logger.log("CounterServlet init");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("CounterServlet doGet");

        try {
            HttpSession session = req.getSession();
            Integer count = (Integer) session.getAttribute("count");

            if (count == null) {
                count = 0;
            }

            count++;
            session.setAttribute("count", count);

            resp.setContentType("text/html");
            PrintWriter out = resp.getWriter();
            out.println("<html><body>");
            out.println("<h1>Visit counts: " + count + "</h1>");
            out.println("</body></html>");
            Logger.log("CounterServlet - counter is " + count);
        } catch (Exception e) {
            throw new RuntimeException();
        }

    }

    @Override
    public void destroy() {
        Logger.log("CounterServlet destroy");
    }
}
