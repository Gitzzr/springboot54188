package sb.java.springboot.service;

import java.util.List;

import sb.java.springboot.entity.BaseDict;

/*
 * 数据字典Service字典
 */
public interface BaseDictService {
	
	//根据类别代码查询数据字典
	public List<BaseDict> findBaseDictByTypeCode(String typecode);
}
