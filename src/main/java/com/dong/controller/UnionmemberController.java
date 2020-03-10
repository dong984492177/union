package com.dong.controller;

import com.dong.model.Unionmember;
import com.dong.model.UnionmemberAndRoles;
import com.dong.service.UnionmemberService;
import com.dong.util.ParseData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

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

    @RequestMapping("/getAll")
    public ParseData getAll(int page , int limit, HttpServletRequest request){
        logger.info("进入"+new Exception().getStackTrace()[0].getMethodName()+"方法");
        HttpSession session =request.getSession();
        int uaid= (int) session.getAttribute("uald");
        int offset=(page-1)*limit;
        List<UnionmemberAndRoles> unionmemberAndRolesList=unionmemberService.queryAllByLimitAndRoles(offset,limit,uaid);
        int count =unionmemberService.getCount();
        ParseData parseData= new ParseData();
        parseData.setData(unionmemberAndRolesList);
        parseData.setCount(count);
        return parseData;
    }


}