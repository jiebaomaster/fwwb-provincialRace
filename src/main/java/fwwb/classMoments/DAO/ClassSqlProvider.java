package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Class;
import org.apache.ibatis.jdbc.SQL;

public class ClassSqlProvider {

    public String insertSelective(Class record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("class");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getClassNum() != null) {
            sql.VALUES("class_num", "#{classNum,jdbcType=INTEGER}");
        }
        
        if (record.getClassName() != null) {
            sql.VALUES("class_name", "#{className,jdbcType=VARCHAR}");
        }
        
        if (record.getSchoolId() != null) {
            sql.VALUES("school_id", "#{schoolId,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Class record) {
        SQL sql = new SQL();
        sql.UPDATE("class");
        
        if (record.getClassNum() != null) {
            sql.SET("class_num = #{classNum,jdbcType=INTEGER}");
        }
        
        if (record.getClassName() != null) {
            sql.SET("class_name = #{className,jdbcType=VARCHAR}");
        }
        
        if (record.getSchoolId() != null) {
            sql.SET("school_id = #{schoolId,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}