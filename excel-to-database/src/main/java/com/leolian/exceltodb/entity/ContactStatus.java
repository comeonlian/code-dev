package com.leolian.exceltodb.entity;

/**
 * @author Administrator
 * @description:
 * @date 2025/6/6 10:09
 */
public enum ContactStatus {
    // 1:正常待机,2:关机,3:无法接通,4:沉默号码,5:停机,6:空号
    NORMAL(1, "正常待机"),
    SHUTDOWN(2, "关机"),
    UNCONNNECT(3, "无法接通"),
    SILENT(4, "沉默号码"),
    STOP(5, "停机"),
    EMPTY(6, "空号");

    private int status;
    private String desc;

    ContactStatus(int status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public int getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }

    public static ContactStatus find(String typeCode) {
        for (ContactStatus value : ContactStatus.values()) {
            if (typeCode.equals(value.getDesc())) {
                return value;
            }
        }
        //根据自身的业务 查不到可以返回null，或者抛出异常。
        return null;
    }
}
