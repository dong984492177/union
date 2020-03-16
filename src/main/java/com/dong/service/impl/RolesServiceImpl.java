package com.dong.service.impl;

import com.dong.model.Roles;
import com.dong.dao.RolesDao;
import com.dong.service.RolesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Roles)表服务实现类
 *
 * @author makejava
 * @since 2020-03-05 15:04:18
 */
@Service("rolesService")
public class RolesServiceImpl implements RolesService {
    @Resource
    private RolesDao rolesDao;

    /**
     * 通过ID查询单条数据
     *
     * @param rId 主键
     * @return 实例对象
     */
    @Override
    public Roles queryById(Integer rId) {
        return this.rolesDao.queryById(rId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Roles> queryAllByLimit(int offset, int limit) {
        return this.rolesDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param roles 实例对象
     * @return 实例对象
     */
    @Override
    public Roles insert(Roles roles) {
        this.rolesDao.insert(roles);
        return roles;
    }

    /**
     * 修改数据
     *
     * @param roles 实例对象
     * @return 实例对象
     */
    @Override
    public Roles update(Roles roles) {
        this.rolesDao.update(roles);
        return this.queryById(roles.getRId());
    }

    /**
     * 通过主键删除数据
     *
     * @param rId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer rId) {
        return this.rolesDao.deleteById(rId) > 0;
    }

    /**
     * 获取所以的信息
     * @param roles
     * @return
     */
    @Override
    public List<Roles> queryAll(Roles roles) {
        return this.rolesDao.queryAll(roles);
    }

    /**
     * 修改返回int
     * @param roles
     * @return
     */
    @Override
    public int updateReturnInt(Roles roles) {
        return  this.rolesDao.update(roles);
    }

    /**
     * 删除成员信息中的工会id
     * @param rid
     * @return
     */
    @Override
    public int deleteApplicationById(int rid) {
        return this.rolesDao.deleteApplicationById(rid);
    }
}