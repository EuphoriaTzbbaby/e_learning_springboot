package tzb.service;

import tzb.pojo.Users;

import java.util.List;

public interface UsersService {
    Users findById(long id);
    List<Users> findAll();
    int insert(Users user);
    int update(Users user);
    int deleteById(long id);
    int checkLogin(Users users);
}
