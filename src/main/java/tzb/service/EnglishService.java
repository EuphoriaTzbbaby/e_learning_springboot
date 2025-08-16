package tzb.service;

import tzb.pojo.English;

import java.util.List;

public interface EnglishService {
    int insert(English english);
    int deleteById(long egId);
    int update(English english);
    English selectById(long egId);
    List<English> selectAll();
}
