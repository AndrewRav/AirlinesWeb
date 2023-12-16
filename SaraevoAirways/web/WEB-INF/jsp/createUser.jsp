<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/createStyle.css"%></style>
            <title><fmt:message key="title.createUser"/></title>
        </head>
        <body>
            <form action="BackServlet" method="post">
                <input type="submit" class="leave" value='<fmt:message key="button.back"/>' />
            </form>
            <form action="CreateUserServlet" method="post">
                <label for="login"><fmt:message key="label.login"/></label>
                <input type="text" id="login" name="login" required>
                <label for="password"><fmt:message key="label.password"/></label>
                <input type="password" id="password" name="password" required>
                <label for="lastName"><fmt:message key="label.lastName"/></label>
                <input type="text" id="lastName" name="lastName" required>
                <label for="firstName"><fmt:message key="label.firstName"/></label>
                <input type="text" id="firstName" name="firstName" required>
                <label for="surName"><fmt:message key="label.surName"/></label>
                <input type="text" id="surName" name="surName" required>
                <label for="email"><fmt:message key="label.email"/></label>
                <input type="email" id="email" name="email" required>
                <input type="submit" class="send" value='<fmt:message key="button.register"/>'>
            </form>
        </body>
    </fmt:bundle>
</html>