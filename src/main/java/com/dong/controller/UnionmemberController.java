package com.dong.controller;

import com.dong.model.Unionmember;
import com.dong.model.UnionmemberAndRoles;
import com.dong.service.UnionmemberService;
import com.dong.util.AgreeCount;
import com.dong.util.ParseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Unionmember)表控制层
 *
 * @author makejava
 * @since 2020-03-03 13:32:14
 */
@RestController
@RequestMapping("/unionmember")
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

    /**
     * 分页连表查询
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
        int offset=(page-1)*limit;
        List<UnionmemberAndRoles> unionmemberAndRolesList=unionmemberService.queryAllByLimitAndRoles(offset,limit,uaid);
        int count =unionmemberService.getCount(uaid);
        ParseData parseData= new ParseData();
        parseData.setData(unionmemberAndRolesList);
        parseData.setCount(count);
        return parseData;
    }

    /**
     * 获得所有人的信息键值对
     *
     * @param request
     * @return 只有key为 value和name 的 其值分别为总贡献度 和角色名字
     */
    @RequestMapping("/getEveryone")
    public List<Map<String ,Object>> getEveryone(HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        int uaid= (int) session.getAttribute("uald");
        List<Map<String ,Object>> data=unionmemberService.getAllAndRoles(uaid);
        List<Map<String ,Object>> datas=new ArrayList<>();
        for (Map<String ,Object> map: data) {
            Map<String ,Object> maps= new HashMap<>();
            maps.put("value",map.get("un_total_contribution"));
            maps.put("name",map.get("r_username"));
            datas.add(maps);
        }
        return datas;
    }

    /**
     * 会长转让
     * @param unPId
     * @param request
     * @return
     */
    @RequestMapping("/transfer")
    public  int transfer(int unPId ,int unRId,HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        Unionmember unionmember =new Unionmember();
        int uaid= (int) session.getAttribute("uald");
        int rid = (int) session.getAttribute("id");
        unionmember.setUnRId(unRId);
        unionmember.setUmUaId(uaid);
        unionmember.setUnPId(unPId);
        int count =unionmemberService.transfer(unionmember,rid);
        if (count>0){
            session.setAttribute("position", 4);
        }
        return count;
    }

    /**
     * 任命
     * @param unionmember
     * @param request
     * @return
     */
    @RequestMapping("/appointment")
    public  int appointment(Unionmember unionmember,HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        int uaid= (int) session.getAttribute("uald");
        unionmember.setUmUaId(uaid);
        int count=unionmemberService.appointment(unionmember);
        return count;
    }

    /**
     * 移除单个
     * @param data
     * @return
     */
    @RequestMapping("/delete")
    public AgreeCount delete( @RequestBody Map<String ,Object> data ){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        AgreeCount agreeCount = unionmemberService.deleteUnion(data);
        return agreeCount;

    }

    /**
     * 移除所有选中
     * @param data
     * @return
     */
    @RequestMapping("/deleteAll")
    public AgreeCount deleteAll(@RequestBody Map<String ,Object>[] data ){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        AgreeCount agreeCount =unionmemberService.deleteUnionAll(data);
        return agreeCount;
    }
    @RequestMapping("/escGuild")
    public int escGuild(HttpServletRequest request){
        HttpSession session =request.getSession();
        int uaid= (int) session.getAttribute("uald");
        int rid = (int) session.getAttribute("id");
        int count = unionmemberService.escGuild(rid);
        return count;
    }
}