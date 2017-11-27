package net.abc.xxx.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
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
	@Column(name = "id")
	@GeneratedValue(generator = "UUID")
	private String id;

	private String prop_name;
	private String prop_desc;
	private Date create_time;

	private String proj_id;
	private String entity_id;
	private String prop_type;

	private Integer prop_min;
	private Integer prop_max;

	private Integer is_uuid;
	private String valid_msg;

	private Integer is_not_null;

	private String regex;

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public Integer getIs_not_null() {
		return is_not_null;
	}

	public void setIs_not_null(Integer is_not_null) {
		this.is_not_null = is_not_null;
	}

	public String getValid_msg() {
		return valid_msg;
	}

	public void setValid_msg(String valid_msg) {
		this.valid_msg = valid_msg;
	}

	public Integer getIs_uuid() {
		return is_uuid;
	}

	public void setIs_uuid(Integer is_uuid) {
		this.is_uuid = is_uuid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getProp_name() {
		return prop_name;
	}

	public void setProp_name(String prop_name) {
		this.prop_name = prop_name;
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

	public String getProj_id() {
		return proj_id;
	}

	public void setProj_id(String proj_id) {
		this.proj_id = proj_id;
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