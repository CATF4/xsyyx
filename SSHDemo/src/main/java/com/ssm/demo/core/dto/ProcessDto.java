package com.ssm.demo.core.dto;

import java.util.List;

/**
 * Describe：封装结果
 * Created by 欧阳猛 on 2017/7/1.
 */
public class ProcessDto {

    //运行过程
    private String regStr;
    private String controlStr;
    private String stackStr;
    private String denvStr;

    public String getRegStr() {
        return regStr;
    }

    public void setRegStr(String regStr) {
        this.regStr = regStr;
    }

    public String getControlStr() {
        return controlStr;
    }

    public void setControlStr(String controlStr) {
        this.controlStr = controlStr;
    }

    public String getStackStr() {
        return stackStr;
    }

    public void setStackStr(String stackStr) {
        this.stackStr = stackStr;
    }

    public String getDenvStr() {
        return denvStr;
    }

    public void setDenvStr(String denvStr) {
        this.denvStr = denvStr;
    }
}
