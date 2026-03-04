<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Edit Driver</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: url('images/car1.jpg') no-repeat center center fixed;
            background-size: cover;
            height: 100vh;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        .form-container {
            background: #ffffff;
            padding: 30px 40px;
            border-radius: 16px;
            box-shadow: 0 10px 25px rgba(0, 0, 0, 0.15);
            width: 100%;
            max-width: 450px;
            animation: floatIn 0.8s ease;
        }

        @keyframes floatIn {
            from {
                opacity: 0;
                transform: translateY(-20px);
            }
            to {
                opacity: 1;
                transform: translateY(0);
            }
        }

        h2 {
            text-align: center;
            color: #333;
            margin-bottom: 25px;
        }

        label {
            display: block;
            margin-bottom: 6px;
            font-weight: bold;
            color: #444;
        }

        input[type="text"] {
            width: 100%;
            padding: 10px 12px;
            border: 1px solid #ccc;
            border-radius: 8px;
            margin-bottom: 15px;
            box-shadow: inset 0 1px 3px rgba(0,0,0,0.1);
            transition: box-shadow 0.3s ease;
        }

        input[type="text"]:focus {
            outline: none;
            box-shadow: 0 0 0 3px rgba(41, 182, 246, 0.3);
            border-color: #29b6f6;
        }

        button {
            width: 100%;
            padding: 12px;
            background: linear-gradient(135deg, #66bb6a, #43a047);
            border: none;
            border-radius: 8px;
            color: white;
            font-size: 16px;
            font-weight: bold;
            cursor: pointer;
            transition: transform 0.2s, box-shadow 0.2s;
        }

        button:hover {
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0, 0, 0, 0.2);
        }

        .error {
            color: red;
            text-align: center;
            margin-bottom: 15px;
            font-weight: bold;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Edit Driver</h2>

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>

    <form action="drivers" method="post">
        <input type="hidden" name="action" value="update" />
        <label for="driver_id">ID</label>
        <input type="text" name="driver_id" value="${driver.driverId}" />

        <label for="name">Name</label>
        <input type="text" id="name" name="name" value="${driver.name}" required />

        <label for="license_number">License Number</label>
        <input type="text" id="license_number" name="license_number" value="${driver.licenseNumber}" required />

        <label for="contact">Contact</label>
        <input type="text" id="contact" name="contact" value="${driver.contact}" required />

        <label for="nic">NIC</label>
        <input type="text" id="nic" name="nic" value="${driver.nic}" required />

        <button type="submit">Update Driver</button>
    </form>
</div>

</body>
</html>
