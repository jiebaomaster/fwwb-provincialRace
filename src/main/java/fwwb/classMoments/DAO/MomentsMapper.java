package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Moments;
import fwwb.classMoments.model.MomentsModel;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface MomentsMapper {
    @Delete({
            "delete from moments",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into moments (create_time, ",
            "poster_id, class_id, ",
            "content, is_top, top_deadline)",
            "values (#{createTime,jdbcType=TIMESTAMP}, ",
            "#{posterId,jdbcType=INTEGER}, #{classId,jdbcType=INTEGER}, ",
            "#{content,jdbcType=VARCHAR}, #{isTop,jdbcType=BIT}, #{topDeadline,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    int insert(Moments record);

    @InsertProvider(type = MomentsSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(Moments record);

    @Select({
            "select",
            "id, create_time, poster_id, class_id, content, is_top, top_deadline",
            "from moments",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "poster_id", property = "poster_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "class_id", property = "classId", jdbcType = JdbcType.INTEGER),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "is_top", property = "isTop", jdbcType = JdbcType.BIT),
            @Result(column = "top_deadline", property = "topDeadline", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "id", property = "sources",
                    many = @Many(select = "fwwb.classMoments.DAO.SourceMapper.selectByInMomentId"))
    })
    MomentsModel selectByPrimaryKey(Integer id);

    @UpdateProvider(type = MomentsSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(MomentsModel record);

    @Update({
            "update moments",
            "set create_time = #{createTime,jdbcType=TIMESTAMP},",
            "poster_id = #{posterId,jdbcType=INTEGER},",
            "class_id = #{classId,jdbcType=INTEGER},",
            "content = #{content,jdbcType=VARCHAR},",
            "is_top = #{isTop,jdbcType=BIT},",
            "top_deadline = #{topDeadline,jdbcType=TIMESTAMP}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(MomentsModel record);

    @Select({
            "select",
            "id, create_time, poster_id, class_id, content, is_top, top_deadline",
            "from moments",
            "where poster_id = #{uid,jdbcType=INTEGER} and is_top = false",
            "order by create_time desc",
            "limit #{start,jdbcType=INTEGER},#{count,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "poster_id", property = "poster_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "class_id", property = "classId", jdbcType = JdbcType.INTEGER),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "is_top", property = "isTop", jdbcType = JdbcType.BIT),
            @Result(column = "top_deadline", property = "topDeadline", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "id", property = "sources",
                    many = @Many(select = "fwwb.classMoments.DAO.SourceMapper.selectByInMomentId"))
    })
    List<MomentsModel> selectMyMomentsByUid(@Param("uid") int uid, @Param("start") int start, @Param("count") int count);

    @Select({
            "select",
            "id, create_time, poster_id, class_id, content, is_top, top_deadline",
            "from moments",
            "where class_id = #{class_id,jdbcType=INTEGER} and is_top = false",
            "order by create_time desc",
            "limit #{start,jdbcType=INTEGER},#{count,jdbcType=INTEGER}"

    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "poster_id", property = "poster_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "class_id", property = "classId", jdbcType = JdbcType.INTEGER),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "is_top", property = "isTop", jdbcType = JdbcType.BIT),
            @Result(column = "top_deadline", property = "topDeadline", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "id", property = "sources",
                    many = @Many(select = "fwwb.classMoments.DAO.SourceMapper.selectByInMomentId"))
    })
    List<MomentsModel> selectClassMomentsByClassId(@Param("class_id") int class_id, @Param("start") int start, @Param("count") int count);


    @Select({
            "select",
            "id, create_time, poster_id, class_id, content, is_top, top_deadline",
            "from moments",
            "where class_id = #{class_id,jdbcType=INTEGER} and is_top = true and top_deadline > #{now,jdbcType=TIMESTAMP}",
            "order by create_time desc"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "create_time", property = "createTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "poster_id", property = "poster_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "class_id", property = "classId", jdbcType = JdbcType.INTEGER),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR),
            @Result(column = "is_top", property = "isTop", jdbcType = JdbcType.BIT),
            @Result(column = "top_deadline", property = "topDeadline", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "id", property = "sources",
                    many = @Many(select = "fwwb.classMoments.DAO.SourceMapper.selectByInMomentId"))
    })
    List<MomentsModel> selectTopsByClassId(@Param("class_id") int class_id, @Param("now") Timestamp now);
}