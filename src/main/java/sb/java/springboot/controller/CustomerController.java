package sb.java.springboot.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import sb.java.springboot.entity.BaseDict;
import sb.java.springboot.entity.Customer;
import sb.java.springboot.entity.User;
import sb.java.springboot.service.BaseDictService;
import sb.java.springboot.service.CustomerService;
import sb.java.springboot.utils.Page;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private BaseDictService baseDictService;
	
	
	//客户来源
	@Value("${customer.from.type}")
	private String FROM_TYPR;
	
	//客户所属行业
	@Value("${customer.industry.type}")
	private String INDUSTRY_TYPE;
	
	//客户级别
	@Value("${customer.level.type}")
	private String LEVEL_TYPE;
	
	/*
	 * 客户列表
	 */
	@RequestMapping(value = "/list.action")
	public String list(@RequestParam(defaultValue="1") Integer page, @RequestParam(defaultValue="10") Integer rows, 
						String custName, String custSource, String custIndustry, String custLevel, Model model) {
		
		
		//条件查询所有客户
		Page<Customer> customers = customerService.findCustomerList(page, rows, custName, custSource, custIndustry, custLevel);
		model.addAttribute("page", customers);
		//客户来源
		List<BaseDict> fromType = baseDictService.findBaseDictByTypeCode(FROM_TYPR);
		//客户所属行业
		List<BaseDict> industryType = baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);
		//客户级别
		List<BaseDict> levelType = baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);
		
		//添加参数
		model.addAttribute("fromType", fromType);
		model.addAttribute("industryType", industryType);
		model.addAttribute("levelType", levelType);
		model.addAttribute("custName", custName);
		model.addAttribute("custSource", custSource);
		model.addAttribute("custIndustry", custIndustry);
		model.addAttribute("custLevel", custLevel);
		
		return "customer"; 
		
	}
	
	
	
	/*
	 * 创建客户
	 */
	@RequestMapping(value = "/create.action")
	@ResponseBody
	public String customerCreate(Customer customer, HttpSession session) {
		//获取Session中的当前用户信息
		User user = (User) session.getAttribute("USER_SESSION");
		//将当前用户id存储在客户对象中
		customer.setCust_create_id(user.getUser_id());
		//创建Date对象
		Date date = new Date();
		//得到一个Timestamp格式的时间,存入mysql中的时间格式"yyyy/MM/dd HH:mm:ss"
		Timestamp timestamp = new Timestamp(date.getTime());
		customer.setCust_createtime(timestamp);
		//执行Service层中的创建方法，返回的是受影响的行数
		int row = customerService.createCustomer(customer);
		if(row > 0) {
			return "OK";
		}else {
			return "FALL";
		}

	}
	
	
	/*
	 * 通过id获取客户信息
	 */
	@RequestMapping("/getCustomerById.action")
	@ResponseBody
	public Customer getCustomerById(Integer id) {
		Customer customer = customerService.getCustomerById(id);
		return customer;
	}
	
	/*
	 * 更新客户
	 */
	@RequestMapping("/update.action")
	@ResponseBody
	public String customerUpdate(Customer customer) {
		int rows = customerService.updateCustomer(customer);
		if(rows > 0) {
			return "OK";
		}else {
			return "FALL";
		}
	}
	
	/*
	 * 删除客户
	 */
	@RequestMapping("/delete.action")
	@ResponseBody
	public String customerDelete(Integer id) {
		int rows = customerService.deleteCustomer(id);
		if(rows > 0) {
			return "OK";
		}else {
			return "FALL";
		}
	}
	
}



