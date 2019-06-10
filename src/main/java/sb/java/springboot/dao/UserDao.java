package sb.java.springboot.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import sb.java.springboot.entity.User;

public interface UserDao {

	// 查询账户和密码登录
	@Select("select * from sys_user where user_code = #{usercode} and user_password = #{password}")
	public User findUser(@Param("usercode") String usercode, @Param("password") String password);
	
	//增加用户
	@Insert("insert into sys_user(user_code,user_name,user_password,user_state) values (#{usercode},#{username},#{password},1)")
    public boolean insertUser(@Param("usercode") String usercode,@Param("username") String username, @Param("password") String password);
    
    
   //根据用户名查询
	@Select("select * from sys_user where user_code = #{usercode}")
    User findByUserCode(@Param("usercode") String usercode);

}
