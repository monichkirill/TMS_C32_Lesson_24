package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logger.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logs")
public class LoggerServlet extends HttpServlet {

    @Override
    public void init() {
        Logger.log("LoggerServlet init");
    }

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Logger.log("LoggerServlet doGet is run");
        resp.setContentType("text/html");
        final String LOG_PATH = "D:\\TMS_Homework\\lesson_24\\src\\main\\resources\\log.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(LOG_PATH))) {
            PrintWriter respWriter = new PrintWriter(resp.getWriter());
            String line;
            respWriter.println("<html>");
            respWriter.println("<head>");
            respWriter.println("</head>");
            respWriter.println("<body>");
            while ((line = reader.readLine()) != null) {
                respWriter.println("<p>" + line + "</p>");
            }

            respWriter.println("</body>");
            respWriter.println("</html>");
        } catch (IOException e) {
            resp.getWriter().println("Error during logs writing: " + e.getMessage());
        }
    }

    @Override
    public void destroy() {
        Logger.log("LoggerServlet destroy");
    }
}
