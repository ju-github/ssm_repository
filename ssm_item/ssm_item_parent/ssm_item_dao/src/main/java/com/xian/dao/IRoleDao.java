package com.xian.dao;

import com.xian.domain.Permission;
import com.xian.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IRoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property ="id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",many = @Many(select = "com.xian.dao.IPermissionDao.findByRoleId"))
    })
    public List<Role> findRoleByUserId(String userId);

    @Select("select * from role")
    List<Role> findAll();

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);

    @Select("select * from Role where id not in(select roleId from users_role where userId=#{id})")
    List<Role> findOtherRole(String id);

    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);

    @Select("select * from role where id=#{roleId}")
    Role findById(String roleId);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(String roleId);


    @Insert("Insert into role_permission (roleId,permissionId) values (#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
