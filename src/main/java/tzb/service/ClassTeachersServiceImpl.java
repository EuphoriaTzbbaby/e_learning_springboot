package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.ClassTeachersMapper;
import tzb.pojo.ClassTeachers;

import java.util.List;

@Service
public class ClassTeachersServiceImpl implements ClassTeachersService {
    @Autowired
    private ClassTeachersMapper classTeachersMapper;
    @Override
    public Integer insert(ClassTeachers classTeachers) {
        return  classTeachersMapper.insert(classTeachers);
    }
    @Override
    public List<ClassTeachers> selectByClassId(long classId) {
        return classTeachersMapper.selectByClassId(classId);
    }
}
