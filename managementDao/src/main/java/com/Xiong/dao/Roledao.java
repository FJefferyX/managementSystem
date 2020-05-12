package com.Xiong.dao;

import com.Xiong.domain.Permission;
import com.Xiong.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Roledao {
    @Select("select * from role")
    @Results(id = "result", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "users", javaType = List.class, many = @Many(select = "com.Xiong.dao.UserDao.findByRoleId")),
            @Result(column = "id", property = "permissions", javaType = List.class, many = @Many(select = "com.Xiong.dao.PermissionDao.findByRoleId")),
    })
    public List<Role> findAll();

    @Select("select * from role where id in (select roleId from users_role where usersId =#{id} )")
    @ResultMap("result")
    public Role findByUserId(String id);

    @Select("select * from role where id in (select roleId from role_permission where permissionId =#{id} )")
    @ResultMap("result")
    public Role findByPermissionId(String id);

    @Insert("insert into role(id,roleName,roleDesc) values(#{id},#{roleName},#{roleDesc})")
    public void save(Role role);

    @Select("select * from role where id =#{id}")
    @ResultMap("result")
    public Role findById(String id);

    @Delete(("delete from role where id =#{id}"))
    public void deleteById(String id);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{id})")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "permissionName", property = "permissionName"),
            @Result(column = "url", property = "url"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.Xiong.dao.Roledao.findByPermissionId"))
    })
    public List<Permission> findNotInPermission(String id);

    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    public void addPermission(@Param(value = "roleId") String roleId, @Param(value = "permissionId") String permissionId);
}
