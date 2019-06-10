package sb.java.springboot.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sb.java.springboot.dao.UserDao;
import sb.java.springboot.entity.User;
import sb.java.springboot.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImp implements UserService {

	//注入UserDao
	@Autowired
	private UserDao userDao;
	
	//通过账号和密码查询用户
	@Override
	public User findUser(String usercode, String password) {
		User user = this.userDao.findUser(usercode, password);
		return user;
	}


	@Override
	public User findByUserCode(String usercode) {
		return userDao.findByUserCode(usercode);
	}

	@Override
	public boolean insertUser(String usercode, String username, String password) {
		userDao.insertUser(usercode, username, password);
		return true;
	}

}
