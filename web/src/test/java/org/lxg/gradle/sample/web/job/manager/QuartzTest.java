package org.lxg.gradle.sample.web.job.manager;

import org.junit.Test;
import org.lxg.gradle.sample.web.bean.JobEntity;
import org.lxg.gradle.sample.web.bean.TriggerEntity;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xuegangliu
 * @date: 9/30/2018 2:51 PM
 * @DES:
 * @version: v1.0
 */
public class QuartzTest {

    @Test
    public void baseTest() throws SchedulerException, ClassNotFoundException, InterruptedException {
        SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
        Scheduler sche1 = gSchedulerFactory.getScheduler();

        String job_name = "任务调度";
        System.out.println("【系统启动】开始(每1秒输出一次)...");
        QuartzManager.addJob(sche1, job_name, Class.forName( "org.lxg.gradle.sample.web.job.JobA" ), "0/1 * * * * ?");
        Thread.sleep(3000);

        System.out.println("【修改时间】开始(每2秒输出一次)...");
        QuartzManager.modifyJobTime(sche1, job_name, "0/2 * * * * ?");
        Thread.sleep(4000);

        System.out.println("【移除定时】开始...");
        QuartzManager.removeJob(sche1, job_name);
        System.out.println("【移除定时】成功");

        System.out.println("【再次添加定时任务】开始(每3秒输出一次)...");
        QuartzManager.addJob(sche1, job_name, Class.forName( "org.lxg.gradle.sample.web.job.JobB" ), "0/3 * * * * ?");
        Thread.sleep(30000);

        System.out.println("【移除定时】开始...");
        QuartzManager.removeJob(sche1, job_name);
        System.out.println("【移除定时】成功");

        Thread.sleep(30000);
    }

//    @Test
//    public void quartzBeanTest() {
//        try {
//            SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
//            Scheduler sche1 = gSchedulerFactory.getScheduler();
//            Scheduler sche2 = gSchedulerFactory.getScheduler();
//            List<JobEntity> jobList = new ArrayList<JobEntity>();
//            List<TriggerEntity> triggerList = new ArrayList<TriggerEntity>();
//            JobEntity jobA = new JobEntity();
//            jobA.setJobName( "A1" );
//            jobA.setJobGroupName( "group1" );
//            jobA.setJobClass( "org.lxg.gradle.sample.web.job.JobA" );
//
//            JobEntity jobB = new JobEntity();
//            jobB.setJobName( "B1" );
//            jobB.setJobGroupName( "group2" );
//            jobB.setJobClass( "org.lxg.gradle.sample.web.job.JobB" );
////            jobList.add( jobA );
//            jobList.add( jobB );
//
//            TriggerEntity triggerEntity1 =  new TriggerEntity();
//            triggerEntity1.setTriggerName( "t1" );
//            triggerEntity1.setTriggerGroupName( "g1" );
//            triggerEntity1.setTriggerCronValue( "0/1 * * * * ?" );
//
//            TriggerEntity triggerEntity2 =  new TriggerEntity();
//            triggerEntity2.setTriggerName( "t2" );
//            triggerEntity2.setTriggerGroupName( "g2" );
//            triggerEntity2.setTriggerCronValue( "0/2 * * * * ?" );
//
//            TriggerEntity triggerEntity3 =  new TriggerEntity();
//            triggerEntity3.setTriggerName( "t3" );
//            triggerEntity3.setTriggerGroupName( "g3" );
//            triggerEntity3.setTriggerCronValue( "0/5 * * * * ?" );
////            triggerList.add( triggerEntity1 );
////            triggerList.add( triggerEntity2 );
//            triggerList.add( triggerEntity3 );
//
//            QuartzManager.addJob( sche1, jobA.getJobName()+System.currentTimeMillis(), jobA.getJobGroupName(), triggerEntity1.getTriggerName(),
//                    triggerEntity1.getTriggerGroupName()+System.currentTimeMillis(), Class.forName( jobA.getJobClass() ), triggerEntity1.getTriggerCronValue() );
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
}
