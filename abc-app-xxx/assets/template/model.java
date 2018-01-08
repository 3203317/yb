package ${(data_p.package_name)!}.model;

import java.io.Serializable;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

<#--import org.hibernate.validator.constraints.Length;-->

/**
 *
 * @author huangxin <3203317@qq.com>
 *
 */
@Table(name = "${(data_pe.db_tab_name)!}")
public class ${(data_pe.id)!} implements Serializable {

  private static final long serialVersionUID = -1L;

  <#import "data_type_java" as data_type>

<#list data_list_pep! as doc>  // ${(doc.prop_desc)!}<#if 1==doc.is_pk>
  @Id</#if><#if 1==doc.is_uuid>
  @GeneratedValue(generator = "UUID")</#if><#if 1==doc.is_transient>
  @Transient<#else>
  @Column(name = "${(doc.id)!}")</#if>
  private <@data_type.m name="${(doc.prop_type)!}"/> ${(doc.id)!};

</#list>

  <#list data_list_pep! as doc>
  public void set${(doc.id)?cap_first}(<@data_type.m name="${(doc.prop_type)!}"/> ${(doc.id)!}) {
    this.${(doc.id)!} = ${(doc.id)!};
  }

  public <@data_type.m name="${(doc.prop_type)!}"/> get${(doc.id)?cap_first}() {
    return ${(doc.id)!};
  }

  </#list>

}