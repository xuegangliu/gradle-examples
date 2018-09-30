package org.lxg.gradle.sample.web.job.manager;

import org.junit.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @author: xuegangliu
 * @date: 9/30/2018 2:51 PM
 * @DES:
 * @version: v1.0
 */
public class QuartzTest {

    @Test
    public void quartz() {
        try {
            SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
            Scheduler sche = gSchedulerFactory.getScheduler();

            String job_name = "任务调度";
            System.out.println("【系统启动】开始(每1秒输出一次)...");
            QuartzManager.addJob(sche, job_name, Class.forName( "org.lxg.gradle.sample.web.job.JobA" ), "0/1 * * * * ?");
            Thread.sleep(3000);

            System.out.println("【修改时间】开始(每2秒输出一次)...");
            QuartzManager.modifyJobTime(sche, job_name, "0/2 * * * * ?");
            Thread.sleep(4000);

            System.out.println("【移除定时】开始...");
            QuartzManager.removeJob(sche, job_name);
            System.out.println("【移除定时】成功");

            System.out.println("【再次添加定时任务】开始(每3秒输出一次)...");
            QuartzManager.addJob(sche, job_name, Class.forName( "org.lxg.gradle.sample.web.job.JobB" ), "0/3 * * * * ?");
            Thread.sleep(30000);

            System.out.println("【移除定时】开始...");
            QuartzManager.removeJob(sche, job_name);
            System.out.println("【移除定时】成功");

            Thread.sleep(30000);
            sche.shutdown();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
