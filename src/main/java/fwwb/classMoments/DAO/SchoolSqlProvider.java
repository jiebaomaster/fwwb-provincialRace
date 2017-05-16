package fwwb.classMoments.DAO;

import fwwb.classMoments.model.School;
import org.apache.ibatis.jdbc.SQL;

public class SchoolSqlProvider {

    public String insertSelective(School record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("school");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getSchoolName() != null) {
            sql.VALUES("school_name", "#{schoolName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(School record) {
        SQL sql = new SQL();
        sql.UPDATE("school");
        
        if (record.getSchoolName() != null) {
            sql.SET("school_name = #{schoolName,jdbcType=VARCHAR}");
        }
        
        if (record.getDescription() != null) {
            sql.SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}