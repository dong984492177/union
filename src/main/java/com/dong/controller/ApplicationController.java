package com.dong.controller;

import com.dong.model.Application;

import com.dong.model.ApplicationAndRoles;
import com.dong.model.Roles;
import com.dong.model.Unionmember;
import com.dong.service.ApplicationService;
import com.dong.service.RolesService;
import com.dong.service.UnionmemberService;
import com.dong.util.AgreeCount;
import com.dong.util.ParseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * (Application)表控制层
 *
 * @author makejava
 * @since 2020-03-03 13:32:07
 */
@RestController
@RequestMapping("/application")
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
    @GetMapping("/selectOne")
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
                application.setAOperatingId(1);
                application.setADate(new Date());
                count=applicationService.updateIsInt(application);
            }else {
                application.setADate(new Date());
                count=applicationService.insertIsInt(application);
            }
        }
        return count;

    }

    /**
     * 连表分页
     * @param page
     * @param limit
     * @param request
     * @return
     */
    @RequestMapping("/getAll")
    public ParseData getAll(int page , int limit, HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        int uaid= (int) session.getAttribute("uald");
        //int position =(int) session.getAttribute("position");
        ApplicationAndRoles applicationAndRoles =new ApplicationAndRoles();
        applicationAndRoles.setAUaId(uaid);
        applicationAndRoles.setAApplicationStatus(1);
        int offset=(page-1)*limit;
        List<ApplicationAndRoles> applicationAndRolesList =applicationService.queryAllByLimitAndRoles(offset,limit,applicationAndRoles);
        int count =applicationService.getCountAll(applicationAndRoles);
        ParseData parseData= new ParseData();
        parseData.setData(applicationAndRolesList);
        parseData.setCount(count);
        return parseData;
    }

    /**
     * 申请全部拒绝
     * @param data 申请的数组的详情
     * @param request
     * @return 操作成功和失败数
     */
    @RequestMapping("/refuseAll")
    public AgreeCount refuseall(@RequestBody  Map<String ,Object>[] data ,HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        int aOperatingId = (int) session.getAttribute("id");
        AgreeCount agreeCount=applicationService.refuseall(data,aOperatingId);
        return agreeCount;
    }

    /**
     * 申请拒绝
     * @param data 单个申请
     * @param request
     * @return
     */
    @RequestMapping("/refuse")
    public int refuse(@RequestBody  Map<String ,Object> data,HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        int aid = (int) data.get("aid");
        int aOperatingId = (int) session.getAttribute("id");
        int count =applicationService.refuse(aid,aOperatingId);
        return count;
    }

    /**
     * 申请同意
     * @param data
     * @param request
     * @return
     */
    @RequestMapping("/agree")
    public AgreeCount agree(@RequestBody  Map<String ,Object> data,HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        //角色表id
        int aid = (int) data.get("aid");
        //操作申请人的id
        int aOperatingId = (int) session.getAttribute("id");
        Map<String ,Object> roles= (Map<String, Object>) data.get("roles");
        //角色id
        int rid= (int) roles.get("rid");
        //工会id
        int uald= (int) session.getAttribute("uald");
        AgreeCount agreeCount =applicationService.agree(aid,aOperatingId,rid,uald);
        return agreeCount;
    }

    @RequestMapping("/agreeAll")
    public AgreeCount agree(@RequestBody  Map<String ,Object>[] data ,HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        //操作申请人id
        int aOperatingId = (int) session.getAttribute("id");
        //工会id
        int uald= (int) session.getAttribute("uald");
        AgreeCount agreeCount=applicationService.agreeAll(data,aOperatingId,uald);
        return agreeCount;
    }

}