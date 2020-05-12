package com.Xiong.dao;

import com.Xiong.domain.Permission;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    @Select("select * from permission where id in (select permissionId from role_permission where roleId = #{id})")
    public Permission findByRoleId(String id);

    @Select("select * from permission")
    @Results(value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "permissionName", property = "permissionName"),
            @Result(column = "url", property = "url"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.Xiong.dao.Roledao.findByPermissionId"))
    })
    public List<Permission> findAll();
}
