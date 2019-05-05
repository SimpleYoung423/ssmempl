package com.yxp423.ssmempl.mapper;

import com.yxp423.ssmempl.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Description: java类作用描述
 * @Author: yxp
 * @CreateDate: 2019-04-16 21:02
 * @Version: 1.0
 */

@Mapper
public interface UserMapper {

    /**
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE user_id = #{id}")
    public User getUserById(Integer id);

    @Select("SELECT * FROM sys_user WHERE id_card = #{idCard}")
    public User getUserByIdcard(String idCard);

    @Select("SELECT * FROM sys_user WHERE phone = #{phone}")
    public User getUserByPhone(String phone);

    /**
     * 查询所有用户信息
     * @return
     */
    @Select("SELECT * FROM user ")
    public List<User> getUserAll();

    /**
     * 查询用户角色
     * @param userAccount
     * @return
     */
    @Select("")
    public String getRole(String userAccount);


    @Select("SELECT * FROM sys_user WHERE user_account= #{userAccount} ")
    public User getUserByUserAccount(String userAccount);

    /**
     * 根据用户名查询密码
     * @param userAccount
     * @return
     */
    @Select("SELECT password FROM sys_user WHERE user_account = #{userAccount} ")
    public String getPasswordByUsername(String userAccount);

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Insert("INSERT INTO sys_user(user_account,`password`,`name`,sex,id_card,phone,address,creat_time,update_time,dept_code,`status`) " +
            "VALUES(#{userAccount},#{password},#{name},#{sex},#{idCard},#{phone},#{address},#{creatTime},#{updateTime},#{deptCode},#{status})")
    public int inserUser(User user);


    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Update("UPDATE sys_user SET user_account = #{userAccount} WHERE user_id = #{UserId}")
    public int updateUser(User user);


    /**
     * 根据角色编号模糊查询用户
     * @param roleCode
     * @return
     */
    @Select("SELECT sys_user.user_id,sys_user.user_account,sys_user.`name`,sys_user.dept_code FROM sys_user WHERE user_role LIKE #{roleCode}")
    public List<User> getReviewer(String roleCode);

}

