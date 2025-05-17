package tzb.service;

import tzb.pojo.ClassTeachers;

import java.util.List;

public interface ClassTeachersService {
    Integer insert(ClassTeachers classTeachers);
    List<ClassTeachers> selectByClassId(long id);
}
