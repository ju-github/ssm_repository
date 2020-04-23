package com.xian.service.impl;

import com.xian.dao.IRoleDao;
import com.xian.domain.Permission;
import com.xian.domain.Role;
import com.xian.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class RoleServiceImpl implements IRoleService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findOtherRole(String id) {
        return roleDao.findOtherRole(id);

    }

    @Override
    public void addRoleToUser(String userId, String[] ids) {
        for (String id : ids) {
            roleDao.addRoleToUser(userId,id);
        }

    }

    @Override
    public Role findById(String roleId) {
        return roleDao.findById(roleId);
    }

    @Override
    public List<Permission> findOtherPermission(String roleId) {
        return roleDao.findOtherPermission(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] ids) {
        for (String permissionId : ids) {
            roleDao.addPermissionToRole(roleId,permissionId);
        }
    }
}
