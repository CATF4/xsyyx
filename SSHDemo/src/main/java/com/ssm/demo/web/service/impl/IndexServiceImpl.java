package com.ssm.demo.web.service.impl;

import com.ssm.demo.core.dto.ProcessDto;
import com.ssm.demo.core.dto.ResultDto;
import com.ssm.demo.core.util.MyLeProcess;
import com.ssm.demo.web.service.IndexService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Describe：简单的描述一下该文件
 * Created by 欧阳猛 on 2017/7/1.
 */
@Service("indexService")
public class IndexServiceImpl implements IndexService {

    public ResultDto leProcess(String exp, String denv) {

        MyLeProcess myLeProcess = new MyLeProcess(exp,denv);
        System.out.println("抽象机动态演练");
        myLeProcess.cal();

        ResultDto resultDto = new ResultDto();
        resultDto.setControlIntial(myLeProcess.getControlIntial());
        resultDto.setStackIntial(myLeProcess.getStackIntial());
        resultDto.setDenvIntial(myLeProcess.getDenvIntial());

        List<String> regList = myLeProcess.getRegList();
        List<String> controlList = myLeProcess.getControlList();
        List<String> stackList = myLeProcess.getStackList();
        String denvStr = myLeProcess.getDenvStr();

        List<ProcessDto> processDtos = new ArrayList<>();
        int len = controlList.size();
        for (int i= 0;i<len;i++){
            ProcessDto processDto = new ProcessDto();
            processDto.setRegStr(regList.get(i));
            processDto.setControlStr(controlList.get(i));
            processDto.setStackStr(stackList.get(i));
            processDto.setDenvStr(denvStr);
            processDtos.add(processDto);
        }
       resultDto.setProcessDtoList(processDtos);
        return resultDto;
    }
}
