<#include "../parts/main-template.ftl">
<#import "/spring.ftl" as spring />
<@main "Poster"/>

<#macro content>

    <a href="list">< Back</a>
    <@spring.bind "productWriteDto" />
    <form method="post" enctype="multipart/form-data" action="/posters/write">
        <@spring.formHiddenInput "productWriteDto.id"/>

        <div>
            <label>Description: </label>
            <@spring.formInput
            "productWriteDto.description" "placeholder='Description'"/>
        </div>
        <div>
            <label>Width: </label>
            <@spring.formInput
            "productWriteDto.width" "placeholder='Width'"/>
        </div>
        <div>
            <label>Height: </label>
            <@spring.formInput
            "productWriteDto.height" "placeholder='Height'"/>
        </div>
        <div>
            <label>Base price: </label>
            <@spring.formInput
            "productWriteDto.basePrice" "placeholder='Base price'"/>
        </div>
        <div>
            <label>Orientation: </label>
            <@spring.formSingleSelect
            "productWriteDto.orientation" orientations/>
        </div>
        <div>
            <label>Material: </label>
            <@spring.formSingleSelect
            "productWriteDto.materialId" materials/>
        </div>
        <div>
            <label>Image: </label>
            <img src="${productWriteDto.image!}" id="image-holder" alt="no image :(">
            <input id="fileInput" type="file" onchange="encode()"/>
            <@spring.formHiddenInput "productWriteDto.image"/>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Save</button>
    </form>

    <script src="/scripts/posterWriteScripts.js"></script>
</#macro>