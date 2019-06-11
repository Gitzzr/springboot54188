package sb.java.springboot.defaultView;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class DefaultView implements WebMvcConfigurer {
	static boolean Dafa = false;
	@Autowired
    private LoginInterceptor loginInterceptor;
	
	
	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
	}
	
	// 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
			Dafa = true;
		  registry.addInterceptor(loginInterceptor)
		  .addPathPatterns("/**")
		  .excludePathPatterns("/customer/delete.action","/login","/register","/register.action","/customer/create.action","/customer/getCustomerById.action","/customer/update.action","/customer/list.action","/logout.action","/login.action","/css/**","/js/**","/fonts/**","/images/**");		 
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
}
