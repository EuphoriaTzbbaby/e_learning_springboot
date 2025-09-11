// DeepSeekMapper.java
package tzb.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import tzb.pojo.DeepSeekConfig;

@Mapper
public interface DeepSeekMapper {

    @Select("SELECT configValue as apiKey FROM config WHERE id = 14")
    String getApiKeyById();

    @Select("SELECT configValue as apiKey FROM config WHERE configKey = '11'")
    String getApiKeyByKey();

    @Select("SELECT id, configValue as apiKey FROM config WHERE id = #{id}")
    DeepSeekConfig getConfigById(Integer id);
}
