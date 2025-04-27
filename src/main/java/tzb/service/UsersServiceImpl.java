package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.UsersMapper;
import tzb.pojo.Users;
import tzb.service.UsersService;

import java.util.List;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    private UsersMapper usersMapper;

    @Override
    public Users findById(long id) {
        return usersMapper.findById(id);
    }

    @Override
    public List<Users> findAll() {
        return usersMapper.findAll();
    }

    @Override
    public int insert(Users user) {
        return usersMapper.insert(user);
    }

    @Override
    public int update(Users user) {
        return usersMapper.update(user);
    }

    @Override
    public int deleteById(long id) {
        return usersMapper.deleteById(id);
    }
    @Override
    public int checkLogin(Users users) {
        return usersMapper.checkLogin(users);
    }
}
