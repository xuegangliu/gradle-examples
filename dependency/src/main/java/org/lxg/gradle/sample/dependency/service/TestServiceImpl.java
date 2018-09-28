package org.lxg.gradle.sample.dependency.service;

import org.lxg.gradle.sample.helloworld.api.TestService;

/**
 * @author: xuegangliu
 * @date: 9/28/2018 5:32 PM
 * @DES:
 * @version: v1.0
 */
public class TestServiceImpl implements TestService {
    @Override
    public void print() {
        System.out.println("TestServiceImpl");
    }
}
