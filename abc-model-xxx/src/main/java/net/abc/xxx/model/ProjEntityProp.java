package net.abc.xxx.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Table(name = "gen_proj_entity_prop")
public class ProjEntityProp implements Serializable {

	private static final long serialVersionUID = -3442427685161741989L;

	@Id
	private String id;
	private String prop_desc;
	private Date create_time;

	@Id
	private String entity_id;
	private String prop_type;

	private Integer prop_min;
	private Integer prop_max;

	private String def_val;
	private String valid_msg;

	private Integer is_null;

	private String regex;

	private Integer is_transient;

	private Integer is_pk;

	public Integer getIs_pk() {
		return is_pk;
	}

	public void setIs_pk(Integer is_pk) {
		this.is_pk = is_pk;
	}

	public Integer getIs_transient() {
		return is_transient;
	}

	public void setIs_transient(Integer is_transient) {
		this.is_transient = is_transient;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getValid_msg() {
		return valid_msg;
	}

	public void setValid_msg(String valid_msg) {
		this.valid_msg = valid_msg;
	}

	public String getDef_val() {
		return def_val;
	}

	public void setDef_val(String def_val) {
		this.def_val = def_val;
	}

	public Integer getIs_null() {
		return is_null;
	}

	public void setIs_null(Integer is_null) {
		this.is_null = is_null;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProp_desc() {
		return prop_desc;
	}

	public void setProp_desc(String prop_desc) {
		this.prop_desc = prop_desc;
	}

	public Date getCreate_time() {
		return create_time;
	}

	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}

	public String getEntity_id() {
		return entity_id;
	}

	public void setEntity_id(String entity_id) {
		this.entity_id = entity_id;
	}

	public String getProp_type() {
		return prop_type;
	}

	public void setProp_type(String prop_type) {
		this.prop_type = prop_type;
	}

	public Integer getProp_min() {
		return prop_min;
	}

	public void setProp_min(Integer prop_min) {
		this.prop_min = prop_min;
	}

	public Integer getProp_max() {
		return prop_max;
	}

	public void setProp_max(Integer prop_max) {
		this.prop_max = prop_max;
	}

}