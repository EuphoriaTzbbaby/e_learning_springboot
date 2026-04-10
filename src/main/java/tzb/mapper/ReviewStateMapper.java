package tzb.mapper;

import org.apache.ibatis.annotations.*;
import tzb.pojo.ReviewState;
import java.util.List;

@Mapper
public interface ReviewStateMapper {

    @Insert("INSERT INTO review_state(userId, egId, interval_days, repetitions, ef, last_review, next_review, createDate, updateDate) " +
            "VALUES(#{userId}, #{egId}, #{intervalDays}, #{repetitions}, #{ef}, #{lastReview}, #{nextReview}, #{createDate}, #{updateDate})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(ReviewState reviewState);

    @Select("SELECT * FROM review_state WHERE id = #{id}")
    ReviewState findById(@Param("id") long id);

    @Select("SELECT * FROM review_state WHERE userId = #{userId}")
    List<ReviewState> findByUserId(@Param("userId") long userId);

    @Select("SELECT * FROM review_state WHERE next_review <= NOW() AND userId = #{userId}")
    List<ReviewState> findDueReviews(@Param("userId") long userId);

    @Update("UPDATE review_state SET " +
            "interval_days=#{intervalDays}, repetitions=#{repetitions}, ef = #{ef}, " +
            "last_review=#{lastReview}, next_review=#{nextReview}, updateDate=#{updateDate}" +
            "WHERE id=#{id}")
    int update(ReviewState reviewState);

    @Delete("DELETE FROM review_state WHERE id = #{id}")
    int deleteById(@Param("id") long id);

    @Select("SELECT * FROM review_state")
    List<ReviewState> findAll();
}
