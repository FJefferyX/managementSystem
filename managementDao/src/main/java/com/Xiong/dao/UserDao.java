package com.Xiong.dao;

import com.Xiong.domain.Role;
import com.Xiong.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {
    @Select("select * from users where id in (select usersId from users_role where roleId = #{id})")
    public User findByRoleId(String id);

    @Select("select * from users")
    @Results(id = "userMap", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "email", property = "email"),
            @Result(column = "username", property = "username"),
            @Result(column = "password", property = "password"),
            @Result(column = "phoneNum", property = "phoneNum"),
            @Result(column = "status", property = "status"),
            @Result(column = "id", property = "roles", javaType = List.class, many = @Many(select = "com.Xiong.dao.Roledao.findByUserId")),
    })
    public List<User> findAll();

    @Select("select * from users where username = #{string}")
    @ResultMap(value = "userMap")
    public User findByUsername(String string);

    @Insert("insert into users(id,username,password,email,phoneNum,status) values(#{id},#{username},#{password},#{email},#{phoneNum},#{status})")
    public void updateUser(User user);

    @Select("select * from users where id = #{string}")
    @ResultMap(value = "userMap")
    public User findById(String string);

    @Select("select * from role where id not in (select roleId from users_role where usersId = #{id})")
    @Results(id = "result", value = {
            @Result(id = true, column = "id", property = "id"),
            @Result(column = "roleName", property = "roleName"),
            @Result(column = "roleDesc", property = "roleDesc"),
            @Result(column = "id", property = "users", javaType = List.class, many = @Many(select = "com.Xiong.dao.UserDao.findByRoleId")),
            @Result(column = "id", property = "permissions", javaType = List.class, many = @Many(select = "com.Xiong.dao.PermissionDao.findByRoleId")),
    })
    public List<Role> findRolesNotInUser(String id);

    @Insert("insert into users_role(usersId,roleId) values(#{userId},#{roleId})")
    public void addRole(@Param("userId") String userId, @Param("roleId") String roleId);

    @Delete("delete from users_role where usersId=#{userId}")
    public void deleteRoleAndUser(String userId);

    @Delete("delete from users where Id=#{userId}")
    public void deleteUser(String userId);
}
