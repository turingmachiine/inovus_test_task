<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <script
            src="https://code.jquery.com/jquery-3.6.0.min.js"
            integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
            crossorigin="anonymous"></script>
</head>
<body>
<div id="content">
    <ol>
    <#list cats as cat>
        <li>${cat.name} - ${cat.score}</li>
        <img src="cats${cat.image}">
    </#list>
    </ol>
</div>
</body>
</html>