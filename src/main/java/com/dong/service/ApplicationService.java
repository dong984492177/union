package com.dong.service;

import com.dong.model.Application;
import com.dong.model.ApplicationAndRoles;
import com.dong.util.AgreeCount;

import java.util.List;
import java.util.Map;

/**
 * (Application)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 13:32:05
 */
public interface ApplicationService {

    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    Application queryById(Integer aId);


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Application> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    Application insert(Application application);

    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 实例对象
     */
    Application update(Application application);

    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer aId);

    /**
     * 通过实体作为筛选条件查询
     * @param application
     * @return
     */
    List<Application> queryAll(Application application);

    /**
     * 修改返回int
     * @param application
     * @return
     */
    int updateIsInt(Application application);

    /**
     * 添加返回int
     * @param application
     * @return
     */
    int insertIsInt(Application application);

    /**
     * 连表分页查询
     * @param page
     * @param limit
     * @param applicationAndRoles
     * @return
     */
    List<ApplicationAndRoles> queryAllByLimitAndRoles(int page, int limit, ApplicationAndRoles applicationAndRoles);

    /**
     * 分页查询条数
     * @param applicationAndRoles
     * @return
     */
    int getCountAll(ApplicationAndRoles applicationAndRoles);

    /**
     * 多条拒绝
     * @param data
     * @return
     */
    AgreeCount refuseall(Map<String ,Object>[] data,int aOperatingId );

    int refuse(int aId,int aOperatingId );
}