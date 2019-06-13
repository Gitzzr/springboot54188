package sb.java.springboot.defaultView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import sb.java.springboot.entity.User;

@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		if (url.indexOf("/login") >= 0) {
			return true;
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("USER_SESSION");
		if (user != null) {
			//request.getRequestDispatcher("/WEB-INF/jsp/customer.jsp").forward(request, response);
			return true;
		}
		
			request.setAttribute("msg", "您还没有登录, 请先登录!");
		
//		request.setAttribute("msg", "您还没有登录, 请先登录!");
		request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
		return false;
	}
}
