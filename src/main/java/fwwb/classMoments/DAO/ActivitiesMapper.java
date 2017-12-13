package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Activities;
import fwwb.classMoments.model.ActivityModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActivitiesMapper {
    @Delete({
            "delete from activities",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into activities (poster_id, ",
            "create_time, content, class_id) ",
            "values (#{posterId,jdbcType=INTEGER}, ",
            "#{createTime,jdbcType=TIMESTAMP}, #{content,jdbcType=VARCHAR}, ",
            "#{classId,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(Activities record);

    @InsertProvider(type = ActivitiesSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(Activities record);

    @Select({
            "select",
            "id, poster_id, create_time, content, class_id",
            "from activities",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "poster_id", property = "posterId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "class_id", property = "classId", jdbcType = JdbcType.INTEGER)
    })
    Activities selectByPrimaryKey(Integer id);

    @UpdateProvider(type = ActivitiesSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Activities record);

    @Update({
            "update activities",
            "set poster_id = #{posterId,jdbcType=INTEGER},",
            "create_time = #{createTime,jdbcType=TIMESTAMP},",
            "content = #{content,jdbcType=VARCHAR},",
            "class_id = #{classId,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Activities record);

    @Select({
            "select",
            "id, poster_id, create_time, content",
            "from activities",
            "where id = #{activity_id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "poster_id", property = "posterId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "id", property = "usersActivityList",
                    many = @Many(select = "fwwb.classMoments.DAO.UsersActivityMapper.selectByActivityId"))
    })
    ActivityModel getActivityModelById(int activity_id);

    @Select({
            "select",
            "id, poster_id, create_time, content",
            "from activities",
            "where class_id = #{class_id,jdbcType=INTEGER}",
            "order by create_time desc",
            "limit #{start,jdbcType=INTEGER},#{count,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "poster_id", property = "posterId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "id", property = "usersActivityList",
                    many = @Many(select = "fwwb.classMoments.DAO.UsersActivityMapper.selectByActivityId"))
    })
    List<ActivityModel> selectClassActivitiesByClassId(@Param("class_id") int class_id, @Param("start") int start, @Param("count") int count);

}