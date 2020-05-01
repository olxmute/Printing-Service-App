<#include "../parts/main-template.ftl">
<@main "Outdoor posters"/>

<#macro content>

    <div>
        <#list outdoorPosters as poster>
            <div><strong>${poster.description}</strong></div>
            <div>Material: ${poster.materialName}</div>
            <div>Orientation: ${poster.orientation}</div>
            <div>Paper quality: ${poster.paperQuality}</div>
            <div>Height: ${poster.height}</div>
            <div>Width: ${poster.width}</div>
            <div>Price: ${poster.totalPrice}</div>
            <br>
        </#list>
    </div>

</#macro>