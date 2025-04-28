package tzb.service;

import org.apache.ibatis.annotations.Param;
import tzb.pojo.Classes;

import java.util.List;

public interface ClassesService {
    Classes selectById(long id);
    List<Classes> selectAll();
    Integer insert(Classes classes);
    Integer updateById(Classes classes);
    Integer deleteById(long id);
}
