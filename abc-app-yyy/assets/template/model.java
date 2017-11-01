package ${(data_p.package_name)!}.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.validator.constraints.Length;

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Table(name = "${(data_pe.db_name)!}")
public class ${(data_pe.entity_name)!} implements Serializable {

  private static final long serialVersionUID = -1L;

  <#import "data_type_java" as data_type>

<#list data_list_pep! as doc>  // ${(doc.prop_desc)!}
  @Length(min = ${(doc.prop_min)!}, max = ${(doc.prop_max)!}, message = "${(doc.validate_msg)!}")
  @Column(name = "${(doc.prop_name)!}")
  private <@data_type.m name="${(doc.prop_type)!}"/> ${(doc.prop_name)!};

</#list>

  <#list data_list_pep! as doc>
  public <@data_type.m name="${(doc.prop_type)!}"/> set${(doc.prop_name)?cap_first}(<@data_type.m name="${(doc.prop_type)!}"/> ${(doc.prop_name)!}) {
    this.${(doc.prop_name)!} = ${(doc.prop_name)!};
  }

  public <@data_type.m name="${(doc.prop_type)!}"/> get${(doc.prop_name)?cap_first}() {
    return ${(doc.prop_name)!};
  }
  </#list>

}