package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.Users;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    Users selectById(@Param("id") long id);

    @Select("SELECT * FROM users")
    List<Users> selectAll();
    @Select("select * from users where email = #{email} and password = #{password} and role = #{role}")
    Users checkLogin(Users user);
    @Insert("INSERT INTO users (username, password, role, name, email, created_at, updated_at, state, avatar) " +
            "VALUES (#{username}, #{password}, #{role}, #{name}, #{email}, #{createdAt}, #{updatedAt}, state, #{avatar})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Users user);

    @Update("UPDATE users SET username = #{username}, password = #{password}, " +
            "role = #{role}, name = #{name}, email = #{email}, created_at = #{createdAt}, " +
            "updated_at = #{updatedAt}, state = #{state}, avatar = #{avatar} " +
            "WHERE id = #{id}")
    int updateById(Users user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteById(@Param("id") long id);
}
