<#include "../parts/main-template.ftl">
<@main "Login"/>

<#macro content>

    <form action="/login" method="post">

        <div>
            <h2>
                Log-in to your account
            </h2>
            <div>
                <input type="text" name="username" placeholder="Username" autocomplete="off">
            </div>
            <div>
                <input type="password" name="password" placeholder="Password">
            </div>
            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
            <button type="submit">Login</button>
        </div>

        <#if RequestParameters.error??>
            <div>
                <p>Invalid username and password.</p>
            </div>
        </#if>
        <#if RequestParameters.logout??>
            <div>
                <p>You have been logout.</p>
            </div>
        </#if>

    </form>

</#macro>