package com.dong.controller;

import com.dong.model.Roles;
import com.dong.service.RolesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ToController {

    public final static Logger logger= LoggerFactory.getLogger(ToController.class);

    /**
     * 服务对象
     */
    @Resource
    private RolesService rolesService;
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


    @RequestMapping("/torguild/{id}")
    public String torguild(HttpServletRequest request , @PathVariable int id){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        //创建session
        HttpSession session=request.getSession();
        Roles roles= rolesService.queryById(id);
        session.setAttribute("guild", roles.getRUaId());
        return "guild";
    }
    @RequestMapping("/topasswordUpdate")
    public String topasswordUpdate(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "passwordUpdate";
    }
}
