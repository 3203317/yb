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
@Table(name = "gen_proj_entity")
public class ProjEntity implements Serializable {

	private static final long serialVersionUID = -7790766835360961294L;

	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "UUID")
	private String id;

	private String entity_name;
	private String entity_desc;
	private Date create_time;

	private String proj_id;

	private String db_name;

	private String sqls;

	public String getSqls() {
		return sqls;
	}

	public void setSqls(String sqls) {
		this.sqls = sqls;
	}

	public String getDb_name() {
		return db_name;
	}

	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEntity_name() {
		return entity_name;
	}

	public void setEntity_name(String entity_name) {
		this.entity_name = entity_name;
	}

	public String getEntity_desc() {
		return entity_desc;
	}

	public void setEntity_desc(String entity_desc) {
		this.entity_desc = entity_desc;
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