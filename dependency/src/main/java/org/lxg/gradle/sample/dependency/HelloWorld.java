package org.lxg.gradle.sample.dependency;

import org.apache.log4j.Logger;

/**
 * @author: xuegangliu
 * @date: 9/28/2018 3:09 PM
 * @DES:
 * @version: v1.0
 */
public class HelloWorld {
    private static final Logger LOGGER = Logger.getLogger(HelloWorld.class);

    public static void main(String[] args) {
        MessageService messageService = new MessageService();

        String message = messageService.getMessage();
        LOGGER.info("Received message: " + message);
    }
}
