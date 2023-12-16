<%@page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <fmt:setLocale value='${pageContext.response.locale}' scope="session"/>
    <fmt:bundle basename="com.company.localization.messages.msg">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <style><%@include file="../resources/css/updateStyle.css"%></style>
            <title><fmt:message key="title.updateUser"/></title>
    </head>
    <body>
        <form action="BackServlet" method="post">
            <input type="submit" class="leave" value='<fmt:message key="button.back"/>' />
        </form>
        <form action="UpdateUserServlet" method="post">
            <table>
                <thead>
                    <tr>
                        <th>id</th>
                        <th><fmt:message key="label.login"/></th>
                        <th><fmt:message key="label.password"/></th>
                        <th><fmt:message key="label.lastName"/></th>
                        <th><fmt:message key="label.firstName"/></th>
                        <th><fmt:message key="label.surName"/></th>
                        <th><fmt:message key="label.email"/></th>
                        <th><fmt:message key="label.update"/></th>
                    </tr>
                </thead>
                <tr>
                    <td>${user.id}</td>
                    <td><input type="text" name="login" value="${user.login}" required></td>
                    <td><input type="text" name="password" value="${user.password}" required></td>
                    <td><input type="text" name="lastName" value="${user.lastName}" required></td>
                    <td><input type="text" name="firstName" value="${user.firstName}" required></td>
                    <td><input type="text" name="surName" value="${user.surName}" required></td>
                    <td><input type="text" name="email" value="${user.email}" required></td>
                    <td>
                        <input type="hidden" name="id" value="${user.id}"/>
                        <input type="submit" value='<fmt:message key="button.update"/>'/>
                    </td>                
                </tr>
            </table>
        </form>
    </body>
    </fmt:bundle>
</html>