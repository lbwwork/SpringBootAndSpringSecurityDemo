package com.xiaobao.study.springsecurity.mapper;

import com.xiaobao.study.springsecurity.entity.SysRole;
import org.apache.ibatis.annotations.Select;

/**
 * 角色mapper
 * @author lbw
 */
public interface SysRoleMapper {
    /**
     * 根据id查询角色
     * @param id
     * @return
     */
    @Select("SELECT * FROM sys_role WHERE id = #{id}")
    SysRole selectById(Integer id);
}
