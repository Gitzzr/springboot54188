package sb.java.springboot.service;

import sb.java.springboot.entity.User;

public interface UserService {
	
	// 查询账户和密码登录
	public User findUser(String usercode, String password);
	
	 //增加用户
	public boolean insertUser(String usercode, String username, String password);
    
    //根据用户名查询
    public User findByUserCode(String usercode);
	
}
