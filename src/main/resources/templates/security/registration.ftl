<#include "../parts/main-template.ftl">
<#import "/spring.ftl" as spring />
<@main "Register"/>

<#macro content>

    <@spring.bind "userDto"/>
    <form action="/registration" method="post">

        <div>
            <label>First name: </label>
            <@spring.formInput
            "userDto.firstName" "placeholder='First name' autocomplete='off'" "text"/>
        </div>
        <div>
            <label>Last name: </label>
            <@spring.formInput
            "userDto.lastName" "placeholder='First name' autocomplete='off'" "text"/>
        </div>
        <div>
            <label>Email: </label>
            <@spring.formInput
            "userDto.email" "placeholder='Email' autocomplete='off'" "text"/>
        </div>
        <div>
            <label>Password</label>
            <@spring.formPasswordInput
            "userDto.password" "placeholder='Password' autocomplete='off'"/>
        </div>

        <input type="hidden" name="_csrf" value="${_csrf.token}"/>
        <button type="submit">Register</button>
    </form>
</#macro>