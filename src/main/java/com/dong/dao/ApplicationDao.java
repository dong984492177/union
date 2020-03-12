package com.dong.dao;

import com.dong.model.Application;
import com.dong.model.ApplicationAndRoles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Application)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 13:32:04
 */
 @Mapper
public interface ApplicationDao {

    /**
     * 通过ID查询单条数据
     *
     * @param aId 主键
     * @return 实例对象
     */
    Application queryById(Integer aId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Application> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param application 实例对象
     * @return 对象列表
     */
    List<Application> queryAll(Application application);

    /**
     * 新增数据
     *
     * @param application 实例对象
     * @return 影响行数
     */
    int insert(Application application);

    /**
     * 修改数据
     *
     * @param application 实例对象
     * @return 影响行数
     */
    int update(Application application);

    /**
     * 通过主键删除数据
     *
     * @param aId 主键
     * @return 影响行数
     */
    int deleteById(Integer aId);

    /**
     * 连表分页查询
     * @param page
     * @param limit
     * @param applicationAndRoles
     * @return
     */
    List<ApplicationAndRoles> queryAllByLimitAndRoles(int page, int limit, ApplicationAndRoles applicationAndRoles);

    /**
     * 连表分页查询总条数
     * @param applicationAndRoles
     * @return
     */
    int getCountAll(ApplicationAndRoles applicationAndRoles);

    int refuse(int aId, int aOperatingId);
}