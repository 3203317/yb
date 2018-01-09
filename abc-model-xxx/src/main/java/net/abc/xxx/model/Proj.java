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
@Table(name = "gen_proj")
public class Proj implements Serializable {
 
  private static final long serialVersionUID = -1L;
 
 
  // 
  @Column(name = "password")
  private String password;
 
  // 
  @Column(name = "user")
  private String user;
 
  // 
  @Column(name = "url")
  private String url;
 
  // 
  @Column(name = "driverClass")
  private String driverClass;
 
  // 包名
  @Column(name = "package_name")
  private String package_name;
 
  // 创建时间
  @Column(name = "create_time")
  private Date create_time;
 
  // 项目描述
  @Column(name = "proj_desc")
  private String proj_desc;
 
  // 项目名称
  @Column(name = "proj_name")
  private String proj_name;
 
  // 
  @Id
  @GeneratedValue(generator = "UUID")
  @Column(name = "id")
  private String id;
 
 
  public void setPassword(String password) {
    this.password = password;
  }
 
  public String getPassword() {
    return password;
  }
 
  public void setUser(String user) {
    this.user = user;
  }
 
  public String getUser() {
    return user;
  }
 
  public void setUrl(String url) {
    this.url = url;
  }
 
  public String getUrl() {
    return url;
  }
 
  public void setDriverClass(String driverClass) {
    this.driverClass = driverClass;
  }
 
  public String getDriverClass() {
    return driverClass;
  }
 
  public void setPackage_name(String package_name) {
    this.package_name = package_name;
  }
 
  public String getPackage_name() {
    return package_name;
  }
 
  public void setCreate_time(Date create_time) {
    this.create_time = create_time;
  }
 
  public Date getCreate_time() {
    return create_time;
  }
 
  public void setProj_desc(String proj_desc) {
    this.proj_desc = proj_desc;
  }
 
  public String getProj_desc() {
    return proj_desc;
  }
 
  public void setProj_name(String proj_name) {
    this.proj_name = proj_name;
  }
 
  public String getProj_name() {
    return proj_name;
  }
 
  public void setId(String id) {
    this.id = id;
  }
 
  public String getId() {
    return id;
  }
 
 
}