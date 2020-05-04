<#include "../parts/main-template.ftl">
<#import "/spring.ftl" as spring />
<@main "Register"/>

<#macro content>

    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="register-form">
                        <h2>Register</h2>
                        <@spring.bind "userDto"/>
                        <form action="/registration" method="post">

                            <div class="group-input">
                                <label for="firstName">First name *</label>
                                <@spring.formInput "userDto.firstName" />
                            </div>
                            <div class="group-input">
                                <label for="lastName">Last name *</label>
                                <@spring.formInput "userDto.lastName"/>
                            </div>
                            <div class="group-input">
                                <label for="email">Email *</label>
                                <@spring.formInput "userDto.email" "" "email"/>
                            </div>
                            <div class="group-input">
                                <label for="password">Password *</label>
                                <@spring.formPasswordInput "userDto.password" />
                            </div>
                            <#-- TODO: process this -->
                            <div class="group-input">
                                <label for="con-pass">Confirm Password *</label>
                                <input type="password" id="con-pass">
                            </div>

                            <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                            <button type="submit" class="site-btn register-btn">REGISTER</button>
                        </form>
                        <div class="switch-login">
                            <a href="/login" class="or-login">Or Login</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</#macro>