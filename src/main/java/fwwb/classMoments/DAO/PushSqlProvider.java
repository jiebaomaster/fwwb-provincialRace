package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Push;
import org.apache.ibatis.jdbc.SQL;

public class PushSqlProvider {

    public String insertSelective(Push record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("push");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getUsersId() != null) {
            sql.VALUES("users_id", "#{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getUuid() != null) {
            sql.VALUES("uuid", "#{uuid,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Push record) {
        SQL sql = new SQL();
        sql.UPDATE("push");
        
        if (record.getUsersId() != null) {
            sql.SET("users_id = #{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getUuid() != null) {
            sql.SET("uuid = #{uuid,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}