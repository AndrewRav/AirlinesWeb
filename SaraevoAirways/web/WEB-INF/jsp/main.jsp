<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            body {
                font-family: Arial, sans-serif;
                display: flex;
                flex-direction: column;
                align-items: center;
                justify-content: center;
                height: 100vh;
                margin: 0;
            }
            .welcome-message {
                text-align: center;
                margin-bottom: 50px;
                font-size: 24px;
            }
            button {
                font-size: 20px;
                padding: 10px 20px;
                margin: 10px;
                background-color: #4CAF50;
                color: white;
                border: none;
                border-radius: 4px;
                cursor: pointer;
            }
            button a {
                color: white;
                text-decoration: none;
            }
        </style>
    </head>
    <body>
        <div class="welcome-message">
            Добро пожаловать в личный кабинет, <%= session.getAttribute("firstName")%> <%= session.getAttribute("surName")%>
        </div>
        <button><a href="createTicket.jsp">Создать билет</a></button>
        <form action="ReadTicketServlet" method="get" class="form_2">
            <input class="button" type="submit" value="Вывести билеты"/>
        </form>
        <button><a href="createUser.html">Создать пользователя</a></button>
        <form action="ReadUserServlet" method="get" class="form_2">
            <input class="button" type="submit" value="Посмотреть всех пользователей в системе"/>
        </form>
        <form action="" method="get" class="form_4">
            <label>Введите номер рейса: </label>
            <input type="number" class="text" id="TicketByFlightNumber" name="TicketByFlightNumber" placeholder="Введите номер рейса" required/><br/>
            <input class="button" type="submit" value="Вывести билеты по номеру рейса"/>
        </form>
        <form action="" method="get" class="form_4">
            <label>Введите фамилию: </label>
            <input type="number" class="text" id="TicketByLastName" name="TicketByFlightNumber" placeholder="Введите фамилию" required/><br/>
            <input class="button" type="submit" value="Вывести билеты по фамилии"/>
        </form>
    </body>
</html>

