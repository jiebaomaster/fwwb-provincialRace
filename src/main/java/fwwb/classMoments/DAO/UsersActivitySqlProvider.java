package fwwb.classMoments.DAO;

import fwwb.classMoments.model.UsersActivity;
import org.apache.ibatis.jdbc.SQL;

public class UsersActivitySqlProvider {

    public String insertSelective(UsersActivity record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("users_activity");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getUsersId() != null) {
            sql.VALUES("users_id", "#{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getActivityId() != null) {
            sql.VALUES("activity_id", "#{activityId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(UsersActivity record) {
        SQL sql = new SQL();
        sql.UPDATE("users_activity");
        
        if (record.getUsersId() != null) {
            sql.SET("users_id = #{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getActivityId() != null) {
            sql.SET("activity_id = #{activityId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}