package org.lxg.gradle.sample.web.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * @author: xuegangliu
 * @date: 9/30/2018 2:49 PM
 * @DES:
 * @version: v1.0
 */
public class JobA implements Job {
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("JobA-----------A");
    }
}
