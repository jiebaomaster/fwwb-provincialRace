package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Push;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface PushMapper {
    @Delete({
            "delete from push",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into push (users_id, ",
            "uuid)",
            "values (#{usersId,jdbcType=INTEGER}, ",
            "#{uuid,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Push record);

    @InsertProvider(type = PushSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(Push record);

    @Select({
            "select",
            "id, users_id, uuid",
            "from push",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "uuid", property = "uuid", jdbcType = JdbcType.VARCHAR)
    })
    Push selectByPrimaryKey(Integer id);

    @UpdateProvider(type = PushSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Push record);

    @Update({
            "update push",
            "set users_id = #{usersId,jdbcType=INTEGER},",
            "uuid = #{uuid,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Push record);

    @Select({
            "select",
            "id, users_id, uuid",
            "from push",
            "where users_id = #{uid,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "uuid", property = "uuid", jdbcType = JdbcType.VARCHAR)
    })
    Push selectByUid(Integer uid);
}