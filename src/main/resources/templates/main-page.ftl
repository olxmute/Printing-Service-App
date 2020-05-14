<#include "parts/main-template.ftl">
<@main "NMU Art Printing"/>
<#macro content>

    <!-- Banner Section Begin -->
    <div class="banner-section spad">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-4">
                    <a href="/posters/list">
                        <div class="single-banner">
                            <img src="/img/banner-1.jpg" alt="">
                            <div class="inner-text">
                                <h4>Posters</h4>
                            </div>
                        </div>
                    </a>
                </div>
                <div class="col-lg-4">
                    <a href="/stickers/list">
                        <div class="single-banner">
                            <img src="/img/banner-2.jpg" alt="">
                            <div class="inner-text">
                                <h4>Stickers</h4>
                            </div>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
    <!-- Banner Section End -->

    <!-- Poster Banner Section Begin -->
    <section class="poster-banner spad">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-3">
                    <div class="product-large set-bg" data-setbg="/img/products/posters-collage.jpg">
                        <h2>Posters</h2>
                        <a href="/posters/list">Discover More</a>
                    </div>
                </div>
                <div class="col-lg-8 offset-lg-1">
                    <div class="product-slider owl-carousel">
                        <#list posters as poster>
                            <div class="product-item">
                                <div class="pi-pic">
                                    <img src="${poster.image}" alt="">
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
                                    <div class="catagory-name">Poster (${poster.height} x ${poster.width}cm)</div>
                                    <h5>${poster.description}</h5>
                                    <h6 class="material-name">${poster.materialName}</h6>
                                    <div class="product-price">$${poster.totalPrice}</div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Poster Banner Section End -->

    <!-- Sticker Banner Section Begin -->
    <section class="sticker-banner spad">
        <div class="container-fluid">
            <div class="row">
                <div class="col-lg-8">
                    <div class="product-slider owl-carousel">
                        <#list stickers as sticker>
                            <div class="product-item">
                                <div class="pi-pic">
                                    <img src="${sticker.image}" alt="">
                                    <form action="/cart/product" method="post">
                                        <ul class="quantity">
                                            <li class="pro-qty">
                                                <input value="${sticker.id}" name="productId" type="hidden">
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
                                    <div class="catagory-name">Sticker (${sticker.height} x ${sticker.width}cm)</div>
                                    <h5>${sticker.description}</h5>
                                    <h6 class="material-name">${sticker.materialName}</h6>
                                    <div class="product-price">$${sticker.totalPrice}</div>
                                </div>
                            </div>
                        </#list>
                    </div>
                </div>
                <div class="col-lg-3 offset-lg-1">
                    <div class="product-large set-bg m-large" data-setbg="/img/products/stickers-collage.jpg">
                        <h2>Stickers</h2>
                        <a href="/stickers/list">Discover More</a>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Sticker Banner Section End -->

    <!-- Instagram Section Begin -->
    <div class="instagram-photo">
        <div class="insta-item set-bg" data-setbg="/img/insta-1.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="https://instagram.com">nmu_printing_art</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="/img/insta-2.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="https://instagram.com">nmu_printing_art</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="/img/insta-3.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="https://instagram.com">nmu_printing_art</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="/img/insta-4.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="https://instagram.com">nmu_printing_art</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="/img/insta-5.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="https://instagram.com">nmu_printing_art</a></h5>
            </div>
        </div>
        <div class="insta-item set-bg" data-setbg="/img/insta-6.jpg">
            <div class="inside-text">
                <i class="ti-instagram"></i>
                <h5><a href="https://instagram.com">nmu_printing_art</a></h5>
            </div>
        </div>
    </div>
    <!-- Instagram Section End -->

    <!-- Benefits Section Begin -->
    <section class="latest-blog spad">
        <div class="container">
            <div class="benefit-items">
                <div class="row">
                    <div class="col-lg-4">
                        <div class="single-benefit">
                            <div class="sb-icon">
                                <img src="/img/icon-1.png" alt="">
                            </div>
                            <div class="sb-text">
                                <h6>Free Shipping</h6>
                                <p>For all order over 99$</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="single-benefit">
                            <div class="sb-icon">
                                <img src="/img/icon-2.png" alt="">
                            </div>
                            <div class="sb-text">
                                <h6>Delivery On Time</h6>
                                <p>If good have prolems</p>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-4">
                        <div class="single-benefit">
                            <div class="sb-icon">
                                <img src="/img/icon-1.png" alt="">
                            </div>
                            <div class="sb-text">
                                <h6>Secure Payment</h6>
                                <p>100% secure payment</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- Benefits Section End -->

    <script src="/scripts/posterListScripts.js"></script>
</#macro>