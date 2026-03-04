<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Driver Management - Online Transport System</title>
    <style>
        * {
            box-sizing: border-box;
        }
        body {
            margin: 0;
            height: 100vh;
            background: url('images/img2.jpg') no-repeat center center fixed;
            background-size: cover;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
            color: #333;
            overflow: hidden;
        }

        /* Center container vertically and horizontally */
        .center-wrapper {
            height: 100vh;
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            gap: 30px;
            padding: 20px;
            text-align: center;
            background: rgba(0, 0, 0, 0.25); /* subtle overlay for text visibility */
        }

        h1 {
            color: #fff;
            font-weight: 700;
            font-size: 2.8rem;
            letter-spacing: 1.2px;
            text-shadow: 0 4px 6px rgba(0,0,0,0.6);
            margin: 0;
        }

        .form-container {
            background: #fff;
            border-radius: 16px;
            padding: 30px 40px;
            width: 400px;
            box-shadow:
                0 10px 15px rgba(0,0,0,0.1),
                0 6px 10px rgba(0,0,0,0.1),
                inset 0 -3px 8px rgba(255, 255, 255, 0.7);
            color: #333;
            transition: transform 0.3s ease, box-shadow 0.3s ease;
        }

        .form-container:hover {
            transform: translateY(-8px);
            box-shadow:
                0 15px 25px rgba(0,0,0,0.2),
                0 10px 15px rgba(0,0,0,0.15),
                inset 0 -3px 8px rgba(255, 255, 255, 0.8);
        }

        form {
            display: flex;
            flex-direction: column;
        }

        input[type="number"],
        input[type="text"] {
            padding: 14px 16px;
            margin-bottom: 20px;
            border-radius: 10px;
            border: 2px solid #ddd;
            font-size: 1rem;
            transition: border-color 0.3s ease, box-shadow 0.3s ease;
            box-shadow:
                inset 2px 2px 5px rgba(255, 255, 255, 0.7),
                inset -2px -2px 5px rgba(0, 0, 0, 0.1);
        }

        input[type="number"]:focus,
        input[type="text"]:focus {
            outline: none;
            border-color: #764ba2;
            box-shadow:
                0 0 8px #764ba2,
                inset 2px 2px 5px rgba(255, 255, 255, 0.9),
                inset -2px -2px 5px rgba(0, 0, 0, 0.2);
        }

        input::placeholder {
            color: #999;
            font-weight: 500;
        }

        .btn-add {
            padding: 14px 0;
            background: linear-gradient(145deg, #6a11cb, #2575fc);
            border: none;
            border-radius: 12px;
            color: white;
            font-size: 1.1rem;
            font-weight: 700;
            cursor: pointer;
            box-shadow:
                3px 3px 6px #1e40af,
                -3px -3px 6px #8e56ff;
            transition: background 0.3s ease, box-shadow 0.3s ease, transform 0.2s ease;
        }

        .btn-add:hover {
            background: linear-gradient(145deg, #2575fc, #6a11cb);
            box-shadow:
                5px 5px 10px #1e40af,
                -5px -5px 10px #8e56ff;
            transform: translateY(-3px);
        }

        .btn-add:active {
            transform: translateY(1px);
            box-shadow:
                inset 2px 2px 5px #1e40af,
                inset -2px -2px 5px #8e56ff;
        }

        /* Responsive */
        @media(max-width: 480px) {
            .form-container {
                width: 90%;
                padding: 25px 20px;
            }

            h1 {
                font-size: 2rem;
            }
        }
    </style>
</head>
<body>

<div class="center-wrapper">
    <h1>Driver Management - Online Transport System</h1>

    <div class="form-container">
        <form action="drivers" method="post">
            <input type="hidden" name="action" value="add">
            <input type="number" name="driver_id" placeholder="Driver ID" required min="1" step="1">
            <input type="text" name="name" placeholder="Name" required>
            <input type="text" name="license_number" placeholder="License Number" required>
            <input type="text" name="contact" placeholder="Contact" required>
            <input type="text" name="nic" placeholder="NIC" required>
            <input type="submit" class="btn-add" value="Add Driver">
        </form>
    </div>
</div>

</body>
</html>
