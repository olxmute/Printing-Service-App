<#include "../parts/main-template.ftl">
<@main "Order history"/>

<#macro content>

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="/home"><i class="fa fa-home"></i> Home</a>
                        <a href="/posters/list">Shop</a>
                        <a href="/cart">Shopping Cart</a>
                        <span>Order history</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Order history Section Begin -->
    <div class="faq-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="faq-accordin">
                        <div class="accordion" id="accordionExample">
                            <#list carts as cart>
                                <div class="card">
                                    <div class="card-heading">
                                        <a data-toggle="collapse" data-target="#collapse${cart?index}">
                                            Order #${carts?size - cart?index} (${cart.lastModifiedDate})
                                        </a>
                                    </div>
                                    <div id="collapse${cart?index}" class="collapse" data-parent="#accordionExample">
                                        <div class="card-body">
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
                                                            </tr>
                                                            </thead>
                                                            <tbody>

                                                            <#list cart.items as item>

                                                            <tr>
                                                                <td class="cart-pic first-row"><img
                                                                            src="${item.product.image!}" alt=""></td>
                                                                <td class="cart-title first-row">
                                                                    <h5>${item.product.description}
                                                                        (${item.product.height}x${item.product.width}
                                                                        cm)</h5>
                                                                </td>
                                                                <td class="p-price first-row">
                                                                    $${item.product.totalPrice}</td>
                                                                <td class="qua-col first-row">${item.productCount}</td>
                                                                <td class="total-price first-row">
                                                                    $${item.product.totalPrice * item.productCount}</td>
                                                                </#list>
                                                            </tbody>
                                                        </table>
                                                        <div class="subtotal">
                                                            <strong>Total items: ${cart.totalItemsCount}</strong>
                                                        </div>
                                                        <div class="cart-total">
                                                            <strong>Total price: $${cart.totalPrice}</strong>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Order history Section End -->

</#macro>