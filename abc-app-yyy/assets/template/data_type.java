<#macro m name><#if name="number">Integer<#elseif name="varchar">String<#elseif name="date">Date<#else>未知</#if></#macro>