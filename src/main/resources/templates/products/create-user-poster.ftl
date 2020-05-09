<#include "../parts/main-template.ftl">
<#import "/spring.ftl" as spring />
<#if productType = 'POSTER'>
    <@main "Poster"/>
<#else>
    <@main "Sticker"/>
</#if>

<#macro content>

    <!-- Breadcrumb Section Begin -->
    <div class="breacrumb-section">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="breadcrumb-text product-more">
                        <a href="/home"><i class="fa fa-home"></i> Home</a>
                        <a href="/posters/list">Shop</a>
                        <span>Edit</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Breadcrumb Section Begin -->

    <section class="checkout-section spad">
        <div class="container">
            <@spring.bind "productWriteDto" />
            <form method="post" class="checkout-form" onchange="recalculatePrice()"
                    <#if productType = 'POSTER'>
                        action="/user-product/poster"
                    <#else>
                        action="/user-product/sticker"
                    </#if>
            >
                <@spring.formHiddenInput "productWriteDto.id"/>
                <@spring.formHiddenInput "productWriteDto.basePrice" "placeholder='Base price'"/>

                <div class="row">
                    <div class="col-lg-6">
                        <h4>
                            <#if productType = 'POSTER'>
                                Poster Details
                            <#else>
                                Sticker Details
                            </#if>
                        </h4>
                        <div class="row">
                            <div class="col-lg-12 mb-3">
                                <label for="prod-name">Product title<span>*</span></label>
                                <@spring.formInput "productWriteDto.description" "id='prod-name'"/>
                                <@spring.showErrors "<br>" "error-holder"/>
                            </div>
                            <div class="col-lg-12 mb-3">
                                <label for="width">Width (cm)<span>*</span></label>
                                <@spring.formInput "productWriteDto.width" "id='width' min='1' step='any'" "number"/>
                                <@spring.showErrors "<br>" "error-holder"/>
                            </div>
                            <div class="col-lg-12 mb-3">
                                <label for="height">Height (cm)<span>*</span></label>
                                <@spring.formInput "productWriteDto.height" "id='height' min='1' step='any'" "number"/>
                                <@spring.showErrors "<br>" "error-holder"/>
                            </div>
                            <div class="col-lg-12 mb-3">
                                <label for="material">Material<span>*</span></label>
                                <@spring.formSingleSelect "productWriteDto.materialId" materials "id='material'"/>
                                <@spring.showErrors "<br>" "error-holder"/>
                            </div>
                            <div class="col-lg-12 mb-3">
                                <label for="image">Image<span>*</span></label>
                                <div class="input-group mb-2">
                                    <div class="custom-file">
                                        <input type="file" class="custom-file-input" id="fileInput"
                                               aria-describedby="inputGroupFileAddon01" onchange="encode()">
                                        <label class="custom-file-label shadow-none" for="fileInput">Choose file</label>
                                    </div>
                                </div>
                                <@spring.formHiddenInput "productWriteDto.image"/>
                                <@spring.showErrors "<br>" "error-holder"/>
                            </div>
                            <div class="col-lg-12 mb-3">
                                <label for="count">Count<span>*</span></label>
                                <input name="count" value="1" id="count" type="number" min="1"/>
                            </div>
                            <div class="col-lg-12">
                                <strong>Total price: <span id="price">0</span>$</strong>
                            </div>

                            <div class="order-btn">
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button type="submit" class="site-btn place-btn">Add to cart</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <img src="${productWriteDto.image!}" id="image-holder" alt="">
                    </div>
                </div>
            </form>
        </div>
    </section>

    <script src="/scripts/posterWriteScripts.js"></script>
    <script src="/scripts/priceScripts.js"></script>
</#macro>