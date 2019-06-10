package sb.java.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sb.java.springboot.dao.BaseDicDao;
import sb.java.springboot.entity.BaseDict;
import sb.java.springboot.service.BaseDictService;

@Service("baseDictService")
public class BaseDictServiceImp implements BaseDictService {

	@Autowired
	private BaseDicDao baseDictDao;
	
	//根据类别代码查询数据字典
	public List<BaseDict> findBaseDictByTypeCode(String typecode) {
		
		return baseDictDao.selectBaseDictByTypeCode(typecode);
	}

}
