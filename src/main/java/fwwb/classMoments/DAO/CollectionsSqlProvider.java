package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Collections;
import org.apache.ibatis.jdbc.SQL;

public class CollectionsSqlProvider {

    public String insertSelective(Collections record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("collections");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getUsersId() != null) {
            sql.VALUES("users_id", "#{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getMomentId() != null) {
            sql.VALUES("moment_id", "#{momentId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateAt() != null) {
            sql.VALUES("create_at", "#{createAt,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Collections record) {
        SQL sql = new SQL();
        sql.UPDATE("collections");
        
        if (record.getUsersId() != null) {
            sql.SET("users_id = #{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getMomentId() != null) {
            sql.SET("moment_id = #{momentId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{createAt,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}