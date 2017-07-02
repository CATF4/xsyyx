package com.ssm.demo.core.dto;

import java.util.List;

/**
 * Describe：封装结果
 * Created by 欧阳猛 on 2017/7/1.
 */
public class ResultDto {
    //初始状态
    private String controlIntial = "[";
    private String stackIntial = "[";
    private String denvIntial = "[";
    //运行过程
   private List<ProcessDto> processDtoList;

    public String getControlIntial() {
        return controlIntial;
    }

    public void setControlIntial(String controlIntial) {
        this.controlIntial = controlIntial;
    }

    public String getStackIntial() {
        return stackIntial;
    }

    public void setStackIntial(String stackIntial) {
        this.stackIntial = stackIntial;
    }

    public String getDenvIntial() {
        return denvIntial;
    }

    public void setDenvIntial(String denvIntial) {
        this.denvIntial = denvIntial;
    }

    public List<ProcessDto> getProcessDtoList() {
        return processDtoList;
    }

    public void setProcessDtoList(List<ProcessDto> processDtoList) {
        this.processDtoList = processDtoList;
    }
}
