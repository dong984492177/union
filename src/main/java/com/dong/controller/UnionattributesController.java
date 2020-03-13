package com.dong.controller;

import com.dong.model.Roles;
import com.dong.model.Unionattributes;
import com.dong.model.UnionattributesAndRoles;
import com.dong.model.Unionmember;
import com.dong.service.RolesService;
import com.dong.service.UnionattributesService;
import com.dong.service.UnionmemberService;
import com.dong.util.ParseData;
import com.dong.util.ResultMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import javax.net.ssl.SSLServerSocket;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * (Unionattributes)表控制层
 *
 * @author makejava
 * @since 2020-03-03 13:32:10
 */
@RestController
@RequestMapping("/unionattributes")
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
    @Resource
    private UnionmemberService unionmemberService;
    @Resource
    private RolesService rolesService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("/selectOne")
    public Unionattributes selectOne(Integer id) {
        return this.unionattributesService.queryById(id);
    }

    /**
     * 查名字重复
     * @param unionattributes
     * @return
     */
    @RequestMapping("/queryuaName")
    public int queryuaName(Unionattributes unionattributes){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        List<Unionattributes> unionattributesList=unionattributesService.queryAll(unionattributes);
        int count =unionattributesList.size();
        return count;
    }

    /**
     * 创建工会
     * 检测工会名是否存在
     * 检测该角色是否加入工会
     * 检测该角色是否满足创建工会金币需求
     * 添加工会表及公会成员表 更改角色表
     * @param unionattributes
     * @param request
     * @return
     */
    @RequestMapping("/addUnionattributes")
    public ResultMsg addUnionattributes(Unionattributes unionattributes, HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        Unionattributes unionattributes1=new Unionattributes();
        ResultMsg resultMsg=new ResultMsg();
        int count=0;
        String msg="";
        int  id  = unionattributes.getUaCreateId();
        unionattributes1.setUaName(unionattributes.getUaName());
        List<Unionattributes> unionattributesList=unionattributesService.queryAll(unionattributes1);
        int size =unionattributesList.size();
        if (size>0){
            msg="创建失败,工会名字已经存在,请重新尝试";
        }else {
            Unionmember unionmember = new Unionmember();
            unionmember.setUnRId(id);
            List<Unionmember> unionmemberList=unionmemberService.queryAll(unionmember);
            size=unionmemberList.size();
            if(size>0) {
                msg = "创建失败,你已经加入工会了,如果你想创建工会请先退出工会";
            }else {
                Roles  roles = rolesService.queryById(id);
                long goid=roles.getRGold();
                if (goid<500000){
                    msg="创建失败,您的金币不足500,000,如需创建工会请继续努力";

                }else {
                    count =unionattributesService.insertReturnInt(unionattributes);
                    msg="创建成功,即将跳转至工会页面";
                    //创建session
                    HttpSession session=request.getSession();
                    Unionmember unionmember2=new Unionmember();
                    unionmember.setUnRId(id);
                    List<Unionmember> unionmembers=unionmemberService.queryAll(unionmember2);
                    //添加工会职位
                    session.setAttribute("position", unionmembers.get(0).getUnPId());
                    //添加工会id
                    session.setAttribute("uald",unionmembers.get(0).getUmUaId());

                }
            }
        }
        resultMsg.setCount(count);
        resultMsg.setMsg(msg);
        return resultMsg;
    }

    /**
     * 分页
     * @param page 当前页数
     * @param limit 分多少页
     * @return
     */
    @RequestMapping("/getAll")
    public ParseData getAll(int page ,int limit){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        int offset=(page-1)*limit;
        List<UnionattributesAndRoles> unionattributesAndRolesList =unionattributesService.queryAllByLimitAndRoles(offset,limit);
        int count =unionattributesService.getCount();
        ParseData parseData= new ParseData();
        parseData.setData(unionattributesAndRolesList);
        parseData.setCount(count);
        return parseData;
    }

    /**
     * 获得工会头部信息
     * @param request
     * @return
     */
    @RequestMapping("/getById")
    public UnionattributesAndRoles getById(HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        int uaid= (int) session.getAttribute("uald");
        UnionattributesAndRoles unionattributesAndRoles =unionattributesService.getById(uaid);
        return unionattributesAndRoles;
    }

}