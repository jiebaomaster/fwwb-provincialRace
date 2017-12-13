package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Activities;
import org.apache.ibatis.jdbc.SQL;

public class ActivitiesSqlProvider {

    public String insertSelective(Activities record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("activities");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getPosterId() != null) {
            sql.VALUES("poster_id", "#{posterId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getClassId() != null) {
            sql.VALUES("class_id", "#{classId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Activities record) {
        SQL sql = new SQL();
        sql.UPDATE("activities");
        
        if (record.getPosterId() != null) {
            sql.SET("poster_id = #{posterId,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getClassId() != null) {
            sql.SET("class_id = #{classId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }


}