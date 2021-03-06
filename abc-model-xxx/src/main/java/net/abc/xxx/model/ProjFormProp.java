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
@Table(name = "gen_proj_form_prop")
public class ProjFormProp implements Serializable {
 
  private static final long serialVersionUID = -1L;
 
 
  // 
  @Id
  @Column(name = "id")
  private String id;
 
  // 
  @Id
  @Column(name = "form_id")
  private String form_id;
 
  // 
  @Column(name = "sort")
  private Integer sort;
 
  // 
  @Transient
  private Integer is_pk;
 
  // 
  @Column(name = "prop_name")
  private String prop_name;
 
  // 
  @Transient
  private String prop_type;
 
  // 
  @Column(name = "create_time")
  private Date create_time;
 
  // 
  @Column(name = "control_type")
  private Integer control_type;
 
 
  public void setId(String id) {
    this.id = id;
  }
 
  public String getId() {
    return id;
  }
 
  public void setForm_id(String form_id) {
    this.form_id = form_id;
  }
 
  public String getForm_id() {
    return form_id;
  }
 
  public void setSort(Integer sort) {
    this.sort = sort;
  }
 
  public Integer getSort() {
    return sort;
  }
 
  public void setIs_pk(Integer is_pk) {
    this.is_pk = is_pk;
  }
 
  public Integer getIs_pk() {
    return is_pk;
  }
 
  public void setProp_name(String prop_name) {
    this.prop_name = prop_name;
  }
 
  public String getProp_name() {
    return prop_name;
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
 
  public void setControl_type(Integer control_type) {
    this.control_type = control_type;
  }
 
  public Integer getControl_type() {
    return control_type;
  }
 
 
}