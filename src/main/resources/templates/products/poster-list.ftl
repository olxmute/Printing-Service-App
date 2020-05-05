<#include "../parts/main-template.ftl">
<@main "Posters"/>

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
                            <li><a href="#">Posters</a></li>
                            <li><a href="#">Stickers</a></li>
                        </ul>
                    </div>
                    <div class="filter-widget">
                        <h4 class="fw-title">Price</h4>
                        <div class="filter-range-wrap">
                            <div class="range-slider">
                                <div class="price-input">
                                    <input type="text" id="minamount">
                                    <input type="text" id="maxamount">
                                </div>
                            </div>
                            <div class="price-range ui-slider ui-corner-all ui-slider-horizontal ui-widget ui-widget-content"
                                 data-min="33" data-max="98">
                                <div class="ui-slider-range ui-corner-all ui-widget-header"></div>
                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                                <span tabindex="0" class="ui-slider-handle ui-corner-all ui-state-default"></span>
                            </div>
                        </div>
                        <a href="#" class="filter-btn">Filter</a>
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
                    <#--                    <div class="product-show-option">-->
                    <#--                        <div class="row">-->
                    <#--                            <div class="col-lg-7 col-md-7"></div>-->
                    <#--                            <div class="col-lg-5 col-md-5 text-right">-->
                    <#--                                <p>Shown ${posters?size} Of ${posters?size} Product</p>-->
                    <#--                            </div>-->
                    <#--                        </div>-->
                    <#--                    </div>-->
                    <div class="product-list">
                        <div class="row">
                            <#list posters as poster>
                                <div class="col-lg-4 col-sm-6">
                                    <div class="product-item">
                                        <div class="pi-pic">
                                            <img src="${poster.image!}" alt="">
                                            <#if isAdmin>
                                                <div class="icon">
                                                    <a href="update?id=${poster.id}">
                                                        <i class="icon_pencil-edit_alt"></i>
                                                    </a>
                                                    <a href="/posters/delete?id=${poster.id}">
                                                        <i class="icon_close_alt"></i>
                                                    </a>
                                                </div>
                                            </#if>
                                            <form action="/cart/product" method="post">
                                                <ul class="quantity">
                                                    <li class="pro-qty">
                                                        <input value="${poster.id}" name="productId" type="hidden">
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
                                                Poster (${poster.height} x ${poster.width}cm)
                                            </div>
                                            <h5>${poster.description}</h5>
                                            <h6 class="material-name">${poster.materialName}</h6>
                                            <div class="product-price">$${poster.totalPrice}</div>
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

    <div><a href="/posters/add">Add poster</a></div>
    <div><a href="/user-product/poster">Create my own poster</a></div>

    <script src="/scripts/posterListScripts.js"></script>

</#macro>