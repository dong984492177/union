package com.dong.controller;

import com.dong.model.Roles;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToController {
    public final static Logger logger= LoggerFactory.getLogger(ToController.class);

    /**
     * 到主页
     * @return
     */
    @RequestMapping("/index")
    public String toIndex(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "index";
    }

    /**
     * 到登录注册页面
     * @return
     */
    @RequestMapping("/tologin")
    public String tologin(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "login";
    }

    @RequestMapping("/torguild")
    public String torguild(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "guild";
    }

}
