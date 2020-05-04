<#include "../parts/main-template.ftl">
<@main "My cart"/>

<#macro content>

    <a href="/home">Continue shopping</a>
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
            <div>
                Product count in cart:
                <form action="/cart/product/count" method="post">
                    <input name="itemId" value="${item.id}" type="hidden">
                    <input name="count" value="${item.productCount}" type="number">
                    <input name="_csrf" value="${_csrf.token}" type="hidden"/>
                    <button type="submit">Change count</button>
                </form>
            </div>
            <div>
                <form action="/cart/product/delete" method="post">
                    <input name="itemId" value="${item.id}" type="hidden">
                    <input name="_csrf" value="${_csrf.token}" type="hidden"/>
                    <button type="submit">Delete from cart</button>
                </form>
            </div>
            <br>
        </#list>
    </div>
    <div><strong>Total items: ${cart.totalItemsCount}</strong></div>
    <div><strong>Total price: ${cart.totalPrice}</strong></div>
    <div>
        <form action="/cart" method="post">
            <input name="_csrf" value="${_csrf.token}" type="hidden"/>
            <button type="submit">Submit order</button>
        </form>
    </div>

</#macro>