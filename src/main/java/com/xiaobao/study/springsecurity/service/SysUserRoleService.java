package com.xiaobao.study.springsecurity.service;

import com.xiaobao.study.springsecurity.entity.SysUserRole;
import com.xiaobao.study.springsecurity.mapper.SysUserRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户角色服务层
 * @author lbw
 */
@Service
public class SysUserRoleService {
    @Autowired
    private SysUserRoleMapper userRoleMapper;

    public List<SysUserRole> listByUserId(Integer userId) {
        return userRoleMapper.listByUserId(userId);
    }
}
