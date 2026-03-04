<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.0/css/all.min.css">
    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: Arial, sans-serif;
        }

        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background: url('images/car4.png') no-repeat center center fixed;
            overflow: hidden;
        }

        .login-container {
            background: #ffffff;
            width: 350px;
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            position: relative;
            transition: transform 0.3s ease;
        }

        .login-container:hover {
            transform: translateY(-8px);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.4);
        }

        h2 {
            text-align: center;
            margin-bottom: 20px;
            color: #333;
        }

        .input-field {
            margin: 15px 0;
            position: relative;
        }

        .input-field input {
            width: 100%;
            padding: 12px 12px 12px 40px;
            border: 2px solid #ddd;
            border-radius: 30px;
            outline: none;
            transition: all 0.3s;
            box-shadow: inset 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .input-field input:focus {
            border-color: #6a11cb;
            box-shadow: inset 0 6px 8px rgba(0, 0, 0, 0.2);
        }

        .input-field i {
            position: absolute;
            top: 50%;
            left: 15px;
            transform: translateY(-50%);
            color: #6a11cb;
            font-size: 18px;
        }

        .login-btn {
            width: 100%;
            padding: 12px;
            background: #6a11cb;
            color: #fff;
            border: none;
            border-radius: 30px;
            cursor: pointer;
            transition: background 0.3s;
            margin-top: 10px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        }

        .login-btn:hover {
            background: #2575fc;
        }

        .login-btn:active {
            transform: scale(0.98);
        }

        .error-message {
            color: red;
            text-align: center;
            margin-top: 10px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>Login</h2>
        <form action="login" method="post">
            <div class="input-field">
                <i class="fas fa-user"></i>
                <input type="text" name="username" placeholder="Username" required>
            </div>
            <div class="input-field">
                <i class="fas fa-lock"></i>
                <input type="password" name="password" placeholder="Password" required>
            </div>
            <button type="submit" class="login-btn">Login</button>
            <% if (request.getParameter("error") != null) { %>
                <div class="error-message">Invalid username or password</div>
            <% } %>
        </form>
    </div>
</body>
</html>
