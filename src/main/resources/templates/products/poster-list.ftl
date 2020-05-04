<#include "../parts/main-template.ftl">
<@main "Posters"/>

<#macro content>

    <div><a href="/posters/add">Add poster</a></div>
    <div><a href="/user-product/poster">Create my own poster</a></div>
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
            <div>
                <a href="update?id=${poster.id}">Edit</a>

                <form action="/posters/delete" method="post">
                    <input value="${poster.id}" name="id" type="hidden">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit">Delete</button>
                </form>
            </div>
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