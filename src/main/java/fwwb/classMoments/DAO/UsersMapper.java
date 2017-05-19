package fwwb.classMoments.DAO;

import fwwb.classMoments.DTO.TeacherUserDTO;
import fwwb.classMoments.DTO.UserDTO;
import fwwb.classMoments.DTO.UserWithChildDTO;
import fwwb.classMoments.model.Users;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersMapper {
    @Delete({
            "delete from users",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
            "insert into users (id, phone, ",
            "passwd, users_name, ",
            "users_type, class_id, ",
            "access_token, avatar_url, ",
            "background_url, have_red_flower, ",
            "sex)",
            "values (#{id,jdbcType=INTEGER}, #{phone,jdbcType=VARCHAR}, ",
            "#{passwd,jdbcType=VARCHAR}, #{usersName,jdbcType=VARCHAR}, ",
            "#{usersType,jdbcType=CHAR}, #{classId,jdbcType=INTEGER}, ",
            "#{accessToken,jdbcType=VARCHAR}, #{avatarUrl,jdbcType=VARCHAR}, ",
            "#{backgroundUrl,jdbcType=VARCHAR}, #{haveRedFlower,jdbcType=BIT}, ",
            "#{sex,jdbcType=CHAR})"
    })
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insert(Users record);

    @InsertProvider(type = UsersSqlProvider.class, method = "insertSelective")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id", before = true, resultType = Integer.class)
    int insertSelective(Users record);

    @Select({
            "select",
            "id, phone, passwd, users_name, users_type, class_id, access_token, avatar_url, ",
            "background_url, have_red_flower, sex",
            "from users",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "passwd", property = "passwd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "users_name", property = "usersName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "users_type", property = "usersType", jdbcType = JdbcType.CHAR),
            @Result(column = "class_id", property = "classId", jdbcType = JdbcType.INTEGER),
            @Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "avatar_url", property = "avatarUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "background_url", property = "backgroundUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "have_red_flower", property = "haveRedFlower", jdbcType = JdbcType.BIT),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.CHAR)
    })
    Users selectByPrimaryKey(Integer id);

    @UpdateProvider(type = UsersSqlProvider.class, method = "updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Users record);

    @Update({
            "update users",
            "set phone = #{phone,jdbcType=VARCHAR},",
            "passwd = #{passwd,jdbcType=VARCHAR},",
            "users_name = #{usersName,jdbcType=VARCHAR},",
            "users_type = #{usersType,jdbcType=CHAR},",
            "class_id = #{classId,jdbcType=INTEGER},",
            "access_token = #{accessToken,jdbcType=VARCHAR},",
            "avatar_url = #{avatarUrl,jdbcType=VARCHAR},",
            "background_url = #{backgroundUrl,jdbcType=VARCHAR},",
            "have_red_flower = #{haveRedFlower,jdbcType=BIT},",
            "sex = #{sex,jdbcType=CHAR}",
            "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Users record);

    @Select({
            "select",
            "id, phone, passwd, users_name, users_type, class_id, access_token, avatar_url, ",
            "background_url, have_red_flower",
            "from users",
            "where phone = #{phone,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "passwd", property = "passwd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "users_name", property = "usersName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "users_type", property = "usersType", jdbcType = JdbcType.CHAR),
            @Result(column = "class_id", property = "classId", jdbcType = JdbcType.INTEGER),
            @Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "avatar_url", property = "avatarUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "background_url", property = "backgroundUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "have_red_flower", property = "haveRedFlower", jdbcType = JdbcType.BIT),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.CHAR)
    })
    Users selectByPhone(String phone);

    @Select({
            "select",
            "id, phone, passwd, users_name, users_type, class_id, access_token, avatar_url, ",
            "background_url, have_red_flower",
            "from users",
            "where class_id = #{classId,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "id", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "phone", property = "phone", jdbcType = JdbcType.VARCHAR),
            @Result(column = "passwd", property = "passwd", jdbcType = JdbcType.VARCHAR),
            @Result(column = "users_name", property = "usersName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "users_type", property = "usersType", jdbcType = JdbcType.CHAR),
            @Result(column = "class_id", property = "classId", jdbcType = JdbcType.INTEGER),
            @Result(column = "access_token", property = "accessToken", jdbcType = JdbcType.VARCHAR),
            @Result(column = "avatar_url", property = "avatarUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "background_url", property = "backgroundUrl", jdbcType = JdbcType.VARCHAR),
            @Result(column = "have_red_flower", property = "haveRedFlower", jdbcType = JdbcType.BIT),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.CHAR)

    })
    List<Users> selectMembersByClassId(Users record);

    @Select({
            "select",
            "id, phone, users_name, users_type, class_id, avatar_url, ",
            "background_url, have_red_flower",
            "from users",
            "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column = "id", property = "uid", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "phone", property = "user_mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "users_name", property = "user_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "users_type", property = "user_type", jdbcType = JdbcType.CHAR),
            @Result(column = "class_id", property = "class_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "avatar_url", property = "avatar_url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "background_url", property = "background_url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "have_red_flower", property = "have_red_flower", jdbcType = JdbcType.BIT),
            @Result(column = "sex", property = "sex", jdbcType = JdbcType.CHAR)
    })
    UserDTO selectUserDTOByPrimaryKey(Integer id);

    @Select({
            "select",
            "u.id, u.phone, u.users_name, u.sex,u.class_id,u.avatar_url, u.background_url, u.have_red_flower,",
            "s.name,s.student_num,s.sex",
            "from users u,students s",
            "where u.class_id = #{class_id,jdbcType=INTEGER} and s.parent_id=u.id",
            "order by s.student_num"
    })
    @Results({
            @Result(column = "u.id", property = "uid", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "u.phone", property = "user_mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "u.users_name", property = "user_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "u.sex", property = "parent_sex", jdbcType = JdbcType.CHAR),
            @Result(column = "u.class_id", property = "class_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "u.avatar_url", property = "avatar_url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "u.background_url", property = "background_url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "u.have_red_flower", property = "have_red_flower", jdbcType = JdbcType.BIT),
            @Result(column = "s.name", property = "child_name", jdbcType = JdbcType.CHAR),
            @Result(column = "s.student_num", property = "child_no", jdbcType = JdbcType.CHAR),
            @Result(column = "s.sex", property = "child_sex", jdbcType = JdbcType.CHAR)
    })
    List<UserWithChildDTO> selectUserWithChildDTOByClassId(Users users);


    @Select({
            "select",
            "u.id, u.phone, u.users_name, u.sex, u.class_id, u.avatar_url, u.background_url,",
            "t.teacher_num,t.teacher_type",
            "background_url, have_red_flower",
            "from users u,teachers t",
            "where u.class_id = #{class_id,jdbcType=INTEGER} and t.user_id=u.id",
            "order by t.teacher_num"
    })
    @Results({
            @Result(column = "u.id", property = "uid", jdbcType = JdbcType.INTEGER, id = true),
            @Result(column = "u.phone", property = "user_mobile", jdbcType = JdbcType.VARCHAR),
            @Result(column = "u.users_name", property = "user_name", jdbcType = JdbcType.VARCHAR),
            @Result(column = "u.sex", property = "parent_sex", jdbcType = JdbcType.CHAR),
            @Result(column = "u.class_id", property = "class_id", jdbcType = JdbcType.INTEGER),
            @Result(column = "u.avatar_url", property = "avatar_url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "u.background_url", property = "background_url", jdbcType = JdbcType.VARCHAR),
            @Result(column = "t.teacher_num", property = "teacher_no", jdbcType = JdbcType.INTEGER),
            @Result(column = "t.teacher_type", property = "teacher_type", jdbcType = JdbcType.VARCHAR),
    })
    List<TeacherUserDTO> selectTeacherUserDTOByClassId(Users users);

    @Insert({
            "<script>",
            "insert into users (phone, users_name, class_id, sex)",
            "values ",
            "<foreach  collection='list' item='item' separator=','>",
            "( #{item.user_mobile,jdbcType=VARCHAR}, #{item.user_name,jdbcType=VARCHAR},#{item.class_id,jdbcType=INTEGER},#{item.parent_sex,jdbcType=VARCHAR})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertParentBatch(List<UserWithChildDTO> list);

    @Insert({
            "<script>",
            "insert into users (phone, users_name, class_id, sex)",
            "values ",
            "<foreach  collection='list' item='item' separator=','>",
            "( #{item.user_mobile,jdbcType=VARCHAR}, #{item.user_name,jdbcType=VARCHAR},#{item.class_id,jdbcType=INTEGER},#{item.sex,jdbcType=VARCHAR})",
            "</foreach>",
            "</script>"
    })
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertTeacherUserBatch(List<TeacherUserDTO> list);
}