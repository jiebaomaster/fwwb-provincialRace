package fwwb.classMoments.DAO;

import fwwb.classMoments.model.HonorWall;
import org.apache.ibatis.jdbc.SQL;

public class HonorWallSqlProvider {

    public String insertSelective(HonorWall record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("honor_wall");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getUsersId() != null) {
            sql.VALUES("users_id", "#{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getMomentId() != null) {
            sql.VALUES("moment_id", "#{momentId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(HonorWall record) {
        SQL sql = new SQL();
        sql.UPDATE("honor_wall");
        
        if (record.getUsersId() != null) {
            sql.SET("users_id = #{usersId,jdbcType=INTEGER}");
        }
        
        if (record.getMomentId() != null) {
            sql.SET("moment_id = #{momentId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}