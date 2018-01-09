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
@Table(name = "gen_proj_entity")
public class ProjEntity implements Serializable {
 
  private static final long serialVersionUID = -1L;
 
 
  // SQL语句
  @Column(name = "sqls")
  private String sqls;
 
  // 表名
  @Column(name = "db_tab_name")
  private String db_tab_name;
 
  // 
  @Id
  @Column(name = "proj_id")
  private String proj_id;
 
  // 
  @Column(name = "create_time")
  private Date create_time;
 
  // 实体描述
  @Column(name = "entity_desc")
  private String entity_desc;
 
  // 实体标签
  @Column(name = "entity_name")
  private String entity_name;
 
  // 实体名称
  @Id
  @Column(name = "id")
  private String id;
 
 
  public void setSqls(String sqls) {
    this.sqls = sqls;
  }
 
  public String getSqls() {
    return sqls;
  }
 
  public void setDb_tab_name(String db_tab_name) {
    this.db_tab_name = db_tab_name;
  }
 
  public String getDb_tab_name() {
    return db_tab_name;
  }
 
  public void setProj_id(String proj_id) {
    this.proj_id = proj_id;
  }
 
  public String getProj_id() {
    return proj_id;
  }
 
  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }
 
  public Date getCreate_time() {
    return create_time;
  }
 
  public void setEntity_desc(String entity_desc) {
    this.entity_desc = entity_desc;
  }
 
  public String getEntity_desc() {
    return entity_desc;
  }
 
  public void setEntity_name(String entity_name) {
    this.entity_name = entity_name;
  }
 
  public String getEntity_name() {
    return entity_name;
  }
 
  public void setId(String id) {
    this.id = id;
  }
 
  public String getId() {
    return id;
  }
 
 
}