package com.dong.dao;

import com.dong.model.Roles;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Roles)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-02 12:05:06
 */
@Mapper
public interface RolesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    public Roles queryById(Integer rId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<Roles> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param roles 实例对象
     * @return 对象列表
     */
    public List<Roles> queryAll(Roles roles);

    /**
     * 新增数据
     *
     * @param roles 实例对象
     * @return 影响行数
     */
    public int insert(Roles roles);

    /**
     * 修改数据
     *
     * @param roles 实例对象
     * @return 影响行数
     */
    public int update(Roles roles);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 影响行数
     */
    public int deleteById(Integer rId);

}