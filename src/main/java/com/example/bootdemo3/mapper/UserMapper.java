package com.example.bootdemo3.mapper;

import com.example.bootdemo3.bean.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface UserMapper {
    User getByUserNameAndPassword(User user);

    @Delete("delete from user where id = #{id,jdbcType=INTEGER}")
    int deleteByPrimaryKey(Integer id);
    @Insert("insert into user ( user_id, user_name, password, email)" +
            "values ( #{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{email,jdbcType=VARCHAR})")
    int insert(User record);
    @Update(" update user" +
            "    set user_id = #{userId,jdbcType=VARCHAR},\n" +
            "      user_name = #{userName,jdbcType=VARCHAR},\n" +
            "      password = #{password,jdbcType=VARCHAR},\n" +
            "      email = #{email,jdbcType=VARCHAR}\n" +
            "    where id = #{id,jdbcType=INTEGER}")
    int updateByPrimaryKey(User record);
}

