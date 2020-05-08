<#include "../parts/main-template.ftl">

<#if productType = 'POSTER'>
    <@main "Posters"/>
<#else>
    <@main "Stickers"/>
</#if>

<#macro content>
    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="/home"><i class="fa fa-home"></i> Home</a>
                        <span>Shop</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb End -->

    <!-- Product Shop Section Begin -->
    <section class="product-shop spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-3 col-md-6 col-sm-8 order-2 order-lg-1 produts-sidebar-filter">
                    <div class="filter-widget">
                        <h4 class="fw-title">Categories</h4>
                        <ul class="filter-catagories">
                            <li>
                                <a href="/posters/list">
                                    <#if productType = 'POSTER'>
                                        <strong>> Posters</strong>
                                    <#else>
                                        Posters
                                    </#if>
                                </a>
                            </li>
                            <li>
                                <a href="/stickers/list">
                                    <#if productType = 'STICKER'>
                                        <strong>> Stickers</strong>
                                    <#else>
                                        Stickers
                                    </#if>
                                </a>
                            </li>
                        </ul>
                    </div>
                    <div class="filter-widget">
                        <h4 class="fw-title">Tags</h4>
                        <div class="fw-tags">
                            <a href="#">Towel</a>
                            <a href="#">Shoes</a>
                            <a href="#">Coat</a>
                            <a href="#">Dresses</a>
                            <a href="#">Trousers</a>
                            <a href="#">Men's hats</a>
                            <a href="#">Backpack</a>
                        </div>
                    </div>
                </div>
                <div class="col-lg-9 order-1 order-lg-2">
                    <div class="product-list">
                        <div class="row">
                            <#list products as product>
                                <div class="col-lg-4 col-sm-6">
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="${product.image!}" alt="">
                                            <#if isAdmin>
                                                <div class="icon">
                                                    <a href="update?id=${product.id}">
                                                        <i class="icon_pencil-edit_alt"></i>
                                                    </a>
                                                    <a
                                                            <#if productType = 'POSTER'>
                                                                href="/posters/delete?id=${product.id}"
                                                            <#else>
                                                                href="/stickers/delete?id=${product.id}"
                                                            </#if>
                                                    >
                                                        <i class="icon_close_alt"></i>
                                                    </a>
                                                </div>
                                            </#if>
                                            <form action="/cart/product" method="post">
                                                <ul class="quantity">
                                                    <li class="pro-qty">
                                                        <input value="${product.id}" name="productId" type="hidden">
                                                        <span class="dec qtybtn">-</span>
                                                        <input type="text" value="1" name="count"
                                                               class="add-to-cart-count">
                                                        <#if user??>
                                                            <input type="hidden" name="_csrf" value="${_csrf.token!}"/>
                                                        </#if>
                                                        <span class="inc qtybtn">+</span>
                                                    </li>
                                                    <li class="w-icon active">
                                                        <button>
                                                            <i class="icon_bag_alt"></i>
                                                        </button>
                                                    </li>
                                                </ul>
                                            </form>
                                        </div>
                                        <div class="pi-text">
                                            <div class="catagory-name">
                                                <#if productType = 'POSTER'>
                                                    Poster
                                                <#else>
                                                    Sticker
                                                </#if>
                                                (${product.height} x ${product.width}cm)
                                            </div>
                                            <h5>${product.description}</h5>
                                            <h6 class="material-name">${product.materialName}</h6>
                                            <div class="product-price">$${product.totalPrice}</div>
                                        </div>
                                    </div>
                                </div>
                            </#list>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Product Shop Section End -->

    <#if productType = 'POSTER'>
        <div><a href="/posters/add">Add poster</a></div>
        <div><a href="/user-product/poster">Create my own poster</a></div>
    <#else>
        <div><a href="/stickers/add">Add sticker</a></div>
        <div><a href="/user-product/sticker">Create my own sticker</a></div>
    </#if>

    <script src="/scripts/posterListScripts.js"></script>

</#macro>