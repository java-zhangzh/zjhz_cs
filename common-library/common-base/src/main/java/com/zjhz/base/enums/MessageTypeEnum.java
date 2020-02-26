package com.zjhz.base.enums;

/**
 * Created by VPEEN on 2019/5/7.
 */
public enum MessageTypeEnum {

    teacher_Leave_Application("0101","员工请假申请"),
    teacher_Leave_Receipt("0102","员工请假申请回执"),

    child_Leave_Application("0201","宝宝请假申请"),
    child_Leave_Receipt("0202","宝宝请假申请回执"),

    live_Reservation("0301","直播预约提醒"),

    pending_Payment("0401","待缴费通知"),
    Payment_Receipt("0402","缴费完成回执"),
    urge_Pay("0403","催缴信息"),
    urge_Pay_Receipt("0404","催缴费完成回执"),
    unpaid_Info("0405","未缴信息"),

    task_Approval_Receipt("0501","任务审批结果回执"),

    admission_application_Receipt("0601","入园申请回执"),

    stop_application_Receipt("0701","站点申请回执"),

    letter_application("0801","信件通知"),

    urgent_notice("0901","慧凡催办任务通知");

    private String code;
    private String name;

    MessageTypeEnum(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
