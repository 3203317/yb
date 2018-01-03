package net.abc.xxx.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * 
 * @author huangxin <3203317@qq.com>
 *
 */
@Table(name = "gen_proj_form_prop")
public class ProjFormProp implements Serializable {

	private static final long serialVersionUID = -3442427685161741989L;

	@Id
	private String id;
	private String prop_desc;
	private Date create_time;

	@Id
	private String form_id;

	private Integer sort;

	private Integer control_type;

	public Integer getControl_type() {
		return control_type;
	}

	public void setControl_type(Integer control_type) {
		this.control_type = control_type;
	}

	@Transient
	private String prop_type;

	public String getProp_type() {
		return prop_type;
	}

	public void setProp_type(String prop_type) {
		this.prop_type = prop_type;
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

	public String getForm_id() {
		return form_id;
	}

	public void setForm_id(String form_id) {
		this.form_id = form_id;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

}