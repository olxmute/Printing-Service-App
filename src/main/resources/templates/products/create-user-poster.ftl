<#include "../parts/main-template.ftl">
<#import "/spring.ftl" as spring />
<@main "Poster"/>

<#macro content>

    <a href="/posters/list">< Discard</a>
    <@spring.bind "productWriteDto" />
    <form method="post" enctype="multipart/form-data" action="/user-product" onchange="recalculatePrice()">
        <@spring.formHiddenInput "productWriteDto.id"/>
        <@spring.formHiddenInput "productWriteDto.basePrice" "placeholder='Base price'"/>

        <div>
            <label>Description: </label>
            <@spring.formInput
            "productWriteDto.description" "placeholder='Description'"/>
        </div>
        <div>
            <label>
                Width:
                <@spring.formInput "productWriteDto.width" "placeholder='Width'" "number"/>
                cm
            </label>
        </div>
        <div>
            <label>
                Height:
                <@spring.formInput "productWriteDto.height" "placeholder='Height'" "number"/>
                cm
            </label>
        </div>
        <div>
            <label>Orientation: </label>
            <@spring.formSingleSelect "productWriteDto.orientation" orientations/>
        </div>
        <div>
            <label>Material: </label>
            <@spring.formSingleSelect "productWriteDto.materialId" materials/>
        </div>
        <div>
            <label for="fileInput">Image: </label>
            <img src="${productWriteDto.image!}" id="image-holder" alt="no image :(">
            <input id="fileInput" type="file" onchange="encode()"/>
            <@spring.formHiddenInput "productWriteDto.image"/>
        </div>

        <div>
            <label>Count: <input name="count" value="1" id="count" type="number"/></label>
        </div>
        <div>Total price: <span id="price">0</span>$</div>
        <input name="_csrf" value="${_csrf.token}" type="hidden"/>
        <button type="submit">Add to cart</button>
    </form>

    <script src="/scripts/posterWriteScripts.js"></script>
    <script src="/scripts/priceScripts.js"></script>
</#macro>