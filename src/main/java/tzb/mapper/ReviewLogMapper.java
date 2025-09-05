package tzb.mapper;
import org.apache.ibatis.annotations.*;
import tzb.pojo.ReviewLog;
import java.util.List;
@Mapper
public interface ReviewLogMapper {
    @Insert("INSERT INTO review_log(userId, egId, score, last_review) " +
            "VALUES(#{userId}, #{egId}, #{score}, #{lastReview})")
    @Options(useGeneratedKeys = true, keyProperty = "logId")
    int insert(ReviewLog reviewLog);
    @Delete("DELETE FROM review_log WHERE logId = #{logId}")
    int deleteById(Long logId);
    @Update("UPDATE review_log SET userId = #{userId}, egId = #{egId}, " +
            "score = #{score}, last_review = #{lastReview} " +
            "WHERE logId = #{logId}")
    int update(ReviewLog reviewLog);
    @Select("SELECT * FROM review_log WHERE userId = #{userId}")
    ReviewLog selectById(Long userId);
    @Select("SELECT * FROM review_log")
    List<ReviewLog> selectAll();
}