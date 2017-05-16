package fwwb.classMoments.DAO;

import fwwb.classMoments.DTO.SourceDTO;
import fwwb.classMoments.model.Source;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SourceMapper {
    @Delete({
        "delete from source",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into source (id, surl, ",
        "stype, in_moment_id)",
        "values (#{id,jdbcType=VARCHAR} #{surl,jdbcType=VARCHAR}, ",
        "#{stype,jdbcType=CHAR}, #{inMomentId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Source record);

    @Insert({
            "insert into source (surl, ",
            "stype, in_moment_id)",
            "values (#{surl,jdbcType=VARCHAR}, ",
            "#{stype,jdbcType=CHAR}, #{inMomentId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertGenerated(Source source);

    @InsertProvider(type=SourceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insertSelective(Source record);

    @Select({
        "select",
        "id, surl, stype, in_moment_id",
        "from source",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="surl", property="surl", jdbcType=JdbcType.VARCHAR),
        @Result(column="stype", property="stype", jdbcType=JdbcType.CHAR),
        @Result(column="in_moment_id", property="inMomentId", jdbcType=JdbcType.INTEGER)
    })
    Source selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SourceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Source record);

    @Update({
        "update source",
        "set surl = #{surl,jdbcType=VARCHAR},",
          "stype = #{stype,jdbcType=CHAR},",
          "in_moment_id = #{inMomentId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Source record);

    @Select({
            "select",
            "id, surl, stype, in_moment_id",
            "from source",
            "where in_moment_id = #{inMomentId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="surl", property="surl", jdbcType=JdbcType.VARCHAR),
            @Result(column="stype", property="stype", jdbcType=JdbcType.CHAR),
            @Result(column="in_moment_id", property="inMomentId", jdbcType=JdbcType.INTEGER)
    })
    List<Source> selectByInMomentId(int inMomentId);
}