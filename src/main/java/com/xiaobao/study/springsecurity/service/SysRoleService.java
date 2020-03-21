package com.xiaobao.study.springsecurity.service;

import com.xiaobao.study.springsecurity.entity.SysRole;
import com.xiaobao.study.springsecurity.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 角色服务层
 * @author lbw
 */
@Service
public class SysRoleService {
    @Autowired
    private SysRoleMapper roleMapper;

    public SysRole selectById(Integer id){
        return roleMapper.selectById(id);
    }
}
