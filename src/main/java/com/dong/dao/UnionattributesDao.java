package com.dong.dao;

import com.dong.model.Unionattributes;
import com.dong.model.UnionattributesAndRoles;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

/**
 * (Unionattributes)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-03 13:33:52
 */
 @Mapper
public interface UnionattributesDao {

    /**
     * 通过ID查询单条数据
     *
     * @param uaId 主键
     * @return 实例对象
     */
    Unionattributes queryById(Integer uaId);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Unionattributes> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param unionattributes 实例对象
     * @return 对象列表
     */
    List<Unionattributes> queryAll(Unionattributes unionattributes);

    /**
     * 新增数据
     *
     * @param unionattributes 实例对象
     * @return 影响行数
     */
    int insert(Unionattributes unionattributes);

    /**
     * 修改数据
     *
     * @param unionattributes 实例对象
     * @return 影响行数
     */
    int update(Unionattributes unionattributes);

    /**
     * 通过主键删除数据
     *
     * @param uaId 主键
     * @return 影响行数
     */
    int deleteById(Integer uaId);

    /**
     * 连表查所有数据
     * @return
     */
    List<UnionattributesAndRoles> getAll();

    /**
     * 查总数
     * @return
     */
    int getCount();

    /**
     * 连表分页
     * @param offset
     * @param limit
     * @return
     */
    List<UnionattributesAndRoles> queryAllByLimitAndRoles(int offset, int limit);

    /**
     * 通过id连表查
     * @param uaid
     * @return
     */
    UnionattributesAndRoles getById(int uaid);
}