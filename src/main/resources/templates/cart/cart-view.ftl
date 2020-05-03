<#include "../parts/main-template.ftl">
<@main "My cart"/>

<#macro content>

    <a href="/posters/list">Continue shopping</a>
    <div>
        <#list cart.items as item>
            <div><strong>${item.product.description}</strong></div>
            <div>Material: ${item.product.materialName}</div>
            <div>Paper quality: ${item.product.paperQuality}</div>
            <#if item.product.orientation??>
                <div>Orientation: ${item.product.orientation}</div>
            </#if>
            <div>Height: ${item.product.height}</div>
            <div>Width: ${item.product.width}</div>
            <div>Price: ${item.product.totalPrice}</div>
            <div><img src="${item.product.image!}" alt="no image :("></div>
            <div>Product count in cart: ${item.productCount}</div>
            <div>
                <form action="/cart/product/delete" method="post">
                    <input type="hidden" name="itemId" value="${item.id}">
                    <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                    <button type="submit">Delete from cart</button>
                </form>
            </div>
        <#--            <form action="/cart/product" method="post">-->
        <#--                <input value="${item.product.id}" name="productId" type="hidden">-->
        <#--                <input name="count" type="number" value="1">-->
        <#--                <button type="submit">Add to cart</button>-->
        <#--                <input type="hidden" name="_csrf" value="${_csrf.token}"/>-->
        <#--            </form>-->
            <br>
        </#list>
    </div>
    <div><strong>Total items: ${cart.totalItemsCount}</strong></div>
    <div><strong>Total price: ${cart.totalPrice}</strong></div>

</#macro>