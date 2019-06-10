package sb.java.springboot.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sb.java.springboot.dao.CustomerDao;
import sb.java.springboot.entity.Customer;
import sb.java.springboot.service.CustomerService;
import sb.java.springboot.utils.Page;

@Service("customerService")
@Transactional
public class CustomerServiceImp implements CustomerService {

	@Autowired
	private CustomerDao customerDao;
	/*
	 * 创建客户
	 */
	@Override
	public int createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}
	
	
	//客户列表
	@Override
	public Page<Customer> findCustomerList(Integer page, Integer rows, String custName, String custSource,
			String custIndustry, String custLevel) {
		
		//创建客户对象
		Customer customer = new Customer();
		//判断客户名称
		if(StringUtils.isNotBlank(custName)) {
			customer.setCust_name(custName);
		}
		//判断客户信息来源
		if(StringUtils.isNotBlank(custSource)) {
			customer.setCust_source(custSource);
		}
		//判断客户所属行业
		if(StringUtils.isNotBlank(custIndustry)) {
			customer.setCust_industry(custIndustry);
		}
		//判断客户级别
		if(StringUtils.isNotBlank(custLevel)) {
			customer.setCust_level(custLevel);
		}
		//当前页
		customer.setStart((page-1) * rows);
		//每页数
		customer.setRows(rows);
		//查询客户列表
		List<Customer> customers = customerDao.selectCustomerList(customer);
		//查询客户列表总记录数
		Integer count = customerDao.selectCustomerListCount(customer);
		//创建Page返回对象
		Page<Customer> result = new Page<>();
		result.setPage(page);
		result.setRows(customers);
		result.setSize(rows);
		result.setTotal(count);
		return result;
	}


	/*
	 * 通过id查询客户
	 * (non-Javadoc)
	 * @see sb.java.springboot.service.CustomerService#getCustomerById(java.lang.Integer)
	 */
	@Override
	public Customer getCustomerById(Integer id) {
		Customer customer = customerDao.getCustomerById(id);
		return customer;
	}


	/*
	 * 更新客户
	 * (non-Javadoc)
	 * @see sb.java.springboot.service.CustomerService#updateCustomer(sb.java.springboot.entity.Customer)
	 */
	@Override
	public int updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}


	/*
	 * 删除客户
	 * (non-Javadoc)
	 * @see sb.java.springboot.service.CustomerService#deleteCustomer(java.lang.Integer)
	 */
	@Override
	public int deleteCustomer(Integer id) {
		return customerDao.deleteCustomer(id);
	}

}
