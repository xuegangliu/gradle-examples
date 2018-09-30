package org.lxg.gradle.sample.web.bean;

import org.lxg.gradle.sample.common.bean.BaseEntity;

/**
 * @author: xuegangliu
 * @date: 9/30/2018 3:18 PM
 * @DES:
 * @version: v1.0
 */
public class TriggerEntity extends BaseEntity {

    private String triggerName;
    private String triggerGroupName;
    private String triggerCronValue;

    public String getTriggerName() {
        return triggerName;
    }

    public void setTriggerName(String triggerName) {
        this.triggerName = triggerName;
    }

    public String getTriggerGroupName() {
        return triggerGroupName;
    }

    public void setTriggerGroupName(String triggerGroupName) {
        this.triggerGroupName = triggerGroupName;
    }

    public String getTriggerCronValue() {
        return triggerCronValue;
    }

    public void setTriggerCronValue(String triggerCronValue) {
        this.triggerCronValue = triggerCronValue;
    }
}
