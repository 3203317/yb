/**
 * Table: ${(data_pe.db_name)!}
 */
create table ${(data_pe.db_name)!} 
(
  <#import "data_type_mysql" as data_type>
<#list data_list_pep! as doc>  ${(doc.prop_name)!}  <@data_type.m name="${(doc.prop_type)!}"/>  null,
</#list>
);