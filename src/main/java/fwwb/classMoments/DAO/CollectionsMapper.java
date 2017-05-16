package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Collections;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectionsMapper {
    @Delete({
            "delete from collections",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into collections (users_id, ",
            "moment_id, create_at)",
            "values (#{usersId,jdbcType=INTEGER}, ",
            "#{momentId,jdbcType=INTEGER}, #{createAt,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Collections record);

    @InsertProvider(type = CollectionsSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(Collections record);

    @Select({
            "select",
            "id, users_id, moment_id, create_at",
            "from collections",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "create_at", property = "createAt", jdbcType = JdbcType.TIMESTAMP)
    })
    Collections selectByPrimaryKey(Integer id);

    @UpdateProvider(type = CollectionsSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Collections record);

    @Update({
            "update collections",
            "set users_id = #{usersId,jdbcType=INTEGER},",
            "moment_id = #{momentId,jdbcType=INTEGER},",
            "create_at = #{createAt,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Collections record);

    @Select({
            "select",
            "m.id",
            "from  collections c,moments m",
            "where c.moment_id=m.id or m.users_id=#{uid,jdbcType=INTEGER}",
            "order by m.create_time desc",
            "limit #{start,jdbcType=INTEGER},#{count,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "m.id", property = "id", jdbcType = JdbcType.INTEGER, id = true)
    })
    List<Integer> selectMomentIdByUid(@Param("uid") int uid, @Param("start") int start, @Param("count") int count);

    @Delete({
            "delete from collections",
            "where moment_id = #{moment_id,jdbcType=INTEGER}"
    })
    int deleteByMomentId(int moment_id);
}