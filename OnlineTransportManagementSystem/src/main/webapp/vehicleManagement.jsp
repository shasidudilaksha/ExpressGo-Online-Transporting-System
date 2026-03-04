<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Vehicle Management</title>
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
            background: linear-gradient(145deg, #42a5f5, #478ed1);

        }

        .container {
            display: flex;
            gap: 20px;
        }

        .form-container {
            background: #fff;
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            width: 400px;
            transition: transform 0.3s ease;
        }

        .table-container {
            background: #fff;
            padding: 20px;
            border-radius: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            transition: transform 0.3s ease;
            overflow-y: auto;
            max-height: 70vh;
        }

        table {
            width: 100%;
            border-collapse: collapse;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background: #4caf50;
            color: white;
        }

        h3 {
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }

        input[type="text"], input[type="number"], input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px;
            border-radius: 10px;
            border: 1px solid #ddd;
            transition: all 0.3s ease;
        }

        input[type="submit"] {
            background: #4caf50;
            color: white;
            font-size: 16px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background: #43a047;
        }

        .action-button {
            padding: 5px 10px;
            margin: 2px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .edit {
            background-color: #ffc107;
            color: #fff;
        }

        .delete {
            background-color: #f44336;
            color: #fff;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h3>Vehicle Management</h3>
            <form action="vehicles" method="post">
                <label for="model">Model:</label>
                <input type="text" id="model" name="model" placeholder="Enter vehicle model" required>

                <label for="registrationNumber">Registration Number:</label>
                <input type="text" id="registrationNumber" name="registrationNumber" placeholder="Enter registration number" required>

                <label for="capacity">Capacity:</label>
                <input type="number" id="capacity" name="capacity" placeholder="Enter capacity" required>
                
                
                <label for="date">Date:</label>
                <input type="date" id="date" name="date" placeholder="Enter date" required>
                 
                <input type="submit" value="Add Vehicle">
            </form>
        </div>

        <div class="table-container">
            <h3>Vehicle List</h3>
            <table>
                <tr>
                    <th>Model</th>
                    <th>Registration Number</th>
                    <th>Capacity</th>
                    <th>Date</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="vehicle" items="${vehicleList}">
                    <tr>
                        <td>${vehicle.model}</td>
                        <td>${vehicle.registrationNumber}</td>
                        <td>${vehicle.capacity}</td>
                        <td>${vehicle.date}</td>
                        
                        <td>
                            <form action="editVehicle" method="post" style="display:inline;">
                                <input type="hidden" name="vehicleId" value="${vehicle.id}">
                                <button type="submit" class="action-button edit">Edit</button>
                            </form>
                            <form action="deleteVehicle" method="post" style="display:inline;">
                                <input type="hidden" name="vehicleId" value="${vehicle.id}">
                                <button type="submit" class="action-button delete">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
