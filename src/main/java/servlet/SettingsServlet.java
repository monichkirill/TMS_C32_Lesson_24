package servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logger.Logger;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/settings")
public class SettingsServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.log("SettingsServlet init");
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("SettingsServlet doGet is running");

        ServletContext context = getServletContext();
        String appName = context.getInitParameter("appName");
        String appVersion = context.getInitParameter("appVersion");
        String developerName = context.getInitParameter("developerName");
        String supportEmail = context.getInitParameter("supportEmail");

        resp.setContentType("text/html");
        PrintWriter respWriter = resp.getWriter();
        respWriter.println("<html><body>");
        respWriter.println("<h1>App Settings</h1>");
        respWriter.println("<p>App name is: " + appName + "</p>");
        respWriter.println("<p>Version: " + appVersion + "</p>");
        respWriter.println("<p>Dev: " + developerName + "</p>");
        respWriter.println("<p>Support email: " + supportEmail + "</p>");
        respWriter.println("</body></html>");
    }

    @Override
    public void destroy() {
        Logger.log("SettingsServlet destroy");
    }
}
