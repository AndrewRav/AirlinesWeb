<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Бронирование билетов</title>
        <style>
            body {
                font-family: Arial, sans-serif;
            }
            form {
                width: 300px;
                margin: 0 auto;
            }
            label {
                display: block;
                margin-top: 20px;
            }
            input[type="text"], input[type="number"] {
                width: 100%;
                padding: 10px;
                margin-top: 5px;
            }
            input[type="submit"] {
                margin-top: 20px;
                padding: 10px 20px;
                background-color: #4CAF50;
                color: white;
                border: none;
                cursor: pointer;
            }
            input[type="submit"]:hover {
                background-color: #45a049;
            }
        </style>
    </head>
    <body>
        <form action="CreateTicketServlet" method="post">
            <label for="flightNumber">Номер рейса:</label>
            <input type="number" id="flightNumber" name="flightNumber">
            <label for="seat">Место:</label>
            <input type="number" id="seat" name="seat">
            <label for="departurePoint">Пункт отправления:</label>
            <input type="text" id="departurePoint" name="departurePoint">
            <label for="destinationPoint">Пункт назначения:</label>
            <input type="text" id="destinationPoint" name="destinationPoint">
            <label for="departureTime">Время отправления по Минску:</label>
            <input type="datetime-local" id="departureTime" name="departureTime">
            <label for="arrivalTime">Время прибытия по Минску:</label>
            <input type="datetime-local" id="arrivalTime" name="arrivalTime">
            <label for="airplaneType">Тип самолета:</label>
            <input type="text" id="airplaneType" name="airplaneType">
            <label for="ticketOwnerFirstName">Имя владельца билета:</label>
            <input type="text" id="ticketOwnerFirstName" name="ticketOwnerFirstName">
            <label for="ticketOwnerLastName">Фамилия владельца билета:</label>
            <input type="text" id="ticketOwnerLastName" name="ticketOwnerLastName">
            <label for="ticketOwnerSurName">Отчество владельца билета:</label>
            <input type="text" id="ticketOwnerSurName" name="ticketOwnerSurName">
            <input type="submit" value="Отправить">
        </form>
    </body>
</html>
