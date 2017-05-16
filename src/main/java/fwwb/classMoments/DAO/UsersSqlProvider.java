package fwwb.classMoments.DAO;

import fwwb.classMoments.model.Users;
import org.apache.ibatis.jdbc.SQL;

public class UsersSqlProvider {

    public String insertSelective(Users record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("users");
        
        sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPasswd() != null) {
            sql.VALUES("passwd", "#{passwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUsersName() != null) {
            sql.VALUES("users_name", "#{usersName,jdbcType=VARCHAR}");
        }
        
        if (record.getUsersType() != null) {
            sql.VALUES("users_type", "#{usersType,jdbcType=CHAR}");
        }
        
        if (record.getClassId() != null) {
            sql.VALUES("class_id", "#{classId,jdbcType=INTEGER}");
        }
        
        if (record.getAccessToken() != null) {
            sql.VALUES("access_token", "#{accessToken,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarUrl() != null) {
            sql.VALUES("avatar_url", "#{avatarUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBackgroundUrl() != null) {
            sql.VALUES("background_url", "#{backgroundUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getHaveRedFlower() != null) {
            sql.VALUES("have_red_flower", "#{haveRedFlower,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Users record) {
        SQL sql = new SQL();
        sql.UPDATE("users");
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=VARCHAR}");
        }
        
        if (record.getPasswd() != null) {
            sql.SET("passwd = #{passwd,jdbcType=VARCHAR}");
        }
        
        if (record.getUsersName() != null) {
            sql.SET("users_name = #{usersName,jdbcType=VARCHAR}");
        }
        
        if (record.getUsersType() != null) {
            sql.SET("users_type = #{usersType,jdbcType=CHAR}");
        }
        
        if (record.getClassId() != null) {
            sql.SET("class_id = #{classId,jdbcType=INTEGER}");
        }
        
        if (record.getAccessToken() != null) {
            sql.SET("access_token = #{accessToken,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatarUrl() != null) {
            sql.SET("avatar_url = #{avatarUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getBackgroundUrl() != null) {
            sql.SET("background_url = #{backgroundUrl,jdbcType=VARCHAR}");
        }
        
        if (record.getHaveRedFlower() != null) {
            sql.SET("have_red_flower = #{haveRedFlower,jdbcType=BIT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }
}