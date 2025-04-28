package tzb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tzb.mapper.ClassStudentsMapper;
import tzb.pojo.ClassStudents;

import java.util.List;

@Service
public class ClassStudentsServiceImpl implements ClassStudentsService {
    @Autowired
    private ClassStudentsMapper classStudentsMapper;
    @Override
    public Integer insert(ClassStudents classStudents) {
        return  classStudentsMapper.insert(classStudents);
    }
    @Override
    public List<ClassStudents> selectByClassId(long classId) {
        return classStudentsMapper.selectByClassId(classId);
    }
}
