package com.dong.service;

import com.dong.model.Unionmember;
import java.util.List;

/**
 * (Unionmember)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 13:32:12
 */
public interface UnionmemberService {

    /**
     * 通过ID查询单条数据
     *
     * @param umId 主键
     * @return 实例对象
     */
    Unionmember queryById(Integer umId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Unionmember> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param unionmember 实例对象
     * @return 实例对象
     */
    Unionmember insert(Unionmember unionmember);

    /**
     * 修改数据
     *
     * @param unionmember 实例对象
     * @return 实例对象
     */
    Unionmember update(Unionmember unionmember);

    /**
     * 通过主键删除数据
     *
     * @param umId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer umId);

    List<Unionmember> queryAll(Unionmember unionmember);
}