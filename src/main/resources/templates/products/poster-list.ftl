<#include "../parts/main-template.ftl">
<@main "Posters"/>

<#macro content>

    <a href="add">Add poster</a>
    <div>
        <#list posters as poster>
            <div><strong>${poster.description}</strong></div>
            <div>Material: ${poster.materialName}</div>
            <div>Paper quality: ${poster.paperQuality}</div>
            <div>Orientation: ${poster.orientation}</div>
            <div>Height: ${poster.height}</div>
            <div>Width: ${poster.width}</div>
            <div>Price: ${poster.totalPrice}</div>
            <div><img src="${poster.image!}" alt="no image :("></div>
            <div><a href="update?id=${poster.id}">Edit</a> <a href="delete?id=${poster.id}">Delete</a></div>
            <form action="/cart/product" method="post">
                <input value="${poster.id}" name="productId" type="hidden">
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