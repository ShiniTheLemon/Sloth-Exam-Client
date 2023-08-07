<!DOCTYPE html>
<html>
<head>
    <title>Congratulations!</title>
    <style>
        body {
            background-color: #f0f0f0;
            font-family: Arial, sans-serif;
        }
        .container {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .content {
            background-color: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.3);
            text-align: center;
            max-width: 80%;
        }
        img {
            max-width: 100%;
            margin-bottom: 20px;
        }
        button{
        	background-color: orange;
        }
    </style>
</head>
<body>
    <div class="container">
        <div class="content">
            <img src="/img/congrats.jpg" alt="Congratulations!" />
            <h1>Congratulations!</h1>
            <p>You have successfully completed the exam.</p>
            <a href="/student/user/dashboard"><button >Done</button> </a>
        </div>
    </div>
</body>
</html>