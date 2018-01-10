<#import "data_type_java" as data_type>  
  @RequestMapping(value = { "/${(data_pf.form_type)!}" }, method = RequestMethod.GET)
  public String ${(data_pf.form_type)!}UI(<#list data_list_pfp! as doc><#if 14 == doc.control_type>@RequestParam(required = true) <@data_type.m name="${(doc.prop_type)!}"/> ${(doc.id)!}, </#if></#list>
    HttpSession session, Map&lt;String, Object&gt; map) {

    ${(data_pf.entity_id)!} data_frm_${(data_pf.id)!} = new ${(data_pf.entity_id)!}();
    <#list data_list_pfp! as doc>
    <#if 14 == doc.control_type>
    data_frm_${(data_pf.id)!}.set${(doc.id)?cap_first}(${(doc.id)!});
    </#if>
    </#list>

    map.put("data_frm_${(data_pf.id)!}", data_frm_${(data_pf.id)!});

    map.put("session_user", SecurityUtils.getSubject().getPrincipal());
    return "${(data_pf.form_type)!}";
  }

  @ResponseBody
  @RequestMapping(value = { "/${(data_pf.form_type)!}" }, method = RequestMethod.POST, produces = "application/json")
  public Map&lt;String, Object&gt; ${(data_pf.form_type)!}(HttpSession session, ${(data_pf.entity_id)!} entity) {
    ${(data_pf.entity_id)?uncap_first}Service.save(entity);

    Map&lt;String, Object&gt; result = new HashMap&lt;String, Object&gt;();
    result.put("success", true);
    return result;
  }