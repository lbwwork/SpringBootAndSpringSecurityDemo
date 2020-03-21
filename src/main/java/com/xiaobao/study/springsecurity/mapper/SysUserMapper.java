package com.xiaobao.study.springsecurity.mapper;

import com.xiaobao.study.springsecurity.entity.SysUser;
import org.apache.ibatis.annotations.Select;

/**
 * 用户mapper
 * @author lbw
 */
public interface SysUserMapper {
    /**
     * 根据用户名查询用户
     * @param name
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE name = #{name}")
    SysUser selectByName(String name);

    /**
     * 根据用户id查询用户
     * @param id
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE id = #{id}")
    SysUser selectById(Integer id);
}
