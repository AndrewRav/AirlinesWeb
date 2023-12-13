<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Вход в систему</title>
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
        input[type="text"], input[type="password"] {
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
    <form action="LoginServlet" method="get">
        <label for="login">Логин:</label><br>
        <input type="text" id="login" name="login"><br>
        <label for="password">Пароль:</label><br>
        <input type="password" id="password" name="password"><br>
        <input type="submit" value="Войти">
    </form>
</body>
</html>

