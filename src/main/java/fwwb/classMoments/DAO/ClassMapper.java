package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Class;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassMapper {
    @Delete({
        "delete from class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into class (id, class_num, ",
        "class_name, school_id, ",
        "description)",
        "values (#{id,jdbcType=INTEGER}, #{classNum,jdbcType=INTEGER}, ",
        "#{className,jdbcType=VARCHAR}, #{schoolId,jdbcType=INTEGER}, ",
        "#{description,jdbcType=VARCHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Class record);

    @InsertProvider(type=ClassSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insertSelective(Class record);

    @Select({
        "select",
        "id, class_num, class_name, school_id, description",
        "from class",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="class_num", property="classNum", jdbcType=JdbcType.INTEGER),
        @Result(column="class_name", property="className", jdbcType=JdbcType.VARCHAR),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER),
        @Result(column="description", property="description", jdbcType=JdbcType.VARCHAR)
    })
    Class selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ClassSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Class record);

    @Update({
        "update class",
        "set class_num = #{classNum,jdbcType=INTEGER},",
          "class_name = #{className,jdbcType=VARCHAR},",
          "school_id = #{schoolId,jdbcType=INTEGER},",
          "description = #{description,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Class record);
}