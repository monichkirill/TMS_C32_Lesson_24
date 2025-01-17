package logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
    private static final String LOG_PATH = "D:\\TMS_Homework\\lesson_24\\src\\main\\resources\\log.txt";

    public static void log(String message) {
        try {
            String dateTime = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").format(new Date());
            String infoMessage = "[INFO]\t" + dateTime + "\t" + message + "\n";
            Files.write(Paths.get(LOG_PATH), infoMessage.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
