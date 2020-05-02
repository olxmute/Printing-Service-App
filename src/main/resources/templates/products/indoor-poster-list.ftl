<#include "../parts/main-template.ftl">
<@main "Indoor posters"/>

<#macro content>

    <div>
        <#list indoorPosters as poster>
            <div><strong>${poster.description}</strong></div>
            <div>Material: ${poster.materialName}</div>
            <div>Orientation: ${poster.orientation}</div>
            <div>Paper quality: ${poster.paperQuality}</div>
            <div>Height: ${poster.height}</div>
            <div>Width: ${poster.width}</div>
            <div>Price: ${poster.totalPrice}</div>
            <div><img src="${poster.image}" alt="no image :("></div>
            <br>
        </#list>
    </div>

</#macro>