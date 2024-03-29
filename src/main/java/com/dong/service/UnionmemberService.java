package com.dong.service;

import com.dong.model.Unionmember;
import com.dong.model.UnionmemberAndRoles;
import com.dong.util.AgreeCount;

import java.util.List;
import java.util.Map;

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

    /**
     * 通过实体作为筛选条件查询
     * @param unionmember
     * @return
     */
    List<Unionmember> queryAll(Unionmember unionmember);

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

    /**
     * 工会添加成员操作
     * @param unionmember
     * @return
     */
    int add(Unionmember unionmember);

    /**
     * 获得信息键值对形式
     * @param uaid
     * @return
     */
    List<Map<String, Object>> getAllAndRoles(int uaid);

    /**
     * 转让会长
     * @param unionmember
     * @param rid
     * @return
     */
    int transfer(Unionmember unionmember, int rid);

    /**
     * 任命
     * @param unionmember
     * @return
     */
    int appointment(Unionmember unionmember);

    /**
     * 会长离职
     * @param unRId
     * @param rid
     * @return
     */
    int leave(int unRId,int rid);

    /**
     * 移除成员
     * @param data
     * @return
     */
    AgreeCount deleteUnion(Map<String, Object> data);

    /**
     * 移除选择所有
     * @param data
     * @return
     */
    AgreeCount deleteUnionAll(Map<String, Object>[] data);

    /**
     * 退出工会
     * @param rid
     * @return
     */
    int escGuild( int rid);
}