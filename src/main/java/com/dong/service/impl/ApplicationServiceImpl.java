package com.dong.service.impl;

import com.dong.model.Application;
import com.dong.dao.ApplicationDao;
import com.dong.model.ApplicationAndRoles;
import com.dong.service.ApplicationService;
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
}