package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.UserActionLogMapper;
import tzb.pojo.UserActionLog;
import tzb.service.UserActionLogService;

import java.util.List;

@Service
public class UserActionLogServiceImpl implements UserActionLogService {

    @Autowired
    private UserActionLogMapper mapper;

    @Override
    public int addLog(UserActionLog log) {
        return mapper.insert(log);
    }

    @Override
    public int deleteById(Long id) {
        return mapper.deleteById(id);
    }

    @Override
    public int deleteByUserId(Long userId) {
        return mapper.deleteByUserId(userId);
    }

    @Override
    public UserActionLog getById(Long id) {
        return mapper.selectById(id);
    }

    @Override
    public List<UserActionLog> getAll() {
        return mapper.selectAll();
    }

    @Override
    public List<UserActionLog> getByUserId(Long userId) {
        return mapper.selectByUserId(userId);
    }

    @Override
    public List<UserActionLog> getByType(String type) {
        return mapper.selectByType(type);
    }

    @Override
    public List<UserActionLog> getPage(int page, int size) {
        int offset = (page - 1) * size;
        return mapper.selectPage(offset, size);
    }

    @Override
    public int countAll() {
        return mapper.countAll();
    }
}