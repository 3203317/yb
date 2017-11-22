package net.abc.yyy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import net.abc.yyy.model.User;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Mapper
public interface UserMapper {

	@Select("select * from s_user where user_name = #{user_name}")
	User getByName(@Param("user_name") String user_name);

}
