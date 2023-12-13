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
                <th>Номер рейса</th>
                <th>Номер места</th>
                <th>Пункт отправления</th>
                <th>Пункт назначения</th>
                <th>Время отправления</th>
                <th>Время прибытия</th>
                <th>Тип самолёта</th>
                <th>Имя</th>
                <th>Фамилия</th>
                <th>Отчество</th>
                <th>Обновление</th>
                <th>Удаление</th>
            </tr>
            </thead>
            <c:forEach var="ticket" items="${ticket}">
            <tr>
                <td>${ticket.id}</td>
                <td>${ticket.flightNumber}</td>
                <td>${ticket.seat}</td>
                <td>${ticket.departurePoint}</td>
                <td>${ticket.destinationPoint}</td>
                <td>${ticket.departureTime}</td>
                <td>${ticket.arrivalTime}</td>
                <td>${ticket.airplaneType}</td>
                <td>${ticket.ticketOwnerFirstName}</td>
                <td>${ticket.ticketOwnerLastName}</td>
                <td>${ticket.ticketOwnerSurName}</td>
                <td><form action="UpdateTicketServlet" method="get" class="update">
                    <input type="hidden" name="id" value="${ticket.id}"/>
                    <input type="submit" value="Обновить"/>
                        </form>
                </td>
                <td><form action="DeleteTicketServlet" method="get" class="delete">
                    <input type="hidden" name="id" value="${ticket.id}"/>
                    <input type="submit" value="Удалить"/>
                        </form>
                </td>                
            </tr>
            </c:forEach>
        </table>
    </body>
</html>