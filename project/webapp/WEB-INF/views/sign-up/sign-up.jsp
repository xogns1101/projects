<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>Insert Your Title</title>

        <style>
            body {
                font-family: Arial, sans-serif;
                background-color: #f4f4f4;
            }
            .login-container {
                width: 300px;
                margin: 100px auto;
                padding: 20px;
                background-color: #fff;
                border-radius: 5px;
                box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            }
            .login-container h2 {
                text-align: center;
            }
            .login-form {
                margin-top: 20px;
            }
            .form-group {
                margin-bottom: 20px;
            }
            .form-group label {
                display: block;
                margin-bottom: 5px;
            }
            .form-group input[type="text"],
            .form-group input[type="password"] {
                width: calc(100% - 12px);
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 3px;
            }
            .form-group button {
                width: 100%;
                padding: 10px;
                background-color: #007bff;
                color: #fff;
                border: none;
                border-radius: 3px;
                cursor: pointer;
            }
            .form-group button:hover {
                background-color: #0056b3;
            }
        </style>

</head>
<body>
  <div class="login-container">
        <h2>Login</h2>
        <form class="login-form" action="#" method="POST">
            <div class="form-group">
                <label for="username">Username:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="form-group">
                <label for="password">Password:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <button type="submit">Login</button>
            </div>
        </form>
    </div>



</body>
</html>