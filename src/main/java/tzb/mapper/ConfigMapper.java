package tzb.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tzb.pojo.Config;

import java.util.List;

@Mapper
public interface ConfigMapper {
    @Select("SELECT * FROM config")
    List<Config> getAllConfigs();
    @Select("select * from config where id = #{id}")
    Config getConfigById(int id);
}
