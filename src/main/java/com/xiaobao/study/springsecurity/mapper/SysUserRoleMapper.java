package com.xiaobao.study.springsecurity.mapper;

import com.xiaobao.study.springsecurity.entity.SysUserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 用户角色表
 * @author lbw
 */
public interface SysUserRoleMapper {
    /**
     * 根据用户id获取该用户对应的所有角色
     * @param userId
     * @return
     */
    @Select("SELECT * FROM sys_user_role WHERE user_id = #{userId}")
    List<SysUserRole> listByUserId(Integer userId);
}
