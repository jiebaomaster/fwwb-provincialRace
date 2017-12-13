package fwwb.classMoments.DAO;

import fwwb.classMoments.DTO.TeacherUserDTO;
import fwwb.classMoments.model.Teachers;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeachersMapper {
    @Delete({
        "delete from teachers",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into teachers (id, teacher_num, ",
        "teacher_type, class_id, ",
        "user_id)",
        "values (#{id,jdbcType=INTEGER}, #{teacherNum,jdbcType=INTEGER}, ",
        "#{teacherType,jdbcType=CHAR}, #{classId,jdbcType=INTEGER}, ",
        "#{userId,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insert(Teachers record);

    @InsertProvider(type=TeachersSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=true, resultType=Integer.class)
    int insertSelective(Teachers record);

    @Select({
        "select",
        "id, teacher_num, teacher_type, class_id, user_id",
        "from teachers",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="teacher_num", property="teacherNum", jdbcType=JdbcType.INTEGER),
        @Result(column="teacher_type", property="teacherType", jdbcType=JdbcType.CHAR),
        @Result(column="class_id", property="classId", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER)
    })
    Teachers selectByPrimaryKey(Integer id);

    @UpdateProvider(type=TeachersSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Teachers record);

    @Update({
        "update teachers",
        "set teacher_num = #{teacherNum,jdbcType=INTEGER},",
          "teacher_type = #{teacherType,jdbcType=CHAR},",
          "class_id = #{classId,jdbcType=INTEGER},",
          "user_id = #{userId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Teachers record);

    @Insert({
            "<script>",
            "insert into teachers (teacher_num, teacher_type, user_id, class_id)",
            "values ",
            "<foreach  collection='list' item='item' separator=','>",
            "(#{item.teacher_no,jdbcType=INTEGER},#{item.teacher_type,jdbcType=VARCHAR},#{item.id,jdbcType=INTEGER},#{item.class_id,jdbcType=INTEGER})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true)
    int insertTeacherBatch(List<TeacherUserDTO> list);
}