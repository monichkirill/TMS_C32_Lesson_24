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

@WebServlet("/reset")
public class ResetServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.log("ResetServlet init");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Logger.log("ResetServlet doGet is running. Counter is reset");
        HttpSession session = request.getSession();
        response.setContentType("text/html");
        session.invalidate();

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Counter is reset</h1>");
        out.println("</body></html>");
    }

    @Override
    public void destroy() {
        Logger.log("ResetServlet destroy");
    }
}
