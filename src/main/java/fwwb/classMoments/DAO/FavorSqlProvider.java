package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Favor;
import org.apache.ibatis.jdbc.SQL;

public class FavorSqlProvider {

    public String insertSelective(Favor record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("favor");
        
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
        
        if (record.getMomentUserId() != null) {
            sql.VALUES("moment_user_id", "#{momentUserId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Favor record) {
        SQL sql = new SQL();
        sql.UPDATE("favor");
        
        if (record.getUsersId() != null) {
            sql.SET("users_id = #{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getMomentId() != null) {
            sql.SET("moment_id = #{momentId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateAt() != null) {
            sql.SET("create_at = #{createAt,jdbcType=TIMESTAMP}");
        }
        
        if (record.getMomentUserId() != null) {
            sql.SET("moment_user_id = #{momentUserId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}