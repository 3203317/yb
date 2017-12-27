drop table if exists ${(data_pe.db_name)!};

/**
 * Table: ${(data_pe.db_name)!}
 */
create table ${(data_pe.db_name)!} 
(
  <#import "data_type_mysql" as data_type>
<#list data_list_pep! as doc><#if 0==doc.is_transient>  ${(doc.id)!} <@data_type.m name="${(doc.prop_type)!}" len="${(doc.len_max)!}"/><#if 1==doc.is_null> not null</#if> comment '${(doc.prop_desc)!}',
</#if></#list>
  primary key (<#list data_list_pep! as doc><#if 0==doc.is_transient>${(doc.id)!}<#if doc_has_next>, </#if></#if></#list>)
);