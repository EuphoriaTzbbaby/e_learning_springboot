package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.ClassesMapper;
import tzb.pojo.Classes;

import java.util.List;

@Service
public class ClassesServiceImpl implements ClassesService {
    @Autowired
    private ClassesMapper classesMapper;

    @Override
    public Classes selectById(long id) {
        return classesMapper.selectById(id);
    }

    @Override
    public List<Classes>  selectAll() {
        return classesMapper.selectAll();
    }

    @Override
    public Integer insert(Classes classes) {
        return classesMapper.insert(classes);
    }

    @Override
    public Integer updateById(Classes classes) {
        return classesMapper.updateById(classes);
    }
    @Override
    public Integer deleteById(long id) {
        return classesMapper.deleteById(id);
    }
}
