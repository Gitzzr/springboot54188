package sb.java.springboot.entity;

import java.io.Serializable;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 * 数据字典持久化类
 */
public class BaseDict implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
//	@Column(name="dict_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String dict_id; //数据字典id
	
//	@Column(name="dict_type_code")
	private String dict_type_code; //数据字典类别代码
	
//	@Column(name="dict_type_name")
	private String dict_type_name; //数据字典类别名称
	
//	@Column(name="dict_item_name")
	private String dict_item_name; //数据字典项目名称
	
//	@Column(name="dict_item_code")
	private String dict_item_code; //数据字典项目代码(可为空)
	
//	@Column(name="dict_sort")
	private Integer dict_sort; //排序字段
	
//	@Column(name="dict_enable")
	private String dict_enable; //1:使用 0:停用
	
//	@Column(name="dict_memo")
	private String dict_memo; //备注

	public String getDict_id() {
		return dict_id;
	}

	public void setDict_id(String dict_id) {
		this.dict_id = dict_id;
	}

	public String getDict_type_code() {
		return dict_type_code;
	}

	public void setDict_type_code(String dict_type_code) {
		this.dict_type_code = dict_type_code;
	}

	public String getDict_type_name() {
		return dict_type_name;
	}

	public void setDict_type_name(String dict_type_name) {
		this.dict_type_name = dict_type_name;
	}

	public String getDict_item_name() {
		return dict_item_name;
	}

	public void setDict_item_name(String dict_item_name) {
		this.dict_item_name = dict_item_name;
	}

	public String getDict_item_code() {
		return dict_item_code;
	}

	public void setDict_item_code(String dict_item_code) {
		this.dict_item_code = dict_item_code;
	}

	public Integer getDict_sort() {
		return dict_sort;
	}

	public void setDict_sort(Integer dict_sort) {
		this.dict_sort = dict_sort;
	}

	public String getDict_enable() {
		return dict_enable;
	}

	public void setDict_enable(String dict_enable) {
		this.dict_enable = dict_enable;
	}

	public String getDict_memo() {
		return dict_memo;
	}

	public void setDict_memo(String dict_memo) {
		this.dict_memo = dict_memo;
	}

	@Override
	public String toString() {
		return "BaseDict [dict_id=" + dict_id + ", dict_type_code=" + dict_type_code + ", dict_type_name="
				+ dict_type_name + ", dict_item_name=" + dict_item_name + ", dict_item_code=" + dict_item_code
				+ ", dict_sort=" + dict_sort + ", dict_enable=" + dict_enable + ", dict_memo=" + dict_memo + "]";
	}
}
