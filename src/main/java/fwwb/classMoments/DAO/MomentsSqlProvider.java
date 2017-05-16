package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Moments;
import fwwb.classMoments.model.MomentsModel;
import org.apache.ibatis.jdbc.SQL;

public class MomentsSqlProvider {

    public String insertSelective(Moments record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("moments");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPosterId() != null) {
            sql.VALUES("poster_id", "#{posterId,jdbcType=INTEGER}");
        }
        
        if (record.getClassId() != null) {
            sql.VALUES("class_id", "#{classId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        if (record.getIsTop() != null) {
            sql.VALUES("is_top", "#{isTop,jdbcType=BIT}");
        }
        
        if (record.getTopDeadline() != null) {
            sql.VALUES("top_deadline", "#{topDeadline,jdbcType=TIMESTAMP}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Moments record) {
        SQL sql = new SQL();
        sql.UPDATE("moments");
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getPosterId() != null) {
            sql.SET("poster_id = #{posterId,jdbcType=INTEGER}");
        }
        
        if (record.getClassId() != null) {
            sql.SET("class_id = #{classId,jdbcType=INTEGER}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        if (record.getIsTop() != null) {
            sql.SET("is_top = #{isTop,jdbcType=BIT}");
        }
        
        if (record.getTopDeadline() != null) {
            sql.SET("top_deadline = #{topDeadline,jdbcType=TIMESTAMP}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}