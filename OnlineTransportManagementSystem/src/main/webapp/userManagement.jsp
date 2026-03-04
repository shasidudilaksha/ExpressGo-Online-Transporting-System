<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>User Management</title>
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
            background: linear-gradient(145deg, #4caf50, #66bb6a);
        }

        .main-container {
            display: flex;
            gap: 20px;
        }

        .form-container, .table-container {
            background: #fff;
            padding: 20px;
            border-radius: 20px;
            box-shadow: 0 8px 16px rgba(0, 0, 0, 0.3);
            transition: transform 0.3s ease;
        }

        .form-container:hover, .table-container:hover {
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

        input[type="text"], input[type="password"], input[type="submit"], input[type="number"] {
            width: 100%;
            padding: 10px;
            margin: 8px 0 15px;
            border-radius: 10px;
            border: 1px solid #ddd;
            transition: all 0.3s ease;
        }

        input[type="text"]:focus, input[type="password"]:focus {
            border-color: #4caf50;
            box-shadow: 0 4px 8px rgba(76, 175, 80, 0.3);
        }

        input[type="submit"], button {
            background: #4caf50;
            color: #fff;
            font-size: 16px;
            cursor: pointer;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.2);
            transition: all 0.3s ease;
        }

        input[type="submit"]:hover, button:hover {
            background: #43a047;
            transform: translateY(-3px);
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
            background-color: #4caf50;
            color: #fff;
        }

        .action-btn {
            margin: 2px;
            padding: 5px 10px;
            border-radius: 5px;
            cursor: pointer;
        }

        .edit-btn {
            background-color: #ff9800;
            color: white;
        }

        .delete-btn {
            background-color: #f44336;
            color: white;
        }

        .message {
            text-align: center;
            margin-bottom: 20px;
            padding: 10px;
            border-radius: 5px;
            color: white;
        }

        .success {
            background-color: #4caf50;
        }

        .error {
            background-color: #f44336;
        }
    </style>
</head>

<body>
    <div class="main-container">
        <!-- User Management Form -->
        <div class="form-container">
            <h3>User Management</h3>

            <!-- Success/Error Message -->
            <c:if test="${not empty message}">
                <div class="message ${messageType}">
                    ${message}
                </div>
            </c:if>

            <form action="users" method="post">
                <label for="userId">User ID (for update):</label>
                <input type="number" id="userId" name="userId" placeholder="Leave empty to add new">

                <label for="username">Username:</label>
                <input type="text" id="username" name="username" placeholder="Enter username" required>

                <label for="role">Role:</label>
                <input type="text" id="role" name="role" placeholder="Enter role" required>

                <label for="date">Date:</label>
                <input type="date" id="date" name="date" placeholder="Enter date" required>

                <input type="submit" value="Save">
            </form>
        </div>

        <!-- User List Table -->
        <div class="table-container">
            <h3>User List</h3>
            <table>
                <tr>
                    <th>ID</th>
                    <th>Username</th>
                    <th>Role</th>
                    <th>Date</th>
                    <th>Actions</th>
                </tr>
                <c:forEach var="user" items="${userList}">
                    <tr>
                        <td>${user.userId}</td>
                        <td>${user.username}</td>
                        <td>${user.role}</td>
                        <td>${user.date}</td>
                        <td>
                            <form action="users" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="delete">
                                <input type="hidden" name="userId" value="${user.userId}">
                                <button class="action-btn delete-btn" type="submit">Delete</button>
                            </form>
                            <form action="users" method="post" style="display:inline;">
                                <input type="hidden" name="action" value="edit">
                                <input type="hidden" name="userId" value="${user.userId}">
                                <button class="action-btn edit-btn" type="submit">Edit</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </div>
    </div>
</body>

</html>

