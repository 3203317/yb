package ${(data_p.package_name)!}.model;

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
@Table(name = "${(data_pe.db_name)!}")
public class ${(data_pe.entity_name)!} implements Serializable {

  private static final long serialVersionUID = -1L;

  <#import "data_type_java" as data_type>

<#list data_list_pep! as doc>  private <@data_type.m name="${(doc.prop_type)!}"/> ${(doc.prop_name)!};  // ${(doc.prop_desc)!}
</#list>

  <#list data_list_pep! as doc>

  public <@data_type.m name="${(doc.prop_type)!}"/> get${(doc.prop_name)?cap_first}() {
    return ${(doc.prop_name)!};
  }

  public <@data_type.m name="${(doc.prop_type)!}"/> get${(doc.prop_name)?cap_first}() {
    return ${(doc.prop_name)!};
  }
  </#list>
}