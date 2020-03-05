package com.dong.service;

import com.dong.model.Roles;
import java.util.List;

/**
 * (Roles)表服务接口
 *
 * @author makejava
 * @since 2020-03-02 11:45:19
 */
public interface RolesService {

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    public Roles queryById(Integer rId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    public List<Roles> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param roles 实例对象
     * @return 实例对象
     */
    public Roles insert(Roles roles);

    /**
     * 修改数据
     *
     * @param roles 实例对象
     * @return 实例对象
     */
    public Roles update(Roles roles);

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer rId);

    /**
     * 通过实体作为筛选条件查询
     * @param roles
     * @return
     */
    List<Roles> queryAll(Roles roles);

    /**
     * 通过实体修改返回int
     * @param roles
     * @return
     */
    int updateReturnInt(Roles roles);
}