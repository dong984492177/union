package com.dong.controller;

import com.dong.model.Roles;
import com.dong.service.RolesService;
import com.dong.util.PicUploadUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.util.List;

/**
 * (Roles)表控制层
 *
 * @author makejava
 * @since 2020-03-02 14:31:37
 */
@Controller
@RequestMapping("/roles")
public class RolesController {
   /**
     * 开启日志
     */
    public final static Logger logger= LoggerFactory.getLogger(RolesController .class);
    /**
     * 服务对象
     */
    @Resource
    private RolesService rolesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    //@GetMapping("/selectOne")
    public Roles selectOne(Integer id) {
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        return this.rolesService.queryById(id);
    }

    /**
     * 注册
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping("/signup")
    public int  signup(Roles roles){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        Roles roles2=rolesService.insert(roles);
        int count=roles2.getRId();
        return count;
    }

    /**
     * 查询所有符合条件的
     * @param roles
     * @return
     */
    @ResponseBody
    @RequestMapping("/rolesQueryAll")
    public int rolesQueryAll(Roles roles){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        List<Roles> rolesList=rolesService.queryAll(roles);
        int count =rolesList.size();
        return count;
    }

    /**
     * 登陆
     * @param roles
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/login")
    public int login(Roles roles, HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        List<Roles> rolesList=rolesService.queryAll(roles);
        HttpSession session=request.getSession();
        int count =rolesList.size();
        if (count>0){
            for (Roles roles1:rolesList) {
                session.setAttribute("id",roles1.getRId());
                session.setAttribute("img",roles1.getRImg());
                session.setAttribute("name",roles1.getRUsername());
            }
        }
        return count;
    }

    /**
     * 跳转且返回个人信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/getRolesById/{id}")
    public String getRolesById(@PathVariable int id, Model model){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        Roles roles=this.selectOne(id);
        model.addAttribute("roles",roles);
        return "personalInformation";
    }

    /**
     * 个人信息修改
     * @param roles
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateRoles")
    public int updateRoles(Roles roles, HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session=request.getSession();
        int count = rolesService.updateReturnInt(roles);
        if(count==1){
            session.setAttribute("name",roles.getRUsername());
        }
        return count;
    }

    /**
     * 头像删除修改
     * @param id 账号id
     * @param roles
     * @param picFile 文件
     * @param request
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateRolesPicFile")
    public int updateRolesPicFile(int id ,Roles roles,@RequestParam("file") MultipartFile picFile , HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session=request.getSession();
        String newPicName = PicUploadUtil.getNewPicName(picFile);
        roles.setRId(id);
        roles.setRImg(newPicName);
        int count = rolesService.updateReturnInt(roles);
        if(count==1){
            session.setAttribute("img",roles.getRImg());
        }
        return count;
    }

    /**
     * 密码修改
     * @param roles
     * @param password2
     * @return
     */
    @ResponseBody
    @RequestMapping("/updateRolesPassword")
    public int updateRolesPassword(Roles roles,String password2){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        List<Roles> rolesList=rolesService.queryAll(roles);
        int count=rolesList.size();
        if(count>0){
            roles.setRPassword(password2);
            count=rolesService.updateReturnInt(roles);
        }
        return count;
    }
}