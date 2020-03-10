package com.dong.service.impl;

import com.dong.model.Unionmember;
import com.dong.dao.UnionmemberDao;
import com.dong.model.UnionmemberAndRoles;
import com.dong.service.UnionmemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Unionmember)表服务实现类
 *
 * @author makejava
 * @since 2020-03-03 13:32:13
 */
@Service("unionmemberService")
public class UnionmemberServiceImpl implements UnionmemberService {
    @Resource
    private UnionmemberDao unionmemberDao;

    /**
     * 通过ID查询单条数据
     *
     * @param umId 主键
     * @return 实例对象
     */
    @Override
    public Unionmember queryById(Integer umId) {
        return this.unionmemberDao.queryById(umId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Unionmember> queryAllByLimit(int offset, int limit) {
        return this.unionmemberDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param unionmember 实例对象
     * @return 实例对象
     */
    @Override
    public Unionmember insert(Unionmember unionmember) {
        this.unionmemberDao.insert(unionmember);
        return unionmember;
    }

    /**
     * 修改数据
     *
     * @param unionmember 实例对象
     * @return 实例对象
     */
    @Override
    public Unionmember update(Unionmember unionmember) {
        this.unionmemberDao.update(unionmember);
        return this.queryById(unionmember.getUmId());
    }

    /**
     * 通过主键删除数据
     *
     * @param umId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer umId) {
        return this.unionmemberDao.deleteById(umId) > 0;
    }

    /**
     * 通过实体作为筛选条件查询
     * @param unionmember
     * @return
     */
    @Override
    public List<Unionmember> queryAll(Unionmember unionmember) {
        return this.unionmemberDao.queryAll(unionmember);
    }

    /**
     * 连表分页
     * @param offset 开始位置
     * @param limit 条数
     * @return
     */
    @Override
    public List<UnionmemberAndRoles> queryAllByLimitAndRoles(int offset, int limit ,int uaid) {
        return this.unionmemberDao.queryAllByLimitAndRoles(offset,limit,uaid);
    }

    /**
     * 获得总条数
     * @return
     */
    @Override
    public int getCount() {
        return unionmemberDao.getCount();
    }
}