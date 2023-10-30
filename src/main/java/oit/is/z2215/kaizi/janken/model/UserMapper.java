package oit.is.z2215.kaizi.janken.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {

  @Select("SELECT ID,USERNAME FROM USERS")
  ArrayList<User> selectAllByUser();

  @Select("SELECT ID,USERNAME FROM USERS WHERE ID = #{id}")
  User selectById(int id);

  @Select("SELECT ID,USERNAME FROM USERS WHERE USERNAME = #{username}")
  User selectByUsername(String username);

}
