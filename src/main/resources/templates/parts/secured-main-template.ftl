<#include "main-template.ftl">

<#assign authorized = Session.SPRING_SECURITY_CONTEXT??>

<#if authorized>
    <#assign
    user = Session.SPRING_SECURITY_CONTEXT.authentication.principal
    name = user.getFirstName() + " " + user.getLastName()
    isAdmin = true
    >
<#else>
    <#assign
    name = "unknown"
    isAdmin = false
    >
</#if>