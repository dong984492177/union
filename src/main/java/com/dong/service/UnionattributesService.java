package com.dong.service;

import com.dong.model.Unionattributes;
import java.util.List;

/**
 * (Unionattributes)表服务接口
 *
 * @author makejava
 * @since 2020-03-03 13:32:09
 */
public interface UnionattributesService {

    /**
     * 通过ID查询单条数据
     *
     * @param uaId 主键
     * @return 实例对象
     */
    Unionattributes queryById(Integer uaId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Unionattributes> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param unionattributes 实例对象
     * @return 实例对象
     */
    Unionattributes insert(Unionattributes unionattributes);

    /**
     * 修改数据
     *
     * @param unionattributes 实例对象
     * @return 实例对象
     */
    Unionattributes update(Unionattributes unionattributes);

    /**
     * 通过主键删除数据
     *
     * @param uaId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer uaId);

}