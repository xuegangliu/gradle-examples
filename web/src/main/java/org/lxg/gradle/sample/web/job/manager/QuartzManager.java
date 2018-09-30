package org.lxg.gradle.sample.web.job.manager;

import org.quartz.CronTrigger;
import org.quartz.JobDetail;
import org.quartz.Scheduler;

/**
 * @author: xuegangliu
 * @date: 9/30/2018 2:49 PM
 * @DES:
 * @version: v1.0
 */
public class QuartzManager {
    private static String JOB_GROUP_NAME = "EXTJWEB_JOBGROUP_NAME";
    private static String TRIGGER_GROUP_NAME = "EXTJWEB_TRIGGERGROUP_NAME";

    /**
     * @Description: ���һ����ʱ����ʹ��Ĭ�ϵ�������������������������������
     *
     * @param sched
     *            ������
     *
     * @param jobName
     *            ������
     * @param cls
     *            ����
     * @param time
     *            ʱ�����ã��ο�quartz˵���ĵ�
     *
     * @Title: QuartzManager.java
     */
    public static void addJob(Scheduler sched, String jobName, @SuppressWarnings("rawtypes") Class cls, String time) {
        try {
            JobDetail jobDetail = new JobDetail(jobName, JOB_GROUP_NAME, cls);// �������������飬����ִ����
            // ������
            CronTrigger trigger = new CronTrigger(jobName, TRIGGER_GROUP_NAME);// ��������,��������
            trigger.setCronExpression(time);// ������ʱ���趨
            sched.scheduleJob(jobDetail, trigger);
            // ����
            if (!sched.isShutdown()) {
                sched.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: ���һ����ʱ����
     *
     * @param sched
     *            ������
     *
     * @param jobName
     *            ������
     * @param jobGroupName
     *            ��������
     * @param triggerName
     *            ��������
     * @param triggerGroupName
     *            ����������
     * @param jobClass
     *            ����
     * @param time
     *            ʱ�����ã��ο�quartz˵���ĵ�
     *
     * @Title: QuartzManager.java
     */
    public static void addJob(Scheduler sched, String jobName, String jobGroupName, String triggerName, String triggerGroupName, @SuppressWarnings("rawtypes") Class jobClass, String time) {
        try {
            JobDetail jobDetail = new JobDetail(jobName, jobGroupName, jobClass);// �������������飬����ִ����
            // ������
            CronTrigger trigger = new CronTrigger(triggerName, triggerGroupName);// ��������,��������
            trigger.setCronExpression(time);// ������ʱ���趨
            sched.scheduleJob(jobDetail, trigger);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: �޸�һ������Ĵ���ʱ��(ʹ��Ĭ�ϵ�������������������������������)
     *
     * @param sched
     *            ������
     * @param jobName
     * @param time
     *
     * @Title: QuartzManager.java
     */
    @SuppressWarnings("rawtypes")
    public static void modifyJobTime(Scheduler sched, String jobName, String time) {
        try {
            CronTrigger trigger = (CronTrigger) sched.getTrigger(jobName, TRIGGER_GROUP_NAME);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                JobDetail jobDetail = sched.getJobDetail(jobName, JOB_GROUP_NAME);
                Class objJobClass = jobDetail.getJobClass();
                removeJob(sched, jobName);
                addJob(sched, jobName, objJobClass, time);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: �޸�һ������Ĵ���ʱ��
     *
     * @param sched
     *            ������ *
     * @param sched
     *            ������
     * @param triggerName
     * @param triggerGroupName
     * @param time
     *
     * @Title: QuartzManager.java
     */
    public static void modifyJobTime(Scheduler sched, String triggerName, String triggerGroupName, String time) {
        try {
            CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerName, triggerGroupName);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(time)) {
                CronTrigger ct = (CronTrigger) trigger;
                // �޸�ʱ��
                ct.setCronExpression(time);
                // ����������
                sched.resumeTrigger(triggerName, triggerGroupName);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: �Ƴ�һ������(ʹ��Ĭ�ϵ�������������������������������)
     *
     * @param sched
     *            ������
     * @param jobName
     *
     * @Title: QuartzManager.java
     */
    public static void removeJob(Scheduler sched, String jobName) {
        try {
            sched.pauseTrigger(jobName, TRIGGER_GROUP_NAME);// ֹͣ������
            sched.unscheduleJob(jobName, TRIGGER_GROUP_NAME);// �Ƴ�������
            sched.deleteJob(jobName, JOB_GROUP_NAME);// ɾ������
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description: �Ƴ�һ������
     *
     * @param sched
     *            ������
     * @param jobName
     * @param jobGroupName
     * @param triggerName
     * @param triggerGroupName
     *
     * @Title: QuartzManager.java
     */
    public static void removeJob(Scheduler sched, String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
        try {
            sched.pauseTrigger(triggerName, triggerGroupName);// ֹͣ������
            sched.unscheduleJob(triggerName, triggerGroupName);// �Ƴ�������
            sched.deleteJob(jobName, jobGroupName);// ɾ������
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:�������ж�ʱ����
     *
     * @param sched
     *            ������
     *
     * @Title: QuartzManager.java
     */
    public static void startJobs(Scheduler sched) {
        try {
            sched.start();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * @Description:�ر����ж�ʱ����
     *
     *
     * @param sched
     *            ������
     *
     *
     * @Title: QuartzManager.java
     */
    public static void shutdownJobs(Scheduler sched) {
        try {
            if (!sched.isShutdown()) {
                sched.shutdown();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
