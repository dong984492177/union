package com.dong.service.impl;

import com.dong.dao.RolesDao;
import com.dong.dao.UnionmemberDao;
import com.dong.model.Roles;
import com.dong.model.Unionattributes;
import com.dong.dao.UnionattributesDao;
import com.dong.model.UnionattributesAndRoles;
import com.dong.model.Unionmember;

import com.dong.service.UnionattributesService;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Resource
    private UnionmemberDao unionmemberDao;
    @Resource
    private RolesDao rolesDao;

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

    /**
     * 通过实体作为筛选条件查询
     * @param unionattributes
     * @return
     */
    @Override
    public List<Unionattributes> queryAll(Unionattributes unionattributes) {
        return unionattributesDao.queryAll(unionattributes);
    }

    /**
     * 工会表添加已经相关联表添加修改
     * @param unionattributes
     * @return
     */
    @Override
    @Transactional(rollbackFor=Exception.class)
    public int insertReturnInt(Unionattributes unionattributes) {
        int count=0;
        //角色id
        int rid = unionattributes.getUaCreateId();
        //添加工会
        unionattributes=this.insert(unionattributes);
        //工会id
        int uaid= unionattributes.getUaId();
        Unionmember unionmember = new Unionmember();
        //工会成员信息表中成员所属工会id
        unionmember.setUmUaId(uaid);
        //工会成员信息表中成员id
        unionmember.setUnRId(rid);
        //工会成员信息表中成员所属工会职务为工会会长
        unionmember.setUnPId(1);
        //工会成员添加
        unionmemberDao.insert(unionmember);
        //获得角色信息
        Roles roles =rolesDao.queryById(rid);
        //更改角色金币数量
        roles.setRGold(roles.getRGold()-500000);
        //更改角色工会id
        roles.setRUaId(uaid);
        count=rolesDao.update(roles);
        return count;
    }

    /**
     * 获得所有的信息
     *
     * @return
     */
    @Override
    public List<UnionattributesAndRoles> getAll() {
        return unionattributesDao.getAll();
    }

    /**
     * 获得总条数
     * @return
     */
    @Override
    public int getCount() {
        return unionattributesDao.getCount();
    }

    /**
     * 连表分页
     * @param offset
     * @param limit
     * @return
     */
    @Override
    public List<UnionattributesAndRoles> queryAllByLimitAndRoles(int offset, int limit) {
        return unionattributesDao.queryAllByLimitAndRoles(offset,limit);
    }

    @Override
    public UnionattributesAndRoles getById(int uaid) {
        return unionattributesDao.getById(uaid);
    }
}