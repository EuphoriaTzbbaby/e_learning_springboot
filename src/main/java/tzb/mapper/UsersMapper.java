package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.Users;

import java.util.List;

@Mapper
public interface UsersMapper {

    @Select("SELECT * FROM users WHERE id = #{id}")
    Users findById(@Param("id") long id);

    @Select("SELECT * FROM users")
    List<Users> findAll();
    @Select("select count(*) from users where email = #{email} and password = #{password} and role = #{role}")
    int checkLogin(Users user);

    @Insert("INSERT INTO users (username, password, role, name, email, created_at, avatar) " +
            "VALUES (#{username}, #{password}, #{role}, #{name}, #{email}, #{createdAt}, #{avatar})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Users user);

    @Update("UPDATE users SET username = #{username}, password = #{password}, " +
            "role = #{role}, name = #{name}, email = #{email}, created_at = #{createdAt}, avatar = #{avatar}" +
            "WHERE id = #{id}")
    int update(Users user);

    @Delete("DELETE FROM users WHERE id = #{id}")
    int deleteById(@Param("id") long id);
}
