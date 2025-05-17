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
    public Users selectById(long id) {
        return usersMapper.selectById(id);
    }

    @Override
    public List<Users> selectAll() {
        return usersMapper.selectAll();
    }


    @Override
    public int insert(Users user) {
        return usersMapper.insert(user);
    }

    @Override
    public int updateById(Users user) {
        return usersMapper.updateById(user);
    }

    @Override
    public int deleteById(long id) {
        return usersMapper.deleteById(id);
    }
    @Override
    public Users checkLogin(Users users) {
        return usersMapper.checkLogin(users);
    }
}
