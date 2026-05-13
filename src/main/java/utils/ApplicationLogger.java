package utils;

import java.io.IOException;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

/**
 * Central logging utility for the Bank Account Management System.
 * Writes INFO and above to bank-app.log; WARNING and above to the console.
 */
public class ApplicationLogger {

  private static final Logger LOGGER = Logger.getLogger("BankApp");
  private static boolean initialized = false;

  private ApplicationLogger() {}

  /**
   * Returns the configured application logger, initializing it on first call.
   *
   * @return The configured Logger instance.
   */
  public static synchronized Logger get() {
    if (!initialized) {
      try {
        LOGGER.setUseParentHandlers(false);

        ConsoleHandler consoleHandler = new ConsoleHandler();
        consoleHandler.setLevel(Level.WARNING);
        LOGGER.addHandler(consoleHandler);

        FileHandler fileHandler = new FileHandler("bank-app.log", true);
        fileHandler.setFormatter(new SimpleFormatter());
        fileHandler.setLevel(Level.ALL);
        LOGGER.addHandler(fileHandler);

        LOGGER.setLevel(Level.ALL);
        initialized = true;
      } catch (IOException e) {
        LOGGER.warning("Could not initialize file handler: " + e.getMessage());
      }
    }
    return LOGGER;
  }

  /** Logs an informational message. */
  public static void info(String message) {
    get().info(message);
  }

  /** Logs a warning message. */
  public static void warn(String message) {
    get().warning(message);
  }

  /** Logs a severe error message. */
  public static void error(String message) {
    get().severe(message);
  }
}
