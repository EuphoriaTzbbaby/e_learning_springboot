package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.EnglishMapper;
import tzb.pojo.English;
import tzb.service.EnglishService;

import java.util.List;

@Service
public class EnglishServiceImpl implements EnglishService {

    @Autowired
    private EnglishMapper englishMapper;

    @Override
    public int insert(English english) {
        return englishMapper.insert(english);
    }

    @Override
    public int deleteById(long egId) {
        return englishMapper.deleteById(egId);
    }

    @Override
    public int update(English english) {
        return englishMapper.update(english);
    }

    @Override
    public English selectById(long egId) {
        return englishMapper.selectById(egId);
    }

    @Override
    public List<English> selectAll() {
        return englishMapper.selectAll();
    }
}
