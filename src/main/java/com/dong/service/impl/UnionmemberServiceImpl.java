package com.dong.service.impl;

import com.dong.dao.UnionattributesDao;
import com.dong.model.Roles;
import com.dong.model.Unionattributes;
import com.dong.model.Unionmember;
import com.dong.dao.UnionmemberDao;
import com.dong.model.UnionmemberAndRoles;
import com.dong.service.RolesService;
import com.dong.service.UnionattributesService;
import com.dong.service.UnionmemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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
    @Resource
    private RolesService rolesService;
    @Resource
    private UnionattributesDao unionattributesDao;


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
    public int getCount(int uaid) {
        return unionmemberDao.getCount( uaid);
    }

    /**
     *工会成员添加
     * @param unionmember
     * @return
     */
    @Override
    public int add(Unionmember unionmember) {
        unionmemberDao.insert(unionmember);
        int uaid =unionmember.umUaId;
        int rid =unionmember.unRId;
        Roles roles =new Roles();
        roles.setRId(rid);
        roles.setRUaId(uaid);
        return rolesService.updateReturnInt(roles);
    }

    /**
     * 获得工会成员信息的全部键值对
     * @param uaid
     * @return
     */
    @Override
    public List<Map<String, Object>> getAllAndRoles(int uaid) {
        return unionmemberDao.getAllAndRoles(uaid);
    }

    /**
     * 转让会长
     * @param unionmember
     * @param rid
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public int transfer(Unionmember unionmember, int rid) {
        int count =0;
        count  =this.appointment(unionmember);
        int unRId=unionmember.getUnRId();
        count=this.leave(unRId,rid);
        return count;
    }

    /**
     * 任命
     * @param unionmember
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public int appointment(Unionmember unionmember) {
        int pid = unionmember.getUnPId();
        Unionmember unionmember2 =new Unionmember();
        unionmember2.setUnRId(unionmember.getUnRId());
        unionmember2.setUmUaId(unionmember.getUmId());
        List<Unionmember> unionmemberList =unionmemberDao.queryAll(unionmember2);
        unionmember.setUmId(unionmemberList.get(0).getUmId());
        return this.unionmemberDao.update(unionmember);
    }

    /**
     * 会长离职
     * @param rid
     * @return
     */
    @Transactional(rollbackFor=Exception.class)
    @Override
    public int leave(int unRId,int rid) {
        Unionattributes unionattributes= new  Unionattributes();
        int count=0;
        unionattributes.setUaCreateId(rid);
        //查到工会信息
        List <Unionattributes> unionattributesList =unionattributesDao.queryAll(unionattributes);
        //修改工会信息
        //获得工会信息id
        int uaId=unionattributesList.get(0).getUaId();
        //填id
        unionattributes.setUaId(uaId);
        //填更换的成员的id
        unionattributes.setUaCreateId(unRId);
        //修改工会信息
        count =unionattributesDao.update(unionattributes);
        //修改原会长在工会的信息
        Unionmember unionmember=new Unionmember();
        unionmember.setUnRId(rid);
        unionmember.setUmUaId(uaId);
        unionmember.setUnPId(4);
        count=this.appointment(unionmember);
        return count;
    }
}