package com.dong.controller;

import com.dong.model.Position;
import com.dong.service.PositionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Position)表控制层
 *
 * @author makejava
 * @since 2020-03-02 14:31:37
 */
@RestController
@RequestMapping("position")
public class PositionController {
   /**
     * 开启日志
     */
    public final static Logger logger= LoggerFactory.getLogger(PositionController .class);
    /**
     * 服务对象
     */
    @Resource
    private PositionService positionService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Position selectOne(Integer id) {
        return this.positionService.queryById(id);
    }

}