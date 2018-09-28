package org.lxg.gradle.sample.dependency;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author: xuegangliu
 * @date: 9/28/2018 3:15 PM
 * @DES:
 * @version: v1.0
 */
public class MessageServiceTest {
    private MessageService messageService;

    @Before
    public void setUp() {
        messageService = new MessageService();
    }

    @Test
    public void getMessage_ShouldReturnMessage() {
        assertEquals("Hello World!", messageService.getMessage());
    }
}
