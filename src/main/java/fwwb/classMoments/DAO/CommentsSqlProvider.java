package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Comments;
import org.apache.ibatis.jdbc.SQL;

public class CommentsSqlProvider {

    public String insertSelective(Comments record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("comments");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getPosterId() != null) {
            sql.VALUES("poster_id", "#{posterId,jdbcType=INTEGER}");
        }
        
        if (record.getReplyTo() != null) {
            sql.VALUES("reply_to", "#{replyTo,jdbcType=INTEGER}");
        }
        
        if (record.getMomentId() != null) {
            sql.VALUES("moment_id", "#{momentId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentTime() != null) {
            sql.VALUES("comment_time", "#{commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.VALUES("content", "#{content,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Comments record) {
        SQL sql = new SQL();
        sql.UPDATE("comments");
        
        if (record.getPosterId() != null) {
            sql.SET("poster_id = #{posterId,jdbcType=INTEGER}");
        }
        
        if (record.getReplyTo() != null) {
            sql.SET("reply_to = #{replyTo,jdbcType=INTEGER}");
        }
        
        if (record.getMomentId() != null) {
            sql.SET("moment_id = #{momentId,jdbcType=INTEGER}");
        }
        
        if (record.getCommentTime() != null) {
            sql.SET("comment_time = #{commentTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getContent() != null) {
            sql.SET("content = #{content,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}