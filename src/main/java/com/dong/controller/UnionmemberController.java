package com.dong.controller;

import com.dong.model.Unionmember;
import com.dong.service.UnionmemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Unionmember)表控制层
 *
 * @author makejava
 * @since 2020-03-03 13:32:14
 */
@RestController
@RequestMapping("unionmember")
public class UnionmemberController {
   /**
     * 开启日志
     */
    public final static Logger logger= LoggerFactory.getLogger(UnionmemberController .class);
    /**
     * 服务对象
     */
    @Resource
    private UnionmemberService unionmemberService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Unionmember selectOne(Integer id) {
        return this.unionmemberService.queryById(id);
    }

}