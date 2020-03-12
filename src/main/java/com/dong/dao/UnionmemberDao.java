package com.dong.dao;

import com.dong.model.Unionmember;
import com.dong.model.UnionmemberAndRoles;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (Unionmember)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 13:33:53
 */
 @Mapper
public interface UnionmemberDao {

    /**
     * 通过ID查询单条数据
     *
     * @param umId 主键
     * @return 实例对象
     */
    Unionmember queryById(Integer umId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Unionmember> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param unionmember 实例对象
     * @return 对象列表
     */
    List<Unionmember> queryAll(Unionmember unionmember);

    /**
     * 新增数据
     *
     * @param unionmember 实例对象
     * @return 影响行数
     */
    int insert(Unionmember unionmember);

    /**
     * 修改数据
     *
     * @param unionmember 实例对象
     * @return 影响行数
     */
    int update(Unionmember unionmember);

    /**
     * 通过主键删除数据
     *
     * @param umId 主键
     * @return 影响行数
     */
    int deleteById(Integer umId);

    /**
     * 连表分页
     * @param offset
     * @param limit
     * @return
     */
    List<UnionmemberAndRoles> queryAllByLimitAndRoles(int offset, int limit,int uaid);

    /**
     * 获得总条数
     * @return
     */
    int getCount(int uaid);
}