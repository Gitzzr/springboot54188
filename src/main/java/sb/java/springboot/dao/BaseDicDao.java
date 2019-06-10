package sb.java.springboot.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import sb.java.springboot.entity.BaseDict;

/*
 * 数据字典
 */
public interface BaseDicDao {
	
	//根据类别代码查询数据字典
	@Select("select * from base_dict where dict_type_code = #{typecode}")
	public List<BaseDict> selectBaseDictByTypeCode(String typecode);
	
}
