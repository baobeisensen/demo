package com.example.demo.Service.Impl;

import com.example.demo.Dao.SysDao;
import com.example.demo.Service.SystemService;
import com.example.demo.Utils.Result;
import com.example.demo.Utils.SysUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class SystemServiceImpl implements SystemService {
    @Resource
    private SysUtil sysUtil;
    @Resource
    private SysDao sysDao;


    @Override
    public Result getSystem() {
        //Map<String,Object> map = new HashMap<>();
        Result result = new Result();
        result.setResultMsg("success");
        result.setResultData(sysUtil.getSysInfo());
        return result;
    }

    @Override
    public Result getDatabaseInfo() {
        Result result = new Result();
        result.setResultMsg("success");
        result.setResultData(sysDao.getDatabaseInfo());
        return result;
    }

    @Override
    public Result getUplockPassword() {
        Result result = new Result();
        result.setResultMsg("success");
        result.setResultData(sysDao.getUplockPassword());
        return result;
    }
}
