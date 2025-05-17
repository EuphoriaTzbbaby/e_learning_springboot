package tzb.mapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tzb.pojo.Config;

import java.util.List;

@Mapper
public interface ConfigMapper {
    @Select("SELECT configKey, configValue FROM config")
    List<Config> getAllConfigs();
}
