package com.dong.service.impl;

import com.dong.model.Unionattributes;
import com.dong.dao.UnionattributesDao;
import com.dong.service.UnionattributesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Unionattributes)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 13:32:10
 */
@Service("unionattributesService")
public class UnionattributesServiceImpl implements UnionattributesService {
    @Resource
    private UnionattributesDao unionattributesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param uaId 主键
     * @return 实例对象
     */
    @Override
    public Unionattributes queryById(Integer uaId) {
        return this.unionattributesDao.queryById(uaId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Unionattributes> queryAllByLimit(int offset, int limit) {
        return this.unionattributesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param unionattributes 实例对象
     * @return 实例对象
     */
    @Override
    public Unionattributes insert(Unionattributes unionattributes) {
        this.unionattributesDao.insert(unionattributes);
        return unionattributes;
    }

    /**
     * 修改数据
     *
     * @param unionattributes 实例对象
     * @return 实例对象
     */
    @Override
    public Unionattributes update(Unionattributes unionattributes) {
        this.unionattributesDao.update(unionattributes);
        return this.queryById(unionattributes.getUaId());
    }

    /**
     * 通过主键删除数据
     *
     * @param uaId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer uaId) {
        return this.unionattributesDao.deleteById(uaId) > 0;
    }
}