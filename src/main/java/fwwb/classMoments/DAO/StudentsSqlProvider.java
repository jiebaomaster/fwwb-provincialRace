package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Students;
import org.apache.ibatis.jdbc.SQL;

public class StudentsSqlProvider {

    public String insertSelective(Students record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("students");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentNum() != null) {
            sql.VALUES("student_num", "#{studentNum,jdbcType=INTEGER}");
        }
        
        if (record.getSex() != null) {
            sql.VALUES("sex", "#{sex,jdbcType=CHAR}");
        }
        
        if (record.getClassId() != null) {
            sql.VALUES("class_id", "#{classId,jdbcType=INTEGER}");
        }
        
        if (record.getSchoolId() != null) {
            sql.VALUES("school_id", "#{schoolId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Students record) {
        SQL sql = new SQL();
        sql.UPDATE("students");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getStudentNum() != null) {
            sql.SET("student_num = #{studentNum,jdbcType=INTEGER}");
        }
        
        if (record.getSex() != null) {
            sql.SET("sex = #{sex,jdbcType=CHAR}");
        }
        
        if (record.getClassId() != null) {
            sql.SET("class_id = #{classId,jdbcType=INTEGER}");
        }
        
        if (record.getSchoolId() != null) {
            sql.SET("school_id = #{schoolId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}