package tzb.service;

import tzb.pojo.UserActionLog;

import java.util.List;

public interface UserActionLogService {

    int addLog(UserActionLog log);

    int deleteById(Long id);

    int deleteByUserId(Long userId);

    UserActionLog getById(Long id);

    List<UserActionLog> getAll();

    List<UserActionLog> getByUserId(Long userId);

    List<UserActionLog> getByType(String type);

    List<UserActionLog> getPage(int page, int size);

    int countAll();
}