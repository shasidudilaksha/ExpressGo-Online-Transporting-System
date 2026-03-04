<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
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
            background: url('images/car.jpg') no-repeat center center fixed;
            background-size: cover;
            overflow: hidden;
            position: relative;
        }

        .datetime {
            position: absolute;
            top: 20px;
            right: 30px;
            background-color: rgba(255, 255, 255, 0.9);
            padding: 10px 20px;
            border-radius: 12px;
            font-size: 16px;
            color: #333;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.2);
        }

        .dashboard {
            background: #fff;
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            text-align: center;
            transition: transform 0.3s ease;
            width: 400px;
        }

        .dashboard:hover {
            transform: translateY(-8px);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.4);
        }

        h2 {
            margin-bottom: 20px;
            color: #333;
        }

        .menu {
            display: flex;
            flex-direction: column;
            gap: 12px;
        }

        .menu a {
            text-decoration: none;
            color: #fff;
            background: #42a5f5;
            padding: 12px;
            border-radius: 30px;
            transition: all 0.3s ease;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        }

        .menu a:hover {
            background: #478ed1;
            transform: translateY(-4px);
            box-shadow: 0 6px 10px rgba(0, 0, 0, 0.3);
        }

        .menu a:active {
            transform: scale(0.98);
        }

        footer {
            margin-top: 20px;
            font-size: 14px;
            color: #666;
        }
    </style>
</head>
<body>
    <!-- Date and Time Display -->
    <div class="datetime" id="datetime">Loading date & time...</div>

    <!-- Dashboard Card -->
    <div class="dashboard">
        <h2>Welcome to the Dashboard</h2>
        <div class="menu">
            <a href="login.jsp">Driver Management</a>
            <a href="vehicleManagement.jsp">Vehicle Management</a>
            <a href="routeManagement.jsp">Route Management</a>
            <a href="tripScheduling.jsp">Trip Scheduling</a>
            <a href="userManagement.jsp">User Management</a>
        </div>
        <footer>&copy; 2025 Online Transport Management System</footer>
    </div>

    <!-- Date and Time Script -->
    <script>
        function updateDateTime() {
            const now = new Date();
            const formatted = now.toLocaleString('en-US', {
                weekday: 'long',
                year: 'numeric',
                month: 'long',
                day: '2-digit',
                hour: '2-digit',
                minute: '2-digit',
                second: '2-digit',
                hour12: true
            });
            document.getElementById('datetime').innerText = formatted;
        }

        setInterval(updateDateTime, 1000);
        updateDateTime();
    </script>
</body>
</html>
