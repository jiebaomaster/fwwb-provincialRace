package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Favor;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavorMapper {
    @Delete({
            "delete from favor",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into favor (id, users_id, ",
            "moment_id, create_at, ",
            "moment_user_id)",
            "values (#{id,jdbcType=INTEGER}, #{usersId,jdbcType=INTEGER}, ",
            "#{momentId,jdbcType=INTEGER}, #{createAt,jdbcType=TIMESTAMP}, ",
            "#{momentUserId,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insert(Favor record);

    @InsertProvider(type = FavorSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(Favor record);

    @Select({
            "select",
            "id, users_id, moment_id, create_at, moment_user_id",
            "from favor",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "moment_user_id", property = "momentUserId", jdbcType = JdbcType.INTEGER)
    })
    Favor selectByPrimaryKey(Integer id);

    @UpdateProvider(type = FavorSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Favor record);

    @Update({
            "update favor",
            "set users_id = #{usersId,jdbcType=INTEGER},",
            "moment_id = #{momentId,jdbcType=INTEGER},",
            "create_at = #{createAt,jdbcType=TIMESTAMP},",
            "moment_user_id = #{momentUserId,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Favor record);

    @Select({
            "select",
            "count(moment_id)",
            "from favor",
            "where moment_id = #{moment_id,jdbcType=INTEGER}"
    })
    int countLikeByMomentId(int moment_id);

    @Select({
            "select",
            "id, users_id, moment_id,create_at,moment_id",
            "from favor",
            "where users_id = #{usersId,jdbcType=INTEGER} and moment_id = #{momentId}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "moment_user_id", property = "momentUserId", jdbcType = JdbcType.INTEGER)
    })
    Favor selectByMomentIdUid(Favor favor);


    @Select({
            "select",
            "id, users_id, moment_id,create_at,moment_id",
            "from favor",
            "where moment_id = #{momentId}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "moment_user_id", property = "momentUserId", jdbcType = JdbcType.INTEGER)
    })
    List<Favor> selectByMomentId(int moment_id);

    @Select({
            "select",
            "id, users_id, moment_id,create_at,moment_id",
            "from favor",
            "where moment_user_id = #{uid,jdbcType=INTEGER}",
            "order by create_at desc",
            "limit #{start,jdbcType=INTEGER},#{count,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "moment_user_id", property = "momentUserId", jdbcType = JdbcType.INTEGER)
    })
    List<Favor> selectMomentFavorByUid(@Param("uid") int uid, @Param("start") int start, @Param("count") int count);

    @Delete({
            "delete from  favor",
            "where moment_id = #{moment_id,jdbcType=INTEGER}"
    })
    int deleteByMomentId(int moment_id);
}