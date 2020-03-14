package com.dong.controller;

import com.dong.model.Roles;
import com.dong.model.Unionmember;
import com.dong.service.RolesService;
import com.dong.service.UnionmemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ToController {

    public final static Logger logger= LoggerFactory.getLogger(ToController.class);

    /**
     * 服务对象
     */
    @Resource
    private RolesService rolesService;
    @Resource
    private UnionmemberService unionmemberService;
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

    /**
     * 进入工会管理页面 返回工会id 和该成员在工会的职位
     * @param request
     * @param id 成员个人信息id
     * @return
     */
    @RequestMapping(value = "/torguild/{id}")
    public String torguild(HttpServletRequest request , @PathVariable int id){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        //创建session
        HttpSession session=request.getSession();
        Roles roles= rolesService.queryById(id);
        session.setAttribute("uald", roles.getRUaId());
        //通过id查工会表中的该成员的职位
        Unionmember unionmember=new Unionmember();
        unionmember.setUnRId(id);
        List<Unionmember> unionmembers=unionmemberService.queryAll(unionmember);
        if (unionmembers.size()>0) {
            session.setAttribute("position", unionmembers.get(0).getUnPId());
        }else{
            session.setAttribute("position", null);
        }
        return "guild";
    }

    /**
     * 进入密码修改页面
     * @return
     */
    @RequestMapping("/topasswordUpdate")
    public String topasswordUpdate(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "passwordUpdate";
    }

    /**
     * 进入创建工会页面
     * @return
     */
    @RequestMapping("/tonewGuild")
    public String tonewGuild(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "newGuild";
    }

    /**
     * 进入我的工会页面
     * @return
     */
    @RequestMapping("/tomyGuild")
    public String tomyGuild(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "myGuild";
    }

    /**
     * 进入工会列表页面
     * @return
     */
    @RequestMapping("/toguildAll")
    public String toguildAll(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "guildAll";
    }

    /**
     * 进入申请页面
     * @return
     */
    @RequestMapping("/toapplication")
    public String toapplication(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "application";
    }

    /**
     * 进入管理工会页面
     * @return
     */
    @RequestMapping("/tomanageApplication")
    public String tomanageApplication(){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return "manageApplication";
    }
}
