package tzb.service;

import tzb.pojo.Users;

import java.util.List;

public interface UsersService {
    Users selectById(long id);
    List<Users> selectAll();
    int insert(Users user);
    int updateById(Users user);
    int deleteById(long id);
    Users checkLogin(Users users);
}
