package net.abc.xxx.model;
 
import java.io.Serializable;
 
import java.util.Date;
 
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
 
 
/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Table(name = "gen_proj_form")
public class ProjForm implements Serializable {
 
  private static final long serialVersionUID = -1L;
 
 
  // 实体名称
  @Transient
  private String entity_name;
 
  // 表单类型
  @Column(name = "form_type")
  private Integer form_type;
 
  // 
  @Column(name = "create_time")
  private Date create_time;
 
  // 表单描述
  @Column(name = "form_desc")
  private String form_desc;
 
  // 表单名称
  @Column(name = "form_name")
  private String form_name;
 
  // 
  @Id
  @Column(name = "entity_id")
  private String entity_id;
 
  // 
  @Id
  @Column(name = "proj_id")
  private String proj_id;
 
  // 
  @Id
  @GeneratedValue(generator = "UUID")
  @Column(name = "id")
  private String id;
 
 
  public void setEntity_name(String entity_name) {
    this.entity_name = entity_name;
  }
 
  public String getEntity_name() {
    return entity_name;
  }
 
  public void setForm_type(Integer form_type) {
    this.form_type = form_type;
  }
 
  public Integer getForm_type() {
    return form_type;
  }
 
  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }
 
  public Date getCreate_time() {
    return create_time;
  }
 
  public void setForm_desc(String form_desc) {
    this.form_desc = form_desc;
  }
 
  public String getForm_desc() {
    return form_desc;
  }
 
  public void setForm_name(String form_name) {
    this.form_name = form_name;
  }
 
  public String getForm_name() {
    return form_name;
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