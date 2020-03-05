package com.dong.controller;

import com.dong.model.Unionattributes;
import com.dong.service.UnionattributesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Unionattributes)表控制层
 *
 * @author makejava
 * @since 2020-03-03 13:32:10
 */
@RestController
@RequestMapping("unionattributes")
public class UnionattributesController {
   /**
     * 开启日志
     */
    public final static Logger logger= LoggerFactory.getLogger(UnionattributesController .class);
    /**
     * 服务对象
     */
    @Resource
    private UnionattributesService unionattributesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Unionattributes selectOne(Integer id) {
        return this.unionattributesService.queryById(id);
    }

}