package ${(data_p.package_name)!};

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

<#list data_list_pep! as doc>  private String ${(doc.prop_name)!};  // ${(doc.prop_desc)!}
</#list>

  <#list data_list_pep! as doc>

  public String get${(doc.prop_name)?cap_first}() {
    return ${(doc.prop_name)!};
  }

  public String get${(doc.prop_name)?cap_first}() {
    return ${(doc.prop_name)!};
  }
  </#list>
}