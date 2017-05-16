package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Students;
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
public interface StudentsMapper {
    @Delete({
        "delete from students",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into students (id, name, ",
        "student_num, sex, class_id, ",
        "school_id)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{studentNum,jdbcType=INTEGER}, #{sex,jdbcType=CHAR}, #{classId,jdbcType=INTEGER}, ",
        "#{schoolId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Students record);

    @InsertProvider(type=StudentsSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insertSelective(Students record);

    @Select({
        "select",
        "id, name, student_num, sex, class_id, school_id",
        "from students",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="student_num", property="studentNum", jdbcType=JdbcType.INTEGER),
        @Result(column="sex", property="sex", jdbcType=JdbcType.CHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="school_id", property="schoolId", jdbcType=JdbcType.INTEGER)
    })
    Students selectByPrimaryKey(Integer id);

    @UpdateProvider(type=StudentsSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Students record);

    @Update({
        "update students",
        "set name = #{name,jdbcType=VARCHAR},",
          "student_num = #{studentNum,jdbcType=INTEGER},",
          "sex = #{sex,jdbcType=CHAR},",
          "class_id = #{classId,jdbcType=INTEGER},",
          "school_id = #{schoolId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Students record);
}