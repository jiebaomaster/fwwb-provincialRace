package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Teachers;
import org.apache.ibatis.jdbc.SQL;

public class TeachersSqlProvider {

    public String insertSelective(Teachers record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("teachers");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getTeacherNum() != null) {
            sql.VALUES("teacher_num", "#{teacherNum,jdbcType=INTEGER}");
        }
        
        if (record.getTeacherType() != null) {
            sql.VALUES("teacher_type", "#{teacherType,jdbcType=CHAR}");
        }
        
        if (record.getClassId() != null) {
            sql.VALUES("class_id", "#{classId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.VALUES("user_id", "#{userId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Teachers record) {
        SQL sql = new SQL();
        sql.UPDATE("teachers");
        
        if (record.getTeacherNum() != null) {
            sql.SET("teacher_num = #{teacherNum,jdbcType=INTEGER}");
        }
        
        if (record.getTeacherType() != null) {
            sql.SET("teacher_type = #{teacherType,jdbcType=CHAR}");
        }
        
        if (record.getClassId() != null) {
            sql.SET("class_id = #{classId,jdbcType=INTEGER}");
        }
        
        if (record.getUserId() != null) {
            sql.SET("user_id = #{userId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}