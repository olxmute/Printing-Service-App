<#include "../parts/main-template.ftl">
<@main "Login"/>

<#macro content>

    <div class="register-login-section spad">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 offset-lg-3">
                    <div class="login-form">
                        <h2>Login</h2>
                        <form action="/login" method="post">

                            <div>
                                <div class="group-input">
                                    <label for="username">Email address *</label>
                                    <#-- TODO: type="email"-->
                                    <input type="text" id="username" name="username">
                                </div>
                                <div class="group-input">
                                    <label for="pass">Password *</label>
                                    <input id="pass" type="password" name="password">
                                </div>
                                <input type="hidden" name="_csrf" value="${_csrf.token}"/>
                                <button type="submit" class="site-btn login-btn">Sign In</button>
                            </div>

                            <#if RequestParameters.error??>
                                <div class="holder login-error">
                                    <div>Invalid username or password.</div>
                                </div>
                            </#if>
                            <#if RequestParameters.logout??>
                                <div class="holder logout">
                                    <div>You have been logout.</div>
                                </div>
                            </#if>

                        </form>
                        <div class="switch-login">
                            <a href="/registration" class="or-login">Or Create An Account</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</#macro>