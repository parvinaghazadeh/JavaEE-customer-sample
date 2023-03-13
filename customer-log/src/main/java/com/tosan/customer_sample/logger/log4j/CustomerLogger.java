package com.tosan.customer_sample.logger.log4j;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class CustomerLogger {

    public static Logger logger(Object object) {
        Logger logger = LogManager.getLogger(object.getClass().getSimpleName());
        return logger;
    }

}
