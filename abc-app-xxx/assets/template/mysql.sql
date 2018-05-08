drop table if exists ${(data_pe.db_tab_name)!};
/**
 * Table: ${(data_pe.db_tab_name)!}
 */
create table ${(data_pe.db_tab_name)!}
(
<#if (0 < data_list_pep_db_pk?size)>
  primary key (<#list data_list_pep_db_pk! as doc><#if 1==doc.is_pk>`${(doc.id)!}`<#if doc_has_next>, </#if></#if></#list>),
</#if>
  <#import "data_type_mysql" as data_type>
<#list data_list_pep_db! as doc>  `${(doc.id)!}` <@data_type.m name="${(doc.prop_type)!}" len="${(doc.len_max)?c}"/><#if 1!=doc.allow_null> not null</#if> comment '${(doc.prop_desc)!}'<#if doc_has_next>,</#if>
</#list>
);