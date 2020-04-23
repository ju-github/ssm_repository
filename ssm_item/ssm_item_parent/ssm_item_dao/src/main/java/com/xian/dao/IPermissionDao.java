package com.xian.dao;

import com.xian.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {


    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{roleId})")
    public List<Permission> findByRoleId(String roleId);

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permission,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
