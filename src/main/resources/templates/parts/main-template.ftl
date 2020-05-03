<#include "../security/security.ftl"/>
<#macro main title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <title>${title}</title>
    </head>

    <body>

    <header>
        <#if user??>
            <div>Cart (${cartItemsCount})</div>
        </#if>
    </header>

    <main>
        <@content/>
    </main>

    </body>
    </html>
</#macro>