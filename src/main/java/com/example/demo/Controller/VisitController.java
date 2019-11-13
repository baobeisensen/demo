package com.example.demo.Controller;

import com.example.demo.Entity.Visit;
import com.example.demo.Service.VisitService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 用户访问记录(Visit)表控制层
 *
 * @author 庄茂森
 * @since 2019-10-10 20:01:31
 */
@RestController
@RequestMapping("/visit")
public class VisitController {
    /**
     * 服务对象
     */
    @Resource
    private VisitService visitService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @RequestMapping("/getVisitCount")
    public Visit getVisitCount() {
        return this.visitService.getVisitCount();
    }

}