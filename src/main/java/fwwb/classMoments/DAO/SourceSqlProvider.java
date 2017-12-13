package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Source;
import org.apache.ibatis.jdbc.SQL;

public class SourceSqlProvider {

    public String insertSelective(Source record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("source");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getSurl() != null) {
            sql.VALUES("surl", "#{surl,jdbcType=VARCHAR}");
        }
        
        if (record.getStype() != null) {
            sql.VALUES("stype", "#{stype,jdbcType=CHAR}");
        }
        
        if (record.getInMomentId() != null) {
            sql.VALUES("in_moment_id", "#{inMomentId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Source record) {
        SQL sql = new SQL();
        sql.UPDATE("source");
        
        if (record.getSurl() != null) {
            sql.SET("surl = #{surl,jdbcType=VARCHAR}");
        }
        
        if (record.getStype() != null) {
            sql.SET("stype = #{stype,jdbcType=CHAR}");
        }
        
        if (record.getInMomentId() != null) {
            sql.SET("in_moment_id = #{inMomentId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}