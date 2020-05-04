<#include "../parts/main-template.ftl">
<@main "My cart"/>

<#macro content>
    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="/home"><i class="fa fa-home"></i> Home</a>
                        <a href="/posters/list">Shop</a>
                        <span>Shopping Cart</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Shopping Cart Section Begin -->
    <section class="shopping-cart spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="cart-table">
                        <table>
                            <thead>
                            <tr>
                                <th>Image</th>
                                <th>Product</th>
                                <th>Price</th>
                                <th>Quantity</th>
                                <th>Total</th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody>

                            <#list cart.items as item>

                            <tr>
                                <td class="cart-pic first-row"><img src="${item.product.image!}" alt=""></td>
                                <td class="cart-title first-row">
                                    <h5>${item.product.description} (${item.product.height}x${item.product.width}
                                        cm)</h5>
                                </td>
                                <td class="p-price first-row">$${item.product.totalPrice}</td>
                                <td class="qua-col first-row">
                                    <div class="quantity">
                                        <div class="pro-qty">
                                            <#-- TODO: change quantity -->
                                            <span class="dec qtybtn">-</span>
                                            <input type="text" value="${item.productCount}">
                                            <span class="inc qtybtn">+</span>
                                        </div>
                                    </div>
                                </td>
                                <td class="total-price first-row">$${item.product.totalPrice * item.productCount}</td>
                                <td class="close-td first-row">
                                    <form action="/cart/product/delete" method="post">
                                        <input name="itemId" value="${item.id}" type="hidden">
                                        <input name="_csrf" value="${_csrf.token}" type="hidden"/>
                                        <button type="submit"><i class="ti-close"></i></button>
                                    </form>
                                </td>
                                <#--                                    <form action="/cart/product/count" method="post">-->
                                <#--                                        <input name="itemId" value="${item.id}" type="hidden">-->
                                <#--                                        <input name="count" value="${item.productCount}" type="number">-->
                                <#--                                        <input name="_csrf" value="${_csrf.token}" type="hidden"/>-->
                                <#--                                        <button type="submit">Change count</button>-->
                                <#--                                    </form>-->
                                </#list>
                            </tbody>
                        </table>
                    </div>
                    <div class="row">
                        <div class="col-lg-4">
                            <div class="cart-buttons">
                                <a href="/home" class="primary-btn up-cart">Continue shopping</a>
                            </div>
                        </div>
                        <div class="col-lg-4 offset-lg-4">
                            <div class="proceed-checkout">
                                <ul>
                                    <li class="subtotal">Total items <span>${cart.totalItemsCount}</span></li>
                                    <li class="cart-total">Total <span>$${cart.totalPrice}</span></li>
                                </ul>
                                <form action="/cart" method="post">
                                    <input name="_csrf" value="${_csrf.token}" type="hidden"/>
                                    <button type="submit" class="proceed-btn">SUBMIT ORDER</button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

</#macro>