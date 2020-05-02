<#include "../parts/main-template.ftl">
<@main "Stickers"/>

<#macro content>

    <div>
        <#list stickers as sticker>
            <div><strong>${sticker.description}</strong></div>
            <div>Material: ${sticker.materialName}</div>
            <div>Paper quality: ${sticker.paperQuality}</div>
            <div>Height: ${sticker.height}</div>
            <div>Width: ${sticker.width}</div>
            <div>Price: ${sticker.totalPrice}</div>
            <br>
        </#list>
    </div>

</#macro>