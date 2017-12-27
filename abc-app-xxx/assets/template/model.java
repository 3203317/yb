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
  @Length(min = ${(doc.len_min)!}, max = ${(doc.len_max)!}, message = "${(doc.valid_msg)!}")
  @Column(name = "${(doc.id)!}")
  private <@data_type.m name="${(doc.prop_type)!}"/> ${(doc.id)!};

</#list>

  <#list data_list_pep! as doc>
  public <@data_type.m name="${(doc.prop_type)!}"/> set${(doc.id)?cap_first}(<@data_type.m name="${(doc.prop_type)!}"/> ${(doc.id)!}) {
    this.${(doc.id)!} = ${(doc.id)!};
  }

  public <@data_type.m name="${(doc.prop_type)!}"/> get${(doc.id)?cap_first}() {
    return ${(doc.id)!};
  }

  </#list>

}