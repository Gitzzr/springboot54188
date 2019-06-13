package sb.java.springboot.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import sb.java.springboot.entity.User;
import sb.java.springboot.service.UserService;

@Controller
@RequestMapping("/customer")
public class UserController {

	@Autowired
	private UserService userService;

//	@RequestMapping("login")
//	public String toLogin() {
//		return "login";
//	}

	
	/*/
	 * 用户登录
	 */
	@RequestMapping(value = "/login.action") 
	public String login(String usercode, String password, Model model, HttpSession session) {

		// 通过账号和密码查询用户
		User user = userService.findUser(usercode, password);
		if (user != null) {
			// 将用户添加到sessionuser
			session.setAttribute("USER_SESSION", user);
			// 跳转到主页面
			return "redirect:/customer/list.action";
		}
		model.addAttribute("msg", "账号密码错误，请重新输入！");
		// 返回登录页面
		return "login";
	}

	@RequestMapping("register")
	public String toRegister() {
		return "register";
	}

	/**
     * 用户注册
     */
    @RequestMapping(value="/register.action")
    public String register(User user, Map<String,Object> map) {
    	User user_code = userService.findByUserCode(user.getUser_code());
    	
    	System.out.println("user_code="+user_code);
    	if(user_code == null) {
    		userService.insertUser(user.getUser_code(), user.getUser_name(), user.getUser_password());
        	map.put("msg", "注册成功！");
    		return "success";
    	}
    	map.put("msg","该账户已经存在，请重新注册！");
		return "register";
    	
    	
        
//        if (userService.findByUserCode(usercode) == null) {
//            // 添加用户
//            userService.register(user);
//            //添加成功，跳转到登录页面
//            return "success.jsp";
//        }
//        // 注册失败跳转到错误页面
//        model.addAttribute("msg","该账户已经存在，请重新注册！");
//		return "register";
		
    }
    
   
    /*
     * 用户退出登录
     */
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session) {
    	
    	//清除Session
    	session.invalidate();
    	//重定向到登录页面的跳转方法
		return "redirect:customer/login";
    }
    
}
