package com.tosan.customer_sample.logger;

import java.io.IOException;
import java.util.logging.*;

public class CustomerLogger {

    private String className;

    private Logger logger;

    public CustomerLogger(String className) {
        this.className = className;

    }

    public CustomerLogger() {

    }

    public Logger logger(String objectName) {
        logger = Logger.getLogger(objectName);

        logger.setLevel(Level.FINE);
//        logger.addHandler(new ConsoleHandler());
//        logger.addHandler(new LogHandler());
        try {
//            Handler fileHandler = new FileHandler("logs\\logger.log", 2000, 5);
            Handler fileHandler = new FileHandler("D:\\develop_help\\customer_sample\\logs\\logger.log");
            fileHandler.setFormatter(new LogFormatter());
            fileHandler.setFilter(new LogFilter());
            logger.addHandler(fileHandler);
//            logger.log(Level.INFO,"Config data");
        } catch (SecurityException | IOException e) {
            e.printStackTrace();
        }
        return logger;
    }

}
