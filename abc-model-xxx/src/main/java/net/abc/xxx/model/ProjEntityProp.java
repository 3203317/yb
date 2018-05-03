package net.abc.xxx.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Table(name = "gen_proj_entity_prop")
public class ProjEntityProp implements Serializable {

	private static final long serialVersionUID = -1L;

	// 属性标签
	@Column(name = "prop_name")
	private String prop_name;

	// UUID
	@Column(name = "is_uuid")
	private Integer is_uuid;

	// 主键
	@Column(name = "is_pk")
	private Integer is_pk;

	// 排除
	@Column(name = "is_transient")
	private Integer is_transient;

	// 正则
	@Column(name = "regex")
	private String regex;

	// 允许空
	@Column(name = "allow_null")
	private Integer allow_null;

	// 验证消息
	@Column(name = "valid_msg")
	private String valid_msg;

	// 默认值
	@Column(name = "def_val")
	private String def_val;

	// 最大
	@Column(name = "len_max")
	private Integer len_max;

	// 最小
	@Column(name = "len_min")
	private Integer len_min;

	// 数据类型
	@Column(name = "prop_type")
	private String prop_type;

	//
	@Column(name = "create_time")
	private Date create_time;

	// 属性描述
	@Column(name = "prop_desc")
	private String prop_desc;

	//
	@Id
	@Column(name = "entity_id")
	private String entity_id;

	//
	@Id
	@Column(name = "proj_id")
	private String proj_id;

	// 属性名称
	@Id
	@Column(name = "id")
	private String id;

	public void setProp_name(String prop_name) {
		this.prop_name = prop_name;
	}

	public String getProp_name() {
		return prop_name;
	}

	public void setIs_uuid(Integer is_uuid) {
		this.is_uuid = is_uuid;
	}

	public Integer getIs_uuid() {
		return is_uuid;
	}

	public void setIs_pk(Integer is_pk) {
		this.is_pk = is_pk;
	}

	public Integer getIs_pk() {
		return is_pk;
	}

	public void setIs_transient(Integer is_transient) {
		this.is_transient = is_transient;
	}

	public Integer getIs_transient() {
		return is_transient;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getRegex() {
		return regex;
	}

	public Integer getAllow_null() {
		return allow_null;
	}

	public void setAllow_null(Integer allow_null) {
		this.allow_null = allow_null;
	}

	public void setValid_msg(String valid_msg) {
		this.valid_msg = valid_msg;
	}

	public String getValid_msg() {
		return valid_msg;
	}

	public void setDef_val(String def_val) {
		this.def_val = def_val;
	}

	public String getDef_val() {
		return def_val;
	}

	public void setLen_max(Integer len_max) {
		this.len_max = len_max;
	}

	public Integer getLen_max() {
		return len_max;
	}

	public void setLen_min(Integer len_min) {
		this.len_min = len_min;
	}

	public Integer getLen_min() {
		return len_min;
	}

	public void setProp_type(String prop_type) {
		this.prop_type = prop_type;
	}

	public String getProp_type() {
		return prop_type;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setProp_desc(String prop_desc) {
		this.prop_desc = prop_desc;
	}

	public String getProp_desc() {
		return prop_desc;
	}

	public void setEntity_id(String entity_id) {
		this.entity_id = entity_id;
	}

	public String getEntity_id() {
		return entity_id;
	}

	public void setProj_id(String proj_id) {
		this.proj_id = proj_id;
	}

	public String getProj_id() {
		return proj_id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

}