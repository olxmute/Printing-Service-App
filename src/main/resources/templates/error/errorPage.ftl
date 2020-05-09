<#include "../parts/main-template.ftl">
<@main "NMU Art Printing"/>

<#macro content>
    <div class="container">
        <div class="errors">
            <div class="status-code">${status}</div>
            <div class="error-message">${errorMsg}</div>
        </div>
    </div>
</#macro>