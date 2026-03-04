<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Trip Scheduling</title>
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
            background: linear-gradient(145deg, #2196F3, #42A5F5);
        }

        .form-container {
            background: #fff;
            padding: 30px;
            border-radius: 15px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            width: 400px;
            transition: transform 0.3s ease;
        }

        .form-container:hover {
            transform: translateY(-6px);
            box-shadow: 0 12px 24px rgba(0, 0, 0, 0.4);
        }

        h3 {
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }

        label {
            font-size: 16px;
            margin-bottom: 5px;
            display: block;
        }

        input[type="number"], input[type="date"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px;
            border-radius: 10px;
            border: 1px solid #ddd;
            transition: all 0.3s ease;
        }

        input[type="number"]:focus, input[type="date"]:focus {
            border-color: #2196F3;
            box-shadow: 0 4px 8px rgba(33, 150, 243, 0.3);
        }

        input[type="submit"] {
            background: #2196F3;
            color: white;
            font-size: 16px;
            cursor: pointer;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            transition: all 0.3s ease;
        }

        input[type="submit"]:hover {
            background: #1976D2;
            transform: translateY(-3px);
        }

        input[type="submit"]:active {
            transform: scale(0.98);
        }

        .message {
            text-align: center;
            margin-bottom: 20px;
            padding: 10px;
            border-radius: 5px;
        }

        .success {
            background-color: #4caf50;
            color: white;
        }

        .error {
            background-color: #f44336;
            color: white;
        }
    </style>
</head>
<body>
    <div class="form-container">
        <h3>Trip Scheduling</h3>
        
        <!-- Success/Error Message -->
        <c:if test="${not empty message}">
            <div class="message ${messageType}">
                ${message}
            </div>
        </c:if>

        <form action="trips" method="post">
            <label for="driverId">Driver ID:</label>
            <input type="number" id="driverId" name="driverId" required placeholder="Enter driver ID" min="1">

            <label for="vehicleId">Vehicle ID:</label>
            <input type="number" id="vehicleId" name="vehicleId" required placeholder="Enter vehicle ID" min="1">

            <label for="routeId">Route ID:</label>
            <input type="number" id="routeId" name="routeId" required placeholder="Enter route ID" min="1">

            <label for="date">Date:</label>
            <input type="date" id="date" name="date" required>

            <input type="submit" value="Schedule Trip">
        </form>
    </div>
</body>
</html>
