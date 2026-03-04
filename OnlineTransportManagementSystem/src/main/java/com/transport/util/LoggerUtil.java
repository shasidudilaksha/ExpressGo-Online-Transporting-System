package com.transport.util;

import java.io.IOException;
import java.util.logging.*;

public class LoggerUtil {

    private static Logger logger = Logger.getLogger(LoggerUtil.class.getName());
    private static FileHandler fileHandler;

    static {
        try {
            // Create logs directory if it doesn't exist
            java.nio.file.Files.createDirectories(java.nio.file.Paths.get("logs"));

            // Setup log file handler
            fileHandler = new FileHandler("logs/transport_app.log", true); // true = append
            fileHandler.setFormatter(new SimpleFormatter());

            logger.addHandler(fileHandler);
            logger.setLevel(Level.ALL);

            // Remove default console handler
            Logger rootLogger = Logger.getLogger("");
            Handler[] handlers = rootLogger.getHandlers();
            if (handlers[0] instanceof ConsoleHandler) {
                rootLogger.removeHandler(handlers[0]);
            }

        } catch (IOException e) {
            System.err.println("Failed to initialize logger handler: " + e.getMessage());
        }
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void warning(String message) {
        logger.warning(message);
    }

    public static void error(String message, Throwable throwable) {
        logger.log(Level.SEVERE, message, throwable);
    }
}
