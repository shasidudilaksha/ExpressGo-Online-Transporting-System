<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Driver Details</title>
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

        .container {
            width: 90%;
            max-width: 1000px;
            background: rgba(255, 255, 255, 0.95);
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0,0,0,0.3);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        .top-buttons {
            display: flex;
            justify-content: space-between;
            margin-bottom: 15px;
            align-items: center;
        }

        .btn, .link-btn {
            padding: 8px 16px;
            border: none;
            border-radius: 5px;
            text-decoration: none;
            color: white;
            cursor: pointer;
            font-weight: bold;
            font-size: 14px;
        }

        .home-btn {
            background-color: #6c757d;
        }

        .print-btn {
            background-color: #17a2b8;
        }

        .btn:hover, .link-btn:hover {
            opacity: 0.9;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            box-shadow: 0 0 10px #ccc;
            background: white;
            border-radius: 5px;
            overflow: hidden;
        }

        th, td {
            padding: 12px;
            border: 1px solid #ddd;
            text-align: center;
        }

        th {
            background-color: #007BFF;
            color: white;
            font-weight: bold;
        }

        .edit-btn {
            background-color: #28a745;
        }

        .delete-btn {
            background-color: #dc3545;
        }

        .edit-btn:hover, .delete-btn:hover {
            opacity: 0.85;
        }

        /* Make action buttons smaller inside table */
        td form button {
            padding: 5px 10px;
            font-size: 13px;
        }
    </style>
</head>
<body>

<div class="container">

    <div class="top-buttons">
        <a href="dashboard.jsp" class="link-btn home-btn">Home</a>

        <form action="drivers" method="post" style="margin:0;">
            <input type="hidden" name="action" value="printPDF">
            <button type="submit" class="btn print-btn"> Export as PDF</button>
        </form>
    </div>

    <h1>Driver Details</h1>

    <table>
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>License Number</th>
                <th>Contact</th>
                <th>NIC</th>
                <th>Actions</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="d" items="${driverList}">
                <tr>
                    <td>${d.driverId}</td>
                    <td>${d.name}</td>
                    <td>${d.licenseNumber}</td>
                    <td>${d.contact}</td>
                    <td>${d.nic}</td>
                <td>
                        <!-- Edit Button -->
                        <form action="drivers" method="post" style="display:inline;">
                            <input type="hidden" name="action" value="editForm">
                            <input type="hidden" name="driver_id" value="${d.driverId}">
                            <a class="btn edit-btn" href="editDriver.jsp?driver_id=${d.driverId}">Edit</a>
                        </form>
                        
                        <!-- Delete Button -->
                        <form action="drivers" method="post" style="display:inline;" onsubmit="return confirm('Are you sure you want to delete this driver?');">
                            <input type="hidden" name="action" value="delete">
                            <input type="hidden" name="driver_id" value="${d.driverId}">
                            <button class="btn delete-btn" type="submit">Delete</button>
                        </form>
                       
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>

</div>

</body>
</html>
