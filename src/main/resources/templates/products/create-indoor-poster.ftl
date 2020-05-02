<#include "../parts/main-template.ftl">
<#import "/spring.ftl" as spring />
<@main "Login"/>

<#macro content>

    <@spring.bind "productWriteDto" />
    <form method="post" enctype="multipart/form-data">

        <div>
            <label>Description: </label>
            <@spring.formInput
            "productWriteDto.description" "placeholder='Description'" "text"/>
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
            <label>File: </label>
            <@spring.formInput
            "productWriteDto.file" "name='file'" "file"/>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Create</button>
    </form>

</#macro>