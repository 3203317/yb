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
@Table(name = "gen_proj_form")
public class ProjForm implements Serializable {

	private static final long serialVersionUID = -7790766835360961294L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUID")
	private String id;

	private String form_name;
	private String form_desc;
	private Date create_time;

	private String proj_id;

	private Integer form_type;

	public Integer getForm_type() {
		return form_type;
	}

	public void setForm_type(Integer form_type) {
		this.form_type = form_type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getForm_name() {
		return form_name;
	}

	public void setForm_name(String form_name) {
		this.form_name = form_name;
	}

	public String getForm_desc() {
		return form_desc;
	}

	public void setForm_desc(String form_desc) {
		this.form_desc = form_desc;
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

}