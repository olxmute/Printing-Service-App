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
            <form action="/cart/product" method="post">
                <input value="${sticker.id}" name="productId" type="hidden">
                <input name="count" type="number" value="1">
                <button type="submit">Add to cart</button>
                <#if user??>
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                </#if>
            </form>
            <br>
        </#list>
    </div>

</#macro>