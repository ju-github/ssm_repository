package com.xian.service;

import com.xian.domain.Permission;
import com.xian.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll();

    void save(Role role);


    List<Role> findOtherRole(String id);

    void addRoleToUser(String userId, String[] ids);

    Role findById(String roleId);

    List<Permission> findOtherPermission(String roleId);

    void addPermissionToRole(String roleId, String[] ids);
}
