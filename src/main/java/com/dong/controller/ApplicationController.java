package com.dong.controller;

import com.dong.model.Application;
import com.dong.service.ApplicationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Application)表控制层
 *
 * @author makejava
 * @since 2020-03-03 13:32:07
 */
@RestController
@RequestMapping("application")
public class ApplicationController {
   /**
     * 开启日志
     */
    public final static Logger logger= LoggerFactory.getLogger(ApplicationController .class);
    /**
     * 服务对象
     */
    @Resource
    private ApplicationService applicationService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Application selectOne(Integer id) {
        return this.applicationService.queryById(id);
    }

}