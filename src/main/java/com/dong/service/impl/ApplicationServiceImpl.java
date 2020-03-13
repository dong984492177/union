package com.dong.service.impl;

import com.dong.dao.RolesDao;
import com.dong.dao.UnionmemberDao;
import com.dong.model.Application;
import com.dong.dao.ApplicationDao;
import com.dong.model.ApplicationAndRoles;
import com.dong.model.Roles;
import com.dong.model.Unionmember;
import com.dong.service.ApplicationService;
import com.dong.service.UnionmemberService;
import com.dong.util.AgreeCount;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * (Application)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 13:32:06
 */
@Service("applicationService")
public class ApplicationServiceImpl implements ApplicationService {
    @Resource
    private ApplicationDao applicationDao;
    @Resource
    private RolesDao rolesDao;
    @Resource
    private UnionmemberService unionmemberService;

    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    @Override
    public Application queryById(Integer aId) {
        return this.applicationDao.queryById(aId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Application> queryAllByLimit(int offset, int limit) {
        return this.applicationDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    @Override
    public Application insert(Application application) {
        this.applicationDao.insert(application);
        return application;
    }

    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    @Override
    public Application update(Application application) {
        this.applicationDao.update(application);
        return this.queryById(application.getAId());
    }

    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer aId) {
        return this.applicationDao.deleteById(aId) > 0;
    }

    /**
     * 通过实体作为筛选条件查询
     * @param application
     * @return
     */
    @Override
    public List<Application> queryAll(Application application) {
        return applicationDao.queryAll(application);
    }

    /**
     * 修改 返回int
     * @param application
     * @return
     */
    @Override
    public int updateIsInt(Application application) {
        return this.applicationDao.update(application);
    }

    /**
     * 删除 返回int
     * @param application
     * @return
     */
    @Override
    public int insertIsInt(Application application) {
        return this.applicationDao.insert(application);
    }

    /**
     * 连表分页查询
     * @param page
     * @param limit
     * @param applicationAndRoles 俩表联立类
     * @return
     */
    @Override
    public List<ApplicationAndRoles> queryAllByLimitAndRoles(int page, int limit, ApplicationAndRoles applicationAndRoles) {
        return applicationDao.queryAllByLimitAndRoles(page,limit,applicationAndRoles);
    }

    /**
     * 连表分页查询总条数
     * @param applicationAndRoles
     * @return
     */
    @Override
    public int getCountAll(ApplicationAndRoles applicationAndRoles) {
        return applicationDao.getCountAll(applicationAndRoles);
    }

    /**
     * 批量拒绝
     * @param data
     * @param aOperatingId
     * @return
     */
    @Override
    public AgreeCount refuseall(Map<String ,Object>[] data,int aOperatingId) {
        AgreeCount agreeCount=new AgreeCount();
        //拒绝成功
        int refuseCount=0;
        //失败
        int failure=0;
        for (Map map:data) {
            int aid= (int) map.get("aid");
            int count=applicationDao.refuse(aid,aOperatingId);
            if(count>0){
                refuseCount++;
            }else {
                failure++;
            }
        }
        agreeCount.setFailure(failure);
        agreeCount.setRefuseCount(refuseCount);
        return agreeCount;
    }

    /**
     * 拒绝申请
     * @param aId 申请的id
     * @param aOperatingId 拒绝操作人
     * @return
     */
    @Override
    public int refuse(int aId,int aOperatingId) {
        return applicationDao.refuse(aId,aOperatingId);
    }

    /**
     * 同意申请
     * @param aid 申请表id
     * @param aOperatingId 操作申请人id
     * @param rid 申请角色的id
     * @param uald 工会id
     * @return
     */
    @Override
    public AgreeCount agree(int aid, int aOperatingId, int rid,int uald) {
        Roles roles = rolesDao.queryById(rid);
        AgreeCount agreeCount=new AgreeCount();
        int count =0;
        //如果有工会
        if (roles.getRUaId()!=null){
            count= applicationDao.refuse(aid,aOperatingId);
            if (count>0){
                agreeCount.setRefuseCount(1);

            }else{
                agreeCount.setFailure(1);
            }

        }else {
            //如果没有工会
            Unionmember unionmember=new Unionmember();
            unionmember.setUmUaId(uald);
            unionmember.setUnRId(rid);
            count = unionmemberService.add(unionmember);
            if (count>0){
                agreeCount.setAgree(1);
                applicationDao.deleteById(aid);
            }else{
                agreeCount.setFailure(1);
            }

        }

        return agreeCount;
    }

    @Override
    public AgreeCount agreeAll(Map<String, Object>[] data, int aOperatingId, int uald) {
        AgreeCount agreeCount=new AgreeCount();
        //同意成功
        int agree=0;
        //拒绝成功
        int refuseCount=0;
        //失败
        int failure=0;
        for (Map map:data ){
            //角色表id
            int aid = (int) map.get("aid");
            //角色id
            Map<String ,Object> roles= (Map<String, Object>) map.get("roles");
            int rid= (int) roles.get("rid");
            AgreeCount  agreeCount2=this.agree(aid,aOperatingId,rid,uald);
            agree += agreeCount2.getAgree();
            refuseCount += agreeCount2.getRefuseCount();
            failure += agreeCount2.getFailure();
        }
        agreeCount.setAgree(agree);
        agreeCount.setFailure(failure);
        agreeCount.setRefuseCount(refuseCount);
        return agreeCount;
    }

}