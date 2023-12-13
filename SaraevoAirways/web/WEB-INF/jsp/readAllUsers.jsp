<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            table {
                width: 100%;
                border-collapse: collapse;
            }
            th, td {
                border: 1px solid #ddd;
                padding: 8px;
                text-align: left;
            }
            th {
                background-color: #4CAF50;
                color: white;
            }
            .update, .delete {
                color: white;
                background-color: #4CAF50;
                text-decoration: none;
                padding: 8px;
            }
        </style>
    </head>
    <body>
        <table>
            <thead>
                <tr>
                    <th>id</th>
                    <th>Логин</th>
                    <th>Пароль</th>
                    <th>Фамилия</th>
                    <th>Имя</th>
                    <th>Отчество</th>
                    <th>Email</th>
                </tr>
            </thead>
            <c:forEach var="user" items="${user}">
                <tr>
                    <td>${user.id}</td>
                    <td>${user.login}</td>
                    <td>${user.password}</td>
                    <td>${user.lastName}</td>
                    <td>${user.firstName}</td>
                    <td>${user.surName}</td>
                    <td>${user.email}</td>
                    <td><form action="UpdateUserServlet" method="get" class="update">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <input type="submit" value="Обновить"/>
                        </form>
                    </td>
                    <td><form action="DeleteUserServlet" method="get" class="delete">
                            <input type="hidden" name="id" value="${user.id}"/>
                            <input type="submit" value="Удалить"/>
                        </form>
                    </td>                
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
