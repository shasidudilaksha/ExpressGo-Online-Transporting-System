<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Route Management</title>
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

        .form-container, .table-container {
            background: #fff;
            padding: 30px;
            border-radius: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            transition: transform 0.3s ease;
        }

        h3 {
            margin-bottom: 20px;
            color: #333;
            text-align: center;
        }

        .form-group {
            margin: 15px 0;
        }

        .form-group input[type="text"], 
        .form-group input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
            border: 2px solid #ddd;
            border-radius: 30px;
            outline: none;
            transition: all 0.3s ease;
            box-shadow: inset 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .form-group input:focus {
            border-color: #42a5f5;
            box-shadow: inset 0 6px 8px rgba(0, 0, 0, 0.2);
        }

        .submit-btn {
            width: 100%;
            padding: 12px;
            margin: 10px 0;
            background: #42a5f5;
            color: #fff;
            border: none;
            border-radius: 30px;
            cursor: pointer;
            transition: background 0.3s ease;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
        }

        .submit-btn:hover {
            background: #478ed1;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 10px;
        }

        th, td {
            padding: 10px;
            text-align: left;
            border: 1px solid #ddd;
        }

        th {
            background: #42a5f5;
            color: #fff;
        }

        .action-btn {
            margin: 2px;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
            background-color: #ff9800;
            color: white;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h3>Route Management</h3>
            <form action="routes" method="post">
            <div class="form-group">
                    <label for="id">Route ID:</label>
                    <input type="text" name="id" id="id" placeholder="Enter route ID" required>
                </div>
                <div class="form-group">
                    <label for="startPoint">Start Point:</label>
                    <input type="text" name="startPoint" id="startPoint" placeholder="Enter start point" required>
                </div>
                <div class="form-group">
                    <label for="endPoint">End Point:</label>
                    <input type="text" name="endPoint" id="endPoint" placeholder="Enter end point" required>
                </div>
                <div class="form-group">
                    <label for="distance">Distance (km):</label>
                    <input type="number" name="distance" id="distance" placeholder="Enter distance" required min="1">
                </div>
                  <div class="form-group">
                    <label for="date">Date:</label>
                    <input type="date" name="date" id="date" placeholder="Enter date" required min="1">
                </div>
                <button type="submit" class="submit-btn">Add Route</button>
            </form>
        </div>

        <div class="table-container">
            <h3>Route List</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Start Point</th>
                    <th>End Point</th>
                    <th>Distance</th>
                    <th>Date</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="route" items="${routeList}">
                    <tr>
                        <td>${route.id}</td>
                        <td>${route.startPoint}</td>
                        <td>${route.endPoint}</td>
                        <td>${route.distance}</td>
                        <td>${route.date}</td>
                        <td>
                            <form action="editRoute" method="post" style="display:inline;">
                                <input type="hidden" name="routeId" value="${route.id}">
                                <button type="submit" class="action-btn">Edit</button>
                            </form>
                            <form action="deleteRoute" method="post" style="display:inline;">
                                <input type="hidden" name="routeId" value="${route.id}">
                                <button type="submit" class="action-btn">Delete</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>
</html>
