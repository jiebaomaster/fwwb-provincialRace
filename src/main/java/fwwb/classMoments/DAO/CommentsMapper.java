package fwwb.classMoments.DAO;

import fwwb.classMoments.DTO.CommentDTO;
import fwwb.classMoments.model.Comments;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentsMapper {
    @Delete({
            "delete from comments",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into comments (poster_id, ",
            "reply_to, moment_id, ",
            "comment_time, content)",
            "values (#{posterId,jdbcType=INTEGER}, ",
            "#{replyTo,jdbcType=INTEGER}, #{momentId,jdbcType=INTEGER}, ",
            "#{commentTime,jdbcType=TIMESTAMP}, #{content,jdbcType=VARCHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = false, resultType = Integer.class)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Comments record);

    @InsertProvider(type = CommentsSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(Comments record);

    @Select({
            "select",
            "id, poster_id, reply_to, moment_id, comment_time, content",
            "from comments",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "poster_id", property = "posterId", jdbcType = JdbcType.INTEGER),
            @Result(column = "reply_to", property = "replyTo", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "comment_time", property = "commentTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR)
    })
    Comments selectByPrimaryKey(Integer id);

    @UpdateProvider(type = CommentsSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Comments record);

    @Update({
            "update comments",
            "set poster_id = #{posterId,jdbcType=INTEGER},",
            "reply_to = #{replyTo,jdbcType=INTEGER},",
            "moment_id = #{momentId,jdbcType=INTEGER},",
            "comment_time = #{commentTime,jdbcType=TIMESTAMP},",
            "content = #{content,jdbcType=VARCHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Comments record);

    @Select({
            "select",
            "count(moment_id)",
            "from comments",
            "where moment_id = #{moment_id,jdbcType=INTEGER}"
    })
    int countCommentByMomentId(int moment_id);

    @Select({
            "select",
            "id, poster_id, reply_to, moment_id, comment_time, content",
            "from comments",
            "where moment_id = #{moment_id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "poster_id", property = "posterId", jdbcType = JdbcType.INTEGER),
            @Result(column = "reply_to", property = "replyTo", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "comment_time", property = "commentTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR)
    })
    List<Comments> selectByMomentId(Integer id);

    @Select({
            "select",
            "c.id, c.poster_id, c.reply_to, c.moment_id, c.comment_time, c.content",
            "from comments c,moments m",
            "where c.moment_id=m.id and m.poster_id=#{uid,jdbcType=INTEGER}",
            "order by comment_time desc",
            "limit #{start,jdbcType=INTEGER},#{count,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "poster_id", property = "posterId", jdbcType = JdbcType.INTEGER),
            @Result(column = "reply_to", property = "replyTo", jdbcType = JdbcType.INTEGER),
            @Result(column = "moment_id", property = "momentId", jdbcType = JdbcType.INTEGER),
            @Result(column = "comment_time", property = "commentTime", jdbcType = JdbcType.TIMESTAMP),
            @Result(column = "content", property = "content", jdbcType = JdbcType.VARCHAR)
    })
    List<Comments> selectByUid(@Param("uid") Integer uid, @Param("start") Integer start, @Param("count") Integer count);

    @Delete({
            "delete from comments",
            "where moment_id = #{moment_id,jdbcType=INTEGER}"
    })
    int deleteByMomentId(int moment_id);
}