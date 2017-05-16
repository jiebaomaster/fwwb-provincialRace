package fwwb.classMoments.DAO;

import fwwb.classMoments.model.UsersActivity;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersActivityMapper {
    @Delete({
            "delete from users_activity",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into users_activity ( users_id, ",
            "activity_id)",
            "values ( #{usersId,jdbcType=INTEGER}, ",
            "#{activityId,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(UsersActivity record);

    @InsertProvider(type = UsersActivitySqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(UsersActivity record);

    @Select({
            "select",
            "id, users_id, activity_id",
            "from users_activity",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "activity_id", property = "activityId", jdbcType = JdbcType.INTEGER)
    })
    UsersActivity selectByPrimaryKey(Integer id);

    @UpdateProvider(type = UsersActivitySqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UsersActivity record);

    @Update({
            "update users_activity",
            "set users_id = #{usersId,jdbcType=INTEGER},",
            "activity_id = #{activityId,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UsersActivity record);

    @Delete({
            "delete from users_activity",
            "where users_id = #{usersId,jdbcType=INTEGER} and activity_id=#{activityId,jdbcType=INTEGER}"
    })
    int deleteByObj(UsersActivity usersActivity);

    @Select({
            "select",
            "id, users_id, activity_id",
            "from users_activity",
            "where activity_id = #{activity_id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "activity_id", property = "activityId", jdbcType = JdbcType.INTEGER)
    })
    List<UsersActivity> selectByActivityId(int activity_id);
}