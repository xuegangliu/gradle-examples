package org.lxg.gradle.sample.web.bean;

import org.lxg.gradle.sample.common.bean.BaseEntity;

/**
 * @author: xuegangliu
 * @date: 9/30/2018 3:09 PM
 * @DES:
 * @version: v1.0
 */
public class JobEntity extends BaseEntity {

    private String jobName;
    private String jobGroupName;
    private String jobClass;

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobGroupName() {
        return jobGroupName;
    }

    public void setJobGroupName(String jobGroupName) {
        this.jobGroupName = jobGroupName;
    }

    public String getJobClass() {
        return jobClass;
    }

    public void setJobClass(String jobClass) {
        this.jobClass = jobClass;
    }
}
