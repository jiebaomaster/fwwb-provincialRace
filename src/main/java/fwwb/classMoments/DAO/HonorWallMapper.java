package fwwb.classMoments.DAO;

import fwwb.classMoments.model.HonorWall;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HonorWallMapper {
    @Delete({
            "delete from honor_wall",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into honor_wall (users_id, ",
            "moment_id)",
            "values (#{usersId,jdbcType=INTEGER}, ",
            "#{momentId,jdbcType=INTEGER})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(HonorWall record);

    @InsertProvider(type = HonorWallSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(HonorWall record);

    @Select({
            "select",
            "id, users_id, moment_id",
            "from honor_wall",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "users_id", property = "usersId", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER)
    })
    HonorWall selectByPrimaryKey(Integer id);

    @UpdateProvider(type = HonorWallSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(HonorWall record);

    @Update({
            "update honor_wall",
            "set users_id = #{usersId,jdbcType=INTEGER},",
            "moment_id = #{momentId,jdbcType=INTEGER}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(HonorWall record);

    @Select({
            "select",
            "m.id",
            "from honor_wall hw,moments m",
            "where hw.moment_id=m.id and hw.users_id=#{uid,jdbcType=INTEGER} and m.is_top = false",
            "order by m.create_time desc",
            "limit #{start,jdbcType=INTEGER},#{count,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "m.id", property = "id", jdbcType = JdbcType.INTEGER, id = true)
    })
    List<Integer> selectMomentIdByUid(@Param("uid") int uid, @Param("start") int start, @Param("count") int count);

    @Delete({
            "delete from honor_wall",
            "where moment_id = #{moment_id,jdbcType=INTEGER}"
    })
    int deleteByMomentId(int moment_id);
}