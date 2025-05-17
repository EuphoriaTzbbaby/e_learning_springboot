package tzb.service;

import tzb.pojo.ClassStudents;

import java.util.List;

public interface ClassStudentsService {
    Integer insert(ClassStudents classStudents);
    List<ClassStudents> selectByClassId(long id);
}
