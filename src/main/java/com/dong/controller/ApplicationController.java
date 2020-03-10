package com.dong.controller;

import com.dong.model.Application;

import com.dong.model.Unionmember;
import com.dong.service.ApplicationService;
import com.dong.service.RolesService;
import com.dong.service.UnionmemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

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

    @Resource
    private UnionmemberService unionmemberService;


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

    /**
     *
     * 提交申请 有申请修改申请表 无申请添加
     * @param uaId
     * @param request
     * @return
     */
    @RequestMapping("/add")
    public int add(int  uaId, HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session=request.getSession();
        int rId= (int) session.getAttribute("id");
        int count =0;
        //判断是否有工会
        Unionmember unionmember=new Unionmember();
        unionmember.setUnRId(rId);
        List<Unionmember> unionmemberList=unionmemberService.queryAll(unionmember);
        if(unionmemberList.size()<1){
            //判断是否向该工会提交过申请
            Application application= new Application();
            application.setAUaId(uaId);
            application.setARId(rId);
            List<Application> applicationList=applicationService.queryAll(application);
            //如果有就改申请时间 如果没有就添加
            if (applicationList.size()>0){
                application=applicationList.get(0);
                application.setADate(new Date());
                count=applicationService.updateIsInt(application);
            }else {
                application.setADate(new Date());
                count=applicationService.insertIsInt(application);
            }
        }
        return count;

    }

}