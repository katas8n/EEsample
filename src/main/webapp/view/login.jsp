<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
</head>
<body>
    <h1>Login</h1>
    <form action="/todo-app/page?page=login" method="post">
        <fieldset>
            <label for="username">Username: </label>
            <input type="text" name="username" id="username" required>
        </fieldset>
        <fieldset>
            <label for="password">Password: </label>
            <input type="password" name="password" id="password" required>
        </fieldset>
        <input type="submit" value="Login">
        <p>Don't have an account? <a href="/todo-app/page?page=registration">Register Page</a></p>
    </form>
</body>
</html>
